import java.util.ArrayList;
import java.util.Scanner;

public class Parcial_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <String> adn = new ArrayList<>();
        int vueltas = 0;
        int op = 0;
            while (vueltas<6){
                System.out.println("Ingrese una cadena de ADN: ");
                String n = sc.nextLine();
                String cadena_adn = n.toUpperCase();
                if (chequearLargo(cadena_adn)){
                    if(revisarCaracteres(cadena_adn)){
                        adn.add(cadena_adn);
                        vueltas++;
                    }else {
                        System.out.println("Los unicos caracteres validos son: (A) (C) (G) (T) ");
                    }
                }else {
                    System.out.println("Ingrese nuevamente y recuerde, el largo de la cadena debe ser de 6 lugares: ");
                }

            }
            if (isMutant(adn)){
                System.out.println("El ADN ingresado pertenece a un mutante!");
            }else {
                System.out.println("El ADN ingresado es de un humano!");
            }
    }
    /* Funcion para revisar el largo de las cadenas */
    private static boolean chequearLargo(String cadena_adn) {
        return cadena_adn.length() == 6;
    }

    /* Funcion para revisar los caracteres de la cadena */
    private static boolean revisarCaracteres(String cadena_adn) {
        for (int i=0 ; i<cadena_adn.length() ; i++){
            if (cadena_adn.charAt(i) != 'A' && cadena_adn.charAt(i) != 'C' && cadena_adn.charAt(i) != 'G' && cadena_adn.charAt(i) != 'T'){
               return false;
            }
        }
        return true;
    }


    /*Funcion para revisar si el adn ingresado es de un mutante */

    private static boolean isMutant(ArrayList<String> adn) {
        /*Declaramos un arreglo con cadenas de mutantes para poder compararlas con las ingresadas por el usuario*/
        String[] mutante = {"AAAA", "CCCC", "GGGG", "TTTT"};
        int contador = 0;

        /* Revisamos en lineas horizontales si encontramos cadenas mutantes */

        for (int j = 0; j < adn.size(); j++) {
            for (int h = 0; h < mutante.length; h++) {
                if (adn.get(j).contains(mutante[h])) {
                    contador++;
                    break;
                }
            }
        }


        /* Revisamos de manera vertical */

        for (int i = 0; i < adn.size() - 3; i++) {
            for (int j = 0; j < adn.size(); j++) {
                char aux = adn.get(i).charAt(j);

                if (aux != adn.get(i + 1).charAt(j) || aux != adn.get(i + 2).charAt(j) || aux != adn.get(i + 3).charAt(j)) {
                    continue;
                }
                contador++;
            }
        }


        /* Revisamos las diagonales */

        for (int i = 0; i < adn.size() - 3; i++) {
            for (int j = 0; j < adn.size(); j++) {
                char aux = adn.get(i).charAt(j);
                /*izquierda a derecha*/
                if (j < adn.size() - 3 && aux != adn.get(i + 1).charAt(j + 1) && aux != adn.get(i + 2).charAt(j + 2) && aux != adn.get(i + 3).charAt(j + 3)) {
                    continue;
                }
                /*derecha a izquierda*/
                if (j >= 3 && aux != adn.get(i + 1).charAt(j - 1) && aux != adn.get(i + 2).charAt(j - 2) && aux != adn.get(i + 3).charAt(j - 3)) {
                    continue;
                }
                contador++;
            }
        }
        return contador >= 2;
    }
}




