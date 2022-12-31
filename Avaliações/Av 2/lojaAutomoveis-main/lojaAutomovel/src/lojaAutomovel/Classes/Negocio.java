package lojaAutomovel.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lojaAutomovel.conexao.Conexao;

public class Negocio {
	private String cpf;
	private String matricula;
	private int codigo;
	private String dataCompra;
	private double precoPago;
	
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
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public double getPrecoPago() {
		return precoPago;
	}
	public void setPrecoPago(double precoPago) {
		this.precoPago = precoPago;
	}
	
	
	public boolean cadastrarNegocio(String cpf, String matricula, int codigo, String dataCompra, double precoPago) {
		// Define a conex�o
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "insert into negocio set cpf=?, matricula=?, codigo=?, dataCompra=?, precoPago=?;";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setString(1, cpf); // Substitui o primeiro par�metro da consulta pela ag�ncia informada
			ps.setString(2, matricula);
			ps.setInt(3, codigo);
			ps.setString(4, dataCompra);
			ps.setDouble(5, precoPago);// 
			int totalRegistrosAfetados = ps.executeUpdate();
			if (totalRegistrosAfetados == 0) {
				System.out.println("N�o foi feito o cadastro!!");
				return false;
			}
			System.out.println("Cadastro realizado!");
			return true;
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar negocio: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	
	public boolean consultarNegocio(String codigo) {
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "select * from negocio where codigo=?";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setString(1, codigo); // Substitui o primeiro par�metro da consulta pela ag�ncia informada
			// Executa a consulta, resultando em um objeto da classe ResultSet
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // Verifica se n�o est� antes do primeiro registro
				System.out.println(" Cliente nao tem compras no banco!");
				return false; // Conta n�o cadastrada
			} else {
				// Efetua a leitura do registro da tabela
				while (rs.next()) {
					this.cpf = rs.getString("cpf");
					this.matricula = rs.getString("matricula");
					this.codigo = rs.getInt("codigo");
					this.dataCompra = rs.getString("dataCompra");
					this.precoPago = rs.getDouble("precoPago");
				}
				return true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar negocio: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean consultarNegocioFuncionario(String matricula) {
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "select * from negocio where matricula=?";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setString(1, matricula); // Substitui o primeiro par�metro da consulta pela ag�ncia informada
			// Executa a consulta, resultando em um objeto da classe ResultSet
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // Verifica se n�o est� antes do primeiro registro
				System.out.println(" Funcionario nao tem vendas no banco!");
				return false; // Conta n�o cadastrada
			} else {
				// Efetua a leitura do registro da tabela
				while (rs.next()) {
					this.cpf = rs.getString("cpf");
					this.matricula = rs.getString("matricula");
					this.codigo = rs.getInt("codigo");
					this.dataCompra = rs.getString("dataCompra");
					this.precoPago = rs.getDouble("precoPago");
				}
				return true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar negocio: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
	
	public boolean consultarNegocioCliente(String cpf) {
		Connection conexao = null;
		try {
			conexao = Conexao.conectaBanco();
			// Define a consulta
			String sql = "select * from negocio where cpf=?";
			// Prepara a consulta
			PreparedStatement ps = conexao.prepareStatement(sql);
			// Define os par�metros da consulta
			ps.setString(1, cpf); // Substitui o primeiro par�metro da consulta pela ag�ncia informada
			// Executa a consulta, resultando em um objeto da classe ResultSet
			ResultSet rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // Verifica se n�o est� antes do primeiro registro
				System.out.println(" Funcionario nao tem vendas no banco!");
				return false; // Conta n�o cadastrada
			} else {
				// Efetua a leitura do registro da tabela
				while (rs.next()) {
					this.cpf = rs.getString("cpf");
					this.matricula = rs.getString("matricula");
					this.codigo = rs.getInt("codigo");
					this.dataCompra = rs.getString("dataCompra");
					this.precoPago = rs.getDouble("precoPago");
				}
				return true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao consultar negocio: " + erro.toString());
			return false;
		} finally {
			Conexao.fechaConexao(conexao);
		}
	}
}
