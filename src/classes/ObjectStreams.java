package classes;

import java.io.*;

public class ObjectStreams {

	public static void main(String[] args) {
		

		Persona p1 = new Persona("Joaquin","Alonso","profesor",42);
		Persona p2 = new Persona("Pedro","Garcia","profesor",50);
		
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("ojetos.txt")));
			){
			
			
			out.writeObject(p1);
			out.writeObject(p2);			
			
			
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Persona p3=null,p4=null;
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("ojetos.txt")))){
			
			p3 = (Persona) in.readObject();
			p4 = (Persona) in.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(p3);
		System.out.println(p4);

	}

}
