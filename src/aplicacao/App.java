package aplicacao;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.ExcecaoXadrez;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		List<PecaDeXadrez> capturar = new ArrayList<>();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printPartida(partidaDeXadrez, capturar);
				System.out.println();
				System.out.println("Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoDeXadrez(sc);
				
				boolean [][] movimentosPossiveis = partidaDeXadrez.movimentosPossiveis(origem);
				UI.clearScreen();
				UI.printTabuleiro(partidaDeXadrez.getpecas(), movimentosPossiveis);
				System.out.println();
				System.out.println("Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoDeXadrez(sc);
				
				PecaDeXadrez capurarPeca = partidaDeXadrez.executarMovimentoDeXadrez(origem, destino);
				
				if (capurarPeca != null) {
					capturar.add(capurarPeca);
				}
			}
			catch(ExcecaoXadrez e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
	
	
		}
	}

}
