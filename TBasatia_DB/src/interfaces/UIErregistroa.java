package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import klaseak.Jokalari;
import logika.klase_Erregistroa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;

public class UIErregistroa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private klase_Erregistroa KJ;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIErregistroa frame = new UIErregistroa();
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
	public UIErregistroa() {
		KJ = new klase_Erregistroa();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox = new JComboBox();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 459, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblErregistroa = new JLabel("ERREGISTROA");
		lblErregistroa.setFont(new Font("Arial", Font.BOLD, 14));
		lblErregistroa.setHorizontalAlignment(SwingConstants.CENTER);
		lblErregistroa.setBounds(10, 27, 439, 14);
		panel.add(lblErregistroa);
		
		JLabel lblIzena_1 = new JLabel("Izena");
		lblIzena_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena_1.setBounds(28, 73, 61, 14);
		panel.add(lblIzena_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 73, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPasahitza_1 = new JLabel("Pasahitza");
		lblPasahitza_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasahitza_1.setBounds(28, 113, 61, 14);
		panel.add(lblPasahitza_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 113, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblJaiotzeUrtea = new JLabel("Jaiotze urtea");
		lblJaiotzeUrtea.setHorizontalAlignment(SwingConstants.CENTER);
		lblJaiotzeUrtea.setBounds(10, 154, 90, 14);
		panel.add(lblJaiotzeUrtea);
		
		textField_4 = new JTextField();
		textField_4.setBounds(131, 154, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(28, 198, 61, 14);
		panel.add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setBounds(101, 198, 116, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnErregistratu = new JButton("Erregistratu");
		btnErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pEIzen = textField_7.getText();
				String pIzen = textField_2.getText();
				String pAbizen = textField_6.getText();
				String pEmail = textField_5.getText();
				int pJUrtea = Integer.parseInt(textField_4.getText());
				String pPasahitza = textField_3.getText();
				String pMota = (String)comboBox.getSelectedItem();
				
				KJ.insertDatuak(pEIzen, null, pIzen, pAbizen, pEmail, pJUrtea, pPasahitza, pMota);
				UIHasiera.main(null);
				UIErregistroa.this.dispose();
			}
		});
		btnErregistratu.setBounds(185, 252, 89, 23);
		panel.add(btnErregistratu);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(360, 306, 89, 23);
		panel.add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UIHasiera.main(null);
				UIErregistroa.this.dispose();
			}
			
		});
		
		JLabel lblAbizena = new JLabel("Abizena");
		lblAbizena.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbizena.setBounds(235, 73, 61, 14);
		panel.add(lblAbizena);
		
		textField_6 = new JTextField();
		textField_6.setBounds(336, 73, 86, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setBounds(235, 113, 61, 14);
		panel.add(lblNickname);
		
		textField_7 = new JTextField();
		textField_7.setBounds(336, 110, 86, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblMota = new JLabel("Mota");
		lblMota.setHorizontalAlignment(SwingConstants.CENTER);
		lblMota.setBounds(235, 154, 61, 14);
		panel.add(lblMota);
		
		comboBox.setToolTipText("");
		comboBox.setBounds(336, 154, 86, 20);
		if (KJ.erabiltzaileKop()==0) {
			comboBox.addItem("Admin");
			comboBox.addItem("Jokalari");
		}else {
			comboBox.addItem("Jokalari");
		}
		panel.add(comboBox);
	}
}

