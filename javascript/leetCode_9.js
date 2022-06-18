/**
 * @param {number} x
 * @return {boolean}
 */

// 9. Palindrome Number
// https://leetcode.com/problems/palindrome-number/
var isPalindrome = function(x) {
    if (x < 0) return false;
    const xArray = x.toString().split('');
    const xLength = xArray.length;
    for(let i=0; i<  xLength / 2; i++) {
        if (xArray[i] !== xArray[xLength - i -1]) return false;    
    }
    return true;  
};
