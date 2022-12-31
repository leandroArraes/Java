package estruturascondicionais;

public class TesteOperadorTernario1 {
	public static void main(String[] args) {
		int idade = 16;
		System.out.println("idade = " + idade);
		System.out.println(idade>=18 ? "Adulto" : "nao e adulto");
		boolean vontade;
		vontade =(idade >= 16) ? true : false;
		System.out.println(vontade ? "pode votar" : "não pode votar");
	}

}
