CREATE OR REPLACE PACKAGE BODY department_pkg IS

  PROCEDURE get_dept_name (
        c_course OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN c_course FOR SELECT
                              dept_name
                          FROM
                              department;

    END;

End;