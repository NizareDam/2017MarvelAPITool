package fr.tse.fise2.ahlouni.marvelapi.parameter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gumi.builders.UrlBuilder;
import org.apache.commons.lang3.Range;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class ComicParameters extends AbstractParameters {
	
	private String startsWith;
    private Integer id;
    private Format format;
    private FormatType formatType;
    private Boolean noVariants;
    private DateDescriptor dateDescriptor;
    private Range<Date> dateRange;
    private Boolean hasDigitalIssue;
    private List<Integer> events = new ArrayList<Integer>();
    private List<Integer> sharedAppearances = new ArrayList<Integer>();
    private List<Integer> collaborators = new ArrayList<Integer>();
    //private List<ComicOrderBy> orderBy = new ArrayList<ComicOrderBy>();

    public ComicParameters() {
    }

    @Override
    public UrlBuilder addParameters(UrlBuilder urlBuilder) {
        urlBuilder = super.addParameters(urlBuilder);
        urlBuilder = addParameterToUrl("titleStartsWith", startsWith, urlBuilder);
        urlBuilder = addParameterToUrl("format", format, urlBuilder);
        urlBuilder = addParameterToUrl("formatType", formatType, urlBuilder);
        urlBuilder = addParameterToUrl("noVariants", noVariants, urlBuilder);
        urlBuilder = addParameterToUrl("dateDescriptor", dateDescriptor, urlBuilder);

        if (dateRange != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String low = simpleDateFormat.format(dateRange.getMinimum());
            String high = simpleDateFormat.format(dateRange.getMaximum());
            urlBuilder = addParameterToUrl("dateRange", String.format("%s,%s", low, high), urlBuilder);
        }

        urlBuilder = addParameterToUrl("hasDigitalIssue", hasDigitalIssue, urlBuilder);
        urlBuilder = addParameterToUrl("modifiedSince", modifiedSince, urlBuilder);
        urlBuilder = addParameterToUrl("events", events, urlBuilder);
        urlBuilder = addParameterToUrl("sharedAppearances", sharedAppearances, urlBuilder);
        urlBuilder = addParameterToUrl("collaborators", collaborators, urlBuilder);
        //urlBuilder = addParameterToUrl("orderBy", orderBy, urlBuilder);
        urlBuilder = addParameterToUrl("limit", limit, urlBuilder);
        urlBuilder = addParameterToUrl("offset", offset, urlBuilder);
        urlBuilder = addParameterToUrl("digitalId", id, urlBuilder);

        return urlBuilder;
    }

    public String getStartsWith() {
		return startsWith;
	}

	public void setStartsWith(String startsWith) {
		this.startsWith = startsWith;
	}

	public List<Integer> getEvents() {
		return events;
	}

	public void setEvents(List<Integer> events) {
		this.events = events;
	}

	public List<Integer> getSharedAppearances() {
		return sharedAppearances;
	}

	public void setSharedAppearances(List<Integer> sharedAppearances) {
		this.sharedAppearances = sharedAppearances;
	}

	public List<Integer> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(List<Integer> collaborators) {
		this.collaborators = collaborators;
	}

	public Format getFormat() {
		return format;
	}

	public FormatType getFormatType() {
		return formatType;
	}

	public Boolean getNoVariants() {
		return noVariants;
	}

	public DateDescriptor getDateDescriptor() {
		return dateDescriptor;
	}

	public Range<Date> getDateRange() {
		return dateRange;
	}

	public Boolean getHasDigitalIssue() {
		return hasDigitalIssue;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
        return id;
    }

    void addEvent(Integer parameter) {
        events.add(parameter);
    }

    void addSharedAppearances(Integer parameter) {
        sharedAppearances.add(parameter);
    }

    void addCollaborators(Integer parameter) {
        collaborators.add(parameter);
    }

    /*void addOrderBy(ComicOrderBy orderBy) {
        this.orderBy.add(orderBy);
    }*/
    public void setNameStartsWith(String startsWith) {
        this.startsWith = startsWith;
    }

    void setFormat(Format format) {
        this.format = format;
    }

    void setFormatType(FormatType formatType) {
        this.formatType = formatType;
    }

    void setNoVariants(Boolean noVariants) {
        this.noVariants = noVariants;
    }

    void setDateDescriptor(DateDescriptor dateDescriptor) {
        this.dateDescriptor = dateDescriptor;
    }

    void setDateRange(Range<Date> dateRange) {
        this.dateRange = dateRange;
    }

    void setHasDigitalIssue(Boolean hasDigitalIssue) {
        this.hasDigitalIssue = hasDigitalIssue;
    }

    void setId(int id) {
        this.id = id;
    }
}
