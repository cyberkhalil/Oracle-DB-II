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
import java.sql.SQLException;
import util.db.DBConnection;

/**
 *
 * @author A7med
 */
public class Student {

    private final String ID = null;
    private String name;
    private String dept_name;
    private double tot_cred;

    public Student(String ID) {
        // TODO get other values from database
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) throws SQLException{
        String query = "Update student set name=? where ID=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, ID);
        preparedStatement.executeUpdate();
        this.name = name;
    }

    /**
     * @return the dept_name
     */
    public String getDept_name() {
        return dept_name;
    }

    /**
     * @param dept_name the dept_name to set
     */
    public void setDept_name(String dept_name)  throws SQLException{
         String query = "Update student set dept_name=? where ID=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, dept_name);
        preparedStatement.setString(3, ID);
        preparedStatement.executeUpdate();
        this.dept_name = dept_name;
    }

    /**
     * @return the tot_cred
     */
    public double getTot_cred() {
        return tot_cred;
    }

    /**
     * @param tot_cred the tot_cred to set
     */
    public void setTot_cred(double tot_cred) throws SQLException {
         String query = "Update student set tot_cred=? where ID=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, (int) tot_cred);
        preparedStatement.setString(3, ID);
        preparedStatement.executeUpdate();
        this.tot_cred = tot_cred;
    }
    
    public void delete() throws SQLException {
        String query = "Delete from student where ID=?";
        PreparedStatement preparedStatement
                = DBConnection.getConnection().prepareStatement(query);
        preparedStatement.setString(1, ID);
        preparedStatement.executeUpdate();
        this.name = null;
        this.tot_cred = 0;
        this.dept_name = null;
    }
    

}
