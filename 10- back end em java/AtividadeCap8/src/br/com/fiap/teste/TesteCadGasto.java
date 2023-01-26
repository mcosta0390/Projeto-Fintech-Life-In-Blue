package br.com.fiap.teste;

import java.util.Calendar;

import br.com.fiap.bean.Gasto;
import br.com.fiap.bean.TipoGasto;
import br.com.fiap.dao.FintechDAO;

public class TesteCadGasto {

	public static void main(String[] args) {

		// Instancia o DAO

		FintechDAO dao = new FintechDAO();

		// Instancia o Gasto
		Gasto gasto = new Gasto();

		gasto.setNmEmail("123@gmail.com");
		gasto.setData(Calendar.getInstance());
		gasto.setValor(200);
		gasto.setDsDespesa("Cabelereiro");

		// Cadastra no banco de dados

		dao.cadastrar(gasto);

		System.out.println("Cadastrado!");

		// Instancia o Tipo de Recebimento
		TipoGasto tipoGasto = new TipoGasto();

		tipoGasto.setCdDespesa(43);
		tipoGasto.setTpDespesa("Sabesp");

		// Cadastra no banco de dados

		dao.cadastrar(tipoGasto);

		System.out.println("Cadastrado!");

	}

}
