package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import klaseak.Jokalari;
import logika.klase_Erregistroa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class UISesioaHasi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UISesioaHasi frame = new UISesioaHasi();
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
	public UISesioaHasi() {
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
		
		JLabel lblSesioaHasi = new JLabel("SESIOA HASI");
		lblSesioaHasi.setFont(new Font("Arial", Font.BOLD, 14));
		lblSesioaHasi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesioaHasi.setEnabled(true);
		lblSesioaHasi.setBounds(10, 31, 414, 14);
		panel.add(lblSesioaHasi);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setBounds(74, 82, 61, 14);
		panel.add(lblNickname);
		
		textField = new JTextField();
		textField.setBounds(216, 79, 139, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(74, 132, 61, 14);
		panel.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 129, 139, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSesioaHasi = new JButton("Sesioa Hasi");
		btnSesioaHasi.setBounds(160, 181, 114, 23);
		panel.add(btnSesioaHasi);
		btnSesioaHasi.addActionListener(new ActionListener() {
			//Metodo honen bidez, sesioa hasteko aukera ematen digu programak.
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				klase_Erregistroa modSql = new klase_Erregistroa();
				Jokalari usr = new Jokalari();
				
				String pass = new String(textField_1.getText());
				
				if(!textField.getText().equals("") && !pass.equals("")) {
					usr.setNick(textField.getText());
					usr.setPasahitza(pass);
					
					if (modSql.login(usr)) {
						if (modSql.eMota(usr) == 1) {
							UIJokalari.main(null);
						}else {
							UIAdmin.main(null);
						}
						UISesioaHasi.this.dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Datuak ez dira egokiak");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Datuak hutsik daude");
				}
			}
			
		});
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(335, 227, 89, 23);
		panel.add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UIHasiera.main(null);
				UISesioaHasi.this.dispose();
			}
			
		});
	}
	public String getIzena() {
		String izena = textField.getText();
		return izena;
	}
}
