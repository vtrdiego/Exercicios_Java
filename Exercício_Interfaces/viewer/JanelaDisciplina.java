package viewer;

import java.awt.EventQueue;
import model.Disciplina;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfCreditos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDisciplina frame = new JanelaDisciplina();
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
	public JanelaDisciplina() {
		setTitle("Disciplina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CÓDIGO:");
		lblNewLabel.setBounds(31, 48, 64, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(31, 96, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nº DE CRÉDITOS:");
		lblNewLabel_2.setBounds(31, 142, 107, 13);
		contentPane.add(lblNewLabel_2);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(105, 45, 96, 19);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(105, 93, 215, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCreditos = new JTextField();
		tfCreditos.setBounds(141, 139, 96, 19);
		contentPane.add(tfCreditos);
		tfCreditos.setColumns(10);
		
		JButton btOk = new JButton("OK");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String codigo = tfCodigo.getText();
				String nome = tfNome.getText();
				String cr = tfCreditos.getText();
				int creditos;
				
				try {
					creditos=Integer.parseInt(cr);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk,"Formato de código inválido!"+nfe);
					return;
				}
				
				try {
					Disciplina dp = new Disciplina(codigo,nome,creditos);
					JOptionPane.showMessageDialog(btOk,"Disciplina cadastrada!");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btOk,"Erro ao cadastrar Disciplina!"+e1.getMessage());
					e1.printStackTrace();
					return;
				}
				
				
			}
		});
		btOk.setBounds(76, 206, 85, 21);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("CANCELAR");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(233, 206, 107, 21);
		contentPane.add(btCancelar);
	}

}
