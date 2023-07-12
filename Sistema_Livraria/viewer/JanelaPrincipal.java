package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btObra = new JButton("OBRA");
		btObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaObra jo=new JanelaObra();
				jo.setVisible(true);
			}
		});
		btObra.setBounds(41, 47, 108, 23);
		contentPane.add(btObra);
		
		JButton btPublicacao = new JButton("PUBLICAÇÃO");
		btPublicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPublicacao jp=new JanelaPublicacao();
				jp.setVisible(true);
			}
		});
		btPublicacao.setBounds(159, 47, 131, 23);
		contentPane.add(btPublicacao);
		
		JButton btEditora = new JButton("EDITORA");
		btEditora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaEditora je=new JanelaEditora();
				je.setVisible(true);
			}
		});
		btEditora.setBounds(300, 47, 108, 23);
		contentPane.add(btEditora);
		
		JButton btSair = new JButton("SAIR");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btSair.setBounds(171, 176, 119, 23);
		contentPane.add(btSair);
		
		JButton btConsultar = new JButton("Consultar Publica\u00E7\u00F5es");
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaConsultarPublicacoes jcp=new JanelaConsultarPublicacoes();
				jcp.setVisible(true);
			}
		});
		btConsultar.setBounds(107, 111, 228, 23);
		contentPane.add(btConsultar);
	}
}