package com.example.formulario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CA extends RecyclerView.Adapter<CA.MyViewHolder> {

    private Context context;
    private ArrayList livro_id, livro_titulo, livro_autor, livro_paginas;

    CA(Context context, ArrayList<String> livroId, ArrayList livro_id, ArrayList livro_titulo, ArrayList livro_autor, ArrayList livro_paginas){
        this.context = context;
        this.livro_id = livro_id;
        this.livro_titulo = livro_titulo;
        this.livro_autor = livro_autor;
        this.livro_paginas = livro_paginas;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.livro_id_txt.setText(String.valueOf(livro_id.get(position)));
        holder.livro_titulo_txt.setText(String.valueOf(livro_titulo.get(position)));
        holder.livro_autor_txt.setText(String.valueOf(livro_autor.get(position)));
        holder.livro_paginas_txt.setText(String.valueOf(livro_paginas.get(position)));

    }

    @Override
    public int getItemCount() {
        return livro_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView livro_id_txt, livro_titulo_txt, livro_autor_txt, livro_paginas_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            livro_id_txt = itemView.findViewById(R.id.livro_id_txt);
            livro_titulo_txt = itemView.findViewById(R.id.livro_titulo_txt);
            livro_autor_txt = itemView.findViewById(R.id.livro_autor_txt);
            livro_paginas_txt = itemView.findViewById(R.id.livro_paginas_txt);
        }
    }
}
