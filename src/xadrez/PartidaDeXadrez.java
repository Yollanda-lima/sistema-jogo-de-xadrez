package xadrez;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

	private int virar;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	private boolean verifica;
	
	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();

	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		virar = 1;
		jogadorAtual = Cor.BRANCO;
		ConfiguracaoInicial();
	}

	public int getVirar() {
		return virar;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}
	
	public boolean getVerificar() {
		return verifica;
	}

	public PecaDeXadrez[][] getpecas() {
		PecaDeXadrez[][] matriz = new PecaDeXadrez[tabuleiro.getRowsLinhas()][tabuleiro.getColumnColuna()];
		for (int i = 0; i < tabuleiro.getRowsLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColumnColuna(); j++) {
				matriz[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		return matriz;
	}

	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem) {
		Posicao posicao = posicaoOrigem.posicionar();
		validarPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}

	public PecaDeXadrez executarMovimentoDeXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validarPosicaoOrigem(origem);
		validarPosicaoDestino(origem, destino);
		Peca capiturarPeca = fazerMover(origem, destino);
		
		if(testeCheck(jogadorAtual)) {
			desfazerMovimento(origem, destino, capiturarPeca);
			throw new ExcecaoXadrez("Voce nao pode se colocar em Check");
		}
		
		verifica = testeCheck(oponente(jogadorAtual)) ? true : false;
		
		proximaVirada();
		return (PecaDeXadrez) capiturarPeca;
	}

	private Peca fazerMover(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca capiturarPeca = tabuleiro.removerPeca(destino);
		tabuleiro.colocarPeca(p, destino);
		
		if (capiturarPeca != null) {
			pecasNoTabuleiro.remove(capiturarPeca);
			pecasCapturadas.add(capiturarPeca);
		}
		
		return capiturarPeca;
	}
	
	private void desfazerMovimento (Posicao origem, Posicao destino, Peca pecaCapturada) {
		Peca p = tabuleiro.removerPeca(destino);
		tabuleiro.colocarPeca(p, origem);
		
		if(pecaCapturada != null) {
			tabuleiro.colocarPeca(pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}
	}
	

	private void validarPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.haPeca(posicao)) {
			throw new ExcecaoXadrez("Nao existe peca na posicao de origem.");
		}
		if (jogadorAtual != ((PecaDeXadrez)tabuleiro.peca(posicao)).getCor()) {
			throw new ExcecaoXadrez("A peca escolhida nao e sua!");
		}
		if (!tabuleiro.peca(posicao).existeAlgumMovimentoPossivel()) {
			throw new ExcecaoXadrez("Nao existe movimentos possiveis para a peca escolhida");
		}
	}

	private void validarPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).movimentosPossiveis(destino)) {
			throw new ExcecaoXadrez("A peca escolhida nao pode se mover para a posicao de destino");
		}
	}
	
	private void proximaVirada() {
		virar++;
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private Cor oponente(Cor cor) {
		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private PecaDeXadrez rei(Cor cor) {
		List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peca p : list) {
			if (p instanceof Rei) {
				return (PecaDeXadrez)p;
			}
		}
		throw new IllegalStateException("Nao existe o rei" + cor + "no tabuleiro");
	}
	
	private boolean testeCheck(Cor cor) {
		Posicao reiPosicao = rei(cor).getPosicaoXadrez().posicionar();
		List<Peca> pecasOponentes = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getCor() == oponente (cor)).collect(Collectors.toList());
		for(Peca p: pecasOponentes) {
			boolean[][] mat = p.movimentosPossiveis();
			if(mat[reiPosicao.getRowFileira()][reiPosicao.getColumnColuna()]) {
				return true;
			}
		}
		return false;
	}

	private void lugarNovoPeca(char column, int row, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new PosicaoXadrez(column, row).posicionar());
		pecasNoTabuleiro.add(peca);
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
