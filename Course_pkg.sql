CREATE OR REPLACE PACKAGE Course_pkg IS
    PROCEDURE setTitle (
        Title   VARCHAR2
    );
    
    PROCEDURE setDepartmentName(
        departmentName   VARCHAR2
    );
    
    PROCEDURE setCredits(
        Credits   Number
    );
END;
/*

Body


*/

