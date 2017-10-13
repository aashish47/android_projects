package com.example.hp.addrecyclerviews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Hp on 9/1/2017.
 */

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder> {

    Context context;
    ArrayList<Course> coursesList;

    public CourseListAdapter(Context context, ArrayList<Course> coursesList) {
        this.context = context;
        this.coursesList = coursesList;
    }


    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course_card,parent,false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, final int position) {
        holder.tvCourse.setText(coursesList.get(position).getCourseName());
        holder.tvTeacher.setText(coursesList.get(position).getTeacher());
        holder.tvClasses.setText(coursesList.get(position).getClasses().toString());
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coursesList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder{
        TextView tvCourse,tvTeacher,tvClasses;
        ImageView ivDelete;
        public CourseViewHolder(View itemView) {
            super(itemView);
            tvCourse = (TextView) itemView.findViewById(R.id.tvCourse);
            tvTeacher = (TextView) itemView.findViewById(R.id.tvTeacher);
            tvClasses = (TextView) itemView.findViewById(R.id.tvClasses);
            ivDelete = (ImageView) itemView.findViewById(R.id.ivDelete);
        }
    }
}
