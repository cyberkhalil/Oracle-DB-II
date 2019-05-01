CREATE OR REPLACE PACKAGE Course_pkg IS
 function getTitle 
(COURSE_IDC Course.COURSE_ID%type) 
return varchar2;

function getDepartmentName 
(COURSE_IDC Course.COURSE_ID%type) 
return varchar2;

function getTotalCerdit
(COURSE_IDC Course.COURSE_ID%type) 
return Number;

PROCEDURE SetTitle (
    COURSE_IDC in Course.COURSE_ID%type,
    S_Title in Course.Title%type
);
PROCEDURE SetDepartmentName  (
    COURSE_IDC in Course.COURSE_ID%type,
    S_DEPT_NAME in Course.Title%type
);
PROCEDURE SetTotalCerdit  (
    COURSE_IDC in Course.COURSE_ID%type,
    C_CREDITS in COURSE.CREDITS%type
);

 
 
END;