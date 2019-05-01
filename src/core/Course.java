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
package core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.db.DBConnection;

/**
 *
 * @author A7med
 */
public class Course {

    private final String COURSE_ID;
    private String title;
    private String departmentName;
    private double credits;

    /**
     *
     * @param COURSE_ID
     * @throws SQLException
     */
    public Course(String COURSE_ID) throws SQLException {
        String query = "select * from course where course_id=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, COURSE_ID);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        title = rs.getString("title");
        departmentName = rs.getString("dept_name");
        credits = rs.getDouble("credits");
        this.COURSE_ID = COURSE_ID;
    }

    /**
     * @return the COURSE_ID
     */
    public String getId() {
        return COURSE_ID;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     * @throws java.sql.SQLException
     */
    public void setTitle(String title) throws SQLException {
        String query = "Update student set title=? where course_id=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, COURSE_ID);
        preparedStatement.executeUpdate();

        this.title = title;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     * @throws java.sql.SQLException
     */
    public void setDepartmentName(String departmentName) throws SQLException {

        String query = "Update student set DEPT_NAME=? where course_id=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, departmentName);
        preparedStatement.setString(2, COURSE_ID);
        preparedStatement.executeUpdate();
        this.departmentName = departmentName;
    }

    /**
     * @return the credits
     */
    public double getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     * @throws java.sql.SQLException
     */
    public void setCredits(double credits) throws SQLException {

        String query = "Update student set credits=? where course_id=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setDouble(1, credits);
        preparedStatement.setString(2, COURSE_ID);
        preparedStatement.executeUpdate();

        this.credits = credits;
    }

    /**
     *
     * @throws SQLException
     */
    public void delete() throws SQLException {
        String query = "Delete from student where course_id=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, COURSE_ID);
        preparedStatement.executeUpdate();
        this.title = null;
        this.credits = -1;
        this.departmentName = null;
    }

}
