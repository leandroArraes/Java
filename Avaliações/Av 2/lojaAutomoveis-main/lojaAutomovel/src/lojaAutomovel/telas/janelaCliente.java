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
import lojaAutomovel.Classes.Cliente;

public class janelaCliente {
	//Janela Clientes
			public static JFrame criarJanelaClientes () {
				
				// Define a janelaClientes
						JFrame janelaClientes = new JFrame("Clientes"); // Janela Normal
						janelaClientes.setResizable(false); // A janela não poderá ter o tamanho ajustado
						janelaClientes.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						janelaClientes.setSize(500, 360); // Define tamanho da janela
						
						// Define o layout da janela
							Container caixa = janelaClientes.getContentPane();
							caixa.setLayout(null);
						
						// Define os labels dos campos
							JLabel labelNome     = new JLabel("Nome: ");
							JLabel labelCPF      = new JLabel("CPF: ");
							JLabel labelCidade   = new JLabel("Cidade: ");
							JLabel labelEstado   = new JLabel("Estado: ");
						
						// Posiciona os labels na janela
							labelCPF.setBounds	  (50, 40,  100, 20); // coluna, linha, largura, tamanho
							labelNome.setBounds	  (50, 70,  100, 20); // coluna, linha, largura, tamanho
							labelCidade.setBounds (50, 100, 100, 20);
							labelEstado.setBounds (50, 130, 100, 20);
						
						// Define os input box
							JTextField jTextNome     = new JTextField();
							JTextField jTextCPF 	 = new JTextField();
							JTextField jTextCidade   = new JTextField();
							JTextField jTextEstado   = new JTextField();
						
						// Define se os campos estão habilitados ou não no início
							jTextCPF.setEnabled(true);
							jTextNome.setEnabled(false);
							jTextCidade.setEnabled(false);
							jTextEstado.setEnabled(false);
						
						// Posiciona os input box
							jTextCPF.setBounds        (120,  40 , 160, 20);
							jTextNome.setBounds       (120,  70 , 160, 20);
							jTextCidade.setBounds     (120, 100 , 160, 20);
							jTextEstado.setBounds     (120, 130 , 160, 20);
						
						// Adiciona os rótulos e os input box na janela
							janelaClientes.add(labelNome);
							janelaClientes.add(labelCPF);
							janelaClientes.add(labelCidade);
							janelaClientes.add(labelEstado);
							janelaClientes.add(jTextNome);
							janelaClientes.add(jTextCPF);
							janelaClientes.add(jTextCidade);
							janelaClientes.add(jTextEstado);
							
						// Define botões e a localização deles na janela	
							JButton botaoConsultar = new JButton("Consultar");
							botaoConsultar.setBounds(300, 40, 100, 20);
							janelaClientes.add(botaoConsultar);	
							
							JButton botaoAtualizar = new JButton("Atualizar");
							botaoAtualizar.setBounds(300, 70, 100, 20);
							janelaClientes.add(botaoAtualizar);	
							botaoAtualizar.setEnabled(false);
							
							JButton botaoCadastrar = new JButton("Cadastrar");
							botaoCadastrar.setBounds(300, 100, 100, 20);
							janelaClientes.add(botaoCadastrar);	
							botaoCadastrar.setEnabled(false);
							
							JButton botaoLimpar = new JButton("Limpar");
							botaoLimpar.setBounds(300, 180, 100, 20);
							janelaClientes.add(botaoLimpar);
							
							Cliente cliente = new Cliente();
							
							botaoConsultar.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									try {
										if(!cliente.consultarCliente(jTextCPF.getText())) {
											JOptionPane.showMessageDialog(janelaClientes,
													"Cliente não encontrado, tente novamente.");
											botaoCadastrar.setEnabled(true);
										}else {
											
											jTextCidade.setText(cliente.getCidade());
											jTextEstado.setText(cliente.getEstado());
											jTextNome.setText(cliente.getNome());

											jTextNome.setEnabled(true);
											jTextCidade.setEnabled(true);
											jTextEstado.setEnabled(true);
											botaoCadastrar.setEnabled(false);
											botaoAtualizar.setEnabled(true);
											JOptionPane.showMessageDialog(janelaClientes,
													"Cliente encontrado!");
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
										if(JOptionPane.showConfirmDialog(janelaClientes, "Tem Certeza?") == 0) {
											
											if(!cliente.atualizarCliente(jTextNome.getText() ,jTextCPF.getText(), jTextCidade.getText(), jTextEstado.getText())) {
												JOptionPane.showMessageDialog(janelaClientes, "Não foi possivel atualizar o cliente");
											}else {
												JOptionPane.showMessageDialog(janelaClientes, "Atualização realizada");
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
										if(JOptionPane.showConfirmDialog(janelaClientes, "Tem Certeza?") == 0) {
											
											if(!cliente.consultarCliente(jTextCPF.getText())) {
												cliente.cadastrarCliente(jTextCPF.getText(), jTextNome.getText(), jTextCidade.getText(), jTextEstado.getText());
											}else {
												JOptionPane.showMessageDialog(janelaClientes, "Usuario ja cadastrado");
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
									jTextNome.setText(""); // Limpar campo
									jTextCPF.setText(""); // Limpar campo
									jTextCidade.setText(""); // Limpar campo
									jTextEstado.setText("");
									
									jTextCPF.requestFocus(); // Colocar o foco em um campo
									
								}
							});
							
						return janelaClientes;
			}


}
