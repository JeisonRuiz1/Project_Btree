package test;

import model.ArbolNArio;
import model.Nodo;
import model.Person;

public class TestNTree<T> {
	
	public static void main(String[] args) {
		Nodo<Person> node = new Nodo<Person>(new Person("Jorge"));
		ArbolNArio<Person> arbol = new ArbolNArio<>(new Nodo<Person>(
				node
		));
		
		arbol.getRaiz().agregarHijo(new Nodo<Person>(new Person("checho")));
		
		Nodo<Person> nodoB= arbol.searchNodeForData("checho");
		
		nodoB.agregarHijo(new Nodo<Person>(new Person("Pepe1")));
		nodoB.agregarHijo(new Nodo<Person>(new Person("Pepe2")));
		nodoB.agregarHijo(new Nodo<Person>(new Person("Pepe3")));
		nodoB.agregarHijo(new Nodo<Person>(new Person("Pepe4")));
		
		int num = arbol.getNumeroDescendientes(nodoB);
		
		System.out.println("Numero de desendientes: " + num);
	}

}
