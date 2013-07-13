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
	protected AtorJogador interfaceGrafica;
	protected Proxy proxy;

	public void enviarJogada(Lance aLance) {
		try {
			proxy.enviaJogada(lance);
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(interfaceGrafica.informarJanela(), e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean conectar(String servidor, String nome) {
		try {
			proxy.conectar(servidor, nome);
			return true;
		} catch (JahConectadoException e) {
			JOptionPane.showMessageDialog(interfaceGrafica.informaJanela(), e.getMessage());
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

	public void receberJogada(Lance aLance) {
		throw new UnsupportedOperationException();
	}

	public void iniciarNovaPartida(Integer aPosicao) {
		throw new UnsupportedOperationException();
	}

	public String informarNomeAdversario() {
		throw new UnsupportedOperationException();
	}

	public void finalizarPartidaComErro(String aMessage) {
		throw new UnsupportedOperationException();
	}

	public void receberMensagem(String aMessage) {
		throw new UnsupportedOperationException();
	}

	public void receberJogada(Jogada aJogada) {
		throw new UnsupportedOperationException();
	}

	public void tratarConexaoPerdida() {
		throw new UnsupportedOperationException();
	}

	public void tratarPartidaNaoIniciada(String aMessage) {
		throw new UnsupportedOperationException();
	}
}