/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class StudentCouse {
      private Students student;
    private Couse couse;
    private boolean status;
    private String recordTime;
    private String note;

    public StudentCouse() {
    }

    public StudentCouse(Students student, Couse couse, boolean status, String recordTime, String note) {
        this.student = student;
        this.couse = couse;
        this.status = status;
        this.recordTime = recordTime;
        this.note = note;
    }

 

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Couse getCouse() {
        return couse;
    }

    public void setCouse(Couse couse) {
        this.couse = couse;
    }

  

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "StudentCouse{" + "student=" + student.getName() + ", couse=" + couse.getId() + ", status=" + status + ", recordTime=" + recordTime + ", note=" + note + '}';
    }
    
}
