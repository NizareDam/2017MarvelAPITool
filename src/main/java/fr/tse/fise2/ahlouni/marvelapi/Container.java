package fr.tse.fise2.ahlouni.marvelapi;

import java.util.List;


/**
 * @author 2017PInfo84-AhLouNi
 *
 * @param <T>
 */
public class Container<T> {
	
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<T> results;
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}


}
