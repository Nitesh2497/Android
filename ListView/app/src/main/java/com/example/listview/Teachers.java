package com.example.listview;

import java.util.ArrayList;

public class Teachers {
    private String name,course;

    Teachers(String name,String course){
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public static ArrayList<Teachers> get8RandomTeachers(){
        ArrayList<Teachers> teachers = new ArrayList<>();
        teachers.add(new Teachers("Arnav","Android"));
        teachers.add(new Teachers("Mohit","C++"));
        teachers.add(new Teachers("Nitesh","Entreprenuership"));
        teachers.add(new Teachers("Elon Musk","Engineering"));
        teachers.add(new Teachers("Anil","Mechanical"));
        teachers.add(new Teachers("Poonam","Economics"));
        teachers.add(new Teachers("Sandesh","Medicine"));
        teachers.add(new Teachers("Ankush","Java"));
        return teachers;
    }
}
