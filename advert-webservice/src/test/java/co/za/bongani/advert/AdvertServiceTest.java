package co.za.bongani.advert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AdvertServiceTest extends TestCase {
	public AdvertServiceTest () {
		super();		
	}
	
	public static Test suite()
    {
        return new TestSuite( AdvertServiceTest.class );
    }
	
	public void testApp()
    {
        assertTrue( true );
    }
}
