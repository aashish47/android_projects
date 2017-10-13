package com.example.hp.addrecyclerviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etCourse,etTeacher,etClasses;
    Button btnAdd;
    RecyclerView rvCourseList;
    ArrayList<Course> coursesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCourse = (EditText) findViewById(R.id.etCourse);
        etTeacher = (EditText) findViewById(R.id.etTeacher);
        etClasses = (EditText) findViewById(R.id.etClasses);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        rvCourseList = (RecyclerView) findViewById(R.id.rvCourseList);

        coursesList = Course.getCourses(10);

        final CourseListAdapter adapter = new CourseListAdapter(this,coursesList);
        rvCourseList.setLayoutManager(new LinearLayoutManager(this));
        rvCourseList.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkCourse = etCourse.getText().toString();
                String checkTeacher = etTeacher.getText().toString();
                String checkClasses = etClasses.getText().toString();
                if(TextUtils.isEmpty(checkCourse)||TextUtils.isEmpty(checkTeacher)||TextUtils.isEmpty(checkClasses)){
                    Toast.makeText(MainActivity.this, "Fields Cannot Be Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Course newCourse = new Course(
                        checkCourse,
                        checkTeacher,
                        Integer.valueOf(checkClasses)
                );
                coursesList.add(newCourse);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
