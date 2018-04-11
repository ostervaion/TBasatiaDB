package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UIAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIAdmin frame = new UIAdmin();
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
	public UIAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdministratzailearenPanela = new JLabel("ADMINISTRATZAILEAREN PANELA");
		lblAdministratzailearenPanela.setFont(new Font("Arial", Font.BOLD, 14));
		lblAdministratzailearenPanela.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministratzailearenPanela.setBounds(10, 29, 414, 14);
		panel.add(lblAdministratzailearenPanela);
		
		JButton btnSesioaAmaitu = new JButton("Sesioa Amaitu");
		btnSesioaAmaitu.setBounds(279, 215, 125, 23);
		panel.add(btnSesioaAmaitu);
		btnSesioaAmaitu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UIHasiera.main(null);
				UIAdmin.this.dispose();
			}
			
		});
		
		JButton btnKartakKudeatu = new JButton("Kartak Kudeatu");
		btnKartakKudeatu.setBounds(130, 124, 179, 23);
		panel.add(btnKartakKudeatu);
		btnKartakKudeatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UIKErregistroa.main(null);
				UIAdmin.this.dispose();
			}
		});
		
		JButton btnJokalariakKudeatu = new JButton("Jokalariak Kudeatu");
		btnJokalariakKudeatu.setBounds(130, 73, 179, 23);
		panel.add(btnJokalariakKudeatu);
		btnJokalariakKudeatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UIJKudeaketa.main(null);
				UIAdmin.this.dispose();
			}
		});
	}
}
