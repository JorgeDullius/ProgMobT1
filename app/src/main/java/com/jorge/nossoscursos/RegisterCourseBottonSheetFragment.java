package com.jorge.nossoscursos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
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
        return binding.getRoot();
    }

    private void setupUi(){
        binding.submitButton.setOnClickListener(view -> {} /*chamar metodo de registrar da viewmodel*/);
    }
}
