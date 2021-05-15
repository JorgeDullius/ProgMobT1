package com.jorge.nossoscursos;

import android.app.Application;

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
            _studentsList = new MutableLiveData<List<Aluno>>(NossosCursosApplication.database.alunoDao().getAll());
        }
        return _studentsList;
    }

    private MutableLiveData<List<CursoAlunos>> _coursesList;

    public LiveData<List<CursoAlunos>> coursesList() {
        if (_coursesList == null) {
            _coursesList = new MutableLiveData<List<CursoAlunos>>(NossosCursosApplication.database.cursoDao().getAllAndAlunos());
        }
        return _coursesList;
    }

    public void registerCourse(int id, String name, int hours){
        //registrar o curso
        //NossosCursosApplication.database.cursoDao().insert(new Curso(id, name, hours));
    }
}


