
package Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Nuno Capela
 */
public class Files {

    public static boolean lerPais(Map<Pais, Set<Pais>> m) throws FileNotFoundException, IOException {
        Pais p = null;
        Set<Pais> sp;

        Scanner ler = new Scanner(new File("paises.txt"));

        /*Ler o ficheiro até este chegar ao fim */
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            //Verifica se linha está em branco
            if ((linha.trim()).length() > 0) {
                String[] temp = linha.split(",");
                p = new Pais(temp[0].trim(), temp[1].trim(), Double.parseDouble(temp[2].trim()),
                        temp[3].trim(), Double.parseDouble(temp[4].trim()), Double.parseDouble(temp[5].trim()));
                sp = new TreeSet<>();
                m.put(p, sp);
            }
        }
        if (m.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean lerFronteira(Map<Pais, Set<Pais>> m) throws FileNotFoundException {
        Scanner ler = new Scanner(new File("fronteiras.txt"));
        Pais p;
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            //Verifica se linha está em branco
            if ((linha.trim()).length() > 0) {
                String[] temp = linha.split(",");
                p = procurarPais(m, temp[0].trim());
                Set<Pais> fronteira = m.get(p);
                p = procurarPais(m, temp[1].trim());
                fronteira.add(p);
                p = procurarPais(m, temp[1].trim());
                fronteira = m.get(p);
                p = procurarPais(m, temp[0].trim());
                fronteira.add(p);
            }
        }
        if (m.isEmpty()) {
            return false;
        }
        return true;
    }

    public static Pais procurarPais(Map<Pais, Set<Pais>> m, String nomePais) {
        Iterator<Pais> itr = m.keySet().iterator();
        while (itr.hasNext()) {
            Pais p = itr.next();
            if (p.getNome().equals(nomePais)) {
                return p;
            }
        }
        return null;
    }

}
