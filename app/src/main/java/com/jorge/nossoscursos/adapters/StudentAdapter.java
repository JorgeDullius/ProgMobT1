package com.jorge.nossoscursos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.jorge.nossoscursos.R;
import com.jorge.nossoscursos.data.entity.Aluno;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Aluno> {
    public StudentAdapter(@NonNull Context context, List<Aluno> resource) {
        super(context, 0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno student = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_student, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.student_name);
        TextView tvCpf = (TextView) convertView.findViewById(R.id.cpf);
        TextView tvEmail = (TextView) convertView.findViewById(R.id.email);

        tvName.setText(student.nome);
        tvCpf.setText(student.cpf);
        tvEmail.setText(student.email);

        return convertView;
    }
}
