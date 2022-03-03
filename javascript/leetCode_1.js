/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let numL = nums.length;
    const result = [];
    
    loop:
    for(let i=0; i< numL; i++) {
        for(let j=i+1; j< numL; j++) {
            if (nums[i]+nums[j] === target) {
                result[0] = i;
                result[1] = j;
                break loop;
            }
        }
    }
    return result;
};
