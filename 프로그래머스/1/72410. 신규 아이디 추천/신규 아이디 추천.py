import re
def solution(new_id):
    answer = ''
    second_filter = ["-", "_", "."]
    # 1단계 (소문자 변환)
    new_id = new_id.lower()
    
    # 2단계 (소문자, 숫자, -, _, . 를 제외한 모든 문자 제거)
    # 정규 표현식
    # import re
    # new_text = re.sub(r"[a-z]", "", text)
    for i in new_id:
        if not i.isalpha() and not i.isdigit() and i not in ("-", "_", "."):
            new_id = new_id.replace(i, "")
    
    # 3단계 ..이 연속으로 나오면 ..으로 치환
#     c = 0
#     new_id = list(new_id)
#     for i in range(len(new_id)):
#         if (new_id[i] == '.') and (c==0):
#             c += 1
#         elif (new_id[i] == '.') and (c>=1):
#             new_id[i] = ''
#             c += 1
#         elif new_id[i] != '.': 
#             c = 0 
#     new_id = "".join(new_id)  
    
    # 해당 코드 사용하면 특정 테케 통과 못 함
    # new_id = new_id.replace("..", ".")
    new_id = re.sub('\.+', '.', new_id)
        
    # 4단계 마침표가 처음이나 끝에 위치한다면 제거
    if new_id[0] == ".":
        new_id = new_id.lstrip(".")
        
    elif new_id[-1] == ".":
        new_id = new_id.rstrip(".")
    
    # 5단계 빈 문자열이면 "a" 대입
    if len(new_id) == 0:
        new_id += "a"
        
    # 6단계 16자 이상이면 15자로 -> 마지막 단어가 마침표면 제거 
    if len(new_id) > 15:
        new_id = new_id[:15]
    
    if new_id[-1] == ".":
        new_id = new_id.rstrip(".")
    
    # 7단계 new_id가 2자 이하라면 마지막 문자 끝에 붙이기
    if len(new_id) <= 2:
        while(len(new_id) <= 2):
            new_id += new_id[-1]
    
    
    d = 0
    new = "......"
    new = list(new)
    for i in range(len(new)):
        if (new[i] == '.') and (d==0):
            d += 1
        elif (new[i] == '.') and (d>=1):
            new[i] = ''
            d += 1
        elif new[i] != '.': 
            d = 0 
    
    print(new)
    
    return new_id