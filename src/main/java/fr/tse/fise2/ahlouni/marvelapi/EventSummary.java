/**
 * 
 */
package fr.tse.fise2.ahlouni.marvelapi;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EventSummary {
    private String resourceURI;
    private String name;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}