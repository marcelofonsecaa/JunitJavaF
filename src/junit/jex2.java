package junit;

import java.util.ArrayList;

public class jex2 {
	public String findName(ArrayList<String> empregados, String nome) {
		String result = "";
		if (empregados.contains(nome)) {
			result = "FOUND";
		} else {
			result = "NOT FOUND";
		}
		return result;
	}

}
