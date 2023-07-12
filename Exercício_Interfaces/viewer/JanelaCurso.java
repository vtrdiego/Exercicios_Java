package viewer;

import java.awt.EventQueue;
import model.Curso;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCurso extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfTipo;
	private JTextField tfCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCurso frame = new JanelaCurso();
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
	public JanelaCurso() {
		setTitle("Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CÓDIGO:");
		lblNewLabel.setBounds(31, 34, 54, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(31, 71, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TIPO:");
		lblNewLabel_2.setBounds(31, 111, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CARGA HORÁRIA:");
		lblNewLabel_3.setBounds(31, 153, 105, 13);
		contentPane.add(lblNewLabel_3);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(106, 31, 96, 19);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(106, 68, 228, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfTipo = new JTextField();
		tfTipo.setBounds(106, 108, 96, 19);
		contentPane.add(tfTipo);
		tfTipo.setColumns(10);
		
		tfCarga = new JTextField();
		tfCarga.setBounds(139, 150, 96, 19);
		contentPane.add(tfCarga);
		tfCarga.setColumns(10);
		
		JButton btOk = new JButton("OK");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String codigo=tfCodigo.getText();
				String nome=tfNome.getText();
				String tipo=tfTipo.getText();
				String ch=tfCarga.getText();
				int cargaHoraria;
				
				try {
					cargaHoraria=Integer.parseInt(ch);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk,"Erro em carga horária!");
					nfe.printStackTrace();
					return;
				}
				
				try {
					Curso c= new Curso(codigo,nome,tipo,cargaHoraria);
					JOptionPane.showMessageDialog(btOk,"Curso cadastrado!");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btOk,"Erro ao cadastrar curso!"+e1.getMessage());
					e1.printStackTrace();
					return;
				}
				
			}
		});
		btOk.setBounds(74, 210, 85, 21);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("CANCELAR");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(229, 210, 105, 21);
		contentPane.add(btCancelar);
	}

}
