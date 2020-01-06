import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Day1{
    //List<String> synsetfile = new ArrayList<>();
    List<Integer> synsetindex = new ArrayList<>();
    List<String> synsets = new ArrayList<>();
    List<String> def = new ArrayList<>();
    List<Integer> hypIndex = new ArrayList<>();
    List<String> hypernyms = new ArrayList<>();
    public void parseSynsets(final String fileName) throws Exception {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String temp[] = sc.nextLine().split(",");
            if (!temp.equals("")) {
                //synsetfile.add(temp);//.split(","));
                synsetindex.add(Integer.parseInt(temp[0]));
                synsets.add(temp[1]);
                def.add(temp[2]);
            }
        }
        sc.close();
    }

    public void parseHypernyms(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String temp[] = sc.nextLine().split(",",2);
            if (!temp.equals("")) {
                hypIndex.add(Integer.parseInt(temp[0]));
                hypernyms.add(temp[1]);
            }
        }
        sc.close();
    }
    public static void main(String[] args) {
        String filename = "synsets.txt";
        String filename1 = "hypernyms.txt";
        Day1 obj = new Day1();
        try {
            obj.parseSynsets(filename);
        } catch (Exception ex) {
            ex = new Exception("s");
        }
        try {
            obj.parseHypernyms(filename1);
        } catch (Exception ex) {
            ex = new Exception("s");
        }
        System.out.println(obj.hypernyms.get(34));
    }
}