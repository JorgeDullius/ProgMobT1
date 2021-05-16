package com.jorge.nossoscursos.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Curso {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cursoId", index=true)
    @NonNull
    public Integer id;

    @ColumnInfo(name = "nomeCurso")
    @NonNull
    public String nome;

    @NonNull
    public int qtdeHoras;

    public Curso(){
        this("", 0);
    }

    public Curso(String name, int hours) {
        this.nome = name;
        this.qtdeHoras = hours;
    }
}