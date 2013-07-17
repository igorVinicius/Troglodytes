package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class Sobre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Sobre() {
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();	
		setLocation((tela.width-this.getSize().width)/2,   
                (tela.height-this.getSize().height)/2);
		
		setFont(new Font("Dialog", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/imagens/logoSobre.png")));
		setTitle("Sobre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sobre.class.getResource("/imagens/logoUfsc.png")));
		lblNewLabel.setBounds(20, 29, 78, 120);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnliseEProjeto = new JLabel("Aná1lise e Projeto de Sistemas");
		lblAnliseEProjeto.setFont(new Font("Calibri", Font.BOLD, 15));
		lblAnliseEProjeto.setBounds(129, 11, 300, 14);
		contentPane.add(lblAnliseEProjeto);
		
		JLabel lblTroglodytes = new JLabel("Troglodytes");
		lblTroglodytes.setFont(new Font("Cambria", Font.BOLD, 20));
		lblTroglodytes.setBounds(164, 46, 200, 24);
		contentPane.add(lblTroglodytes);
		
		JLabel lblAutoresIgorVinicius = new JLabel("Autores: Igor Vinicius Tiburcio");
		lblAutoresIgorVinicius.setFont(new Font("Calibri", Font.ITALIC, 14));
		lblAutoresIgorVinicius.setBounds(130, 94, 300, 14);
		contentPane.add(lblAutoresIgorVinicius);
		
		JLabel lblMarcoAntnioBurgin = new JLabel("Marco Antônio Burgin Gomes da Cunha");
		lblMarcoAntnioBurgin.setFont(new Font("Calibri", Font.ITALIC, 14));
		lblMarcoAntnioBurgin.setBounds(130, 119, 400, 14);
		contentPane.add(lblMarcoAntnioBurgin);
		
		JLabel lblPedroMaurcioSanches = new JLabel("Pedro Maurício de Vargas Sanches");
		lblPedroMaurcioSanches.setFont(new Font("Calibri", Font.ITALIC, 14));
		lblPedroMaurcioSanches.setBounds(130, 144, 400, 14);
		contentPane.add(lblPedroMaurcioSanches);
		
		JLabel lblTurma = new JLabel("Turma 2013/1");
		lblTurma.setFont(new Font("Calibri", Font.ITALIC, 14));
		lblTurma.setBounds(179, 174, 150, 14);
		contentPane.add(lblTurma);
	}

}