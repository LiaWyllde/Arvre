package controller;
import model.Arvore;

public class Teste {
	
	Arvore arvore = new Arvore();
	
	public void teste() throws Exception {
		
		arvore.chamaAdd(200);
		arvore.chamaAdd(150);
		arvore.chamaAdd(130);
		arvore.chamaAdd(180);
		arvore.chamaAdd(310);
		arvore.chamaAdd(170);
		arvore.chamaAdd(220);
		arvore.chamaAdd(210);
		arvore.chamaAdd(300);
		arvore.chamaAdd(100);
		arvore.chamaAdd(320);
		arvore.chamaAdd(350);
		
		
	
		
		arvore.chamaPreOrdem();
		
		arvore.chamaRemove(310);
	}
	
	
	
}
