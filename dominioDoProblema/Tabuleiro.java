package dominioDoProblema;

public class Tabuleiro {
	protected Posicao[][] posicoes;
	protected Jogador jogador1;
	protected Jogador jogador2;
	protected boolean partidaEmAndamento;
	protected boolean conectado;
	protected boolean pecaSelecionada;
	protected Troglodita trogloditaSelecionado;
	protected AtorJogador atorJogador;
	
	public static void main(String[] args){
		Tabuleiro a = new Tabuleiro();
		Jogador jog = new Jogador("Guilherme", 11);
		jog.defineDaVez(false);
		a.jogador1 = jog;
		a.posicoes = new Posicao[7][10];
		
		int linhas;
		int colunas;
		int numeroTrogloditasPorJogador;
		
		
		linhas = a.posicoes.length;
		colunas = a.posicoes[0].length;
		numeroTrogloditasPorJogador = ( ((((linhas - 1) / 2) + 1) * (colunas)) + 
				(((linhas - 1) / 2) * (colunas - 1)) ) / 4;
		
		System.out.println(numeroTrogloditasPorJogador);
		System.out.println(a.distanciaPermitida(0, 6, 1, 4));
		System.out.println(a.verificaBlocosSuficientes(0, 6, 1, 4));
	}
	
	/**
	 * MÉTODOS REFERENTES A LÓGICA DO JOGO
	 */

	public int recebeClick(int linha, int coluna) {
		boolean daVez = jogador1.obterDaVez();
		
		if(daVez){
			if(pecaSelecionada){
				return this.tratarLance(linha, coluna);
			} else {
				return this.selecionarPeca(linha, coluna);
			}
		}
		 return 8;
	}
	
	public void executarLanceRecebido(Lance lance) {
		int linhaA = lance.pegueLinhaOrigem();
		int colunaA = lance.pegueColunaOrigem();
		int linhaB = lance.pegueLinhaDestino();
		int colunaB = lance.pegueColunaDestino();
		
		this.selecionarPeca(linhaA, colunaA);														
		this.tratarLance(linhaB, colunaB);															
	}
	
	public int selecionarPeca(int linha, int coluna) {
		boolean daVez;
		boolean simboloDaVez;
		boolean exito;
		
		Posicao posicaoSelecionada;
		Troglodita possivelTrogloditaSelecionado;
		
		daVez = jogador1.obterDaVez();
		posicaoSelecionada = posicoes[linha][coluna];
		possivelTrogloditaSelecionado = posicaoSelecionada.retorneTroglodita();
		
		if(daVez) simboloDaVez = jogador1.obterSimbolo();
		else simboloDaVez = jogador2.obterSimbolo();
		
		exito = posicaoSelecionada.estaOcupada();
		
		if(exito){
			boolean simboloTroglodita = possivelTrogloditaSelecionado.retorneSimbolo();
			
			if(simboloDaVez == simboloTroglodita){
				trogloditaSelecionado = possivelTrogloditaSelecionado;
				pecaSelecionada = true;
				
				return 16;
			} else {
				return 12;
			}
		} else {
			return 11;
		}
	}

	protected int tratarLance(int linhaB, int colunaB) {
		Posicao atual = trogloditaSelecionado.peguePosicao();
		int linhaA = atual.pegueLinha();
		int colunaA = atual.pegueColuna();
		boolean distancia;
		boolean haBlocosSuficientes;
		boolean bemSucedido;
		boolean vencedor;
		
		distancia = this.distanciaPermitida(linhaA, colunaA, linhaB, colunaB);							
		
		if(distancia){
			haBlocosSuficientes = this.verificaBlocosSuficientes(linhaA, colunaA, linhaB, colunaB);
			
			if(haBlocosSuficientes){
				bemSucedido = this.gereciaPecaNosIntervalos(linhaA, colunaA, linhaB, colunaB);
				
				if(bemSucedido){
					this.mover(linhaA, colunaA, linhaB, colunaB);
					
					vencedor = this.verificaVencedor();
					if(vencedor){
						trogloditaSelecionado = null;
						pecaSelecionada = false;
						partidaEmAndamento = false;
						
						return 9;
					}
					
					Lance novoLance = new Lance(linhaA, colunaA, linhaB, colunaB);
					
					atorJogador.enviarJogada(novoLance);
					
					boolean daVez = jogador1.obterDaVez();
					
					if(daVez){
						jogador1.defineDaVez(false);
						jogador2.defineDaVez(true);
					} else {
						jogador2.defineDaVez(false);
						jogador1.defineDaVez(true);
					}
					
					return 10;
					
				} else {
					return 15;
				}
			} else {
				return 14;
			}
		} else {
			return 13;
		}		
		
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
		
		Troglodita aMover = posicaoInicial.retorneTroglodita();
		
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
			
			posicaoFinal2.definaTroglodita(novoTroglodita);
		}
		
		posicaoInicial.removeTroglodita();
		posicaoFinal1.definaTroglodita(aMover);
	}
	
	protected void removeTroglodita(int linhaB, int colunaB) {
		Posicao posicao = posicoes[linhaB][colunaB];
		Troglodita aRemover = posicao.retorneTroglodita();
		boolean quemEhDono = aRemover.jogadorDono(jogador1);
		
		posicao.removeTroglodita();
		
		if(quemEhDono) jogador1.removeTroglodita(aRemover);
		else jogador2.removeTroglodita(aRemover);
	}

	protected boolean verificaVencedor() {		
		boolean daVez = jogador1.obterDaVez();
		boolean ocupada;
		boolean haAdversarios;
		Troglodita troglodita;
		Posicao posicaoTemporaria;
		
		//Verifica se não há trogloditas adversários, e depois se há próprio troglodita na última linha.
		if(daVez){
			haAdversarios = jogador2.haTrogloditas();
			
			if(!haAdversarios){
				return true;
			}
			
			boolean simboloJogador1 = jogador1.obterSimbolo();
			
			for(int i = 0; i < posicoes.length; i++){												//MODIFICAÇÃO
				for(int j = 0; j < posicoes[0].length; j++){										//MODIFICAÇÃO
					posicaoTemporaria = posicoes[i][j];
					ocupada = posicaoTemporaria.estaOcupada();										//MENSAGEM
					
					if(ocupada){
						troglodita = posicaoTemporaria.retorneTroglodita();
						if(simboloJogador1 == troglodita.retorneSimbolo()){
							jogador1.defineDaVez(false);
							jogador1.defineVencedor();
							
							return true;
						}
					}
				}
			}
		} else {
			haAdversarios = jogador1.haTrogloditas();
			
			if(!haAdversarios){
				return true;
			}
			
			boolean simboloJogador2 = jogador2.obterSimbolo();
			
			for(int i = 0; i < posicoes.length; i++){												//MODIFICAÇÃO
				for(int j = 0; j < posicoes[0].length; j++){										//MODIFICAÇÃO
					posicaoTemporaria = posicoes[i][j];
					ocupada = posicaoTemporaria.estaOcupada();										//MENSAGEM
					
					if(ocupada){
						troglodita = posicaoTemporaria.retorneTroglodita();
						if(simboloJogador2 == troglodita.retorneSimbolo()){
							jogador2.defineDaVez(false);
							jogador2.defineVencedor();
							
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * MÉTODOS REFERENTES AO TABULEIRO
	 */

	public boolean informarConectado() {
		return conectado;
	}

	public void estabelecerConectado(boolean valor) {
		conectado = valor;
	}

	public void esvaziarTabuleiro() {
		for (int linha = 0; linha < posicoes.length; linha++){
			for (int coluna = 0; coluna < posicoes[0].length; coluna++){
				posicoes[(linha)][(linha)].removeTroglodita();												
			};
		};	
		jogador1 = null;
		jogador2 = null;
		partidaEmAndamento = false;
	}

	public void habilitar(int posicao) {
		if(posicao == 1){
			jogador1.defineDaVez(true);
			
			jogador1.assumirSimbolo(true);
			jogador2.assumirSimbolo(false);
		} else {
			jogador2.defineDaVez(true);
			
			jogador1.assumirSimbolo(false);
			jogador2.assumirSimbolo(true);
		}
		
		this.posicionarTrogloditas();
	}
	
	/**
	 * 	POSICIONAR TROGLODITAS
	 */

	public void posicionarTrogloditas() {															//MUDAR ASSINATURA
		int linhas;
		int colunas;
		boolean colunasPar;
		
		linhas = posicoes.length;
		colunas = posicoes[0].length;
		colunasPar = (colunas % 2) == 0;
		
		if(!colunasPar) {
			int cont = 0;
			
			for(int i = 0; i < (linhas - 1); i++){
				
				//Se o número da linha for MENOR que a linha do meio (posicionar trogloditas do jogador 2)
				if(i < ((((linhas - 1) / 2) + 1))){
					
					//Se a linha for par for par
					if(i % 2 == 0) {
						for(int j = 3; j < 7; j++){
							posicoes[i][j].definaTroglodita(jogador2.retorneTroglodita(cont));					//MENSAGEM
							cont++;
						}
						
					} else {
						for(int j = 2; j < 6; j++){
							posicoes[i][j].definaTroglodita(jogador2.retorneTroglodita(cont));					//MENSAGEM
							cont++;
						}
					}
				} else {
					
					//Se o número da linha for MAIOR que a linha do meio (posicionar trogloditas do jogador 1)
					if(i != ((((linhas - 1) / 2) + 1))) {
						if(i % 2 == 0) {
							for(int j = 3; j < 7; j++){
								posicoes[i][j].definaTroglodita(jogador1.retorneTroglodita(cont));				//MENSAGEM
								cont++;
							}
						} else {
							for(int j = 2; j < 6; j++){
								posicoes[i][j].definaTroglodita(jogador1.retorneTroglodita(cont));				//MENSAGEM
								cont++;
							}
						}
					} else {
						
						//Se for a linha do meio, zerar o contador
						cont = 0;
					}
				}
			}
		} else {
			throw new UnsupportedOperationException();
		}
	}
	
	/**
	 * IMAGEM DE TABULEIRO
	 */
	
	public ImagemDeTabuleiro informaEstado() {
		boolean simboloTroglodita;
		int[][] posicoesTraduzidas;
		Posicao posicaoAuxiliar;
		Troglodita trogloditaAuxiliar;
		ImagemDeTabuleiro imagem;
		
		posicoesTraduzidas = new int[posicoes.length][posicoes[0].length];
		
		for(int i = 0; i < posicoes.length; i++){
			for(int j = 0; j < posicoes[0].length; j++){
				posicaoAuxiliar = posicoes[i][j];
				
				if(posicaoAuxiliar.estaOcupada()){
					trogloditaAuxiliar = posicaoAuxiliar.retorneTroglodita();
					simboloTroglodita = trogloditaAuxiliar.retorneSimbolo();
					
					if(simboloTroglodita) posicoesTraduzidas[i][j] = 1;
					else posicoesTraduzidas[i][j] = 2;
					
				} else {
					posicoesTraduzidas[i][j] = 0;
				}
			}
		}
		
		imagem = new ImagemDeTabuleiro(posicoesTraduzidas);
		
		return imagem;
	}
	
	
	/**
	 * JOGADOR
	 */
	
	protected Jogador jogadorDaVez() {
		if (jogador1.obterDaVez()) {
			return jogador1;
		} else {
			return jogador2;
		}
	}
	
	public void criarJogador(String nomeUsuario){
		//Fórmula matemática que define o número de trogloditas de acordo com o número de posições do tabuleiro
		int numeroTrogloditas;
		int numeroPosicoes;
		
		numeroPosicoes = ( ((((posicoes.length - 1) / 2) + 1) * (posicoes[0].length)) + 
							(((posicoes.length - 1) / 2) * (posicoes[0].length - 1)) );
		
		numeroTrogloditas = numeroPosicoes / 4;
		
		if (jogador1 == null){
			jogador1 = new Jogador(nomeUsuario, numeroTrogloditas);
		}else{
			jogador2 = new Jogador(nomeUsuario, numeroTrogloditas);
		}
	}
}