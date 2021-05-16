package com.jorge.nossoscursos.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jorge.nossoscursos.ActivityHomeViewModel;
import com.jorge.nossoscursos.R;
import com.jorge.nossoscursos.RegisterCourseBottonSheetFragment;
import com.jorge.nossoscursos.data.entity.CursoAlunos;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<CursoAlunos> {
    private ActivityHomeViewModel viewModel;

    public CourseAdapter(@NonNull Context context, List<CursoAlunos> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CursoAlunos course = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_course, parent, false);
        }

        AppCompatActivity activity = (AppCompatActivity) convertView.getContext();

        convertView.setOnClickListener(view -> {
            RegisterCourseBottonSheetFragment editCourse = new RegisterCourseBottonSheetFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("courseId", position);

            editCourse.setArguments(bundle);
            editCourse.show(activity.getSupportFragmentManager(), null);
        });

        viewModel = new ViewModelProvider(activity).get(ActivityHomeViewModel.class);

        TextView tvName = convertView.findViewById(R.id.course_name);
        TextView tvHours = convertView.findViewById(R.id.hours);
        TextView tvNumberStudents = convertView.findViewById(R.id.number_of_students);
        ImageButton deleteCourseButton = convertView.findViewById(R.id.delete_course_button);

        tvName.setText(course.curso.nome);
        tvHours.setText(course.curso.qtdeHoras + " horas");
        tvNumberStudents.setText(course.alunos.size() + " aluno(s)");

        deleteCourseButton.setOnClickListener(l -> {
            if (course.alunos.size() > 0) {
                new AlertDialog.Builder(getContext())
                        .setTitle("Não foi possível remover o curso")
                        .setMessage("Existem alunos vinculados a ele")
                        .setNeutralButton("OK", (dialog, id) -> dialog.dismiss())
                        .show();
                return;
            }
            viewModel.removeCourse(course.curso.id);
        });

        return convertView;
    }
}
