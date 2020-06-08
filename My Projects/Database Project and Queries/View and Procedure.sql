/*
 * Created by: Anthony Vierra
 * CS 431: Database Architecture
 */

-- Question 1.
CREATE VIEW movies_legendary_technicians AS
SELECT DISTINCT m.title, CONCAT(first_name, ' ', last_name) AS full_name, 2020 - EXTRACT(YEAR FROM birth_date) AS age
FROM movies m
JOIN movie_cast mc ON mc.movie_id = m.movie_id
JOIN artists a ON a.artist_id = mc.person_id
WHERE 2020 - EXTRACT(YEAR FROM birth_date) > 40
ORDER BY age ASC;

-- A select statement that can be executed as soon as the above view statement is ran to make sure
-- everything is correct.
SELECT * FROM movies_legendary_technicians;

/*
 * Question 2
 * Procedure
 */
USE assign1_movie_database;
DROP PROCEDURE IF EXISTS test;

-- Chane the delimiter.
DELIMITER //

CREATE PROCEDURE test()
BEGIN
	-- Begin the procedure.
	DECLARE main_string		VARCHAR(999) DEFAULT "";
	DECLARE holder_string	VARCHAR(500);
	DECLARE counter			INT DEFAULT 0;
	DECLARE row_not_found	TINYINT DEFAULT FALSE;
	DECLARE temp1			VARCHAR(99);
	DECLARE temp2			VARCHAR(99);
	DECLARE temp3			VARCHAR(99);

	-- Declaring the cursor that will operate on a select statement.
	DECLARE my_cursor CURSOR FOR
	SELECT CONCAT("'", title, "'") AS title,
	CONCAT("'", distributor, "'") AS "Distributor",
	CONCAT("'", EXTRACT(YEAR FROM release_date), "'") AS release_year
	FROM movies
	WHERE gross > 2
	ORDER BY title;

	DECLARE CONTINUE HANDLER FOR NOT FOUND
		SET row_not_found = TRUE;
	
	-- Open the cursor.
	OPEN my_cursor;

	-- Declare a while loop to loop through.
	WHILE row_not_found = FALSE DO
		-- Fetching the row one by one.
		FETCH my_cursor INTO temp1, temp2, temp3;
		
		-- String work.
		SET holder_string = CONCAT(main_string, temp1, ",", temp2, ",", temp3);
		SET main_string = CONCAT(holder_string, "|");
		
	END WHILE;

	-- Close the cursor.
	CLOSE my_cursor;
	
	-- Display at the very end the main string.
	SELECT main_string;

END//

-- Changing the delimiter back to the normal semi-colon ;
DELIMITER ;

CALL test();




