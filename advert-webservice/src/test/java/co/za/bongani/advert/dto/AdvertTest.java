package co.za.bongani.advert.dto;

import co.za.bongani.advert.AdvertServiceTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AdvertTest extends TestCase {
	public AdvertTest () {
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
