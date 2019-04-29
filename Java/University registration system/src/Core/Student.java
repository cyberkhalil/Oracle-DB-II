/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author A7med
 */
public class Student {

    final String ID = null;
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
    public void setName(String name) {
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
    public void setDept_name(String dept_name) {
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
    public void setTot_cred(double tot_cred) {
        this.tot_cred = tot_cred;
    }

}
