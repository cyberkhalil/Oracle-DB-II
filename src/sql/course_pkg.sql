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

 

PROCEDURE Insert_Course (
    C_COURSE_ID   in Course.COURSE_ID%type,
        C_Title   in Course.Title%type,
        DEPT_Name   in Course.DEPT_Name%type,
        C_CREDITS   in Course.CREDITS%type
);

PROCEDURE allcourse (
        allcourse OUT SYS_REFCURSOR
    );
    
PROCEDURE count_and_title_of_course (
        count_and_title_of_course OUT SYS_REFCURSOR
    );    
    
END;