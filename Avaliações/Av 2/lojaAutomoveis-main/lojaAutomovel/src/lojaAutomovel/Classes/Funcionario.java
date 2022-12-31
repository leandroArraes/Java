package lojaAutomovel.Classes;



import lojaAutomovel.conexao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funcionario {
	private String nome;
	private String cpf;
	private String matricula;
	private String cargo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public boolean cadastrarFuncionario(String nome, String cpf, String matricula, String cargo) {
		// Define a conex�o
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "insert into funcionario(nome, cpf, matricula, cargo) values(?, ?, ?, ?);";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setString(1, nome);
			ps.setString(2, cpf);// Substitui o primeiro par�metro da consulta pela ag�ncia informada
			ps.setString(3, matricula); // Substitui o segundo par�metro da consulta pela conta informada
			ps.setString(4, cargo); // Substitui o terceiro par�metro da consulta pelo titular informado
			int totalRegistrosAfetados = ps.executeUpdate();
			if (totalRegistrosAfetados == 0) {
				System.out.println("Não foi feito o cadastro!!");
				return false;
			}
			System.out.println("Cadastro realizado!");
			return true;
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar funcionario: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	
	public boolean consultarFuncionario(String matricula) {
		// Define a conex�o
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "select * from funcionario where matricula=?";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setString(1, matricula); // Substitui o primeiro par�metro da consulta pela ag�ncia informada
			// Executa a consulta, resultando em um objeto da classe ResultSet
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // Verifica se n�o est� antes do primeiro registro
				System.out.println("Funcionario nao cadastrad!");
				return false; // Conta n�o cadastrada
			} else {
				// Efetua a leitura do registro da tabela
				while (rs.next()) {
					this.nome = rs.getString("nome");
					this.cpf = rs.getString("cpf");
					this.matricula = rs.getString("matricula");
					this.cargo = rs.getString("cargo");
				}
				return true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar funcionario: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean atualizarFuncionario(String nome, String cpf, String matricula, String cargo) {
		if (!consultarFuncionario(matricula))
			return false;
		else {
			// Define a conex�o
			Connection conexao = null;
			try {
				// Define a conex�o
				conexao = Conexao.conectaBanco();
				// Define a consulta
				String sql = "update funcionario set nome=?, cpf=?, cargo=? where matricula=?";
				// Prepara a consulta
				PreparedStatement ps = conexao.prepareStatement(sql);
				// Define os par�metros da atualiza��o
				ps.setString(1, nome);
				ps.setString(2, cpf);// Substitui o primeiro par�metro da consulta pela ag�ncia informada
				ps.setString(3, cargo); // Substitui o segundo par�metro da consulta pela conta informada
				ps.setString(4, matricula);
				int totalRegistrosAfetados = ps.executeUpdate();
				if (totalRegistrosAfetados == 0)
					System.out.println("N�o foi feita a atualizacao!");
				else
					System.out.println("Atualizacao realizada!");
				return true;
			} catch (SQLException erro) {
				System.out.println("Erro ao atualizar funcionario: " + erro.toString());
				return false;
			} finally {
				Conexao.fechaConexao(conexao);
			}
		}
	}

}
