CREATE OR REPLACE PACKAGE BODY student_pkg IS
        
        /* set_name */

    PROCEDURE set_name (
        ids      IN       student.id%TYPE,
        s_name   IN       student.name%TYPE
    ) IS
    BEGIN
        UPDATE student
        SET
            name = s_name
        WHERE
            id = ids;

    END;

        /* set_department_name */

    PROCEDURE set_department_name (
        ids           IN            student.id%TYPE,
        s_dept_name   IN            student.dept_name%TYPE
    ) IS
    BEGIN
        UPDATE student
        SET
            dept_name = s_dept_name
        WHERE
            id = ids;

    END;

        /* set_total_cerdit */

    PROCEDURE set_total_cerdit (
        ids             IN              student.id%TYPE,
        s_totalcerdit   IN              student.tot_cred%TYPE
    ) IS
    BEGIN
        UPDATE student
        SET
            tot_cred = s_totalcerdit
        WHERE
            id = ids;

    END;

        /* register_student */

    PROCEDURE register_student (
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

        /* get_all_students */

    PROCEDURE get_all_students (
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

        /* get_student_courses */

    FUNCTION get_student_courses (
        s_id   IN     student.id%TYPE
    ) RETURN SYS_REFCURSOR AS
        c_coursea SYS_REFCURSOR;
    BEGIN
 -- TODO 5 make this function display student id, name & all courses (names and id's) for a student id
        OPEN c_coursea FOR SELECT
                               *
                           FROM
                               takes t
                           WHERE
                               t.id = s_id;

        RETURN c_coursea;
    END;

        /* delete_student */

    PROCEDURE delete_student (
        s_id   IN     student.id%TYPE
    ) IS
    BEGIN
        DELETE FROM student
        WHERE
            id = s_id;

    END;

        /* get_student_by_id */

    FUNCTION get_student_by_id (
        s_id   IN     student.id%TYPE
    ) RETURN SYS_REFCURSOR AS
        c_coursea SYS_REFCURSOR;
    BEGIN
        OPEN c_coursea FOR SELECT
                               *
                           FROM
                               student
                           WHERE
                               id = s_id;

        RETURN c_coursea;
    END;

FUNCTION Student_Name_id(
     S_id in Student.ID%type)
   RETURN SYS_REFCURSOR
AS
   c_coursea SYS_REFCURSOR;
BEGIN
 -- TODO 18 make this procedure display student id, name & all takes information for 
--this student also change procsdure name
          OPEN c_coursea FOR SELECT s.ID, s.name ,c.Title,c.Course_id FROM course c, takes  t, student s  WHERE t.id = S_id  AND s.id = t.id;


   RETURN c_coursea;
END;         
END;