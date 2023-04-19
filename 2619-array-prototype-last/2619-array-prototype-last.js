Array.prototype.last = function() {
    const curr = this;
    if(curr.length == 0)
        return -1;
    return curr[curr.length-1];
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */