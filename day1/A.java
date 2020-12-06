import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class A {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> input = getInput();
        System.out.println(solve(input));
    }

    private static ArrayList<Integer> getInput() throws FileNotFoundException {
        File input = new File("input.txt");
        Scanner sc = new Scanner(input);
        ArrayList<Integer> output = new ArrayList<>();
        while (sc.hasNext()) {
            output.add(sc.nextInt());
        }
        return output;
    }

    private static int solve(ArrayList<Integer> nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(2020 - n)) {
                return n * (2020 - n);
            }
            set.add(n);
        }
        return 0;
    }
}