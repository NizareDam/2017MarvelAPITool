package fr.tse.fise2.ahlouni.marvelapi.parameter;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public enum DateDescriptor {

    LAST_WEEK("lastWeek"), THIS_WEEK("thisWeek"), NEXT_WEEK("nextWeek"), THIS_MONTH("thisMonth");

    private final String string;

    private DateDescriptor(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
