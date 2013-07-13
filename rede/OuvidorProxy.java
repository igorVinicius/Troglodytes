package rede;
public interface OuvidorProxy {

	public void iniciarNovaPartida(int aPosicao);

	public void finalizarPartidaComErro(String aMessage);

	public void receberMensagem(String aMessage);

	public void receberJogada(Jogada aJogada);

	public void tratarConexaoPerdida();

	public void tratarPartidaNaoIniciada(String aMessage);
}