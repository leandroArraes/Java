package br.senac.rj.empresa.teste;

import java.util.Scanner;

import br.senac.rj.empresa.modelo.Material;


public class TesteMaterial1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Material material_1 = new Material();
		Scanner sc = new Scanner(System.in);
		int op;
		int valor;
		
		do {
			System.out.println("1 - Cadastrar material");
			System.out.println("2 - Entrada de material");
			System.out.println("3 - Saida de material");
			System.out.println("4 - Consultar saldo em estoque");
			System.out.println("5 - Encerrar");
			System.out.println("Entre com a Opcao: ");
			
			op = Integer.parseInt(sc.nextLine());
			
			if ((op < 1) || (op > 5)) {System.out.println("\n Opcao incorreta! \n");};
			
			switch (op) {
			case 1:
				System.out.println("codigo  do material:");
						int cod = Integer.parseInt(sc.nextLine());
						System.out.println("Descricao do material:");
						String descMat = sc.nextLine();
						material_1.setCodMaterial(cod);
						material_1.setDescMaterial(descMat);						
				break;
				
			case 2:
				System.out.println("quantidade de material a ser adicionada: ");
				int qtt = Integer.parseInt(sc.nextLine());
				material_1.entrarMaterial(qtt);		
				break;
				
			case 3:
				System.out.println("quantidade de material a ser retirada: ");
				int qt = Integer.parseInt(sc.nextLine());
				material_1.sairMaterial(qt);		
				break;
				
			case 4:
				System.out.println("Codigo: " + material_1.getCodMaterial());
				System.out.println("Descricao: " + material_1.getDescMaterial());
				System.out.println("quantidade: " + material_1.getQtdeEstoque());						
				break;
				
			case 5:
				System.out.println("Fim");
				op = 5;						
				break;
			}
			
			
	
		} while (op != 5);
		sc.close();
	}

}
