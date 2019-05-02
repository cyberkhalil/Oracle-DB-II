CREATE OR REPLACE PACKAGE student_pkg IS
    PROCEDURE set_name (
        ids      IN       student.id%TYPE,
        s_name   IN       student.name%TYPE
    );

    PROCEDURE set_department_name (
        ids           IN            student.id%TYPE,
        s_dept_name   IN            student.dept_name%TYPE
    );

    PROCEDURE set_total_cerdit (
        ids             IN              student.id%TYPE,
        s_totalcerdit   IN              student.tot_cred%TYPE
    );

    PROCEDURE register_student (
        id          IN          student.id%TYPE,
        name        IN          student.name%TYPE,
        dept_name   IN          student.dept_name%TYPE,
        tot_cred    IN          student.tot_cred%TYPE
    );

    PROCEDURE get_all_students (
        allstudent OUT SYS_REFCURSOR
    );

    PROCEDURE get_student_courses (
        c_course   OUT        SYS_REFCURSOR,
        s_id       IN         student.id%TYPE
    );

    PROCEDURE delete_student (
        s_id   IN     student.id%TYPE
    );

    PROCEDURE get_student_by_id (
        c_course   OUT        SYS_REFCURSOR,
        s_id       IN         student.id%TYPE
    );

END;