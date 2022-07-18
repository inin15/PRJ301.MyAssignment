/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Couse {

   private int id;
    private Group group;
    private String name; 
    private int slot;
    private String room;
    private Date date;
    private int numberOfWeek;

    public Couse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Couse(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

 

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(int numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }
 @Override
    public String toString() {
        return "Couse{" + "id=" + id + ", group=" + group + "\n, name=" + name + ", slot=" + slot + ", room=" + room + "\n, date=" + date + ", numberOfWeek=" + numberOfWeek + '}';
    }
   public String toString1() {
        return group.getId() + "<br>-" + group.getSubject().getId() + "<br>at " + room;
    }
   
   
}
