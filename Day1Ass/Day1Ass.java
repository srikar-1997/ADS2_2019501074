//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//import java.util.List;
import java.io.File;

public class Day1Ass {
    HashMap<String, String> synset = new HashMap<>();
    HashMap<String, String> hypernym = new HashMap<>();
    public void parseSynsets(String fileName) throws Exception {
        
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            String temp[] = sc.nextLine().split(",", 2);
            if (!temp.equals("")) {
                    synset.put(temp[0], temp[1]);
            }
        }
    }

    public void parseHypernym(String fileName) throws Exception {
        
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            String temp[] = sc.nextLine().split(",", 2);
            if (!temp.equals("")) {
                    hypernym.put(temp[0], temp[1]);
            }
        }
    }

    public static void main(String[] args) {
        Day1Ass obj = new Day1Ass();
        String fileName = "synsets.txt";
        String fileName1 = "hypernyms.txt";
        try {
            obj.parseSynsets(fileName);
        } catch (Exception ex) {

        }
        try {
            obj.parseHypernym(fileName1);
        } catch (Exception ex) {

        }
        //System.out.println(obj.synset);
        System.out.println(obj.hypernym);
    }
}