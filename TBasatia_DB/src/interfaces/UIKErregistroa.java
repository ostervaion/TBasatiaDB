package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logika.klase_KartaKudea;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class UIKErregistroa extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	klase_KartaKudea KK = new klase_KartaKudea();
	int num = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIKErregistroa frame = new UIKErregistroa();
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
	public UIKErregistroa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 534, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblKartenErregistroa = new JLabel("KARTEN KUDEAKETA");
		lblKartenErregistroa.setFont(new Font("Arial", Font.BOLD, 14));
		lblKartenErregistroa.setHorizontalAlignment(SwingConstants.CENTER);
		lblKartenErregistroa.setBounds(10, 22, 514, 14);
		panel.add(lblKartenErregistroa);
		
		JLabel lblIzena = new JLabel("Izena");
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setBounds(26, 209, 46, 14);
		panel.add(lblIzena);
		
		textField = new JTextField();
		textField.setBounds(94, 206, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblZenbakia = new JLabel("Zenbakia");
		lblZenbakia.setHorizontalAlignment(SwingConstants.CENTER);
		lblZenbakia.setBounds(290, 209, 64, 14);
		panel.add(lblZenbakia);
		
		textField_1 = new JTextField();
		textField_1.setBounds(399, 206, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPuntuak = new JLabel("Puntuak");
		lblPuntuak.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuak.setBounds(26, 239, 46, 14);
		panel.add(lblPuntuak);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 236, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOriginala = new JLabel("Originala");
		lblOriginala.setHorizontalAlignment(SwingConstants.CENTER);
		lblOriginala.setBounds(290, 239, 64, 14);
		panel.add(lblOriginala);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(399, 238, 86, 17);
		panel.add(comboBox);
		comboBox.addItem("B");
		comboBox.addItem("E");
		
		JLabel lblAzalpena = new JLabel("Azalpena");
		lblAzalpena.setBounds(26, 270, 46, 14);
		panel.add(lblAzalpena);
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 267, 384, 41);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.setBounds(220, 327, 89, 23);
		panel.add(btnGorde);
		btnGorde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String izena = textField.getText();
				int Zenbakia = Integer.parseInt(textField_1.getText());
				String Azalpena = textField_3.getText();
				int Puntuak = Integer.parseInt(textField_2.getText());
				String Originala = comboBox.getSelectedItem().toString();
				if (num == 0) {
					KK.insertDatuak(izena, Zenbakia, Azalpena, Puntuak, Originala);
				}else {
					KK.updateDatuak(Zenbakia, Azalpena, Puntuak, Originala, izena);
				}
				UIKErregistroa.this.dispose();
				UIKErregistroa.main(null);
			}
		});
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(435, 327, 89, 23);
		panel.add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UIAdmin.main(null);
				UIKErregistroa.this.dispose();
			}
		});
		
		table = new JTable();
		table.setBounds(10, 54, 514, 125);
		panel.add(table);
		table.setModel(KK.getDatuak());
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				textField.setText(table.getValueAt(row, 0).toString());
				textField_1.setText(table.getValueAt(row, 1).toString());
				textField_2.setText(table.getValueAt(row, 4).toString());
				comboBox.setSelectedItem(table.getValueAt(row, 3).toString());
				textField_3.setText(table.getValueAt(row, 2).toString());
				num = 1;
			}
		});
	}
}
