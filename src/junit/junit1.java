package junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class junit1 {

	@Test
	public void test() {
		jex1 x = new jex1();
		assertEquals("O I", x.concat("O ", "I"));
		
	}

}
