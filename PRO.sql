CREATE OR REPLACE PROCEDURE allstudent (
    s_allstudent OUT student%rowtype
) IS
BEGIN     
--select * into S_AllStudent  from Student where Student.ID='19991'; this is for test
    SELECT
        *
    INTO s_allstudent
    FROM
        student
    WHERE
        student.id = '19991';

EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line(sqlerrm);
END;
--exec AllStudent();

DECLARE
    s_allstudent student%rowtype;
BEGIN
    allstudent(s_allstudent);
   --select * into S_AllStudent  from Student where Student.ID='00128';
    dbms_output.put_line(s_allstudent.name); -- it should put id in procedure if you want to use this way
END;

/*
P2
*/

CREATE OR REPLACE PROCEDURE allcourse (
    c_allcourse OUT course%rowtype
) IS
BEGIN     
--select * into S_AllStudent  from Student where Student.ID='19991'; this is for test
--select * into C_AllCourse from COURSE where COURSE_ID='BIO-101';--COURSE_ID
    SELECT
        *
    INTO c_allcourse
    FROM
        course;--COURSE_ID

EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line(sqlerrm);
END;
---testAllCourse

DECLARE
    c_allcourse course%rowtype;
BEGIN
    allcourse(c_allcourse);
   --select * into S_AllStudent  from Student where Student.ID='00128';
    dbms_output.put_line(c_allcourse.title);
END;

/*

p3
*/

CREATE OR REPLACE PROCEDURE allcourse_credit (
    c_course OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN c_course FOR SELECT
                          credits
                      INTO c_allcourse
                      FROM
                          course;--COURSE_ID

EXCEPTION
    WHEN OTHERS THEN
        dbms_output.put_line(sqlerrm);
END;
--Test one

DECLARE
    CURSOR c_course IS
    SELECT
        credits
    FROM
        course;

    c_course_credits course.credits%TYPE;
BEGIN
    OPEN c_course;
    LOOP
        FETCH c_course INTO c_course_credits;
        EXIT WHEN c_course%notfound;
        dbms_output.put_line('Employee Name: ' || c_course_credits);
        dbms_output.put_line('*************************************');
    END LOOP;

    CLOSE c_course;
END;
--Test two

DECLARE
    TYPE c_course IS REF CURSOR;
    c_course_credits course.credits%TYPE;
BEGIN
    allcourse_credit(c_course);
    LOOP
        FETCH c_emp INTO v_record;
        dbms_output.put_line(v_record.last_name);
        EXIT WHEN c_emp%notfound;
    END LOOP;

END;