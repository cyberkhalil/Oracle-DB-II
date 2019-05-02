CREATE OR REPLACE PACKAGE BODY course_pkg IS

        /* set_title */
    PROCEDURE set_title (
        course_idc   IN           course.course_id%TYPE,
        s_title      IN           course.title%TYPE
    ) IS
    BEGIN
        UPDATE course
        SET
            title = s_title
        WHERE
            course_id = course_idc;

    END;

        /* set_department_name */
    PROCEDURE set_department_name (
        course_idc    IN            course.course_id%TYPE,
        s_dept_name   IN            course.title%TYPE
    ) IS
    BEGIN
        UPDATE course
        SET
            dept_name = s_dept_name
        WHERE
            course_id = course_idc;

    END;

        /* set_cerdits */
    PROCEDURE set_cerdits (
        course_idc   IN           course.course_id%TYPE,
        c_credits    IN           course.credits%TYPE
    ) IS
    BEGIN
        UPDATE course
        SET
            credits = c_credits
        WHERE
            course_id = course_idc;

    END;


        /* create_course */
    PROCEDURE create_course (
        c_course_id   IN            course.course_id%TYPE,
        c_title       IN            course.title%TYPE,
        dept_name     IN            course.dept_name%TYPE,
        c_credits     IN            course.credits%TYPE
    ) IS
    BEGIN
        INSERT INTO course (
            course_id,
            title,
            dept_name,
            credits
        ) VALUES (
            c_course_id,
            c_title,
            dept_name,
            c_credits
        );

    END;
    
        /* get_all_courses */
    PROCEDURE get_all_courses (
        allcourse OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN allcourse FOR SELECT
                               *
                           FROM
                               course;--COURSE_ID

    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
    END;

        /* get_all_courses_students_number */
    PROCEDURE get_all_courses_students_number (
        count_and_title_of_course OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN count_and_title_of_course FOR SELECT
                                               c.title,
                                               COUNT(t.id)
                                           FROM
                                               takes    t,
                                               course   c
                                           WHERE
                                               t.course_id = c.course_id
                                           GROUP BY
                                               c.title;

    END;


        /* get_course_takes */
    FUNCTION get_course_takes (
        c_id   IN     course.course_id%TYPE
    ) RETURN SYS_REFCURSOR AS
        c_coursea SYS_REFCURSOR;
    BEGIN
        OPEN c_coursea FOR SELECT
                               *
                           FROM
                               takes
                           WHERE
                               course_id = c_id;

        RETURN c_coursea;
    END;

    PROCEDURE allcourse_with_id (
        allcourse   OUT         SYS_REFCURSOR,
        c_id        IN          course.course_id%TYPE
    ) IS
    BEGIN
        OPEN allcourse FOR SELECT
                               *
                           FROM
                               course
                           WHERE
                               course_id = c_id;--COURSE_ID

    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
    END;

    PROCEDURE delete_course (
        c_id   IN     course.course_id%TYPE
    ) IS
    BEGIN
        DELETE FROM course
        WHERE
            course_id = c_id;

    END;

END;