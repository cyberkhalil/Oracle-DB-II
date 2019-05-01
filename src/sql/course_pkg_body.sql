create or replace package body all_course
is
function getTitle 
(COURSE_IDC Course.COURSE_ID%type) 
return varchar2
is 
TitleCourse varchar2(50) ;
Begin
  select TITLE into TitleCourse 
  from Course where COURSE_ID =COURSE_IDC;
  
return TitleCourse;
End;

function getDepartmentName 
(COURSE_IDC Course.COURSE_ID%type) 
return varchar2
is 
DepartmentName  varchar2(20) ;
Begin
  select DEPT_NAME into DepartmentName  
  from Course where COURSE_ID =COURSE_IDC;
  
return DepartmentName ;
End;


function getTotalCerdit
(COURSE_IDC Course.COURSE_ID%type) 
return Number
is 
C_CREDITS  varchar2(5) ;
Begin
  select CREDITS into C_CREDITS  
  from Course where COURSE_ID =COURSE_IDC;
  
return C_CREDITS ;
End;


PROCEDURE SetTitle (
    COURSE_IDC in Course.COURSE_ID%type,
    S_Title in Course.Title%type
)
    IS
BEGIN
    UPDATE  Course set TiTle = S_Title where COURSE_ID=COURSE_IDC;

END;

PROCEDURE SetDepartmentName  (
    COURSE_IDC in Course.COURSE_ID%type,
    S_DEPT_NAME in Course.Title%type
)
    IS
BEGIN
    UPDATE  Course set DEPT_NAME = S_DEPT_NAME where COURSE_ID=COURSE_IDC;

END;


PROCEDURE SetTotalCerdit  (
    COURSE_IDC in Course.COURSE_ID%type,
    C_CREDITS in COURSE.CREDITS%type
)
    IS
BEGIN
    UPDATE  Course set CREDITS = C_CREDITS where COURSE_ID=COURSE_IDC;

END;
End;