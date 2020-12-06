import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class A {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> input = parseInput(getInput());
        System.out.println(solve(input));
        // solve(input);
    }

    private static ArrayList<String> getInput() throws FileNotFoundException {
        File input = new File("input.txt");
        Scanner sc = new Scanner(input);
        ArrayList<String> output = new ArrayList<>();
        while (sc.hasNext()) {
            output.add(sc.nextLine());
        }
        sc.close();
        return output;
    }

    private static ArrayList<String> parseInput(ArrayList<String> input) {
        return input;
    }

    private static int solve(ArrayList<String> input) {
        int count = 0;
        int col = 0;
        for (String s : input) {
            if (s.charAt(col) == '#') {
                count++;
            }
            col = (col + 3) % s.length();
        }
        return count;
    }
}