package com.cs.regista;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    ArrayList<StudentInfo> studentInfos;
    Context context;

    public StudentAdapter(Context context, ArrayList<StudentInfo> studentInfos) {
        this.studentInfos = studentInfos;
        this.context = context;
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder{
    TextView studentName;
    TextView studentRoll;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName =itemView.findViewById(R.id.sname);
            studentRoll =itemView.findViewById(R.id.sroll);
        }
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View infoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.s_info,parent,false);
        return new StudentViewHolder(infoView);
    }

    @Override
    public void onBindViewHolder(@NonNull  StudentAdapter.StudentViewHolder holder, int position) {
        holder.studentName.setText(studentInfos.get(position).getSname());
        holder.studentRoll.setText(studentInfos.get(position).getSroll());

    }

    @Override
    public int getItemCount() {
        return studentInfos.size();
    }
}
