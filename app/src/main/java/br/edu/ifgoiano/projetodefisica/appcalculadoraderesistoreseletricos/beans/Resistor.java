package br.edu.ifgoiano.projetodefisica.appcalculadoraderesistoreseletricos.beans;

public class Resistor {

    private int _id;
    private String _nome;
    private double _resistencia;
    private String _unidadeDeMedida;

    public Resistor(int id, String nome, double resistencia, String unidadeDeMedida) {
        _id = id;
        _nome = nome;
        _resistencia = resistencia;
        _unidadeDeMedida = unidadeDeMedida;
    }

    public void setId(int id) {
        _id = id;
    }

    public int getId() {
        return _id;
    }

    public String getNome() {
        return _nome;
    }

    public void setNome(String nome) {
        _nome = nome;
    }

    public double getResistencia() {
        return _resistencia;
    }

    public void setResistencia(double resistencia) {
        _resistencia = resistencia;
    }

    public String getUnidadeDeMedida() {
        return _unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String _unidadeDeMedida) {
        this._unidadeDeMedida = _unidadeDeMedida;
    }

    @Override
    public String toString() {
        return getId() + " " + getNome() + " " + getResistencia() + " " + getUnidadeDeMedida();
    }
}
