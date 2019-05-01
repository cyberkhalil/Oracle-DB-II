CREATE OR REPLACE PACKAGE Course_pkg IS
    PROCEDURE setTitle (
        Title   VARCHAR2
    );
    
    PROCEDURE setDepartmentName(
        departmentName   VARCHAR2
    );
    
    PROCEDURE setCredits(
        Credits   Number
    );
END;
/*

Body


*/

create or replace package body all_course
is

PROCEDURE setTitle (Titl VARCHAR2)
AS LANGUAGE JAVA
NAME 'Course.setTitle(java.lang.String)';


PROCEDURE setDepartmentName (departmentName VARCHAR2)
AS LANGUAGE JAVA
NAME 'Course.setDepartmentName(java.lang.String)';


PROCEDURE setCredits(credits Number) AS LANGUAGE JAVA
Name 'Student.setCredits';

End;