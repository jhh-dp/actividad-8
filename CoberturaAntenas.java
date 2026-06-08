import java.util.Scanner;

public class CoberturaAntenas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Cantidad de casas: ");
        int n = sc.nextInt();

        int casas[] = new int[n];

        System.out.println("Ingrese las posiciones de las casas:");

        for (int i = 0; i < n; i++) {
	    System.out.println("casa: N°"+ (i+1) );
            casas[i] = sc.nextInt();
        }

        System.out.print("Cobertura de la antena (R): ");
        int R = sc.nextInt();

        // Ordenamiento Burbuja
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (casas[j] > casas[j + 1]) {

                    int aux = casas[j];
                    casas[j] = casas[j + 1];
                    casas[j + 1] = aux;
                }
            }
        }

        int antenas[] = new int[n];
        int cantidad = 0;
        int i = 0;

        while (i < n) {

            // so la primera casa no esta cubierta
            int posicionAntena = casas[i] + R;
            antenas[cantidad] = posicionAntena;
            cantidad++;

            // Saltar todas las casas cubiertas por la antena
            while (i < n && casas[i] <= posicionAntena + R) {
                i++;
            }
        }

        System.out.println("\nPosiciones de las antenas:");

        for (int j = 0; j < cantidad; j++) {
            System.out.println(antenas[j]);
        }
        System.out.println("Cantidad total utilizada: " + cantidad);
        sc.close();
    }
}