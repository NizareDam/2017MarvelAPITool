package fr.tse.fise2.ahlouni.marvelapi.parameter;

import java.util.Date;

import org.apache.commons.lang3.Range;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class ComicParametersBuilder {
	
    private  ComicParameters comicParameters = new ComicParameters();
   
    public ComicParametersBuilder() {
        this.comicParameters = new ComicParameters();
    }
    public ComicParametersBuilder(int id) {
        comicParameters.setId(id);
    }	
   

    public ComicParametersBuilder withFormat(Format format) {
        comicParameters.setFormat(format);
        return this;
    }

    public ComicParametersBuilder withFormatType(FormatType formatType) {
        comicParameters.setFormatType(formatType);
        return this;
    }
    public ComicParametersBuilder nameStartsWith(String startsWith) {
    	comicParameters.setNameStartsWith(startsWith);
        return this;
    }
    public ComicParametersBuilder withNoVariants(Boolean noVariants) {
        comicParameters.setNoVariants(noVariants);
        return this;
    }

    public ComicParametersBuilder withDateDescriptor(DateDescriptor dateDescriptor) {
        comicParameters.setDateDescriptor(dateDescriptor);
        return this;
    }

    public ComicParametersBuilder withDateRange(Range<Date> dateRange) {
        comicParameters.setDateRange(dateRange);
        return this;
    }

    public ComicParametersBuilder withHasDigitalIssue(Boolean hasDigitalIssue) {
        comicParameters.setHasDigitalIssue(hasDigitalIssue);
        return this;
    }

    public ComicParametersBuilder withModifiedSince(Date modifiedSince) {
        comicParameters.setModifiedSince(modifiedSince);
        return this;
    }

    public ComicParametersBuilder addCreator(Integer creatorId) {
        comicParameters.addCreator(creatorId);
        return this;
    }

    public ComicParametersBuilder addSeries(Integer seriesId) {
        comicParameters.addSeries(seriesId);
        return this;
    }

    public ComicParametersBuilder addEvent(Integer eventId) {
        comicParameters.addEvent(eventId);
        return this;
    }
    public ComicParametersBuilder addStory(Integer storyId) {
        comicParameters.addStory(storyId);
        return this;
    }

    // TODO better name required!
    public ComicParametersBuilder addSharedAppearances(Integer characterId) {
        comicParameters.addSharedAppearances(characterId);
        return this;
    }

    public ComicParametersBuilder addCollaborators(Integer creatorId) {
        comicParameters.addCollaborators(creatorId);
        return this;
    }

   

    @Override
	public String toString() {
		return "ComicParametersBuilder [comicParameters=" + comicParameters + ", create()=" + create() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public ComicParametersBuilder withLimit(Integer limit) {
        comicParameters.setLimit(limit);
        return this;
    }

    public ComicParametersBuilder withOffset(Integer offset) {
        comicParameters.setOffset(offset);
        return this;
    }

    public ComicParameters create() {
        return comicParameters;
    }
}
