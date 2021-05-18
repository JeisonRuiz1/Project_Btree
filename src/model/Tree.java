package model;

import java.util.ArrayList;

/**
 * Generic n-ary tree.
 *
 * @param <T> Clase generica
 */
public class Tree<T> {

	private Node<T> root;

	/**
	 * Inicializa un árbol con el nodo raíz especificado.
	 *
	 * @param root El nodo raíz del árbol.
	 */
	public Tree(Node<T> root) {
		this.root = root;
	}

	/**
	 * Comprueba si el árbol está vacío (el nodo raíz es nulo)
	 *
	 * @return <code>true</code> si el arbol esta vacio,
	 * <code>false</code>  de lo contrario.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Obtener el nodo raíz del árbol
	 *
	 * @return el nodo raíz.
	 */
	public Node<T> getRoot() {
		return root;
	}

	/**
	 * Establezca el nodo raíz del árbol. Reemplaza el nodo raíz existente.
	 *
	 * @param root El nodo raíz con el que se reemplazará el nodo raíz existente.
	 */
	public void setRoot(Node<T> root) {
		this.root = root;
	}

	/**
	 *
	 * Compruebe si los datos dados están presentes en el árbol.
	 *
	 * @param key Los datos para buscar
	 * @return <code>true</code> si la clave dada se encontró en el árbol,
	 * <code>false</code> de lo contrario.
	 */
	public boolean exists(T key) {
		return find(root, key);
	}

	/**
	 * Obtenga la cantidad de nodos (tamaño) en el árbol.
	 *
	 * @return El número de nodos en el árbol.
	 */
	public int size() {
		return getNumberOfDescendants(root) + 1;
	}

	/**
	 *
	 * Obtiene el número de descendientes que tiene un nodo determinado.
	 *
	 * @param node El nodo cuyo número de descendientes se necesita.
	 * @return el número de descendientes
	 */
	public int getNumberOfDescendants(Node<T> node) {
		int n = node.getChildren().size();
		for (Node<T> child : node.getChildren())
			n += getNumberOfDescendants(child);

		return n;

	}

	private boolean find(Node<T> node, T keyNode) {
		boolean res = false;
		if (node.getData().equals(keyNode))
			return true;

		else {
			for (Node<T> child : node.getChildren())
				if (find(child, keyNode))
					res = true;
		}

		return res;
	}

	private Node<T> findNode(Node<T> node, T keyNode) {
		if (node == null)
			return null;
		if (node.getData().equals(keyNode))
			return node;
		else {
			Node<T> cnode = null;
			for (Node<T> child : node.getChildren())
				if ((cnode = findNode(child, keyNode)) != null)
					return cnode;
		}
		return null;
	}

	/**
	 *
	 * Obtenga la lista de nodos organizados por el recorrido del árbol por pre-orden
	 *
	 * @return La lista de nodos en el árbol, organizados en el pre-orden
	 */
	public ArrayList<Node<T>> getPreOrderTraversal() {
		ArrayList<Node<T>> preOrder = new ArrayList<Node<T>>();
		buildPreOrder(root, preOrder);
		return preOrder;
	}

	/**
	 *
	 * Obtenga la lista de nodos organizados por el recorrido post-orden del árbol.
	 *
	 * @return La lista de nodos en el árbol, organizados en el post-orden
	 */
	public ArrayList<Node<T>> getPostOrderTraversal() {
		ArrayList<Node<T>> postOrder = new ArrayList<Node<T>>();
		buildPostOrder(root, postOrder);
		return postOrder;
	}

	private void buildPreOrder(Node<T> node, ArrayList<Node<T>> preOrder) {
		preOrder.add(node);
		for (Node<T> child : node.getChildren()) {
			buildPreOrder(child, preOrder);
		}
	}

	private void buildPostOrder(Node<T> node, ArrayList<Node<T>> postOrder) {
		for (Node<T> child : node.getChildren()) {
			buildPostOrder(child, postOrder);
		}
		postOrder.add(node);
	}

	/**
	 *
	 *Obtenga la lista de nodos en la ruta más larga desde la raíz hasta cualquier hoja del árbol.
	 *
	 * Por ejemplo, para el árbol de abajo
	 * <pre>
	 *          A
	 *         / \
	 *        B   C
	 *           / \
	 *          D  E
	 *              \
	 *              F
	 * </pre>
	 *
	 * El resultado sera [A, C, E, F]
	 *
	 * @return La lista de nodos en la ruta más larga.
	 */
	public ArrayList<Node<T>> getLongestPathFromRootToAnyLeaf() {
		ArrayList<Node<T>> longestPath = null;
		int max = 0;
		for (ArrayList<Node<T>> path : getPathsFromRootToAnyLeaf()) {
			if (path.size() > max) {
				max = path.size();
				longestPath = path;
			}
		}
		return longestPath;
	}


	/**
	 *
	 * Obtenga la altura del árbol (la cantidad de nodos en el camino más largo desde la raíz hasta la hoja)
	 *
	 * @return La altura del árbol.
	 */
	public int getHeight() {
		return getLongestPathFromRootToAnyLeaf().size();
	}

	/**
	 *
	 * Get a list of all the paths (which is again a list of nodes along a path) from the root node to every leaf.
	 *
	 * @return Lista de caminos.
	 */
	public ArrayList<ArrayList<Node<T>>> getPathsFromRootToAnyLeaf() {
		ArrayList<ArrayList<Node<T>>> paths = new ArrayList<ArrayList<Node<T>>>();
		ArrayList<Node<T>> currentPath = new ArrayList<Node<T>>();
		getPath(root, currentPath, paths);

		return paths;
	}

	private void getPath(Node<T> node, ArrayList<Node<T>> currentPath,
						 ArrayList<ArrayList<Node<T>>> paths) {
		if (currentPath == null)
			return;

		currentPath.add(node);

		if (node.getChildren().size() == 0) {
			// Esta es una hoja
			paths.add(clone(currentPath));
		}
		for (Node<T> child : node.getChildren())
			getPath(child, currentPath, paths);

		int index = currentPath.indexOf(node);
		for (int i = index; i < currentPath.size(); i++)
			currentPath.remove(index);
	}

	private ArrayList<Node<T>> clone(ArrayList<Node<T>> list) {
		ArrayList<Node<T>> newList = new ArrayList<Node<T>>();
		for (Node<T> node : list)
			newList.add(new Node<T>(node));

		return newList;
	}
}