package dinamicStructures;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import classes.Persona;

public class Cola<T> implements Serializable {

	private int size;
	private Nodo<T> head;
	private Nodo<T> tail;

	public Cola() {
		size = 0;
		head = null;
		tail = null;
	}

	public T get() {
		if (head == null)
			return null;
		else if (head == tail) {
			T info = head.getInfo();
			head = null;
			tail = null;
			size--;
			return info;
		} else {
			T info = head.getInfo();
			head = head.getNext();
			size--;
			return info;
		}
	}

	public void add(T info) {

		Nodo<T> n = new Nodo<T>(info);

		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.setNext(n);
			tail = n;
		}

		size++;
	}

	public String toString() {
		Nodo<T> aux = head;
		String salida = "";

		while (aux != null) {
			salida += aux.getInfo().toString();
			aux = aux.getNext();
		}

		return salida;
	}

	public void save(String file) {

		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

			out.writeObject(this);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void load(String file) {
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {

			Cola<T> c = (Cola<T>) in.readObject();
			this.size = c.size;
			this.head = c.head;
			this.tail = c.tail;

		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void guardar(String file) {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {

			out.writeObject(size);
			out.writeObject(head);
			out.writeObject(tail);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void cargar(String file) {
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {

			try {
				size = (int) in.readObject();
				head = (Nodo<T>) in.readObject();
				tail = (Nodo<T>) in.readObject();

			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
