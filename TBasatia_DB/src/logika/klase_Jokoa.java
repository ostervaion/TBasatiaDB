package logika;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import klaseak.Konexioa;

public class klase_Jokoa {
	private final String sql = "INSERT INTO PARTIDA(KODEA, EMAITZA, KOLOREA, HORDUA, BORDUA, DATA, JIZENA, PUNTUAK) VALUES (?,?,?,?,?,?,?,?)";
	private PreparedStatement PS;
	private final Konexioa K;
	private Calendar egutegi;
	private static Time hasieraOrdua;
	java.util.Date data1 = new java.util.Date();
	SimpleDateFormat oinarria = new SimpleDateFormat("yyyy/MM/dd");
	java.sql.Date data = new java.sql.Date(data1.getTime());
	
	public klase_Jokoa() {
		PS = null;
		K = new Konexioa();
		egutegi = new GregorianCalendar();
	}
	
	public int puntuazioaPasatu(int pKodea, Time pHordua,Time pBordua, String pIzena, int pPuntuak) {
		try {
			PS = K.getConnection().prepareStatement(sql);
			PS.setInt		(1, pKodea);
			PS.setString	(2, null); 
			PS.setString	(3, null);
			PS.setTime		(4, pHordua);
			PS.setTime		(5, pBordua);
			PS.setDate		(6, data);
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
	
	public Time lortuOrdua() {
		int ordua, minutuak, segunduak = 0;
		ordua = egutegi.get(Calendar.HOUR_OF_DAY);
		minutuak = egutegi.get(Calendar.MINUTE);
		segunduak = egutegi.get(Calendar.SECOND);
		String denbora = ordua+":"+minutuak+":"+segunduak;
		return Time.valueOf(denbora);
		
	}
	public void setHasieraOrdua(Time pDenbora) {
		hasieraOrdua = pDenbora;
	}
}
