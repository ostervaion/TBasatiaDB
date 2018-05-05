package logika;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import klaseak.Konexioa;

public class klase_sesioak {
	private String SQL_INSERT = "INSERT INTO SESIOAK(SNICK, DATA, DENBORA) VALUES (?,?,?)";
	private String SQL_SELECT = "SELECT * FROM SESIOAK ORDER BY DATA DESC, DENBORA DESC";
	private Konexioa K;
	private java.sql.PreparedStatement PS;
	private ResultSet RS;
	private Calendar egutegi;
	java.util.Date data1 = new java.util.Date();
	SimpleDateFormat oinarria = new SimpleDateFormat("yyyy/MM/dd");
	java.sql.Date data = new java.sql.Date(data1.getTime());
	
	
	public klase_sesioak() {
		K = new Konexioa();
		PS = null;
		RS = null;
		egutegi = new GregorianCalendar();
	}
	
	public Time lortuOrdua() {
		int ordua, minutuak, segunduak = 0;
		ordua = egutegi.get(Calendar.HOUR_OF_DAY);
		minutuak = egutegi.get(Calendar.MINUTE);
		segunduak = egutegi.get(Calendar.SECOND);
		String denbora = ordua+":"+minutuak+":"+segunduak;
		return Time.valueOf(denbora);
		
	}
	
	public int insertDatuak(String pNick ) {
		try {
			PS = K.getConnection().prepareStatement(SQL_INSERT);
			PS.setString	(1, pNick);
			PS.setDate		(2, data); 
			PS.setTime		(3, this.lortuOrdua());
			int erantzun = PS.executeUpdate();
			if (erantzun > 0) {
				JOptionPane.showMessageDialog(null, "Sesioa hasita...");
			}
		} catch (SQLException e) {
			System.out.println("Errorea datuak gordetzean: " + e.getMessage());
		} finally { //Errore bat egotekotan try/catch sekuentzian, finally sekuentzia barruan dagoena exekutatuko da.
			PS = null;
			K.deskonektatu();
		}
		return 0;
	}
	
	public String lortuIzena() {
		String izena = null;
		try {
			PS = K.getConnection().prepareStatement(SQL_SELECT);
			RS = PS.executeQuery();
			RS.next();
			izena = RS.getString(1);
			
		}catch (SQLException e) {
			
		}
		return izena;
	}	
	}

