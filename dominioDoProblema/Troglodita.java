package dominioDoProblema;

public class Troglodita {
	protected Posicao posicaoOcupada;
	protected Jogador jogadorDono;

	public Posicao peguePosicao() {
		return posicaoOcupada;
	}
	
	public void definaPosicao(Posicao posicao){
		this.posicaoOcupada = posicao;
	}

	public boolean jogadorDono(Jogador possivelDono) {
		return possivelDono == jogadorDono;
		
	}
	
	public void defineJogadorDono(Jogador novoDono){
		jogadorDono = novoDono;
	}

	public boolean retorneSimbolo() {
		return jogadorDono.obterSimbolo();
	}
}