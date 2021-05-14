package com.jorge.nossoscursos;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jorge.nossoscursos.data.entity.Aluno;
import com.jorge.nossoscursos.data.entity.Curso;

import java.util.List;

public class ActivityHomeViewModel extends ViewModel {

    private MutableLiveData<List<Aluno>> _studentsList;

    public LiveData<List<Aluno>> studentsList() {
        if (_studentsList == null) {
            _studentsList = new MutableLiveData<List<Aluno>>();
        }
        return _studentsList;
    }

    private MutableLiveData<List<Curso>> _coursesList;

    public LiveData<List<Curso>> coursesList() {
        if (_coursesList == null) {
            _coursesList = new MutableLiveData<List<Curso>>();
        }
        return _coursesList;
    }


}
