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
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "alunoId")
    public int id;

    @ColumnInfo(index = true)
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

    public Aluno(){
        this.nome = "";
        this.cpf = "";
        this.email = "";
        this.telefone = "";
    }

    public Aluno(String name, String email, String cpf, String phoneNumber, Integer idCourse){
        this.nome = name;
        this.email = email;
        this.cpf = cpf;
        this.telefone = phoneNumber;
        this.cursoId = idCourse;
    }
}