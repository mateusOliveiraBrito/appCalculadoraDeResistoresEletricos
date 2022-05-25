package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ConceitosTeoricosActivity extends AppCompatActivity {

    private ScrollView _scrollViewConceitosTeoricos;

    private LinearLayout _layoutTelaResistorEletrico;
    private LinearLayout _layoutTelaAssociacaoDeResistores;
    private LinearLayout _layoutTelaDiferencaDePotencial;
    private LinearLayout _layoutTelaLeisDeOhm;
    private LinearLayout _layoutTelaResistenciaEquivalente;
    private LinearLayout _layoutTelaIntensidadeEletrica;

    private TextView _txtTelaResistorEletrico;
    private TextView _txtTelaAssociacaoDeResistores;
    private TextView _txtTelaDiferencaDePotencial;
    private TextView _txtTelaTelaLeisDeOhm;
    private TextView _txtTelaResistenciaEquivalente;
    private TextView _txtTelaIntensidadeEletrica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceitos_teoricos);

        _scrollViewConceitosTeoricos = findViewById(R.id.scrollViewConceitosTeoricos);

        _layoutTelaResistorEletrico = findViewById(R.id.layoutTelaConceitoResistor);
        _layoutTelaAssociacaoDeResistores = findViewById(R.id.layoutTelaConceitoAssociacaoDeResistores);
        _layoutTelaDiferencaDePotencial = findViewById(R.id.layoutTelaConceitoDdp);
        _layoutTelaLeisDeOhm = findViewById(R.id.layoutTelaConceitoLeiDeOhm);
        _layoutTelaResistenciaEquivalente = findViewById(R.id.layoutTelaConceitoResistenciaEq);
        _layoutTelaIntensidadeEletrica = findViewById(R.id.layoutTelaConceitoIntensidadeEletrica);

        _txtTelaResistorEletrico = findViewById(R.id.txtConceitoResistores);
        _txtTelaAssociacaoDeResistores = findViewById(R.id.txtConceitoAssociacaoDeResistores);
        _txtTelaDiferencaDePotencial = findViewById(R.id.txtConceitoDdp);
        _txtTelaTelaLeisDeOhm = findViewById(R.id.txtConceitoLeiDeOhm);
        _txtTelaResistenciaEquivalente = findViewById(R.id.txtConceitoResistenciaEq);
        _txtTelaIntensidadeEletrica = findViewById(R.id.txtConceitoIntensidadeEletrica);

        definirListenerParaClickLayoutTelaDeConceitoResistorEletrico();
        definirListenerParaClickLayoutTelaDeConceitoAssociacaoDeResistores();
        definirListenerParaClickLayoutTelaDeConceitoDiferencaDePotencial();
        definirListenerParaClickLayoutTelaDeConceitoLeisDeOhm();
        definirListenerParaClickLayoutTelaDeConceitoResistencaEquivalente();
        definirListenerParaClickLayoutTelaDeConceitoIntensidadeEletrica();
    }

    private void definirListenerParaClickLayoutTelaDeConceitoResistorEletrico() {
        _layoutTelaResistorEletrico.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        _layoutTelaResistorEletrico.setBackground(getResources().getDrawable(R.drawable.shape_pressed));
                        _txtTelaResistorEletrico.setTextColor(Color.WHITE);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        _layoutTelaResistorEletrico.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaResistorEletrico.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        abrirTelaDefinicaoResistor();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        _layoutTelaResistorEletrico.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaResistorEletrico.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void definirListenerParaClickLayoutTelaDeConceitoAssociacaoDeResistores() {
        _layoutTelaAssociacaoDeResistores.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        _layoutTelaAssociacaoDeResistores.setBackground(getResources().getDrawable(R.drawable.shape_pressed));
                        _txtTelaAssociacaoDeResistores.setTextColor(Color.WHITE);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        _layoutTelaAssociacaoDeResistores.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaAssociacaoDeResistores.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        abrirTelaDefinicaoAssociacaoDeResistores();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        _layoutTelaAssociacaoDeResistores.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaAssociacaoDeResistores.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void definirListenerParaClickLayoutTelaDeConceitoDiferencaDePotencial() {
        _layoutTelaDiferencaDePotencial.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        _layoutTelaDiferencaDePotencial.setBackground(getResources().getDrawable(R.drawable.shape_pressed));
                        _txtTelaDiferencaDePotencial.setTextColor(Color.WHITE);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        _layoutTelaDiferencaDePotencial.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaDiferencaDePotencial.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        abrirTelaDefinicaoDiferencaDePotencial();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        _layoutTelaDiferencaDePotencial.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaDiferencaDePotencial.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void definirListenerParaClickLayoutTelaDeConceitoLeisDeOhm() {
        _layoutTelaLeisDeOhm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        _layoutTelaLeisDeOhm.setBackground(getResources().getDrawable(R.drawable.shape_pressed));
                        _txtTelaTelaLeisDeOhm.setTextColor(Color.WHITE);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        _layoutTelaLeisDeOhm.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaTelaLeisDeOhm.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        abrirTelaDefinicaoLeisDeOhm();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        _layoutTelaLeisDeOhm.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaTelaLeisDeOhm.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void definirListenerParaClickLayoutTelaDeConceitoResistencaEquivalente() {
        _layoutTelaResistenciaEquivalente.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        _layoutTelaResistenciaEquivalente.setBackground(getResources().getDrawable(R.drawable.shape_pressed));
                        _txtTelaResistenciaEquivalente.setTextColor(Color.WHITE);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        _layoutTelaResistenciaEquivalente.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaResistenciaEquivalente.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        abrirTelaDefinicaoResistenciaEquivalente();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        _layoutTelaResistenciaEquivalente.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaResistenciaEquivalente.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void definirListenerParaClickLayoutTelaDeConceitoIntensidadeEletrica() {
        _layoutTelaIntensidadeEletrica.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        _layoutTelaIntensidadeEletrica.setBackground(getResources().getDrawable(R.drawable.shape_pressed));
                        _txtTelaIntensidadeEletrica.setTextColor(Color.WHITE);
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        _layoutTelaIntensidadeEletrica.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaIntensidadeEletrica.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        abrirTelaDefinicaoIntensidadeEletrica();
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        _layoutTelaIntensidadeEletrica.setBackground(getResources().getDrawable(R.drawable.shape));
                        _txtTelaIntensidadeEletrica.setTextColor(ContextCompat.getColor(ConceitosTeoricosActivity.this, R.color.secondary_text));
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void abrirTelaDefinicaoResistor() {
        Intent definicaoResistor = new Intent(ConceitosTeoricosActivity.this, DefinicaoResistorEletricoActivity.class);
        startActivity(definicaoResistor);
    }

    private void abrirTelaDefinicaoAssociacaoDeResistores() {
        Intent definicaoAssociacaoDeResistores = new Intent(ConceitosTeoricosActivity.this, DefinicaoAssociacaoDeResistoresActivity.class);
        startActivity(definicaoAssociacaoDeResistores);
    }

    private void abrirTelaDefinicaoDiferencaDePotencial() {
        Intent definicaoDiferencaDePotencial = new Intent(ConceitosTeoricosActivity.this, DefinicaoDiferencaDePotencialActivity.class);
        startActivity(definicaoDiferencaDePotencial);
    }

    private void abrirTelaDefinicaoLeisDeOhm() {
        Intent definicaoLeisDeOhm = new Intent(ConceitosTeoricosActivity.this, DefinicaoLeisDeOhmActivity.class);
        startActivity(definicaoLeisDeOhm);
    }

    private void abrirTelaDefinicaoResistenciaEquivalente() {
        Intent definicaoResistenciaEquivalente = new Intent(ConceitosTeoricosActivity.this, DefinicaoResistenciaEquivalenteActivity.class);
        startActivity(definicaoResistenciaEquivalente);
    }

    private void abrirTelaDefinicaoIntensidadeEletrica() {
        Intent definicaoIntensidadeEletrica = new Intent(ConceitosTeoricosActivity.this, DefinicaoIntensidadeEletricaActivity.class);
        startActivity(definicaoIntensidadeEletrica);
    }
}