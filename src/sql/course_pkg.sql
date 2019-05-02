CREATE OR REPLACE PACKAGE course_pkg IS
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

    PROCEDURE create_course (
        c_course_id   IN            course.course_id%TYPE,
        c_title       IN            course.title%TYPE,
        dept_name     IN            course.dept_name%TYPE,
        c_credits     IN            course.credits%TYPE
    );

    PROCEDURE get_all_courses (
        allcourse OUT SYS_REFCURSOR
    );

    PROCEDURE get_courses_students_number (
        count_and_title_of_course OUT SYS_REFCURSOR
    );

    FUNCTION get_course_takes (
        c_id   IN     course.course_id%TYPE
    ) RETURN SYS_REFCURSOR;

    PROCEDURE allcourse_with_id (
        allcourse   OUT         SYS_REFCURSOR,
        c_id        IN          course.course_id%TYPE
    );

    PROCEDURE delete_course (
        c_id   IN     course.course_id%TYPE
    );

END;