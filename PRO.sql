CREATE OR REPLACE PROCEDURE allstudent (
    s_allstudent   OUT student%rowtype
)
    IS
BEGIN     
--select * into S_AllStudent  from Student where Student.ID='19991'; this is for test

    SELECT
        *
    INTO
        s_allstudent
    FROM
        student;

EXCEPTION
    WHEN others THEN
        dbms_output.put_line(sqlerrm);
END;
--exec AllStudent();
/*
DECLARE
    s_allstudent   student%rowtype;
BEGIN
    allstudent(s_allstudent);
   --select * into S_AllStudent  from Student where Student.ID='00128';

    dbms_output.put_line(s_allstudent.name); -- it should put id in procedure if you want to use this way

END;
*/
/*
P2
*/

CREATE OR REPLACE PROCEDURE allcourse (
    c_allcourse   OUT course%rowtype
)
    IS
BEGIN     

--select * into C_AllCourse from COURSE where COURSE_ID='BIO-101';--COURSE_ID

    SELECT
        *
    INTO
        c_allcourse
    FROM
        course;--COURSE_ID

EXCEPTION
    WHEN others THEN
        dbms_output.put_line(sqlerrm);
END;
---testAllCourse
/*
DECLARE
    c_allcourse   course%rowtype;
BEGIN
    allcourse(c_allcourse);
    dbms_output.put_line(c_allcourse.title);
END;
*/
/*

p3
*/

CREATE OR REPLACE PROCEDURE allcourse_credit (
    c_course   OUT SYS_REFCURSOR
)
    IS
BEGIN
    OPEN c_course FOR
        SELECT
            credits
       
        FROM
            course;--COURSE_ID

END;
--Test one

DECLARE
    CURSOR c_course IS
        SELECT
            credits
        FROM
            course;

    c_course_credits   course.credits%type;
BEGIN
    OPEN c_course;
    LOOP
        FETCH c_course INTO c_course_credits;
        EXIT WHEN
            c_course%notfound;
        dbms_output.put_line('Employee Name: ' || c_course_credits);
        dbms_output.put_line('*************************************');
    END LOOP;

    CLOSE c_course;
END;



/*
p3
Display the information about Course Takes from the takes table
*/
/*
DECLARE BEGIN-- just run  select statment
    SELECT
        title
    FROM
        course c,
        takes t
    WHERE
        c.course_id = t.course_id;

END;
*/
CREATE OR REPLACE PROCEDURE tcourse_eq_ttakes (
    c_course   OUT SYS_REFCURSOR
)
    IS
BEGIN
    OPEN c_course FOR
        SELECT
            title
        FROM
            course c,
            takes t
        WHERE
            c.course_id = t.course_id;

END;

/*
p4
Displaying Student name and ID along with the courses that they have taken.
*/

CREATE OR REPLACE PROCEDURE Student_name_and_ID (
    c_course   OUT SYS_REFCURSOR
)
    IS
BEGIN
    OPEN c_course FOR
        SELECT
        s.id,
        s.name
    FROM
        course c,
        takes t,
        student s
    WHERE
        c.course_id = t.course_id
    AND
        s.id = t.id;
END;


/*
DECLARE BEGIN-- just run  select statment
    SELECT
        s.id,
        s.name
    FROM
        course c,
        takes t,
        student s
    WHERE
        c.course_id = t.course_id
    AND
        s.id = t.id;

END;
*/
/*
P5 :
Display number of students enrolled in each course section
*/
CREATE OR REPLACE PROCEDURE count_and_Title_of_course (
    count_and_Title_of_course   OUT SYS_REFCURSOR
)
    IS
BEGIN
    OPEN count_and_Title_of_course FOR
           -- SELECT  DisTINCT c.TITLE,(select count(t.id)from takes t where t.course_id = c.course_id)   FROM course c, takes t WHERE c.course_id = t.course_id  ;
select c.title, count(t.id)
  from takes t , course c 
  where t.course_id=c.course_id
  group by c.title;

END;

/*
DECLARE BEGIN-- just run  select statment
select c.title, count(t.id)
  from takes t , course c 
  where t.course_id=c.course_id
  group by c.title;--SELECT distincit c.TITLE,count(s.id) FROM course c, takes t WHERE c.course_id = t.course_id;

END;
*/
/*
P6:
Register a new Student.*/


CREATE OR REPLACE PROCEDURE Insert_Student (
    ID   in Student.ID%type,
        Name   in Student.Name%type,
        DEPT_Name   in Student.DEPT_Name%type,
        TOT_CRED   in Student.TOT_CRED%type
)
    IS
BEGIN
INSERT INTO Student (ID, Name, DEPT_Name, TOT_CRED)
VALUES (ID, Name, DEPT_Name, TOT_CRED);
End;
/*
DECLARE BEGIN
Insert_Student('10104','Smith2','Comp. Sci.', 10);
/*
INSERT INTO Student (ID, Name, DEPT_Name, TOT_CRED)
VALUES ('10101', 'Smith', 'Comp. Sci.', 10);

*/

END;

CREATE OR REPLACE PROCEDURE allstudent2 (
    allstudent2   OUT SYS_REFCURSOR
)
    IS
BEGIN     
--select * into S_AllStudent  from Student where Student.ID='19991'; this is for test
OPEN  allstudent2 for
    SELECT
        *
   
    FROM
        student;

EXCEPTION
    WHEN others THEN
        dbms_output.put_line(sqlerrm);
END;


/*
*/
CREATE OR REPLACE PROCEDURE allcourse2 (
    allcourse2   OUT SYS_REFCURSOR
)
    IS
BEGIN     

--select * into C_AllCourse from COURSE where COURSE_ID='BIO-101';--COURSE_ID
OPEN allcourse2 for
    SELECT
        *
   
    FROM
        course;--COURSE_ID

EXCEPTION
    WHEN others THEN
        dbms_output.put_line(sqlerrm);
END;