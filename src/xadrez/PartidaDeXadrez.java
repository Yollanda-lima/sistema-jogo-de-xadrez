package xadrez;

import tabuleiro.Peca;
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
	
	public PecaDeXadrez executarMovimentoDeXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validarPosicaoOrigem(origem);
		Peca capiturarPeca = fazerMover(origem, destino);
		return (PecaDeXadrez)capiturarPeca;
	}
	
	private Peca fazerMover(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca capiturarPeca = tabuleiro.removerPeca(destino);
		tabuleiro.colocarPeca(p, destino);
		return capiturarPeca;
	}
	
	private void validarPosicaoOrigem(Posicao posicao) {
		if(!tabuleiro.haPeca(posicao)) {
			throw new ExcecaoXadrez("Nao existe peca na posicao de origem.");
		}
	}


	private void lugarNovoPeca(char column, int row, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(column, row).posicionar());
	}
	
	private void ConfiguracaoInicial() {
		lugarNovoPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		lugarNovoPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		lugarNovoPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		lugarNovoPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));

	}
}
