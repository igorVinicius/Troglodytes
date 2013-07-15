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

			if (jogador1.obterDaVez()) {

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

	protected boolean gereciaPecaNosIntervalos(int linhaA, int colunaA,
			int linhaB, int colunaB) {
		
		//Retorna true se não existiam peças ou existiam adversários e 
		// 		  false se existia própria peça no intervalo
		
		boolean linhaPar;
		boolean movimentacaoSentidoVertical;
		boolean simboloOutroTroglodita;
		boolean simboloTrogloditaSelecionado;
		boolean removerTrogloditaP1 = false;
		boolean removerTrogloditaP2 = false;
		boolean ocupada;
		
		Posicao ocupacaoP1 = posicoes[linhaB][colunaB];
		Posicao ocupacaoP2;
		
		linhaPar = (linhaA % 2 == 0);
		movimentacaoSentidoVertical = (linhaA == linhaB) ? false : true;
		simboloTrogloditaSelecionado = trogloditaSelecionado.retorneSimbolo();
		ocupada = ocupacaoP1.estaOcupada();
		
		if(movimentacaoSentidoVertical){
			if(linhaPar){
				if(colunaA == colunaB) ocupacaoP2 = posicoes[linhaB][colunaB - 1];
				else ocupacaoP2 = posicoes[linhaB][colunaB + 1];
			} else {
				if(colunaA == colunaB) ocupacaoP2 = posicoes[linhaB][colunaB + 1];
				else ocupacaoP2 = posicoes[linhaB][colunaB - 1];
			}
			
			if(ocupada){
				simboloOutroTroglodita = ocupacaoP1.retorneTroglodita().retorneSimbolo();
				
				if(simboloOutroTroglodita != simboloTrogloditaSelecionado){
					removerTrogloditaP1 = true;
				} else {
					return false;
				}
			}
			
			ocupada = ocupacaoP2.estaOcupada();
			
			if(ocupada){
				simboloOutroTroglodita = ocupacaoP2.retorneTroglodita().retorneSimbolo();
				
				if(simboloOutroTroglodita != simboloTrogloditaSelecionado){
					removerTrogloditaP2 = true;
				} else {
					return false;
				}
			}
			
			if(removerTrogloditaP1) this.removeTroglodita(linhaB, colunaB);
			if(removerTrogloditaP2) this.removeTroglodita(linhaB, ocupacaoP2.pegueColuna());
			
		} else {			
			if(ocupada){
				simboloOutroTroglodita = ocupacaoP1.retorneTroglodita().retorneSimbolo();
				
				if(simboloOutroTroglodita != simboloTrogloditaSelecionado){
					this.removeTroglodita(linhaB, colunaB);
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

	protected void removeTroglodita(int linhaB, int colunaB) {
		Posicao posicao = posicoes[linhaB][colunaB];
		Troglodita aRemover = posicao.retorneTroglodita();											//MENSAGEM
		boolean quemEhDono = (aRemover.jogadorDono(jogador1)) ? true : false;						//MENSAGEM
		
		posicao.removeTroglodita();																	//MENSAGEM
		
		if(quemEhDono) jogador1.removeTroglodita(aRemover);											//MENSAGEM
		else jogador2.removeTroglodita(aRemover); 													//MENSAGEM
	}

	protected void mover(int linhaA, int colunaA, int linhaB, int colunaB) {
		boolean linhaPar;
		boolean movimentacaoSentidoVertical;
		Posicao posicaoInicial;
		Posicao posicaoFinal1;
		Posicao posicaoFinal2;
		
		linhaPar = (linhaA % 2 == 0);
		movimentacaoSentidoVertical = (linhaA == linhaB) ? false : true;
		
		posicaoInicial = posicoes[linhaA][colunaA];
		posicaoFinal1 = posicoes[linhaB][colunaB];
		
		Troglodita aMover = posicaoInicial.retorneTroglodita();										//MENSAGEM
		
		if(movimentacaoSentidoVertical){
			Troglodita novoTroglodita;
			
			if(linhaPar){
				if(colunaA == colunaB) posicaoFinal2 = posicoes[linhaB][colunaB - 1];
				else posicaoFinal2 = posicoes[linhaB][colunaB + 1];
			} else {
				if(colunaA == colunaB) posicaoFinal2 = posicoes[linhaB][colunaB + 1];
				else posicaoFinal2 = posicoes[linhaB][colunaB - 1];
			}
			
			//Multiplicar troglodita
			
			novoTroglodita = this.jogadorDaVez().criarTroglodita();
			
			posicaoFinal2.definaTroglodita(novoTroglodita);											//MENSAGEM
		}
		
		posicaoInicial.removeTroglodita();															//MENSAGEM
		posicaoFinal1.definaTroglodita(aMover);														//MENSAGEM
	}

	protected boolean verificaVencedor() {
		boolean daVez = jogador1.obterDaVez();														//MENSAGEM
		boolean ocupada;
		boolean haAdversarios;
		Troglodita troglodita;
		
		//Verifica se não há trogloditas adversários, e depois se há próprio troglodita na última linha.
		if(daVez){
			haAdversarios = jogador2.haTrogloditas();												//MENSAGEM
			
			if(!haAdversarios){
				return true;
			}
			
			boolean simboloJogador1 = jogador1.obterSimbolo();										//MENSAGEM
			
			for(Posicao posicao : posicoes[0]){
				ocupada = posicao.estaOcupada();													//MENSAGEM
				
				if(ocupada){
					troglodita = posicao.retorneTroglodita();										//MENSAGEM
					if(simboloJogador1 == troglodita.retorneSimbolo()){								//MENSAGEM
						return true;
					}
				}
			}
		} else {
			haAdversarios = jogador1.haTrogloditas();												//MENSAGEM
			
			if(!haAdversarios){
				return true;
			}
			
			boolean simboloJogador2 = jogador2.obterSimbolo();										//MENSAGEM
			
			for(Posicao posicao : posicoes[posicoes.length - 1]){									//MENSAGEM
				ocupada = posicao.estaOcupada();													//MENSAGEM
				
				if(ocupada){
					troglodita = posicao.retorneTroglodita();										//MENSAGEM
					if(simboloJogador2 == troglodita.retorneSimbolo()){								//MENSAGEM
						return true;
					}
				}
			}
		}

		return false;
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