package interfaceGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import dominioDoProblema.ImagemDeTabuleiro;
import dominioDoProblema.AtorJogador;


public class InterfaceTroglodytes extends JFrame {
	
	Icon azul = new ImageIcon(InterfaceTroglodytes.class.getResource("/imagens/trogo1.png"));
	Icon marrom = new ImageIcon(InterfaceTroglodytes.class.getResource("/imagens/trogo2.png"));
	Icon vazia = new ImageIcon(InterfaceTroglodytes.class.getResource("/imagens/vazio.png"));
	Icon azulPreenchida = new ImageIcon(InterfaceTroglodytes.class.getResource("/imagens/trog1Selecionado.png"));
	Icon marromPreenchida = new ImageIcon(InterfaceTroglodytes.class.getResource("/imagens/trog2Selecionado.png"));
	
	private static final long serialVersionUID = 1L;
	
	private final String online = "Online";
	private final String offline = "Offline";

    protected AtorJogador atorJogador; 
	private JPanel contentPane = null;
	

	private JLabel posicao00 = null;
	private JLabel posicao01 = null;
	private JLabel posicao02 = null;
	private JLabel posicao03 = null;
	private JLabel posicao04 = null;
	private JLabel posicao05 = null;
	private JLabel posicao06 = null;

	private JLabel posicao10 = null;
	private JLabel posicao11 = null;
	private JLabel posicao12 = null;
	private JLabel posicao13 = null;
	private JLabel posicao14 = null;
	private JLabel posicao15 = null;
	private JLabel posicao16 = null;

	private JLabel posicao20 = null;
	private JLabel posicao21 = null;
	private JLabel posicao22 = null;
	private JLabel posicao23 = null;
	private JLabel posicao24 = null;
	private JLabel posicao25 = null;
	private JLabel posicao26 = null;

	private JLabel posicao30 = null;
	private JLabel posicao31 = null;
	private JLabel posicao32 = null;
	private JLabel posicao33 = null;
	private JLabel posicao34 = null;
	private JLabel posicao35 = null;
	private JLabel posicao36 = null;

	private JLabel posicao40 = null;
	private JLabel posicao41 = null;
	private JLabel posicao42 = null;
	private JLabel posicao43 = null;
	private JLabel posicao44 = null;
	private JLabel posicao45 = null;
	private JLabel posicao46 = null;

	private JLabel posicao50 = null;
	private JLabel posicao51 = null;
	private JLabel posicao52 = null;
	private JLabel posicao53 = null;
	private JLabel posicao54 = null;
	private JLabel posicao55 = null;
	private JLabel posicao56 = null;

	private JLabel posicao60 = null;
	private JLabel posicao61 = null;
	private JLabel posicao62 = null;
	private JLabel posicao63 = null;
	private JLabel posicao64 = null;
	private JLabel posicao65 = null;
	private JLabel posicao66 = null;
	
	private JLabel daVez = null;

	private JLabel statusRede = null;
	
	private JLabel nomeJogadorAdversario = null;
	
	protected JLabel mapaPosicao[][] = new JLabel[7][7];
	
	private JMenuBar jMenuBar = null;
	
	private JMenu menuatorJogador = null;

	private JMenuItem jMenuItem1 = null;

	private JMenuItem jMenuItem2 = null;

	private JMenuItem jMenuItem3 = null;
	
	private JMenu menuSobre = null;

	

	public InterfaceTroglodytes() {		
		super();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setFont(new Font("Dialog", Font.BOLD, 13));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(InterfaceTroglodytes.class.getResource("/imagens/trogo1.png")));
		this.setTitle("Troglodytes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 618, 568);
		
		//initialize();
		
		this.setContentPane(getStartContentPanel());	
		setLocation((tela.width-this.getSize().width)/2,   
                (tela.height-this.getSize().height)/2);
		
	}
	
	private void cliqueInicial(){
		contentPane = null;
		initialize();
	}
	
	private JPanel getStartContentPanel(){
		Icon startGame = new ImageIcon((InterfaceTroglodytes.class.getResource("/imagens/startGame.png")));
		
		contentPane = new JPanel();
		contentPane.setLayout(null);	
		
		JLabel imagemDeFundo = new JLabel();
		imagemDeFundo.setIcon(startGame);
		imagemDeFundo.setBounds(0, 16, 606, 498);
		imagemDeFundo.setVisible(true);
		contentPane.add(imagemDeFundo);
		
		JLabel start = new JLabel();
		start.setBounds(221, 300, 205, 102);
		start.setVisible(true);
		contentPane.add(start);
		start.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				cliqueInicial(); 
			}
		});
		
		return contentPane;
	}
	
	private void initialize(){
		this.setContentPane(getContentPanel());	
	    jMenuBar = new JMenuBar();
		jMenuBar.add(getMenu());
		jMenuBar.add(getMenuSobre());
		this.setJMenuBar(jMenuBar);	
		atorJogador = new AtorJogador(this);
		this.setVisible(true);
		JOptionPane.showMessageDialog(this, "Bem vindo ao jogo Troglodytes em rede! \n\nPara jogar, conecte-se clicando no " +
				"menu \"Conectar\". \nA partir daí você tem duas opções: \n\n-Esperar alguém iniciar partida; \n\n-Iniciar uma" +
				" partida clicando em \"Iniciar nova partida\" e aguardar alguém se conectar! \n\n Divirta-se!");
	}

	private JPanel getContentPanel(){
			
		if (contentPane == null) {		
			contentPane = new JPanel();
			contentPane.setLayout(null);
	
			
			Icon vazia = new ImageIcon((InterfaceTroglodytes.class.getResource("/imagens/vazio.png")));
			Icon floresta = new ImageIcon((InterfaceTroglodytes.class.getResource("/imagens/floresta.png")));
			
			/**
			
			nomeJogadorAdversario = new JLabel(offline);
			nomeJogadorAdversario.setBounds(280, 30, 50, 20); 
			nomeJogadorAdversario.setForeground(Color.lightGray);
			nomeJogadorAdversario.setFont(new Font("Calibri", Font.ITALIC, 16));
			contentPane.add(nomeJogadorAdversario);
			
			*/
			
			daVez = new JLabel("");
			daVez.setIcon(vazia);
			daVez.setBounds(535, 13, 50, 44);
			contentPane.add(daVez);
			
			statusRede = new JLabel(offline);
			statusRede.setBounds(280, 30, 50, 20); 
			statusRede.setForeground(Color.lightGray);
			statusRede.setFont(new Font("Calibri", Font.ITALIC, 16));
			contentPane.add(statusRede);

						
			posicao00 = new JLabel("");
			posicao00.setIcon(vazia);
			posicao00.setBounds(106, 70, 46, 44);
			posicao00.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(0,0); 
				}
			});
			contentPane.add(posicao00, null);
	
			posicao01 = new JLabel("");
			posicao01.setIcon(vazia);
			posicao01.setBounds(162, 70, 46, 44);
			posicao01.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(0,1); 
				}
			});
			contentPane.add(posicao01);
	
			posicao02 = new JLabel("");
			posicao02.setIcon(vazia);
			posicao02.setBounds(218, 70, 46, 44);
			posicao02.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(0,2); 
				}
			});
			contentPane.add(posicao02);
	
			posicao03 = new JLabel("");
			posicao03.setIcon(vazia);
			posicao03.setBounds(274, 70, 46, 44);
			posicao03.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(0,3); 
				}
			});
			contentPane.add(posicao03);
	
			posicao04 = new JLabel("");
			posicao04.setIcon(vazia);
			posicao04.setBounds(330, 70, 46, 44);
			posicao04.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(0,4); 
				}
			});
			contentPane.add(posicao04);
	
			posicao05 = new JLabel("");
			posicao05.setIcon(vazia);
			posicao05.setBounds(386, 70, 46, 44);
			posicao05.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(0,5); 
				}
			});
			contentPane.add(posicao05);
	
			posicao06 = new JLabel("");
			posicao06.setIcon(vazia);
			posicao06.setBounds(442, 70, 46, 44);
			posicao06.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(0,6); 
				}
			});
			contentPane.add(posicao06);
	
			posicao10 = new JLabel("");
			posicao10.setIcon(vazia);
			posicao10.setBounds(137, 122, 46, 44);
			posicao10.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,0); 
				}
			});
			contentPane.add(posicao10);
	
			posicao11 = new JLabel("");
			posicao11.setIcon(vazia);
			posicao11.setBounds(191, 122, 46, 44);
			posicao11.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,1); 
				}
			});
			contentPane.add(posicao11);
	
			posicao12 = new JLabel("");
			posicao12.setIcon(vazia);
			posicao12.setBounds(247, 122, 46, 44);
			posicao12.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,2); 
				}
			});
			contentPane.add(posicao12);
	
			posicao13 = new JLabel("");
			posicao13.setIcon(vazia);
			posicao13.setBounds(303, 122, 46, 44);
			posicao13.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,3); 
				}
			});
			contentPane.add(posicao13);
	
			posicao14 = new JLabel("");
			posicao14.setIcon(vazia);
			posicao14.setBounds(358, 122, 46, 44);
			posicao14.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,4); 
				}
			});
			contentPane.add(posicao14);
	
			posicao15 = new JLabel("");
			posicao15.setIcon(vazia);
			posicao15.setBounds(414, 122, 46, 44);
			posicao15.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(1,5); 
				}
			});
			contentPane.add(posicao15);
	
			posicao20 = new JLabel("");
			posicao20.setIcon(vazia);
			posicao20.setBounds(106, 177, 46, 44);
			posicao20.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,0); 
				}
			});
			contentPane.add(posicao20);
	
			posicao21 = new JLabel("");
			posicao21.setIcon(vazia);
			posicao21.setBounds(162, 177, 46, 44);
			posicao21.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,1); 
				}
			});
			contentPane.add(posicao21);
	
			posicao22 = new JLabel("");
			posicao22.setIcon(vazia);
			posicao22.setBounds(218, 177, 46, 44);
			posicao22.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,2); 
				}
			});
			contentPane.add(posicao22);
	
			posicao23 = new JLabel("");
			posicao23.setIcon(vazia);
			posicao23.setBounds(274, 177, 46, 44);
			posicao23.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,3); 
				}
			});
			contentPane.add(posicao23);
	
			posicao24 = new JLabel("");
			posicao24.setIcon(vazia);
			posicao24.setBounds(330, 177, 46, 44);
			posicao24.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,4); 
				}
			});
			contentPane.add(posicao24);
	
			posicao25 = new JLabel("");
			posicao25.setIcon(vazia);
			posicao25.setBounds(386, 177, 46, 44);
			posicao25.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,5); 
				}
			});
			contentPane.add(posicao25);
	
			posicao26 = new JLabel("");
			posicao26.setIcon(vazia);
			posicao26.setBounds(442, 177, 46, 44);
			posicao26.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(2,6); 
				}
			});
			contentPane.add(posicao26);
	
			posicao30 = new JLabel("");
			posicao30.setIcon(vazia);
			posicao30.setBounds(137, 232, 46, 44);
			posicao30.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,0); 
				}
			});
			contentPane.add(posicao30);
	
			posicao31 = new JLabel("");
			posicao31.setIcon(vazia);
			posicao31.setBounds(194, 232, 46, 44);
			posicao31.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,1); 
				}
			});
			contentPane.add(posicao31);
	
			posicao32 = new JLabel("");
			posicao32.setIcon(vazia);
			posicao32.setBounds(250, 232, 46, 44);
			posicao32.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,2); 
				}
			});
			contentPane.add(posicao32);
	
			posicao33 = new JLabel("");
			posicao33.setIcon(vazia);
			posicao33.setBounds(306, 232, 46, 44);
			posicao33.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,3); 
				}
			});
			contentPane.add(posicao33);
	
			posicao34 = new JLabel("");
			posicao34.setIcon(vazia);
			posicao34.setBounds(361, 232, 46, 44);
			posicao34.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,4); 
				}
			});
			contentPane.add(posicao34);
	
			posicao35 = new JLabel("");
			posicao35.setIcon(vazia);
			posicao35.setBounds(417, 232, 46, 44);
			posicao35.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(3,5); 
				}
			});
			contentPane.add(posicao35);
	
			posicao40 = new JLabel("");
			posicao40.setIcon(vazia);
			posicao40.setBounds(106, 284, 46, 44);
			posicao40.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,0); 
				}
			});
			contentPane.add(posicao40);
	
			posicao41 = new JLabel("");
			posicao41.setIcon(vazia);
			posicao41.setBounds(162, 284, 46, 44);
			posicao41.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,1); 
				}
			});
			contentPane.add(posicao41);
	
			posicao42 = new JLabel("");
			posicao42.setIcon(vazia);
			posicao42.setBounds(218, 284, 46, 44);
			posicao42.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,2); 
				}
			});
			contentPane.add(posicao42);
	
			posicao43 = new JLabel("");
			posicao43.setIcon(vazia);
			posicao43.setBounds(274, 284, 46, 44);
			posicao43.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,3); 
				}
			});
			contentPane.add(posicao43);
	
			posicao44 = new JLabel("");
			posicao44.setIcon(vazia);
			posicao44.setBounds(330, 284, 46, 44);
			posicao44.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,4); 
				}
			});
			contentPane.add(posicao44);
	
			posicao45 = new JLabel("");
			posicao45.setIcon(vazia);
			posicao45.setBounds(386, 284, 46, 44);
			posicao45.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,5); 
				}
			});
			contentPane.add(posicao45);
	
			posicao46 = new JLabel("");
			posicao46.setIcon(vazia);
			posicao46.setBounds(442, 284, 46, 44);
			posicao46.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(4,6); 
				}
			});
			contentPane.add(posicao46);
	
			posicao50 = new JLabel("");
			posicao50.setIcon(vazia);
			posicao50.setBounds(137, 339, 46, 44);
			posicao50.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,0); 
				}
			});
			contentPane.add(posicao50);
	
			posicao51 = new JLabel("");
			posicao51.setIcon(vazia);
			posicao51.setBounds(194, 339, 46, 44);
			posicao51.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,1); 
				}
			});
			contentPane.add(posicao51);
	
			posicao52 = new JLabel("");
			posicao52.setIcon(vazia);
			posicao52.setBounds(250, 339, 46, 44);
			posicao52.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,2); 
				}
			});
			contentPane.add(posicao52);
	
			posicao53 = new JLabel("");
			posicao53.setIcon(vazia);
			posicao53.setBounds(306, 339, 46, 44);
			posicao53.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,3); 
				}
			});
			contentPane.add(posicao53);
	
			posicao54 = new JLabel("");
			posicao54.setIcon(vazia);
			posicao54.setBounds(361, 339, 46, 44);
			posicao54.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,4); 
				}
			});
			contentPane.add(posicao54);
	
			posicao55 = new JLabel("");
			posicao55.setIcon(vazia);
			posicao55.setBounds(417, 339, 46, 44);
			posicao55.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(5,5); 
				}
			});
			contentPane.add(posicao55);
	
			posicao60 = new JLabel("");
			posicao60.setIcon(vazia);
			posicao60.setBounds(106, 394, 46, 44);
			posicao60.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,0); 
				}
			});
			contentPane.add(posicao60);
	
			posicao61 = new JLabel("");
			posicao61.setIcon(vazia);
			posicao61.setBounds(162, 394, 46, 44);
			posicao61.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,1); 
				}
			});
			contentPane.add(posicao61);
	
			posicao62 = new JLabel("");
			posicao62.setIcon(vazia);
			posicao62.setBounds(218, 394, 46, 44);
			posicao62.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,2); 
				}
			});
			contentPane.add(posicao62);
	
			posicao63 = new JLabel("");
			posicao63.setIcon(vazia);
			posicao63.setBounds(274, 394, 46, 44);
			posicao63.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,3); 
				}
			});
			contentPane.add(posicao63);
	
			posicao64 = new JLabel("");
			posicao64.setIcon(vazia);
			posicao64.setBounds(330, 394, 46, 44);
			posicao64.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,4); 
				}
			});
			contentPane.add(posicao64);
	
			posicao65 = new JLabel("");
			posicao65.setIcon(vazia);
			posicao65.setBounds(386, 394, 46, 44);
			posicao65.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,5); 
				}
			});
			contentPane.add(posicao65);
	
			posicao66 = new JLabel("");
			posicao66.setIcon(vazia);
			posicao66.setBounds(442, 394, 46, 44);
			posicao66.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					click(6,6); 
				}
			});
			contentPane.add(posicao66);
			
			JLabel imagemDeFundo = new JLabel();
			imagemDeFundo.setIcon(floresta);
			imagemDeFundo.setBounds(0, 0, 606, 498);
			contentPane.add(imagemDeFundo);
	
			
			mapaPosicao[0][0] = posicao00;
			mapaPosicao[0][1] = posicao01;
			mapaPosicao[0][2] = posicao02;
			mapaPosicao[0][3] = posicao03;
			mapaPosicao[0][4] = posicao04;
			mapaPosicao[0][5] = posicao05;
			mapaPosicao[0][6] = posicao06;
								
			mapaPosicao[1][0] = posicao10;
			mapaPosicao[1][1] = posicao11;
			mapaPosicao[1][2] = posicao12;
			mapaPosicao[1][3] = posicao13;
			mapaPosicao[1][4] = posicao14;
			mapaPosicao[1][5] = posicao15;
			mapaPosicao[1][6] = posicao16;
	
			mapaPosicao[2][0] = posicao20;
			mapaPosicao[2][1] = posicao21;
			mapaPosicao[2][2] = posicao22;
			mapaPosicao[2][3] = posicao23;
			mapaPosicao[2][4] = posicao24;
			mapaPosicao[2][5] = posicao25;
			mapaPosicao[2][6] = posicao26;
	
			mapaPosicao[3][0] = posicao30;
			mapaPosicao[3][1] = posicao31;
			mapaPosicao[3][2] = posicao32;
			mapaPosicao[3][3] = posicao33;
			mapaPosicao[3][4] = posicao34;
			mapaPosicao[3][5] = posicao35;
			mapaPosicao[3][6] = posicao36;
	
			mapaPosicao[4][0] = posicao40;
			mapaPosicao[4][1] = posicao41;
			mapaPosicao[4][2] = posicao42;
			mapaPosicao[4][3] = posicao43;
			mapaPosicao[4][4] = posicao44;
			mapaPosicao[4][5] = posicao45;
			mapaPosicao[4][6] = posicao46;
	
			mapaPosicao[5][0] = posicao50;
			mapaPosicao[5][1] = posicao51;
			mapaPosicao[5][2] = posicao52;
			mapaPosicao[5][3] = posicao53;
			mapaPosicao[5][4] = posicao54;
			mapaPosicao[5][5] = posicao55;
			mapaPosicao[5][6] = posicao56;
	
			mapaPosicao[6][0] = posicao60;
			mapaPosicao[6][1] = posicao61;
			mapaPosicao[6][2] = posicao62;
			mapaPosicao[6][3] = posicao63;
			mapaPosicao[6][4] = posicao64;
			mapaPosicao[6][5] = posicao65;
			mapaPosicao[6][6] = posicao66;
			
		}
		return contentPane;
			
	}
	
		
		private JMenu getMenu() {
			if (menuatorJogador == null) {
				menuatorJogador = new JMenu();
				menuatorJogador.setText("Jogar Online");
				menuatorJogador.setIcon(new ImageIcon((InterfaceTroglodytes.class.getResource("/imagens/logoJogarOnline.png"))));
				menuatorJogador.setBounds(0, 0, 606, 29);
				menuatorJogador.add(getJMenuItem1());
				menuatorJogador.add(getJMenuItem2());
				menuatorJogador.add(getJMenuItem3());

			}
			return menuatorJogador;
		}
	
		private JMenuItem getJMenuItem1() {
			if (jMenuItem1 == null) {
				jMenuItem1 = new JMenuItem();
				jMenuItem1.setText("Conectar");
				jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						conectar();
					}
				});
			}
			return jMenuItem1;
		}
		
		private JMenuItem getJMenuItem2() {
			if (jMenuItem2 == null) {
				jMenuItem2 = new JMenuItem();
				jMenuItem2.setText("Iniciar nova partida");
				jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						iniciarPartida();
					}
				});
			}
			return jMenuItem2;
		}

		private JMenuItem getJMenuItem3() {
			if (jMenuItem3 == null) {
				jMenuItem3 = new JMenuItem();
				jMenuItem3.setText("Desconectar");
				jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						desconectar();
					}
				});
			}
			return jMenuItem3;
		}
		
		private JMenu getMenuSobre() {
			if (menuSobre == null) {
				menuSobre = new JMenu();
				menuSobre.setText("Sobre");
				menuSobre.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						  	Sobre frame = new Sobre();  
					        frame.setVisible(true);  
					        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					}
				});
				menuSobre.setIcon(new ImageIcon(InterfaceTroglodytes.class.getResource("/imagens/logoSobre.png")));
			}
			return menuSobre;
		}

		public void conectar() {
			int resultado = atorJogador.conectar(); 
			
			if(resultado == 0 || resultado == 1){				
				statusRede.setText(online);
			}
			
			this.notificarResultado(resultado);
		}


		public void desconectar() {
			int resultado = atorJogador.desconectar();
			
			if(resultado != 0 || resultado != 1){	
				statusRede.setText(offline);
			}
			
			this.notificarResultado(resultado);
		}

		public void iniciarPartida() {
			int resultado = atorJogador.iniciarPartida();
			this.notificarResultado(resultado);
		}
		
		
		public String obterIdJogador() {
			String idJogador = ("jogador");
			idJogador = JOptionPane.showInputDialog(this, ("Insira o nome do jogador"));
			return idJogador;
		}
		
		public String obterIdServidor() {
			String idServidor = ("venus.inf.ufsc.br");
			idServidor = JOptionPane.showInputDialog(this, ("Insira o endereço do servidor"), idServidor);
			return idServidor;
		}

		public void click(int linha, int coluna) {
		
			int resultado = 0;
			resultado = atorJogador.click(linha, coluna);
			if ((resultado == 10) || resultado == 16){
				this.exibirEstado();
			}else{
				this.notificarResultado(resultado);
			}
			
		}
		
		public void exibirEstado() {
			ImagemDeTabuleiro estado; 
			estado = atorJogador.informaEstado();
			this.atualizarWidgets(estado);		
			}	
		
		public void atualizarWidgets(ImagemDeTabuleiro estado) {
			int valor = 0;
			int colunaLimite;
			boolean simboloDaVez;
			
			simboloDaVez = atorJogador.informarSimboloDaVez();
			
			if(simboloDaVez){
				daVez.setIcon(azulPreenchida);
			} else {
				daVez.setIcon(marromPreenchida);
			}
			
			for (int linha = 0; linha < 7; linha++){
				if(linha % 2 == 0){
					colunaLimite = 7;
				} else {
					colunaLimite = 6;
				}
				for (int coluna = 0; coluna < colunaLimite; coluna++){
					valor = estado.informarValor(linha, coluna);
					switch (valor){
						case 0: mapaPosicao[linha][coluna].setIcon(vazia);
						break;
						case 1: mapaPosicao[linha][coluna].setIcon(azul);
						break;
						case 2: mapaPosicao[linha][coluna].setIcon(marrom);
						break;
						case 3: mapaPosicao[linha][coluna].setIcon(azulPreenchida);
						break;
						case 4: mapaPosicao[linha][coluna].setIcon(marromPreenchida);
						break;
					}
				}
			}
		}		
	
		
		public void notificarResultado(int codigo) {
			switch (codigo) {
	    		case 0:  JOptionPane.showMessageDialog(this, "Conexão efetuada com exito"); break;        	
	    		case 1:  JOptionPane.showMessageDialog(this, "Tentativa de conexão com conexão previamente estabelecida"); break;
	        	case 2:  JOptionPane.showMessageDialog(this, "Tentativa de conexao falhou"); break;
	        	case 3:  JOptionPane.showMessageDialog(this, "Desconexão efetuada com exito"); break;
	        	case 4:  JOptionPane.showMessageDialog(this, "Tentativa de desconexao sem conexao previamente estabelecida"); break;
	        	case 5:  JOptionPane.showMessageDialog(this, "Tentativa de desconexao falhou"); break;
	        	case 6:  JOptionPane.showMessageDialog(this, "O jogo iniciou, e você começa jogando!"); break;
	        	case 7:  JOptionPane.showMessageDialog(this, "Tentativa de inicio sem conexao previamente estabelecida"); break;
	        	case 8:  JOptionPane.showMessageDialog(this, "Não é a sua vez"); break;
	        	case 9:  {
	        		
	        		boolean jogador1EhVencedor = atorJogador.jogador1EhVencedor();
	        		
	        		if(jogador1EhVencedor){
	        			JOptionPane.showMessageDialog(this, "Parabéns, você ganhou!"); 
	        		} else {
	        			JOptionPane.showMessageDialog(this, "Você perdeu! :/");	        			
	        		}
	        		JOptionPane.showMessageDialog(this, "Para jogar novamente, clique em \"Iniciar nova partida\" no menu ou " +
														"aguarde uma nova solicitação."); 
	        		break;
	        	}
	        	case 10: {
	        		//JOptionPane.showMessageDialog(this, "É a sua vez!");
	        		break;
	        	}
	        	case 11: {
	        		//JOptionPane.showMessageDialog(this, "Você não pode clicar numa posição vazia");
	        		break;
	        	}
	        	case 12: {
	        		JOptionPane.showMessageDialog(this, "Este troglodita não é seu!");
	        		break;
	        	}
	        		
	        	case 13: {
	        		//JOptionPane.showMessageDialog(this, "Distância não permitida"); 
	        		break;
	        	}
	        	case 14: {
	        		//JOptionPane.showMessageDialog(this, "Não há blocos suficientes para a movimentação"); 
	        		break;
	        	}
	        	case 15: {
	        		//JOptionPane.showMessageDialog(this, "Não pode mover, pois há peças suas no intervalo!"); 
	        		break;
	        	}
	        	case 16: {
	        		//JOptionPane.showMessageDialog(this, "Peça selecionada!"); 
	        		break;
	        	}
	        	case 17: JOptionPane.showMessageDialog(this, "A partida corrente não pode ser interrompida!"); break;
	        	case 18: JOptionPane.showMessageDialog(this, "O jogo ainda não começou! Conecte-se e aguarde uma solicitação" +
	        											" ou clique em \"Iniciar nova partida\"!"); break;
	        	case 19: JOptionPane.showMessageDialog(this, "A partida começou! Aguarde a primeira jogada de " + atorJogador.informaNomeJogador(2)); break;
			};
		}	
		
}