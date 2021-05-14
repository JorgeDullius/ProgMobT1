package com.jorge.nossoscursos.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.jorge.nossoscursos.data.entity.Aluno;

import java.util.List;

@Dao
public interface AlunoDao {
    @Query("SELECT * FROM Aluno")
    List<Aluno> getAll();

    @Insert
    void insertAll(Aluno... alunos);

    @Delete
    void delete(Aluno aluno);
}
