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

 

    PROCEDURE insert_student (
        id          IN          student.id%TYPE,
        name        IN          student.name%TYPE,
        dept_name   IN          student.dept_name%TYPE,
        tot_cred    IN          student.tot_cred%TYPE
    );

    


PROCEDURE Get_Dept_Name (
    c_course   OUT SYS_REFCURSOR
);
END;
