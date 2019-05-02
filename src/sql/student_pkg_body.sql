CREATE OR REPLACE PACKAGE BODY student_pkg IS
        
        /* set_name */

    PROCEDURE set_name (
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

        /* set_department_name */

    PROCEDURE set_department_name (
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

        /* set_total_cerdit */

    PROCEDURE set_total_cerdit (
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

        /* register_student */

    PROCEDURE register_student (
        id          IN          student.id%TYPE,
        name        IN          student.name%TYPE,
        dept_name   IN          student.dept_name%TYPE,
        tot_cred    IN          student.tot_cred%TYPE
    ) IS
    BEGIN
        INSERT INTO student (
            id,
            name,
            dept_name,
            tot_cred
        ) VALUES (
            id,
            name,
            dept_name,
            tot_cred
        );

    END;

        /* get_all_students */

    PROCEDURE get_all_students (
        allstudent OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN allstudent FOR SELECT
                                *
                            FROM
                                student;

    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
    END;

        /* get_student_courses */

    PROCEDURE get_student_courses (
        c_course   OUT        SYS_REFCURSOR,
        s_id       IN         student.id%TYPE
    ) IS
    BEGIN
        OPEN c_course FOR SELECT
                              *
                          FROM
                              takes t
                          WHERE
                              t.id = s_id;

    END;
        /* delete_student */

    PROCEDURE delete_student (
        s_id   IN     student.id%TYPE
    ) IS
    BEGIN
        DELETE FROM student
        WHERE
            id = s_id;

    END;

        /* get_student_by_id */

    PROCEDURE get_student_by_id (
        c_course   OUT        SYS_REFCURSOR,
        s_id       IN         student.id%TYPE
    ) IS
    BEGIN
        OPEN c_course FOR SELECT
                              *
                          FROM
                              student
                          WHERE
                              id = s_id;

    END;

END;