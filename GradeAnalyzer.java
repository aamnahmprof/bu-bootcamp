import java.io.*; 
import java.util.ArrayList;
import java.util.List;

public class GradeAnalyzer {
    public static void main(String[] args ) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");
        // Step 2: calculate statistics
        double average = calculateAverage(scores);

        int highestScore = Integer.MIN_VALUE;
        int lowestScore = Integer.MAX_VALUE;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) > highestScore) {
                highestScore = scores.get(i);
            } else if (scores.get(i) < lowestScore) {
                lowestScore = scores.get(i);
            }
        }

        // Step 3: write and print report
        writeReport(scores, average, highestScore, lowestScore, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>(15);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    try {
                        int score = Integer.parseInt(line);
                        scores.add(score);
                    } catch (NumberFormatException e) {
                        System.out.println("WARNING - Line is not a valid integer and is being skipped");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        double average;

        if (scores.isEmpty()) {
            average = 0.0;
        } else {
            int sum = 0;
            for (int i = 0; i < scores.size(); i++) {
                sum += scores.get(i);
            }
            average = sum / scores.size();
        }

        return average;
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        // your code here
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) >= 90) {
                countA += 1;
            } else if (80 <= scores.get(i) && scores.get(i) < 90) {
                countB += 1;
            } else if (70 <= scores.get(i) && scores.get(i) < 80) {
                countC += 1;
            } else if (60 <= scores.get(i) && scores.get(i) < 70) {
                countD += 1;
            } else {
                countF += 1;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("\n~Grade Analysis Report~\n");
            writer.write(String.format("%-15s %5d%n", "Total grades:", scores.size()));
            writer.write(String.format("\n%-15s %5.1f%n", "Average:", avg));
            writer.write(String.format("%-15s %5d%n", "Highest Score:", high));
            writer.write(String.format("%-15s %5d%n", "Lowest Score:", low));
            writer.write("\nGrade Distribution:");
            writer.write(String.format("\n%-15s %5d%n", "A (90-100):", countA));
            writer.write(String.format("%-15s %5d%n", "B (80-90):", countB));
            writer.write(String.format("%-15s %5d%n", "C (70-80):", countC));
            writer.write(String.format("%-15s %5d%n", "D (60-70):", countD));
            writer.write(String.format("%-15s %5d%n", "F (0-60):", countF));

        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}