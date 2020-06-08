; Created by: Anthony Vierra

; Question number 1
(define (binomial N K) (if (equal? K 0) 1 (if (equal? N K) 1 (+ (binomial (- N 1) K) 
	(binomial (- N 1) (- K 1))))))

(binomial 4 0)
(binomial 8 8)
(binomial 3 2)

; Comments: This function will take two inputs and return a recursive number that is
; based on our multiple function calls.

; Question number 2
(define (mod N M) (if (< N M) N (if (equal? N 0) 0 (mod (- N M) M))))

(mod 14 6)

; This function also works recursively, simply subracting the numerator from the denominator
; and using that as our function argument along with M. This should get us the modulus
; everytime using recursion.

; Question number 3
(define (binaryToDecimal b)
(if (= b 0)
0
(+ (mod b 10) (* 2 (binaryToDecimal (/ b 10))))))

(binaryToDecimal 1111)

; This function will take an input into binaryToDecimal such as 1010 and output its
; decimal equivalent.

; Question number 4
(define (addBinary lst)
  (if (null? lst) 0)
  (+ (binaryToDecimal (car lst)) (addBinary (cdr lst))))

(addBinary '(1010 100))

; This function will use the binaryToDecimal function in the previous question, then
; it will add everything up and give the result.

; Question number 5
(define (min lst) (minHelper (cdr lst) (car lst)))
(define (minHelper lst currentMin) (if (null? lst) currentMin 

(if (< (car lst) currentMin) (minHelper (cdr lst) (car lst)) 

(minHelper (cdr lst) currentMin))))

(min '(56 7 23 45))

; This function will accept a list and recursively call the list one by one, by using 
; the cdr and car function by determining if one is larger than the other.

; Question number 6
(define (myRemove num lst)
  (if (null? lst) '() (if (equal? num (car lst)) (myRemove num (cdr lst)) 
  	(cons (car lst) (myRemove num (cdr lst))))))

(myRemove 4 '(34 56 4 8 7))

; This function will examine always the car of the list to see if its going to match
; up with the num that is provided. It will compare, and if its not equal then I will
; cons it and recursively call to compare other values in the list.

; Question number 7
(define (selectionSort lst) (if (null? lst) '() 
	(cons (min lst) (selectionSort (myRemove (min lst) lst)))))

(display (selectionSort '(45 23 40 99 145 12 6)))

; The only way i could see doing this was using my other functions that I did previously
; To find both the min in certain situations and to using the myremove.













