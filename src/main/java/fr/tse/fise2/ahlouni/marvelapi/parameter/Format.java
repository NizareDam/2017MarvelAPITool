package fr.tse.fise2.ahlouni.marvelapi.parameter;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public enum Format {

    COMIC("comic"),
    MAGAZINE("magazine"),
    TRADE_PAPERBACK("trade paperback"),
    HARDCOVER("hardcover"),
    DIGEST("digest"),
    GRAPHIC_NOVEL("graphic novel"),
    DIGITAL_COMIC("digital comic"),
    INFINITE_COMIC("infinite comic");

    private final String string;

    private Format(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
