/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var widthOfBinaryTree = function(root) {
    let maxA = 0n, hash=new Map();
    const recurse = (cur, width, level) =>
    {
        if(cur===null)
        {
            return;
        }
        if(hash.has(level))
        { 
            // console.log(hash);
            let [min, max] = hash.get(level);
            if ((BigInt)(min) > (BigInt) (width))
                min = (BigInt) (width);
            else 
                min = (BigInt) (min); 
            
             if ((BigInt) (max) <  (BigInt) (width))
                max = (BigInt) (width);
            else 
                max = (BigInt) (max); 
    
            hash.set(level, [min, max]);
        }
        else{

            hash.set(level, [(width), (width)]);
        }

        if((BigInt) (hash.get(level)[1]) - (BigInt) (hash.get(level)[0]) +1n > maxA)
            maxA = (BigInt) (hash.get(level)[1]) - (BigInt) (hash.get(level)[0]) + 1n;
        else 
            maxA= (BigInt) (maxA);
        recurse(cur.left, (BigInt)  (width)*2n-1n, level+1);
        recurse(cur.right, (BigInt) (width) *2n, level+1);
    }
    recurse(root,1, 0)
    return maxA;
};