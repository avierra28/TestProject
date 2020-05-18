/*
Created by: Anthony Vierra
*/

DROP DATABASE IF EXISTS univ_db;
CREATE DATABASE univ_db;
USE univ_db;

/*
 * The department table.
 * department_num_major is its primary key.
 * In which the student and professor tables use this as their foreign key.
 */
CREATE TABLE department (
	department_num_major INT 	PRIMARY KEY 	AUTO_INCREMENT,
	department_name 	 VARCHAR(30)
);

/*
 * The Student table.
 * student_id being the primary key and it being auto_incremented. And the first/last name and department # having not null
 * as per the instructions
 */
CREATE TABLE student (
	
	student_id 	INT		PRIMARY KEY		AUTO_INCREMENT,
	department_num_major INT	NOT NULL,
	first_name 	VARCHAR(30) NOT NULL,
	last_name 	VARCHAR(30) NOT NULL,
	address 	VARCHAR(60),
	year_admitted INT(4),
	birthday 	DATE,
	
	-- Constraint for the foreign key.
	CONSTRAINT student_foreign_key
	FOREIGN KEY (department_num_major)
	REFERENCES department (department_num_major)
);

/*
 * The professor table
 * I left only the professor_id and the first and last name as being not null as there were no other
 * instructions for this table.
 */
CREATE TABLE professor (
	professor_id 	INT 	PRIMARY KEY 	AUTO_INCREMENT,
	department_num_major	INT	NOT NULL,
	first_name 		VARCHAR(30) NOT NULL,
	last_name 		VARCHAR(30) NOT NULL,
	office_number 	INT(8),
	start_time 		TIME,
	duration 		TIME,
	
	-- Constraint for the foreign key.
	CONSTRAINT professor_foreign_key
	FOREIGN KEY (department_num_major)
	REFERENCES department (department_num_major)
);

/*
 * The courses table.
 * No other special instruction for this table.
 */
CREATE TABLE courses (
	course_number INT 	PRIMARY KEY 	AUTO_INCREMENT,
	course_name	  VARCHAR(30)
);

/*
 * The classes table.
 * Allowing all columns except the primary key to be null as there are no other special instructions
 * for them that they cant be null.
 */
CREATE TABLE classes (
	course_number 	INT 	NOT NULL,
	class_section 	INT(6)	NOT NULL,
	semester 		VARCHAR(10),
	course_year 	INT(4),
	professor 		VARCHAR(30),
	day_of_week 	VARCHAR(10),
	duration 		INT(2),
	class_hours 	TIME,
	
	CONSTRAINT classes_key
	PRIMARY KEY (course_number, class_section)
);

/*
 * The enrollment table.
 * This table holds two foreign keys the course number from the courses table
 * and the student_id from the students table.
 */
CREATE TABLE enrollment (
	course_number 	INT		NOT NULL,
	student_id 		INT		NOT NULL,
	semester	VARCHAR(10),
	class_section INT(3)	NOT NULL,
	
	-- Constraints for the foreign keys.
	CONSTRAINT course_foreign_keys
	FOREIGN KEY (course_number)
	REFERENCES courses (course_number),
	
	CONSTRAINT student_foreign_keys
	FOREIGN KEY (student_id)
	REFERENCES student (student_id)
	
);


/*
 * The final_grade table
 * This table just like the one above (the enrollment table) is holding two foreign keys.
 * Then 3 more columns that are defined below.
 */
CREATE TABLE final_grade (
	course_number 	INT		NOT NULL,
	student_id 		INT		NOT NULL,
	semester	VARCHAR(10),
	grade_year	INT(4),
	grade		CHAR(1),
	class_section INT(3)	NOT NULL,
	
	-- Constraints for the foreign keys.
	CONSTRAINT finalgrade1_foreign_keys
	FOREIGN KEY (course_number)
	REFERENCES courses (course_number),
	
	CONSTRAINT finalgrade2_foreign_keys
	FOREIGN KEY (student_id)
	REFERENCES student (student_id)

);








