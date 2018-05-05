package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logika.klase_Jokoa;
import logika.klase_sesioak;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UIJokatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private klase_sesioak KS= new klase_sesioak();
	private Time bukaeraOrdua;
	private klase_Jokoa KJ = new klase_Jokoa();
	private JTextField textField_3;
	private Random rd = new Random();
	private JTextField textField_2;
	private JTextField textField_4;

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
		setLocationRelativeTo(null);
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
				klase_Jokoa KJ = new klase_Jokoa();
				int emaitza = rd.nextInt(1000);
				textField.setText(Integer.toString(emaitza));
				textField_4.setText(KJ.lortuOrdua().toString());
				btnPuntuak.setEnabled(false);
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setText(Integer.toString(rd.nextInt(200)));
		textField_3.setEditable(false);
		textField_3.setVisible(false);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(90, 68, 89, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnAmaitu = new JButton("Amaitu");
		btnAmaitu.setBounds(90, 133, 89, 23);
		panel.add(btnAmaitu);
		
		textField_1 = new JTextField();
		textField_1.setText(KS.lortuIzena());
		textField_1.setEditable(false);
		textField_1.setBounds(10, 174, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText(KJ.lortuOrdua().toString());
		textField_2.setBounds(10, 36, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(165, 36, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
	
		btnAmaitu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textField.getText().equals(null)) {
					UIJokalari.main(null);
					UIJokatu.this.dispose();
				}else {
					KJ.puntuazioaPasatu(Integer.parseInt(textField_3.getText()),Time.valueOf(textField_2.getText()),Time.valueOf(textField_4.getText()), textField_1.getText(), Integer.parseInt(textField.getText()));
					UIJokalari.main(null);
					UIJokatu.this.dispose();
				}
				
			}
		});
	}
}
