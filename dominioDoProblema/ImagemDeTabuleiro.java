package dominioDoProblema;

public class ImagemDeTabuleiro {
//	protected String mensagem;
	protected int[][] mapa;
	
	public ImagemDeTabuleiro(int[][] mapa){
		this.mapa = mapa;
//		this.mensagem = mensagem;
	}
	
	public int[][] obterMapa(){
		return mapa;
	}
	
//	public String mensagem(){
//		return mensagem;
//	}
}