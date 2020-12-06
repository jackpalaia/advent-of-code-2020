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
        int ans = 1;
        ans *= getTrees(input, 1, 1);
        ans *= getTrees(input, 3, 1);
        ans *= getTrees(input, 5, 1);
        ans *= getTrees(input, 7, 1);
        ans *= getTrees(input, 1, 2);
        return ans;
    }

    private static int getTrees(ArrayList<String> input, int right, int down) {
        int count = 0;
        int col = 0;
        for (int i = 0; i < input.size(); i += down) {
            String s = input.get(i);
            if (s.charAt(col) == '#') {
                count++;
            }
            col = (col + right) % s.length();
        }
        return count;
    }
}