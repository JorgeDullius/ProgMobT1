package com.jorge.nossoscursos;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.jorge.nossoscursos.databinding.ActivityHomeBinding;

public class ActivityHome extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupUi();
    }

    private void setupUi() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.page_1:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentCourses()).commit();
                    return true;
                case R.id.page_2:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentStudents()).commit();
                    return true;
            }
            return false;
        });
        binding.bottomNavigation.setSelectedItemId(R.id.page_1);
    }
}
