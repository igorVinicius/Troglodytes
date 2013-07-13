package dominioDoProblema;

import rede.AtorNetGames;
import InerfaceTroglodytes.InterfaceTroglodytes;

public class AtorJogador {
	protected Tabuleiro tabuleiro;
	protected AtorNetGames rede;
	protected String nomeUsuario;
	protected InterfaceTroglodytes janela;

	public void enviarJogada(Lance lance) {
		throw new UnsupportedOperationException();
	}

	public int click(int linha, int coluna) {
		throw new UnsupportedOperationException();
	}

	public ImagemDeTabuleiro informaEstado() {
		throw new UnsupportedOperationException();
	}

	public int conectar() {
		throw new UnsupportedOperationException();
	}

	public String obterDadosConexao() {
		throw new UnsupportedOperationException();
	}

	public int desconectar() {
		throw new UnsupportedOperationException();
	}

	public int iniciarPartida() {
		throw new UnsupportedOperationException();
	}

	public void receberLance(Lance lance) {
		throw new UnsupportedOperationException();
	}

	public void tratarIniciarPartida(int posicao) {
		throw new UnsupportedOperationException();
	}
}