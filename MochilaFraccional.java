import java.util.Scanner;

public class MochilaFraccional {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
	System.out.print("\nCapacidad de la mochila: ");
        double capacidad = sc.nextDouble();

        System.out.print("Ingrese cantidad de objetos: ");
        int n = sc.nextInt();

        String nombre[] = new String[n];
        double valor[] = new double[n];
        double peso[] = new double[n];
        double relacion[] = new double[n];
	
	for (int i = 0; i < n; i++) {
            System.out.println("\nObjeto " + (i + 1));
            System.out.print("Nombre: ");
            nombre[i] = sc.next();

            System.out.print("Valor: ");
            valor[i] = sc.nextDouble();

            System.out.print("Peso: ");
            peso[i] = sc.nextDouble();
            relacion[i] = valor[i] / peso[i];
        }
        

        // Ordenamiento Burbuja
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (relacion[j] < relacion[j + 1]) {

                    double auxD;

                    auxD = relacion[j];
                    relacion[j] = relacion[j + 1];
                    relacion[j + 1] = auxD;

                    auxD = valor[j];
                    valor[j] = valor[j + 1];
                    valor[j + 1] = auxD;

                    auxD = peso[j];
                    peso[j] = peso[j + 1];
                    peso[j + 1] = auxD;

                    String auxS = nombre[j];
                    nombre[j] = nombre[j + 1];
                    nombre[j + 1] = auxS;
                }
            }
        }

        double valorTotal = 0;
        System.out.println("\nObjetos seleccionados:");

        for (int i = 0; i < n; i++) {

            if (capacidad == 0) {
                break;
            }

            if (peso[i] <= capacidad) {

                System.out.println(nombre[i] + " completo");

                capacidad = capacidad - peso[i];
                valorTotal = valorTotal + valor[i];

            } else {

                double fraccion = capacidad / peso[i];
		int parteTomada = (int) capacidad;
		int pesoObjeto = (int) peso[i];

		System.out.println(parteTomada +"/"+ pesoObjeto +" Parte del objeto " + nombre[i]);

		valorTotal = valorTotal + (valor[i] * fraccion);

		capacidad = 0;
            }
        }
        System.out.println("Valor total obtenido: " + valorTotal);
        sc.close();
    }
}