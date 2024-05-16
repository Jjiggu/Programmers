def find_start_location(park):
    for y_index, y in enumerate(park):
        if "S" in y:
            return[y_index, y.index("S")]
    return [-1, -1]

def move_location(dog_location, direction, distance, park):
    initial_y, initial_x = dog_location
    y, x = dog_location
    
    for i in range(distance):
        one_mov = [a+b for a, b in zip(dog_location, direction)]
        y, x = one_mov
        
        try:
            if(park[y][x] != "X" and (0 <= y < len(park)) and (0 <= x < len(park[0]))):
                dog_location = [y, x]
            else:
                return [initial_y, initial_x]
        except IndexError:
            return [initial_y, initial_x]
        
    return [y, x]

def solution(park, routes):
    answer = []
    
    dog_location = find_start_location(park)
    
    direction = {"N":[-1, 0], "S":[1, 0], "W":[0, -1], "E":[0, 1]}
    
    for route in routes:
        
        mov_dir = direction[route[0]]
        mov_dis = int(route[2])
        
        dog_location = move_location(dog_location, mov_dir, mov_dis, park)
    
    
    return dog_location