package PL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DEI-ESINF
 */
public class TREE_WORDS extends BST<TextWord> {

    public void createTree() throws FileNotFoundException {
        try (Scanner readfile = new Scanner(new File("paises.txt"))) {
            while (readfile.hasNextLine()) {
                String[] pal = readfile.nextLine().split("(\\,)|(\\s)|(\\.)");
                for (String word : pal) {
                    if (word.length() > 0) {
                        insert(new TextWord(word, 1));
                    }
                }
            }
        }
    }

    /**
     * Inserts a new word in the tree, or increments the number of its
     * occurrences.
     *
     * @param element
     */
    @Override
    public void insert(TextWord element) {
        root = insert(element, root);
    }

    private Node<TextWord> insert(TextWord element, Node<TextWord> node) {
        Node<TextWord> test = find(element, node);
        if (test == null) {
            super.insert(element);
        } else {
            test.getElement().incOcorrences();
        }
        return test;
    }

    /**
     * Returns a map with a list of words for each occurrence found.
     *
     * @return a map with a list of words for each occurrence found.
     */
    public Map<Integer, List<String>> getWordsOccurrences() {
        Map<Integer, List<String>> occurs = new HashMap<>();
        Iterable<TextWord> todosOsNos = preOrder();
        Iterator<TextWord> it = todosOsNos.iterator();
        while (it.hasNext()) {
            TextWord palavra = it.next();
            int nOccurs = palavra.getOcorrences();
            if (occurs.containsKey(nOccurs)) {
                occurs.get(nOccurs).add(palavra.getWord());
            } else {
                List<String> novaLista = new ArrayList<>();
                novaLista.add(palavra.getWord());
                occurs.put(nOccurs, novaLista);
            }
        }
        return occurs;
    }

}
