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

public class UIJokalari extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIJokalari frame = new UIJokalari();
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
	public UIJokalari() {
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
		
		JLabel lblJokalariarenPanela = new JLabel("JOKALARIAREN PANELA");
		lblJokalariarenPanela.setFont(new Font("Arial", Font.BOLD, 14));
		lblJokalariarenPanela.setHorizontalAlignment(SwingConstants.CENTER);
		lblJokalariarenPanela.setBounds(10, 36, 414, 14);
		panel.add(lblJokalariarenPanela);
		
		JButton btnSesioaAmaitu = new JButton("Sesioa Amaitu");
		btnSesioaAmaitu.setBounds(303, 227, 121, 23);
		panel.add(btnSesioaAmaitu);
		btnSesioaAmaitu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UIHasiera.main(null);
				UIJokalari.this.dispose();
			}
			
		});
	}

}
