package junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class calculatortest {

	@Test
	public void test() {
		calculator calc = new calculator();
		assertEquals(8, calc.add(5,3));
		// int resultadoAtual = calc.add(5,3)
		// outra forma de fazer o calculo adicionamento de uma variavel
		
		
		
		
	}

}
