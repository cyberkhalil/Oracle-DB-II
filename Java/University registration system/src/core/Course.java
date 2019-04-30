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

/**
 *
 * @author A7med
 */
public class Course {

    private String COURSE_ID = null;
    private String TITLE;
    private String DEPT_NAME;
    private double CREDITS;

    
    public Course (String COURSE_ID){
    
    }
    
    
    
    /**
     * @return the COURSE_ID
     */
    public String getCOURSE_ID() {
        return COURSE_ID;
    }

    /**
     * @param COURSE_ID the COURSE_ID to set
     */
    public void setCOURSE_ID(String COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    /**
     * @return the TITLE
     */
    public String getTITLE() {
        return TITLE;
    }

    /**
     * @param TITLE the TITLE to set
     */
    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    /**
     * @return the DEPT_NAME
     */
    public String getDEPT_NAME() {
        return DEPT_NAME;
    }

    /**
     * @param DEPT_NAME the DEPT_NAME to set
     */
    public void setDEPT_NAME(String DEPT_NAME) {
        this.DEPT_NAME = DEPT_NAME;
    }

    /**
     * @return the CREDITS
     */
    public double getCREDITS() {
        return CREDITS;
    }

    /**
     * @param CREDITS the CREDITS to set
     */
    public void setCREDITS(double CREDITS) {
        this.CREDITS = CREDITS;
    }
    

}
