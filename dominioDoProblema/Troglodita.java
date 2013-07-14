package dominioDoProblema;

public class Troglodita {
	protected Posicao posicaoOcupada;
	protected Jogador jogadorDono;

	public Posicao peguePosicao() {
		return posicaoOcupada;
	}

	public boolean jogadorDono(Jogador possivelDono) {
		return possivelDono == jogadorDono;
		
	}

	public boolean retorneSimbolo() {
		return jogadorDono.obterSimbolo();
	}
}