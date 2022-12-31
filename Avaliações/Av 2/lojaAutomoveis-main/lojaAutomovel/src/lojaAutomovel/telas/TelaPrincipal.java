package lojaAutomovel.telas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;




public class TelaPrincipal {
	
	//Janela principal
		public static void apresentarMenu() {
			//configura janela principal
			JFrame janelaPrincipal = new JFrame("Cadastro de conta");
			janelaPrincipal.setTitle("Auto Vendas");
			janelaPrincipal.setResizable(false);
			janelaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			janelaPrincipal.setSize(800, 600);
			
			// Cria uma barra de menu para a janela principal
				JMenuBar menuBar = new JMenuBar();
			
			// Adiciona a barra de menu ao frame
				janelaPrincipal.setJMenuBar(menuBar);
			
			// Define e adiciona menu na barra de menu
			
				JMenu menuAutomoveis   = new JMenu("Automoveis");
				JMenu menuClientes     = new JMenu("Clientes");
				JMenu menuFuncionarios = new JMenu("Funcionarios");
			
				menuBar.add(menuAutomoveis);
				menuBar.add(menuClientes);
				menuBar.add(menuFuncionarios);
				
			JMenuItem mAuto         = new JMenuItem("Automoveis ");
			JMenuItem mClientes     = new JMenuItem("Clientes ");
			JMenuItem mFuncionarios = new JMenuItem("Funcionarios ");
			
			menuAutomoveis.add(mAuto);
			menuClientes.add(mClientes);
			menuFuncionarios.add(mFuncionarios);

			JFrame janelaAutomovel    = janelaAutomoveis.CriarJanelaAutomoveis();
			JFrame janelaClientes     = janelaCliente.criarJanelaClientes();
			JFrame janelaFuncionarios = janelaFuncionario.criarJanelaFuncionarios();
					
			mAuto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					janelaAutomovel.setVisible(true);
				}
			});
			mClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					janelaClientes.setVisible(true);
				}
			});
			mFuncionarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					janelaFuncionarios.setVisible(true);
				}
			});
			
			
			janelaPrincipal.setVisible(true);
			
		}
	

	
	public static void main(String[] args) {
		apresentarMenu();
		}
}
