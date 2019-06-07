package com.example.listviewperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.listviewperformance.Courses.generateNRandomCourses;

public class MainActivity extends AppCompatActivity {
    ListView lvCourses;
    ArrayList<Courses> courses= generateNRandomCourses(20);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCourses = findViewById(R.id.lvCourses);
        CourseAdapter courseAdapter = new CourseAdapter();
        lvCourses.setAdapter(courseAdapter);
    }

    class CourseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return courses.size();
        }

        @Override
        public Courses getItem(int position) {
            return courses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CourseViewHolder holder;
            if(convertView==null){
                convertView = getLayoutInflater().inflate(R.layout.list_item_courses,parent,false);
                holder = new CourseViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder = (CourseViewHolder)convertView.getTag();
            }
//            View itemView = getLayoutInflater().inflate(R.layout.list_item_courses,parent,false);
//            TextView courses = itemView.findViewById(R.id.tvCourseName);
//            TextView teacherName = itemView.findViewById(R.id.tvTeachers);
//            TextView lectures = itemView.findViewById(R.id.tvLectures);

            Courses courses1 = getItem(position);
            holder.courses.setText(courses1.getName());
            holder.teacherName.setText(courses1.getTeacherName());
            holder.lectures.setText(String.valueOf(courses1.getLectures()));
            return convertView;
        }

        class CourseViewHolder{
            TextView courses , teacherName,lectures;
            public CourseViewHolder(View itemView){
                courses = itemView.findViewById(R.id.tvCourseName);
                teacherName = itemView.findViewById(R.id.tvTeachers);
                lectures = itemView.findViewById(R.id.tvLectures);
            }

        }
    }
}
