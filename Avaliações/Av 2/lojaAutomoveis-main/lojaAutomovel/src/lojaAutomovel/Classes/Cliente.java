package lojaAutomovel.Classes;


import lojaAutomovel.conexao.*;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {
	private String cpf;
	private String nome;
	private String cidade;
	private String estado;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public boolean cadastrarCliente(String cpf, String nome , String cidade, String estado) {
		// Define a conex�o
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "insert into cliente(nome, cpf, cidade, estado) Values(?, ?, ?, ?)";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setString(1, nome); // Substitui o primeiro par�metro da consulta pela ag�ncia informada
			ps.setString(2, cpf); // Substitui o segundo par�metro da consulta pela conta informada
			ps.setString(3, cidade); // Substitui o terceiro par�metro da consulta pelo titular informado
			ps.setString(4, estado);
			int totalRegistrosAfetados = ps.executeUpdate();
			if (totalRegistrosAfetados == 0) {
				System.out.println("N�o foi feito o cadastro!!");
				return false;
			}
			System.out.println("Cadastro realizado!");
			return true;
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar Cliente: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean consultarCliente(String cpf) {
		// Define a conex�o
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "select * from cliente where cpf=?";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setString(1, cpf); // Substitui o primeiro par�metro da consulta pela ag�ncia informada
			// Executa a consulta, resultando em um objeto da classe ResultSet
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // Verifica se n�o est� antes do primeiro registro
				System.out.println("Cliente nao cadastrad!");
				return false; // Conta n�o cadastrada
			} else {
				// Efetua a leitura do registro da tabela
				while (rs.next()) {
					this.cpf = rs.getString("cpf");
					this.nome = rs.getString("nome");
					this.cidade = rs.getString("cidade");
					this.estado = rs.getString("estado");
				}
				return true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar cliente: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean atualizarCliente(String nome, String cpf, String cidade, String estado) {
		if (!consultarCliente(cpf))
			return false;
		else {
			// Define a conex�o
			Connection conexao = null;
			try {
				// Define a conex�o
				conexao = Conexao.conectaBanco();
				// Define a consulta
				String sql = "update cliente set cidade=?, estado=? where cpf=?";
				// Prepara a consulta
				PreparedStatement ps = conexao.prepareStatement(sql);
				// Define os par�metros da atualiza��o
				ps.setString(1, cidade);
				ps.setString(2, estado);
				ps.setString(3, cpf);
				int totalRegistrosAfetados = ps.executeUpdate();
				if (totalRegistrosAfetados == 0)
					System.out.println("N�o foi feita a atualizacao!");
				else
					System.out.println("Atualizacao realizada!");
				return true;
			} catch (SQLException erro) {
				System.out.println("Erro ao atualizar cliente: " + erro.toString());
				return false;
			} finally {
				Conexao.fechaConexao(conexao);
			}
		}
	}
}
