package com.example.listviewperformance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerCourseAdapter extends RecyclerView.Adapter<RecyclerCourseAdapter.CourseViewHolder> {

    ArrayList<Courses> courses;

    public RecyclerCourseAdapter(ArrayList<Courses> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = (LayoutInflater)viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_courses,viewGroup,false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder courseViewHolder, int i) {
        Courses courses1 = courses.get(i);
        courseViewHolder.courses2.setText(courses1.getName());
        courseViewHolder.teacherName.setText(courses1.getTeacherName());
        courseViewHolder.lectures.setText(String.valueOf(courses1.getLectures()));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder{
        TextView courses2 , teacherName,lectures;
        public CourseViewHolder(View itemView){
            super(itemView);
            courses2 = itemView.findViewById(R.id.tvCourseName);
            teacherName = itemView.findViewById(R.id.tvTeachers);
            lectures = itemView.findViewById(R.id.tvLectures);
        }
    }
}
