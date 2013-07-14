package dominioDoProblema;

public class Tabuleiro {
	protected Posicao[][] posicoes;
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected boolean partidaEmAndamento;
	protected boolean conectado;
	protected boolean indicaClick;
	protected boolean pecaSelecionada;
	protected Troglodita trogloditaSelecionado;
	protected AtorJogador atorJogador;
	
	public static void main(String[] args){
		Tabuleiro a = new Tabuleiro();
		Jogador jog = new Jogador();
		jog.defineDaVez(false);
		a.jogador1 = jog;
		a.posicoes = new Posicao[7][7];
		
		System.out.println(a.distanciaPermitida(0, 6, 1, 4));
		System.out.println(a.verificaBlocosSuficientes(0, 6, 1, 4));
	}

	public void recebeClick(int linha, int coluna) {
		throw new UnsupportedOperationException();
	}

	public ImagemDeTabuleiro informaEstado() {
		throw new UnsupportedOperationException();
	}

	protected int tratarLance(int linha, int coluna) {
		throw new UnsupportedOperationException();
	}

	protected boolean distanciaPermitida(int linhaA, int colunaA, int linhaB,
			int colunaB) {

		int sentidoHorizontal;
		// sentidoHorizontal: 0 - não mudou de coluna
		// 1 - indo para a esquerda
		// 2 - indo para a direita

		int sentidoVertical;
		// sentidoVerticalNulo: 0 - não mudou de linha
		// 1 - subindo
		// -1 - descendo

		boolean diferencaEntreColunas = Math.abs(colunaA - colunaB) <= 1;
		boolean distanciaHorizontal = (linhaA == linhaB) && diferencaEntreColunas;
		boolean distanciaVertical;

		if ((colunaA - colunaB) == 0) {
			sentidoHorizontal = 0;
		} else {
			if ((colunaA - colunaB) < 0) {
				sentidoHorizontal = 2;
			} else {
				sentidoHorizontal = 1;
			}
		}

		if (linhaA - linhaB == 0) {
			sentidoVertical = 0;
		} else {
			if (linhaA - linhaB < 0) {
				sentidoVertical = -1;
			} else {
				sentidoVertical = 1;
			}
		}
		
		if (sentidoVertical == 0 && sentidoHorizontal == 0) {
			return false;
		} else {

			if (jogador1.obterDaVez()) { 													// MENSAGEM

				distanciaVertical = (sentidoVertical == 1
						&& diferencaEntreColunas && sentidoHorizontal != 1);

				// Está subindo, a diferença entre as colunas é 0 ou 1 (NÃO PODE
				// SER MAIS QUE 1, pois assim estaria andando
				// mais casas que pode) e não está indo para a direita (devido
				// abstração feita do tabuleiro)

			} else {
				distanciaVertical = ((linhaA - linhaB) == -1
						&& diferencaEntreColunas && sentidoHorizontal != 2);

				// Está subindo, a diferença entre as colunas é 0 ou 1 (NÃO PODE
				// SER MAIS QUE 1, pois assim estaria andando
				// mais casas que pode) e não está indo para a esquerda (devido
				// abstração feita do tabuleiro)

			}

			if (distanciaHorizontal) return true;
			if (distanciaVertical) return true;

			return false;

		}
	}

	protected boolean gereciaPecaNosIntervalos(int linhaA, int colunaA,							//MUDANCÇA DE NOME DE MÉTODO
			int linhaB, int colunaB) {
		
		//Retorna true se não existiam peças ou existiam adversários e 
		// 		  false se existia própria peça no intervalo
		
		boolean linhaPar = (linhaA%2 == 0);
		boolean movimentacaoSentidoVertical = (linhaA == linhaB) ? false : true;
		boolean simboloOutroTroglodita;
		boolean simboloTrogloditaSelecionado = trogloditaSelecionado.retorneSimbolo();  				//MENSAGEM
		boolean removerTrogloditaP1 = false;
		boolean removerTrogloditaP2 = false;
		
		Posicao ocupacaoP1 = posicoes[linhaB][colunaB];
		Posicao ocupacaoP2;
		
		if(movimentacaoSentidoVertical){
			if(linhaPar){
				if(colunaA == colunaB) ocupacaoP2 = posicoes[linhaB][colunaB - 1];
				else ocupacaoP2 = posicoes[linhaB][colunaB + 1];
			} else {
				if(colunaA == colunaB) ocupacaoP2 = posicoes[linhaB][colunaB + 1];
				else ocupacaoP2 = posicoes[linhaB][colunaB - 1];
			}
			
			if(ocupacaoP1.estaOcupada()){
				simboloOutroTroglodita = ocupacaoP1.retorneTroglodita().retorneSimbolo();
				
				if(simboloOutroTroglodita != simboloTrogloditaSelecionado){									//MENSAGEM
					removerTrogloditaP1 = true;
				} else {
					return false;
				}
			}
			
			if(ocupacaoP2.estaOcupada()){
				simboloOutroTroglodita = ocupacaoP2.retorneTroglodita().retorneSimbolo();					//MENSAGEM
				
				if(simboloOutroTroglodita != simboloTrogloditaSelecionado){
					removerTrogloditaP2 = true;
				} else {
					return false;
				}
			}
			
			if(removerTrogloditaP1) this.removeTroglodita(linhaB, colunaB);									//MENSAGEM
			if(removerTrogloditaP2) this.removeTroglodita(linhaB, ocupacaoP2.pegueColuna());				//MENSAGEM
			
		} else {
			
			if(ocupacaoP1.estaOcupada()){
				simboloOutroTroglodita = ocupacaoP1.retorneTroglodita().retorneSimbolo();					//MENSAGEM
				
				if(simboloOutroTroglodita != simboloTrogloditaSelecionado){
					this.removeTroglodita(linhaB, colunaB);													//MENSAGEM
				} else {
					return false;
				}
			}
		}
		
		return true;
	}

	protected boolean verificaBlocosSuficientes(int linhaA, int colunaA,
			int linhaB, int colunaB) {
		
		boolean movimentoHorizontal = (linhaA == linhaB);
		boolean extremidade;
		boolean linhaPar = (linhaA%2 == 0);
		
		if(linhaPar){
			extremidade = (colunaA == 0 || colunaA == (posicoes[0].length - 1));
		} else {
			extremidade = (colunaA == 0 || colunaA == (posicoes[0].length - 2));
		}
		
		if(movimentoHorizontal) return true;
		if(extremidade && linhaPar){
			return false;
		} else {
			return true;
		}
	}

	protected void removeTroglodita(int linhaB, int colunaB) {									//MUDEI OS PARÂMETROS E NOMES
		//throw new UnsupportedOperationException();
		
		
		
		System.out.println("Troglodita Removido, na linha " + linhaB + " e coluna " + colunaB);
	}

	protected void mover(int linhaFinal, int colunaFinal) {
		throw new UnsupportedOperationException();
	}

	protected boolean verificaVencedor() {
		throw new UnsupportedOperationException();
	}

	protected boolean retornaSimboloDaVez() {
		throw new UnsupportedOperationException();
	}

	public boolean informarConectado() {
		return conectado;
	}

	public void estabelecerConectado(boolean valor) {
		throw new UnsupportedOperationException();
	}

	public void executarLanceRecebido(Lance lance) {
		throw new UnsupportedOperationException();
	}

	public void esvaziarTabuleiro() {
		throw new UnsupportedOperationException();
	}

	public void criarJogador(String nomeUsuario) {
		throw new UnsupportedOperationException();
	}

	public void habilitar(int posicao) {
		throw new UnsupportedOperationException();
	}

	public void posicionarTrogloditas(Jogador jogadorA, Jogador jogadorB) {
		throw new UnsupportedOperationException();
	}

	public int selecionarPeca(int linha, int coluna) {
		throw new UnsupportedOperationException();
	}

	protected Jogador jogadorDaVez() {
		if (jogador1.obterDaVez()) {
			return jogador1;
		} else {
			return jogador2;
		}
	}
}