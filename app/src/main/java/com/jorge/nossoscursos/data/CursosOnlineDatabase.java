package com.jorge.nossoscursos.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jorge.nossoscursos.data.dao.AlunoDao;
import com.jorge.nossoscursos.data.dao.CursoDao;
import com.jorge.nossoscursos.data.entity.Aluno;
import com.jorge.nossoscursos.data.entity.Curso;

@Database(entities = {Aluno.class, Curso.class}, version = CursosOnlineDatabase.DB_VERSION)
public abstract class CursosOnlineDatabase extends RoomDatabase {
    public abstract AlunoDao alunoDao();
    public abstract CursoDao cursoDao();

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "cursosonline.db";

    public static CursosOnlineDatabase build(Context context) {
        return Room.databaseBuilder(context, CursosOnlineDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .createFromAsset("database/cursosonline.db")
                .build();
    }
}
