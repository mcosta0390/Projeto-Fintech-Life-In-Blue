package br.com.fiap.bean;

import java.util.Calendar;

public class Gasto {

	private int codigo;

	private String nmEmail;

	private Calendar data;

	private float valor;

	private String dsDespesa;

	public Gasto(int codigo, String nmEmail, Calendar data, float valor, String dsDespesa) {
		super();
		this.codigo = codigo;
		this.nmEmail = nmEmail;
		this.data = data;
		this.valor = valor;
		this.dsDespesa = dsDespesa;
	}

	public Gasto() {
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

	public String getDsDespesa() {
		return dsDespesa;
	}

	public void setDsDespesa(String dsDespesa) {
		this.dsDespesa = dsDespesa;
	}

	public String getNmEmail() {
		return nmEmail;
	}

	public void setNmEmail(String nmEmail) {
		this.nmEmail = nmEmail;
	}

	@Override
	public String toString() {
		return "Gasto [codigo=" + codigo + ", nmEmail=" + nmEmail + ", data=" + data + ", valor=" + valor
				+ ", dsDespesa=" + dsDespesa + "]";
	}
}
