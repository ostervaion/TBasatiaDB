package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import klaseak.Konexioa;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Konektatu extends JFrame {
	
	Konexioa con;

	private JPanel contentPane;
	private static Konektatu nKonektatu = null;
	
	public static void main(String[] args) {
		Konektatu.getKonektatu();
	}
	
	public static Konektatu getKonektatu() {
		if (nKonektatu == null) {
			nKonektatu = new Konektatu();
		}
		return nKonektatu;
	}
	
	private Konektatu() {
		setBounds(800, 400, 191, 238);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		JPanel panela = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panela.setLayout(new BoxLayout(panela, BoxLayout.Y_AXIS));
		
		JButton btnKonektatu = new JButton("Konektatu");
		btnKonektatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				con = new Konexioa();
				Connection reg = con.getConnection();
			}
		});
		
		JButton btnDeskonektatu = new JButton("Deskonektatu");
		btnDeskonektatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				con.deskonektatu();
			}
			
		});
		panela.add(btnKonektatu);
		panela.add(btnDeskonektatu);
		
		contentPane.add(panela);
		pack();
		setVisible(true);
	}

}
