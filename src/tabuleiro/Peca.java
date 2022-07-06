package tabuleiro;

public class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null; // a posição inicial será nula
	}

	protected Tabuleiro getTabuleiro() { //visivel somente dentro do pacote tabuleiro e subclasse pecas
		return tabuleiro;
	}

}
