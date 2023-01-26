package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.bean.Recebimento;
import br.com.fiap.bean.TipoRecebimento;
import br.com.fiap.dao.FintechDAO;

public class TesteConsRecebimento {

	public static void main(String[] args) {

		FintechDAO dao = new FintechDAO();

		List<Recebimento> lista = dao.listar();
		for (Recebimento item : lista) {
			System.out.println(item.getCodigo() + "" + item.getNmEmail() + "" + item.getData().getTime() + ""
					+ item.getValor() + "" + item.getDsReceita());
		}

		List<TipoRecebimento> lista2 = dao.listar2();
		for (TipoRecebimento item : lista2) {
			System.out.println(item.getCodigo() + "" + item.getCdReceita() + "" + item.getTpReceita());
		}

	}
}
