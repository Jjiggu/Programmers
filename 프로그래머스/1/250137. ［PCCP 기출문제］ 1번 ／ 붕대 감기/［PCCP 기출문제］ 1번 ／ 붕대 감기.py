def solution(bandage, health, attacks):
    answer = 0
    
#     # 공격
#     for attack in range()
    
#     # 스킬 사용
#     for i in range(bandage[0]):
#         if now_hp <= health: # 현재 체력이 최대 체력보다 작은 경우 회복 
#             health += bandage[1]
            
#     if (now_hp + bandage[2]) <= health: # 스킬 사용이 끝난 후 추가 회복량과 최대체력 비교
#         now_hp += bandage[2]  # 최대 체력을 넘지 않으면 추가 체력 회복
#     else:
#         now_hp = health # 최대 체력까지만 회복

    cast_time, healing_per_second, additional_healing = bandage
    
    max_health = health
    per_attack_time = attacks[0][0]
    
    for attack_time, damage in attacks:
        time_between = attack_time - per_attack_time -1
    
        if time_between > 0:
            health += (time_between * healing_per_second)
            health += ((time_between // cast_time) * additional_healing)

            if health > max_health:
                health = max_health
        health -= damage

        if health <= 0:
            return -1

        per_attack_time = attack_time
    
        
    return health
