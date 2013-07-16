package dominioDoProblema;

public class Posicao {
	protected boolean ocupada;
	protected int linha;
	protected int coluna;
	protected Troglodita troglodita;

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
		troglodita = null;
		ocupada = false;
	}
	
	public void definaTroglodita(Troglodita troglodita){
		this.troglodita = troglodita;
		ocupada = true;
	}
}