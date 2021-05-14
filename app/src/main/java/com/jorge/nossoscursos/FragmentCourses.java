package com.jorge.nossoscursos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.jorge.nossoscursos.adapters.CourseAdapter;
import com.jorge.nossoscursos.data.entity.CursoAlunos;
import com.jorge.nossoscursos.databinding.FragmentCoursesBinding;

import java.util.List;

public class FragmentCourses extends Fragment {

    private FragmentCoursesBinding binding;
    private ActivityHomeViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentCoursesBinding.inflate(getLayoutInflater(), container, false);

        viewModel = new ViewModelProvider(getActivity()).get(ActivityHomeViewModel.class);
        viewModel.coursesList().observe(getActivity(), cursos -> {
            CourseAdapter arrayAdapter = new CourseAdapter(getActivity(), cursos);
            binding.coursesGrid.setAdapter(arrayAdapter);
        });

        return binding.getRoot();
    }
}
