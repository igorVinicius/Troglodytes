package dominioDoProblema;

import java.util.ArrayList;

public class Jogador {
	protected String nome;
	protected ArrayList<Troglodita> personagens;
	protected boolean vencedor;
	protected boolean daVez;
	protected boolean simbolo;
	
	public boolean obterDaVez() {
		return daVez;
	}

	public void defineVencedor() {
		throw new UnsupportedOperationException();
	}

	public boolean obterSimbolo() {
		throw new UnsupportedOperationException();
	}

	public void defineDaVez(boolean daVez) {
		this.daVez = daVez;
	}

	public boolean haTrogloditas() {
		throw new UnsupportedOperationException();
	}
	
	
}