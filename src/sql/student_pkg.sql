CREATE OR REPLACE PACKAGE student_pkg IS
    

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

    PROCEDURE insert_student (
        id          IN          student.id%TYPE,
        name        IN          student.name%TYPE,
        dept_name   IN          student.dept_name%TYPE,
        tot_cred    IN          student.tot_cred%TYPE
    );

    PROCEDURE allstudent (
        allstudent OUT SYS_REFCURSOR
    );

    FUNCTION student_name_and_ida (
        s_id   IN     student.id%TYPE
    ) RETURN SYS_REFCURSOR;

PROCEDURE Delete_Student (
     S_id in Student.ID%type
     );
    
    -- TODO 7 create procedure take student id as input & return student record. student_name_and_ida
END;