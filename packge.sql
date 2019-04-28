create or replace package all_course
is
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

PROCEDURE Student_name_and_ID (
    c_course   OUT SYS_REFCURSOR
);
PROCEDURE count_and_Title_of_course (
    count_and_Title_of_course   OUT SYS_REFCURSOR
);
ROCEDURE Insert_Student (
    ID   in Student.ID%type,
        Name   in Student.Name%type,
        DEPT_Name   in Student.DEPT_Name%type,
        TOT_CRED   in Student.TOT_CRED%type
);
End;


--
/*
body;
*/
