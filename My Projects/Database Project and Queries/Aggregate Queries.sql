/*
Created by: Anthony Vierra
CS 431: Database Architecture.
*/

-- Question 1
SELECT 
    category_name AS Name, COUNT(instrument_id), MAX(list_price)
FROM
    categories,
    instruments
WHERE
    categories.category_id = instruments.category_id
GROUP BY category_name
ORDER BY COUNT(categories.category_id) DESC;

-- Question 2
SELECT 
    m.email_address AS Email,
    SUM(oi.item_price * oi.quantity) AS "Item Price Total",
    SUM(oi.discount_amount * quantity) AS "Discount amount Total"
FROM
    musicians m,
    order_instruments oi,
    orders o
WHERE
    m.musician_id = o.musician_id
        AND o.order_id = oi.order_id
GROUP BY m.email_address
ORDER BY SUM(oi.item_price * oi.quantity) DESC;

-- Question 3
SELECT 
    musicians.email_address AS Email,
    COUNT(orders.order_id) AS Count,
    SUM(order_instruments.quantity * (order_instruments.item_price - order_instruments.discount_amount)) AS total_amount
FROM
    musicians
        JOIN
    orders ON orders.musician_id = musicians.musician_id
        JOIN
    order_instruments ON order_instruments.order_id = orders.order_id
GROUP BY musicians.email_address
HAVING COUNT(DISTINCT orders.order_id) > 1
ORDER BY total_amount DESC;

-- Question 4
SELECT 
    musicians.email_address AS Email,
    COUNT(orders.order_id) AS Count,
    SUM(order_instruments.quantity * (order_instruments.item_price - order_instruments.discount_amount)) AS total_amount
FROM
    musicians
        JOIN
    orders ON orders.musician_id = musicians.musician_id
        JOIN
    order_instruments ON order_instruments.order_id = orders.order_id
WHERE
    order_instruments.item_price > 400
GROUP BY musicians.email_address
HAVING COUNT(orders.order_id) > 1
ORDER BY total_amount DESC;

-- Question 5
SELECT 
    instrument_name,
    SUM(quantity * (item_price - discount_amount)) AS total_amount
FROM
    instruments i
        JOIN
    order_instruments oi ON i.instrument_id = oi.instrument_id
GROUP BY i.instrument_name WITH ROLLUP;

-- Question 6
SELECT 
    email_address, COUNT(DISTINCT oi.instrument_id) AS "Number of instruments"
FROM
    musicians m
        JOIN
    orders o ON m.musician_id = o.musician_id
        JOIN
    order_instruments oi ON oi.order_id = o.order_id
GROUP BY email_address
HAVING COUNT(oi.instrument_id) > 1
ORDER BY email_address;

-- Question 7
SELECT 
    IF(GROUPING(c.category_name) = 1,
        'Grand Total',
        c.category_name) AS category_name,
    IF(GROUPING(i.instrument_name) = 1,
        'Category Total',
        i.instrument_name) AS instrument_name,
    SUM(quantity) AS Quantity
FROM
    categories c
        JOIN
    instruments i ON i.category_id = c.category_id
        JOIN
    order_instruments oi ON oi.instrument_id = i.instrument_id
GROUP BY category_name , instrument_name WITH ROLLUP;

-- Question 8
SELECT order_id,
(item_price - discount_amount) * quantity AS item_total,
SUM((item_price - discount_amount) * quantity) OVER(PARTITION BY order_id) AS order_total
FROM order_instruments
ORDER BY order_id ASC;

-- Question 9
SELECT 
    order_id,
    ((item_price - discount_amount) * quantity) AS total_amount,
	SUM((item_price - discount_amount) * quantity) OVER(window_name
    ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS order_amount,
    ROUND(AVG((item_price - discount_amount) * quantity) OVER(window_name), 2) AS Average_total
FROM order_instruments
WINDOW window_name AS (PARTITION BY order_id) 
ORDER BY order_id, order_amount ASC;

-- Question 10
SELECT o.musician_id,
o.order_date,
(oi.item_price - oi.discount_amount) * oi.quantity AS total_amount,
SUM((oi.item_price - oi.discount_amount) * oi.quantity) OVER(PARTITION BY o.musician_id) as total_for_musician,
SUM((oi.item_price - oi.discount_amount) * oi.quantity) OVER(PARTITION BY o.order_date
RANGE BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS total_by_date
FROM orders o
JOIN order_instruments oi ON oi.order_id = o.order_id 
WHERE o.order_id = oi.order_id
ORDER BY o.musician_id;










