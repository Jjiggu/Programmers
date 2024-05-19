def solution(phone_number):
    answer = ''
    
    # 뒷자리
    back_number = phone_number[-4:]
    
    new_number = "*" * (len(phone_number) - 4) + back_number
    
    return new_number