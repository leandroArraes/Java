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


import lojaAutomovel.Classes.Automovel;
import lojaAutomovel.Classes.Negocio;


public class janelaAutomoveis {
	//Janela automoveis
	public static JFrame CriarJanelaAutomoveis () {
	// Define a janela
			JFrame janelaAutomoveis = new JFrame("Automoveis"); // Janela Normal
			janelaAutomoveis.setResizable(false); // A janela não poderá ter o tamanho ajustado
			janelaAutomoveis.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			janelaAutomoveis.setSize(500, 360); // Define tamanho da janela
			
			// Define o layout da janela
			Container caixa = janelaAutomoveis.getContentPane();
			caixa.setLayout(null);
			
			// Define os labels dos campos
				JLabel labelCodigo      = new JLabel("Codigo: ");
				JLabel labelFabricante  = new JLabel("Fabricante: ");
				JLabel labelModelo      = new JLabel("Modelo: ");
				JLabel labelPreco       = new JLabel("Preco: ");
			
			// Posiciona os labels na janela
				labelCodigo.setBounds		(50, 40,  100, 20); // coluna, linha, largura, tamanho
				labelFabricante.setBounds	(50, 70,  100, 20); // coluna, linha, largura, tamanho
				labelModelo.setBounds		(50, 100, 100, 20);
				labelPreco.setBounds		(50, 130, 100, 20);
			
			// Define os input box
				JTextField jTextcodigo     = new JTextField();
				JTextField jTextfabricante = new JTextField();
				JTextField jTextmodelo     = new JTextField();
				JTextField jTextpreco      = new JTextField();
			
			// Define se os campos estão habilitados ou não no início
				jTextcodigo.setEnabled(true);
				jTextfabricante.setEnabled(false);
				jTextmodelo.setEnabled(false);
				jTextpreco.setEnabled(false);
			
			// Posiciona os input box
				jTextcodigo.setBounds     (120, 40  , 160, 20);
				jTextfabricante.setBounds (120, 70  , 160, 20);
				jTextmodelo.setBounds     (120, 100 , 160, 20);
				jTextpreco.setBounds      (120, 130 , 160, 20);
			
			// Adiciona os rótulos e os input box na janela
				janelaAutomoveis.add(labelCodigo);
				janelaAutomoveis.add(labelFabricante);
				janelaAutomoveis.add(labelModelo);
				janelaAutomoveis.add(labelPreco);
				janelaAutomoveis.add(jTextcodigo);
				janelaAutomoveis.add(jTextfabricante);
				janelaAutomoveis.add(jTextmodelo);
				janelaAutomoveis.add(jTextpreco);
				
			// Define botões e a localização deles na janela	
				JButton botaoConsultar = new JButton("Consultar");
				botaoConsultar.setBounds(300, 40, 100, 20);
				janelaAutomoveis.add(botaoConsultar);	
				
				JButton botaoAtualizar = new JButton("Atualizar");
				botaoAtualizar.setBounds(300, 70, 100, 20);
				janelaAutomoveis.add(botaoAtualizar);	
				botaoAtualizar.setEnabled(false);
				
				JButton botaoCadastrar = new JButton("Cadastrar");
				botaoCadastrar.setBounds(300, 100, 100, 20);
				janelaAutomoveis.add(botaoCadastrar);
				botaoCadastrar.setEnabled(false);
				
				JButton botaoVender = new JButton("Vender");
				botaoVender.setBounds(300, 130, 100, 20);
				janelaAutomoveis.add(botaoVender);
				botaoVender.setEnabled(false);
				
				JButton botaoLimpar = new JButton("Limpar");
				botaoLimpar.setBounds(300, 190, 100, 20);
				janelaAutomoveis.add(botaoLimpar);
				
				
				Automovel automovel = new Automovel();
				
				botaoConsultar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(!automovel.consultarAuto(Integer.parseInt(jTextcodigo.getText()))) {
								JOptionPane.showMessageDialog(janelaAutomoveis,
										"Automovel não encontrado, tente novamente.");
										
								botaoCadastrar.setEnabled(true);
							}else {
								
								jTextcodigo.setText(Integer.toString(automovel.getCodigo()));
								jTextfabricante.setText(automovel.getFabricante());
								jTextmodelo.setText(automovel.getModelo());
								jTextpreco.setText(Double.toString(automovel.getPreco()));

								jTextfabricante.setEnabled(true);
								jTextmodelo.setEnabled(true);
								jTextpreco.setEnabled(true);
								botaoVender.setEnabled(true);
								botaoAtualizar.setEnabled(true);
								botaoCadastrar.setEnabled(false);
								JOptionPane.showMessageDialog(janelaAutomoveis,
										"Automovel encontrado!");
							}
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				});
				
				botaoAtualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(JOptionPane.showConfirmDialog(janelaAutomoveis, "Tem Certeza?") == 0) {
								if(!automovel.atualizarAuto(Integer.parseInt(jTextcodigo.getText()) ,jTextfabricante.getText(), jTextmodelo.getText(), Double.parseDouble(jTextpreco.getText()))) {
									JOptionPane.showMessageDialog(janelaAutomoveis, "Não foi possivel atualizar o cliente");
								}else {
									JOptionPane.showMessageDialog(janelaAutomoveis, "Atualização realizada");
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
							if(JOptionPane.showConfirmDialog(janelaAutomoveis, "Tem Certeza?") == 0) {
								if(!automovel.consultarAuto(Integer.parseInt(jTextcodigo.getText()))) {
									automovel.cadastrarAuto(Integer.parseInt(jTextcodigo.getText()), jTextfabricante.getText(), jTextmodelo.getText(), Double.parseDouble(jTextpreco.getText()));
								}else {
									JOptionPane.showMessageDialog(janelaAutomoveis, "Veiculo já cadastrado");
									botaoCadastrar.setEnabled(false);
								}
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				});
				Negocio negocio = new Negocio();
				botaoVender.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(JOptionPane.showConfirmDialog(janelaAutomoveis, "Tem Certeza?") == 0) {
							if (automovel.consultarAuto(Integer.parseInt(jTextcodigo.getText()))){
									if(!negocio.consultarNegocio(jTextcodigo.getText())) {
										JFrame janelaVenda = janelaVendas.CriarJanelaVenda(automovel);
										janelaVenda.setVisible(true);
									}else {
										JOptionPane.showMessageDialog(janelaAutomoveis, "Veiculo indisponível");
									}
							}else {
								JOptionPane.showMessageDialog(janelaAutomoveis, "Veiculo Não encontrado");
							}
						}
					}
				});
				
				botaoLimpar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jTextcodigo.setText(""); // Limpar campo
						jTextfabricante.setText(""); // Limpar campo
						jTextmodelo.setText(""); // Limpar campo
						jTextpreco.setText("");
						
						jTextcodigo.requestFocus(); // Colocar o foco em um campo
					}
				});
				
			return janelaAutomoveis;
}


}
