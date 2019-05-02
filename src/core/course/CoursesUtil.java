/*
 * Copyright (C) 2019 AyShe2
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package core.course;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import static util.db.DBConnection.getConnection;

/**
 *
 * @author User
 */
public final class CoursesUtil {

    private CoursesUtil() {
    }

    public static ResultSet displayCourseInformation() throws SQLException {
        String call = "{CALL Course_pkg.get_all_courses(?)}";
        CallableStatement statment = getConnection().prepareCall(call);
        statment.registerOutParameter(1, OracleTypes.CURSOR);
        statment.execute();
        ResultSet rs = ((OracleCallableStatement) statment).getCursor(1);
        return rs;
    }

    public static ResultSet getAllCoursesStudentsNumber() throws SQLException {
        String call = "{CALL Course_pkg.get_all_courses_students_number(?)}";
        CallableStatement statment = getConnection().prepareCall(call);
        statment.registerOutParameter(1, OracleTypes.CURSOR);
        statment.execute();
        ResultSet rs = ((OracleCallableStatement) statment).getCursor(1);
        return rs;
    }

    public static void createCourse(String courseId, String courseTitle,
            String courseDepartmentName, double courseCredits)
            throws SQLException {
        String call = "{CALL course_pkg.create_course(?,?,?,?)}";
        CallableStatement statment = getConnection().prepareCall(call);

        statment.setString(1, courseId);
        statment.setString(2, courseTitle);
        statment.setString(3, courseDepartmentName);
        statment.setDouble(4, courseCredits);
        statment.execute();
    }
}
