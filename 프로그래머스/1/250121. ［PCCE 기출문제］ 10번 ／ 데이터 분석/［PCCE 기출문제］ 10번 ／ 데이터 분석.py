def solution(data, ext, val_ext, sort_by):
    
    data_type = {
        "code" : 0,
        "date" : 1,
        "maximum" : 2,
        "remain" : 3
    }
    
    filterd_data = [d for d in data if d[data_type[ext]] < val_ext]
    
    sorted_data = sorted(filterd_data, key=lambda x: x[data_type[sort_by]])
    
    
    return sorted_data