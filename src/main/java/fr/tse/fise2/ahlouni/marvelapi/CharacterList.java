package fr.tse.fise2.ahlouni.marvelapi;


import java.util.List;

/**
 * @author 2017PInfo84-AhLouNi
 *
 */
public class CharacterList extends AbstractList {
    private List<CharacterSummary> items;

	public List<CharacterSummary> getItems() {
		return items;
	}

	public void setItems(List<CharacterSummary> items) {
		this.items = items;
	}


}
