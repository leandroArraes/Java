package br.senac.rj.empresa.modelo;

public class Material {
	
	private int codMaterial;
	private String descMaterial;
	private int qtdeEstoque;
	
	public int getCodMaterial() {
		return codMaterial;
	}
	public void setCodMaterial(int codMaterial) {
		this.codMaterial = codMaterial;
	}
	public String getDescMaterial() {
		return descMaterial;
	}
	public void setDescMaterial(String descMaterial) {
		this.descMaterial = descMaterial;
	}
	public int getQtdeEstoque() {
		return qtdeEstoque;
	}
	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	
	public void entrarMaterial(int valor) {
		this.qtdeEstoque += valor;
	}
	
	public void sairMaterial(int valor) {
		if ((this.qtdeEstoque - valor) <= 0)  { 
			System.out.println("Nao ha estoque suficiente!");
			} else { 
				this.qtdeEstoque -= valor ;
			}
		
	}
	
}


