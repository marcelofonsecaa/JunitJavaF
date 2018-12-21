package junit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class junit2 {

	@Test
	public void test() {
		jex2 ex2 = new jex2();
		ArrayList<String> empregados = new ArrayList<String>();
		empregados.add("Maria");
		empregados.add("Marcelo");
		
		assertEquals ("FOUND", ex2.findName(empregados,"Marcelo"));
		
	}

}
