package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos.Utils.ResistorAdapter;
import br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos.beans.Resistor;

public class DadosEspecificosSerieResistenciaActivity extends AppCompatActivity {

    private ListView _resistores;
    private Button _btnCalcularResistenciaEquivalenteEmSerie;
    private ArrayList<Resistor> _listaDeresistores = new ArrayList<Resistor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_especificos_serie_resistencia);

        Intent intent = getIntent();
        int quantidadeDeResistores = Integer.parseInt(intent.getStringExtra("quantidadeDeResistores"));

        _listaDeresistores = gerarResistores(quantidadeDeResistores);

        _resistores = findViewById(R.id.listaDeResistoresParaCalculo);
        ResistorAdapter resistorAdapter = new ResistorAdapter(gerarResistores(quantidadeDeResistores), this);
        _resistores.setAdapter(resistorAdapter);

        _btnCalcularResistenciaEquivalenteEmSerie = findViewById(R.id.btnCalcularResistenciaEquivalenteEmSerie);
        _btnCalcularResistenciaEquivalenteEmSerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                obterResistoresDaListView();
                Pair<Boolean, String> validacao = validarCampos();

                if (!validacao.first) {
                    Toast.makeText(DadosEspecificosSerieResistenciaActivity.this, validacao.second, Toast.LENGTH_LONG).show();
                    return;
                }

                Intent calculoReqEmSerie = new Intent(DadosEspecificosSerieResistenciaActivity.this, CalculoResistenciaEquivalenteEmSerieActivity.class);
                calculoReqEmSerie.putExtra("quantidadeDeResistores", _listaDeresistores.size() + "");
                calculoReqEmSerie.putExtra("resistores", resistoresToJson());
                startActivity(calculoReqEmSerie);
            }
        });
    }

    private ArrayList<Resistor> gerarResistores(int quantidadeDeResistores) {
        ArrayList<Resistor> resistores = new ArrayList<Resistor>();

        for (int i = 1; i <= quantidadeDeResistores; i++) {
            resistores.add(new Resistor(i, "Resistor " + i, 0, ""));
        }

        return resistores;
    }

    private void obterResistoresDaListView() {
        _listaDeresistores.clear();
        int tamanhoListView = _resistores.getCount();

        for (int i = 0; i < tamanhoListView; i++) {
            _listaDeresistores.add((Resistor) _resistores.getItemAtPosition(i));
        }
    }

    private Pair<Boolean, String> validarCampos() {

        for (Resistor resistor : _listaDeresistores) {
            if (resistor.getResistencia() == 0d) {
                return new Pair<Boolean, String>(false, "Não foi informado um valor de resistência para o " + resistor.getNome() + ". Favor, preencher todos os campos solicitados.");
            }
        }

        return new Pair<Boolean, String>(true, "");
    }

    private String resistoresToJson() {
        JSONStringer js = new JSONStringer();

        try {
            js.object().key("resistores").array();

            for (Resistor resistor : _listaDeresistores) {
                js.object();

                js.key("id").value(resistor.getId());
                js.key("nome").value(resistor.getNome());
                js.key("resistencia").value(resistor.getResistencia());
                js.key("unidadeDeMedida").value(resistor.getUnidadeDeMedida());

                js.endObject();
            }

            js.endArray().endObject();
        } catch (JSONException e) {

        }


        return js.toString();
    }
}