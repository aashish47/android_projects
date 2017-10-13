package com.example.hp.addrecyclerviews;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Hp on 9/1/2017.
 */

public class Course {
    String courseName;
    String teacher;
    Integer classes;

    public String getCourseName() {
        return courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public Integer getClasses() {
        return classes;
    }

    public Course(String courseName, String teacher, Integer classes) {

        this.courseName = courseName;
        this.teacher = teacher;
        this.classes = classes;
    }

    static String courses[] = {"Crux","Launchpad","Pandora","Algo++","Elixir"};
    static String teachers[] = {"Arnav","Prateek","Sumit","Rishabh","Harshit","Aayush"};

    public static ArrayList<Course> getCourses(int n){
        ArrayList<Course> coursesList  = new ArrayList<>();
        Random r = new Random();

        for(int i = 0 ;i< n ;i++){
            Course newCourse = new Course(
                    courses[r.nextInt(courses.length)],
                    teachers[r.nextInt(teachers.length)],
                    20 + r.nextInt(5)
            );
            coursesList.add(newCourse);
        }

        return coursesList;

    }
}
