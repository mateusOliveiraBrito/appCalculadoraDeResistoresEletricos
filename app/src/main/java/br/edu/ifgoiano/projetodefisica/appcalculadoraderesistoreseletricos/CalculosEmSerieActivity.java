package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CalculosEmSerieActivity extends AppCompatActivity {

    private RadioGroup _radioGroupGrandezas;
    private FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculos_em_serie);

        _radioGroupGrandezas = findViewById(R.id.rdGpGrandezas);
        _radioGroupGrandezas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int codigoChecked) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (codigoChecked == R.id.rdBtnResistenciaEletrica) {
                    DadosGeraisSerieResistenciaFragment dadosGeraisSerieResistenciaFragment = new DadosGeraisSerieResistenciaFragment();
                    fragmentTransaction.replace(R.id.formulariosGrandezas, dadosGeraisSerieResistenciaFragment);
                }

                if (codigoChecked == R.id.rdBtnTensao) {
                    DadosGeraisSerieTensaoFragment dadosGeraisSerieTensaoFragment = new DadosGeraisSerieTensaoFragment();
                    fragmentTransaction.replace(R.id.formulariosGrandezas, dadosGeraisSerieTensaoFragment);
                }

                if (codigoChecked == R.id.rdBtnCorrente) {
                    DadosGeraisSerieCorrenteEletricaFragment dadosGeraisSerieCorrenteEletricaFragment = new DadosGeraisSerieCorrenteEletricaFragment();
                    fragmentTransaction.replace(R.id.formulariosGrandezas, dadosGeraisSerieCorrenteEletricaFragment);
                }

                fragmentTransaction.commit();
            }
        });

        RadioButton radioButtonResistenciaEquivalente = (RadioButton) _radioGroupGrandezas.getChildAt(0);
        radioButtonResistenciaEquivalente.setChecked(true);
    }
}