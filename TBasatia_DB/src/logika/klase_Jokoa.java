package logika;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.JOptionPane;

import klaseak.Konexioa;

public class klase_Jokoa {
	private final String sql = "INSERT INTO PARTIDA(KODEA, EMAITZA, KOLOREA, HORDUA, BORDUA, DATA, JIZENA, PUNTUAK) VALUES (?,?,?,?,?,?,?,?)";
	private PreparedStatement PS;
	private final Konexioa K;
	
	public klase_Jokoa() {
		PS = null;
		K = new Konexioa();
	}
	
	public int puntuazioaPasatu(int pKodea, String pEmaitza, String pKolorea, Time pHordua, Time pBordua, Date pData, String pIzena, int pPuntuak) {
		try {
			PS = K.getConnection().prepareStatement(sql);
			PS.setInt		(1, pKodea);
			PS.setString	(2, pEmaitza); 
			PS.setString	(3, pKolorea);
			PS.setTime		(4, pHordua);
			PS.setTime		(5, pBordua);
			PS.setDate		(6, pData);
			PS.setString	(7, pIzena);
			PS.setInt		(8, pPuntuak);
			int erantzun = PS.executeUpdate();
			if (erantzun > 0) {
				JOptionPane.showMessageDialog(null, "Emaitza gordeta...");
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
