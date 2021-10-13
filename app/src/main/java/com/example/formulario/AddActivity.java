package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText tittulo_input, autor_input, paginas_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        tittulo_input = findViewById(R.id.titulo_input);
        autor_input = findViewById(R.id.autor_input);
        paginas_input = findViewById(R.id.paginas_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper database = new DatabaseHelper(AddActivity.this);
                database.addLivro(tittulo_input.getText().toString().trim(),
                        autor_input.getText().toString().trim(),
                        Integer.valueOf(paginas_input.getText().toString().trim()));
            }
        });
    }
}