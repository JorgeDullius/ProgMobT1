package com.jorge.nossoscursos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jorge.nossoscursos.databinding.FragmentCoursesBinding;

public class FragmentCourses extends Fragment {

    private FragmentCoursesBinding binding;

    @Nullable
    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState
    ) {
        binding = FragmentCoursesBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
}
