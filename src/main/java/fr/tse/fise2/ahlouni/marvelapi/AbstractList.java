package fr.tse.fise2.ahlouni.marvelapi;

public abstract class AbstractList {
    protected int available;
    /**
     * Classe abstraite l'implémentation n'est pas complète et qui n'est pas instanciable. Elle sert de base à d'autres classes dérivées 
     */
    
    protected int returned;
    protected String collectionURI;

    /**
     * @return available
     *
     */
    public int getAvailable() {
        return available;
    }

    /**
     * @param available
     *
     */
    public void setAvailable(int available) {
        this.available = available;
    }

    /**
     * @return
     *
     */
    public int getReturned() {
        return returned;
    }

    /**
     * @param returned
     *
     */
    public void setReturned(int returned) {
        this.returned = returned;
    }

    /**
     * @return
     *
     */
    public String getCollectionURI() {
        return collectionURI;
    }

    /**
     * @param collectionURI
     *
     */
    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }
}
