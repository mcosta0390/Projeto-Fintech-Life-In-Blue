package br.com.fiap.bean;

import java.sql.Date;
import java.util.Calendar;

public class Investimento {
	
	private int codigo;

	private String nmEmail;
	
	private String nmInstituicao;

	private Calendar data;
	
	private Calendar dataVenc;

	private float valor;

	private String dsInvestimento;

	public Investimento(int codigo, String nmEmail, String nmInstituicao, Calendar data, Calendar dataVenc, float valor,
			String dsInvestimento) {
		super();
		this.codigo = codigo;
		this.nmEmail = nmEmail;
		this.nmInstituicao = nmInstituicao;
		this.data = data;
		this.dataVenc = dataVenc;
		this.valor = valor;
		this.dsInvestimento = dsInvestimento;
	}
	
	public Investimento() {
		super();
	}


	public Investimento(int codigo2, String nmEmail2, Date data2, Calendar dataVenc2, Float valor2,
			String dsInvestimento2) {
		// TODO Auto-generated constructor stub
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

	public String getNmInstituicao() {
		return nmInstituicao;
	}

	public void setNmInstituicao(String nmInstituicao) {
		this.nmInstituicao = nmInstituicao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getDataVenc() {
		return dataVenc;
	}

	public void setDataVenc(Calendar dataVenc) {
		this.dataVenc = dataVenc;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDsInvestimento() {
		return dsInvestimento;
	}

	public void setDsInvestimento(String dsInvestimento) {
		this.dsInvestimento = dsInvestimento;
	}
}
