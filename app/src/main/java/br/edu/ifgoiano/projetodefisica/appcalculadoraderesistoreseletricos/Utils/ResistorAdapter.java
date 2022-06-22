package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos.Utils;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.jar.JarEntry;

import br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos.DadosEspecificosSerieResistenciaActivity;
import br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos.R;
import br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos.beans.Resistor;

public class ResistorAdapter extends BaseAdapter {

    private List<Resistor> _resistores;
    private Activity _context;

    public ResistorAdapter(List<Resistor> resistores, Activity context) {
        _resistores = resistores;
        _context = context;
    }

    @Override
    public int getCount() {
        return _resistores.size();
    }

    @Override
    public Object getItem(int position) {
        return _resistores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _resistores.get(position).getId();
    }

    public List<Resistor> getAll() {
        return _resistores;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Resistor resistor = (Resistor) getItem(position);

        LayoutInflater inflate = _context.getLayoutInflater();
        View linha = inflate.inflate(R.layout.layout_lista_resistores, null);

        TextView nome = (TextView) linha.findViewById(R.id.txtNomeResistor);
        nome.setText(resistor.getNome().toUpperCase());

        EditText resistencia = (EditText) linha.findViewById(R.id.edTxtResistencia);
        resistencia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.toString().isEmpty()) {
                    resistor.setResistencia(0d);
                } else {
                    resistor.setResistencia(Double.parseDouble(editable.toString()));
                }
            }
        });

        Spinner spnUnidadeResistencia = (Spinner) linha.findViewById(R.id.spnUnidadeResistencia);
        String[] unidadesDeResistencia = {"MΩ", "KΩ", "Ω", "mΩ", "μΩ"};

        ArrayAdapter adapter = new ArrayAdapter(_context, android.R.layout.simple_spinner_dropdown_item, unidadesDeResistencia);
        spnUnidadeResistencia.setAdapter(adapter);
        spnUnidadeResistencia.setSelection(2);
        spnUnidadeResistencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resistor.setUnidadeDeMedida(spnUnidadeResistencia.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return linha;
    }
}
