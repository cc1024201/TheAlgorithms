package datastructures.heaps;

/**
 * @author Cc.
 * @version 1.0.0
 * @ClassName HeapElement.java
 * @Description TODO
 * @createTime 2020-02-24 21:06
 */
public class HeapElement {
    private final double key;
    private final Object aditionalInfo;

    public HeapElement(double key, Object aditionalInfo) {
        this.key = key;
        this.aditionalInfo = aditionalInfo;
    }

    public HeapElement(int key, Object aditionalInfo) {
        this.key = key;
        this.aditionalInfo = aditionalInfo;
    }

    public HeapElement(Integer key, Object aditionalInfo) {
        this.key = key;
        this.aditionalInfo = aditionalInfo;
    }

    public HeapElement(Double key, Object aditionalInfo) {
        this.key = key;
        this.aditionalInfo = aditionalInfo;
    }

    public HeapElement(double key) {
        this.key = key;
        this.aditionalInfo = null;
    }

    public HeapElement(int key) {
        this.key = key;
        this.aditionalInfo = null;
    }

    public HeapElement(Double key) {
        this.key = key;
        this.aditionalInfo = null;
    }

    public HeapElement(Integer key) {
        this.key = key;
        this.aditionalInfo = null;
    }

    public Object getInfo() {
        return aditionalInfo;
    }

    public double getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "HeapElement{" +
                "key=" + key +
                ", aditionalInfo=" + aditionalInfo.toString() +
                '}';
    }

    public boolean equals(HeapElement otherHeapelement) {
        return (this.key == otherHeapelement.key) && (this.aditionalInfo.equals(otherHeapelement.aditionalInfo));
    }
}
