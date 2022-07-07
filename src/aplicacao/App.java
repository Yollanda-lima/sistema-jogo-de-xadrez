package aplicacao;

import java.awt.Point;
import java.util.Scanner;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		
		while (true) {
			UI.printTabuleiro(partidaDeXadrez.getpecas());
			System.out.println();
			System.out.println("Origem: ");
			PosicaoXadrez origem = UI.lerPosicaoDeXadrez(sc);
			
			System.out.println();
			System.out.println("Destino: ");
			PosicaoXadrez destino = UI.lerPosicaoDeXadrez(sc);
			
			PecaDeXadrez capurarPeca = partidaDeXadrez.executarMovimentoDeXadrez(origem, destino);
		}
	

	}

}
