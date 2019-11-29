import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// Tunnukset ja osoite tietokantaan
public class Connect {
	
	static final String URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7313312";
	static final String USERID = "sql7313312";
	static final String PASSWORD = "Ei salasanoja Gittiin";
	static String dbKaikki = "SELECT * FROM Kirjasto;";
	
	
	
 public static void main(String args[]) {
	
	
	try {
		Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
		//System.out.print("Yhteys tietokantaan luotu!");
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.print("Virhe tietokannan käytössä");
		e.printStackTrace();
	}
		
 }

 // Taulukon tietojen tyhjennys
 public static void tyhjennys() {
	 
	 DefaultTableModel model = (DefaultTableModel) Tietokantasovellus.taulukko.getModel();
	 
	 model.setRowCount(0);
	 
 }
 
 
 //Kirjan lisääminen tietokantaan ja päivitys taulukkoon
 public static void lisaaKirja(Kirja uusiKirja) {
	 
	 String kirjanNimi = uusiKirja.getKirjanNimi();
	 String tekija = uusiKirja.getTekija();
	 String julkaisuvuosi = uusiKirja.getJulkaisuvuosi();
	 String isbn = uusiKirja.getIsbn();
	 
	 if (uusiKirja.getKirjanNimi().equals("")) {
		 JOptionPane.showMessageDialog(null, "Vaikkei kirjassa olis sivun sivua,\n"
		 		+ "niin nimi sillä häätyy olla!");
	 } else {
		 
	 Connection conn = null;
	 Statement stmt =null;
	 
	 try {
		Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
		
		String sql = "INSERT INTO Kirjasto (KirjanNimi,Tekija,Julkaisuvuosi,ISBN) VALUES (?,?,?,?)";
	
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		
		
		preparedStmt.setString(1, kirjanNimi);
		preparedStmt.setString(2, tekija);
		preparedStmt.setString(3, julkaisuvuosi);
		preparedStmt.setString(4, isbn);
	 	
		preparedStmt.execute();
		tyhjennys();
		lataappa();
		 
	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se2) {
		} 
		try {
			if (conn != null)
				conn.close();
			JOptionPane.showMessageDialog(null, "Kirja lisätty kirjastoon!");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	} 
	 
 }}
// Kirjan poistaminen tietokannasta ja taulukosta
public static void poistaKirja() {
	
	Connection conn = null;
	Statement stmt =null;
	
	int row = Tietokantasovellus.taulukko.getSelectedRow();
	String solu = Tietokantasovellus.taulukko.getModel().getValueAt(row,0).toString();
	String sqlPoisto = "DELETE FROM Kirjasto WHERE KirjanNimi='" + solu+"'";

	 try {
			Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
		
			PreparedStatement preparedStmt = con.prepareStatement(sqlPoisto);
			JOptionPane.showMessageDialog(null, "Sinne meni! Toivottavasti oli tarkoitus..");
			
			preparedStmt.execute();
			tyhjennys();
			lataappa();
			
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} 
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} 
	
}

//Kaikkien kirjojen haku tietokannasta ArrayList taulukkoon
 public static ArrayList<Kirja>teokset(){
	 ArrayList<Kirja> teokset = new ArrayList<>();
	 

		try {
			Connection con = DriverManager.getConnection(URL, USERID, PASSWORD);
			//System.out.print("Yhteys tietokantaan luotu!");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(dbKaikki);
			
			Kirja uusiKirja;
			while(rs.next()) {
				uusiKirja=new Kirja(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				teokset.add(uusiKirja);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Virhe tietokannan käytössä");
			e.printStackTrace();
		}
	 return teokset;
 }

 //Kirjojen listaaminen JTable -taulukkoon
 public static void lataappa() {
	 ArrayList<Kirja> list = teokset();
	 DefaultTableModel model = (DefaultTableModel)Tietokantasovellus.taulukko.getModel();
	 
	 Object[] row = new Object[100];
	 for(int i=0;i<list.size();i++) {
		 row[0]=list.get(i).getKirjanNimi();
		 row[1]=list.get(i).getTekija();
		 row[2]=list.get(i).getJulkaisuvuosi();
		 row[3]=list.get(i).getIsbn();
		 model.addRow(row);
		 //System.out.println(row);
		 
 }
 }
}
