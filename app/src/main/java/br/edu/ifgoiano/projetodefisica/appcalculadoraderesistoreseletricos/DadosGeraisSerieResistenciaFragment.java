package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DadosGeraisSerieResistenciaFragment extends Fragment {

    private EditText _edtTxtQuantidadeResistores;
    private Button _btnAbrirTelaDadosEspecificosSerieResistencia;
    private int _quantidadeDeResistores;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_dados_gerais_serie_resistencia, container, false);

        _edtTxtQuantidadeResistores = view.findViewById(R.id.edtTextQuantidadeResistores);
        _btnAbrirTelaDadosEspecificosSerieResistencia = view.findViewById(R.id.btnAbrirTelaDadosEspecificosSerieResistencia);

        _btnAbrirTelaDadosEspecificosSerieResistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pair<Boolean, String> validacao = validarCampos();

                if (!validacao.first.booleanValue()) {
                    Toast.makeText(container.getContext(), validacao.second.toString(), Toast.LENGTH_LONG).show();
                    return;
                }

                Intent dadosEspecificosSerieResistencia = new Intent(container.getContext(), DadosEspecificosSerieResistenciaActivity.class);
                dadosEspecificosSerieResistencia.putExtra("quantidadeDeResistores", _quantidadeDeResistores + "");
                startActivity(dadosEspecificosSerieResistencia);
            }
        });

        return view;
    }

    private Pair<Boolean, String> validarCampos() {
        try {
            _quantidadeDeResistores = Integer.parseInt(_edtTxtQuantidadeResistores.getText().toString());
        } catch (Exception ex) {
            return new Pair(false, "O valor inserido deve ser um valor numérico.");
        }

        if (_quantidadeDeResistores <= 0) {
            return new Pair(false, "A quantidade de resistores deve ser um número positivo.");
        }

        return new Pair(true, "");
    }
}