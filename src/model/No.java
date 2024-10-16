package model;

public class No <T> {
	
	private T element;
	private No<T> maior;
	private No<T> menor;
	
	public No(T e) {
		this.maior = null;
		this.menor = null;
		this.element = e;
	}
	
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public No<T> getMaior() {
		return maior;
	}
	public void setMaior(No<T> maior) {
		this.maior = maior;
	}
	public No<T> getMenor() {
		return menor;
	}
	public void setMenor(No<T> menor) {
		this.menor = menor;
	}
	
	@Override
	public String toString() {
		return element.toString();
	}
}
