import java.util.Stack;

/**
 *
 * 
 */
public class MochilaDinamica{

    //Metodo que hace las combinaciones de los pesos
    private static int minBags(int peso, int[] bags, Stack<Integer> bag, int pos, int result) {
        if (peso == 0) {// Caso base
            return result;
        } else {
            int iter = bags[pos];
            if (iter <= peso) {
                bag.push(iter);
                result++;
                return minBags(peso - iter, bags, bag, pos, result);
            } else {
                int iter2 = bags[pos - 1];
                if (iter2 <= peso) {
                    bag.push(iter2);
                    result++;
                    return minBags(peso - iter2, bags, bag, pos - 1, result);
                } else {
                    int top = bag.pop();
                    result--;
                    return minBags(peso + top, bags, bag, pos - 1, result);
                }
            }
        }
    }
    
    public static int minBags(int peso, int[] bolsas) {
        Stack<Integer> bags = new Stack<>();
        int pos = bolsas.length - 1;
        int result = 0;
        return minBags(peso, bolsas, bags, pos, result);
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
        
        int prueba01 = minBags(12, prueba1);
        int prueba02 = minBags(10, prueba2);
        int prueba03 = minBags(6, prueba3);
        int prueba04 = minBags(18, prueba4);
        int prueba05 = minBags(360, prueba5);
        int prueba06 = minBags(360, prueba6);
        int prueba07 = minBags(1360, prueba7);

        System.out.println("Prueba 1: " + prueba01 + "\nPuebra 2: " + prueba02 + "\nPuebra 3: " + prueba03
                + "\nPuebra 4: " + prueba04 + "\nPuebra 5: " + prueba05 + "\nPuebra 6: " + prueba06
                + "\nPuebra 7: " + prueba07);
    }
}
