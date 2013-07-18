package dominioDoProblema;

import rede.AtorNetGames;
import interfaceGrafica.InterfaceTroglodytes;

public class AtorJogador {
	protected Tabuleiro tabuleiro;
	protected AtorNetGames rede;
	protected String nomeUsuario;
	protected InterfaceTroglodytes janela;
	
	
	public AtorJogador(InterfaceTroglodytes janela){
		this.janela = janela;
		rede = new AtorNetGames(this);
		tabuleiro = new Tabuleiro(this);
		tabuleiro.definirPartidaEmAndamento(false);
		tabuleiro.estabelecerConectado(false);
	}

	

	public int click(int linha, int coluna) {
		int resultado = 0;
		resultado = tabuleiro.recebeClick(linha, coluna);
		return resultado;
	}
	
	public void enviarJogada(Lance lance) {
		rede.enviarJogada(lance);
	}

	public ImagemDeTabuleiro informaEstado() {
		return tabuleiro.informaEstado();
	}

	public int conectar() {
		boolean conectado = tabuleiro.informarConectado();
		if (!conectado){
			String servidor = this.obterDadosConexao();
			boolean exito = rede.conectar(servidor, nomeUsuario);
			if (exito){
				tabuleiro.estabelecerConectado(true);
				return 0;
			}else{
				return 2;
			}			
		}else{
			return 1;
		}		
	}
	

	public String obterDadosConexao() {
		nomeUsuario = janela.obterIdJogador();
		String servidor = janela.obterIdServidor();
		return servidor;
	}

	public int desconectar() {
		boolean conectado = tabuleiro.informarConectado();
		if (conectado){
			boolean exito = rede.desconectar();
			if (exito){
				tabuleiro.definirPartidaEmAndamento(false);
				tabuleiro.estabelecerConectado(false);
				return 3;
			}else{
				return 5;
			}			
		}else{
			return 4;
		}		
	}
	

	public int iniciarPartida() {
		
		boolean emAndamento = tabuleiro.informarPartidaEmAndamento();
		boolean conectado = tabuleiro.informarConectado();
		
		if (!emAndamento && conectado){
			rede.iniciarPartida();
			tabuleiro.definirPartidaEmAndamento(true);
			return 6;
		}
		if (!conectado) {
			return 7;
		}
		return 17;
	}

	public void tratarIniciarPartida(int posicao) {
		tabuleiro.esvaziarTabuleiro();
		tabuleiro.criarJogador(nomeUsuario);
		String idJogador = rede.informarNomeAdversario(nomeUsuario);
		tabuleiro.criarJogador(idJogador);
		tabuleiro.habilitar(posicao);
		janela.exibirEstado();
		if(posicao == 2){
			janela.notificarResultado(19);
		}
	}
	
		
	public void receberLance(Lance lance) {
		int resultado = tabuleiro.executarLanceRecebido(lance);
		janela.exibirEstado();
		janela.notificarResultado(resultado);
	}
	
	
	public InterfaceTroglodytes informarJanela(){
		return janela;
	}
	
	public boolean jogador1EhVencedor(){
		return tabuleiro.jogador1EhVencedor();
	}
	
	public String informaNomeJogador(int posicao){
		return tabuleiro.informaNomeJogador(posicao);
	}
	
	public boolean informarSimboloDaVez(){
		return tabuleiro.informarSimboloDaVez();
	}
}