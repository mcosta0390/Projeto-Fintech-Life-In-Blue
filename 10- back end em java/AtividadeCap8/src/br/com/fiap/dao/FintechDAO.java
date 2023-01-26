package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.Gasto;
import br.com.fiap.bean.Recebimento;
import br.com.fiap.bean.TipoGasto;
import br.com.fiap.bean.TipoRecebimento;
import br.com.fiap.jdbc.FintechDBManager;

public class FintechDAO {

	private Connection conexao;

	// DAO Cadastro recebimento

	public void cadastrar(Recebimento recebimento) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_RECEBIMENTO (CD_RECEITA, T_FIN_LOGIN_NM_EMAIL, DT_DATA, VL_VALOR, DS_RECEITA) VALUES (SQ_FIN_RECEBIMENTO.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, recebimento.getNmEmail());
			java.sql.Date data = new java.sql.Date(recebimento.getData().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setFloat(3, recebimento.getValor());
			stmt.setString(4, recebimento.getDsReceita());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// DAO cadastro Tipo de Recebimento

	public void cadastrar(TipoRecebimento tipoRecebimento) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_TIPO_RECEBIMENTO (CD_TIPO_RECEITA, T_FIN_RECEBIMENTO_CD_RECEITA, TP_RECEITA) VALUES (SQ_FIN_TIPO_RECEBIMENTO.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, tipoRecebimento.getCdReceita());
			stmt.setString(2, tipoRecebimento.getTpReceita());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// DAO Listar Recebimento

	public List<Recebimento> listar() {

		// Cria uma lista de Recebimento

		List<Recebimento> lista = new ArrayList<Recebimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_RECEBIMENTO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("CD_RECEITA");
				String nmEmail = rs.getString("T_FIN_LOGIN_NM_EMAIL");
				java.sql.Date data = rs.getDate("DT_DATA");
				Calendar dataRecebimento = Calendar.getInstance();
				dataRecebimento.setTimeInMillis(data.getTime());
				Float valor = rs.getFloat("VL_VALOR");
				String dsReceita = rs.getString("DS_RECEITA");

				// Cria um objeto recebimento com as informações encontradas

				Recebimento recebimento = new Recebimento(codigo, nmEmail, dataRecebimento, valor, dsReceita);

				// Adiciona o recebimento na lista

				lista.add(recebimento);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	// DAO Listar Tipo Recebimento

	public List<TipoRecebimento> listar2() {

		// Cria uma lista de Recebimento

		List<TipoRecebimento> lista2 = new ArrayList<TipoRecebimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_TIPO_RECEBIMENTO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("CD_TIPO_RECEITA");
				int cdReceita = rs.getInt("T_FIN_RECEBIMENTO_CD_RECEITA");
				String tpReceita = rs.getString("TP_RECEITA");

				// Cria um objeto recebimento com as informações encontradas

				TipoRecebimento tipoRecebimento = new TipoRecebimento(codigo, cdReceita, tpReceita);

				// Adiciona o recebimento na lista

				lista2.add(tipoRecebimento);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista2;
	}

	// DAO Cadastrar Gasto

	public void cadastrar(Gasto gasto) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_GASTO (CD_DESPESA, T_FIN_LOGIN_NM_EMAIL, DT_DATA, VL_VALOR, DS_DESPESA) VALUES (SQ_FIN_GASTO.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, gasto.getNmEmail());
			java.sql.Date data = new java.sql.Date(gasto.getData().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setFloat(3, gasto.getValor());
			stmt.setString(4, gasto.getDsDespesa());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// DAO Cadastrar Tipo de Gasto

	public void cadastrar(TipoGasto tipoGasto) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_TIPO_GASTO (CD_TIPO_DESPESA, T_FIN_GASTO_CD_DESPESA, TP_DESPESA) VALUES (SQ_FIN_TIPO_GASTO.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, tipoGasto.getCdDespesa());
			stmt.setString(2, tipoGasto.getTpDespesa());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// DAO Listar Gasto

	public List<Gasto> listar3() {

		// Cria uma lista de Gasto

		List<Gasto> lista = new ArrayList<Gasto>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_GASTO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("CD_DESPESA");
				String nmEmail = rs.getString("T_FIN_LOGIN_NM_EMAIL");
				java.sql.Date data = rs.getDate("DT_DATA");
				Calendar dataGasto = Calendar.getInstance();
				dataGasto.setTimeInMillis(data.getTime());
				Float valor = rs.getFloat("VL_VALOR");
				String dsGasto = rs.getString("DS_DESPESA");

				// Cria um objeto gasto com as informações encontradas

				Gasto gasto = new Gasto(codigo, nmEmail, dataGasto, valor, dsGasto);

				// Adiciona o gasto na lista

				lista.add(gasto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	// DAO Listar Tipo Gasto

	public List<TipoGasto> listar4() {

		// Cria uma lista de Gasto

		List<TipoGasto> lista3 = new ArrayList<TipoGasto>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_TIPO_GASTO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("CD_TIPO_DESPESA");
				int cdDespesa = rs.getInt("T_FIN_GASTO_CD_DESPESA");
				String tpGasto = rs.getString("TP_DESPESA");

				// Cria um objeto Gasto com as informações encontradas

				TipoGasto tipoGasto = new TipoGasto(codigo, cdDespesa, tpGasto);

				// Adiciona o Gasto na lista

				lista3.add(tipoGasto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista3;
	}
}
