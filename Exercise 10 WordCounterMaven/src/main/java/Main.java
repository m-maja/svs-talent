import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main (String [] args){

        if (args.length < 1){
            System.err.println("Too few arguments");
            return;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        Scanner scanner = null;

        try {
            scanner =
                    new Scanner(
                            new FileReader(
                                    new File(args[0])));
            String line;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] words = line.split("\\s+");

                for (String word : words) {
                    word = word.replaceAll("[^\\w]","");
                    word = StringUtils.lowerCase(word);
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }
            map.remove("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        printMap(map);
    }

     public static void printMap (Map map){
        for (Object o : map.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
}
