def solution(bandage, health, attacks):
    active_t, heal_second, extra_heal = bandage
    now_health = health
    max_health = health
    now_time = 0
    skill_time = 1
    
    for attack in attacks:
        attack_t, attack_d = attack
            
        for time in range(now_time, attack_t):
            if skill_time == active_t:
                if now_health + extra_heal + heal_second > max_health:
                    now_health = max_health
                    skill_time = 1
                    continue
                else:
                    now_health += (extra_heal + heal_second)
                    skill_time = 1
                    continue
            
            if now_health + heal_second > max_health:
                skill_time += 1
                now_health = max_health
                
            elif now_health + heal_second <= max_health:
                skill_time += 1
                now_health += heal_second
            
        now_health -= attack_d
        
        if now_health <= 0:
            return -1
        
        skill_time = 1
        now_time = attack_t + 1
        
        
    return now_health