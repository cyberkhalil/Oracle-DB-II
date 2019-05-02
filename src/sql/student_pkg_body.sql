create or replace package body student_pkg
is
 function getName 
(IDS Student.ID%type) 
return varchar2
is 
nameStudent varchar2(5) ;
Begin
  select Name into nameStudent 
  from STUDENT where ID =IDS;
  
return nameStudent;
End;
function getDepartmentName 
(IDS Student.ID%type) 
return varchar2
is 
DepartmentName  varchar2(5) ;
Begin
  select DEPT_NAME into DepartmentName  
  from STUDENT where ID =IDS;
  
return DepartmentName ;
End;
function getTotalCerdit 
(IDS Student.ID%type) 
return Number
is 
TOT_CREDa  varchar2(5) ;
Begin
  select TOT_CRED into TOT_CREDa  
  from STUDENT where ID =IDS;
  
return TOT_CREDa ;
End;
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

End;
