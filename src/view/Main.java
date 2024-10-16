package view;

import controller.Teste;

public class Main {

	public static void main(String[] args) {
		Teste teste = new Teste();
		try {
			teste.teste();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
