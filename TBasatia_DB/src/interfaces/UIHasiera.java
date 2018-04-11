package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIHasiera extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIHasiera frame = new UIHasiera();
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
	public UIHasiera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 334, 211);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBerriaAlZara = new JLabel("Berria al zara?");
		lblBerriaAlZara.setFont(new Font("Arial", Font.BOLD, 14));
		lblBerriaAlZara.setHorizontalAlignment(SwingConstants.CENTER);
		lblBerriaAlZara.setBounds(0, 36, 334, 14);
		panel.add(lblBerriaAlZara);
		
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.setBounds(115, 74, 109, 23);
		panel.add(btnErregistratu);
		btnErregistratu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UIErregistroa.main(null);
				UIHasiera.this.dispose();
			}
			
		});
		
		JLabel lblBestela = new JLabel("Bestela...");
		lblBestela.setFont(new Font("Arial", Font.BOLD, 14));
		lblBestela.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestela.setBounds(0, 120, 334, 14);
		panel.add(lblBestela);
		
		JButton btnSesioaHasi = new JButton("Sesioa Hasi");
		btnSesioaHasi.setBounds(115, 157, 109, 23);
		panel.add(btnSesioaHasi);
		btnSesioaHasi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UISesioaHasi.main(null);
				UIHasiera.this.dispose();
			}
			
		});
	}
}
