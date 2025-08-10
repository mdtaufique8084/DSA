class LRUCache {
    public class Node{
        int key,val;
        Node next,prev;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    private HashMap<Integer,Node> cache;
    private Node head,tail;
    private int n;
    public LRUCache(int capacity) {
        n=capacity;
        cache=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addNewNode(node);
    }
    private void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void addNewNode(Node node){
        node.next=head.next;
        node.prev=head;
        node.next.prev=node;
        head.next=node;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node=cache.get(key);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int val) {
        if(cache.containsKey(key)){
            Node node=cache.get(key);
            node.val=val;
            moveToHead(node);
        }
        else{
            if(cache.size()==n){
                Node lru=tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            Node newNode=new Node(key,val);
            cache.put(key,newNode);
            addNewNode(newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */