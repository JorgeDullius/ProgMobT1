package com.jorge.nossoscursos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jorge.nossoscursos.data.entity.Curso;
import com.jorge.nossoscursos.data.entity.CursoAlunos;
import com.jorge.nossoscursos.databinding.FragmentRegisterCourseBinding;

public class RegisterCourseBottonSheetFragment extends BottomSheetDialogFragment {

    private FragmentRegisterCourseBinding binding;
    private ActivityHomeViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getActivity()).get(ActivityHomeViewModel.class);
        binding = FragmentRegisterCourseBinding.inflate(inflater);
        setupUi();
        return binding.getRoot();
    }

    private void setupUi() {
        Bundle arguments = getArguments();
        Curso curso;

        if (arguments != null) {
            int courseId = arguments.getInt("courseId");
            curso = viewModel.coursesList().getValue().get(courseId).curso;

            binding.submitButton.setOnClickListener(view -> {
                curso.nome = binding.courseNameEditText.getText().toString();
                curso.qtdeHoras = Integer.valueOf(binding.courseHoursEditText.getText().toString());

                viewModel.updateCourse(curso);
                dismiss();
            });

            binding.courseNameEditText.setText(curso.nome);
            binding.courseHoursEditText.setText(String.valueOf(curso.qtdeHoras));
            binding.submitButton.setText("Salvar");
            binding.courseName.setText("Editar curso");
        } else {
            binding.submitButton.setOnClickListener(view -> {
                viewModel.registerCourse(
                        binding.courseNameEditText.getText().toString(),
                        Integer.parseInt(binding.courseHoursEditText.getText().toString())
                );

                dismiss();
            });
        }
    }
}
