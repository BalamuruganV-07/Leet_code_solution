-----------------------------(brute force)-------------------------------------------

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int arr[]=new int[m*n];
        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[index++]=matrix[i][j];
            }
        }
        for(int i=0;i<index;i++){
            for(int j=i+1;j<index;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr[k-1];
    }
}

-----------------------------------------(priority queue)------------------------------------
class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
            }
        }

        for (int i = 1; i < k; i++) {
            pq.poll();
        }

        return pq.poll();
    }
}
