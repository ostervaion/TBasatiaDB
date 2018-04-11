package logika;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import klaseak.Konexioa;

public class klase_KartaKudea {
	private PreparedStatement PS;
	private final Konexioa K;
	private final String SQL_SELECT = "SELECT * FROM KANIMALI";
	private final String SQL_INSERT = "INSERT INTO KANIMALI (AIZENA, ZENBAKIA, AZALPENA, JORIGINALA, PUNTUAK) values (?, ?, ?, ?, ?)";
	private DefaultTableModel DT;
	private ResultSet RS;
	
	public klase_KartaKudea() {
		PS = null;
		K = new Konexioa();
		DT = new DefaultTableModel();
	}
	
	private DefaultTableModel setIzenburu() {
		DT = new DefaultTableModel();
		DT.addColumn("Izena");
		DT.addColumn("Zenbakia");
		DT.addColumn("Azalpena");
		DT.addColumn("Originala");
		DT.addColumn("Puntuak");
		return DT;
	}
	
	public DefaultTableModel getDatuak() {
		try {
			this.setIzenburu();
			PS = K.getConnection().prepareStatement(SQL_SELECT);
			RS = PS.executeQuery();
			Object[] lerroa = new Object[5];
			while (RS.next()) {
				lerroa[0] = RS.getString(1);
				lerroa[1] = RS.getInt(2);
				lerroa[2] = RS.getString(3);
				lerroa[3] = RS.getString(4);
				lerroa[4] = RS.getInt(5);
				DT.addRow(lerroa);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Errorea datuak enlistatzean: " + e.getMessage());
		}
		return DT;
	}
	
	public int updateDatuak(int pZenbaki,  String pAzalpena, int pPuntuak, String pOriginala, String pIzena ) {
		String SQL = "UPDATE KANIMALI SET ZENBAKIA ='"+pZenbaki+"', AZALPENA = '"+pAzalpena+"', PUNTUAK = '"+pPuntuak+"', JORIGINALA = '"+pOriginala+"' WHERE AIZENA = '"+pIzena+"'";
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
	
	public int insertDatuak(String pAIzen, int pZenbaki, String pAzalpena, int pPuntuak, String pOriginala) {
		try {
			PS = K.getConnection().prepareStatement(SQL_INSERT);
			PS.setString	(1, pAIzen);
			PS.setInt		(2, pZenbaki); 
			PS.setString	(3, pAzalpena);
			PS.setString	(4, pOriginala);
			PS.setInt		(5, pPuntuak);
			int erantzun = PS.executeUpdate();
			if (erantzun > 0) {
				JOptionPane.showMessageDialog(null, "Erregistroa gordeta...");
			}
		} catch (SQLException e) {
			System.out.println("Errorea datuak gordetzean: " + e.getMessage());
		} finally { //Errore bat egotekotan try/catch sekuentzian, finally sekuentzia barruan dagoena exekutatuko da.
			PS = null;
			K.deskonektatu();
		}
		return 0;
	}
}
