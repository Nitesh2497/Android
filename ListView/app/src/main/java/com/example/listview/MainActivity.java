package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.listview.Teachers.get8RandomTeachers;

public class MainActivity extends AppCompatActivity {

    ArrayList<Teachers> teachers = get8RandomTeachers();
    ListView lvTeachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTeachers = findViewById(R.id.lvTeachers);
        TeacherAdapter teacherAdapter = new TeacherAdapter();
        lvTeachers.setAdapter(teacherAdapter);
    }

    class TeacherAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return teachers.size();
        }

        @Override
        public Teachers getItem(int position) {
            return teachers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //getView is the one which gets us the layout of the file
        //getView occurs for every item in teachers list
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Process of taking a xml file and converting it to a ListView is called inflating a view
            View itemView = getLayoutInflater().inflate(R.layout.list_item_teacher_1,parent,false);

            TextView tvName = itemView.findViewById(R.id.tvName);
            TextView tvCourse = itemView.findViewById(R.id.tvCourse);
            tvName.setText(getItem(position).getName());
            tvCourse.setText(getItem(position).getCourse());

            return itemView;
        }
    }
}
