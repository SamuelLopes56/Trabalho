package com.example.formulario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Key;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Livraria.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "minha_livraria";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_titulo = "titulo";
    private static final String COLUMN_autor = "autor";
    private static final String COLUMN_paginas = "paginas";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTINGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_titulo + " TEXT, " +
                        COLUMN_autor + " TEXT, " +
                        COLUMN_paginas + " INTEGER) ;";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addLivro(String titulo, String autor, int paginas){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_titulo, titulo);
        cv.put(COLUMN_autor, autor);
        cv.put(COLUMN_paginas, paginas);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Deu ruim, algo de errado não está certo", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Livro adicionado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            db.rawQuery(query, null);
        }
        return cursor;
    }
}
