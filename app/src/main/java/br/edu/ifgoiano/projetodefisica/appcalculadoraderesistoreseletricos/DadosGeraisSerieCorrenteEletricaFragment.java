package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

public class DadosGeraisSerieCorrenteEletricaFragment extends Fragment {

    private LinearLayout _containerTensaoTotal;
    private LinearLayout _containerResistenciaEquivalente;
    private LinearLayout _containerQuantidadeDeResistores;

    private RadioGroup _radioGroupTipoDeTensao;
    private RadioButton _radioButtonTensaoTotal;

    private RadioGroup _radioGroupResistenciaEquivalente;
    private RadioButton _radioButtonResistenciaEquivalente;

    private boolean isTensaoEmCadaResistor = false, isResistenciaEmCadaResistor = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_dados_gerais_serie_corrente_eletrica, container, false);

        _containerTensaoTotal = view.findViewById(R.id.containerTensaoTotal);
        _containerResistenciaEquivalente = view.findViewById(R.id.containerResistencaEquivalente);
        _containerQuantidadeDeResistores = view.findViewById(R.id.containerQtdResistores);

        _containerTensaoTotal.setVisibility(View.VISIBLE);
        _containerResistenciaEquivalente.setVisibility(View.VISIBLE);
        _containerQuantidadeDeResistores.setVisibility(View.GONE);

        _radioGroupTipoDeTensao = view.findViewById(R.id.rdGpTipoTensao);
        _radioButtonTensaoTotal = view.findViewById(R.id.rdbtnTensaoTotal);

        _radioGroupTipoDeTensao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int codigoChecked) {

                if (codigoChecked == R.id.rdbtnTensaoTotal) {
                    isTensaoEmCadaResistor = false;
                    _containerTensaoTotal.setVisibility(View.VISIBLE);

                    if (!isTensaoEmCadaResistor && !isResistenciaEmCadaResistor){
                        _containerQuantidadeDeResistores.setVisibility(View.GONE);
                    }
                }

                if (codigoChecked == R.id.rdbtnTensaoCadaResistor) {
                    isTensaoEmCadaResistor = true;
                    _containerQuantidadeDeResistores.setVisibility(View.VISIBLE);
                    _containerTensaoTotal.setVisibility(View.GONE);
                }
            }
        });

        _radioGroupResistenciaEquivalente = view.findViewById(R.id.rdGpTipoResistencia);
        _radioButtonResistenciaEquivalente = view.findViewById(R.id.rdbtnResistenciaTotal);

        _radioGroupResistenciaEquivalente.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int codigoChecked) {
                if (codigoChecked == R.id.rdbtnResistenciaTotal) {
                    isResistenciaEmCadaResistor = false;
                    _containerResistenciaEquivalente.setVisibility(View.VISIBLE);

                    if (!isTensaoEmCadaResistor && !isResistenciaEmCadaResistor){
                        _containerQuantidadeDeResistores.setVisibility(View.GONE);
                    }
                }

                if (codigoChecked == R.id.rdbtnResistenciaCadaResistor) {
                    isResistenciaEmCadaResistor = true;
                    _containerQuantidadeDeResistores.setVisibility(View.VISIBLE);
                    _containerResistenciaEquivalente.setVisibility(View.GONE);
                }
            }
        });

        _radioButtonTensaoTotal.setChecked(true);
        _radioButtonResistenciaEquivalente.setChecked(true);

        return view;
    }
}