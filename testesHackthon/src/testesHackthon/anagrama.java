package testesHackthon;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class anagrama {

	public static void main(String[] args) throws Exception {

		// listando as palavras
		List<String> palavras = new ArrayList<>();
		try (Scanner s = new Scanner(new File("palavras.txt"))) {
			while (s.hasNext()) {
				palavras.add(s.next());
			}
		}

		// mapeando as palavras
		Map<String, List<String>> mapa = new HashMap<>();

		for (String str : palavras) {
			char[] temp = str.toCharArray();
			Arrays.sort(temp);
			String chave = new String(temp).toUpperCase();
			
			if (mapa.get(chave) != null) {
				mapa.get(chave).add(str.toUpperCase());
			} else {
				ArrayList<String> listaAnagrama = new ArrayList<>();
				listaAnagrama.add(str);
				mapa.put(chave, listaAnagrama);
			}
		}

		// Digite a palavra
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite uma palavra:");
		String palavra = entrada.nextLine().toUpperCase();
		
		char[] key = palavra.toCharArray();
		Arrays.sort(key);
		palavra = new String(key).toUpperCase();
		System.out.println(palavra);
		
		if (!mapa.containsKey(palavra)) {
			System.out.println("Palavra não encontrada");
		} else if (mapa.get(palavra).size() != 1) {
			for (String p : mapa.get(palavra)) {
				System.out.println(p + " ");
			}
		} else {
			System.out.println("Não foi encontrado nenhum anagrama");

		}

	}
}
