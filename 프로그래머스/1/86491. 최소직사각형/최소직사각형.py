def solution(sizes):
    new_num = 0
    new_sizes = []
    
    row_max = 0
    columns_max = 0
    
    for row, columns in sizes:
        if row < columns:
        #     new_num = columns
        #     columns = row
        #     row = new_num
        #     new_sizes.append([row, columns])
        # else:
        #     new_sizes.append([row, columns])
        # 아래 코드로 변경 가능
            row, columns = columns, row
            
        row_max = max(row, row_max)
        columns_max = max(columns, columns_max)
            
            
    
#     for row, columns in new_sizes:
#         if row > row_max:
#             row_max = row
        
#         if columns > columns_max:
#             columns_max = columns
            
    
    
    return row_max * columns_max