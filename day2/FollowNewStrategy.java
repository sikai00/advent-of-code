import java.util.Scanner;

class FollowNewStrategy {
    public static int getTotalScore(Scanner sc) {
        int totalScore = 0;
        while (sc.hasNextLine()) {
            String curr = sc.nextLine();
            if (curr.equals("e")) {
                break;
            }
            char[] tokens = tokenize(curr);
            totalScore += getScorePerRound(tokens[0], tokens[1]);
        }
        return totalScore;
    }

    private static char[] tokenize(String tokens) {
        return tokens.replaceAll("\\h", "").toCharArray();
    }

    private static int getScorePerRound(char opp, char you) {
        int res = winTieLose(opp, you);
        int shapeScore;
        if (res == 0) { // lose
            if (opp == 'A') { // opp rock, you scissors
                shapeScore = 3;
            } else if (opp == 'B') { // opp paper, you rock
                shapeScore = 1;
            } else {
                shapeScore = 2; // opp scissors, you paper
            }
        } else if (res == 3) { // tie
            shapeScore = opp - 64;
        } else { // win
            if (opp == 'A') { // opp rock, you paper
                shapeScore = 2;
            } else if (opp == 'B') { // opp paper, you scissors
                shapeScore = 3;
            } else { // opp scissors, you rock
                shapeScore = 1;
            }
        }
        return res + shapeScore;
    }

    /**
     * @return 3 if tie, 6 if win, 0 if lose
     */
    private static int winTieLose(char opp, char you) {
        int res = 0;
        switch (you) {
            case 'X':
                res = 0;
                break;
            case 'Y':
                res = 3;
                break;
            case 'Z':
                res = 6;
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getTotalScore(sc));
        sc.close();
    }
}
