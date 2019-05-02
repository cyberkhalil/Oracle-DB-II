create or replace package body student_pkg
is
PROCEDURE SetName (
    IDS in Student.ID%type,
    S_Name in Student.Name%type
)
    IS
BEGIN
    UPDATE  STUDENT set Name = S_Name where ID=IDS;

END;
PROCEDURE SetDEPT_NAME (
    IDS in Student.ID%type,
    S_DEPT_NAME in Student.DEPT_NAME%type
)
    IS
BEGIN
    UPDATE  STUDENT set DEPT_NAME = S_DEPT_NAME where ID=IDS;
END;
PROCEDURE SetTotalCerdit (
    IDS in Student.ID%type,
    S_TotalCerdit in Student.TOT_CRED%type
)
    IS
BEGIN
    UPDATE  STUDENT set TOT_CRED = S_TotalCerdit where ID=IDS;
END;
PROCEDURE insert_student (
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
    
    
    PROCEDURE allstudent (
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


 FUNCTION student_name_and_ida(
     S_id in Student.ID%type)
   RETURN SYS_REFCURSOR
AS
   c_coursea SYS_REFCURSOR;
BEGIN
 -- TODO 18 make this procedure display student id, name & all takes information for 
--this student also change procsdure name
          OPEN c_coursea FOR SELECT * FROM takes  t WHERE t.id = S_id;

   RETURN c_coursea;
END;

PROCEDURE Delete_Student (
     S_id in Student.ID%type
     )
     IS
     Begin
     DELETE
FROM
    Student
WHERE
    ID =S_id;
    END;
End;
