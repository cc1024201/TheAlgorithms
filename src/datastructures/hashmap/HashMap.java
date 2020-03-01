package datastructures.hashmap;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName HashMap.java
 * @Description TODO
 * @createTime 2020-03-01 19:11
 */
class HashMap {
    private int hsize;
    private LinkedList[] buckets;
    public HashMap(int hsize){
        buckets = new LinkedList[hsize];
        for(int i=0; i<hsize; i++){
            buckets[i] = new LinkedList();
        }
        this.hsize = hsize;
    }
    public int hashing(int key){
        int hash = key % hsize;
        if(hash < 0){
            hash += hsize;
        }
        return hash;
    }
    public void insertHash(int key){
        int hash = hashing(key);
        buckets[hash].insert(key);
    }
    public void deleteHash(int key){
        int hash = hashing(key);
        buckets[hash].delete(key);
    }
    public void displayHashtable() {
        for (int i = 0; i < hsize; i++) {
            System.out.printf("Bucket %d :", i);
            buckets[i].display();
        }
    }
}
