package br.com.fiap.bean;

import java.util.Calendar;

public class Objetivo {
	
	private int codigo;

	private String nmEmail;

	private Calendar data;

	private float valor;

	private String dsObjetivo;

	public Objetivo(int codigo, String nmEmail, Calendar data, float valor, String dsObjetivo) {
		super();
		this.codigo = codigo;
		this.nmEmail = nmEmail;
		this.data = data;
		this.valor = valor;
		this.dsObjetivo = dsObjetivo;
	}

	public Objetivo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNmEmail() {
		return nmEmail;
	}

	public void setNmEmail(String nmEmail) {
		this.nmEmail = nmEmail;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDsObjetivo() {
		return dsObjetivo;
	}

	public void setDsObjetivo(String dsObjetivo) {
		this.dsObjetivo = dsObjetivo;
	}
	
}
