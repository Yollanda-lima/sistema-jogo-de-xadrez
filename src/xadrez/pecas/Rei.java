package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Rei extends PecaDeXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "R"; // R de Rei
	}

	private boolean podeMover(Posicao posicao) {
		PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(posicao);
		return p == null || p.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getRowsLinhas()][getTabuleiro().getColumnColuna()];

		Posicao p = new Posicao(0, 0);

		p.setValores(posicao.getRowFileira() - 1, posicao.getColumnColuna());
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
		}
		p.setValores(posicao.getRowFileira() + 1, posicao.getColumnColuna());
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
		}
		p.setValores(posicao.getRowFileira(), posicao.getColumnColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
		}
		p.setValores(posicao.getRowFileira(), posicao.getColumnColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
		}
		p.setValores(posicao.getRowFileira() - 1, posicao.getColumnColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
		}
		p.setValores(posicao.getRowFileira() - 1, posicao.getColumnColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
		}
		p.setValores(posicao.getRowFileira() + 1, posicao.getColumnColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
		}
		p.setValores(posicao.getRowFileira() + 1, posicao.getColumnColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
		}
		return matriz;
	}

}
