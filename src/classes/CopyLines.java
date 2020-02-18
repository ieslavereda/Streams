package classes;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class CopyLines {
	public static void main(String[] args) throws IOException {

		BufferedReader inputStream = null;
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try {
			inputStream = new BufferedReader(new FileReader("prueba.txt"));

			Persona p;
			String l, nombre, apellidos, profesion;
			int edad;
			String[] lSplit;

			while ((l = inputStream.readLine()) != null) {

				lSplit = l.split(";");

				nombre = lSplit[0];
				apellidos = lSplit[1];
				profesion = lSplit[2];
				edad = Integer.parseInt(lSplit[3]);

				p = new Persona(nombre, apellidos, profesion, edad);

				personas.add(p);

			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}

		}

		System.out.println(personas);

		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("fileData.txt")));

		for (Persona p : personas) {
			out.writeUTF(p.getNombre());
			out.writeUTF(p.getApellidos());
			out.writeUTF(p.getProfesion());
			out.writeInt(p.getEdad());
		}

		out.close();

		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("fileData.txt")));

		try {
			while (true) {
				System.out.println(in.readUTF());
				System.out.println(in.readUTF());
				System.out.println(in.readUTF());
				System.out.println(in.readInt());
			}
		} catch (EOFException eof) {

		}

	}
}
