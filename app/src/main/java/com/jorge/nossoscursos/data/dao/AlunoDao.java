package com.jorge.nossoscursos.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jorge.nossoscursos.data.entity.Aluno;
import com.jorge.nossoscursos.data.entity.Curso;

import java.util.List;

@Dao
public interface AlunoDao {
    @Query("SELECT * FROM Aluno")
    List<Aluno> getAll();

    @Query("SELECT * FROM Aluno WHERE cursoId LIKE :cursoId")
    List<Aluno> getByCurso(int cursoId);

    @Update
    public void update(Aluno aluno);

    @Insert
    void insert(Aluno alunos);

    @Delete
    void delete(Aluno aluno);
}
