package fr.tse.fise2.ahlouni.marvelapi;


/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class CreatorSummary {
	
    private String resourceURI;
    private String name;
    private String role;
	public String getResourceURI() {
		return resourceURI;
	}
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "CreatorSummary [resourceURI=" + resourceURI + ", name=" + name + ", role=" + role + "]";
	}


}
