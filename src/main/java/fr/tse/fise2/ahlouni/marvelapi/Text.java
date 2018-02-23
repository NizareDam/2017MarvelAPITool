package fr.tse.fise2.ahlouni.marvelapi;

import java.util.List;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class Text {
	
    private String type;
    private String language;
    private String text;

		private int id;
	    private int digitalId;
	    private String title;
	    private double issueNumber;
	    private String variantDescription;
	    private String description;
	    private String modified;
	    private String isbn;
	    private String upc;
	    private String diamondCode;
	    private String ean;
	    private String issn;
	    private String format;
	    private int pageCount;
	    private List<Text> textObjects;
	    private String resourceURI;
	     public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getDigitalId() {
			return digitalId;
		}
		public void setDigitalId(int digitalId) {
			this.digitalId = digitalId;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public double getIssueNumber() {
			return issueNumber;
		}
		public void setIssueNumber(double issueNumber) {
			this.issueNumber = issueNumber;
		}
		public String getVariantDescription() {
			return variantDescription;
		}
		public void setVariantDescription(String variantDescription) {
			this.variantDescription = variantDescription;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getModified() {
			return modified;
		}
		public void setModified(String modified) {
			this.modified = modified;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public String getUpc() {
			return upc;
		}
		public void setUpc(String upc) {
			this.upc = upc;
		}
		public String getDiamondCode() {
			return diamondCode;
		}
		public void setDiamondCode(String diamondCode) {
			this.diamondCode = diamondCode;
		}
		public String getEan() {
			return ean;
		}
		public void setEan(String ean) {
			this.ean = ean;
		}
		public String getIssn() {
			return issn;
		}
		public void setIssn(String issn) {
			this.issn = issn;
		}
		public String getFormat() {
			return format;
		}
		public void setFormat(String format) {
			this.format = format;
		}
		public int getPageCount() {
			return pageCount;
		}
		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}
		public List<Text> getTextObjects() {
			return textObjects;
		}
		public void setTextObjects(List<Text> textObjects) {
			this.textObjects = textObjects;
		}
		public String getResourceURI() {
			return resourceURI;
		}
		public void setResourceURI(String resourceURI) {
			this.resourceURI = resourceURI;
		}
		public List<URL> getUrls() {
			return urls;
		}
		public void setUrls(List<URL> urls) {
			this.urls = urls;
		}
		public List<ComicPrice> getPrices() {
			return prices;
		}
		public void setPrices(List<ComicPrice> prices) {
			this.prices = prices;
		}
		public Image getThumbnail() {
			return thumbnail;
		}
		public void setThumbnail(Image thumbnail) {
			this.thumbnail = thumbnail;
		}
		public List<Image> getImages() {
			return images;
		}
		public void setImages(List<Image> images) {
			this.images = images;
		}
		public CreatorList getCreators() {
			return creators;
		}
		public void setCreators(CreatorList creators) {
			this.creators = creators;
		}
		public CharacterList getCharacters() {
			return characters;
		}
		public void setCharacters(CharacterList characters) {
			this.characters = characters;
		}
		private List<URL> urls;
	     // les champs en commentaires ne seront pas utilisés dans un premier temps  il faut les implémenter 
//	    private SeriesSummary series;
//	    private List<ComicSummary> collections;
//	    private List<ComicSummary> variants;
//	    private List<ComicSummary> collectedIssues;
//	    private List<ComicDate> dates;
	    private List<ComicPrice> prices;
	    private Image thumbnail;
	    private List<Image> images;
	    private CreatorList creators;
	    private CharacterList characters;
//	    private StoryList stories;
//	    private EventList events;
	
	   
	
	 
}
