package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DaoEditora;
import model.DaoObra;
import model.DaoPublicacao;
import model.Editora;
import model.ModelException;
import model.Obra;
import model.Publicacao;

public class JanelaPublicacao extends JFrame {

	private JPanel contentPane;
	private JTextField tfIsbn;
	private JTextField tfAno;
	private JTextField tfNumEdicao;
	private JTextField tfTipoMidia;
	private JComboBox cbObra;
	private JComboBox cbEditora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPublicacao frame = new JanelaPublicacao();
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
	public JanelaPublicacao() {
		setTitle("Janela Publicação");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Isbn:");
		lblNewLabel.setBounds(25, 29, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ano:");
		lblNewLabel_1.setBounds(25, 64, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número Edição:");
		lblNewLabel_2.setBounds(192, 29, 94, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de mídia:");
		lblNewLabel_3.setBounds(202, 64, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		tfIsbn = new JTextField();
		tfIsbn.setBounds(61, 27, 86, 20);
		contentPane.add(tfIsbn);
		tfIsbn.setColumns(10);
		
		tfAno = new JTextField();
		tfAno.setBounds(61, 62, 86, 20);
		contentPane.add(tfAno);
		tfAno.setColumns(10);
		
		tfNumEdicao = new JTextField();
		tfNumEdicao.setBounds(296, 27, 110, 20);
		contentPane.add(tfNumEdicao);
		tfNumEdicao.setColumns(10);
		
		tfTipoMidia = new JTextField();
		tfTipoMidia.setBounds(296, 62, 110, 20);
		contentPane.add(tfTipoMidia);
		tfTipoMidia.setColumns(10);
		
		JButton btOk = new JButton("OK");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String isbn=tfIsbn.getText();
				String a=tfAno.getText();
				String ne=tfNumEdicao.getText();
				String tipoMidia=tfTipoMidia.getText();
				int ano;
				int numEdicao;
				Obra o = (Obra)cbObra.getSelectedItem();
				Editora ed = (Editora)cbEditora.getSelectedItem();
				
				try {
					ano=Integer.parseInt(a);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk,"Ano inválido! ");
					return;
				}
				
				try {
					numEdicao=Integer.parseInt(ne);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk,"Número de edição inválido! ");
					return;
				}
				
				try {
					Publicacao pb= new Publicacao(isbn,ano,numEdicao,tipoMidia,o,ed);
					JOptionPane.showMessageDialog(btOk," Nova Publicação incluída!");
					setVisible(false);

					DaoPublicacao dao = new DaoPublicacao();
					dao.incluir(pb);
					dao.commit();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btOk,"Não funcionou!"+e1.getMessage());
					return;
				}
			}
		});
		btOk.setBounds(75, 202, 89, 23);
		contentPane.add(btOk);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btSair.setBounds(252, 202, 89, 23);
		contentPane.add(btSair);
		
		cbObra = new JComboBox();
		cbObra.setBounds(40, 138, 149, 21);
		contentPane.add(cbObra);
		try {
			DaoObra daoObra = new DaoObra();
			Obra[] lista = (Obra[])daoObra.consultarTodos();
			for(int i = 0; i < daoObra.getNumObra(); i++) {
				cbObra.addItem(lista[i]);			
			}
		} catch (ModelException e1) {
			System.out.println("Ocorreu algum problema na montagem da caixa de seleção: " + e1);
		}
		
		JLabel lblNewLabel_4 = new JLabel("OBRA:");
		lblNewLabel_4.setBounds(92, 115, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		cbEditora = new JComboBox();
		cbEditora.setBounds(227, 138, 149, 21);
		contentPane.add(cbEditora);
		try { 
			DaoEditora daoEditora = new DaoEditora();
			Editora[] lista = (Editora[])daoEditora.consultarTodos();
			for(int i = 0; i < daoEditora.getNumEditora(); i++) {
				cbEditora.addItem(lista[i]);			
			}
		} catch (ModelException e1) {
			System.out.println("Ocorreu algum problema na montagem da caixa de seleção: " + e1);
		}
		
		JLabel lblNewLabel_5 = new JLabel("EDITORA:");
		lblNewLabel_5.setBounds(276, 115, 62, 13);
		contentPane.add(lblNewLabel_5);
	}
}