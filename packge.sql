CREATE OR REPLACE PACKAGE university IS
 PROCEDURE allstudent (
    allstudent   OUT SYS_REFCURSOR
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

PROCEDURE allcourse (
    allcourse   OUT SYS_REFCURSOR
);
END;





--
/*
body;
*/



