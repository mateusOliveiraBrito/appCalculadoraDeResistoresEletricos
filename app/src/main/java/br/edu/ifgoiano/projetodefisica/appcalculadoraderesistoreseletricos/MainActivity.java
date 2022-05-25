package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout _layoutTelaConceitos;
    private LinearLayout _layoutTelaCalculoEmSerie;
    private LinearLayout _layoutTelaCalculoEmParalelo;
    private TextView _txtConceitoTeorico;
    private TextView _txtCalculoEmSerie;
    private TextView _txtCalculoEmParalelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _layoutTelaConceitos = findViewById(R.id.layoutTelaConceitos);
        _layoutTelaCalculoEmSerie = findViewById(R.id.layoutTelaCalculoEmSerie);
        _layoutTelaCalculoEmParalelo = findViewById(R.id.layoutTelaCalculoEmParalelo);
        _txtConceitoTeorico = findViewById(R.id.txtConceitoTeorico);
        _txtCalculoEmSerie = findViewById(R.id.txtCalculoEmSerie);
        _txtCalculoEmParalelo = findViewById(R.id.txtCalculoEmParalelo);

        definirListenerParaClickLayoutTelaDeConceitos();
        definirListenerParaClickLayoutTelaDeCalculoEmSerie();
        definirListenerParaClickLayoutTelaDeCalculoEmParalelo();
    }

    private void definirListenerParaClickLayoutTelaDeConceitos() {
        _layoutTelaConceitos.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        _layoutTelaConceitos.setBackground(getResources().getDrawable(R.drawable.shape_pressed));
                        _txtConceitoTeorico.setTextColor(Color.WHITE);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        _layoutTelaConceitos.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtConceitoTeorico.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.secondary_text));
                        abrirTelaDeConceitosTeoricos();
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void abrirTelaDeConceitosTeoricos() {
        Intent conceito = new Intent(this, ConceitosTeoricosActivity.class);
        startActivity(conceito);
    }

    private void definirListenerParaClickLayoutTelaDeCalculoEmSerie() {
        _layoutTelaCalculoEmSerie.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        _layoutTelaCalculoEmSerie.setBackground(getResources().getDrawable(R.drawable.shape_pressed));
                        _txtCalculoEmSerie.setTextColor(Color.WHITE);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        _layoutTelaCalculoEmSerie.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtCalculoEmSerie.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.secondary_text));
                        abrirTelaDeCalculosEmSerie();
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void abrirTelaDeCalculosEmSerie() {
        Intent serie = new Intent(this, CalculosEmSerieActivity.class);
        startActivity(serie);
    }

    private void definirListenerParaClickLayoutTelaDeCalculoEmParalelo() {
        _layoutTelaCalculoEmParalelo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        _layoutTelaCalculoEmParalelo.setBackground(getResources().getDrawable(R.drawable.shape_pressed));
                        _txtCalculoEmParalelo.setTextColor(Color.WHITE);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        _layoutTelaCalculoEmParalelo.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtCalculoEmParalelo.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.secondary_text));
                        abrirTelaDeCalculosEmParalelo();
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void abrirTelaDeCalculosEmParalelo() {
        Intent paralelo = new Intent(this, CalculosEmParaleloActivity.class);
        startActivity(paralelo);
    }
}