
import java.nio.file.Paths;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File: ");
        String file = scanner.nextLine();
        System.out.println("Team: ");
        String team = scanner.nextLine();

        int wins = 0;
        int losses = 0;
        int games = 0;

        try ( Scanner fileScanner = new Scanner(Paths.get(file))) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                String[] parts = line.split(",");
                
                //If the team is found at index 0, compare the first number to the latter to determine wins.
                if (parts[0].contains(team)) {
                    if (Integer.valueOf(parts[2]) > Integer.valueOf(parts[3])) {
                        wins++;
                        games++;
                    } else {
                        losses++;
                        games++;
                    }
                    
                  //If the team is found at index 1, compare the second number to the first to determine wins.
                } else if (parts[1].contains(team)) {
                    if (Integer.valueOf(parts[3]) > Integer.valueOf(parts[2])) {
                        wins++;
                        games++;
                    } else {
                        losses++;
                        games++;
                    }
                }

            }
            System.out.println("Games: " + games + "\n" + "Wins: " + wins + "\n" + "Losses: " + losses);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
