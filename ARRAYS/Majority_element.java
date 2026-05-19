class Solution {
    int majorityElement(int arr[]) {
         int ans=-1;
        HashMap<Integer,Integer>map=new HashMap<>();
        int need_ele=arr.length/2;
        int n=arr.length;
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
            if(map.get(num)>need_ele){
                ans= num;
            }
        }
    return ans;
    }
}
/*In this In this problem we want to find a majority element in an array and want to return 
it so in order to do that I used a hash map hashmap uses to store the frequency also
I used the hashmap and checked condition that if any element frequency is exceeding 
the half of the length of the array if it is then that is the element we are searching for 
so I just used Hashmap and count all the frequencies and checking if any element frequencies increasing half of the length of the array and if it is adjusted on that element that's simple*/
