package com.jorge.nossoscursos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.jorge.nossoscursos.adapters.StudentAdapter;
import com.jorge.nossoscursos.data.entity.CursoAlunos;
import com.jorge.nossoscursos.databinding.FragmentEditCourseBinding;

public class FragmentEditCourse extends Fragment {

    private FragmentEditCourseBinding binding;
    private ActivityHomeViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentEditCourseBinding.inflate(getLayoutInflater(), container, false);

        int courseId = this.getArguments().getInt("courseId");

        viewModel = new ViewModelProvider(getActivity()).get(ActivityHomeViewModel.class);
        viewModel.coursesList().observe(getActivity(), cursos -> {
            CursoAlunos cursoAlunos = cursos.get(courseId);
            binding.courseName.setText(cursoAlunos.curso.nome);
            binding.courseHours.setText(String.valueOf(cursoAlunos.curso.qtdeHoras));

            StudentAdapter studentAdapter = new StudentAdapter(getContext(), cursoAlunos.alunos);
            binding.courseStudentsGrid.setAdapter(studentAdapter);
        });

        return binding.getRoot();
    }
}
