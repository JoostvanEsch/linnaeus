package nl.linnaeus.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nl.linnaeus.app.model.AnalyzedImage;
import nl.linnaeus.app.model.ImageAnalyzer;
import nl.linnaeus.app.service.AppService;


@RestController
public class Endpoints {
	
	@Autowired
	AppService appService;
	
	@ResponseBody
    @PostMapping("/analyzeimagefromurl")
    public String analyzeImageFromUrl(@RequestBody String url){
		ImageAnalyzer ia = new ImageAnalyzer();
		AnalyzedImage AnIm = ia.processURL(url);
        return AnIm.determineTag();
    }
	
	@ResponseBody
    @GetMapping("/test")
    public void analyzeImageFrorl(){
		System.out.println("werkt");

    }

}
