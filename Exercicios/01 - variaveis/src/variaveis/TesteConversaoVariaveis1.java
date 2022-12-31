package variaveis;

public class TesteConversaoVariaveis1 {
	public static void main(String[] args) {
		// converção implicita de tipo 
		
		int a = 5;
		float b = 10.5f; // precisa colocar a letra f no final para que seja considerado float e não double 
		b = a;
		// converção explicita de tipo 
		int c = (int) b; //exemplo cast 
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("c = "+c );
	}

}
