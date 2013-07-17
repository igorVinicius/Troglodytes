package dominioDoProblema;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Lance implements Jogada {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int linhaOrigem;
	protected int colunaOrigem;
	protected int linhaDestino;
	protected int colunaDestino;
	
	public Lance(int linhaA, int colunaA, int linhaB, int colunaB){
		linhaOrigem = Math.abs(linhaA - 6);
		colunaOrigem = colunaA;
		linhaDestino = Math.abs(linhaB - 6);
		colunaDestino = colunaB;
	}
	
	public int pegueLinhaOrigem(){
		return linhaOrigem;
	}
	
	public int pegueLinhaDestino(){
		return linhaDestino;
	}
	
	public int pegueColunaOrigem(){
		return colunaOrigem;
	}
	
	public int pegueColunaDestino(){
		return colunaDestino;
	}
}