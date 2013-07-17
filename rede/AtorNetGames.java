package rede;

import javax.swing.JOptionPane;

import dominioDoProblema.AtorJogador;
import dominioDoProblema.Lance;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorNetGames implements OuvidorProxy {
	
	private static final long serialVersionUID = 1L;
	
	protected AtorJogador interfaceGrafica;
	protected Proxy proxy;

	
	public AtorNetGames(AtorJogador interfaceGrafica){
		super();
		this.interfaceGrafica = interfaceGrafica;
		this.proxy = Proxy.getInstance();
		proxy.addOuvinte(this);	
	}
	
	
	public boolean conectar(String servidor, String nome) {
		try {
			proxy.conectar(servidor, nome);
			return true;
		} catch (JahConectadoException e) {
			JOptionPane.showMessageDialog(interfaceGrafica.informarJanela(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (NaoPossivelConectarException e) {
			JOptionPane.showMessageDialog(interfaceGrafica.informarJanela(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (ArquivoMultiplayerException e) {
			JOptionPane.showMessageDialog(interfaceGrafica.informarJanela(), e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean desconectar() {
		try {
			proxy.desconectar();
			return true;
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(interfaceGrafica.informarJanela(), e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public void iniciarPartida() {
		try {
			proxy.iniciarPartida(new Integer(2));
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(interfaceGrafica.informarJanela(), e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		interfaceGrafica.tratarIniciarPartida(posicao);
	}
	
	public void enviarJogada(Lance lance) {
		try {
			proxy.enviaJogada((Jogada) lance);
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(interfaceGrafica.informarJanela(), e.getMessage());
			e.printStackTrace();
		}
	}

	public void receberJogada(Lance lance) {
		Lance estado = (Lance) lance;
		interfaceGrafica.receberLance(estado);
	}

	

	public String informarNomeAdversario(String idUsuario) {
		String aux1 = proxy.obterNomeAdversario(new Integer(1));
		String aux2 = proxy.obterNomeAdversario(new Integer(2));;
		if (aux1.equals(idUsuario)){
			return aux2;
		} else {
			return aux1;
		}		
	}
	
	@Override
	public void receberJogada(Jogada jogada) {
		interfaceGrafica.receberLance((Lance) jogada);
	}

	public void finalizarPartidaComErro(String aMessage) {
		throw new UnsupportedOperationException();
	}

	public void receberMensagem(String aMessage) {
		throw new UnsupportedOperationException();
	}

	public void tratarConexaoPerdida() {
		throw new UnsupportedOperationException();
	}

	public void tratarPartidaNaoIniciada(String aMessage) {
		throw new UnsupportedOperationException();
	}
}