package com.jorge.nossoscursos.data.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CursoAlunos {
    @Embedded
    public Curso curso;
    @Relation(
            parentColumn = "cursoId",
            entityColumn = "cursoId"
    )
    public List<Aluno> alunos;
}