package mundo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Principal
{
	// METODO MAIN
	public static void main(String[] args)throws IOException
	{
		// VALORES DE PRUEBA
		String mensaje1   = "Hola Mundo Java";
		String mensaje2   = "Anita lava la tina";
		String textoNormalizado = mensaje2.replace(" ", "").toLowerCase();
		String mensaje3   = "Wxor Jyxbq";          							// Cifrado con desplazamiento 10
		int opcion = 0;


		// ARRAY SIMULACION DE OPCIONES
		int[] simulacion = {1, 2, 3, 4, 5};


		do 
		{
			// IMPRIMIR MENU
			System.out.println("========== SISTEMA DE CIFRADO CÉSAR ==========\r\n" +
					simulacion[0]	+ ". Cifrar un mensaje\r\n" +
					simulacion[1]	+ ". Descifrar un mensaje\r\n" +
					simulacion[2]	+ ". Analizar frecuencia de caracteres\r\n" +
					simulacion[3]	+ ". Verificar si un mensaje es palíndromo\r\n" +
					simulacion[4] 	+ ". Salir\r\n"
					+ "==============================================\r\n"
					+ "Seleccione una opción: [X]");
			
			
			// SELECCION DE OPCION
			BufferedReader entradaTexto = new BufferedReader(new InputStreamReader(System.in));
			opcion = Integer.parseInt(entradaTexto.readLine());


			// MENU OPCIONES
			switch (opcion)
			{
			case 1:
				System.out.println("\nMensaje original: " + mensaje1);
				int desplazamiento = 3;
				System.out.println("Desplazamiento: " + desplazamiento);
				String mensajeCifrado = ProcesoCifrado.cifrar(mensaje1, desplazamiento);
				System.out.println(mensajeCifrado + "/n");

				
				// REPETIR CIFRADO
				System.out.println("\n¿Deseas volver a cifrar el mensaje?");
				System.out.println("1. Si\r\n2. No");
				int opcionRecifrar = Integer.parseInt(entradaTexto.readLine());

				if(opcionRecifrar == 1)
				{
					System.out.println("\n¿Cuántas veces deseas cifrar el mensaje?");
					int veces = Integer.parseInt(entradaTexto.readLine());
					mensajeCifrado = ProcesoCifrado.repetirCifrado(mensajeCifrado, desplazamiento, veces);
				}
				break;

			case 2:
				System.out.println("\nMensaje cifrado: " + mensaje3);
				int desplazamiento1 = 10;
				System.out.println("Desplazamiento: " + desplazamiento1);
				System.out.println(ProcesoCifrado.descifrar(mensaje3, desplazamiento1) + "\n");
				break;

			case 3:
				System.out.println("\nTexto a analizar: " + mensaje1);
				System.out.println(ProcesoCifrado.analizarFrecuencia(mensaje1) + "\n");
				break;

			case 4:
				System.out.println("\nTexto analizado: " + mensaje2);
				System.out.println("Texto normalizado: " + textoNormalizado);
				System.out.println("¿Es palíndromo? " + ProcesoCifrado.esPalindromo(mensaje2) + "\n");
				break; 

			case 5:
				System.out.println("\nEl cifrado ha terminado");
				break;

			default:
				System.out.println("\nPor favor seleccione una opcion válida");
				break;
			}
		}
		while (opcion != 5);
	}
}
