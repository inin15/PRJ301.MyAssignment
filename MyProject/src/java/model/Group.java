/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Group {
    private String id;
    private Subject subject;
    private Instructor instructor;

    public Group() {
    }

    public Group(String id, Subject subject, Instructor instructor) {
        this.id = id;
        this.subject = subject;
        this.instructor = instructor;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", subject=" + subject + ", instructor=" + instructor + '}';
    }
    
}
