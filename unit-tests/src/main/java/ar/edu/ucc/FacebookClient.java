package ar.edu.ucc;

public class FacebookClient {
	private int value;
	
	FacebookClient(int value) {
		this.value = value;
	}
	
    public void createPost(IFacebook fb) {
    	String message = "";
    	
    	if (value > 10) {
    		message = fb.connect();
    	}

        System.out.println(message);
        
        // Otro c�digo con la conexi�n ya hecha
    }
}
