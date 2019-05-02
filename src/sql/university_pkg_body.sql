CREATE OR REPLACE PACKAGE BODY university IS

-- TODO 5 accept input course_id and move to course package

 
-- TODO accept input student_id & return course name

    PROCEDURE student_name_and_id (
        c_course OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN c_course FOR SELECT
                              s.id,
                              s.name
                          FROM
                              course    c,
                              takes     t,
                              student   s
                          WHERE
                              c.course_id = t.course_id
                              AND s.id = t.id;

    END;

-- TODO accept input course_id

  
-- TODO move to student package

    

-- TODO move to student package

-- TODO move to courses package

   
-- TODO move to course package

-- TODO move to department package

    PROCEDURE get_dept_name (
        c_course OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN c_course FOR SELECT
                              dept_name
                          FROM
                              department;

    END;

END;
