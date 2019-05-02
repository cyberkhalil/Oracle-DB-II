
CREATE OR REPLACE PACKAGE  department_pkg IS


PROCEDURE Get_Dept_Name (
    c_course   OUT SYS_REFCURSOR
);


End;