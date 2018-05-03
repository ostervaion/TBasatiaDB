package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UIJokatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIJokatu frame = new UIJokatu();
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
	public UIJokatu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 261, 207);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPultsatuBotoia = new JLabel("Pultsatu Botoia");
		lblPultsatuBotoia.setHorizontalAlignment(SwingConstants.CENTER);
		lblPultsatuBotoia.setBounds(10, 11, 241, 14);
		panel.add(lblPultsatuBotoia);
		
		JButton btnPuntuak = new JButton("Puntuak");
		btnPuntuak.setBounds(90, 99, 89, 23);
		panel.add(btnPuntuak);
		btnPuntuak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Random rd = new Random();
				int emaitza = rd.nextInt(1000);
				textField.setText(Integer.toString(emaitza));
				btnPuntuak.setEnabled(false);
			}
		});
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(90, 68, 89, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(162, 173, 89, 23);
		panel.add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textField.getText().equals(null)) {
					UIJokalari.main(null);
					UIJokatu.this.dispose();
				}else {
					
				}
				
			}
		});
	}
}
