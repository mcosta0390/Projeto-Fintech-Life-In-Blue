package br.com.fiap.bean;

public class TipoInvestimento {
	
	private int codigo;

	private int cdInvestimento;

	private String tpInvestimento;
	
	
	public TipoInvestimento(int codigo, int cdInvestimento, String tpInvestimento) {
		super();
		this.codigo = codigo;
		this.cdInvestimento = cdInvestimento;
		this.tpInvestimento = tpInvestimento;
	}

	public TipoInvestimento() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCdInvestimento() {
		return cdInvestimento;
	}

	public void setCdInvestimento(int cdInvestimento) {
		this.cdInvestimento = cdInvestimento;
	}

	public String getTpInvestimento() {
		return tpInvestimento;
	}

	public void setTpInvestimento(String tpInvestimento) {
		this.tpInvestimento = tpInvestimento;
	}
	
}
