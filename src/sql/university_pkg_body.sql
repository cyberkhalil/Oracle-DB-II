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

    PROCEDURE insert_student (
        id          IN          student.id%TYPE,
        name        IN          student.name%TYPE,
        dept_name   IN          student.dept_name%TYPE,
        tot_cred    IN          student.tot_cred%TYPE
    ) IS
    BEGIN
        INSERT INTO student (
            id,
            name,
            dept_name,
            tot_cred
        ) VALUES (
            id,
            name,
            dept_name,
            tot_cred
        );

    END;

-- TODO move to student package

    PROCEDURE allstudent (
        allstudent OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN allstudent FOR SELECT
                                *
                            FROM
                                student;

    EXCEPTION
        WHEN OTHERS THEN
            dbms_output.put_line(sqlerrm);
    END;

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
