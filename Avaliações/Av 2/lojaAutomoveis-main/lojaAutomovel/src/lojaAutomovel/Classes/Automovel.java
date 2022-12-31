package lojaAutomovel.Classes;

import java.sql.Connection;
import lojaAutomovel.conexao.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Automovel {
	private int codigo;
	private String fabricante;
	private String modelo;
	private double preco;
	
	 public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	public boolean cadastrarAuto(int codigo, String fabricante , String modelo, double preco) {
		// Define a conex�o
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "insert into automovel set codigo=?, fabricante=?, modelo=?, preco=0;";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setInt(1, codigo); // Substitui o primeiro par�metro da consulta pela ag�ncia informada
			ps.setString(2, fabricante); // Substitui o segundo par�metro da consulta pela conta informada
			ps.setString(3, modelo); // Substitui o terceiro par�metro da consulta pelo titular informado
			ps.setDouble(4, preco);
			int totalRegistrosAfetados = ps.executeUpdate();
			if (totalRegistrosAfetados == 0) {
				System.out.println("N�o foi feito o cadastro!!");
				return false;
			}
			System.out.println("Cadastro realizado!");
			return true;
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar automovel: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	
	public boolean consultarAuto(int codigo) {
		// Define a conex�o
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "select * from automovel where codigo=? and statusVenda=?";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setInt(1, codigo);
			ps.setInt(2, 0);
			// Executa a consulta, resultando em um objeto da classe ResultSet
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // Verifica se n�o est� antes do primeiro registro
				System.out.println("Automovel nao cadastrado!");
				return false; // Automovel n�o cadastrada
			} else {
				// Efetua a leitura do registro da tabela
				while (rs.next()) {
					this.codigo = rs.getInt("codigo");
					this.fabricante = rs.getString("fabricante");
					this.modelo = rs.getString("modelo");
					this.preco = rs.getDouble("preco");
				}
				return true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar o automovel: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean atualizarAuto(int codigo, String fabricante, String modelo, double preco) {
		if (!consultarAuto(codigo))
			return false;
		else {
			// Define a conex�o
			Connection conexao = null;
			try {
				// Define a conex�o
				conexao = Conexao.conectaBanco();
				// Define a consulta
				String sql = "update automovel set preco=? where codigo=? and fabricante=? and modelo=?";
				// Prepara a consulta
				PreparedStatement ps = conexao.prepareStatement(sql);
				// Define os par�metros da atualiza��o
				ps.setDouble(1, preco);
				ps.setInt(2, codigo);
				ps.setString(3, fabricante);
				ps.setString(4, modelo);
				int totalRegistrosAfetados = ps.executeUpdate();
				if (totalRegistrosAfetados == 0)
					System.out.println("N�o foi feita a atualiza��o!");
				else
					System.out.println("Atualiza��o realizada!");
				return true;
			} catch (SQLException erro) {
				System.out.println("Erro ao atualizar automovel: " + erro.toString());
				return false;
			} finally {
				Conexao.fechaConexao(conexao);
			}
		}
	}
	
	public boolean removerAuto(int codigo) {
		// Define a conex�o
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "update automovel set statusVenda=? where codigo=?;";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setInt(1, 1);
			ps.setInt(2, codigo);// Substitui o terceiro par�metro da consulta pelo titular informado
			int totalRegistrosAfetados = ps.executeUpdate();
			if (totalRegistrosAfetados == 0) {
				System.out.println("N�o foi feito a remoção!!");
				return false;
			}
			System.out.println("Remoção realizada!");
			return true;
		} catch (SQLException erro) {
			System.out.println("Erro ao remover automovel: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}

}
}
