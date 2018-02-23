package fr.tse.fise2.ahlounibis;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import fr.tse.fise2.ahlouni.marvelapi.parameter.CharacterParameters;
import fr.tse.fise2.ahlouni.marvelapi.parameter.ComicParameters;

import fr.tse.fise2.ahlouni.marvelapi.CollectionURI;
import fr.tse.fise2.ahlouni.marvelapi.CollectionURIDeserializer;
import fr.tse.fise2.ahlouni.marvelapi.Comic;
import fr.tse.fise2.ahlouni.marvelapi.MarvelCharacter;
import fr.tse.fise2.ahlouni.marvelapi.Result;
import fr.tse.fise2.ahlouni.marvelapi.Series;

import java.io.IOException;


import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;



/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class ResultUrl {

    public final BuildUrl urlFactory; // Watch out Niz, don't forget to switch to private var
    private final ObjectMapper objectMapper;
    private Proxy proxy;

    /**
     * Méthode de Deserialization inspriré d'un exemple  sur le site de référence Q/R stackoverflow 
     * @param privateKey
     * @param publicKey
     */
    public ResultUrl(String privateKey, String publicKey) {
        this.urlFactory = new BuildUrl(privateKey, publicKey);
        this.objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CollectionURIDeserializerModule",
                new Version(1, 0, 0, null, null, null));
        module.addDeserializer(CollectionURI.class, new CollectionURIDeserializer());
        objectMapper.registerModule(module);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    /**
     * Constructeur de la classe ResultURL
     * @param privateKey
     * @param publicKey
     * @param proxy
     */
    public ResultUrl(String privateKey, String publicKey, Proxy proxy) {
        this(privateKey, publicKey);
        this.proxy = proxy;
    }
    
    /**
     * Retourne la liste de personnages filtrés par l'identifiant d'un personnage
     *
     * @param characterId
     * @return
     * @throws IOException
     */
    public Result<MarvelCharacter> getCharacter(int characterId) throws IOException {
        final String result = getURL(urlFactory.getCharacterURL(characterId));
        
        return convertToResult(MarvelCharacter.class, result);
    }
    
    /**
     * Retourne la liste de personnages filtrés par le nom du personnage
     *
     * @param characterId
     * @return
     * @throws IOException
     */
    public Result<MarvelCharacter> getCharacter(CharacterParameters caracterParameter) throws IOException {
        final String result = getURL(urlFactory.getCharactersByNameURL(caracterParameter));
        
        return convertToResult(MarvelCharacter.class, result);
    }

   
    /**
     * Retourne la liste de comics
     * @param comicParameters 
     *
     * @return
     * @throws IOException
     */
    public Result<Comic> getComics() throws IOException {
        final String result = getURL(urlFactory.getComicsURL());
        return convertToResult(Comic.class, result);
    }
    /**
     * Retourne un seul Comic selon un identifiant d'un comic
     *
     * @param comicId
     * @return
     * @throws IOException
     */
    public Result<Comic> getComics(int comicId) throws IOException {
        final String result = getURL(urlFactory.getComicsURL(comicId));
        return convertToResult(Comic.class, result);
    }
    public Result<Series> getSerie(int serieId) throws IOException {
        final String result = getURL(urlFactory.getSeriesURL(serieId));
        return convertToResult(Series.class, result);
    }
    
    /**
     * Retourne un seul comic par paramètre
     *
     * @param comicId
     * @return
     * @throws IOException
     */
    public Result<Comic> getComics(ComicParameters comicParameters) throws IOException {
        final String result = getURL(urlFactory.getComicsURL(comicParameters));
        return convertToResult(Comic.class, result);
    }

    /**
     * Affiche les listes des personnages d'un comic selon un paramètre de comic mis en paramètre 
     *
     * @param comicParameters
     * @return
     * @throws IOException
     */
    public Result<Comic> getCharactersComics(ComicParameters comicParameters) throws IOException {
        final String result = getURL(urlFactory.getCharactersComicsURL(comicParameters));
        return convertToResult(Comic.class, result);
    }
 
    /**
     * Permet de convertir l'objectMapper en résultat stocké dans une type défini Result<T> 
     * @param nameOfClass
     * @param result
     * @return
     * @throws IOException
     *
     */
    private <T> Result<T> convertToResult(Class nameOfClass, String result) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Result.class, nameOfClass);
        final Result<T> mappedResult = objectMapper.readValue(result, javaType);
        mappedResult.setRawResponse(result);
        return mappedResult;
    }

    /**
     * Retourne l'URL de la réponse HTTP
     * @param url
     * @return
     * @throws IOException
     *
     */
    private String getURL(String url) throws IOException {
        final HttpResponse httpResponse = getResponse(url);
        if (httpResponse.getStatusLine().getStatusCode() != 200) {
            throw new ResultException(httpResponse);
        }
        return EntityUtils.toString(httpResponse.getEntity());
    }
  
    
    /**
     * Retourne la reponse de la requête HTTP
     * @param url
     * @return 
     * @throws IOException
     *
     */
    private HttpResponse getResponse(String url) throws IOException {
        if (proxy == null) {
            return Request.Get(url).execute().returnResponse();
        } else {
            return Request.Get(url).viaProxy(new HttpHost(proxy.getHost(), proxy.getPort())).execute().returnResponse();
        }
    }
}
