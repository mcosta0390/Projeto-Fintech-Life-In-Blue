package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.CadastroUsuario;
import br.com.fiap.bean.Gasto;
import br.com.fiap.bean.InstInvestimento;
import br.com.fiap.bean.Investimento;
import br.com.fiap.bean.Objetivo;
import br.com.fiap.bean.Recebimento;
import br.com.fiap.bean.TipoGasto;
import br.com.fiap.bean.TipoInvestimento;
import br.com.fiap.bean.TipoObjetivo;
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

	// DAO Cadastro Usuario

	public void cadastrar(CadastroUsuario cadastroUsuario) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_CADASTRO (CD_USUARIO, NM_NOME_COMPLETO, DT_NASCIMENTO, DS_GENERO, NM_EMAIL, NR_SENHA) VALUES (SQ_FIN_CADASTRO.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cadastroUsuario.getNome());
			java.sql.Date data = new java.sql.Date(cadastroUsuario.getData().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setString(3, cadastroUsuario.getGenero());
			stmt.setString(4, cadastroUsuario.getEmail());
			stmt.setString(5, cadastroUsuario.getSenha());

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

	// DAO Listar Cadastro Usuario

	public List<CadastroUsuario> listar5() {

		// Cria uma lista de Usuario

		List<CadastroUsuario> lista = new ArrayList<CadastroUsuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CADASTRO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("CD_USUARIO");
				String nome = rs.getString("NM_NOME_COMPLETO");
				java.sql.Date data = rs.getDate("DT_NASCIMENTO");
				Calendar nascimento = Calendar.getInstance();
				nascimento.setTimeInMillis(data.getTime());
				String genero = rs.getString("DS_GENERO");
				String email = rs.getString("NM_EMAIL");
				String senha = rs.getString("NR_SENHA");

				// Cria um objeto cadastro com as informações encontradas

				CadastroUsuario cadastroUsuario = new CadastroUsuario(codigo, nome, nascimento, genero, email, senha);

				// Adiciona as informações na lista

				lista.add(cadastroUsuario);
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

	// DAO Cadastro Investimento

	public void cadastrar(Investimento investimento) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_INVESTIMENTO (CD_INVESTIMENTO, T_FIN_LOGIN_NM_EMAIL, T_FIN_INSTITUICAO_INVESTIMENTO_NM_INSTITUICAO, DT_DATA, DT_VENCIMENTO, VL_VALOR, DS_INVESTIMENTO) VALUES (SQ_FIN_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, investimento.getNmEmail());
			stmt.setString(2, investimento.getNmInstituicao());
			java.sql.Date data = new java.sql.Date(investimento.getData().getTimeInMillis());
			stmt.setDate(3, data);
			java.sql.Date dataVenc = new java.sql.Date(investimento.getData().getTimeInMillis());
			stmt.setDate(4, dataVenc);
			stmt.setFloat(5, investimento.getValor());
			stmt.setString(6, investimento.getDsInvestimento());

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

	// DAO cadastro Tipo de Investimento

	public void cadastrar(TipoInvestimento tipoInvestimento) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_TIPO_INVESTIMENTO (CD_TIPO_INVESTIMENTO, T_FIN_INVESTIMENTO_CD_INVESTIMENTO, TP_INVESTIMENTO) VALUES (SQ_FIN_TIPO_INVESTIMENTO.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, tipoInvestimento.getCdInvestimento());
			stmt.setString(2, tipoInvestimento.getTpInvestimento());

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

	// DAO cadastro Tipo de Instituição de Investimento

	public void cadastrar(InstInvestimento instInvestimento) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_INSTITUICAO_INVESTIMENTO (NM_INSTITUICAO, NM_APLICACAO) VALUES (?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, instInvestimento.getNmInstituicao());
			stmt.setString(2, instInvestimento.getNmAplicacao());

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

	// DAO Listar Investimento

	public List<Investimento> listar6() {

		// Cria uma lista de Investimento

		List<Investimento> lista = new ArrayList<Investimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_INVESTIMENTO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("CD_INVESTIMENTO");
				String nmEmail = rs.getString("T_FIN_LOGIN_NM_EMAIL");
				java.sql.Date data = rs.getDate("DT_DATA");
				Calendar dataInvestimento = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data.getTime());
				java.sql.Date data2 = rs.getDate("DT_VENCIMENTO");
				Calendar dataVenc = Calendar.getInstance();
				dataInvestimento.setTimeInMillis(data2.getTime());
				Float valor = rs.getFloat("VL_VALOR");
				String dsInvestimento = rs.getString("DS_INVESTIMENTO");

				// Cria um objeto investimento com as informações encontradas

				Investimento Investimento = new Investimento(codigo, nmEmail, data, dataVenc, valor, dsInvestimento);

				// Adiciona o recebimento na lista

				lista.add(Investimento);
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

	// DAO Listar Tipo Investimento

	public List<TipoInvestimento> listar7() {

		// Cria uma lista de Investimento

		List<TipoInvestimento> lista = new ArrayList<TipoInvestimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_TIPO_INVESTIMENTO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("CD_TIPO_INVESTIMENTO");
				int cdInvestimento = rs.getInt("T_FIN_RECEBIMENTO_CD_INVESTIMENTO");
				String tpInvestimento = rs.getString("TP_INVESTIMENTO");

				// Cria um objeto investimento com as informações encontradas

				TipoInvestimento tipoInvestimento = new TipoInvestimento(codigo, cdInvestimento, tpInvestimento);

				// Adiciona o recebimento na lista

				lista.add(tipoInvestimento);
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

	// DAO Listar Instituição de Investimento

	public List<InstInvestimento> listar8() {

		// Cria uma lista de Instituição de Investimento

		List<InstInvestimento> lista = new ArrayList<InstInvestimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_INSTITUICAO_INVESTIMENTO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {

				String nmInstituicao = rs.getString("NM_INSTITUICAO");
				String nmAplicacao = rs.getString("NM_APLICACAO");

				// Cria um objeto investimento com as informações encontradas

				InstInvestimento instInvestimento = new InstInvestimento(nmInstituicao, nmAplicacao);

				// Adiciona o recebimento na lista

				lista.add(instInvestimento);
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

	// DAO Cadastro Objetivo

	public void cadastrar(Objetivo objetivo) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_OBJETIVO (CD_OBJETIVO, T_FIN_LOGIN_NM_EMAIL, DT_DATA, VL_VALOR, DS_OBJETIVO) VALUES (SQ_FIN_OBJETIVO.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, objetivo.getNmEmail());
			java.sql.Date data = new java.sql.Date(objetivo.getData().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setFloat(3, objetivo.getValor());
			stmt.setString(4, objetivo.getDsObjetivo());

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

	// DAO cadastro Tipo de Objetivo

	public void cadastrar(TipoObjetivo tipoObjetivo) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FIN_TIPO_OBJETIVO (CD_TIPO_OBJETIVO, T_FIN_OBJETIVO_CD_OBJETIVO, TP_OBJETIVO) VALUES (SQ_FIN_TIPO_OBJETIVO.NEXTVAL, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, tipoObjetivo.getCdObjetivo());
			stmt.setString(2, tipoObjetivo.getTpObjetivo());

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

	// DAO Listar Objetivo

	public List<Objetivo> listar9() {

		// Cria uma lista de Objetivo

		List<Objetivo> lista = new ArrayList<Objetivo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_OBJETIVO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("CD_OBJETIVO");
				String nmEmail = rs.getString("T_FIN_LOGIN_NM_EMAIL");
				java.sql.Date data = rs.getDate("DT_DATA");
				Calendar dataObjetivo = Calendar.getInstance();
				dataObjetivo.setTimeInMillis(data.getTime());
				Float valor = rs.getFloat("VL_VALOR");
				String dsObjetivo = rs.getString("DS_OBJETIVO");

				// Cria um objeto recebimento com as informações encontradas

				Objetivo objetivo = new Objetivo(codigo, nmEmail, dataObjetivo, valor, dsObjetivo);

				// Adiciona o recebimento na lista

				lista.add(objetivo);
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

	// DAO Listar Tipo Objetivo

	public List<TipoObjetivo> listar10() {

		// Cria uma lista de Objetivo

		List<TipoObjetivo> lista = new ArrayList<TipoObjetivo>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_TIPO_OBJETIVO");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados

			while (rs.next()) {
				int codigo = rs.getInt("CD_TIPO_OBJETIVO");
				int cdObjetivo = rs.getInt("T_FIN_OBJETIVO_CD_OBJETIVO");
				String tpObjetivo = rs.getString("TP_OBJETIVO");

				// Cria um objeto objetivo com as informações encontradas

				TipoObjetivo tipoObjetivo = new TipoObjetivo(codigo, cdObjetivo, tpObjetivo);

				// Adiciona o Objetivo na lista

				lista.add(tipoObjetivo);
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

}
