package logika;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import klaseak.Konexioa;

public class klase_JokalariKudea {
	private PreparedStatement PS;
	private final Konexioa K;
	private final String SQL_SELECT = "SELECT * FROM JOKALARI";
	private DefaultTableModel DT;
	private ResultSet RS;
	
	
	public klase_JokalariKudea() {
		PS = null;
		K = new Konexioa();
		DT = new DefaultTableModel();
	}
	
	private DefaultTableModel setIzenburu() {
		DT = new DefaultTableModel();
		DT.addColumn("Nickname");
//		DT.addColumn("Data");
//		DT.addColumn("Izena");
//		DT.addColumn("Abizena");
//		DT.addColumn("Email");
//		DT.addColumn("JUrtea");
//		DT.addColumn("Pasahitza");
		DT.addColumn("Mota");
		return DT;
	}
	
	public DefaultTableModel getDatuak() {
		try {
			setIzenburu();
			PS = K.getConnection().prepareStatement(SQL_SELECT);
			RS = PS.executeQuery();
			Object[] lerroa = new Object[2];
			while(RS.next()) {
				lerroa[0] = RS.getString(1);
//				lerroa[1] = RS.getDate(2);
//				lerroa[2] = RS.getString(3);
//				lerroa[3] = RS.getString(4);
//				lerroa[4] = RS.getString(5);
//				lerroa[5] = RS.getInt(6);
//				lerroa[6] = RS.getString(7);
				lerroa[1] = RS.getString(8);
				DT.addRow(lerroa);
			}
		}catch (SQLException e) {
			System.out.println("Errorea datuak enlistatzean: " + e.getMessage());
		//}finally {
		//	PS = null;
		//	RS = null;
		//	K.deskonektatu();
		}
		return DT;
	} 
	
	public int updateDatuak(String pEIzen,  String pMota ) {
		String SQL = "UPDATE JOKALARI SET MOTA ='"+pMota+"' WHERE EIZENA = '"+pEIzen+"'";
		int erantzun = 0;
		try {
			PS = K.getConnection().prepareStatement(SQL);
			erantzun = PS.executeUpdate();
			if (erantzun > 0) {
				JOptionPane.showMessageDialog(null, "Erregistroa aldatua...");
			}
		} catch (SQLException e) {
			System.out.println("Errorea datuak aldatzean: " + e.getMessage());
		} finally { //Errore bat egotekotan try/catch sekuentzian, finally sekuentzia barruan dagoena exekutatuko da.
			PS = null;
			K.deskonektatu();
		}
		return 0;
	}

}
