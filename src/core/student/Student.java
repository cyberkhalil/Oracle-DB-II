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
package core.student;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.db.DBConnection;
import static util.db.DBConnection.getConnection;

/**
 *
 * @author A7med
 */
public class Student {

    private final String ID;
    private String name;
    private String departmentName;
    private double totalCerdit;

    /**
     *
     * @param ID
     * @throws SQLException
     */
    public Student(String ID) throws SQLException {
        // TODO 7 use pl/sql procedure
        String query = "select * from student where ID=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, ID);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        name = rs.getString("name");
        departmentName = rs.getString("dept_name");
        totalCerdit = rs.getDouble("tot_cred");
        this.ID = ID;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @return the totalCerdit
     */
    public double getTotalCerdit() {
        return totalCerdit;
    }

    /**
     * @param name the name to set
     * @throws java.sql.SQLException
     */
    public void setName(String name) throws SQLException {
        String call = "{CALL student_pkg.setname(?,?)}";
        CallableStatement statment
                = getConnection().prepareCall(call);
        statment.setString(1, ID);
        statment.setString(2, name);
        statment.execute();
        this.name = name;
    }

    /**
     * @param departmentName the departmentName to set
     * @throws java.sql.SQLException
     */
    public void setDepartmentName(String departmentName) throws SQLException {
        String call = "{CALL student_pkg.setdept_name(?,?)}";
        CallableStatement statment
                = getConnection().prepareCall(call);
        statment.setString(1, ID);
        statment.setString(2, departmentName);
        statment.execute();
        this.departmentName = departmentName;
    }

    /**
     * @param totalCerdit the totalCerdit to set
     * @throws java.sql.SQLException
     */
    public void setTotalCerdit(double totalCerdit) throws SQLException {
        String call = "{CALL student_pkg.getTotalCerdit(?,?)}";
        CallableStatement statment
                = getConnection().prepareCall(call);
        statment.setString(1, ID);
        statment.setDouble(2, totalCerdit);
        statment.execute();
    }

    /**
     *
     * @throws SQLException
     */
    public void delete() throws SQLException {
        String call = "{CALL student_pkg.Delete_Student(?)}";
        CallableStatement statment = getConnection().prepareCall(call);
        statment.setString(1, ID);
        statment.execute();

        this.name = null;
        this.totalCerdit = -1;
        this.departmentName = null;
    }

}
