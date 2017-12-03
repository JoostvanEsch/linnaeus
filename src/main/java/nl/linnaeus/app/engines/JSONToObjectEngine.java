package nl.linnaeus.app.engines;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nl.linnaeus.app.model.AnalyzedImage;

public class JSONToObjectEngine {
	
	//Fields
	private String JSONMessage;
	private AnalyzedImage analyzedImage;

	//Constructors
	public JSONToObjectEngine() {}
	
	public JSONToObjectEngine(String JSONMessage) {
		this.JSONMessage = JSONMessage;
	}

	//Convert JSON string to AnalyzedImage object 
	public AnalyzedImage createAnalyzedImage(String JSONMessage) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Convert JSON string to Object
			String jsonInString = JSONMessage;
			AnalyzedImage AnIm = mapper.readValue(jsonInString, AnalyzedImage.class);
			this.analyzedImage = AnIm;
			return AnIm;
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return analyzedImage;
	}
	
	//Getters en setters
	public String getJSONMessage() {
		return JSONMessage;
	}
	
	public void setJSONMessage(String jSONMessage) {
		JSONMessage = jSONMessage;
	}
	
	public AnalyzedImage getAnalyzedImage() {
		return analyzedImage;
	}
	
	public void setAnalyzedImage(AnalyzedImage analyzedImage) {
		this.analyzedImage = analyzedImage;
	}

}