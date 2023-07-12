package viewer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Programa;

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
		setTitle("JANELA PRINCIPAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OPÇÕES:");
		lblNewLabel.setBounds(184, 10, 59, 19);
		contentPane.add(lblNewLabel);
		
		JButton btPessoa = new JButton("PESSOA");
		btPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPessoa jp=new JanelaPessoa();
				jp.setVisible(true);
			}
		});
		btPessoa.setBounds(42, 67, 85, 21);
		contentPane.add(btPessoa);
		
		JButton btProfessor = new JButton("PROFESSOR");
		btProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaProfessor jpr=new JanelaProfessor();
				jpr.setVisible(true);
			}
		});
		btProfessor.setBounds(157, 67, 118, 21);
		contentPane.add(btProfessor);
		
		JButton btAluno = new JButton("ALUNO");
		btAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaAluno ja = new JanelaAluno();
				ja.setVisible(true);
			}
		});
		btAluno.setBounds(298, 67, 85, 21);
		contentPane.add(btAluno);
		
		JButton btDisciplina = new JButton("DISCIPLINA");
		btDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaDisciplina jd = new JanelaDisciplina();
				jd.setVisible(true);
			}
		});
		btDisciplina.setBounds(86, 138, 104, 21);
		contentPane.add(btDisciplina);
		
		JButton btCurso = new JButton("CURSO");
		btCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaCurso jc =new JanelaCurso();
				jc.setVisible(true);
			}
		});
		btCurso.setBounds(239, 138, 104, 21);
		contentPane.add(btCurso);
		
		JButton btSair = new JButton("SAIR");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Programa.salvarObjetos();
				System.exit(0);
			}
		});
		btSair.setBackground(new Color(255, 157, 157));
		btSair.setBounds(125, 214, 180, 21);
		contentPane.add(btSair);
	}

}
