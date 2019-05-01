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
package util.gui;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;    //TODO 3 try to change vector to arraylist
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public final class GUI_Util {

    private GUI_Util() {
    }

    public static void duplicateText(JTextField original, JTextField duplicate) {

        original.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textChanged();
            }

            private void textChanged() {
                duplicate.setText(original.getText());
            }
        }
        );
    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

    }

    public static void linkFrameToButton(JFrame frame, JButton button) {
        button.setEnabled(false);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                button.setEnabled(true);
            }
        });
    }

    public static void exitConfirm(Component rootPane) {
        int confirm = JOptionPane.showConfirmDialog(
                rootPane, "Are You Sure to Close Application?",
                "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static String promoteString(
            Component pane, String request, String title, String emptyMsg) {

        String promotedString = JOptionPane.
                showInputDialog(pane, request, title, DISPOSE_ON_CLOSE);

        if (promotedString != null && promotedString.trim().isEmpty()) {
            JOptionPane.showMessageDialog(pane, emptyMsg);
            return null;
        }
        return promotedString;
    }

    public static boolean promoteConfirm(
            Component rootPane, String msg, String title) {
        int confirm = JOptionPane.showConfirmDialog(
                rootPane, msg,
                title, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        return confirm == JOptionPane.YES_OPTION;
    }

    public static void promoteSpinner(String title, String labelTxt,
            String buttonTxt, SpinnerNumberModel spinnerNumberModel,
            DoSomethingWithSpinner dsws) {
        JFrame promoteFrame
                = new PromoteSpinner(title, labelTxt, spinnerNumberModel, buttonTxt, dsws);
        promoteFrame.setVisible(true);
    }

    public static void promoteIntegerBySpinner(String title, String labelTxt,
            String buttonTxt, DoSomethingWithSpinner dsws) {
        JFrame promoteFrame = new PromoteSpinner(
                title, labelTxt,
                new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1),
                buttonTxt,
                dsws);
        promoteFrame.setVisible(true);
    }

    public static abstract interface DoSomethingWithSpinner {

        /**
         * @param spinnerValue the value of the spinner
         * @return true to close or false to not close
         */
        abstract boolean doSomething(double spinnerValue);
    }

}
