import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class A {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> input = getInput();
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

    private static int solve(ArrayList<String> input) {
        int start = 0;
        int end = 0;
        String[] nums = new String[2];
        char c = 'a';
        String s = "";
        int count = 0;
        int tempCount = 0;
        String[] temp = new String[3];
        for (int i = 0; i < input.size(); i++) {
            temp = input.get(i).split(" ");
            nums = temp[0].split("-");
            start = Integer.parseInt(nums[0]);
            end = Integer.parseInt(nums[1]);
            c = temp[1].charAt(0);
            s = temp[2];
            for (char d : s.toCharArray()) {
                if (d == c) {
                    tempCount++;
                }
            }
            if (tempCount >= start && tempCount <= end) {
                count++;
            }
            tempCount = 0;
        }
        return count;
    }
}