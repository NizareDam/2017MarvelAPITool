package fr.tse.fise2.ahlouni.marvelapi;

import java.util.List;

import fr.tse.fise2.ahlouni.marvelapi.CreatorSummary;


/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class CreatorList extends AbstractList {
	
    private List<CreatorSummary> items;
    
  public CreatorList() {
	   }
     
    
	public List<CreatorSummary> getItems() {
		return items;
	}

	public void setItems(List<CreatorSummary> items) {
		this.items = items;
	}


}
