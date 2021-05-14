package com.jorge.nossoscursos.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.jorge.nossoscursos.data.entity.Curso;

import java.util.List;

@Dao
public interface CursoDao {
    @Query("SELECT * FROM Curso")
    List<Curso> getAll();

    @Insert
    void insertAll(Curso... curso);

    @Delete
    void delete(Curso curso);
}
