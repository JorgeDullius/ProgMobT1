package com.jorge.nossoscursos.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.jorge.nossoscursos.FragmentCourses;
import com.jorge.nossoscursos.FragmentEditCourse;
import com.jorge.nossoscursos.FragmentStudents;
import com.jorge.nossoscursos.R;
import com.jorge.nossoscursos.data.entity.CursoAlunos;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<CursoAlunos> {
    public CourseAdapter(@NonNull Context context, List<CursoAlunos> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CursoAlunos course = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_course, parent, false);
        }

        convertView.setOnClickListener(view -> {
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            FragmentEditCourse editCourse = new FragmentEditCourse();

            Bundle bundle = new Bundle();
            bundle.putInt("courseId", position);

            editCourse.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, editCourse).commit();
        });

        TextView tvName = convertView.findViewById(R.id.course_name);
        TextView tvHours = convertView.findViewById(R.id.hours);
        TextView tvNumberStudents = convertView.findViewById(R.id.number_of_students);

        tvName.setText(course.curso.nome);
        tvHours.setText(course.curso.qtdeHoras + " horas");
        tvNumberStudents.setText(course.alunos.size() + " aluno(s)");

        return convertView;
    }
}
