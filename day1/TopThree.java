import java.util.Scanner;
import java.util.TreeSet;

class TopThree {
    public static int getTopThree(Scanner sc) {
        TreeSet<Integer> tree = new TreeSet<>();
        int currCalories = 0;

        while (sc.hasNextLine()) {
            String currLine = sc.nextLine();
            if (currLine.equals("")) {
                if (tree.size() < 3) {
                    tree.add(currCalories);
                } else {
                    int lowestValueInTree = tree.pollFirst();
                    tree.add(Math.max(lowestValueInTree, currCalories));
                }
                currCalories = 0;
            } else {
                currCalories += Integer.valueOf(currLine);
            }
        }
        return tree.stream().reduce(0, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getTopThree(sc));
        sc.close();
    }
}
