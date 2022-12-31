package lojaAutomovel.telas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import lojaAutomovel.Classes.Funcionario;

public class janelaFuncionario {
	public static JFrame criarJanelaFuncionarios () {
		
		// Define a janelaClientes
			JFrame janelaFuncionarios = new JFrame("Funcionarios"); // Janela Normal
			janelaFuncionarios.setResizable(false); // A janela não poderá ter o tamanho ajustado
			janelaFuncionarios.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			janelaFuncionarios.setSize(500, 360); // Define tamanho da janela
		
		// Define o layout da janela
			Container caixa = janelaFuncionarios.getContentPane();
			caixa.setLayout(null);
		
			// Define os labels dos campos
			JLabel labelMatricula = new JLabel("Matricula: ");
			JLabel labelNome      = new JLabel("Nome: ");
			JLabel labelCPF       = new JLabel("CPF: ");
			JLabel labelCargo     = new JLabel("Cargo: ");
		
			// Posiciona os labels na janela
			labelMatricula.setBounds      (50, 40 , 100, 20);
			labelNome.setBounds           (50, 70  , 100, 20); // coluna, linha, largura, tamanho
			labelCPF.setBounds            (50, 100  , 100, 20); // coluna, linha, largura, tamanho
			labelCargo.setBounds          (50, 130 , 100, 20);
		
		// Define os input box
			JTextField jTextMatricula = new JTextField();
			JTextField jTextCPF       = new JTextField();
			JTextField jTextNome      = new JTextField();
			JTextField jTextCargo     = new JTextField();
		
		// Define se os campos estão habilitados ou não no início
			jTextMatricula.setEnabled(true);
			jTextNome.setEnabled(false);
			jTextCPF.setEnabled(false);
			jTextCargo.setEnabled(false);
		
		// Posiciona os input box
			jTextMatricula.setBounds  (120, 40 , 160, 20);
			jTextNome.setBounds       (120, 70  , 160, 20);
			jTextCPF.setBounds        (120, 100  , 160, 20);
			jTextCargo.setBounds      (120, 130 , 160, 20);
		
		// Adiciona os rótulos e os input box na janela
			janelaFuncionarios.add(labelNome);
			janelaFuncionarios.add(labelCPF);
			janelaFuncionarios.add(labelMatricula);
			janelaFuncionarios.add(labelCargo);
			janelaFuncionarios.add(jTextNome);
			janelaFuncionarios.add(jTextCPF);
			janelaFuncionarios.add(jTextMatricula);
			janelaFuncionarios.add(jTextCargo);
			
		// Define botões e a localização deles na janela	
			JButton botaoConsultar = new JButton("Consultar");
			botaoConsultar.setBounds(300, 40, 100, 20);
			janelaFuncionarios.add(botaoConsultar);	
			
			JButton botaoAtualizar = new JButton("Atualizar");
			botaoAtualizar.setBounds(300, 70, 100, 20);
			janelaFuncionarios.add(botaoAtualizar);	
			botaoAtualizar.setEnabled(false);
			
			JButton botaoCadastrar = new JButton("Cadastrar");
			botaoCadastrar.setBounds(300, 100, 100, 20);
			janelaFuncionarios.add(botaoCadastrar);	
			botaoCadastrar.setEnabled(false);
			
			JButton botaoLimpar = new JButton("Limpar");
			botaoLimpar.setBounds(300, 190, 100, 20);
			janelaFuncionarios.add(botaoLimpar);
			
			
			Funcionario funcionario = new Funcionario();
			
			botaoConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
							
						if(!funcionario.consultarFuncionario(jTextMatricula.getText())) {
							JOptionPane.showMessageDialog(janelaFuncionarios, "Funcionario não encontrado.");
							botaoCadastrar.setEnabled(true);

						}else {
							
							jTextMatricula.setText(funcionario.getMatricula());
							jTextCargo.setText(funcionario.getCargo());
							jTextNome.setText(funcionario.getNome());
							jTextCPF.setText(funcionario.getCpf());

							jTextCPF.setEnabled(true);
							jTextNome.setEnabled(true);
							jTextMatricula.setEnabled(true);
							jTextCargo.setEnabled(true);
							botaoAtualizar.setEnabled(true);
							botaoCadastrar.setEnabled(false);
							JOptionPane.showMessageDialog(janelaFuncionarios,
									"Funcionario encontrado!");
							botaoAtualizar.setEnabled(true);
						}
						
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			});
			
			botaoAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(JOptionPane.showConfirmDialog(janelaFuncionarios, "Tem Certeza?") == 0) {
							
							if(!funcionario.atualizarFuncionario(jTextNome.getText() ,jTextCPF.getText(), jTextMatricula.getText(), jTextCargo.getText())) {
								JOptionPane.showMessageDialog(janelaFuncionarios, "Não foi possivel atualizar o fincionario");
							}else {
								JOptionPane.showMessageDialog(janelaFuncionarios, "Atualização realizada");
							}
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			});
			
			botaoCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(JOptionPane.showConfirmDialog(janelaFuncionarios, "Tem Certeza?") == 0) {
							
							if(!funcionario.consultarFuncionario(jTextMatricula.getText())) {
								funcionario.cadastrarFuncionario(jTextNome.getText(), jTextCPF.getText(), jTextMatricula.getText(), jTextCargo.getText());
								JOptionPane.showMessageDialog(janelaFuncionarios, "Cadastrado realizado!");
							}else {
								JOptionPane.showMessageDialog(janelaFuncionarios, "Funcionario ja cadastrado");
								botaoCadastrar.setEnabled(false);
							}
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			});

			botaoLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						if(JOptionPane.showConfirmDialog(janelaFuncionarios, "Tem Certeza?") == 0) {
							
							jTextNome.setText(""); // Limpar campo
							jTextCPF.setText(""); // Limpar campo
							jTextMatricula.setText(""); // Limpar campo
							jTextCargo.setText("");
							
							jTextMatricula.requestFocus(); // Colocar o foco em um campo
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			});
			
		return janelaFuncionarios;
	}
}
