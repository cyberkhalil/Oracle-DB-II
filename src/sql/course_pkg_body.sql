create or replace package body Course_pkg
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

    PROCEDURE insert_course (
        c_course_id   IN            course.course_id%TYPE,
        c_title       IN            course.title%TYPE,
        dept_name     IN            course.dept_name%TYPE,
        c_credits     IN            course.credits%TYPE
    ) IS
    BEGIN
        INSERT INTO course (
            course_id,
            title,
            dept_name,
            credits
        ) VALUES (
            c_course_id,
            c_title,
            dept_name,
            c_credits
        );

    END;

 PROCEDURE allcourse (
        allcourse OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN allcourse FOR SELECT
                               *
                           FROM
                               course;--COURSE_ID

    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
    END;

  PROCEDURE count_and_title_of_course (
        count_and_title_of_course OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN count_and_title_of_course FOR SELECT
                                               c.title,
                                               COUNT(t.id)
                                           FROM
                                               takes    t,
                                               course   c
                                           WHERE
                                               t.course_id = c.course_id
                                           GROUP BY
                                               c.title;

    END;

End;