package dominioDoProblema;

public class ImagemDeTabuleiro {
	protected int[][] mapa;
	
	public ImagemDeTabuleiro(int[][] mapa){
		this.mapa = mapa;
	}
	
	public int informarValor(int linha, int coluna){
		return mapa[linha][coluna];
	}
}