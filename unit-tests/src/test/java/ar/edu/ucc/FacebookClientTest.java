package ar.edu.ucc;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class FacebookClientTest {

	@Test
	public void testCreatePost() {
	    FacebookClient client = new FacebookClient(11);

	    IFacebook iFacebook = mock(IFacebook.class);

	    when(iFacebook.connect()).thenReturn("Using mockito is great");

	    client.createPost(iFacebook);
	    
	    verify(iFacebook, atLeastOnce()).connect();
	}
	
	@Test
	public void testCreatePostNoConnectExecuted() {
	    FacebookClient client = new FacebookClient(0);

	    IFacebook iFacebook = mock(IFacebook.class);

	    when(iFacebook.connect()).thenReturn("Using mockito is great");

	    client.createPost(iFacebook);
	    
	    verify(iFacebook, never()).connect();
	}
}
