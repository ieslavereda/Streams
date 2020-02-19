package dinamicStructures;

import java.io.*;

import classes.Persona;

public class Test {

	public static void main(String[] args) throws IOException {

		Cola<Persona> cola = new Cola<Persona>();

		cola.add(new Persona("Joaquin", "Alonso", "profesor", 42));
		cola.add(new Persona("Pedro", "Gutierrez", "alumno", 22));
		cola.add(new Persona("Carmen", "Perez", "profesor", 33));

		///////////////////////////// 
		
		try (ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("cola.mystructura")))) {

			out.writeObject(cola);

		}

		Cola<Persona> c = null;

		try (ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("cola.mystructura")))) {

			c = (Cola<Persona>) in.readObject();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(c);

		////////////////////////

		cola.guardar("cola.file");

		cola = new Cola<Persona>();

		System.out.println(cola);
		
		cola.cargar("cola.file");

		System.out.println(cola);

		/////////////////////////

		cola.save("cola.file2");

		cola = new Cola<Persona>();

		cola.load("cola.file2");

		System.out.println(cola);

	}

}
