def find_start(park):
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == "S":
                return [i, j]
                
            
def solution(park, routes):
    answer = []
    direction = {"N":[-1, 0], "S":[1, 0], "W":[0, -1], "E":[0, 1]}
    
    dog_location = find_start(park)
    
    for i in routes:
        op, n = i.split(" ")
        intitial_y, intitial_x = dog_location
        y, x = dog_location
        
        for j in range(int(n)):
            now_direction = direction[op]
            
            y, x = [y + now_direction[0], x + now_direction[1]]
            
            # one_move = [a + b for a, b in zip(dog_location, now_direction)]
            # y, x = one_move
            
            try:
                if park[y][x] != "X" and (0 <= y < len(park)) and (0 <= x < len(park[0])):
                    dog_location = [y, x]
                else:
                    dog_location = [intitial_y, intitial_x]
                    break
                    
            except IndexError:
                dog_location = [intitial_y, intitial_x]
                break
        
        
    return dog_location
            