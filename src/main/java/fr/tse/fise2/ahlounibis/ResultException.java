package fr.tse.fise2.ahlounibis;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class ResultException extends RuntimeException {

    private final HttpResponse response;

    public ResultException(HttpResponse response) throws IOException {
        super(EntityUtils.toString(response.getEntity()));
        this.response = response;
    }
}
