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
import com.jorge.nossoscursos.databinding.FragmentStudentsBinding;

public class FragmentStudents extends Fragment {

    private FragmentStudentsBinding binding;
    private ActivityHomeViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentStudentsBinding.inflate(getLayoutInflater(), container, false);

        viewModel = new ViewModelProvider(getActivity()).get(ActivityHomeViewModel.class);
        viewModel.studentsList().observe(getActivity(), alunos -> {
            StudentAdapter arrayAdapter = new StudentAdapter(getActivity(), alunos);
            binding.studentsGrid.setAdapter(arrayAdapter);
        });
        setupUi();
        return binding.getRoot();
    }

    private void setupUi() {
        RegisterStudentBottomSheetFragment fragment = new RegisterStudentBottomSheetFragment();
        binding.addStudentFloatingButton.setOnClickListener(
            view -> fragment.show(requireActivity().getSupportFragmentManager(),
                null)
        );
    }
}
