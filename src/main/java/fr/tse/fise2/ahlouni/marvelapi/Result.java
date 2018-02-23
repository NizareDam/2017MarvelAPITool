package fr.tse.fise2.ahlouni.marvelapi;




/**
 * @author 2017PInfo84-AhLouNi
 *
 * @param <T>
 */
public class Result<T> {
	
    private int code;
    private String status;
    private String etag;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private Container<T> data;
    private String rawResponse;
    
    
	@Override
	public String toString() {
		return "Result [code=" + code + ", status=" + status + ", etag=" + etag + ", copyright=" + copyright
				+ ", attributionText=" + attributionText + ", attributionHTML=" + attributionHTML + ", data=" + data
				+ ", rawResponse=" + rawResponse + "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEtag() {
		return etag;
	}
	public void setEtag(String etag) {
		this.etag = etag;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getAttributionText() {
		return attributionText;
	}
	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}
	public String getAttributionHTML() {
		return attributionHTML;
	}
	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}
	public Container<T> getData() {
		return data;
	}
	public void setData(Container<T> data) {
		this.data = data;
	}
	public String getRawResponse() {
		return rawResponse;
	}
	public void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}



}
