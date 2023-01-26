package br.com.fiap.bean;

public class TipoObjetivo {

	private int codigo;

	private int cdObjetivo;

	private String tpObjetivo;

	public TipoObjetivo(int codigo, int cdObjetivo, String tpObjetivo) {
		super();
		this.codigo = codigo;
		this.cdObjetivo = cdObjetivo;
		this.tpObjetivo = tpObjetivo;
	}

	public TipoObjetivo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCdObjetivo() {
		return cdObjetivo;
	}

	public void setCdObjetivo(int cdObjetivo) {
		this.cdObjetivo = cdObjetivo;
	}

	public String getTpObjetivo() {
		return tpObjetivo;
	}

	public void setTpObjetivo(String tpObjetivo) {
		this.tpObjetivo = tpObjetivo;
	}
	
	
}
