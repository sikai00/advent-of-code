import java.util.Scanner;
import java.util.HashSet;

public class SharedBadge {
  public static int getSumPriorities(Scanner sc) {
    int sumPriorities = 0;
    int counter = 0;
    String first = "";
    String second = "";
    String third = "";

    while (sc.hasNextLine()) {
      String currRucksack = sc.nextLine();
      if (currRucksack.equals("e")) {
        break;
      }
      if (counter == 2) {
        third = currRucksack;
        char sharedItem = getSharedItem(first, second, third);
        int sharedItemScore = sharedItem > 90 ? (sharedItem - 96) : (sharedItem - 64 + 26);
        System.out.println("score: " + sharedItemScore);
        sumPriorities += sharedItemScore;
        counter = 0;
        first = "";
        second = "";
        third = "";
      } else if (counter == 0) {
        first = currRucksack;
        counter++;
      } else if (counter == 1) {
        second = currRucksack;
        counter++;
      }
    }
    return sumPriorities;
  }

  public static char getSharedItem(String first, String second, String third) {
    HashSet<Character> set = new HashSet<>();
    HashSet<Character> set2 = new HashSet<>();

    for (char f : first.toCharArray()) {
      set.add(f);
    }

    for (char s : second.toCharArray()) {
      set2.add(s);
    }

    for (char t : third.toCharArray()) {
      if (set.contains(t) && set2.contains(t)) {
        System.out.println("common: " + t);
        return t;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(getSumPriorities(sc));
    sc.close();
  }
}
