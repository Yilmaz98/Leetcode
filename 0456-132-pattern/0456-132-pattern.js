/**
 * @param {number[]} nums
 * @return {boolean}
 */
var find132pattern = function(nums) {
    let stack = [], temp = -Infinity;
   for(let i=nums.length-1;i>-1;i--)
   {
      if(nums[i]<temp)
      {
          return true;
      }
      if(stack.length===0)
      {
          stack.push(nums[i]);
          continue;


      }
      if(nums[i]<stack[stack.length-1])
      {
          stack.push(nums[i]);
      }
      else if(nums[i]>stack[stack.length-1])
      {
          while(stack.length>0 && stack[stack.length-1] <nums[i])
          {
              temp = stack[stack.length-1]
              stack.pop();
          }
          stack.push(nums[i])
       }
}
return false
};