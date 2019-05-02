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
package util.db;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import static util.db.DBConnection.getConnection;

/**
 *
 * @author User
 */
public final class PL_SQL_Handler {

    private PL_SQL_Handler() {
    }

    public static int countAllTables() throws SQLException {
        String query = "select count(*) from tab";
        PreparedStatement statment
                = getConnection().prepareStatement(query);
        ResultSet rs = statment.executeQuery();
        rs.next();
        return rs.getInt("COUNT(*)");
    }

    public static ResultSet getAllTables() throws SQLException {
        String query = "select * from tab";
        PreparedStatement statment
                = getConnection().prepareStatement(
                        query,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statment.executeQuery();
        return rs;
    }

    public static ResultSet displayStudentInformation() throws SQLException {
        String call = "{CALL student_pkg.allstudent(?)}";
        CallableStatement statment
                = getConnection().prepareCall(call);
        statment.registerOutParameter(1, OracleTypes.CURSOR);
        statment.execute();
        ResultSet rs = ((OracleCallableStatement) statment).getCursor(1);
        return rs;
    }

    public static ResultSet displayCourseInformation() throws SQLException {
        String call = "{CALL Course_pkg.allcourse(?)}";
        CallableStatement statment
                = getConnection().prepareCall(call);
        statment.registerOutParameter(1, OracleTypes.CURSOR);
        statment.execute();
        ResultSet rs = ((OracleCallableStatement) statment).getCursor(1);
        return rs;
    }

    // TODO 5 change this to take String input and get the result
    public static ResultSet displayInformationAboutCourseTakes()
            throws SQLException {
        String call = "{CALL Course_pkg.tcourse_eq_ttakesa(?)}";
        CallableStatement statment
                = getConnection().prepareCall(call);
        statment.registerOutParameter(1, OracleTypes.CURSOR);
        statment.execute();
        ResultSet rs = ((OracleCallableStatement) statment).getCursor(1);
        return rs;
    }

    public static ResultSet DisplayingStudentNameIDCourses() throws SQLException {
        String call = "{CALL student_pkg.student_name_and_id(?)}";
        CallableStatement statment
                = getConnection().prepareCall(call);
        statment.registerOutParameter(1, OracleTypes.CURSOR);
        statment.execute();
        ResultSet rs = ((OracleCallableStatement) statment).getCursor(1);
        return rs;
    }

    public static ResultSet DisplayNumberOfStudents() throws SQLException {
        String call = "{CALL Course_pkg.count_and_title_of_course(?)}";
        CallableStatement statment
                = getConnection().prepareCall(call);
        statment.registerOutParameter(1, OracleTypes.CURSOR);
        statment.execute();
        ResultSet rs = ((OracleCallableStatement) statment).getCursor(1);
        return rs;
    }

    public static void Insert_Student(String studentId, String studentName,
            String studentDepartmentName, double studentTotalCredit)
            throws SQLException {

        String call = "{CALL student_pkg.Insert_Student(?,?,?,?)}";
        CallableStatement statment = getConnection().prepareCall(call);

        statment.setString(1, studentId);
        statment.setString(2, studentName);
        statment.setString(3, studentDepartmentName);
        statment.setDouble(4, studentTotalCredit);
        statment.execute();
    }

    public static ResultSet displayDepartmentNames() throws SQLException {
        String call = "{CALL department_pkg.Get_Dept_Name(?)}";
        CallableStatement statment
                = getConnection().prepareCall(call);
        statment.registerOutParameter(1, OracleTypes.CURSOR);
        statment.execute();
        ResultSet rs = ((OracleCallableStatement) statment).getCursor(1);
        return rs;
    }
}
