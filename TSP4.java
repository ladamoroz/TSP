import java.util.Scanner;

public class TSP_easy {
    public static void main(String[] args) {
        // N = 3!
        // input the data - distances between each pair in the form of adjacency matrix
        int[][]g = new int[4][4];
        // if N = 3, 4,5 - different
        // somehow input, do not pay much attention at the beginning
        // i, j -> first, second
        Scanner cin = new Scanner(System.in);
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                 g[i][j] = cin.nextInt();
            }
        }
        find_shortest_path_4(g);
    }

    static void find_shortest_path_4(int[][] distances) {
        // array distances contains in distances[i][j]
        // distance between city with i and city j
        int currentMinimalPathDistance = 1000000; // stores minimal distance of path through all 4 cities that we already found
        // initially number is VERY BIG that is for sure greater than any possible result
        int firstCity = 0; // city 0 is starting and finishing point, as we define it
        // now we need to find all possible pemutations of cities 1,2,3
        for (int secondCity = 1; secondCity <= 3; secondCity = secondCity + 1) { // what is second city in the path?
            for (int thirdCity = 1; thirdCity <= 3; thirdCity = thirdCity + 1) { // what is third city in the path?
                for (int fourthCity = 1; fourthCity <= 3; fourthCity = fourthCity + 1) { // what is fourth city in the path?
                    // our path is defined now
                    // firstCity -> SecondCity -> thirdCity -> fourthCity -> firstCity
                    int[] orderOfCitiesInPath = {firstCity, secondCity, thirdCity, fourthCity};
                    // we might face an issue that some city repeats twice or more in the path
                    // we need to detect such a situation
                    boolean CitiesInPathAreAllDifferent = true; // if all cities are different (true), then such order is correct
                    for (int firstIndex = 0; firstIndex <= 3; firstIndex = firstIndex + 1) { // check each pair of cities
                        for (int secondIndex = 0; secondIndex <= 3; secondIndex = secondIndex + 1) {
                            if (firstIndex != secondIndex) {// if cities indices in the path are not the same, we check for difference
                                int firstCityToCheck = orderOfCitiesInPath[firstIndex]; // ask Artem ? first/second
                                int secondCityToCheck = orderOfCitiesInPath[secondIndex];
                                if (firstCityToCheck == secondCityToCheck) {
                                    CitiesInPathAreAllDifferent = false; // if cities are same, city repeats twice,
                                    // so they are not different
                                }
                            }
                        }
                    }
                    if (CitiesInPathAreAllDifferent == false) {
                        continue;
                    } else {
                        int currentPathDistance = 0;
                        currentPathDistance += distances[firstCity][secondCity];
                        currentPathDistance += distances[secondCity][thirdCity];
                        currentPathDistance += distances[thirdCity][fourthCity];
                        currentPathDistance += distances[fourthCity][firstCity];
                        if (currentPathDistance < currentMinimalPathDistance) {
                            currentMinimalPathDistance = currentPathDistance;
                        }
                    }
                }
            }
        }
        // print the result
        System.out.println(currentMinimalPathDistance);
    }
}
