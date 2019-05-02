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
package gui.studentsFrames;

import static core.department.DepartmentsUtil.displayDepartmentNames;
import java.sql.SQLException;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import util.gui.GUI_Util;
import static core.student.StudentsUtil.registerStudent;

/**
 *
 * @author User
 */
public class AddNewStudent extends javax.swing.JFrame {

    /**
     * Creates new form AddNewStudent
     */
    public AddNewStudent() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbl = new javax.swing.JLabel();
        studentNameLbl = new javax.swing.JLabel();
        studentNameTf = new javax.swing.JTextField();
        studentDeptLbl = new javax.swing.JLabel();
        sutdentIdTf = new javax.swing.JTextField();
        studentTotalCreditLbl = new javax.swing.JLabel();
        registerStudentBtn = new javax.swing.JButton();
        studentTotalCreditSp = new javax.swing.JSpinner();
        studentIdLbl = new javax.swing.JLabel();
        studentDepartmentCb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(430, 380));
        setResizable(false);

        titleLbl.setText("Student Registration");

        studentNameLbl.setText("Name :");

        studentDeptLbl.setText("Department name :");

        studentTotalCreditLbl.setText("Total credit :");

        registerStudentBtn.setText("Register New Student");
        registerStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerStudentBtnActionPerformed(evt);
            }
        });

        studentTotalCreditSp.setModel(new SpinnerNumberModel(0.0, 0.0, 10000000.0, 10.0));
        studentTotalCreditSp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        studentIdLbl.setText("Id :");

        studentDepartmentCb.setModel(getDepartmentNameModel());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(titleLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentNameLbl)
                                    .addComponent(studentTotalCreditLbl)
                                    .addComponent(studentDeptLbl)
                                    .addComponent(studentIdLbl))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(studentNameTf, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(sutdentIdTf)
                                    .addComponent(studentTotalCreditSp)
                                    .addComponent(studentDepartmentCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(registerStudentBtn)))))
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(titleLbl)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIdLbl)
                    .addComponent(sutdentIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNameLbl)
                    .addComponent(studentNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentDeptLbl)
                    .addComponent(studentDepartmentCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentTotalCreditLbl)
                    .addComponent(studentTotalCreditSp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(registerStudentBtn)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerStudentBtnActionPerformed
        try {
            registerStudent(studentNameTf.getText(),
                    this.studentNameTf.getText(),
                    (String) this.studentDepartmentCb.getSelectedItem(),
                    (double) this.studentTotalCreditSp.getValue());

            JOptionPane.showMessageDialog(
                    rootPane, "Student Registered Successfully");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_registerStudentBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton registerStudentBtn;
    private javax.swing.JComboBox<String> studentDepartmentCb;
    private javax.swing.JLabel studentDeptLbl;
    private javax.swing.JLabel studentIdLbl;
    private javax.swing.JLabel studentNameLbl;
    private javax.swing.JTextField studentNameTf;
    private javax.swing.JLabel studentTotalCreditLbl;
    private javax.swing.JSpinner studentTotalCreditSp;
    private javax.swing.JTextField sutdentIdTf;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables

    private ComboBoxModel<String> getDepartmentNameModel() {
        try {
            return GUI_Util.buildComboBoxModel(
                    displayDepartmentNames());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        return null;
    }
}
