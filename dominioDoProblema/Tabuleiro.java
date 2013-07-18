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
	
	/*
	public static void main(String[] args){
		Tabuleiro a = new Tabuleiro();
		Jogador jog = new Jogador("Guilherme", 11);
		jog.defineDaVez(true);
		a.jogador1 = jog;
		a.posicoes = new Posicao[7][10];
		
		System.out.println(a.distanciaPermitida(3, 3, 2, 5));
		System.out.println(a.verificaBlocosSuficientes(0, 6, 1, 4));
	}
	*/
		
	/**
	 * MÉTODOS REFERENTES A LÓGICA DO JOGO
	 */
	
	public Tabuleiro(AtorJogador ator){
		int quantidadeLinhas = 7;
		int quatidadeColunas = 7;
		
		posicoes = new Posicao[7][7];
		
		for (int linha = 0; linha < quantidadeLinhas; linha++){
			for (int coluna = 0; coluna < quatidadeColunas; coluna++){
				posicoes[(linha)][(coluna)] = new Posicao(linha, coluna);
			}
		}
		
		this.atorJogador = ator;
	}

	public int recebeClick(int linha, int coluna) {		
		if(partidaEmAndamento){
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
		return 18;
	}
	
	public int executarLanceRecebido(Lance lance) {
		int linhaA = lance.pegueLinhaOrigem();
		int colunaA = lance.pegueColunaOrigem();
		int linhaB = lance.pegueLinhaDestino();
		int colunaB = lance.pegueColunaDestino();
		
		this.selecionarPeca(linhaA, colunaA);														
		return this.tratarLance(linhaB, colunaB);															
	}
	
	protected int selecionarPeca(int linha, int coluna) {
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
						
						Lance novoLance = new Lance(linhaA, colunaA, linhaB, colunaB);
						
						atorJogador.enviarJogada(novoLance);
						
						return 9;
					}
					
					boolean daVez = jogador1.obterDaVez();
					
					if(daVez){
						jogador1.defineDaVez(false);
						jogador2.defineDaVez(true);
					} else {
						jogador2.defineDaVez(false);
						jogador1.defineDaVez(true);
					}
					
					trogloditaSelecionado = null;
					pecaSelecionada = false;
					
					Lance novoLance = new Lance(linhaA, colunaA, linhaB, colunaB);
					
					atorJogador.enviarJogada(novoLance);
					
					return 10;
					
				} else {
					trogloditaSelecionado = null;
					pecaSelecionada = false;
					
					return 15;
				}
			} else {
				trogloditaSelecionado = null;
				pecaSelecionada = false;
				
				return 14;
			}
		} else {
			trogloditaSelecionado = null;
			pecaSelecionada = false;
			
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
				
				if(linhaA % 2 == 0) {
					distanciaVertical = (sentidoVertical == 1
						&& diferencaEntreColunas && sentidoHorizontal != 2 && (linhaA - linhaB) == 1);					
				} else {
					distanciaVertical = (sentidoVertical == 1
							&& diferencaEntreColunas && sentidoHorizontal != 1 && (linhaA - linhaB) == 1);
				}				

				// Está subindo, a diferença entre as colunas é 0 ou 1 (NÃO PODE
				// SER MAIS QUE 1, pois assim estaria andando
				// mais casas que pode) e não está indo para a direita (devido
				// abstração feita do tabuleiro)

			} else {
				
				if(linhaA % 2 == 0) {
					distanciaVertical = ((linhaA - linhaB) == -1
						&& diferencaEntreColunas && sentidoHorizontal != 2);
				} else {
					distanciaVertical = ((linhaA - linhaB) == -1
							&& diferencaEntreColunas && sentidoHorizontal != 1);
				}
				

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

			for(int j = 0; j < posicoes[0].length; j++){
				posicaoTemporaria = posicoes[0][j];
				ocupada = posicaoTemporaria.estaOcupada();
				
				if(ocupada){
					troglodita = posicaoTemporaria.retorneTroglodita();
					if(simboloJogador1 == troglodita.retorneSimbolo()){
						jogador1.defineDaVez(false);
						jogador1.defineVencedor();
						
						return true;
					}
				}
			}
		} else {
			haAdversarios = jogador1.haTrogloditas();
			
			if(!haAdversarios){
				return true;
			}
			
			boolean simboloJogador2 = jogador2.obterSimbolo();

			for(int j = 0; j < posicoes[0].length; j++){
				posicaoTemporaria = posicoes[6][j];
				ocupada = posicaoTemporaria.estaOcupada();
				
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
		
		return false;
	}
	
	protected void posicionarTrogloditas() {
		
			//Jogador 2:
			
			posicoes[0][2].definaTroglodita(jogador2.retorneTroglodita(0));
			posicoes[0][3].definaTroglodita(jogador2.retorneTroglodita(1));
			posicoes[0][4].definaTroglodita(jogador2.retorneTroglodita(2));
			posicoes[1][0].definaTroglodita(jogador2.retorneTroglodita(3));
			posicoes[1][1].definaTroglodita(jogador2.retorneTroglodita(4));
			posicoes[1][2].definaTroglodita(jogador2.retorneTroglodita(5));
			posicoes[1][3].definaTroglodita(jogador2.retorneTroglodita(6));
			posicoes[1][4].definaTroglodita(jogador2.retorneTroglodita(7));
			posicoes[1][5].definaTroglodita(jogador2.retorneTroglodita(8));
			posicoes[2][2].definaTroglodita(jogador2.retorneTroglodita(9));
			posicoes[2][3].definaTroglodita(jogador2.retorneTroglodita(10));
			posicoes[2][4].definaTroglodita(jogador2.retorneTroglodita(11));
			
			//Jogador 1:
			
			posicoes[4][2].definaTroglodita(jogador1.retorneTroglodita(0));
			posicoes[4][3].definaTroglodita(jogador1.retorneTroglodita(1));
			posicoes[4][4].definaTroglodita(jogador1.retorneTroglodita(2));
			posicoes[5][0].definaTroglodita(jogador1.retorneTroglodita(3));
			posicoes[5][1].definaTroglodita(jogador1.retorneTroglodita(4));
			posicoes[5][2].definaTroglodita(jogador1.retorneTroglodita(5));
			posicoes[5][3].definaTroglodita(jogador1.retorneTroglodita(6));
			posicoes[5][4].definaTroglodita(jogador1.retorneTroglodita(7));
			posicoes[5][5].definaTroglodita(jogador1.retorneTroglodita(8));
			posicoes[6][2].definaTroglodita(jogador1.retorneTroglodita(9));
			posicoes[6][3].definaTroglodita(jogador1.retorneTroglodita(10));
			posicoes[6][4].definaTroglodita(jogador1.retorneTroglodita(11));
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
		Posicao temporaria;
		
		for (int linha = 0; linha < posicoes.length; linha++){
			for (int coluna = 0; coluna < posicoes[0].length; coluna++){
				 temporaria = posicoes[(linha)][(coluna)];
				 if(temporaria.estaOcupada()){
					 temporaria.removeTroglodita();
				 }
			};
		};	
		jogador1 = null;
		jogador2 = null;
		partidaEmAndamento = false;
	}

	public void habilitar(int posicao) {
		if(posicao == 1){
			jogador1.defineDaVez(true);
			jogador2.defineDaVez(false);
			
			jogador1.assumirSimbolo(true);
			jogador2.assumirSimbolo(false);
		} else {
			jogador2.defineDaVez(true);
			jogador1.defineDaVez(false);
			
			jogador1.assumirSimbolo(false);
			jogador2.assumirSimbolo(true);
		}
		
		partidaEmAndamento = true;
		this.posicionarTrogloditas();
		
		
	}
	
	public void definirPartidaEmAndamento(boolean estado){
		this.partidaEmAndamento = estado;
	}
	
	public boolean informarPartidaEmAndamento(){
		return partidaEmAndamento;
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
					
					if(simboloTroglodita) {
						posicoesTraduzidas[i][j] = 1;
					}
					else {
						posicoesTraduzidas[i][j] = 2;
					}
				} else {
					posicoesTraduzidas[i][j] = 0;
				}
			}
		}
		
		if(pecaSelecionada){
			Posicao auxiliar = trogloditaSelecionado.peguePosicao();
			int linha = auxiliar.pegueLinha();
			int coluna = auxiliar.pegueColuna();
			
			if(jogador1.obterSimbolo()){
				posicoesTraduzidas[linha][coluna] = 3;
			} else {
				posicoesTraduzidas[linha][coluna] = 4;
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
		int numeroTrogloditas = 12;
		
		if (jogador1 == null){
			jogador1 = new Jogador(nomeUsuario, numeroTrogloditas);
		}else{
			jogador2 = new Jogador(nomeUsuario, numeroTrogloditas);
		}
	}
	
	public boolean jogador1EhVencedor() {
		return jogador1.ehVencedor();
	}
	
	public String informaNomeJogador(int posicao){
		if(posicao == 1){
			return jogador1.obterNome();
		} else {
			return jogador1.obterNome();
		}
	}

	public boolean informarSimboloDaVez() {
		if(jogador1.obterDaVez()){
			return jogador1.obterSimbolo();
		} else {
			return jogador2.obterSimbolo();
		}
	}
}