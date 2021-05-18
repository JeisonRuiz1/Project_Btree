package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Un nodo de cualquier tipo. Un nodo contiene datos y enlaces a sus hijos y su padre.
 *
 * @param <T> El tipo de clase Node
 */
public class Node<T> {
    private T data;
    private List<Node<T>> children;
    private Node<T> parent;

    public Node(T data) {
        this.data = data;
        this.children = new ArrayList<Node<T>>();
    }

    /**
     * Inicialice un nodo con los datos de otro nodo.
     * Esto no copia a los hijos del nodo.
     *
     * @param node El nodo cuyos datos se van a copiar.
     */
    public Node(Node<T> node) {
        this.data = node.getData();
        children = new ArrayList<Node<T>>();
    }

    /**
     *
     * Agregue un hijo a este nodo.
     *
     * @param child child node
     */
    public void addChild(Node<T> child) {
        child.setParent(this);
        children.add(child);
    }

    /**
     *
     * Agregue un nodo secundario en el índice dado.
     *
     * @param index El índice en el que se debe insertar el hijo
     * @param child El nodo hijo.
     */
    public void addChildAt(int index, Node<T> child) {
        child.setParent(this);
        this.children.add(index, child);
    }

    public void setChildren(List<Node<T>> children) {
        for (Node<T> child : children)
            child.setParent(this);

        this.children = children;
    }

    /**
     * Elimine todos los hijos de este nodo.
     */
    public void removeChildren() {
        this.children.clear();
    }

    /**
     *
     * Eliminar el hijo en el índice dado.
     *
     * @param index El índice en el que el hijo tiene que ser eliminado.
     * @return el indice del nodo eliminado.
     */
    public Node<T> removeChildAt(int index) {
        return children.remove(index);
    }

    /**
     * Elimina el hijo dado de este nodo.
     *
     * @param childToBeDeleted el nodo hijo para eliminar.
     * @return <code>true</code> si el nodo dado era un hijo de este nodo y se eliminó,
     * <code>false</code> de lo contrario.
     */
    public boolean removeChild(Node<T> childToBeDeleted) {
        List<Node<T>> list = getChildren();
        return list.remove(childToBeDeleted);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return this.children;
    }

    public Node<T> getChildAt(int index) {
        return children.get(index);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj)
            return false;

        if (obj instanceof Node) {
            if (((Node<?>) obj).getData().equals(this.data))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}