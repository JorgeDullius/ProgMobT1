package com.jorge.nossoscursos;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.jorge.nossoscursos.data.entity.Aluno;
import com.jorge.nossoscursos.data.entity.Curso;
import com.jorge.nossoscursos.data.entity.CursoAlunos;
import com.jorge.nossoscursos.databinding.FragmentRegisterStudentFragmentBinding;

public class RegisterStudentBottomSheetFragment extends BottomSheetDialogFragment {

    private FragmentRegisterStudentFragmentBinding binding;
    private ActivityHomeViewModel viewModel;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getActivity()).get(ActivityHomeViewModel.class);
        binding = FragmentRegisterStudentFragmentBinding.inflate(inflater);
        viewModel.coursesList().observe(getActivity(), cursos -> {
            String[] localCourses = cursos.stream().map(CursoAlunos::getCourseName).toArray(String[]::new);
            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(requireContext(), R.layout.support_simple_spinner_dropdown_item, localCourses);

            binding.availableCoursesSpinner.setAdapter(
                spinnerArrayAdapter
            );
        });
        setupUi();
        return binding.getRoot();
    }

    private void setupUi() {
        Bundle arguments = getArguments();
        Aluno student;

        if (arguments != null) {
            int studentId = arguments.getInt("studentId");
            student = viewModel.studentsList().getValue().get(studentId);

            binding.submitButton.setOnClickListener(view -> {
                CursoAlunos course = viewModel.coursesList().getValue().get(binding.availableCoursesSpinner.getSelectedItemPosition());

                student.nome = binding.studentNameEditText.getText().toString();
                student.cpf = binding.studentCpfEditText.getText().toString();
                student.telefone = binding.studentPhoneEditText.getText().toString();
                student.email = binding.studentEmailEditText.getText().toString();
                student.cursoId = course.curso.id;

                viewModel.updateStudent(student);
                dismiss();
            });

            binding.studentNameEditText.setText(student.nome);
            binding.studentEmailEditText.setText(student.email);
            binding.studentCpfEditText.setText(student.cpf);
            binding.studentPhoneEditText.setText(student.telefone);
            // TODO: Set student current course
            binding.availableCoursesSpinner.setSelection(0);
            binding.addStudent.setText("Editar aluno");
            binding.submitButton.setText("Salvar");
        } else {
            binding.submitButton.setOnClickListener(view -> {
                CursoAlunos course = viewModel.coursesList().getValue().get(binding.availableCoursesSpinner.getSelectedItemPosition());
                viewModel.registerStudent(
                        binding.studentNameEditText.getText().toString(),
                        binding.studentEmailEditText.getText().toString(),
                        binding.studentCpfEditText.getText().toString(),
                        binding.studentPhoneEditText.getText().toString(),
                        course.curso.id
                );
                dismiss();
            });
        }
    }
}
