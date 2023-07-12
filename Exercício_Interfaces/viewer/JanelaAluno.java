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

import model.Aluno;

public class JanelaAluno extends JFrame {

	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextField tfMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAluno frame = new JanelaAluno();
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
	public JanelaAluno() {
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(24, 35, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(24, 72, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IDADE:");
		lblNewLabel_2.setBounds(24, 116, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MATRÍCULA:");
		lblNewLabel_3.setBounds(24, 156, 75, 13);
		contentPane.add(lblNewLabel_3);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(79, 32, 96, 19);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(79, 69, 279, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(79, 113, 96, 19);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(104, 153, 124, 19);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		JButton btOk = new JButton("OK");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf=tfCpf.getText();
				String nome=tfNome.getText();
				String id=tfIdade.getText();
				String matricula=tfMatricula.getText();
				int idade;
				
				try {
					idade=Integer.parseInt(id);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk,"Idade inválida!"+nfe);
					return;
				}
				
				try {
					Aluno ja= new Aluno(cpf,nome,idade,matricula);
					JOptionPane.showMessageDialog(btOk,"Aluno cadastrado! ");
				}catch(Exception e1){
					JOptionPane.showMessageDialog(btOk,"Erro ao cadastrar! "+e1.getMessage());
					e1.printStackTrace();
					return;
				}
				
				
			}
		});
		btOk.setBounds(90, 211, 85, 21);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("CANCELAR");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(230, 211, 109, 21);
		contentPane.add(btCancelar);
	}
}
