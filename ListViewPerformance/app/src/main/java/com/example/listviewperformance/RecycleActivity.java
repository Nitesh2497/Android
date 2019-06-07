package com.example.listviewperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.listviewperformance.Courses.generateNRandomCourses;

public class RecycleActivity extends AppCompatActivity {

    ArrayList<Courses> courses = generateNRandomCourses(100);
    RecyclerView rvCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        RecyclerCourseAdapter recyclerCourseAdapter = new RecyclerCourseAdapter(courses);
        rvCourses.setAdapter(recyclerCourseAdapter);
    }
}
