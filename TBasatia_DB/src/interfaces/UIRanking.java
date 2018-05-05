package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logika.klase_Ranking;
import logika.klase_sesioak;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UIRanking extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private klase_Ranking KR = new klase_Ranking();
	private klase_sesioak KS = new klase_sesioak();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIRanking frame = new UIRanking();
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
	public UIRanking() {
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(205, 175, 101, 22);
		panel.add(comboBox);
		comboBox.addItem("Nireak");
		comboBox.addItem("Egunekoak");
		comboBox.addItem("Orokorrak");
		comboBox.addItem("BatazBestekoak");
		
		table = new JTable();
		table.setBounds(10, 11, 414, 120);
		panel.add(table);
		
		JLabel lblNirePuntuazioMaxiomoa = new JLabel("Nire Puntuazio Maxiomoa");
		lblNirePuntuazioMaxiomoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNirePuntuazioMaxiomoa.setBounds(20, 142, 190, 14);
		panel.add(lblNirePuntuazioMaxiomoa);
		
		textField = new JTextField();
		textField.setBounds(291, 139, 86, 20);
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		textField.setText(String.valueOf(KR.lortuNirePuntuMax(KS.lortuIzena())));
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(335, 227, 89, 23);
		panel.add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UIJokalari.main(null);
				UIRanking.this.dispose();
				
			}
		});
		
		JLabel lblRankingMota = new JLabel("Ranking Mota");
		lblRankingMota.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankingMota.setBounds(20, 178, 190, 14);
		panel.add(lblRankingMota);
		
		JButton btnFiltratu = new JButton("Filtratu");
		btnFiltratu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int pTmota = 0;
				switch(comboBox.getSelectedItem().toString()) {
				case "Nireak":
					pTmota = 0;
					break;
				case "Egunekoak":
					pTmota = 1;
					break;
				case "Orokorrak":
					pTmota = 2;
					break;
				case "BatazBestekoak":
					pTmota = 3;
					break;
				}
				table.setModel(KR.getDatuak(KS.lortuIzena(), pTmota));
			}
		});
		btnFiltratu.setBounds(335, 174, 89, 23);
		panel.add(btnFiltratu);
		
		
	}
}
