package xadrez;

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
	
	private void lugarNovoPeca(char column, int row, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(column, row).posicionar());
	}
	
	private void ConfiguracaoInicial() {
		lugarNovoPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		lugarNovoPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));

	}
}
