package com.jorge.nossoscursos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

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

        TextView tvName = (TextView) convertView.findViewById(R.id.course_name);
        TextView tvHours = (TextView) convertView.findViewById(R.id.hours);
        TextView tvNumberStudents = (TextView) convertView.findViewById(R.id.number_of_students);

        tvName.setText(course.curso.nome);
        tvHours.setText(course.curso.qtdeHoras + " horas");
        tvNumberStudents.setText(course.alunos.size() + " aluno(s)");

        return convertView;
    }
}
