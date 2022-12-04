import java.util.Arrays;
import java.util.Scanner;

class FullOverlap {
  public static int getFullOverlapPairCount(Scanner sc) {
    int pairCount = 0;
    while (sc.hasNext()) {
      String curr = sc.nextLine();
      if (doesPairsFullyOverlap(curr)) {
        pairCount++;
      }
    }
    return pairCount;
  }

  private static boolean doesPairsFullyOverlap(String pair) {
    String[] eachPair = pair.split(",");
    Integer[] firstPairIndex = Arrays.stream(eachPair[0].split("-"))
        .map(x -> Integer.valueOf(x)).toArray(Integer[]::new);
    Integer[] secondPairIndex = Arrays.stream(eachPair[1].split("-"))
        .map(x -> Integer.valueOf(x)).toArray(Integer[]::new);
    if ((firstPairIndex[0] <= secondPairIndex[0] && firstPairIndex[1] >= secondPairIndex[1]) ||
        (secondPairIndex[0] <= firstPairIndex[0] && secondPairIndex[1] >= firstPairIndex[1])) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(getFullOverlapPairCount(sc));
    sc.close();
  }
}