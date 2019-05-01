CREATE OR REPLACE PACKAGE student_pkg IS
    PROCEDURE setName (
        name   VARCHAR2
    );
    
    PROCEDURE setDepartmentName(
        departmentName   VARCHAR2
    );
    
    PROCEDURE setTotalCerdit(
        totalCerdit   Number
    );
END;

