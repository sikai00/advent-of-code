import java.util.Scanner;

class CalorieCounting {
    public static int getMostCalorie(Scanner sc) {
        int most = Integer.MIN_VALUE;
        int currCalories = 0;

        while (sc.hasNextLine()) {
            String currLine = sc.nextLine();
            if (currLine.equals("")) {
                most = Math.max(most, currCalories);
                currCalories = 0;
            } else {
                currCalories += Integer.valueOf(currLine);
            }
        }
        return most;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getMostCalorie(sc));
        sc.close();
    }
}
