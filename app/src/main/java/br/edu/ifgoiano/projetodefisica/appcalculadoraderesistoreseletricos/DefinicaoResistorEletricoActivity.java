package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DefinicaoResistorEletricoActivity extends AppCompatActivity {

    private TextView _urlResistores;
    private TextView _urlVaristor;
    private TextView _urlDesenhoResistor;
    private TextView _urlTabelaDeCores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definicao_resistor_eletrico);

        _urlResistores = findViewById(R.id.urlResistores);
        _urlResistores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginaWeb("https://media.istockphoto.com/photos/resistors-against-a-white-background-picture-id172924172?k=20&m=172924172&s=612x612&w=0&h=3HYOxChjGEfnY_4ShJTZPqqaHihyYLPhl14OREoqU-w=");
            }
        });

        _urlVaristor = findViewById(R.id.urlVaristor);
        _urlVaristor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginaWeb("https://static.mundoeducacao.uol.com.br/mundoeducacao/2020/02/varistor.jpg");
            }
        });

        _urlDesenhoResistor = findViewById(R.id.urlDesenhoResistor);
        _urlDesenhoResistor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginaWeb("https://noic.com.br/wp-content/uploads/2020/06/images-1.png");
            }
        });

        _urlTabelaDeCores = findViewById(R.id.urlTabelaDeCores);
        _urlTabelaDeCores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginaWeb("https://www.mundodaeletrica.com.br/y/766/3-faixas.jpg");
            }
        });
    }

    private void abrirPaginaWeb(String url){
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse(url));
        startActivity(browser);
    }
}