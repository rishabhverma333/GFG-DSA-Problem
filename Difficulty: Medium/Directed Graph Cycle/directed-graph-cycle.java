class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        //in degree
        int[] arr= new int[V];
        for(int i=0;i<V;i++){
            for(int ele:adj.get(i)){
                arr[ele]+=1;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(arr[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> list= new ArrayList<>();
        while(q.size()>0){
            int top=q.remove();
            list.add(top);
            for(int ele:adj.get(top)){
                arr[ele]-=1;
                if(arr[ele]==0){
                    q.add(ele);
                }
            }
        }
        if(list.size()==V) return false;
        return true;
    }
}