CREATE OR REPLACE PACKAGE BODY university IS

-- TODO 5 accept input course_id and move to course package

    PROCEDURE tcourse_eq_ttakes (
        c_course OUT SYS_REFCURSOR
    ) IS
    BEGIN
        OPEN c_course FOR SELECT
                              *
                          FROM
                              course   c,
                              takes    t
                          WHERE
                              c.course_id = t.course_id;

    END;

-- TODO accept input student_id

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

-- TODO move to course package

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