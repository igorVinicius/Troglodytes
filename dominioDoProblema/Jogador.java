package dominioDoProblema;

import java.util.ArrayList;

public class Jogador {
	protected String nome;
	protected ArrayList<Troglodita> personagens;
	protected boolean vencedor;
	protected boolean daVez;
	protected boolean simbolo;
	
	public Jogador(String nome, int numeroTrogloditas){
		this.iniciar(nome);																						//MENSAGEM
		
		for(int i = 0; i < numeroTrogloditas; i++){
			this.criarTroglodita();														//MENSAGEM
		}
	}
	
	protected void iniciar(String nome) {
		personagens = new ArrayList<Troglodita>();
		daVez = false;
		vencedor = false;
		this.nome = nome;
	}
	
	public boolean obterDaVez() {
		return daVez;
	}
	
	public void defineDaVez(boolean daVez) {
		this.daVez = daVez;
	}

	public void defineVencedor() {
		vencedor = true;
	}
	
	public boolean ehVencedor(){
		return vencedor;
	}

	public boolean obterSimbolo() {
		return simbolo;
	}
	
	public void assumirSimbolo(boolean simbolo) {
		this.simbolo = simbolo;
	}

	public boolean haTrogloditas() {
		return !personagens.isEmpty();
	}
	
	public void removeTroglodita(Troglodita aRemover){
		personagens.remove(aRemover);
	}
	
	public Troglodita criarTroglodita(){
		Troglodita novo = new Troglodita();
		novo.defineJogadorDono(this);
		personagens.add(novo);
		return novo;
	}
	
	public String obterNome(){
		return nome;
	}

	public Troglodita retorneTroglodita(int index) {
		return personagens.get(index);
	}
	
}