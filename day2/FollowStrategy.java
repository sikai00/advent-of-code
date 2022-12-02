import java.util.Scanner;

class FollowStrategy {
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
        int shapeScore = you - 87;
        return res + shapeScore;
    }

    /**
     * @return 3 if tie, 6 if win, 0 if lose
     */
    private static int winTieLose(char opp, char you) {
        int res = 0;
        switch (you) {
            case 'X':
                if (opp == 'A') {
                    res = 3;
                } else if (opp == 'B') {
                    res = 0;
                } else if (opp == 'C') {
                    res = 6;
                }
                break;
            case 'Y':
                if (opp == 'A') {
                    res = 6;
                } else if (opp == 'B') {
                    res = 3;
                } else if (opp == 'C') {
                    res = 0;
                }
                break;
            case 'Z':
                if (opp == 'A') {
                    res = 0;
                } else if (opp == 'B') {
                    res = 6;
                } else if (opp == 'C') {
                    res = 3;
                }
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
