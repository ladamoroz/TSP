import time

def find_shortest_path_4(distances):
    currentMinimalPathDistance = 1000000
    firstCity = 0
    for secondCity in range(1,4):
        for thirdCity in range(1,4):
            for fourthCity in range(1,4):
                orderOfCitiesInPath = [firstCity, secondCity, thirdCity, fourthCity]
                CitiesInPathAreAllDifferent = True
                for firstIndex in range(0,4):
                    for secondIndex in range(0,4):
                        if firstIndex != secondIndex:
                            firstCityToCheck = orderOfCitiesInPath[firstIndex]
                            secondCityToCheck = orderOfCitiesInPath[secondIndex]
                            if firstCityToCheck == secondCityToCheck:
                                CitiesInPathAreAllDifferent = False
                if CitiesInPathAreAllDifferent == False:
                    continue
                else:
                    currentPathDistance = 0
                    currentPathDistance += distances[firstCity][secondCity]
                    currentPathDistance += distances[secondCity][thirdCity]
                    currentPathDistance += distances[thirdCity][fourthCity]
                    currentPathDistance += distances[fourthCity][firstCity]
                    if currentPathDistance < currentMinimalPathDistance:
                        currentMinimalPathDistance = currentPathDistance
    print(currentMinimalPathDistance)
#fix the reading of adjacency matrix
g = []
for i in range(4):
    g.append([int(j) for j in input().split()])
start_time = time.time_ns()
find_shortest_path_4(g)
print(time.time_ns() - start_time, "nanoseconds")
