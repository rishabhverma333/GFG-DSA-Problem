class Solution {
    public boolean isBipartite(int V, int[][] edges) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           adj.get(v).add(u);
           adj.get(u).add(v);
       }
       int[] arr=new int[V];
       for(int i=0;i<V;i++){
           if(arr[i]==0){
               if(!(bfs(i,arr,adj))) return false;
           }
       }
       return true;
    }
    boolean bfs(int src,int[] arr, ArrayList<ArrayList<Integer>> adj){
        arr[src]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while(q.size()>0){
            int pop=q.remove();
            int color=arr[pop];
            for(int ele:adj.get(pop)){
                if(arr[ele]==0){
                    q.add(ele);
                    if(arr[pop]==1) arr[ele]=2;
                    else arr[ele]=1;
                    //arr[ele]=3-color;
                }
                else if(arr[ele]==color) return false;
            }
        }
        return true;
    }
}