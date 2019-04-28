Create or Replace PROCEDURE AllStudent(
S_AllStudent out Student%Rowtype
)
is 
begin     
--select * into S_AllStudent  from Student where Student.ID='19991'; this is for test
select * into S_AllStudent  from Student where Student.ID='19991';
    exception
    when others then 
    DBMS_OUTPUT.PUT_LINE(sqlerrm);
end;
--exec AllStudent();
Declare 
S_AllStudent Student%Rowtype;
Begin
AllStudent(S_AllStudent);
   --select * into S_AllStudent  from Student where Student.ID='00128';
    DBMS_OUTPUT.PUT_LINE(S_AllStudent.Name); -- it should put id in procedure if you want to use this way
End;

/*
P2
*/

Create or Replace PROCEDURE AllCourse(
C_AllCourse out COURSE%Rowtype
)
is 
begin     
--select * into S_AllStudent  from Student where Student.ID='19991'; this is for test
--select * into C_AllCourse from COURSE where COURSE_ID='BIO-101';--COURSE_ID
select * into C_AllCourse from COURSE ;--COURSE_ID

    exception
    when others then 
    DBMS_OUTPUT.PUT_LINE(sqlerrm);
end;
---testAllCourse
Declare 
C_AllCourse COURSE%Rowtype;
Begin
AllCourse(C_AllCourse);
   --select * into S_AllStudent  from Student where Student.ID='00128';
    DBMS_OUTPUT.PUT_LINE(C_AllCourse.Title);
End;

/*

p3
*/

Create or Replace PROCEDURE Allcourse_credit(
c_COURSE out SYS_REFCURSOR
)
is 
begin     
open  c_COURSE for
select  CREDITS into C_AllCourse from COURSE ;--COURSE_ID

    exception
    when others then 
    DBMS_OUTPUT.PUT_LINE(sqlerrm);
end;
--Test one
Declare 
Cursor c_COURSE is select  CREDITS from COURSE ;
C_Course_CREDITS COURSE.CREDITS%type;
Begin

open c_COURSE ;
loop 
  fetch c_COURSE into C_Course_CREDITS;
  exit when c_COURSE%notfound;
     DBMS_OUTPUT.PUT_LINE('Employee Name: ' || C_Course_CREDITS);
   
     DBMS_OUTPUT.PUT_LINE('*************************************');
  end loop;
  
close c_COURSE
;End;
--Test two

Declare 
TYPE c_COURSE IS REF CURSOR;
C_Course_CREDITS COURSE.CREDITS%type;
Begin
Allcourse_credit(c_COURSE);
loop 
fetch c_emp into v_record ;
 DBMS_OUTPUT.PUT_LINE(v_record.last_name);
 exit when c_emp%notfound;
 end loop;
End;