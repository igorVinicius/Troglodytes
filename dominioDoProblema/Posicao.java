package dominioDoProblema;

public class Posicao {
	protected boolean ocupada;
	protected int linha;
	protected int coluna;
	protected Troglodita troglodita;
	
	public Posicao(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}

	public boolean estaOcupada() {
		return ocupada;
	}

	public int pegueLinha() {
		return linha;
	}

	public int pegueColuna() {
		return coluna;
	}

	public Troglodita retorneTroglodita() {
		return troglodita;
	}
	
	public void removeTroglodita(){
		troglodita.definaPosicao(null);
		troglodita = null;
		ocupada = false;
	}
	
	public void definaTroglodita(Troglodita troglodita){
		this.troglodita = troglodita;
		troglodita.definaPosicao(this);
		ocupada = true;
	}
}