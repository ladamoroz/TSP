import time
def tsp_5(distances):
  minimalCurrentPathDistance = 1000000
  shortestPath = [ -1, -1, -1, -1, -1 ]
  firstCity = 0

  for secondCity in range(1,5):
    for thirdCity in range(1,5):
      for fourthCity in range(1,5):
        for fifthCity in range(1,5):

          orderOfCitiesInPath = [firstCity, secondCity, thirdCity, fourthCity, fifthCity]
          citiesInPathAreAllDifferent = True
          for firstIndex in range(0,5):
            for secondIndex in range(0,5):
              if firstIndex != secondIndex:
                firstCityToCheck = orderOfCitiesInPath[firstIndex]
                secondCityToCheck = orderOfCitiesInPath[secondIndex]
                if firstCityToCheck == secondCityToCheck:
                  citiesInPathAreAllDifferent = False     
          if citiesInPathAreAllDifferent == False:
            continue
          else:
            currentPathDistance = 0;
            currentPathDistance += distances[firstCity][secondCity]
            currentPathDistance += distances[secondCity][thirdCity]
            currentPathDistance += distances[thirdCity][fourthCity]
            currentPathDistance += distances[fourthCity][fifthCity]
            currentPathDistance += distances[fifthCity][firstCity]
            if minimalCurrentPathDistance > currentPathDistance:
              minimalCurrentPathDistance = currentPathDistance
              for i in range(0,5):
                shortestPath[i] = orderOfCitiesInPath[i]
  print(minimalCurrentPathDistance)   
  for i in shortestPath:
    print(i)
  print(firstCity)            


g = []
for i in range(5):
    g.append([int(j) for j in input().split()])
start_time = time.time_ns()
tsp_5(g)
print(time.time_ns() - start_time, "nanoseconds")

