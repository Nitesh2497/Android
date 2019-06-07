package com.example.listviewperformance;

import java.util.ArrayList;
import java.util.Random;

public class Courses {
    String name,teacherName;
    int lectures;

    Courses(String name,String teacherName,int lectures){
        this.name = name;
        this.teacherName = teacherName;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getLectures() {
        return lectures;
    }

    public static final String[] teachers = {
            "Harshit", "Arnav", "Prateek", "Aayush", "Deepak", "Garima"
    };
    public static final String[] courseNames = {
            "Launchpad", "Crux", "Android", "NodeJS", "Python", "AngularJS"
    };

    public static ArrayList<Courses> generateNRandomCourses(int n){
        ArrayList<Courses> courses = new ArrayList<>();
        Random r = new Random();
        for(int i=0;i<n;i++){
            Courses courses1 = new Courses(courseNames[r.nextInt(6)],teachers[r.nextInt(6)],10+r.nextInt(10));
            courses.add(courses1);
        }
        return courses;
    }
}
