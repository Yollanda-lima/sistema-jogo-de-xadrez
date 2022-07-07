package xadrez;

import tabuleiro.Tabuleiro;

public class PartidaDeXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
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
}
