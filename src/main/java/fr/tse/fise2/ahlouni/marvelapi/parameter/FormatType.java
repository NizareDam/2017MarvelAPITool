package fr.tse.fise2.ahlouni.marvelapi.parameter;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public enum FormatType {

    COMIC("comic"), COLLECTION("collection");

    public String getString() {
		return string;
	}

	private final String string;

    private FormatType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
