/**
 * 
 */
package fr.tse.fise2.ahlouni.marvelapi;

import java.awt.List;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class Character {
	private int id;
    private String name;
    private String description;
    //private Date modified;
    private String resourceURI;
    //private List<Url> urls;
    private Image thumbnail;
    private ComicList comics;
    //private StoryList stories;
    //private EventList events;
    //private SeriesList series;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the resourceURI
	 */
	public String getResourceURI() {
		return resourceURI;
	}
	/**
	 * @param resourceURI the resourceURI to set
	 */
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	/**
	 * @return the thumbnail
	 */
	public Image getThumbnail() {
		return thumbnail;
	}
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}
	/**
	 * @return the comics
	 */
	public ComicList getComics() {
		return comics;
	}
	/**
	 * @param comics the comics to set
	 */
	public void setComics(ComicList comics) {
		this.comics = comics;
	}


}
