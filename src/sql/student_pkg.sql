CREATE OR REPLACE PACKAGE student_pkg IS
-- TODO 6 add function like constrator return the student record from student table
-- TODO 7 add deleteStudent procedure
    PROCEDURE setname (
        ids      IN       student.id%TYPE,
        s_name   IN       student.name%TYPE
    );

    PROCEDURE setdept_name (
        ids           IN            student.id%TYPE,
        s_dept_name   IN            student.dept_name%TYPE
    );

    PROCEDURE settotalcerdit (
        ids             IN              student.id%TYPE,
        s_totalcerdit   IN              student.tot_cred%TYPE
    );

END;