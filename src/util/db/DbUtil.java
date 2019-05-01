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

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.IO_Util;
import static util.db.DBConnection.getConnection;

/**
 *
 * @author User
 */
public final class DbUtil {

    private static final int DB_TABLES_NUMBER = 11;
    private static final File SCHEMA_FILE = new File("src/sql/universitySchema.sql");
    private static final File DROP_DB_FILE = new File("src/sql/dropDB.sql");
    private static final File UNIVERSITY_PACKAGE_FILE
            = new File("src/sql/university_pkg.sql");
    private static final File STUDENT_PACKAGE_FILE
            = new File("src/sql/student_pkg.sql");
    private static final File COURSE_PACKAGE_FILE
            = new File("src/sql/course_pkg.sql");
    //
     private static final File UNIVERSITY_PACKAGE_BODY_FILE
            = new File("src/sql/university_pkg_body.sql");
    private static final File STUDENT_PACKAGE_BODY_FILE
            = new File("src/sql/student_pkg_body.sql");
    private static final File COURSE_PACKAGE_BODY_FILE
            = new File("src/sql/course_pkg_body.sql");

    private DbUtil() {
    }

    public static boolean checkUniversitySchema() throws SQLException {
        ResultSet rs = PL_SQL_Handler.getAllTables();
        return PL_SQL_Handler.countAllTables() == DB_TABLES_NUMBER
                && rs.last() && rs.getString("Name").equals("TIME_SLOT");
    }

    public static void applyUniversity() throws IOException, SQLException {
        dropDB();
        createUniversitySchema();
        createUniversityPackages();
    }

    private static void createUniversitySchema() throws IOException, SQLException {
        String universityDB = IO_Util.readFile(
                SCHEMA_FILE.toString(), StandardCharsets.UTF_8);

        for (String line : universityDB.split("\n")) {
            line = line.replace(";", "");
            PreparedStatement statment = getConnection().prepareStatement(line);
            try {
                statment.executeUpdate();
            } catch (SQLException ex) {
                if ("42000".equals(ex.getSQLState())) // dropping non exist table .. 
                {
                    continue;
                }
                System.out.println(line);
                throw ex;
            }
        }
    }

    private static void dropDB() throws IOException, SQLException {
        String dropDB = IO_Util.readFile(
                DROP_DB_FILE.toString(), StandardCharsets.UTF_8);

        CallableStatement statment = getConnection().prepareCall(dropDB);
        statment.execute();
    }

    public static void createUniversityPackages() throws SQLException, IOException {

        createUniversityPackage();
        createStudentPackage();
        createCoursePackage();
    }

    private static void createCoursePackage() throws IOException, SQLException {
        String course_pkg = IO_Util.readFile(
                COURSE_PACKAGE_FILE.toString(), StandardCharsets.UTF_8);

        String course_pkg_body = IO_Util.readFile(
                COURSE_PACKAGE_BODY_FILE.toString(), StandardCharsets.UTF_8);

        CallableStatement statment
                = getConnection().prepareCall(course_pkg);

        CallableStatement statment2
                = getConnection().prepareCall(course_pkg_body);
        statment.execute();
        statment2.execute();

    }

    private static void createStudentPackage() throws SQLException, IOException {
        String student_pkg = IO_Util.readFile(
                STUDENT_PACKAGE_FILE.toString(), StandardCharsets.UTF_8);
        CallableStatement statment
                = getConnection().prepareCall(student_pkg);
        
        
         String student_pkg_body = IO_Util.readFile(
                STUDENT_PACKAGE_BODY_FILE.toString(), StandardCharsets.UTF_8);
        CallableStatement statment2
                = getConnection().prepareCall(student_pkg_body);
        
        
        statment.execute();
        statment2.execute();

    }

    private static void createUniversityPackage() throws IOException, SQLException {
        String university_pkg = IO_Util.readFile(
                UNIVERSITY_PACKAGE_FILE.toString(), StandardCharsets.UTF_8);
        CallableStatement statment
                = getConnection().prepareCall(university_pkg);
        
            String university_pkg_body = IO_Util.readFile(
                UNIVERSITY_PACKAGE_BODY_FILE.toString(), StandardCharsets.UTF_8);
        CallableStatement statment2
                = getConnection().prepareCall(university_pkg_body);
        statment.execute();
        statment2.execute();

    }
}
