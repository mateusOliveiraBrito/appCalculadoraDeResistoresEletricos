package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

import br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos.beans.Resistor;

public class CalculoResistenciaEquivalenteEmSerieActivity extends AppCompatActivity {

    private Pair[] _unidadesDeMedidaEmNumeros = new Pair[]{
            new Pair<String, Double>("MΩ", 0.000001),
            new Pair<String, Double>("KΩ", 0.001),
            new Pair<String, Double>("Ω", 1.0),
            new Pair<String, Double>("mΩ", 1000.0),
            new Pair<String, Double>("μΩ", 1000000.0),
            new Pair<String, Double>("nΩ", 1000000000.0)
    };

    private Spinner _spnUnidadeResistencia;
    private String[] _unidadesDeResistencia = {"MΩ", "KΩ", "Ω", "mΩ", "μΩ", "nΩ"};
    private ArrayList<Resistor> _resistores = new ArrayList<Resistor>();
    private TextView _txtQtdResistores;
    private TextView _txtReqEmDiferentesUnidades;
    private TextView _urlResistorAssociadosEmSerie;

    private Double _resultadoEmMegaOhm = 0d;
    private Double _resultadoEmKiloOhm = 0d;
    private Double _resultadoEmOhm = 0d;
    private Double _resultadoEmMiliOhm = 0d;
    private Double _resultadoEmMicroOhm = 0d;
    private Double _resultadoEmNanoOhm = 0d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_resistencia_equivalente_em_serie);

        _urlResistorAssociadosEmSerie = findViewById(R.id.urlResistorAssociadosEmSerie);
        _txtQtdResistores = findViewById(R.id.txtResultadoReqSerieQtdResistores);
        _txtReqEmDiferentesUnidades = findViewById(R.id.txtReqEmDiferentesUnidades);
        _spnUnidadeResistencia = findViewById(R.id.spnUnidadeResistenciaResultado);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, _unidadesDeResistencia);
        _spnUnidadeResistencia.setAdapter(adapter);

        _spnUnidadeResistencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String unidadeSelecionada = _spnUnidadeResistencia.getSelectedItem().toString();

                if (unidadeSelecionada.equals("MΩ")) {
                    _txtReqEmDiferentesUnidades.setText(_resultadoEmMegaOhm + " MΩ");
                }

                if (unidadeSelecionada.equals("KΩ")) {
                    _txtReqEmDiferentesUnidades.setText(_resultadoEmKiloOhm + " KΩ");
                }

                if (unidadeSelecionada.equals("Ω")) {
                    _txtReqEmDiferentesUnidades.setText(_resultadoEmOhm + " Ω");
                }

                if (unidadeSelecionada.equals("mΩ")) {
                    _txtReqEmDiferentesUnidades.setText(_resultadoEmMiliOhm + " mΩ");
                }

                if (unidadeSelecionada.equals("μΩ")) {
                    _txtReqEmDiferentesUnidades.setText(_resultadoEmMicroOhm + " μΩ");
                }

                if (unidadeSelecionada.equals("nΩ")) {
                    _txtReqEmDiferentesUnidades.setText(_resultadoEmNanoOhm + " nΩ");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        _spnUnidadeResistencia.setSelection(2);

        Intent intent = getIntent();

        _txtQtdResistores.setText(intent.getStringExtra("quantidadeDeResistores"));
        jsonToResistores(intent.getStringExtra("resistores"));

        calcularResistenciaEquivalente();

        _urlResistorAssociadosEmSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginaWeb("http://www.drb-m.org/eletrodinamica/AssociacaodeResistores.htm");
            }
        });
    }

    private void jsonToResistores(String json) {
        try {
            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
            JSONArray resistores = object.getJSONArray("resistores");

            for (int i = 0; i < resistores.length(); i++) {
                JSONObject dados = (JSONObject) resistores.get(i);
                int id = dados.getInt("id");
                String nome = dados.getString("nome");
                double resistencia = dados.getDouble("resistencia");
                String unidadDeMedida = dados.getString("unidadeDeMedida");

                Resistor resistor = new Resistor(id, nome, resistencia, unidadDeMedida);

                _resistores.add(resistor);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void calcularResistenciaEquivalente() {

        for (Resistor resistor : _resistores) {

            Pair<String, Double> unidadeDeMedida = null;

            for (int i = 0; i < _unidadesDeMedidaEmNumeros.length; i++) {
                if (resistor.getUnidadeDeMedida().equals(_unidadesDeMedidaEmNumeros[i].first.toString())) {
                    unidadeDeMedida = _unidadesDeMedidaEmNumeros[i];
                }
            }

            if (unidadeDeMedida == null) {
                unidadeDeMedida = _unidadesDeMedidaEmNumeros[2];
            }

            _resultadoEmOhm += ((double) resistor.getResistencia() / unidadeDeMedida.second);
        }

        _resultadoEmMegaOhm = _resultadoEmOhm * Double.parseDouble(_unidadesDeMedidaEmNumeros[0].second.toString());
        _resultadoEmKiloOhm = _resultadoEmOhm * Double.parseDouble(_unidadesDeMedidaEmNumeros[1].second.toString());
        _resultadoEmMiliOhm = _resultadoEmOhm * Double.parseDouble(_unidadesDeMedidaEmNumeros[3].second.toString());
        _resultadoEmMicroOhm = _resultadoEmOhm * Double.parseDouble(_unidadesDeMedidaEmNumeros[4].second.toString());
        _resultadoEmNanoOhm = _resultadoEmOhm * Double.parseDouble(_unidadesDeMedidaEmNumeros[5].second.toString());
    }

    private void abrirPaginaWeb(String url) {
        Intent browser = new Intent(Intent.ACTION_VIEW);
        browser.setData(Uri.parse(url));
        startActivity(browser);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}