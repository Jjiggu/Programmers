def solution(wallpaper):
    answer = []
    y_index = []
    x_index = []
    
    # 최소, 최대 좌표 찾기
    for index_y, word in enumerate(wallpaper):
        for index_x, letter in enumerate(word):
            if letter == "#":
                y_index.append(index_y)
                x_index.append(index_x)
    
    
    
    return [min(y_index), min(x_index), max(y_index)+1, max(x_index)+1]