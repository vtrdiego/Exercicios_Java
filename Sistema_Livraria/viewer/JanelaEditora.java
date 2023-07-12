package viewer;

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

import model.DaoEditora;
import model.Editora;

public class JanelaEditora extends JFrame {

	private JPanel contentPane;
	private JTextField tfCnpj;
	private JTextField tfNome;
	private JTextField tfCidade;
	private JTextField tfUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaEditora frame = new JanelaEditora();
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
	public JanelaEditora() {
		setTitle("Janela Editora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cnpj:");
		lblNewLabel.setBounds(34, 33, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(34, 67, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cidade:");
		lblNewLabel_2.setBounds(34, 92, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("UF:");
		lblNewLabel_3.setBounds(34, 122, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		tfCnpj = new JTextField();
		tfCnpj.setBounds(78, 30, 174, 20);
		contentPane.add(tfCnpj);
		tfCnpj.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(78, 64, 86, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(78, 92, 86, 20);
		contentPane.add(tfCidade);
		tfCidade.setColumns(10);
		
		tfUf = new JTextField();
		tfUf.setBounds(78, 119, 86, 20);
		contentPane.add(tfUf);
		tfUf.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cnpj=tfCnpj.getText();
				String nome=tfNome.getText();
				String cidade=tfCidade.getText();
				String uf=tfUf.getText();
				
				try {
					Editora ed=new Editora(cnpj,nome,cidade,uf);
					JOptionPane.showMessageDialog(btOk," Nova Editora incluída!");
					setVisible(false);

					DaoEditora dao = new DaoEditora();
					dao.incluir(ed);
					dao.commit();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btOk," Não funcionou!"+e1.getMessage());
					return;
				}
				
			}
		});
		btOk.setBounds(75, 191, 89, 23);
		contentPane.add(btOk);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btSair.setBounds(210, 191, 89, 23);
		contentPane.add(btSair);
	}

}
