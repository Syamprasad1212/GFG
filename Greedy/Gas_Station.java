class Solution {
    public int startStation(int[] gas, int[] cost) {
      int n=gas.length,totalgas=0,totalcost=0;
        for(int num : gas){
            totalgas+=num;
        }

        for(int num : cost){
            totalcost+=num;
        }

        if(totalgas<totalcost) return -1;
        int start=0,tank=0;
        for(int i=0;i<n;i++){
            tank+=gas[i]-cost[i];
            if(tank<0){
                start=i+1;
                tank=0;
            }
        }
        return start;
    }
}

/*When I first looked at this problem, my initial thought was to treat it as a circular traversal problem. The goal is to find a starting gas station from which I can travel around the entire circle and come back to the same station without ever running out of gas.

A straightforward (brute-force) approach would be to try every station as the starting point and simulate the entire journey. While this works, it takes O(n²) time.

To optimize it, I used a greedy observation.

First, I calculate the total amount of gas and the total travel cost. If the total gas is less than the total cost, completing the circuit is impossible, so I immediately return -1.

Next, I traverse the array only once while maintaining two variables:

tank → the current amount of gas available.
start → the current candidate starting station.

At every station, I update the tank using:

tank += gas[i] - cost[i]

If the tank becomes negative, it means I cannot reach the next station from my current starting point. More importantly, none of the stations between the current starting point and the failure point can be a valid starting station either. This is the greedy observation that allows us to skip all those stations.

So, instead of checking every station individually, I directly move the starting point to i + 1 and reset the tank to 0.

I continue this process until the end of the array. Since we already know the total gas is sufficient, the final value of start will be the only valid starting station from which the entire circuit can be completed.

Why is this Greedy?

Whenever the current starting point fails, I greedily discard all starting stations up to that failure point because they can never produce a valid solution. This allows me to solve the problem in a single traversal instead of trying every possible starting station.

Time Complexity
O(n)
One traversal to calculate the total gas and total cost.
One traversal to find the valid starting station.
Space Complexity
O(1)

Only a few extra variables are used.*/
