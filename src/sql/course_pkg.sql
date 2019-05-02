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
    
PROCEDURE allcourse_with_Id (
        allcourse OUT SYS_REFCURSOR,
          C_id in COURSE.COURSE_ID%type
    );

PROCEDURE delete_course (
     c_id in course.course_id%type
     );
END;