package com.example.test2;

public class Program {private int id;
    private String student;
    private String teacher;
    private int Room;
    public  Program(int id, String stName, String teacher , int room) {
        this.id = id;
        this.student = stName;
        this.teacher = teacher;
        this.Room = room;
    }
    public int getId() {
        return this.id;
    }
    public String getStudent() {
        return student;
    }

    public String getTeacher() {
        return this.teacher ;
    }
    public int getRoom() {
        return this.Room ;

    }


    public void setRoom(int room) {
        this.Room = room;
    }
}

