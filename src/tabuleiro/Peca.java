package tabuleiro;

import java.util.Iterator;

public abstract class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null; // a posição inicial será nula
	}

	protected Tabuleiro getTabuleiro() { // visivel somente dentro do pacote tabuleiro e subclasse pecas
		return tabuleiro;
	}

	public abstract boolean[][] movimentosPossiveis();

	public boolean movimentosPossiveis(Posicao posicao) {
		return movimentosPossiveis()[posicao.getRowFileira()][posicao.getColumnColuna()];
	}
	
	public boolean existeAlgumMovimentoPossivel() {
		boolean[][] matriz = movimentosPossiveis();
		 for (int i=0; i<matriz.length; i++) {
			 for (int j=0; j<matriz.length; j++) {
				 if(matriz[i][j]) {
					 return true;
				 }
			 }
		 }
		 return false;
	}
}
