import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class B {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<ArrayList<String>> input = parseInput(getInput());
        System.out.println(solve(input));
        // solve(input);
    }

    private static String getInput() throws FileNotFoundException, IOException {
        String output = Files.readString(Paths.get("input.txt"), StandardCharsets.US_ASCII);
        return output;
    }

    private static ArrayList<ArrayList<String>> parseInput(String input) {
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        String[] lines = input.split("\n\n");
        for (String line : lines) {
            String[] temp = line.split("\\s");
            output.add(new ArrayList<>(Arrays.asList(temp)));
        }
        return output;
    }

    private static int solve(ArrayList<ArrayList<String>> input) {
        int count = 0;
        HashSet<String> set = new HashSet<>();
        set.add("byr");
        set.add("iyr");
        set.add("eyr");
        set.add("hgt");
        set.add("hcl");
        set.add("ecl");
        set.add("pid");
        set.add("cid");
        for (ArrayList<String> list : input) {
            HashSet<String> temp = (HashSet<String>) set.clone();
            for (String s : list) {
                String mod = s.substring(0, 3);
                temp.remove(mod);
                System.out.print(mod + " ");
            }
            if (temp.size() == 0 || (temp.size() == 1 && temp.contains("cid"))) {
                count++;
                System.out.print("true");
            } else {
                System.out.print("false");
            }
            System.out.println("");
        }
        return count;
    }
}