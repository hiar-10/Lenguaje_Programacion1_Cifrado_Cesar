package mundo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main
{
	
	// METODO MAIN
	public static void main(String[] args)throws IOException
	{

		// READER TEXTO Y NUMERO
		BufferedReader entradaTexto = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader entradaNumero = new BufferedReader(new InputStreamReader(System.in));

		
		// VARIABLES
		String mensaje = "";
		int opcion = 0;
		int desplazamiento = 0;
		int veces = 0;
		
		do 
		{
			// IMPRIMIR MENU
			System.out.println("========== SISTEMA DE CIFRADO CÉSAR ==========\r\n" +
					"1. Cifrar un mensaje\r\n" +
					"2. Descifrar un mensaje\r\n" +
					"3. Analizar frecuencia de caracteres\r\n" +
					"4. Verificar si un mensaje es palíndromo\r\n" +
					"5. Salir\r\n"
					+ "==============================================\r\n"
					+ "Seleccione una opción: [X]");


			// SELECCION DE OPCION
			opcion = ProcesoCifrado.enteroPositivo(entradaNumero);


			// MENU OPCIONES
			switch (opcion)
			{
			case 1:
				System.out.println("Por favor ingresa el mensaje a Cifrar:");
				mensaje = ProcesoCifrado.soloLetras(entradaTexto);
				System.out.println("Por favor ingresa el desplazamiento que desea utilizar:");
				desplazamiento = ProcesoCifrado.enteroPositivo(entradaNumero);
				System.out.println("\nMensaje original: " + mensaje);
				System.out.println("Desplazamiento: " + desplazamiento);
				String mensajeCifrado = ProcesoCifrado.cifrar(mensaje, desplazamiento);
				System.out.println("Mensaje cifrado: " + mensajeCifrado);


				// REPETIR CIFRADO
				System.out.println("\n¿Deseas volver a cifrar el mensaje?");
				System.out.println("1. Si\r\n2. No");
				int opcionRecifrar = ProcesoCifrado.enteroPositivo(entradaNumero);

				if(opcionRecifrar == 1)
				{
					System.out.println("\n¿Cuántas veces deseas cifrar el mensaje?");
					veces = ProcesoCifrado.enteroPositivo(entradaNumero);
					mensajeCifrado = ProcesoCifrado.repetirCifrado(mensajeCifrado, desplazamiento, veces);
				}
				else
				{
					System.out.println("De vuelta al menú principal\n");
				}
				break;

			
			case 2:
				System.out.println("Por favor ingresa el mensaje a Descifrar:");
				mensaje = ProcesoCifrado.soloLetras(entradaTexto);
				System.out.println("Por favor ingresa el desplazamiento que desea utilizar:");
				desplazamiento = ProcesoCifrado.enteroPositivo(entradaNumero);
				System.out.println("\nMensaje descifrado: " + mensaje);
				System.out.println("Desplazamiento: " + desplazamiento);
				System.out.println(ProcesoCifrado.descifrar(mensaje, desplazamiento) + "\n");
				break;

				
			case 3:
				System.out.println("Por favor ingresa el texto a analizar la frecuencia de carácteres:");
				mensaje = ProcesoCifrado.soloLetras(entradaTexto);
				System.out.println("\nTexto analizado: " + mensaje);
				System.out.println(ProcesoCifrado.analizarFrecuencia(mensaje) + "\n");
				break;

				
			case 4:
				System.out.println("\nIngrese el texto que desea verificar si es un palíndromo: ");
				mensaje = ProcesoCifrado.soloLetras(entradaTexto);
				String textoNormalizado = mensaje.replace(" ", "").toLowerCase();
				System.out.println("Texto normalizado: " + textoNormalizado);
				System.out.println("¿Es palíndromo? " + ProcesoCifrado.esPalindromo(mensaje) + "\n");
				break; 

				
			case 5:
				System.out.println("\nHas salido del programa");
				break;

				
			default:
				System.out.println("\nPor favor seleccione una opcion válida");
				break;
			}
		}
		while (opcion != 5);
	}
}
