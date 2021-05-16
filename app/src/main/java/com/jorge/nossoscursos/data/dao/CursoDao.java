package com.jorge.nossoscursos.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.jorge.nossoscursos.data.entity.Aluno;
import com.jorge.nossoscursos.data.entity.Curso;
import com.jorge.nossoscursos.data.entity.CursoAlunos;

import java.util.List;

@Dao
public interface CursoDao {
    @Query("SELECT * FROM Curso")
    List<Curso> getAll();

    @Transaction
    @Query("SELECT * FROM Curso")
    List<CursoAlunos> getAllAndAlunos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Curso curso);

    @Update
    public void update(Curso curso);

    @Query("DELETE FROM Curso WHERE cursoId = :id AND NOT EXISTS (SELECT * FROM Aluno WHERE cursoId = :id)")
    void delete(int id);
}
