package fr.tse.fise2.ahlounibis;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class Proxy {
	
    private final String host;
    private final int port;

    public Proxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
