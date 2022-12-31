package estruturascondicionais;

public class TesteIfElse1 {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		if (a==b) {
			System.out.println("A igual a B");
		} else {
			System.out.println("A diferente e B");
		}
		
		if (a != b)
			System.out.println("a diferente de b");
		a = b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		if (a == b)
			System.out.println("A e igual a B");
		else 
			System.out.println("A e diferente de B");
		
	}

}
