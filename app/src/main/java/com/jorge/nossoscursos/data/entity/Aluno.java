package com.jorge.nossoscursos.data.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "Aluno",
    foreignKeys = {
        @ForeignKey(
            entity = Curso.class,
            parentColumns = "cursoId",
            childColumns = "cursoId"
           // onDelete = ForeignKey.CASCADE
        )
    }
)
public class Aluno {
    @PrimaryKey
    @ColumnInfo(name = "alunoId")
    public int id;

    public Integer cursoId;

    @ColumnInfo(name = "nomeAluno")
    @NonNull
    public String nome;

    @NonNull
    public String cpf;

    @NonNull
    public String email;

    @NonNull
    public String telefone;
}