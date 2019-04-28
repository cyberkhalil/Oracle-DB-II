CREATE OR REPLACE PACKAGE all_course IS
    PROCEDURE allstudent (
        s_allstudent   OUT student%rowtype
    );
/*
p2
*/
    PROCEDURE allcourse (
        c_allcourse   OUT course%rowtype
    );
    PROCEDURE allcourse_credit (
        c_course   OUT SYS_REFCURSOR
    );
/*

*/
    PROCEDURE tcourse_eq_ttakes (
        c_course   OUT SYS_REFCURSOR
    );
    PROCEDURE student_name_and_id (
        c_course   OUT SYS_REFCURSOR
    );
    PROCEDURE count_and_title_of_course (
        count_and_title_of_course   OUT SYS_REFCURSOR
    );
    PROCEDURE insert_student(
        id IN student.id%type,
        name IN student.name%type,
        dept_name IN student.dept_name%type,
        tot_cred IN student.TOT_CRED%type
    );

END;

--
/*
body;
*/