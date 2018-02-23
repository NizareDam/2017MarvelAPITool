package fr.tse.fise2.ahlouni.marvelapi;

import java.util.List;

 /**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class Creator {
	 

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String fullName;
    private String modified;
    private String resourceURI;
    private List<URL> urls;
    private Image thumbnail;
//    private SeriesList series;
    private StoryList stories;
    private ComicList comics;
//    private EventList events;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getResourceURI() {
		return resourceURI;
	}
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	public List<URL> getUrls() {
		return urls;
	}
	public void setUrls(List<URL> urls) {
		this.urls = urls;
	}
	public Image getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

   
}
