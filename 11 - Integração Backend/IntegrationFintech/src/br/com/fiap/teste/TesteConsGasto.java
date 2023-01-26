package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.bean.Gasto;
import br.com.fiap.bean.TipoGasto;
import br.com.fiap.dao.FintechDAO;

public class TesteConsGasto {

	public static void main(String[] args) {

		FintechDAO dao = new FintechDAO();

		List<Gasto> lista = dao.listar3();
		for (Gasto item : lista) {
			System.out.println(item.getCodigo() + "" + item.getNmEmail() + "" + item.getData().getTime() + ""
					+ item.getValor() + "" + item.getDsDespesa());
		}

		List<TipoGasto> lista3 = dao.listar4();
		for (TipoGasto item : lista3) {
			System.out.println(item.getCodigo() + "" + item.getCdDespesa() + "" + item.getTpDespesa());
		}

	}

}
