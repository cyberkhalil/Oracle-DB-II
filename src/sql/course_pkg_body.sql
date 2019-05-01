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