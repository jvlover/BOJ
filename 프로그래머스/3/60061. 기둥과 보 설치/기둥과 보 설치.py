def solution(n, build_frame):
    built = set()
    
    for i in build_frame:
        x, y, a, b = i
        
        if not b:
            built.remove((x, y, a))
            if not is_possible(built):
                built.add((x, y, a))
                
        else:
            built.add((x, y, a))
            if not is_possible(built):
                built.remove((x, y, a))

    return sorted(built)

def is_possible(built): 
        for b in built:
            x, y, a = b
            
            if not a:
                if y and (x, y-1, 0) not in built and ((x, y, 1) not in built and (x-1, y, 1) not in built):
                    return False
                
            else:
                if ((x, y-1, 0) not in built and (x+1, y-1, 0) not in built) and ((x-1, y, 1) not in built or (x+1, y, 1) not in built):
                    return False
                
        return True