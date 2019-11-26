package testesHackthon;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class anagrama {

	public static void main(String[] args) throws Exception {

		// adicionando as palavras em uma Lista
		List<String> palavras = new ArrayList<>();
		try (Scanner s = new Scanner(new File("palavras.txt"))) {
			while (s.hasNext()) {
				palavras.add(s.next());
			}
		}

		// mapeando as palavras
		Map<String, List<String>> mapa = new HashMap<>();

		for (String str : palavras) {
			char[] temp = str.trim().toCharArray();
			Arrays.sort(temp);
			String chave = new String(temp);
			
			if (mapa.get(chave) != null) {
				mapa.get(chave).add(str);
			} else {
				ArrayList<String> listaAnagrama = new ArrayList<>();
				listaAnagrama.add(str);
				mapa.put(chave, listaAnagrama);
			}
		}

		// Digite a palavra
		
		Pattern patern = Pattern.compile("[a-zA-Z ]+"); //defindo o limite de caracteres
		boolean teste;
		
		System.out.println("Digite uma palavra:");
		
		Scanner entrada = new Scanner(System.in); //criando um novo objeto do tipo Scanner
		String palavra = entrada.nextLine().toUpperCase().replace(" ", ""); //entrada da palavra
		
		
		Matcher m = patern.matcher(palavra);
		teste = m.matches();
		
		if(teste == true) { //teste para certificar que a palavra não contém caracteres inválidos
		
		char[] key = palavra.toCharArray();
		Arrays.sort(key);
		palavra = new String(key).toUpperCase();
		//System.out.println(palavra);
		
		if (!mapa.containsKey(palavra)) {
			System.out.println("Palavra não encontrada");
		} else if (mapa.get(palavra).size() != 1) {
			for (String p : mapa.get(palavra)) {
				System.out.println(p);
			}
		} else {
			System.out.println("Não foi encontrado nenhum anagrama");

		}
		
		}else {
			System.out.println("Caracteres inválidos");
			}
	}
}
