package logika;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import interfaces.UIErregistroa;
import klaseak.Jokalari;
import klaseak.Konexioa;

public class klase_Erregistroa {
	private final String SQL_INSERT = "INSERT INTO JOKALARI (EIZENA, EDATA, IZENA, ABIZENA,  EMAIL, JURTEA, PASAHITZA, MOTA) values (?, ?, ?, ?, ?, ?, ?, ?)";
	private PreparedStatement PS;
	private final Konexioa K;
	java.util.Date data1 = new java.util.Date();
	SimpleDateFormat oinarria = new SimpleDateFormat("yyyy/MM/dd");
	java.sql.Date data = new java.sql.Date(data1.getTime());
	
	public klase_Erregistroa() {
		PS = null;
		K = new Konexioa();
	}
	
	//Jokalariaren edo administratzailearen erregistroa egiten du.
	public int insertDatuak(String pEIzen, Date pData, String pIzen, String pAbizen, String pEmail, int pJUrtea, String pPasahitza, String pMota ) {
		try {
			PS = K.getConnection().prepareStatement(SQL_INSERT);
			PS.setString	(1, pEIzen);
			PS.setDate		(2, data); 
			PS.setString	(3, pIzen);
			PS.setString	(4, pAbizen);
			PS.setString	(5, pEmail);
			PS.setInt		(6, pJUrtea);
			PS.setString	(7, pPasahitza);
			PS.setString	(8, pMota);
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
	public boolean login(Jokalari pErabiltzaile) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT EIZENA, IZENA, PASAHITZA, MOTA FROM JOKALARI WHERE EIZENA = ?";
		
		try {
			ps = K.getConnection().prepareStatement(sql);
			ps.setString(1, pErabiltzaile.getNick());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(pErabiltzaile.getPasahitza().equals(rs.getString(3))) {
					pErabiltzaile.setNick(rs.getString(1));
					pErabiltzaile.setIzena(rs.getString(2));
					pErabiltzaile.setMota(rs.getString(4));
					return true;
				}else {
					return false;
				}
			}
			return false;
		}catch (SQLException ex) {
			Logger.getLogger(UIErregistroa.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
	}
	
	public int eMota (Jokalari pErabiltzaile) {
		if(pErabiltzaile.getMota().equals("Jokalari")) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public int erabiltzaileKop() {
		//Zenbat erabiltzaile erregistratuta dauden jakiteko.
		//0 egotekotan, lehenengo erabiltzailea "Admin bezala erregistratzeko aukera edukiko du.
		int emaitza = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM JOKALARI";
		
		try {
			ps = K.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next() && emaitza >0) {
				emaitza++;
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return emaitza;
	}

}
