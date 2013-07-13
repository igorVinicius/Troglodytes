package dominioDoProblema;

public class Tabuleiro {
	protected Posicao <<array_2D>>_posicoes;
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected boolean partidaEmAndamento;
	protected boolean conectado;
	protected boolean indicaClick;
	protected boolean pecaSelecionada;
	protected Troglodita trogloditaSelecionado;
	protected AtorJogador atorJogador;

	public void recebeClick(int aLinha, int aColuna) {
		throw new UnsupportedOperationException();
	}

	public ImagemDeTabuleiro informaEstado() {
		throw new UnsupportedOperationException();
	}

	protected int tratarLance(int aLinha, int aColuna) {
		throw new UnsupportedOperationException();
	}

	protected boolean distanciaPermitida(int aLinhaA, int aColunaA, int aLinhaB, int aColunaB) {
		throw new UnsupportedOperationException();
	}

	protected boolean existePPecaIntervalos(int aLinhaA, int aColunaA, int aLinhaB, int aColunaB) {
		throw new UnsupportedOperationException();
	}

	protected boolean verificaBlocosSuficientes(int aLinhaA, int aColunaA, int aLinhaB, int aColunaB) {
		throw new UnsupportedOperationException();
	}

	protected void removeAdversarios(int aLinhaA, int aColunaA, int aLinhaB, int aColunaB) {
		throw new UnsupportedOperationException();
	}

	protected void mover(int aLinhaFinal, int aColunaFinal) {
		throw new UnsupportedOperationException();
	}

	protected boolean verificaVencedor() {
		throw new UnsupportedOperationException();
	}

	protected boolean retornaSimboloDaVez() {
		throw new UnsupportedOperationException();
	}

	public boolean informarConectado() {
		throw new UnsupportedOperationException();
	}

	public void estabelecerConectado(boolean aValor) {
		throw new UnsupportedOperationException();
	}

	public void executarLanceRecebido(Lance aLance) {
		throw new UnsupportedOperationException();
	}

	public void esvaziarTabuleiro() {
		throw new UnsupportedOperationException();
	}

	public void criarJogador(String aNomeUsuario) {
		throw new UnsupportedOperationException();
	}

	public void habilitar(int aPosicao) {
		throw new UnsupportedOperationException();
	}

	public void posicionarTrogloditas(Jogador aJogadorA, Jogador aJogadorB) {
		throw new UnsupportedOperationException();
	}

	public int selecionarPeca(int aLinha, int aColuna) {
		throw new UnsupportedOperationException();
	}

	protected Jogador jogadorDaVez() {
		throw new UnsupportedOperationException();
	}
}