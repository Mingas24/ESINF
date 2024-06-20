package PL;

import esinf_parte_3.Pais;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nuno Capela
 * @param <E>
 */
public class KDTREE<E extends Comparable<E>> {

    //Variável usada para distinguir o x do y
    private int orientacao = 0;
    private int dimensoes = 2;

    /**
     * Nested static class for a binary search tree node.
     *
     * @param <E>
     */
    protected static class Node<E> {

        int x, y = 0;
        private E element;          // an element stored at this node
        private Node<E> left;       // a reference to the left child (if any)
        private Node<E> right;      // a reference to the right child (if any)
        double[] coordenadas = {x, y};

        public Node(E element, Node<E> left, Node<E> right, double x, double y) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.coordenadas[0] = x;
            this.coordenadas[1] = y;

        }

        // accessor methods
        public E getElement() {
            return element;
        }

        // update methods
        public void setElement(E e) {
            element = e;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

    }

    //----------- end of nested Node class -----------
    protected KDTREE.Node<E> root = null;     // root of the tree

    public KDTREE() {
        root = null;
    }

    protected KDTREE.Node<E> root() {
        return root;
    }

    public Node<E> getRoot() {
        return root;
    }

    public void insert(E element, double x, double y) {
        double[] coordenadas = {x, y};
        root = insert(element, root, coordenadas, orientacao);

    }

    private Node<E> insert(E element, Node<E> node, double[] coordenadas, int orientacao) {
        if (node == null) {
            node = new Node(element, null, null, coordenadas[0], coordenadas[1]);
        } else if (coordenadas[orientacao] < node.coordenadas[orientacao]) {
            node.left = insert(element, node.left, coordenadas, (orientacao + 1) % dimensoes);
        } else {
            node.right = insert(element, node.right, coordenadas, (orientacao + 1) % dimensoes);
        }

        return node;
    }

    public Iterable<E> inOrder() {
        List<E> inOrderList = new ArrayList<>();
        if (root != null) {
            inOrderSubtree(root, inOrderList);   // fill the snapshot recursively
        }
        return inOrderList;
    }

    /**
     * Adds elements of the subtree rooted at Node node to the given snapshot
     * using an in-order traversal
     *
     * @param node Node serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void inOrderSubtree(KDTREE.Node<E> node, List<E> inOrderList) {
        if (node == null) {
            return;
        }
        inOrderSubtree(node.getLeft(), inOrderList);
        inOrderList.add(node.getElement());
        inOrderSubtree(node.getRight(), inOrderList);
    }

    /**
     * Returns an iterable collection of elements of the tree, reported in
     * pre-order.
     *
     * @return iterable collection of the tree's elements reported in pre-order
     */
    public Iterable<E> preOrder() {
        List<E> snapshot = new ArrayList<>();
        if (root() != null) {
            preOrderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    /**
     * Adds elements of the subtree rooted at Node node to the given snapshot
     * using an pre-order traversal
     *
     * @param node Node serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void preOrderSubtree(KDTREE.Node<E> node, List<E> snapshot) {
        if (node == null) {
            return;
        }
        snapshot.add(node.getElement());
        preOrderSubtree(node.getLeft(), snapshot);
        preOrderSubtree(node.getRight(), snapshot);
    }

    /**
     * Returns an iterable collection of elements of the tree, reported in
     * post-order.
     *
     * @return iterable collection of the tree's elements reported in post-order
     */
    public Iterable<E> posOrder() {
        List<E> snapshot = new ArrayList<>();
        if (root() != null) {
            posOrderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    /**
     * Adds positions of the subtree rooted at Node node to the given snapshot
     * using an post-order traversal
     *
     * @param node Node serving as the root of a subtree
     * @param snapshot a list to which results are appended
     */
    private void posOrderSubtree(KDTREE.Node<E> node, List<E> snapshot) {
        if (node == null) {
            return;
        }
        posOrderSubtree(node.getLeft(), snapshot);
        posOrderSubtree(node.getRight(), snapshot);
        snapshot.add(node.getElement());
    }

    protected Node<E> find(Node<E> node, double[] coordenadas, int orientacao) {
        if (node == null) {
            return null;
        }

        if (coordenadas[0] == node.coordenadas[0] && coordenadas[1] == node.coordenadas[1]) {
            return node;
        }

        if (coordenadas[orientacao] < node.coordenadas[orientacao] && node.getLeft() != null) {
            return find(node.getLeft(), coordenadas, (orientacao + 1) % dimensoes);

        }

        if (coordenadas[orientacao] > node.coordenadas[orientacao] && node.getRight() != null) {
            return find(node.getRight(), coordenadas, (orientacao + 1) % dimensoes);
        }
        return null;
    }

    public E findNode(double x, double y) {
        double[] coordenadas = {x, y};

        Node<E> node = find(root, coordenadas, 0);

        if (node == null) {
            return null;
        }
        return node.getElement();
    }

    public LinkedList<E> pesquisaGeo(double lat1, double long1, double lat2, double long2) {
        double[] coordenadas = {lat1, long1, lat2, long2};
        LinkedList<E> listaObjectos = new LinkedList<>();

        pesquisaGeo(coordenadas, root, 0, listaObjectos);

        return listaObjectos;
    }

    private void pesquisaGeo(double[] coordenadas, Node<E> node, int orientacao, List<E> listaObjectos) {
        if (node == null) {
            return;
        }

        if (node.coordenadas[orientacao] < coordenadas[orientacao]) {
            pesquisaGeo(coordenadas, node.getRight(), (orientacao + 1) % dimensoes, listaObjectos);

        } else if (node.coordenadas[orientacao] > coordenadas[orientacao + 2]) {
            pesquisaGeo(coordenadas, node.getLeft(), (orientacao + 1) % dimensoes, listaObjectos);
        } else {
            if (node.coordenadas[(orientacao + 1) % dimensoes] >= coordenadas[(orientacao + 1) % dimensoes]
                    && node.coordenadas[(orientacao + 1) % dimensoes] <= coordenadas[(orientacao + 1) % dimensoes + 2]) {
                listaObjectos.add(node.getElement());
            }
            pesquisaGeo(coordenadas, node.getRight(), (orientacao + 1) % dimensoes, listaObjectos);
            pesquisaGeo(coordenadas, node.getLeft(), (orientacao + 1) % dimensoes, listaObjectos);
        }
    }

    public E getMaisProximoByLatitudeLongitudePrep(double[] latitudeLongitude) {
        double dist = Double.MAX_VALUE;
        return getMaisProximoByLatitudeLongitude(latitudeLongitude, root, root, dist, 0).getElement();
    }

    public Node<E> getMaisProximoByLatitudeLongitude(double[] latitudeLongitude, Node<E> raizAtual, Node<E> raizMinima, double distancia, int depth) {

        if (raizAtual == null) {
            return raizMinima;
        }

        double dist = calcularDistanciaAoNode(latitudeLongitude, raizAtual);
        if (dist < distancia) {
            distancia = dist;
            raizMinima = raizAtual;
        }

        int orientacao = depth % dimensoes;
        if (latitudeLongitude[orientacao] < raizAtual.coordenadas[orientacao]) {
            return getMaisProximoByLatitudeLongitude(latitudeLongitude, raizAtual.getLeft(), raizMinima, distancia, (orientacao + 1) % dimensoes);
        } else {
            return getMaisProximoByLatitudeLongitude(latitudeLongitude, raizAtual.getRight(), raizMinima, distancia, (orientacao + 1) % dimensoes);
        }
    }

    public double calcularDistanciaAoNode(double[] coordenadas, Node<E> raiz) {
        return Math.sqrt(Math.pow(raiz.coordenadas[0] - coordenadas[0], 2) + Math.pow(raiz.coordenadas[1] - coordenadas[1], 2));
    }

    public double calcularDistanciaEntreCoordenadas(double[] coordenadas1, double[] coordenadas2) {
        return Math.sqrt(Math.pow(coordenadas1[0] - coordenadas2[0], 2) + Math.pow(coordenadas2[1] - coordenadas2[1], 2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRec(root, 0, sb);
        return sb.toString();
    }

    private void toStringRec(KDTREE.Node<E> root, int level, StringBuilder sb) {
        if (root == null) {
            return;
        }
        toStringRec(root.getRight(), level + 1, sb);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                sb.append("|\t");
            }
            sb.append("|-------").append(root.getElement()).append("\n");
        } else {
            sb.append(root.getElement()).append("\n");
        }
        toStringRec(root.getLeft(), level + 1, sb);
    }

    /*
    * Returns the number of nodes in the tree.
    * @return number of nodes in the tree
     */
    public int size() {
        return size(root());
    }

    private int size(KDTREE.Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

}
