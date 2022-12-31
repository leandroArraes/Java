package estruturascondicionais;

public class TesteOperadoresLogicos1 {
	public static void main(String[] args) {
		int a = 3;
		int b = 2;
		char c = 'z';
		char d = 'k';
		boolean e = true;
		boolean f = true;
		
		System.out.println("a = " + a );
		System.out.println("b = " + b );
		System.out.println("c = " + c );
		System.out.println("d = " + d );
		System.out.println("e = " + e );
		System.out.println("f = " + f );
		
		System.out.println("a e maior que b E b maior que 1 = "+(a>b && b>1));
		System.out.println("c e maior que d E d maior que A = " + (c>d && d>'A'));
		System.out.println("a e igual a b OU b menor que 5 = " + (a == b || b < 5 ));
		System.out.println("c e igual b e OU d menor que w = " + (c == d || d<'w'));
		System.out.println("e ou EXCLUSIVO f = " + (e^f));
		System.out.println("Not e = " +(!e));
	}

}
