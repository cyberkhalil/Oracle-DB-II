CREATE OR REPLACE PACKAGE university IS
    PROCEDURE allstudent (
        allstudent OUT SYS_REFCURSOR
    );

    PROCEDURE tcourse_eq_ttakes (
        c_course OUT SYS_REFCURSOR
    );

    PROCEDURE student_name_and_id (
        c_course OUT SYS_REFCURSOR
    );

    PROCEDURE count_and_title_of_course (
        count_and_title_of_course OUT SYS_REFCURSOR
    );

    PROCEDURE insert_student (
        id          IN          student.id%TYPE,
        name        IN          student.name%TYPE,
        dept_name   IN          student.dept_name%TYPE,
        tot_cred    IN          student.tot_cred%TYPE
    );

    PROCEDURE allcourse (
        allcourse OUT SYS_REFCURSOR
    );


PROCEDURE Insert_Course (
    C_COURSE_ID   in Course.COURSE_ID%type,
        C_Title   in Course.Title%type,
        DEPT_Name   in Course.DEPT_Name%type,
        C_CREDITS   in Course.CREDITS%type
);
PROCEDURE Get_Dept_Name (
    c_course   OUT SYS_REFCURSOR
);
END;
