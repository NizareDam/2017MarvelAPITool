package fr.tse.fise2.ahlounibis;


import org.apache.commons.codec.digest.DigestUtils;

import fr.tse.fise2.ahlouni.marvelapi.parameter.ComicParameters;
import fr.tse.fise2.ahlouni.marvelapi.parameter.AbstractParameters;
import fr.tse.fise2.ahlouni.marvelapi.parameter.CharacterParameters;
import gumi.builders.UrlBuilder;
/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class BuildUrl {

    private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

    private static final String COMICS_CHARACTERS_URL = BASE_URL + "comics/%d/characters";
    private static final String COMICS_CREATORS_URL = BASE_URL + "comics/%d/creators";
    private static final String COMICS_EVENTS_URL = BASE_URL + "comics/%d/events";
    private static final String COMICS_STORIES_URL = BASE_URL + "comics/%d/stories";
    private static final String COMICS_BY_ID_URL = BASE_URL + "comics/%d";
    private static final String COMICS_BY_TITLESTART = BASE_URL + "comics?titleStartsWith=%s&limit=100";
    
    
    private static final String COMICS_URL = BASE_URL + "comics";

    private static final String CHARACTERS_BY_ID_URL = BASE_URL + "characters/%d";
    private static final String CHARACTERS_BY_NAME = BASE_URL + "characters?nameStartsWith=%s&limit=100";

    private static final String CHARACTERS_COMICS_URL =  BASE_URL + "characters/%d/comics";
    private static final String CHARACTERS_EVENT_URL = BASE_URL + "characters/%d/events";
    private static final String CHARACTERS_STORIES_URL = BASE_URL + "characters/%d/stories";
    private static final String CHARACTERS_SERIES_URL = BASE_URL + "characters/%d/series";

    private static final String EVENTS_URL = BASE_URL + "events";
    private static final String EVENTS_BY_ID_URL = BASE_URL + "events/%d";
    private static final String EVENTS_CHARACTERS_URL = BASE_URL + "events/%d/characters";
    private static final String EVENTS_COMICS_URL = BASE_URL + "events/%d/comics";
    private static final String EVENTS_STORIES_URL = BASE_URL + "events/%d/stories";
    private static final String EVENTS_CREATORS_URL = BASE_URL + "events/%d/creators";
    

    private final String publicKey;
    private final String privateKey;

    /**
     * @param privateKey
     * @param publicKey
     */
    public BuildUrl(String privateKey, String publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }



  
    public String getComicsURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(COMICS_URL);
        urlBuilder = addParameterToURL(urlBuilder);
        return urlBuilder.toString();
    }


    /**
     * @param comicId
     * @return
     *
     */
    public String getComicsURL(int comicId) {
        final String url = String.format(COMICS_BY_ID_URL, comicId);
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        urlBuilder = addParameterToURL(urlBuilder);
        return urlBuilder.toString();
    }
   
    /**
     * @param comicParameters
     * @return
     *
     */
    public String getComicsURL(ComicParameters comicParameters) {
        final String url = String.format(COMICS_BY_TITLESTART, comicParameters.getStartsWith());
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        urlBuilder = addParameterToURL(urlBuilder);
        return urlBuilder.toString();
    }
    /**
     * @param comicParameters
     * @return
     *
     */
    public String getCharactersByNameURL(CharacterParameters characterParameter) {
    	final String url = String.format(CHARACTERS_BY_NAME, characterParameter.getStartsWith());
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        urlBuilder = addParameterToURL(urlBuilder);
        return urlBuilder.toString();
    }
    
    /**
     * @param characterId
     * @return
     *
     */
    public String getCharacterURL(int characterId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(String.format(CHARACTERS_BY_ID_URL, characterId));
        return addParameterToURL(urlBuilder).toString();
    }

    /**
     * @return
     *
     */
    public String getCharactersComicsURL(ComicParameters comicParameters) {
        final String url = String.format(CHARACTERS_COMICS_URL, comicParameters.getId());
        return buildURL(url, comicParameters);
    }

    public String getEventsURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(EVENTS_URL);
        urlBuilder = addParameterToURL(urlBuilder);
        return urlBuilder.toString();
    }

    /**
     * @param eventId
     * @return
     *
     */
    public String getEventsURL(int eventId) {
        final String url = String.format(EVENTS_BY_ID_URL, eventId);
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        urlBuilder = addParameterToURL(urlBuilder);
        return urlBuilder.toString();
    }





    /**
     * @return
     *
     */
    public String getSeriesURL() {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series");
        urlBuilder = addParameterToURL(urlBuilder);
        return urlBuilder.toString();
    }

    /**
     * @param seriesId
     * @return
     *
     */
    public String getSeriesURL(int seriesId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "series/" + seriesId);
        urlBuilder = addParameterToURL(urlBuilder);
        return urlBuilder.toString();
    }


     

    /**
     * @param url
     * @param parameters
     * @return
     *
     */
    private <T extends AbstractParameters> String buildURL(String url, T parameters) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(url);
        urlBuilder = parameters.addParameters(urlBuilder);
        urlBuilder = addParameterToURL(urlBuilder);
        return urlBuilder.toString();
    }

    /**
     * @param urlBuilder
     * @return
     *
     */
    private UrlBuilder addParameterToURL(UrlBuilder urlBuilder) {
        long timeStamp = System.currentTimeMillis();
        return urlBuilder.addParameter("ts", String.valueOf(timeStamp))
                .addParameter("apikey", publicKey)
                .addParameter("hash", createHash(timeStamp));
    }

    /** Méthode qui permet de créer le HASH obligatoire dans l'URL  ( chaineToHash sera crypté en format MD5hex ) .
     * @param timeStamp
     * @return
     *
     */
    private String createHash(long timeStamp) {
        String chaineToHash = timeStamp + privateKey + publicKey;
        return DigestUtils.md5Hex(chaineToHash);
    }
    /* (non-Javadoc)
  	 * @see java.lang.Object#toString()
  	 */
  	@Override
  	public String toString() {
  		return "BuildUrl [publicKey=" + publicKey + ", privateKey=" + privateKey + ", getComicsURL()=" + getComicsURL()
  				+ ", toString()=" + super.toString() + "]";
  	}

}
