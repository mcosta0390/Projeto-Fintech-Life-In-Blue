package br.com.fiap.bean;

import java.util.Calendar;

public class Recebimento {

	private int codigo;

	private String nmEmail;

	private Calendar data;

	private float valor;

	private String dsReceita;

	public Recebimento(int codigo, String nmEmail, Calendar data, float valor, String dsReceita) {
		super();
		this.codigo = codigo;
		this.nmEmail = nmEmail;
		this.data = data;
		this.valor = valor;
		this.dsReceita = dsReceita;
	}

	public Recebimento() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public String getDsReceita() {
		return dsReceita;
	}

	public void setDsReceita(String dsReceita) {
		this.dsReceita = dsReceita;
	}

	public String getNmEmail() {
		return nmEmail;
	}

	public void setNmEmail(String nmEmail) {
		this.nmEmail = nmEmail;
	}

	@Override
	public String toString() {
		return "Recebimento [codigo=" + codigo + ", nmEmail=" + nmEmail + ", data=" + data + ", valor=" + valor
				+ ", dsReceita=" + dsReceita + "]";
	}

}
