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
import core.student.Student;
import gui.DefaultFrame;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableModel;
import util.gui.GUI_Util;
import static util.gui.GUI_Util.buildTableModel;
import static core.student.StudentsUtil.getAllStudents;
import javax.swing.DefaultComboBoxModel;
import util.db.DbUtil;
import static util.gui.GUI_Util.linkFrameToButton;
import static util.gui.GUI_Util.promoteComboBox;

/**
 *
 * @author User
 */
public class EditStudents extends DefaultFrame {

    Student selectedStudent;

    /**
     * Creates new form EditStudents
     */
    public EditStudents() {
        initComponents();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        studentIdLbl = new javax.swing.JLabel();
        studentNameLbl = new javax.swing.JLabel();
        studentDepartmentLbl = new javax.swing.JLabel();
        studentTotalCreditLbl = new javax.swing.JLabel();
        studentDepartmentTf = new javax.swing.JTextField();
        studentNameTf = new javax.swing.JTextField();
        studentIdTf = new javax.swing.JTextField();
        studentCreditTf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        deleteStudentBtn = new javax.swing.JButton();
        editNameBtn = new javax.swing.JButton();
        editDepartmentBtn = new javax.swing.JButton();
        editTotalCreditBtn = new javax.swing.JButton();
        editStudentCoursesBtn = new javax.swing.JButton();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        studentIdLbl.setText("Id :");

        studentNameLbl.setText("Name :");

        studentDepartmentLbl.setText("Department :");

        studentTotalCreditLbl.setText("Total Credit :");

        studentDepartmentTf.setEditable(false);

        studentNameTf.setEditable(false);

        studentIdTf.setEditable(false);

        studentCreditTf.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentDepartmentLbl)
                    .addComponent(studentNameLbl)
                    .addComponent(studentIdLbl)
                    .addComponent(studentTotalCreditLbl))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentDepartmentTf)
                    .addComponent(studentCreditTf, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(studentNameTf)
                    .addComponent(studentIdTf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIdLbl)
                    .addComponent(studentIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNameLbl)
                    .addComponent(studentNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentDepartmentLbl)
                    .addComponent(studentDepartmentTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(studentCreditTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentTotalCreditLbl))
                .addGap(20, 20, 20))
        );

        deleteStudentBtn.setText("delete Student");
        deleteStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentBtnActionPerformed(evt);
            }
        });

        editNameBtn.setText("Edit Name");
        editNameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNameBtnActionPerformed(evt);
            }
        });

        editDepartmentBtn.setText("Edit Department");
        editDepartmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDepartmentBtnActionPerformed(evt);
            }
        });

        editTotalCreditBtn.setText("Edit Total Credits");
        editTotalCreditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTotalCreditBtnActionPerformed(evt);
            }
        });

        editStudentCoursesBtn.setText("Show Student Courses");
        editStudentCoursesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStudentCoursesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(editTotalCreditBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteStudentBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(editNameBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(editDepartmentBtn)))
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(editStudentCoursesBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editNameBtn)
                    .addComponent(editDepartmentBtn))
                .addGap(18, 18, 18)
                .addComponent(editStudentCoursesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTotalCreditBtn)
                    .addComponent(deleteStudentBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        TableModel tableModel = jTable1.getModel();
        try {
            selectedStudent = new Student((String) tableModel.getValueAt(i, 0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        updateTable();
    }//GEN-LAST:event_jTable1MouseClicked

    private void editNameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNameBtnActionPerformed
        if (!validSelection()) {
            return;
        }
        String newStudentName = GUI_Util.promoteString(
                rootPane,
                "New student name:",
                "Student Name",
                "Student name can't be empty !");
        if (newStudentName == null) {
            return;
        }
        try {
            selectedStudent.setName(newStudentName);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        updateTable();
    }//GEN-LAST:event_editNameBtnActionPerformed

    private void editDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDepartmentBtnActionPerformed
        if (!validSelection()) {
            return;
        }
        String[] arr;
        try {
            arr = DbUtil.resultSetToSigleColoumnArray(
                    displayDepartmentNames()
            );
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(rootPane, ex);
            return;
        }
        linkFrameToButton(promoteComboBox(
                "Course Department Name",
                "New department name:",
                "Set department name",
                new DefaultComboBoxModel(arr),
                (String choice) -> {
                    try {
                        selectedStudent.setDepartmentName(choice);

                        JOptionPane.showMessageDialog(rootPane,
                                "Department Changed Successfully");
                        updateTable();
                        editDepartmentBtn.setEnabled(true);
                        return true;
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex);
                        return false;
                    }
                }), editDepartmentBtn);
    }//GEN-LAST:event_editDepartmentBtnActionPerformed

    private void deleteStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentBtnActionPerformed
        if (!validSelection()) {
            return;
        }
        if (GUI_Util.promoteConfirm(rootPane,
                "Are you sure you want to delete this student ?",
                "Student Deletion")) {
            try {
                selectedStudent.delete();
                updateTable();
                studentIdTf.setText("");
                studentNameTf.setText("");
                studentDepartmentTf.setText("");
                studentCreditTf.setText("");
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(rootPane, ex);
            }
        }
    }//GEN-LAST:event_deleteStudentBtnActionPerformed

    private void editTotalCreditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTotalCreditBtnActionPerformed
        if (!validSelection()) {
            return;
        }
        linkFrameToButton(GUI_Util.promoteSpinner("Student Total Credit",
                "New student total credit :",
                "Set Total Credit",
                new SpinnerNumberModel(0.0, 0.0, 10_000_000.0, 10.0),
                (double newTotalCredit) -> {
                    try {
                        selectedStudent.setTotalCerdit(newTotalCredit);
                        updateTable();
                        editTotalCreditBtn.setEnabled(true);
                        return true;
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex);
                    }
                    return false;
                }), editTotalCreditBtn);
    }//GEN-LAST:event_editTotalCreditBtnActionPerformed

    private void editStudentCoursesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentCoursesBtnActionPerformed
        if (!validSelection()) {
            return;
        }
        ShowStudentCourses frame = new ShowStudentCourses(selectedStudent);
        linkFrameToButton(frame, editStudentCoursesBtn);
        frame.setVisible(true);
    }//GEN-LAST:event_editStudentCoursesBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteStudentBtn;
    private javax.swing.JButton editDepartmentBtn;
    private javax.swing.JButton editNameBtn;
    private javax.swing.JButton editStudentCoursesBtn;
    private javax.swing.JButton editTotalCreditBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField studentCreditTf;
    private javax.swing.JLabel studentDepartmentLbl;
    private javax.swing.JTextField studentDepartmentTf;
    private javax.swing.JLabel studentIdLbl;
    private javax.swing.JTextField studentIdTf;
    private javax.swing.JLabel studentNameLbl;
    private javax.swing.JTextField studentNameTf;
    private javax.swing.JLabel studentTotalCreditLbl;
    // End of variables declaration//GEN-END:variables

    private void updateTable() {
        try {
            jTable1.setModel(buildTableModel(getAllStudents()));
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(rootPane, ex);
        }
        if (selectedStudent == null) {
            studentIdTf.setText("");
            studentNameTf.setText("");
            studentDepartmentTf.setText("");
            studentCreditTf.setText("");
        } else {
            studentIdTf.setText(selectedStudent.getID());
            studentNameTf.setText(selectedStudent.getName());
            studentDepartmentTf.setText(selectedStudent.getDepartmentName());
            studentCreditTf.setText(String.valueOf(selectedStudent.getTotalCerdit()));
        }
    }

    private boolean validSelection() {
        if (selectedStudent == null) {
            JOptionPane.showMessageDialog(rootPane,
                    "Choose a Student to make this opreation !");
            return false;
        }
        return true;
    }

}
