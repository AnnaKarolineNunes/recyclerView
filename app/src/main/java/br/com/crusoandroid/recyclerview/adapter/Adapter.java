package br.com.crusoandroid.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.crusoandroid.recyclerview.R;
import br.com.crusoandroid.recyclerview.model.Filme;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Filme> listaFilmes;

    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) { //nome da classe
        View itemLista = LayoutInflater.from(parent.getContext()) // converter o XML em uma visualização
                .inflate(R.layout.adapter_lista,parent,false);
        return new MyViewHolder(itemLista); // criou o objeto e passou o item lista
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) { // visualizaçao dos itens criados

        Filme filme = listaFilmes.get(position); // com todas as posiçoes de forma dinamica
        holder.titulo.setText(filme.getTitulo());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size(); // tamanho da lista
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView ano;
        TextView genero;

        public MyViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
