package viewer;

import java.awt.EventQueue;

import model.Professor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField tfCpf;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextField tfMatricula;
	private JButton btOk;
	private JButton btCancelar;
	private JLabel lblNewLabel_4;
	private JTextField tfTitulacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaProfessor frame = new JanelaProfessor();
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
	public JanelaProfessor() {
		setTitle("Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(54, 29, 41, 13);
		contentPane.add(lblNewLabel);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(105, 26, 96, 19);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(42, 60, 53, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("IDADE:");
		lblNewLabel_2.setBounds(37, 89, 58, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("MATRÍCULA:");
		lblNewLabel_3.setBounds(25, 118, 77, 13);
		contentPane.add(lblNewLabel_3);
		
		tfNome = new JTextField();
		tfNome.setBounds(105, 55, 280, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfIdade = new JTextField();
		tfIdade.setText("");
		tfIdade.setBounds(105, 86, 96, 19);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(105, 115, 107, 19);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		btOk = new JButton("OK");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf=tfCpf.getText();
				String nome=tfNome.getText();
				String id=tfIdade.getText();
				String mt=tfMatricula.getText();
				String titulacao=tfTitulacao.getText();
				int idade;
				int matricula;
				
				try {
					idade=Integer.parseInt(id);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk,"Idade inválida!"+nfe);
					return;
				}
				
				try {
					matricula=Integer.parseInt(mt);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk,"Matrícula inválida!"+nfe);
					return;
				}
				
				try {
					Professor pf = new Professor(cpf,nome,idade,matricula,titulacao);
					JOptionPane.showMessageDialog(btOk,"Professor cadastrado!");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btOk,"Erro no cadastramento! "+e1.getMessage());
					e1.printStackTrace();
					return;
				}
				
				
			}
		});
		btOk.setBounds(85, 210, 85, 21);
		contentPane.add(btOk);
		
		btCancelar = new JButton("CANCELAR");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(237, 210, 115, 21);
		contentPane.add(btCancelar);
		
		lblNewLabel_4 = new JLabel("TITULAÇÃO:");
		lblNewLabel_4.setBounds(25, 152, 77, 13);
		contentPane.add(lblNewLabel_4);
		
		tfTitulacao = new JTextField();
		tfTitulacao.setBounds(105, 149, 125, 19);
		contentPane.add(tfTitulacao);
		tfTitulacao.setColumns(10);
	}

}
