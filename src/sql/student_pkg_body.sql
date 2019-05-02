CREATE OR REPLACE PACKAGE BODY student_pkg IS

    PROCEDURE setname (
        ids      IN       student.id%TYPE,
        s_name   IN       student.name%TYPE
    ) IS
    BEGIN
        UPDATE student
        SET
            name = s_name
        WHERE
            id = ids;

    END;

    PROCEDURE setdept_name (
        ids           IN            student.id%TYPE,
        s_dept_name   IN            student.dept_name%TYPE
    ) IS
    BEGIN
        UPDATE student
        SET
            dept_name = s_dept_name
        WHERE
            id = ids;

    END;

    PROCEDURE settotalcerdit (
        ids             IN              student.id%TYPE,
        s_totalcerdit   IN              student.tot_cred%TYPE
    ) IS
    BEGIN
        UPDATE student
        SET
            tot_cred = s_totalcerdit
        WHERE
            id = ids;

    END;

END;