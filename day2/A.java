import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class A {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<ArrayList<Object>> input = parseInput(getInput());
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

    private static ArrayList<ArrayList<Object>> parseInput(ArrayList<String> input) {
        ArrayList<ArrayList<Object>> output = new ArrayList<>();
        for (String s : input) {
            ArrayList<Object> temp = new ArrayList<>();
            String[] split = s.split(" ");
            String[] nums = split[0].split("-");
            temp.add(Integer.parseInt(nums[0]));
            temp.add(Integer.parseInt(nums[1]));
            temp.add(split[1].charAt(0));
            temp.add(split[2]);
            output.add(temp);
        }
        return output;
    }

    private static int solve(ArrayList<ArrayList<Object>> input) {
        int count = 0;
        for (ArrayList<Object> list : input) {
            int start = (int) list.get(0);
            int end = (int) list.get(1);
            char c = (char) list.get(2);
            String s = (String) list.get(3);
            if (isValidPassword(start, end, c, s)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isValidPassword(int start, int end, char c, String s) {
        int count = 0;
        for (char d : s.toCharArray()) {
            if (d == c) {
                count++;
            }
        }
        return count >= start && count <= end;
    }
}