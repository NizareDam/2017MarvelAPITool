/**
 * 
 */
package fr.tse.fise2.ahlouni.graphicinterface;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */


public class Biblio {
	private int idcomics;
	private String title;
	private int note;
	private String commentaire;
	
	
	/**
	 * @return the idcomics
	 */
	public int getIdcomics() {
		return idcomics;
	}
	/**
	 * @param idcomics the idcomics to set
	 */
	public void setIdcomics(int idcomics) {
		this.idcomics = idcomics;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}
	/**
	 * @return the commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}
	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	/**
	 * @return the id_biblio
	 */
	public int getId_biblio() {
		return id_biblio;
	}
	/**
	 * @param id_biblio the id_biblio to set
	 */
	public void setId_biblio(int id_biblio) {
		this.id_biblio = id_biblio;
	}
	private int id_biblio;
}
