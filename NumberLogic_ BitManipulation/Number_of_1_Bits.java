class Solution{
    public int hammingWeight(int n){
        int count=0;//variable to store number of 1 bits
        //loops runs until n becomes 0
        while(n!=0){
            count=count+(n&1); //(n&1)checks last bit.
            //   if last bit=1 add it into count 
            n>>>=1;//shift the bits to thr right by 1 position.this removes the last checked bit
        
        }
        return count;    //return total number of 1 bits
    }
}
