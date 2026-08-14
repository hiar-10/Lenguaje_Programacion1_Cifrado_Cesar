package mundo;
public class ProcesoCifrado
{

	// METODO CIFRAR
	static String cifrar(String mensaje, int desplazamiento)
	{
		String mensajeCifrado = "";
		for (int i = 0; i < mensaje.length(); i++)					// Recorre todo el mensaje caracter por caracter hasta el último
		{
			char caracter = mensaje.charAt(i);
			if (Character.isUpperCase(caracter))
			{
				char caracterCifrado = (char)(((caracter - 'A' + desplazamiento) % 26) + 'A');		// Formula de Notion para mayusculas
				mensajeCifrado += caracterCifrado;													// Agrega a cadena de texto
			}
			else if (Character.isLowerCase(caracter))
			{
				char caracterCifrado = (char)(((caracter - 'a' + desplazamiento) % 26) + 'a');		// Formula de Notion para minusculas
				mensajeCifrado += caracterCifrado;													// Agrega a cadena de texto
			}
			else
			{
				mensajeCifrado += caracter;															// Agrega a cadena de texto simbolos espacios y numeros
			}
		}
		return mensajeCifrado;
	}


	// METOOD DESCIFRAR
	static String descifrar(String mensajeCifrado, int desplazamiento)
	{
		String mensajeDescifrado = "";
		for (int i = 0 ; i < mensajeCifrado.length(); i++)			// Recorre todo el mensaje caracter por caracter hasta el último
		{
			char caracter = mensajeCifrado.charAt(i);
			if (Character.isUpperCase(caracter))
			{
				char caracterDescifrado = (char)(((caracter - 'A' - desplazamiento + 26) % 26) + 'A');		// Formula de Notion para mayusculas
				mensajeDescifrado += caracterDescifrado;													// Agrega a cadena de texto
			}
			else if (Character.isLowerCase(caracter))
			{
				char caracterDescifrado = (char)(((caracter - 'a' - desplazamiento + 26) % 26) + 'a');		// Formula de Notion para minusculas
				mensajeDescifrado += caracterDescifrado;													// Agrega a cadena de texto
			}
			else
			{
				mensajeDescifrado += caracter;															// Agrega a cadena de texto simbolos espacios y numeros
			}
		}
		return mensajeDescifrado;
	}


	// METODO ANALIZAR FRECUENCIA
	static String analizarFrecuencia(String mensaje)
	{
		int contarA = 0;
		int contarE = 0;
		int contarI = 0;
		int contarO = 0;
		int contarU = 0;
		int consonantes = 0;

		for (int i = 0; i < mensaje.length(); i++)
		{
			char letra = Character.toLowerCase(mensaje.charAt(i));

			if(letra == 'a')
			{
				contarA++;
			}
			else if(letra == 'e')
			{
				contarE++;
			}
			else if(letra == 'i')
			{
				contarI++;
			}
			else if(letra == 'o')
			{
				contarO++;
			}
			else if(letra == 'u')
			{
				contarU++;
			}
			else if(Character.isLetter(letra))
			{
				consonantes++;
			}
		}

		String	contadorLetras =
				"Vocal 'a': " + contarA 	+
				"\nVocal 'e': " + contarE	+
				"\nVocal 'i': " + contarI	+
				"\nVocal 'o': " + contarO	+
				"\nVocal 'u': " + contarU	+
				"\nTotal consonantes: " 	+ consonantes;

		return contadorLetras;
	}



	// METODO PALINDRMO
	static boolean esPalindromo(String texto)
	{
		
		String textoNormalizado = texto.replace(" ", "").toLowerCase();
		for (int i = 0; i < textoNormalizado.length() / 2; i++)
		{

			if(texto.charAt(i) == texto.charAt(textoNormalizado.length() - 1 - i))
			{
				return false;
			}
		}
		return true;
		
	}


	// REPETIR CIFRADO
	static String repetirCifrado(String mensaje, int desplazamiento, int veces)
	{

		String resultado = mensaje;
		for (int ciclos = 1; ciclos <= veces ; ciclos++)
		{
			System.out.println("\nMensaje Original :" + resultado);
			resultado = cifrar(resultado, desplazamiento);
			System.out.println("Mensaje Cifrado :" + resultado +
					"\nCiclo # :" + ciclos + "/n");
		}
		return resultado;
	
	}
}
