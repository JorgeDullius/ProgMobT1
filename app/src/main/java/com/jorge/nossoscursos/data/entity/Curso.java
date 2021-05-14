package com.jorge.nossoscursos.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Curso {
    @PrimaryKey
    @ColumnInfo(name = "cursoId", index=true)
    public int id;

    @ColumnInfo(name = "nomeCurso")
    @NonNull
    public String nome;

    @NonNull
    public int qtdeHoras;
}