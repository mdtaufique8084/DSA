class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int[] segTree=new int[4*n];

        buildSegTree(0,0,n-1,baskets,segTree); // building segTree
        int unplaced=0;
        for(int fruit:fruits){
            if(!canBePlaced(0,0,n-1,segTree,fruit)){ // if canNot be placed
                unplaced++;
            }
        }
        return unplaced;
    }
    private void buildSegTree(int i,int l,int r,int[] baskets,int[] segTree){
        if(l==r){
            segTree[i]=baskets[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildSegTree(2*i+1,l,mid,baskets,segTree);
        buildSegTree(2*i+2,mid+1,r,baskets,segTree);
        segTree[i]=Math.max(segTree[2*i+1],segTree[2*i+2]);
    }
    private boolean canBePlaced(int i,int l,int r,int[] segTree,int fruit){
        if(segTree[i]<fruit){
            return false;
        }
        if(l==r){
            segTree[i]=-1;
            return true;
        }
        int mid=l+(r-l)/2;
        boolean placed=false;
        if(segTree[2*i+1]>=fruit){ // left range querry
            placed=canBePlaced(2*i+1,l,mid,segTree,fruit);
        }
        else{ // right range query
            placed=canBePlaced(2*i+2,mid+1,r,segTree,fruit);
        }
        segTree[i]=Math.max(segTree[2*i+1],segTree[2*i+2]);
        return placed;
    }
}