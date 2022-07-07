package tabuleiro;

public class Tabuleiro {

	private int rowsLinhas;
	private int columnColuna;
	private Peca[][] pecas; // cria uma matriz

	public Tabuleiro(int rowsLinhas, int columnColuna) {
		if (rowsLinhas < 1 || columnColuna < 1) {
			throw new ExcecaoTabuleiro("Erro criando tabuleiro: � necess�rio que tenha pelo menos 1 linha e 1 coluna");
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
		if(!posi��oExiste(rowsLinhas,columnColuna)) {
			throw new ExcecaoTabuleiro("N�o existe posi��o no tabuleiro");
		}
		return pecas[rowsLinhas][columnColuna];
	}

	public Peca peca(Posicao posicao) {
		if(!posi��oExiste(posicao)) {
			throw new ExcecaoTabuleiro("N�o existe posi��o no tabuleiro");
		}
		return pecas[posicao.getRowFileira()][posicao.getColumnColuna()];
	}
	
	public void colocarPeca (Peca peca, Posicao posicao) {
		if(haPeca(posicao)) {
			throw new ExcecaoTabuleiro("J� existe uma pe�a na posicao " + posicao);
		}
		pecas[posicao.getRowFileira()][posicao.getColumnColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean posi��oExiste(int linha, int coluna) {
		return linha >= 0 && linha < rowsLinhas && coluna >= 0 && coluna < columnColuna; 
	}
	
	public boolean posi��oExiste(Posicao posicao) {
		return posi��oExiste(posicao.getRowFileira(), posicao.getColumnColuna());
	}
	
	public boolean haPeca(Posicao posicao) {
		if(!posi��oExiste(posicao)) {
			throw new ExcecaoTabuleiro("N�o existe posi��o no tabuleiro");
		}
		return peca(posicao) != null;
	}
	
	

}
