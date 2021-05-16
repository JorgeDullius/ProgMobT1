package com.jorge.nossoscursos.adapters;

import android.content.Context;
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
import com.jorge.nossoscursos.RegisterStudentBottomSheetFragment;
import com.jorge.nossoscursos.data.entity.Aluno;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Aluno> {
    private ActivityHomeViewModel viewModel;

    public StudentAdapter(@NonNull Context context, List<Aluno> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno student = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_student, parent, false);
        }

        AppCompatActivity activity = (AppCompatActivity) convertView.getContext();

        convertView.setOnClickListener(view -> {
            RegisterStudentBottomSheetFragment editStudent = new RegisterStudentBottomSheetFragment();

            Bundle bundle = new Bundle();
            bundle.putInt("studentId", position);

            editStudent.setArguments(bundle);
            editStudent.show(activity.getSupportFragmentManager(), null);
        });

        viewModel = new ViewModelProvider(activity).get(ActivityHomeViewModel.class);

        TextView tvName = convertView.findViewById(R.id.student_name);
        TextView tvCpf = convertView.findViewById(R.id.cpf);
        TextView tvEmail = convertView.findViewById(R.id.email);
        ImageButton deleteStudentButton = convertView.findViewById(R.id.delete_student_button);

        tvName.setText(student.nome);
        tvCpf.setText(student.cpf);
        tvEmail.setText(student.email);

        deleteStudentButton.setOnClickListener(l -> {
            viewModel.removeStudent(student.id);
        });

        return convertView;
    }
}
