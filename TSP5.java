import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    int[][] g = new int[5][5];
    Scanner in = new Scanner(System.in);
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            g[i][j] = in.nextInt();
        }
    }
    long startTime = System.nanoTime();
    tsp_5(g);
    long timeSpent = System.nanoTime() - startTime;
    System.out.println(timeSpent + " nanoseconds");
  }
  public static void tsp_5(int distances[][]) {

    int minimalCurrentPathDistance = 1000000;
    int[] shortestPath = { -1, -1, -1, -1, -1 };

    int firstCity = 0;
    
    for (int secondCity = 1; secondCity <= 4; secondCity = secondCity + 1) {
        for (int thirdCity = 1; thirdCity <= 4; thirdCity = thirdCity + 1) {
            for (int fourthCity = 1; fourthCity <= 4; fourthCity = fourthCity + 1) {
                for (int fifthCity = 1; fifthCity <= 4; fifthCity = fifthCity + 1) {


                    int[] orderOfCitiesInPath = { firstCity, secondCity, thirdCity, fourthCity, fifthCity };

                    boolean citiesInPathAreAllDifferent = true;

                    for (int firstIndex = 0; firstIndex <= 4; firstIndex = firstIndex + 1) {
                        for (int secondIndex = 0; secondIndex <= 4; secondIndex = secondIndex + 1) {
                            if (firstIndex != secondIndex) {
                                int firstCityToCheck = orderOfCitiesInPath[firstIndex];
                                int secondCityToCheck = orderOfCitiesInPath[secondIndex];
                                if (firstCityToCheck == secondCityToCheck) {
                                    citiesInPathAreAllDifferent = false;
                                }
                            }
                        }
                    }

                    if (citiesInPathAreAllDifferent == false) {
                        continue;
                    }
                    else {
                        int currentPathDistance = 0;
                        currentPathDistance += distances[firstCity][secondCity];
                        currentPathDistance += distances[secondCity][thirdCity];
                        currentPathDistance += distances[thirdCity][fourthCity];
                        currentPathDistance += distances[fourthCity][fifthCity];
                        currentPathDistance += distances[fifthCity][firstCity];

                        if (minimalCurrentPathDistance > currentPathDistance) {
                            minimalCurrentPathDistance = currentPathDistance;
                            for (int i = 0; i < 5; i++)
                                shortestPath[i] = orderOfCitiesInPath[i];
                        }
                    }
                }
            }
        }
    }

    System.out.println(minimalCurrentPathDistance); 
    for (int i = 0; i < 5; i++)
        System.out.print(shortestPath[i] + " ");
    System.out.println(firstCity);
}
}