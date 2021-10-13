package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    DatabaseHelper database;
    ArrayList<String> livro_id, livro_titulo, livro_autor, livro_paginas;
    CA custom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        database = new DatabaseHelper(MainActivity.this);
        livro_id = new ArrayList<>();
        livro_titulo = new ArrayList<>();
        livro_autor = new ArrayList<>();
        livro_paginas = new ArrayList<>();

        displayDataInArrays();

        custom = new CA(MainActivity.this, livro_id, livro_titulo, livro_autor, livro_autor, livro_paginas);
        recyclerView.setAdapter(custom);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }

    void displayDataInArrays(){
        Cursor cursor = database.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Sem dados", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                livro_id.add(cursor.getString(0));
                livro_titulo.add(cursor.getString(0));
                livro_autor.add(cursor.getString(0));
                livro_paginas.add(cursor.getString(0));

            }
        }
    }
}