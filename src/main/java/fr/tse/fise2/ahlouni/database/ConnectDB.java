/**
 * 
 */
package fr.tse.fise2.ahlouni.database;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;



import fr.tse.fise2.ahlouni.graphicinterface.Biblio;
import fr.tse.fise2.ahlouni.graphicinterface.User;

public class ConnectDB {
	private Connection conn;
	private ResultSet rs = null;
	private ResultSet rs1 = null;
	private Statement stmt;
	private PreparedStatement pst;
	private PreparedStatement pst1;
	private String dbUrl = "jdbc:derby:db;create=true";

	public static void main(String[] args) throws SQLException {
		ConnectDB app = new ConnectDB();

	}

	public void connectionToDerby() {
		// -------------------------------------------
		// URL format is
		// jdbc:derby:<local directory to save data>
		// -------------------------------------------
		// Si on ne trouve pas la BDD, on va la crée
		// pour lancer le localhost il faut suivre lire la documentation, lancer le
		// script startNetwork.bat dispo sur l
		try {
			conn = DriverManager.getConnection(dbUrl);
			createTable();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
	public void deleteComic (int idcomics) {
		
		try {
		

			stmt = conn.createStatement();	
			
			stmt.executeUpdate("DELETE FROM comics where idcomics = "+idcomics);
	} catch (SQLException sqlExcept) {
		sqlExcept.printStackTrace();
	}
	}
	
	public void createTable() {

		try {
			
			
			ResultSet res = conn.getMetaData().getTables(null, "APP", null, null); //Default schema name is "APP"
			if(res.next())
			{
			    //do some thing;
				
				System.out.println("La table existe");
			}else{
			    JOptionPane.showMessageDialog(null, "dictionnaire" +" not exist");
			    	// Table does not exist
				
				// create table
				stmt = conn.createStatement();
				stmt.executeUpdate(
						"Create table identifiant (id int primary key, firstName varchar(100), lastName varchar(100), email varchar(100),login varchar(100), password varchar(100), id_biblio int )");
				stmt.executeUpdate(
						"Create table library (id_biblio int primary key, id_user varchar(100), id_comics_lu varchar(100),id_comics_nonlu varchar(100)      )");

				stmt.executeUpdate(
						"Create table comics(idcomics int NOT NULL PRIMARY KEY , title varchar(200), note int, commentaire varchar(100), id_biblio int    )");
				stmt.executeUpdate(
						"Create table dictionnaire(id_word  int primary key  , name_word varchar(200), frequency int , id_user int)");
				stmt.close();
			}
			
			
			
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
	
	public void insertIntoDico(String k, int id_user) {
		try {
			// insert 6 rows
			
			

			// query
			 String SQL = "SELECT * FROM dictionnaire where name_word= ? and id_user=?";

				pst = conn.prepareStatement(SQL);
				pst.setString(1,k);
				pst.setInt(2, id_user);
				rs = pst.executeQuery();
				
			
			if(rs.next()) {
				
				 String sql = "UPDATE dictionnaire SET frequency=  ? WHERE id_word = ? and id_user= ?";

					pst = conn.prepareStatement(sql);
					
					    // set the preparedstatement parameters
					
					pst.setInt(1,getFrequency(k, id_user)+1);
					pst.setInt(2,rs.getInt("id_word"));
					pst.setInt(3,id_user);
					    // call executeUpdate to execute our sql update statement
					pst.executeUpdate();
					
			}
			else {
				
				String sql = "insert into dictionnaire values ("+(getLastId_Word()+1)+",?,1,?) ";

				pst = conn.prepareStatement(sql);
				
				pst.setString(1,k);
				pst.setInt(2,id_user);
				    // call executeUpdate to execute our sql update statement
				 pst.executeUpdate();
				
			

			}
		
				stmt = conn.createStatement();

				// query
				rs = stmt.executeQuery("SELECT * FROM dictionnaire");
			// print out query result
			while (rs.next()) {
				System.out.printf("%d \t %s \t %d \t %d  \n", rs.getInt("id_word"),rs.getString("name_word"),rs.getInt("frequency"),rs.getInt("id_user"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
	public void supprimerComic (int id_comic) {
		
	}
	public void shutdown() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				DriverManager.getConnection(dbUrl + ";shutdown=true");
				conn.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}

	public void creationComptesTest() {

	}

	public void addComicsRead(int idcomics, String title, int id_user, int note, String commentaire, int id_biblio) {

		try {
			// Il faut se connecter pour pouvoir ajouter dans sa propre bilbiothèque,
			// identifiant sera celui attribué lors de la connexion
			String sql = "insert into comics values (?,?,?,?,?)";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, idcomics);
			pst.setString(2, title);
			pst.setInt(3, note);
			pst.setString(4, commentaire);
			pst.setInt(5, id_biblio);
			pst.executeUpdate();

			pst.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

	}

	public void dropTable() {
		try {
			// drop table
			stmt = conn.createStatement();
			stmt.executeUpdate("Drop Table identifiant");
			stmt.executeUpdate("Drop Table library");
			stmt.executeUpdate("Drop Table comics");
			stmt.executeUpdate("Drop Table dictionnaire");
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	public void readRows() {
		try {
			stmt = conn.createStatement();

			// query
			rs = stmt.executeQuery("SELECT * FROM identifiant");

			// print out query result
			System.out.println("ID \t first name \t last name \t email \t login \t password \t id_biblio \n");
			while (rs.next()) {
				System.out.printf("%d \t %s \t %s \t %s \t %s \\t %s %d\t \n", rs.getInt("id"),
						rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"),
						rs.getString("login"), rs.getString("password"), rs.getInt("id_biblio"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	public void insertLigne() {
		try {
			stmt = conn.createStatement();
			// insert 6 rows
			stmt.executeUpdate("insert into identifiant values (1,'Bob','jacob','bob@gmail.com','bob','123456',1)  ");
			stmt.executeUpdate(
					"insert into identifiant values (2,'Nizare','Damoumat','nizare@gmail.com','nizare','123456',2)");
			stmt.executeUpdate(
					"insert into identifiant values (3,'Sebastien','Dupond','bob@gmail.com','sebastien','123456',3)");
			stmt.executeUpdate(
					"insert into identifiant values (4,'Etienne','Capon','etienne-capon@gmail.com','etienne','123456',4)");
			stmt.executeUpdate(
					"insert into identifiant values (5,'Dylan','Leroi','dylan@gmail.com','dylan','123456',5)");
			stmt.executeUpdate(
					"insert into identifiant values (6,'Jack','Davis','jack-davis@gmail.com','jack','123456',6)");
			stmt.executeUpdate(
					"insert into dictionnaire values (1,'Spider-man',1)");
			// query
			rs = stmt.executeQuery("SELECT * FROM identifiant");

			// print out query result
			while (rs.next()) {
				System.out.printf("%d \t %s \t %s \t %s \t %s \t %s \t %d  \n", rs.getInt("id"),
						rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"),
						rs.getString("login"), rs.getString("password"), rs.getInt("id_biblio"));
			}
			
						
						
			rs.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	public boolean checkLogin(String login, String password) {

		String sql = "Select * from identifiant where login=? and password=?";

		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, login);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			} else
				return false;

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return false;

	}

	public User getInformationUsers(String login, String password) {

		String sql = "Select * from identifiant where login=? and password=?";
		User c = new User();
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, login);
			pst.setString(2, password);
			rs = pst.executeQuery();
			// print out query result
			while (rs.next()) {
				System.out.printf("%d \t %s \t %s \t %s \t %s \t %s \t %d  \n", rs.getInt("id"),
						rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"),
						rs.getString("login"), rs.getString("password"), rs.getInt("id_biblio"));

				c.setId(rs.getInt("id"));
				c.setFirstName(rs.getString("firstName"));
				c.setLastName(rs.getString("lastName"));
				c.setEmail(rs.getString("email"));
				c.setLogin(rs.getString("login"));
				c.setPassword(rs.getString("password"));
				c.setId_biblio(rs.getInt("id_biblio"));
			}

			rs.close();
			stmt.close();

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

		return c;
	}

	public Biblio GetInformationBiblio(int id_biblio) {

		String sql = "Select * from comics where id_biblio=?";
		Biblio b = new Biblio();
		try {

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_biblio);

			rs = pst.executeQuery();
			// print out query result
			while (rs.next()) {
				System.out.printf("%d  %s %d %s %d \n", rs.getInt("idcomics"), rs.getString("title"), rs.getInt("note"),
						rs.getString("commentaire"), rs.getInt("id_biblio"));

				b.setIdcomics(rs.getInt("idcomics"));
				b.setTitle(rs.getString("title"));
				b.setNote(rs.getInt("note"));
				b.setCommentaire(rs.getString("commentaire"));
				b.setId_biblio(rs.getInt("id_biblio"));

			}

			rs.close();
			stmt.close();

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

		return b;
	}

	public List<String> getListComic(int id_biblio) {

		String sql = "Select title from comics where id_biblio=?";
		 List<String> k = new ArrayList<String>();
		try {

			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_biblio);

			rs = pst.executeQuery();
			// print out query result
			while (rs.next()) {
				System.out.printf("%s \n",rs.getString("title"));

				
				k.add(rs.getString("title"));
				
			}

			rs.close();
			pst.close();

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

		return k;
	}

	// public String checkTypeAccount(String login, String password) {
	//
	// String sql = "Select typeaccount from identifiant where login=? and
	// password=?";
	//
	// try {
	//
	// pst = conn.prepareStatement(sql);
	// pst.setString(1, login);
	// pst.setString(2, password);
	// rs = pst.executeQuery();
	// pst.close();
	// } catch (SQLException sqlExcept) {
	// sqlExcept.printStackTrace();
	// }
	//
	// return rs.toString();
	// }
	
	public int getFrequency(String k,int id_user) {
		
		int freq=1 ;
		try {
				
				
				
			
			pst1 = conn.prepareStatement("SELECT * from dictionnaire where name_word= ? and id_user=?");

				// query
			pst1.setString(1, k);
			pst1.setInt(2, id_user);
			rs = pst1.executeQuery();
				
				if (rs.next()) {
					freq = rs.getInt("frequency");
					System.out.printf("%d ",rs.getInt("frequency"));
				}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return freq;
	}
	public int getLastId_Word() {

		int num = 0;

		try {

		
			stmt = conn.createStatement();

			// query
			rs = stmt.executeQuery("SELECT MAX(id_word)  AS maxnum  FROM dictionnaire");
			System.out.println();
			if (rs.next()) {
				num = rs.getInt("maxnum");

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public int getLastIdIdentifiant() {

		int num = 0;

		try {

			stmt = conn.createStatement();

			// query
			rs = stmt.executeQuery("SELECT MAX(id)  AS maxnum  FROM identifiant");
			System.out.println();
			if (rs.next()) {
				num = rs.getInt("maxnum");

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public int getLastIdBib() {

		int id_bib = 0;

		try {

			stmt = conn.createStatement();

			// query
			rs = stmt.executeQuery("SELECT MAX(id_biblio)  AS maxnum  FROM identifiant");
			System.out.println();
			if (rs.next()) {
				id_bib = rs.getInt("maxnum");

			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id_bib;
	}
	public void register(int ID, String firstName, String lastName, String email, String identifiant, String password,int id_biblio) {

		try {
			String sql = "insert into identifiant values (?,?,?,?,?,?,?)";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ID);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, email);
			pst.setString(5, identifiant);
			pst.setString(6, password);
			pst.setInt(7, id_biblio);

			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "Enregistrement terminé !");

			pst.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	public boolean checkComicRead(int id_comicSelectione, Biblio b) {

		String sql = "Select * from comics where idcomics=? and id_biblio=?";

		try {
			System.out.println("On teste si on a lu le comic");
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_comicSelectione);
			pst.setInt(2, b.getId_biblio());

			rs = pst.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Comic déjà lu");

				return true;
			} else
				return false;

		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return false;

	}
	public int getIdComic(String title) {
		
		String sql = "Select idcomics from comics where title=?";
		int id_comic=0;
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, title);

			rs = pst.executeQuery();
			// print out query result
			while (rs.next()) {
				System.out.printf("%d \n",rs.getInt("idcomics"));	
				id_comic=rs.getInt("idcomics");
			}

			rs.close();
			pst.close();
			
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

		return id_comic;
	}
	public ArrayList<String> getNameWords(int id_user ) {
		
		
		ArrayList<String> monarray= new ArrayList<String>();
		try {
			
			stmt = conn.createStatement();

			// query
			rs = stmt.executeQuery("SELECT * from dictionnaire where id_user="+id_user);
			System.out.println();
			while (rs.next()) {
				monarray.add(rs.getString("name_word"));
				System.out.printf("%s",rs.getString("name_word"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

		return monarray;
	}
	public int getVote(String title) {
		
		String sql = "Select note from comics where title=?";
		int vote=0;
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, title);

			rs = pst.executeQuery();
			// print out query result
			while (rs.next()) {
				System.out.printf("%d \n",rs.getInt("note"));	
				vote=rs.getInt("note");
			}

			rs.close();
			pst.close();
			
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

		return vote;
	}

	public String getCommentaireComic(String title) {
		
		String sql = "Select commentaire from comics where title=?";
		String comment="";
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, title);

			rs = pst.executeQuery();
			// print out query result
			while (rs.next()) {
				System.out.printf("%s \n",rs.getString("commentaire"));	
				comment=rs.getString("commentaire");
			}

			rs.close();
			pst.close();
			
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}

		return comment;
	}
}

