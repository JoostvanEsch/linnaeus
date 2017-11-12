package nl.linnaeus.app.model;

public class ImageAnalyzer {
	
	//Fields
	/*
	private Long id;
	private String url;
	*/
	private static String dummyUrlCow1 = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Cow_female_black_white.jpg/220px-Cow_female_black_white.jpg";
	private static String dummyUrlCow2 = "http://www.qygjxz.com/data/out/52/3930490-cow-picture.jpg";
	private static String dummyUrlCow3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvBm6oREXdq0Xv7CNFQjDUuBsK2ySDZAwzPkJZAC08EzHHS_4L";
	
	private static String dummyUrlSheep1 = "https://9xw0h49o7xv2hkoym1wqjuz6-wpengine.netdna-ssl.com/wp-content/uploads/2016/10/sheep.jpg";
	private static String dummyUrlSheep2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhHcsGbKpend_qFN0QG9Bde4LSVi_o0FViQCUrkeKcNCS_eveD6w";
	private static String dummyUrlSheep3 = "http://www.oddsfarm.co.uk/wp-content/uploads/2013/04/Balwen-Sheep-NEW-e1494508828421-1024x720.jpg";
	
	private static String dummyUrlDog1 = "https://i.imgur.com/AadGQOf.jpg?1";
	private static String dummyUrlDog2 = "https://i.imgur.com/ymLdWFg.jpg";
	private static String dummyUrlDog3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUfy22FzSpAPQ8mOB8zML5jFIRIF8-gkppLW_P1zZVQ1VfnJ46QQ";
	
	private static String dummyUrlCat1 = "https://www.pets4homes.co.uk/images/articles/771/large/cat-lifespan-the-life-expectancy-of-cats-568e40723c336.jpg";
	private static String dummyUrlCat2 = "https://www.bluecross.org.uk/sites/default/files/pets/338228.jpg";
	private static String dummyUrlCat3 = "http://www.golfian.com/wp-content/uploads/2016/06/Brown-Ragdoll-Cat-Baby-Picture.jpg";
	
	private String reqUrl;
	
	
	//Constructor
	public ImageAnalyzer() {}
	public ImageAnalyzer(String reqUrl) {
		this.reqUrl = reqUrl;
	}
	
	//Process image url to return AnalyzedImage object
	public AnalyzedImage processURL() {
		return processURL(this.reqUrl);
	}
	public AnalyzedImage processURL(String url) {
		Vision v = new Vision(url);
		JSONToObjectEngine J2O = new JSONToObjectEngine();
		AnalyzedImage koko = J2O.execute(v.getJSON());
		koko.setSource(url);
		
		return koko;
	}
	
	/*
	public static void main(String[] args) throws Exception{
		ImageAnalyzer ia = new ImageAnalyzer();
		AnalyzedImage anim = ia.processURL("https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Left_side_of_Flying_Pigeon.jpg/266px-Left_side_of_Flying_Pigeon.jpg");
		anim.printInfo();
		System.out.println(anim.determineTag());
	}*/
	
}
