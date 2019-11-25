package testesHackthon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class anagrams {
    public static void main(String[] args) throws FileNotFoundException {


        List<String> words = new ArrayList<>();
        try (Scanner s = new Scanner(new File("palavras.txt"))){
        	while (s.hasNext()) {
            words.add(s.next());
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : words) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp).toUpperCase();
            if (map.get(key) != null) {
                map.get(key).add(str.toUpperCase());
            } else {
                ArrayList<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                map.put(key, anagramList);
            }
        }
        
        Scanner input = new Scanner(System.in);
        String str = input.next().toUpperCase();
        char[] key = str.toCharArray();
        Arrays.sort(key);
        str = new String(key).toUpperCase();
        if (!map.containsKey(str)) {
            System.out.print("word not found");
        } else if (map.get(str).size() != 1) {
            for (String p : map.get(str)) {
                System.out.print(p + " ");
            }
        } else {
            System.out.print("No anagrams found");
        }
       
        input.close();
    }
}
    
}