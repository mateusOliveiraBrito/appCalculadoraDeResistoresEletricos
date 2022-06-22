package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DadosGeraisSerieTensaoFragment extends Fragment {

    private EditText _edtTextQuantidadeDeResistores;
    private EditText _edtTextIntensidadeDaCorrenteEletrica;

    private RadioGroup _radioGroupSentidoDaCorrente;
    private RadioButton _radioButtonSentido01;

    private Spinner _spnUnidadeCorrenteEletrica;
    private String[] _unidadesDeCorrente = {"A", "mA", "μA", "nA"};

    private Button _btnAbrirTelaDadosEspecificosTensao;

    private int _quantidadeDeResistores;
    private double _intensidadeDaCorrenteEletrica;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_dados_gerais_serie_tensao, container, false);

        _edtTextQuantidadeDeResistores = view.findViewById(R.id.edtTextQuantidadeResistores);
        _edtTextIntensidadeDaCorrenteEletrica = view.findViewById(R.id.edtTextIntensidadeDaCorrenteEletrica);

        _radioGroupSentidoDaCorrente = view.findViewById(R.id.rdGpSentidoDaCorrente);
        _radioButtonSentido01 = view.findViewById(R.id.sentido01);
        _radioButtonSentido01.setChecked(true);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, _unidadesDeCorrente);
        _spnUnidadeCorrenteEletrica = view.findViewById(R.id.spnUnidadeCorrenteEletrica);
        _spnUnidadeCorrenteEletrica.setAdapter(adapter);
        _spnUnidadeCorrenteEletrica.setSelection(1);

        _btnAbrirTelaDadosEspecificosTensao = view.findViewById(R.id.btnAbrirTelaDadosEspecificosTensao);
        _btnAbrirTelaDadosEspecificosTensao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pair<Boolean, String> validacao = validarCampos();

                if (!validacao.first.booleanValue()) {
                    Toast.makeText(container.getContext(), validacao.second.toString(), Toast.LENGTH_LONG).show();
                    return;
                }

                Intent dadosEspecificosSerieTensao = new Intent(container.getContext(), DadosEspecificosSerieTensaoActivity.class);
                dadosEspecificosSerieTensao.putExtra("quantidadeDeResistores", _quantidadeDeResistores);
                dadosEspecificosSerieTensao.putExtra("intensidadeDaCorrente", _intensidadeDaCorrenteEletrica);
                dadosEspecificosSerieTensao.putExtra("sentidoDaCorrente", _radioGroupSentidoDaCorrente.getCheckedRadioButtonId());
                dadosEspecificosSerieTensao.putExtra("unidadeDaCorrente", _unidadesDeCorrente[(int) _spnUnidadeCorrenteEletrica.getSelectedItemId()]);

                startActivity(dadosEspecificosSerieTensao);
            }
        });

        return view;
    }

    private Pair<Boolean, String> validarCampos() {
        try {
            _quantidadeDeResistores = Integer.parseInt(_edtTextQuantidadeDeResistores.getText().toString());
        } catch (Exception ex) {
            return new Pair(false, "A quantidade de resistores deve ser um valor numérico.");
        }

        try {
            _intensidadeDaCorrenteEletrica = Integer.parseInt(_edtTextIntensidadeDaCorrenteEletrica.getText().toString());
        } catch (Exception ex) {
            return new Pair(false, "A intensidade da corrente elétrica deve ser um valor numérico.");
        }

        if (_quantidadeDeResistores <= 0) {
            return new Pair(false, "A quantidade de resistores deve ser um número positivo.");
        }

        if (_intensidadeDaCorrenteEletrica < 0) {
            return new Pair(false, "A intensidade da corrente deve ser maior ou igual a zero.");
        }

        return new Pair(true, "");
    }
}
