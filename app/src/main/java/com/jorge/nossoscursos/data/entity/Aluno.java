package com.jorge.nossoscursos.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName="Aluno",
        foreignKeys={@ForeignKey(entity = Curso.class,
                parentColumns = "cursoId",
                childColumns = "cursoId",
                onDelete = ForeignKey.CASCADE)
        }
)
public class Aluno {
    @PrimaryKey
    @ColumnInfo(name = "alunoId")
    public int id;

    public int cursoId;

    @ColumnInfo(name = "nomeAluno")
    public String nome;

    public String cpf;
    public String email;
    public String telefone;
}