package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		ConfiguracaoInicial();
	}

	
	public PecaDeXadrez [][] getpecas(){
		PecaDeXadrez[][] matriz = new PecaDeXadrez[tabuleiro.getRowsLinhas()][tabuleiro.getColumnColuna()];
		for(int i=0; i<tabuleiro.getRowsLinhas();i++) {
			for(int j=0; j<tabuleiro.getColumnColuna(); j++) {
				matriz[i][j] = (PecaDeXadrez) tabuleiro.peca(i,j);
			}
		}
		return matriz;
	}
	
	private void ConfiguracaoInicial() {
		tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
		tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 4));

	}
}
