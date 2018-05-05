package logika;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;

import klaseak.Konexioa;

public class klase_Ranking {
	private PreparedStatement PS;
	private final Konexioa K;
	private DefaultTableModel DT;
	private ResultSet RS;
	java.util.Date data1 = new java.util.Date();
	SimpleDateFormat oinarria = new SimpleDateFormat("yyyy/MM/dd");
	java.sql.Date data = new java.sql.Date(data1.getTime());
	
	public klase_Ranking() {
		K = new Konexioa();
		PS = null;
		DT = new DefaultTableModel();
		RS = null;
	}
	
	private DefaultTableModel setIzenburu() {
		DT = new DefaultTableModel();
		DT.addColumn("Puntuazioa");
		DT.addColumn("Izena");
		DT.addColumn("Data");
		Object[] lerroa = new Object[3];
		lerroa[0] = "Puntuazioa";
		lerroa[1] = "Izena";
		lerroa[2] = "Data";
		DT.addRow(lerroa);
		return DT;
	}
	
	public DefaultTableModel getDatuak(String pIzena, int pTmota) {
		try {
			setIzenburu();
			String SQL_SELECT_NIREA = "SELECT * FROM PARTIDA WHERE JIZENA='"+pIzena+"' ORDER BY PUNTUAK DESC LIMIT 5";
			String SQL_SELECT_EGUNEKOAK = "SELECT * FROM PARTIDA WHERE DATA='"+data.toString()+"' ORDER BY PUNTUAK DESC LIMIT 5";
			String SQL_SELECT_OROKORRA = "SELECT * FROM PARTIDA ORDER BY PUNTUAK DESC LIMIT 5";
			String SQL_SELECT_BATAZBESTEKOA = "SELECT *, AVG(PUNTUAK) FROM PARTIDA GROUP BY JIZENA ORDER BY AVG(PUNTUAK) LIMIT 5";
			switch(pTmota) {
				case 0:
					PS = K.getConnection().prepareStatement(SQL_SELECT_NIREA);
					break;
				case 1:
					PS = K.getConnection().prepareStatement(SQL_SELECT_EGUNEKOAK);
					break;
				case 2:
					PS = K.getConnection().prepareStatement(SQL_SELECT_OROKORRA);
					break;
				case 3:
					PS = K.getConnection().prepareStatement(SQL_SELECT_BATAZBESTEKOA);
					break;
			}
			RS = PS.executeQuery();
			Object[] lerroa = new Object[3];
			while(RS.next()) {
				lerroa[0] = RS.getInt(8);
				lerroa[1] = RS.getString(7);
				lerroa[2] = RS.getDate(6);
				DT.addRow(lerroa);
			}
		}catch (SQLException e) {
			System.out.println("Errorea datuak enlistatzean: " + e.getMessage());
		}
		return DT;
	} 
	
	public int lortuNirePuntuMax(String pIzena) {
		int emaitza = 0;
		String SQL_SELECT_NIREA_2 = "SELECT * FROM PARTIDA WHERE JIZENA='"+pIzena+"' ORDER BY PUNTUAK DESC LIMIT 1";
		try {
			PS = K.getConnection().prepareStatement(SQL_SELECT_NIREA_2);
			RS = PS.executeQuery();
			if (RS.next()) {
				emaitza = RS.getInt(8);
			}
		}catch(SQLException e){
		System.out.println("Ezin dira datuak jaso...");
		}
	return emaitza;
	}

}
