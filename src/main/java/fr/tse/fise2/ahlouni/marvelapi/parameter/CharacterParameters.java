/**
 * 
 */
package fr.tse.fise2.ahlouni.marvelapi.parameter;

import gumi.builders.*;;
/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class CharacterParameters extends AbstractParameters {
    private String name;
   // private List<CharacterOrderBy> orderBy = new ArrayList<CharacterOrderBy>();
    private String startsWith;
    
    @Override
    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = super.addParameters(urlBuilder);
        urlBuilder = addParameterToUrl("name", name, urlBuilder);
      //  urlBuilder = addParameterToUrl("orderBy", orderBy, urlBuilder);
        urlBuilder = addParameterToUrl("nameStartsWith", startsWith, urlBuilder);
        return urlBuilder;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CharacterParameters [name=" + name + ", startsWith=" + startsWith + ", getStartsWith()="
				+ getStartsWith() + ", getName()=" + getName() + ", toString()=" + super.toString() + "]";
	}

	void setName(String name) {
        this.name = name;
    }

//    void addOrderBy(CharacterOrderBy orderBy) {
//        this.orderBy.add(orderBy);
//    }

    /**
	 * @return the startsWith
	 */
	public String getStartsWith() {
		return startsWith;
	}

	/**
	 * @param startsWith the startsWith to set
	 */
	public void setStartsWith(String startsWith) {
		this.startsWith = startsWith;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public void setNameStartsWith(String startsWith) {
        this.startsWith = startsWith;
    }
}