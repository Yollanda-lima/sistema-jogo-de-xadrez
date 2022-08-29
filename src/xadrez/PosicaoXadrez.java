package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {

	private char columnColuna;
	private int rowLinha;

	public PosicaoXadrez(char columnColuna, int rowLinha) {
		if(columnColuna < 'a' || columnColuna > 'h' || rowLinha < 1 || rowLinha > 8) {
			throw new ExcecaoXadrez("Erro instanciando ExcecaoXadrez. Valores válidos são de a1 até h8.");
		}
		this.columnColuna = columnColuna;
		this.rowLinha = rowLinha;
	}

	public char getColumnColuna() {
		return columnColuna;
	}

	public int getRowLinha() {
		return rowLinha;
	}
	
	protected Posicao posicionar() {
		return new Posicao(8 - rowLinha, columnColuna - 'a');
	}
	
	protected static PosicaoXadrez daPosicao (Posicao posicao) {
		return new PosicaoXadrez((char)('a' + posicao.getColumnColuna()),8 - posicao.getRowFileira());
	}
	
	@Override
	public String toString() {
		return "" + columnColuna + rowLinha;
	}

}
