package tabuleiro;

public class Tabuleiro {

	private int rowsLinhas;
	private int columnColuna;
	private Peca[][] pecas; // cria uma matriz

	public Tabuleiro(int rowsLinhas, int columnColuna) {
		this.rowsLinhas = rowsLinhas;
		this.columnColuna = columnColuna;
		pecas = new Peca[rowsLinhas][columnColuna];
	}

	public int getRowsLinhas() {
		return rowsLinhas;
	}

	public void setRowsLinhas(int rowsLinhas) {
		this.rowsLinhas = rowsLinhas;
	}

	public int getColumnColuna() {
		return columnColuna;
	}

	public void setColumnColuna(int columnColuna) {
		this.columnColuna = columnColuna;
	}

}
