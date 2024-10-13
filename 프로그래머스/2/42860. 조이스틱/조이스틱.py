def solution(name):
    len_name = len(name)

    cursor_move = len_name - 1  

    answer = 0

    for i in range(len_name):
        answer += min(ord(name[i]) - ord('A'), ord('Z') - ord(name[i]) + 1)

        # 해당 알파벳 다음부터 연속된 A 문자열 index 찾기
        next = i + 1
        while next < len_name and name[next] == 'A':
            next += 1

        cursor_move = min([ cursor_move, 2 * i + len_name - next, i + 2 * (len_name - next) ])


    return answer + cursor_move