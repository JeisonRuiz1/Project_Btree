package model;

import java.util.ArrayList;
import java.util.List;

public class ArbolNArio<T> {
	
	private Nodo<T> raiz;
	private int altura;
		 
	public ArbolNArio(Nodo<T> raiz) {
		this.raiz = raiz;
	}
	
	public boolean vacio() {
		return raiz == null;
	}
	
	public Nodo<T> getRaiz() {
		return raiz;
	}
	
	public void setRaiz(Nodo<T> raiz) {
		 this.raiz = raiz;
	}
	
	public boolean existe(T clave) {
		return encontrar(raiz, clave);
	}
		 
	public int getNumeroNodos() {
		return getNumeroDescendientes(raiz) + 1;	 
	}
		 
	public int getNumeroDescendientes(Nodo<T> nodo) {
		 int n = nodo.getHijos().size();
		 for (Nodo<T> hijo : nodo.getHijos()) {
			 n += getNumeroDescendientes(hijo);
		 }
		 
		 return n;
	}
		 
	private boolean encontrar(Nodo<T> nodo, T nodoClave) {
		boolean res = false;
		if (nodo.getDato().equals(nodoClave))
			return true;
		else {
			for (Nodo<T> hijo : nodo.getHijos())
				if (encontrar(hijo, nodoClave))
					res = true;
		}
		return res;
	}

	private Nodo<T> encontrarNodo(Nodo<T> nodo, T nodoClave) {
		if(nodo == null)
			return null;
		if(nodo.getDato().equals(nodoClave))
			return nodo;
		else{
			Nodo<T> cnodo = null;
			for (Nodo<T> hijo : nodo.getHijos())
				if ((cnodo = encontrarNodo(hijo, nodoClave)) != null)
					return cnodo;
		}
		
		return null;
	}
	
	public Nodo<T> searchNodeForData(String info){
		Nodo<T> cnodo = null;
		for (Nodo<T> hijo : raiz.getHijos()) {
			if ((cnodo = searchNodeForData((String) hijo.getDato())) != null) {
				return cnodo;
			}
		}
		return cnodo;
	}
	
	public ArrayList<Nodo<T>> getPreOrder() {
		ArrayList<Nodo<T>> preOrder = new ArrayList<Nodo<T>>();
		construirPreOrder(raiz, preOrder);
		return preOrder;
	}
		 
	public ArrayList<Nodo<T>> getPostOrder() {
		ArrayList<Nodo<T>> postOrder = new ArrayList<Nodo<T>>();
		construirPostOrder(raiz, postOrder);
		return postOrder;
	}
	
	private void construirPreOrder(Nodo<T> nodo, ArrayList<Nodo<T>> preOrder) {
		preOrder.add(nodo);
		for (Nodo<T> hijo : nodo.getHijos()) {
			construirPreOrder(hijo, preOrder);
		}
	}
	
	private void construirPostOrder(Nodo<T> nodo, ArrayList<Nodo<T>> postOrder) {
		for (Nodo<T> hijo : nodo.getHijos()) {
			construirPostOrder(hijo, postOrder);
		}
		
		postOrder.add(nodo);
	}

	public ArrayList<Nodo<T>> caminoMasLargo() {
		ArrayList<Nodo<T>> camino = null;
		int max = 0;
		for (ArrayList<Nodo<T>> ruta : getRamas()) {
			if (ruta.size() > max) {
				max = ruta.size();
				camino = ruta;
			}
		}
		 return camino;
	}
		 
	public int getCaminoMasLargo(){
		 return caminoMasLargo().size();
	}

	public ArrayList<ArrayList<Nodo<T>>> getRamas() {
		ArrayList<ArrayList<Nodo<T>>> rutas = new
		ArrayList<ArrayList<Nodo<T>>>();
		ArrayList<Nodo<T>> camino = new ArrayList<Nodo<T>>();
		getPath(raiz, camino, rutas);
		return rutas;
	}
	
	private void getPath(Nodo<T> nodo, ArrayList<Nodo<T>> camino,
		ArrayList<ArrayList<Nodo<T>>> rutas) {
		if (camino == null)
			return;
		camino.add(nodo);
		if (nodo.getHijos().size() == 0) {
			rutas.add(clone(camino));
		}
		 
		for (Nodo<T> hijo : nodo.getHijos()) 
			getPath(hijo, camino, rutas);
		 	int index = camino.indexOf(nodo);
		
		 	
		for (int i = index; i < camino.size(); i++) {
		 camino.remove(index);
		}
	}
	
	private ArrayList<Nodo<T>> clone(ArrayList<Nodo<T>> list) {
		ArrayList<Nodo<T>> lista = new ArrayList<Nodo<T>>();
		for (Nodo<T> nodo : list)
			lista.add(new Nodo<T>(nodo)); 
		 return lista;
	}
	
	public void recorrerNiveles() {
        // lista para guardar los valores de los nodos
        List<T> valores = new ArrayList<>();
        // agregar el valor de la raíz
        valores.add(raiz.getDato());

        // iterar desde 1 hasta altura - 1
        // altura - 1 porque si el arbol tiene altura 4 solo se 
        // necesitan 3 niveles porque la raiz ya está incluida
        for (int i = 1; i < getNumeroNodos(); i++) {
            // llamda recursiva para bajar un nivel
            recorrerNiveles(raiz, i - 1, valores);
        }
        System.out.println(valores);

    }

    private void recorrerNiveles(Nodo<T> nodo, int nivel, List<T> valores) {
       // iterar los hijos del nodo
        for (Nodo<T> n : nodo.getHijos()) {
            // si ya se llegó al nivel 0 agregar los valores a la lista
            if (nivel == 0)
                valores.add(n.getDato());
            else // seguir bajando de nivel hasta llegar al nivel cero
                recorrerNiveles(n, nivel - 1, valores);
        }
    }

}
