package nl.linnaeus.app.model;

import java.util.ArrayList;
import java.util.HashMap;

public class AnalyzedImage {
	
	//Fields
	private String source;
	private HashMap<String, Object> metadata;
	private String requestId;
	private ArrayList<HashMap<String, Object>> categories;
	private ArrayList<HashMap<String, Object>> tags;
	
	private String[] returnableAnimals = {"dog","cat"};
	
	//Print AnalyzedImage info
	public void printInfo() {
		System.out.println("\n");
		System.out.println("[ AnalyzedImage INFO: ]");
		System.out.println("Source: \t\t" + getSource());
		System.out.println("Metadata: \t" + getMetadata());
		System.out.println("RequestId: \t" + getRequestId());
		System.out.println("Categories: \t" + getCategories());
		System.out.println("Tags: \t\t" + getTags());
		System.out.println("\n");
	}
	
	//Getters en setters
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Object getMetadata() {
		return metadata;
	}
	public void setMetadata(HashMap<String, Object> metadata) {
		this.metadata = metadata;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public ArrayList<HashMap<String, Object>> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<HashMap<String, Object>> categories) {
		this.categories = categories;
	}
	public ArrayList<HashMap<String, Object>> getTags() {
		return tags;
	}
	public void setTags(ArrayList<HashMap<String, Object>> tags) {
		this.tags = tags;
	}

	public String determineTag() {
		
		boolean isDeterminated = false;
		String determinatedTag = "Da's geen dier, da's wat 't is, geen dier.";
		
		//Eerst kijken of categorie = animal_...
		for (HashMap<String, Object> categorie : categories) {
			Object[] catArr = categorie.values().toArray();
			//System.out.println(catArr[1].toString());
			if (catArr[1].toString().startsWith("animal")) {
				//System.out.println(catArr[1].toString().substring(catArr[1].toString().indexOf("_")+1, catArr[1].toString().length()));
				//System.out.println("");
				determinatedTag = catArr[1].toString().substring(catArr[1].toString().indexOf("_")+1, catArr[1].toString().length());
				isDeterminated = true;
			}
		}
		
		//Als geen Categorie = animal, dan kijken of er Hint = animal staat
		if (!isDeterminated) {
			for (HashMap<String, Object> tag : tags) {
				Object[] tagArr = tag.values().toArray();
				if (tagArr.length == 3 && tagArr[1].equals("animal")) {
					if (!tagArr[2].equals("mammal")) {
						//System.out.println("Hint aanwezig: " + tagArr[1] + ". Tag is: " + tagArr[2]);
						determinatedTag = tagArr[2].toString();
						isDeterminated = true;
					} else {
						//System.out.println("Hint aanwezig: animal. Tag is: mammal");
					}
				} else if (tagArr.length == 2) {
					//System.out.println(tagArr[1]);
				}
			}
		}
		
		return determinatedTag;
	}
}


