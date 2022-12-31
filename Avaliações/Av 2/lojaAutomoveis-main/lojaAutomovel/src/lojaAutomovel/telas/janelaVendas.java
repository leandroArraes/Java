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
import lojaAutomovel.Classes.Cliente;
import lojaAutomovel.Classes.Funcionario;
import lojaAutomovel.Classes.Negocio;

public class janelaVendas {
	
	    //Janela venda
			public static JFrame CriarJanelaVenda(Automovel automovel){
			JFrame janelaVenda = new JFrame("Venda"); // Janela Normal
			janelaVenda.setResizable(false); // A janela não poderá ter o tamanho ajustado
			janelaVenda.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			janelaVenda.setSize(500, 360); // Define tamanho da janela
			
		// Define o layout da janela
			Container caixa = janelaVenda.getContentPane();
			caixa.setLayout(null);
			
		// Define os labels dos campos
				JLabel labelCpf         = new JLabel("CPF Cliente: ");
				JLabel labelMatricula   = new JLabel("Mat.Vendedor: ");
				JLabel labelCodigo      = new JLabel("Cod. Veiculo: ");
				JLabel labelPreco       = new JLabel("Preco: ");
				JLabel labelData        = new JLabel("Data: ");
			
			// Posiciona os labels na janela
				labelCpf.setBounds		    (50, 40,  120, 20); // coluna, linha, largura, tamanho
				labelMatricula.setBounds	(50, 70,  120, 20); // coluna, linha, largura, tamanho
				labelCodigo.setBounds		(50, 100, 120, 20);
				labelPreco.setBounds		(50, 130, 120, 20);
				labelData.setBounds		    (50, 160, 120, 20);
				
			// Define os input box
				JTextField jTextCpf        = new JTextField();
				JTextField jTextMatricula  = new JTextField();
				JTextField jTextCodigo     = new JTextField();
				JTextField jTextPreco      = new JTextField();
				JTextField jTextData       = new JTextField();
			
			// Define se os campos estão habilitados ou não no início
				jTextCpf.setEnabled(true);
				jTextMatricula.setEnabled(true);
				jTextCodigo.setEnabled(true);
				jTextPreco.setEnabled(true);
			
			// Posiciona os input box
				jTextCpf.setBounds        (160,  40 , 160, 20);
				jTextMatricula.setBounds  (160,  70 , 160, 20);
				jTextCodigo.setBounds     (160, 100 , 160, 20);
				jTextPreco.setBounds      (160, 130 , 160, 20);
				jTextData.setBounds		  (160, 160 , 160, 20);
			
			// Adiciona os rótulos e os input box na janela
				janelaVenda.add(labelCpf);
				janelaVenda.add(labelMatricula);
				janelaVenda.add(labelCodigo);
				janelaVenda.add(labelPreco);
				janelaVenda.add(jTextCpf);
				janelaVenda.add(jTextMatricula);
				janelaVenda.add(jTextCodigo);
				janelaVenda.add(jTextPreco);
				janelaVenda.add(labelData);
				janelaVenda.add(jTextData);
				
				jTextCodigo.setEditable(false);
				
				jTextCodigo.setText(Integer.toString(automovel.getCodigo()));
				
				JButton botaoConfirmacaoButton = new JButton("Confirmar");
				botaoConfirmacaoButton.setBounds(350, 250, 100, 20);
				janelaVenda.add(botaoConfirmacaoButton);
				
				Cliente cliente = new Cliente();
				Funcionario funcionario = new Funcionario();
				Negocio negocio = new Negocio();

				botaoConfirmacaoButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(JOptionPane.showConfirmDialog(janelaVenda, "Tem Certeza?") == 0) {
								
								if(cliente.consultarCliente(jTextCpf.getText())) {
									if(funcionario.consultarFuncionario(jTextMatricula.getText())) {
										negocio.cadastrarNegocio(jTextCpf.getText(), jTextMatricula.getText(), automovel.getCodigo(), jTextData.getText(), Double.parseDouble(jTextPreco.getText()));
										automovel.removerAuto(automovel.getCodigo());
										JOptionPane.showMessageDialog(janelaVenda, "Venda Concluida?");
										janelaVenda.dispose();
									}else {
										JOptionPane.showMessageDialog(janelaVenda, "Funcionario não encontrado");
									}
								}else {
									JOptionPane.showMessageDialog(janelaVenda, "Cliente não encontrado");
								}
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
						
					}
				});
			return janelaVenda;
		}
		
}
