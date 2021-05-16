package com.jorge.nossoscursos;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jorge.nossoscursos.data.entity.Aluno;
import com.jorge.nossoscursos.data.entity.Curso;
import com.jorge.nossoscursos.data.entity.CursoAlunos;

import java.util.List;

public class ActivityHomeViewModel extends ViewModel {

    private MutableLiveData<List<Aluno>> _studentsList;

    public LiveData<List<Aluno>> studentsList() {
        if (_studentsList == null) {
            _studentsList = new MutableLiveData<>();
            loadStudents();
        }
        return _studentsList;
    }

    private MutableLiveData<List<CursoAlunos>> _coursesList;

    public LiveData<List<CursoAlunos>> coursesList() {
        if (_coursesList == null) {
            _coursesList = new MutableLiveData<>();
            loadCourses();
        }
        return _coursesList;
    }

    public void loadStudents(){
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> _studentsList.setValue(NossosCursosApplication.database.alunoDao().getAll()), 1000);
    }

    public void loadCourses() {
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> _coursesList.setValue(NossosCursosApplication.database.cursoDao().getAllAndAlunos()), 1000);
    }

    public void registerCourse(String name, int hours) {
        Long curso = NossosCursosApplication.database.cursoDao().insert(new Curso(name, hours));
        System.out.println(curso);
        loadCourses();
    }
}


