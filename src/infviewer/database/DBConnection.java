package infviewer.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Klasa sluzi za povezivanje sa određenom bazom podataka. Pre izvršavanja bilo kakve SQL naredbe potrebno je
 * obezbediti Connection objekat koji predstavlja uspostavljenu vezu sa bazom podataka.
 * ObjekatConnection takođe služi za izvršavanjem upita nad bazom podataka 
 * radi dobijanja informacija opodacima u bazi podataka. 
 *
 * 
 * @author DrGoz
 *
 */
public class DBConnection {
	
	private static DBConnection instance = new DBConnection();
	private String ipAdress;
	private String dbname;
	private String dbusername;
	private String dbpassword;
	private String server;
	private Connection connection;
	
	private DBConnection() { }
	
	public static DBConnection getInstance(){		
		return instance;
	}
	
	/**
	 * 
	 * @param url Adresa na koju se korisnik konektuj.
	 * @param baza Baza na koju se konektuje.
	 * @param korisnik Korisnicko ime
	 * @param lozinka Lozinka korisnika.
	 * @param konekcija Adresa konekcije.
	 * @throws SQLException neuspesno konektovanje na bazu.
	 */
	public void setParams(String url, String baza,String korisnik, String lozinka, String konekcija) throws SQLException {
		this.ipAdress=url;
		this.dbname=baza;
		this.dbusername=korisnik;
		this.dbpassword=lozinka;
		this.server=konekcija;
		connection = DriverManager.getConnection(server+ipAdress+"/"+dbname, dbusername, dbpassword);
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getDbusername() {
		return dbusername;
	}

	public void setDbusername(String dbusername) {
		this.dbusername = dbusername;
	}

	public String getDbpassword() {
		return dbpassword;
	}

	public void setDbpassword(String dbpassword) {
		this.dbpassword = dbpassword;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}