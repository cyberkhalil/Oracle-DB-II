CREATE OR REPLACE PACKAGE BODY course_pkg IS

    FUNCTION gettitle (
        course_idc course.course_id%TYPE
    ) RETURN VARCHAR2 IS
        titlecourse VARCHAR2(50);
    BEGIN
        SELECT
            title
        INTO titlecourse
        FROM
            course
        WHERE
            course_id = course_idc;

        RETURN titlecourse;
    END;

    FUNCTION getdepartmentname (
        course_idc course.course_id%TYPE
    ) RETURN VARCHAR2 IS
        departmentname VARCHAR2(20);
    BEGIN
        SELECT
            dept_name
        INTO departmentname
        FROM
            course
        WHERE
            course_id = course_idc;

        RETURN departmentname;
    END;

    FUNCTION gettotalcerdit (
        course_idc course.course_id%TYPE
    ) RETURN NUMBER IS
        c_credits VARCHAR2(5);
    BEGIN
        SELECT
            credits
        INTO c_credits
        FROM
            course
        WHERE
            course_id = course_idc;

        RETURN c_credits;
    END;

    PROCEDURE settitle (
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

    PROCEDURE setdepartmentname (
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

    PROCEDURE settotalcerdit (
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

    PROCEDURE insert_course (
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

    PROCEDURE allcourse (
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

    PROCEDURE count_and_title_of_course (
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

    FUNCTION tcourse_eq_ttakesa (
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

END;