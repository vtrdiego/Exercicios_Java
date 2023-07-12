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

import model.Pessoa;

public class JanelaPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfNome;
	private JLabel lblNewLabel_2;
	private JTextField tfIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPessoa frame = new JanelaPessoa();
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
	public JanelaPessoa() {
		setTitle("Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(13, 21, 29, 23);
		contentPane.add(lblNewLabel);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(62, 23, 245, 19);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(13, 71, 46, 13);
		contentPane.add(lblNewLabel_1);
		
		tfNome = new JTextField();
		tfNome.setBounds(62, 68, 245, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		lblNewLabel_2 = new JLabel("IDADE:");
		lblNewLabel_2.setBounds(13, 128, 39, 13);
		contentPane.add(lblNewLabel_2);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(62, 125, 96, 19);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		JButton btOk = new JButton("OK");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf=tfCpf.getText();
				String nome=tfNome.getText();
				String aux=tfIdade.getText();
				int idade;
				
				try {
					idade=Integer.parseInt(aux);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk,"Idade inválida!"+aux);
					return;
				}
				
				try {
					Pessoa p= new Pessoa(cpf,nome, idade);
					JOptionPane.showMessageDialog(btOk,"Deu Bom!"+p);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btOk,"Deu Ruim!"+e1.getMessage());
					return;
				}
				
			}
		});
		btOk.setBounds(106, 204, 85, 21);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("CANCELAR");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(255, 204, 102, 21);
		contentPane.add(btCancelar);
	}
}
