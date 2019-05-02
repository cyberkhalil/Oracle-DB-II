CREATE OR REPLACE PACKAGE course_pkg IS
    -- TODO 8 remove all get's from pkg and pkg body.
    FUNCTION gettitle (
        course_idc course.course_id%TYPE
    ) RETURN VARCHAR2;

    FUNCTION getdepartmentname (
        course_idc course.course_id%TYPE
    ) RETURN VARCHAR2;

    FUNCTION gettotalcerdit (
        course_idc course.course_id%TYPE
    ) RETURN NUMBER;

    PROCEDURE set_title (
        course_idc   IN           course.course_id%TYPE,
        s_title      IN           course.title%TYPE
    );

    PROCEDURE set_department_name (
        course_idc    IN            course.course_id%TYPE,
        s_dept_name   IN            course.title%TYPE
    );

    PROCEDURE set_cerdits (
        course_idc   IN           course.course_id%TYPE,
        c_credits    IN           course.credits%TYPE
    );

    PROCEDURE insert_course (
        c_course_id   IN            course.course_id%TYPE,
        c_title       IN            course.title%TYPE,
        dept_name     IN            course.dept_name%TYPE,
        c_credits     IN            course.credits%TYPE
    );

    PROCEDURE allcourse (
        allcourse OUT SYS_REFCURSOR
    );

    PROCEDURE count_and_title_of_course (
        count_and_title_of_course OUT SYS_REFCURSOR
    );

    FUNCTION tcourse_eq_ttakesa (
        c_id   IN     course.course_id%TYPE
    ) RETURN SYS_REFCURSOR;

-- TODO 9 create procedure take course id as input & return course record
-- TODO 10 create delete procedure take course id and delete record from course table

END;