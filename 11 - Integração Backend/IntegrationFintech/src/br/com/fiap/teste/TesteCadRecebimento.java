package br.com.fiap.teste;

import java.util.Calendar;

import br.com.fiap.bean.Recebimento;
import br.com.fiap.bean.TipoRecebimento;
import br.com.fiap.dao.FintechDAO;

public class TesteCadRecebimento {

	public static void main(String[] args) {

		// Instancia o DAO

		FintechDAO dao = new FintechDAO();

		// Instancia o Recebimento
		Recebimento recebimento = new Recebimento();

		recebimento.setNmEmail("123@gmail.com");
		recebimento.setData(Calendar.getInstance());
		recebimento.setValor(800);
		recebimento.setDsReceita("Atingimento de Meta");

		// Cadastra no banco de dados

		dao.cadastrar(recebimento);

		System.out.println("Cadastrado!");

		// Instancia o Tipo de Recebimento
		TipoRecebimento tipoRecebimento = new TipoRecebimento();

		tipoRecebimento.setCdReceita(52);
		tipoRecebimento.setTpReceita("Empréstimo para Terceiros");

		// Cadastra no banco de dados

		dao.cadastrar(tipoRecebimento);

		System.out.println("Cadastrado!");
	}
}
