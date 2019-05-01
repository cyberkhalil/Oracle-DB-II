create or replace package body student_pkg
is
PROCEDURE setName(name varchar2) AS LANGUAGE JAVA
NAME 'Student.setName';

PROCEDURE setDepartmentName(departmentName varchar2) AS LANGUAGE JAVA
NAME 'Student.setDepartmentName';

PROCEDURE setTotalCerdit(totalCerdit Number) AS LANGUAGE JAVA
Name 'Student.setTotalCerdit';

End;
