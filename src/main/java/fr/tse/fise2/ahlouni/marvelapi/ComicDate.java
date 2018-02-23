/**
 * 
 */
package fr.tse.fise2.ahlouni.marvelapi;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class ComicDate {
    private String type;
    private String date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}