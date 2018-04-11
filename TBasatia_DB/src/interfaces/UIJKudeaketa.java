package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logika.klase_Erregistroa;
import logika.klase_JokalariKudea;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class UIJKudeaketa extends JFrame {

	private JPanel contentPane;
	private JTable table;
	klase_JokalariKudea KJ = new klase_JokalariKudea();
	private JTextField textField;
	int num = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIJKudeaketa frame = new UIJKudeaketa();
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
	public UIJKudeaketa() {
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
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNick.setBounds(252, 76, 46, 14);
		panel.add(lblNick);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(326, 73, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblMota = new JLabel("Mota");
		lblMota.setHorizontalAlignment(SwingConstants.CENTER);
		lblMota.setBounds(252, 114, 46, 14);
		panel.add(lblMota);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(326, 111, 86, 20);
		panel.add(comboBox);
		comboBox.addItem("Jokalari");
		comboBox.addItem("Admin");
		comboBox.addItem("Null");
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		table.setRowSelectionAllowed(false);
		table.setBounds(10, 11, 206, 239);
		panel.add(table);
		table.setModel(KJ.getDatuak());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				textField.setText(table.getValueAt(row, 0).toString());
				comboBox.setSelectedItem(table.getValueAt(row, 1).toString());
				num = 1;
			}
		});
		
		JButton btnAldatuBaimenak = new JButton("Aldatu Baimenak");
		btnAldatuBaimenak.setBounds(252, 166, 160, 23);
		panel.add(btnAldatuBaimenak);
		btnAldatuBaimenak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String mota = comboBox.getSelectedItem().toString();
				String nick = textField.getText();
				KJ.updateDatuak(nick, mota);
				UIJKudeaketa.main(null);
				UIJKudeaketa.this.dispose();
			}
			
		});
		
		JLabel lblBaimenAldaketa = new JLabel("BAIMEN ALDAKETA");
		lblBaimenAldaketa.setFont(new Font("Arial", Font.BOLD, 14));
		lblBaimenAldaketa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaimenAldaketa.setBounds(226, 22, 198, 14);
		panel.add(lblBaimenAldaketa);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(335, 227, 89, 23);
		panel.add(btnAtzera);
		btnAtzera.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				UIAdmin.main(null);
				UIJKudeaketa.this.dispose();
			}
			
		});
	}
}
