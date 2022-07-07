package aplicacao;

import java.awt.Point;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;

public class App {

	public static void main(String[] args) {
		
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		UI.printTabuleiro(partidaDeXadrez.getpecas());

	}

}
