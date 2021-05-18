package test;

import model.Tree;
import model.Node;
import model.Person;

public class TestNTree<T> {
	
	public static void main(String[] args) {
		Node<Person> node = new Node<Person>(new Person("Jorge"));
		Tree<Person> arbol = new Tree<>(new Node<Person>(
				node
		));
		
	/*	arbol.getRaiz().agregarHijo(new Node<Person>(new Person("checho")));
		

		Node<Person> nodeB = arbol.searchNodeForData("checho");
		
		nodeB.agregarHijo(new Node<Person>(new Person("Pepe1")));
		nodeB.agregarHijo(new Node<Person>(new Person("Pepe2")));
		nodeB.agregarHijo(new Node<Person>(new Person("Pepe3")));
		nodeB.agregarHijo(new Node<Person>(new Person("Pepe4")));
		
		int num = arbol.getNumeroDescendientes(nodeB);
		
		System.out.println("Numero de desendientes: " + num);

	 */
	}

}
