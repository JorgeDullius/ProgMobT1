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
public interface CursoDao {
    @Query("SELECT * FROM Curso")
    List<Curso> getAll();

    @Insert
    void insert(Curso curso);

    @Update
    public void update(Curso curso);

    @Delete
    void delete(Curso curso);
}
