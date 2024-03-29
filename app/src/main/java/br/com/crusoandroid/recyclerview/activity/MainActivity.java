package br.com.crusoandroid.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.crusoandroid.recyclerview.R;
import br.com.crusoandroid.recyclerview.RecyclerItemClickListener;
import br.com.crusoandroid.recyclerview.adapter.Adapter;
import br.com.crusoandroid.recyclerview.model.Filme;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de filmes
        this.criarFilmes();

        // configurar adapter
        Adapter adapter = new Adapter(listaFilmes); // adapter instanciado



        // configurar recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); // metodo que otimiza, tendo um tamanho fixo
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL)); // linha divisória
        recyclerView.setAdapter(adapter);


        //evento de clique
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(),
                                    "Item pressionado: " + filme.getTitulo(),
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position); // objeto criado
                            Toast.makeText(getApplicationContext(),
                                    "Clique longo: " + filme.getTitulo(),
                                    Toast.LENGTH_SHORT)
                                    .show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

    }
     public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha - De volta ao lar","genero","2017");
        this.listaFilmes.add(filme);

         filme = new Filme("Mulher Maravilha" , "Fantasia","2017");
         this.listaFilmes.add(filme);

         filme = new Filme("Liga da Justiça" , "Ficção","2017");
         this.listaFilmes.add(filme);

         filme = new Filme("Capitão América - Guerra Civil" , "Aventura","2016");
         this.listaFilmes.add(filme);

         filme = new Filme("It: A coisa" , "drama/terror","2017");
         this.listaFilmes.add(filme);

         filme = new Filme("Pica Pau- O filme" , "Comédia/Animação","2017");
         this.listaFilmes.add(filme);

         filme = new Filme("A múmia " , "Terror","2017");
         this.listaFilmes.add(filme);

         filme = new Filme("A bela e Fera" , "Romance","2017");
         this.listaFilmes.add(filme);

         filme = new Filme("Meu malvado favorito 3 " , "Comédia","2017");
         this.listaFilmes.add(filme);

         filme = new Filme("Carros 3 " , "Comédia","2017");
         this.listaFilmes.add(filme);
     }
}