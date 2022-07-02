
import java.util.ArrayList;

/**
 *
 * @author Juan Carlos Quispe Ttito
 */
public class FuerzaBruta {

    //metod que recorre las pesas de las bolsas
    public static int minBolsas(int peso, int[] bolsas) {
        ArrayList<Integer> iter = new ArrayList<>();
        for (int i = 0; i < bolsas.length; i++) {  //recorre la cantidad de bolsas
            iter.add(bolsas[i]); //añade las bolsas
        }
        int result = 1;
        return minBolsas(peso, iter, result, iter);
    }

    //metodo que hace las combinaciones para obtener el menor cantidad de bolsas
    private static int minBolsas(int peso, ArrayList<Integer> iter, int result, ArrayList<Integer> iter1) {
        ArrayList<Integer> iter2 = new ArrayList<>();
        result++;
        for (int i = 0; i < iter.size(); i++) {
            int A = iter.get(i);
            for (int j = 0; j < iter1.size(); j++) {
                int B = iter1.get(j);
                int sum = A + B;
                if (sum == peso) {
                    return result;
                } else {
                    if (iter.contains(sum) == false) {
                        if (iter2.contains(sum) == false) {
                            iter2.add(sum);
                        }
                    }
                }
            }
        }
        return minBolsas(peso, iter2, result, iter1);
    }

    //funcion main
    public static void main(String args[]) {

        //pruebas 
        int prueba1[] = {1, 2, 5};
        int prueba2[] = {1, 3, 4};
        int prueba3[] = {1, 3, 4};
        int prueba4[] = {1, 3, 5, 7};
        int prueba5[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int prueba6[] = {1, 2, 5, 7, 11, 13};
        int prueba7[] = {1, 2, 5, 7, 11, 13};
        int prueba01 = minBolsas(12, prueba1);
        int prueba02 = minBolsas(10, prueba2);
        int prueba03 = minBolsas(6, prueba3);
        int prueba04 = minBolsas(18, prueba4);
        int prueba05 = minBolsas(360, prueba5);
        int prueba06 = minBolsas(360, prueba6);
        int prueba07 = minBolsas(1360, prueba7);

        System.out.println("Prueba 1: " + prueba01 + "\nPuebra 2: " + prueba02 + "\nPuebra 3: " + prueba03
                + "\nPuebra 4: " + prueba04 + "\nPuebra 5: " + prueba05 + "\nPuebra 6: " + prueba06
                + "\nPuebra 7: " + prueba07);
    }

}

