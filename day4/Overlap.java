import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;;

class Overlap {
  public static int getFullOverlapPairCount(Scanner sc) {
    int pairCount = 0;
    while (sc.hasNext()) {
      String curr = sc.nextLine();
      if (doesPairsOverlap(curr)) {
        pairCount++;
      }
    }
    return pairCount;
  }

  private static boolean doesPairsOverlap(String pair) {
    String[] eachPair = pair.split(",");
    Integer[] firstPairIndex = Arrays.stream(eachPair[0].split("-"))
        .map(x -> Integer.valueOf(x)).toArray(Integer[]::new);
    Integer[] secondPairIndex = Arrays.stream(eachPair[1].split("-"))
        .map(x -> Integer.valueOf(x)).toArray(Integer[]::new);
    HashSet<Integer> set = new HashSet<>();
    for (int i = firstPairIndex[0]; i <= firstPairIndex[1]; i++) {
      set.add(i);
    }
    for (int i = secondPairIndex[0]; i <= secondPairIndex[1]; i++) {
      if (set.contains(i)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(getFullOverlapPairCount(sc));
    sc.close();
  }
}