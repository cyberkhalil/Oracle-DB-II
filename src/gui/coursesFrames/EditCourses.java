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
package gui.coursesFrames;

import core.Course;
import gui.DefaultFrame;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableModel;
import util.gui.GUI_Util;
import static util.gui.GUI_Util.buildTableModel;
import static util.db.PL_SQL_Handler.displayCourseInformation;

/**
 *
 * @author User
 */
public class EditCourses extends DefaultFrame {

    Course selectedCourse;

    /**
     * Creates new form EditStudents
     */
    public EditCourses() {
        initComponents();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        courseIdLbl = new javax.swing.JLabel();
        courseTitleLbl = new javax.swing.JLabel();
        courseDepartmentLbl = new javax.swing.JLabel();
        courseCreditsLbl = new javax.swing.JLabel();
        courseDepartmentTf = new javax.swing.JTextField();
        courseTitleTf = new javax.swing.JTextField();
        courseIdTf = new javax.swing.JTextField();
        courseCreditsTf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        deleteCourseBtn = new javax.swing.JButton();
        editNameBtn = new javax.swing.JButton();
        editDepartmentBtn = new javax.swing.JButton();
        editCreditsBtn = new javax.swing.JButton();
        editCourseTakes = new javax.swing.JButton();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        courseIdLbl.setText("Id :");

        courseTitleLbl.setText("Title :");

        courseDepartmentLbl.setText("Department :");

        courseCreditsLbl.setText("Credits :");

        courseDepartmentTf.setEditable(false);

        courseTitleTf.setEditable(false);

        courseIdTf.setEditable(false);

        courseCreditsTf.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseDepartmentLbl)
                    .addComponent(courseTitleLbl)
                    .addComponent(courseIdLbl)
                    .addComponent(courseCreditsLbl))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(courseDepartmentTf)
                    .addComponent(courseCreditsTf, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(courseTitleTf)
                    .addComponent(courseIdTf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseIdLbl)
                    .addComponent(courseIdTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseTitleLbl)
                    .addComponent(courseTitleTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseDepartmentLbl)
                    .addComponent(courseDepartmentTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(courseCreditsTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseCreditsLbl))
                .addGap(20, 20, 20))
        );

        deleteCourseBtn.setText("delete Course");
        deleteCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseBtnActionPerformed(evt);
            }
        });

        editNameBtn.setText("Edit Title");
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

        editCreditsBtn.setText("Edit Credits");
        editCreditsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCreditsBtnActionPerformed(evt);
            }
        });

        editCourseTakes.setText("Edit course Takes");
        editCourseTakes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseTakesActionPerformed(evt);
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
                        .addComponent(editCreditsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteCourseBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(editNameBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(editDepartmentBtn)))
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(editCourseTakes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editNameBtn)
                    .addComponent(editDepartmentBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editCourseTakes)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteCourseBtn)
                    .addComponent(editCreditsBtn))
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
            selectedCourse = new Course((String) tableModel.getValueAt(i, 0));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        updateTable();
    }//GEN-LAST:event_jTable1MouseClicked

    private void editNameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNameBtnActionPerformed
        if (!validSelection()) {
            return;
        }
        String newCourseTitle = GUI_Util.promoteString(
                rootPane,
                "New course title:",
                "Course Title",
                "Course title can't be empty !");
        if (newCourseTitle == null) {
            return;
        }
        try {
            selectedCourse.setTitle(newCourseTitle);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        updateTable();
    }//GEN-LAST:event_editNameBtnActionPerformed

    private void editDepartmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDepartmentBtnActionPerformed
        if (!validSelection()) {
            return;
        }
        String newCourseDepartmentName = GUI_Util.promoteString(
                rootPane,
                "New course department name:",
                "Course department",
                "Coursedepartment name can't be empty !");
        if (newCourseDepartmentName == null) {
            return;
        }
        try {
            selectedCourse.setDepartmentName(newCourseDepartmentName);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        updateTable();
    }//GEN-LAST:event_editDepartmentBtnActionPerformed

    private void deleteCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseBtnActionPerformed
        if (GUI_Util.promoteConfirm(rootPane,
                "Are you sure you want to delete this course ?",
                "Course Deletion")) {
            try {
                selectedCourse.delete();
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(rootPane, ex);
            }
        }
        updateTable();
    }//GEN-LAST:event_deleteCourseBtnActionPerformed

    private void editCreditsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCreditsBtnActionPerformed
        GUI_Util.promoteSpinner("Course Credits", "New course credits :",
                "Set Course Credit",
                new SpinnerNumberModel(0.0, 0.0, 10_000_000.0, 10.0),
                (double newCredits) -> {
                    try {
                        selectedCourse.setCredits(newCredits);
                        return true;
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane, ex);
                    }
                    return false;
                });
        updateTable();
    }//GEN-LAST:event_editCreditsBtnActionPerformed

    private void editCourseTakesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseTakesActionPerformed
        // TODO 11 add code here
    }//GEN-LAST:event_editCourseTakesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseCreditsLbl;
    private javax.swing.JTextField courseCreditsTf;
    private javax.swing.JLabel courseDepartmentLbl;
    private javax.swing.JTextField courseDepartmentTf;
    private javax.swing.JLabel courseIdLbl;
    private javax.swing.JTextField courseIdTf;
    private javax.swing.JLabel courseTitleLbl;
    private javax.swing.JTextField courseTitleTf;
    private javax.swing.JButton deleteCourseBtn;
    private javax.swing.JButton editCourseTakes;
    private javax.swing.JButton editCreditsBtn;
    private javax.swing.JButton editDepartmentBtn;
    private javax.swing.JButton editNameBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void updateTable() {
        try {
            jTable1.setModel(buildTableModel(displayCourseInformation()));
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(rootPane, ex);
        }
        if (selectedCourse == null) {
            courseIdTf.setText("");
            courseTitleTf.setText("");
            courseDepartmentTf.setText("");
            courseCreditsTf.setText("");
        } else {
            courseIdTf.setText(selectedCourse.getId());
            courseTitleTf.setText(selectedCourse.getTitle());
            courseDepartmentTf.setText(selectedCourse.getDepartmentName());
            courseCreditsTf.setText(String.valueOf(selectedCourse.getCredits()));
        }
    }

    private boolean validSelection() {
        if (selectedCourse == null) {
            JOptionPane.showMessageDialog(rootPane,
                    "Choose a Student to make this opreation !");
            return false;
        }
        return true;
    }

}
