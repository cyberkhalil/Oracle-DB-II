CREATE OR REPLACE PACKAGE student_pkg IS
    PROCEDURE setName (
        name   VARCHAR2
    );
    
    PROCEDURE setDepartmentName(
        departmentName   VARCHAR2
    );
    
    PROCEDURE setTotalCerdit(
        totalCerdit   Number
    );
END;

create or replace package body student_pkg
is
PROCEDURE setName(name varchar2) AS LANGUAGE JAVA
NAME 'Student.setName(java.lang.String) ';
End;
/*
PROCEDURE setDepartmentName(departmentName varchar2) AS LANGUAGE JAVA
NAME 'Student.setDepartmentName';

PROCEDURE setTotalCerdit(totalCerdit Number) AS LANGUAGE JAVA
Name 'Student.setTotalCerdit';
*/
