import java.util.Scanner;
import java.util.HashSet;

public class SharedPriority {
  public static int getSumPriorities(Scanner sc) {
    int sumPriorities = 0;
    while (sc.hasNextLine()) {
      String currRucksack = sc.nextLine();
      if (currRucksack.equals("e")) {
        break;
      }
      String[] rucksackHalves = splitRucksack(currRucksack);
      char sharedItem = getSharedItem(rucksackHalves[0], rucksackHalves[1]);
      int sharedItemScore = sharedItem > 90 ? (sharedItem - 96) : (sharedItem - 64 + 26);
      System.out.println("score: " + sharedItemScore);
      sumPriorities += sharedItemScore;
    }
    return sumPriorities;
  }

  public static char getSharedItem(String first, String second) {
    HashSet<Character> set = new HashSet<>();
    for (char f : first.toCharArray()) {
      set.add(f);
    }

    for (char s : second.toCharArray()) {
      if (set.contains(s)) {
        System.out.println("common: " + s);
        return s;
      }
    }
    return 0;
  }

  public static String[] splitRucksack(String rucksack) {
    String first = rucksack.substring(0, rucksack.length() / 2);
    System.out.println("first: " + first);
    String second = rucksack.substring(rucksack.length() / 2, rucksack.length());
    System.out.println("first: " + second);
    return new String[] { first, second };
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(getSumPriorities(sc));
    sc.close();
  }
}
