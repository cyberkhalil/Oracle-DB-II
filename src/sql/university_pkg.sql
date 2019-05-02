CREATE OR REPLACE PACKAGE university IS
    PROCEDURE allstudent (
        allstudent OUT SYS_REFCURSOR
    );

   

    PROCEDURE student_name_and_id (
        c_course OUT SYS_REFCURSOR
    );

 



PROCEDURE Get_Dept_Name (
    c_course   OUT SYS_REFCURSOR
);
END;
