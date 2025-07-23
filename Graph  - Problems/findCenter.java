import java.util.*;
// class Garph{
//     int data;
//     Graph right,left;
//     public normalgraph(int r, int l ){
//         this.right = r; 
//         this.left = l ; 
//     }
// }
 class Solution {

    public int findCenter(int[][] edges) {
        
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
         {
    return edges[0][0];
        } 
        else 
        {
    return edges[0][1];
        }
    }
}
