package viewer;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DaoPublicacao;
import model.Publicacao;

public class JanelaConsultarPublicacoes extends JFrame {

	private JPanel contentPane;
	private JTextField tfConsultaIsbn;
	private JTextField tfDadosPublicacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaConsultarPublicacoes frame = new JanelaConsultarPublicacoes();
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
	public JanelaConsultarPublicacoes() {
		setTitle("JanelaConsultarPublica\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfConsultaIsbn = new JTextField();
		tfConsultaIsbn.setBounds(141, 24, 156, 20);
		contentPane.add(tfConsultaIsbn);
		tfConsultaIsbn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ISBN: ");
		lblNewLabel.setBounds(96, 27, 39, 14);
		contentPane.add(lblNewLabel);
		
		tfDadosPublicacao = new JTextField();
		tfDadosPublicacao.setBounds(31, 80, 377, 128);
		contentPane.add(tfDadosPublicacao);
		tfDadosPublicacao.setColumns(10);
		
		JButton btSair = new JButton("SAIR");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btSair.setBounds(251, 227, 89, 23);
		contentPane.add(btSair);
		
		JButton btConsultar = new JButton("Consultar");
		btConsultar.addActionListener(new ActionListener() {
			private Component btOk;

			public void actionPerformed(ActionEvent arg0) {
				
				String isbn=tfConsultaIsbn.getText();
				String aux;
				
				try {
					DaoPublicacao daoPublicacao = new DaoPublicacao();
					Publicacao[] lista = (Publicacao[])daoPublicacao.consultarTodos();
					for(int i = 0; i < daoPublicacao.getNumPublicacao(); i++) {
						
						Publicacao umaPub = lista[i];
						
						if(umaPub.getIsbn().equals(isbn)) {
							aux=umaPub.toString();
							tfDadosPublicacao.setText(aux);
						}
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(btOk,"ISBN NÃO ENCONTRADO!"+e.getMessage());
				}
				
			}
		});
		
		btConsultar.setBounds(83, 227, 124, 23);
		contentPane.add(btConsultar);
	}
}
