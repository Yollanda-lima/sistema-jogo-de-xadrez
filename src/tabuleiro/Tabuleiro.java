package tabuleiro;

public class Tabuleiro {

	private int rowsFileiras;
	private int columnColuna;
	private Peca[][] pecas; // cria uma matriz

	public Tabuleiro(int rowsLinhas, int columnColuna) {
		if (rowsLinhas < 1 || columnColuna < 1) {
			throw new ExcecaoTabuleiro("Erro criando tabuleiro: e necessario que tenha pelo menos 1 linha e 1 coluna");
		}
		this.rowsFileiras = rowsLinhas;
		this.columnColuna = columnColuna;
		pecas = new Peca[rowsLinhas][columnColuna];
	}

	public int getRowsLinhas() {
		return rowsFileiras;
	}

	public int getColumnColuna() {
		return columnColuna;
	}

	public Peca peca(int rowsLinhas, int columnColuna) {
		if(!posiçãoExiste(rowsLinhas,columnColuna)) {
			throw new ExcecaoTabuleiro("Nao existe posicao no tabuleiro");
		}
		return pecas[rowsLinhas][columnColuna];
	}

	public Peca peca(Posicao posicao) {
		if(!posiçãoExiste(posicao)) {
			throw new ExcecaoTabuleiro("Nao existe posicao no tabuleiro");
		}
		return pecas[posicao.getRowFileira()][posicao.getColumnColuna()];
	}
	
	public void colocarPeca (Peca peca, Posicao posicao) {
		if(haPeca(posicao)) {
			throw new ExcecaoTabuleiro("Ja existe uma peca na posicao " + posicao);
		}
		pecas[posicao.getRowFileira()][posicao.getColumnColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removerPeca(Posicao posicao) {
		if (!posiçãoExiste(posicao)) {
			throw new ExcecaoTabuleiro("Nao existe posicao no tabuleiro");
		}
		if (peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getRowFileira()][posicao.getColumnColuna()] = null;
		return aux;
	}
	
	private boolean posiçãoExiste(int linha, int coluna) {
		return linha >= 0 && linha < rowsFileiras && coluna >= 0 && coluna < columnColuna; 
	}
	
	public boolean posiçãoExiste(Posicao posicao) {
		return posiçãoExiste(posicao.getRowFileira(), posicao.getColumnColuna());
	}
	
	public boolean haPeca(Posicao posicao) {
		if(!posiçãoExiste(posicao)) {
			throw new ExcecaoTabuleiro("Nao existe posicao no tabuleiro");
		}
		return peca(posicao) != null;
	}
	
	

}
