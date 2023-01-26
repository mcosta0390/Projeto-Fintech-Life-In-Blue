package br.com.fiap.bean;

public class InstInvestimento {
	
	private String nmInstituicao;
	
	private String nmAplicacao;

	public InstInvestimento(String nmInstituicao, String nmAplicacao) {
		super();
		this.nmInstituicao = nmInstituicao;
		this.nmAplicacao = nmAplicacao;
	}

	public InstInvestimento() {
		super();
	}

	public String getNmInstituicao() {
		return nmInstituicao;
	}

	public void setNmInstituicao(String nmInstituicao) {
		this.nmInstituicao = nmInstituicao;
	}

	public String getNmAplicacao() {
		return nmAplicacao;
	}

	public void setNmaplicacao(String nmAplicacao) {
		this.nmAplicacao = nmAplicacao;
	}
	
}
