package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T"; // T de Torre
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getRowsLinhas()][getTabuleiro().getColumnColuna()];

		Posicao p = new Posicao(0, 0);

		// cima
		p.setValores(posicao.getRowFileira() - 1, posicao.getColumnColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
			p.setRowFileira(p.getRowFileira() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;

		}

		// esquerda
		p.setValores(posicao.getRowFileira(), posicao.getColumnColuna() - 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
			p.setColumnColuna(p.getColumnColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;

		}

		// direita
		p.setValores(posicao.getRowFileira(), posicao.getColumnColuna() + 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
			p.setColumnColuna(p.getColumnColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;

		}

		// baixo
		p.setValores(posicao.getRowFileira() + 1, posicao.getColumnColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().haPeca(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;
			p.setRowFileira(p.getRowFileira() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && existePecaAdversaria(p)) {
			matriz[p.getRowFileira()][p.getColumnColuna()] = true;

		}

		return matriz;
	}

}
