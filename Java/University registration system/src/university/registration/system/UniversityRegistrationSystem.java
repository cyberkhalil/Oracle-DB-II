package university.registration.system;

import db.DBConnection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author A7med
 */
public class UniversityRegistrationSystem {

    public static void main(String[] args) {
        try {
            DBConnection.establishConnection();
            System.out.println("Connection SUCCESSFUL;No Exception found!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
