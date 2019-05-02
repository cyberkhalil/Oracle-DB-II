CREATE OR REPLACE PACKAGE student_pkg IS
 function getName 
(IDS Student.ID%type) 
return varchar2;

function getDepartmentName 
(IDS Student.ID%type) 
return varchar2;

function getTotalCerdit 
(IDS Student.ID%type) 
return Number;

PROCEDURE SetName (
    IDS in Student.ID%type,
    S_Name in Student.Name%type
);

PROCEDURE SetDEPT_NAME (
    IDS in Student.ID%type,
    S_DEPT_NAME in Student.DEPT_NAME%type
);
PROCEDURE SetTotalCerdit (
    IDS in Student.ID%type,
    S_TotalCerdit in Student.TOT_CRED%type
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
FUNCTION student_name_and_ida(
     S_id in Student.ID%type)
   RETURN SYS_REFCURSOR;
    
END;

