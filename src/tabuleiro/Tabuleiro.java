package tabuleiro;

public class Tabuleiro {

	private int rowsLinhas;
	private int columnColuna;
	private Peca[][] pecas; // cria uma matriz

	public Tabuleiro(int rowsLinhas, int columnColuna) {
		if (rowsLinhas < 1 || columnColuna < 1) {
			throw new ExcecaoTabuleiro("Erro criando tabuleiro: é necessário que tenha pelo menos 1 linha e 1 coluna");
		}
		this.rowsLinhas = rowsLinhas;
		this.columnColuna = columnColuna;
		pecas = new Peca[rowsLinhas][columnColuna];
	}

	public int getRowsLinhas() {
		return rowsLinhas;
	}

	public int getColumnColuna() {
		return columnColuna;
	}

	public Peca peca(int rowsLinhas, int columnColuna) {
		if(!posiçãoExiste(rowsLinhas,columnColuna)) {
			throw new ExcecaoTabuleiro("Não existe posição no tabuleiro");
		}
		return pecas[rowsLinhas][columnColuna];
	}

	public Peca peca(Posicao posicao) {
		if(!posiçãoExiste(posicao)) {
			throw new ExcecaoTabuleiro("Não existe posição no tabuleiro");
		}
		return pecas[posicao.getRowFileira()][posicao.getColumnColuna()];
	}
	
	public void colocarPeca (Peca peca, Posicao posicao) {
		if(haPeca(posicao)) {
			throw new ExcecaoTabuleiro("Já existe uma peça na posicao " + posicao);
		}
		pecas[posicao.getRowFileira()][posicao.getColumnColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean posiçãoExiste(int linha, int coluna) {
		return linha >= 0 && linha < rowsLinhas && coluna >= 0 && coluna < columnColuna; 
	}
	
	public boolean posiçãoExiste(Posicao posicao) {
		return posiçãoExiste(posicao.getRowFileira(), posicao.getColumnColuna());
	}
	
	public boolean haPeca(Posicao posicao) {
		if(!posiçãoExiste(posicao)) {
			throw new ExcecaoTabuleiro("Não existe posição no tabuleiro");
		}
		return peca(posicao) != null;
	}
	
	

}
