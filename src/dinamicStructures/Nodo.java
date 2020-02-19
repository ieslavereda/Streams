package dinamicStructures;

import java.io.Serializable;

public class Nodo<T> implements Serializable {

	private T info;
	private Nodo<T> next;
	
	public Nodo(T info) {
		this.info=info;
		this.next=null;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	@Override
	public String toString() {
		return  info.toString() ;
	}
	
	
}
