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
        student
   ;

EXCEPTION
    WHEN others THEN
        dbms_output.put_line(sqlerrm);
END;
--exec AllStudent();

DECLARE
    s_allstudent   student%rowtype;
BEGIN
    allstudent(s_allstudent);
   --select * into S_AllStudent  from Student where Student.ID='00128';

    dbms_output.put_line(s_allstudent.name); -- it should put id in procedure if you want to use this way

END;

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

DECLARE
    c_allcourse   course%rowtype;
BEGIN
    allcourse(c_allcourse);

    dbms_output.put_line(c_allcourse.title);
END;

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
        INTO
            c_allcourse
        FROM
            course;--COURSE_ID

EXCEPTION
    WHEN others THEN
        dbms_output.put_line(sqlerrm);
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

Declare 
Begin
select Title from Course c,takes t where  c.Course_id= t.Course_id;
End;


CREATE OR REPLACE PROCEDURE TCourse_eq_Ttakes (
    c_course   OUT SYS_REFCURSOR
)
    IS
BEGIN
open c_course  for select Title from Course c,takes t where  c.Course_id= t.Course_id;

End;

/*
p4
Displaying Student name and ID along with the courses that they have taken.
*/
Declare 
Begin
select S.ID ,S.Name from Course c,takes t ,Student S where  c.Course_id= t.Course_id and S.ID=t.ID;
End;

CREATE OR REPLACE PROCEDURE Student_name_and_ID (
    Student_name_and_ID   OUT SYS_REFCURSOR
)
    IS
BEGIN
open Student_name_and_ID  for select S.ID ,S.Name from Course c,takes t ,Student S where  c.Course_id= t.Course_id and S.ID=t.ID;
End;