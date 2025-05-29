table = [["EMPTY"]*51 for _ in range(51)]
par = [[[r, c] for c in range(51)] for r in range(51)]
output = []

def find(r, c):
    if par[r][c] == [r, c]:
        return [r, c]
    pr, pc = par[r][c]
    par[r][c] = find(pr, pc)
    return par[r][c]


def MERGE(r1, c1, r2, c2):
    if (r1, c1) == (r2, c2):
        return
    r1, c1 = find(r1, c1)
    r2, c2 = find(r2, c2)
    if (r1, c1) == (r2, c2):
        return

    if table[r1][c1] == "EMPTY" and table[r2][c2] != "EMPTY":
        r1, c1, r2, c2 = r2, c2, r1, c1

    group = []
    for i in range(1, 51):
        for j in range(1, 51):
            pi, pj = find(i, j)
            if (pi, pj) == (r2, c2):
                group.append((i, j))
    for i, j in group:
        par[i][j] = [r1, c1]


def UNMERGE(r, c):
    pr, pc = find(r, c)
    v = table[pr][pc]
    
    group = []
    for i in range(1, 51):
        for j in range(1, 51):
            pi, pj = find(i, j)
            if [pi, pj] == [pr, pc]:
                group.append((i, j))
    for i, j in group:
        par[i][j] = [i, j]
        table[i][j] = "EMPTY"
    table[r][c] = v


def UPDATE(r, c, v):
    pr, pc = find(r, c)
    table[pr][pc] = v


def UPDATE_VAL(val1, val2):
    for r in range(1, 51):
        for c in range(1, 51):
            if table[r][c] == val1:
                table[r][c] = val2


def PRINT(r, c):
    pr, pc = find(r, c)
    output.append(table[pr][pc])


def solution(commands):
    for command in commands:
        op, *args = command.split()
        if (op == "UPDATE"):
            if len(args) == 3:
                r, c = map(int, args[:2])
                UPDATE(r, c, args[2])
            else:
                UPDATE_VAL(*args)
        if (op == "MERGE"):
            MERGE(*map(int, args))
        if (op == "UNMERGE"):
            UNMERGE(*map(int, args))
        if (op == "PRINT"):
            PRINT(*map(int, args))

    return output