package klaseak;

import java.util.Date;

public class Jokalari {
	private String Nick;
	private String Izena;
//	private String Abizena;
//	private String Email;
	private String Pasahitza;
//	private int jUrtea;
//	private Date data;
	private String Mota;
	
	
	public String getMota() {
		return Mota;
	}

	public void setMota(String mota) {
		Mota = mota;
	}
	
	public String getNick() {
		return Nick;
	}

	public void setNick(String i) {
		Nick = i;
	}

	public String getIzena() {
		return Izena;
	}

	public void setIzena(String izena) {
		Izena = izena;
	}

	public String getPasahitza() {
		return Pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		Pasahitza = pasahitza;
	}
}
