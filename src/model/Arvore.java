package model;

public class Arvore<T extends Comparable<T>> {
	
	private No<T> raiz;
	
	public void chamaAdd(T e) {
		No<T> no = new No<T>(e);
		if (this.raiz == null) {
			this.raiz = no;
		} else {
			add(no, raiz);
		}
	}
	
	private void add(No<T> novo, No<T> raizNova) {
		if(novo.getElement().compareTo(raizNova.getElement()) == -1) {
			if (raizNova.getMenor() == null) {
				raizNova.setMenor(novo);
			} else {
				raizNova = raizNova.getMenor();
				add(novo, raizNova);
			}
		} else {
			if (raizNova.getMaior() == null) {
				raizNova.setMaior(novo);
			} else {
				raizNova = raizNova.getMaior();
				add(novo, raizNova);
			}
		}
	}
	
	public void chamaPreOrdem() {
		preOrdem(this.raiz);
	}
	
	public void chamaRemove(T e) throws Exception {
		if (this.raiz == null) {
			System.out.println("Arvore vazia.");
			// verifica se a arvore é vazia
		} else {
			// se a arvore não for vazia, receber o conteúdo e comparar com a raiz
			No<T> no = new No<T>(e);
			if (no.getElement() == this.raiz.getElement()){
				if (this.raiz.getMaior() == null && this.raiz.getMenor() == null) {
					//se for igual a raiz e não houverem filhos, só zerar
					this.raiz = null;
				} else {
					remove(no);
				}			
			} else {
				//corre nós
				boolean ruhere = verifica(no, this.raiz);
				if (ruhere == true) {
					no = encontraNode(no, this.raiz);
					remove(no);
				} else if (ruhere == false) {
					System.out.println("Elemento não está na lista.");
				}
			}
		}
	}
	
	private No<T> encontraNode(No<T> novo, No<T> raizNova) {
		if(novo.getElement().compareTo(raizNova.getElement()) == -1) {
			if (raizNova.getMenor() == null) {
				return null;
			} else {
				if (novo.getElement().compareTo(raizNova.getMenor().getElement()) == 0) {
					novo = raizNova.getMenor();
					return novo;
				} else {
					raizNova = raizNova.getMenor();
					return encontraNode(novo, raizNova);
				}
			}
		} else {
			if (raizNova.getMaior() == null) {
				return null;
			} else {
				if (novo.getElement().compareTo(raizNova.getMaior().getElement()) == 0) {
					novo = raizNova.getMaior();
					return novo;
				} else {
					raizNova = raizNova.getMaior();
					return encontraNode(novo, raizNova);
				}
			}
		}
	}
	
	private boolean verifica(No<T> novo, No<T> raizNova) throws Exception {
		if(novo.getElement().compareTo(raizNova.getElement()) == -1) {
			if (raizNova.getMenor() == null) {
				return false;
			} else {
				if (novo.getElement().compareTo(raizNova.getMenor().getElement()) == 0) {
					novo = raizNova.getMenor();
					return true;
				} else {
					raizNova = raizNova.getMenor();
					return verifica(novo, raizNova);
				}
			}
		} else {
			if (raizNova.getMaior() == null) {
				return false;
			} else {
				if (novo.getElement().compareTo(raizNova.getMaior().getElement()) == 0) {
					novo = raizNova.getMaior();
					return true;
				} else {
					raizNova = raizNova.getMaior();
					return verifica(novo, raizNova);
				}
			}
		}
	}

	private void remove(No<T> no) {
		
		No<T> substituto = substituto(no);
		No<T> paiSubstituto = paiDoNo(substituto);
		No<T> paiDoNo = paiDoNo(no);
		
		System.out.println(" no " + no.getElement().toString() + " pai: " + paiDoNo.getElement().toString());
		System.out.println(" substituto " + substituto.getElement().toString() + " pai: " + paiSubstituto.getElement().toString());
		
	}
	
	private No<T> paiDoNo(No<T> no) {
		No<T> paiDoNo = raiz;
		while (true) {
			if (no.getElement().compareTo(paiDoNo.getElement()) == -1) {
				if(no.getElement().compareTo(paiDoNo.getMenor().getElement()) == 0) {
					break;
				} else {
					paiDoNo = paiDoNo.getMenor();
				}
				
			} else {
				if(no.getElement().compareTo(paiDoNo.getMaior().getElement()) == 0) {
					break;
				} else {
					paiDoNo = paiDoNo.getMaior();
				}		
			}
		}
		return paiDoNo;
	}
	
	private No<T> substituto(No<T> no) {
		No<T> substituto = no;
		
		if (no.getMaior() != null) {
			substituto = no.getMaior();
			while (substituto.getMenor() != null) {
				substituto = substituto.getMenor();
			}
			
		} else {
			substituto = no.getMenor();
			while (substituto.getMaior() != null) {
				substituto = substituto.getMaior();
			}
		}
		return substituto;
	}

	private void preOrdem(No<T> atual) {
		//pai, menor, maior
		if (atual != null) {
			System.out.print(atual.getElement() + " ");
			preOrdem(atual.getMenor());
			preOrdem(atual.getMaior());
		}
	}
}
