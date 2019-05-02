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
END;

