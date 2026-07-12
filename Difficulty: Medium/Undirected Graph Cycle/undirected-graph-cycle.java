class Pair{
    int val;
    int parent;
    Pair(int val,int parent){
        this.val=val;
        this.parent=parent;
    }
}
class Solution {
    public boolean isCycle(int n, int[][] arr) {
        //edgeList are given convert in to adjList
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            int u=arr[i][0];
            int v=arr[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                if(bfs(i,visit,adj)) return true;
            }
        }
        return false;
    }
    boolean bfs(int src,boolean[] visit,ArrayList<ArrayList<Integer>> adj){
    visit[src]=true;
    Queue<Pair> q=new LinkedList<>();
    q.add(new Pair(src,-1));
    while(q.size()>0){
        Pair pop=q.remove();
        int val=pop.val;
        int parent=pop.parent;
        for(int ele:adj.get(val)){
            if(!visit[ele]){
                q.add(new Pair(ele,val));
                visit[ele]=true;
            }
            else if(ele!=parent) return true;
        }
    } 
    return false;
    }
}