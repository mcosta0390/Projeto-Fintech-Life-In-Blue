package br.com.fiap.bean;

public class TipoRecebimento {

	private int codigo;

	private int cdReceita;

	private String tpReceita;

	public TipoRecebimento(int codigo, int cdReceita, String tpReceita) {
		super();
		this.codigo = codigo;
		this.cdReceita = cdReceita;
		this.tpReceita = tpReceita;
	}

	public TipoRecebimento() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTpReceita() {
		return tpReceita;
	}

	public void setTpReceita(String tpReceita) {
		this.tpReceita = tpReceita;
	}

	public int getCdReceita() {
		return cdReceita;
	}

	public void setCdReceita(int cdReceita) {
		this.cdReceita = cdReceita;
	}

	@Override
	public String toString() {
		return "TipoRecebimento [codigo=" + codigo + ", cdReceita=" + cdReceita + ", tpReceita=" + tpReceita + "]";
	}
}
