package dominioDoProblema;

public class Posicao {
	protected boolean ocupada;
	protected int linha;
	protected int coluna;
	protected Troglodita troglodita;

	public boolean estaOcupada() {
		throw new UnsupportedOperationException();
	}

	public int pegueLinha() {
		throw new UnsupportedOperationException();
	}

	public int pegueColuna() {
		throw new UnsupportedOperationException();
	}

	public Troglodita retorneTroglodita() {
		throw new UnsupportedOperationException();
	}
	
	public void removeTroglodita(){
		troglodita = null;
	}
	
	public void definaTroglodita(Troglodita troglodita){
		this.troglodita = troglodita;
	}
}