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

import model.DaoObra;
import model.Obra;

public class JanelaObra extends JFrame {

	private JPanel contentPane;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaObra frame = new JanelaObra();
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
	public JanelaObra() {
		setTitle("Janela Obra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Título:");
		lblNewLabel.setBounds(47, 41, 46, 14);
		contentPane.add(lblNewLabel);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(90, 38, 134, 20);
		contentPane.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Autor:");
		lblNewLabel_1.setBounds(47, 80, 39, 14);
		contentPane.add(lblNewLabel_1);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(90, 77, 134, 20);
		contentPane.add(tfAutor);
		tfAutor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ano:");
		lblNewLabel_2.setBounds(47, 126, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfAno = new JTextField();
		tfAno.setBounds(88, 123, 86, 20);
		contentPane.add(tfAno);
		tfAno.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String titulo=tfTitulo.getText();
				String autor=tfAutor.getText();
				String a=tfAno.getText();
				int ano;
				
				try {
					ano=Integer.parseInt(a);
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk," O formato do ano é inválido!");
					return;
				}
				
				try {
					Obra o= new Obra(titulo,autor,ano);
					JOptionPane.showMessageDialog(btOk, " Nova Obra incluída!"+ o);
					setVisible(false);

					DaoObra dao = new DaoObra();
					dao.incluir(o);
					dao.commit();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(btOk,"Não funcionou!"+e1.getMessage());
					return;
				}
				
			}
		});
		btOk.setBounds(85, 189, 89, 23);
		contentPane.add(btOk);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btSair.setBounds(230, 189, 89, 23);
		contentPane.add(btSair);
	}
}

