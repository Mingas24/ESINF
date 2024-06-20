/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package;

import java.util.Comparator;

/**
 *
 * @author Utilizador
 */
public class Utilitarios {

    public static double calcDistance(double lat1, double lat2, double lon1,
            double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c; // convert to meters

        return distance;
    }

    public static class compararGrau implements Comparator<Pais> {

        @Override
        public int compare(Pais p1, Pais p2) {
            if (p1.getGrau() > p2.getGrau()) {
                return -1;
            }
            if (p1.getGrau() == p2.getGrau()) {
                return 0;
            }
            return 1;
        }
    }

}
