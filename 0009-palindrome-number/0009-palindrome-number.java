class Solution {
  public boolean isPalindrome(int num){
   if(num < 0) return  false; 
   int reversed = 0, original = num;
   while(num != 0) { // reversed integer is stored in variable
        reversed = reversed * 10 + (num % 10); //multiply reversed by 10 then add the remainder so it gets stored at next decimal place.
        num  /= 10;  //the last digit is removed from num after division by 10.
    }
    // palindrome if original and reversed are equal
    return original == reversed;
}
}