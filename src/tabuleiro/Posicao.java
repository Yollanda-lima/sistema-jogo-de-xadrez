package tabuleiro;

public class Posicao {

	private int rowFileira;
	private int columnColuna;

	public Posicao(int rowFileira, int columnColuna) {
		this.rowFileira = rowFileira;
		this.columnColuna = columnColuna;
	}

	public int getRowFileira() {
		return rowFileira;
	}

	public void setRowFileira(int rowFileira) {
		this.rowFileira = rowFileira;
	}

	public int getColumnColuna() {
		return columnColuna;
	}

	public void setColumnColuna(int columnColuna) {
		this.columnColuna = columnColuna;
	}

	@Override // imprimir a posição na tela
	public String toString() {
		return rowFileira + ", " + columnColuna;
	}
}
