package br.com.fiap.bean;

public class TipoGasto {

	private int codigo;

	private int cdDespesa;

	private String tpDespesa;

	public TipoGasto(int codigo, int cdDespesa, String tpDespesa) {
		super();
		this.codigo = codigo;
		this.cdDespesa = cdDespesa;
		this.tpDespesa = tpDespesa;
	}

	public TipoGasto() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTpDespesa() {
		return tpDespesa;
	}

	public void setTpDespesa(String tpDespesa) {
		this.tpDespesa = tpDespesa;
	}

	public int getCdDespesa() {
		return cdDespesa;
	}

	public void setCdDespesa(int cdDespesa) {
		this.cdDespesa = cdDespesa;
	}

	@Override
	public String toString() {
		return "TipoGasto [codigo=" + codigo + ", cdDespesa=" + cdDespesa + ", tpDespesa=" + tpDespesa + "]";
	}
}
