import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BinaryTree<K extends Comparable<K>,E> implements Map<K,E> {

    private class Node<K extends Comparable<K>,E>{

        private K key;
        private E value;
        private Node leftChild;
        private Node rightChild;

        public Node(K key, E value){
            this.key = key;
            this.value = value;
        }

        public boolean isUnique(K newKey){
            boolean check = true;
            if (key.equals(newKey)) return false;
            if (leftChild != null)
                check = leftChild.isUnique(newKey);
            if (rightChild != null)
                check = rightChild.isUnique(newKey);
            return check;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<K,E> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<K,E> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<K,E> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<K,E> rightChild) {
            this.rightChild = rightChild;
        }

        public void add(Node<K,E> newNode){
            if (this.key.compareTo(newNode.key) > 0){
                if (this.rightChild == null) {
                    this.rightChild = newNode;
                    return;
                } else
                    this.rightChild.add(newNode);
            } else if (this.key.compareTo(newNode.key) < 0){
                if (this.leftChild == null) {
                    this.leftChild = newNode;
                    return;
                } else
                    this.leftChild.add(newNode);
            }
            return;
        }

        public int childrenNumber(int counter){
            if (leftChild != null)
                counter = leftChild.childrenNumber(counter);
             if (rightChild != null)
                counter = rightChild.childrenNumber(counter);
            return counter + 1;
        }

        public void remove(Object key){
            if ((this.key.compareTo((K)key) > 0) && (rightChild != null)){
                if (rightChild.key.compareTo((K)key) == 0){
                    if (rightChild.rightChild == null && rightChild.leftChild == null) rightChild = null;
                    else if (rightChild.rightChild == null && rightChild.leftChild != null) rightChild = rightChild.leftChild;
                    else if (rightChild.rightChild != null && rightChild.leftChild == null) rightChild = rightChild.rightChild;
                    else if (rightChild.rightChild != null && rightChild.leftChild != null){
                        Node<K,E> currNode = rightChild.rightChild.leftChild;
                        Node<K,E> father = rightChild.rightChild;
                        heir(currNode, father);
                        father.leftChild = currNode.rightChild;
                        rightChild = currNode;
                    }
                } else rightChild.remove(key);
            }else if ((this.key.compareTo((K)key) <= -1) && (leftChild != null)){
                if (leftChild.key.compareTo((K)key) == 0){
                    if (leftChild.rightChild == null && leftChild.leftChild == null) leftChild = null;
                    else if (leftChild.rightChild == null && leftChild.leftChild != null) leftChild= leftChild.leftChild;
                    else if (leftChild.rightChild != null && leftChild.leftChild == null) leftChild= leftChild.rightChild;
                    else if (leftChild.rightChild != null && leftChild.leftChild != null){
                        Node<K,E> currNode = leftChild.rightChild.leftChild;
                        Node<K,E> father = leftChild.rightChild;
                        heir(currNode, father);
                        father.leftChild = currNode.rightChild;
                        leftChild = currNode;
                    }
                } else leftChild.remove(key);
            }
        }

        private void heir(Node<K,E> currNode, Node<K,E> father){
            if (currNode.leftChild != null) {
                father = currNode;
                currNode = currNode.leftChild;
                heir(currNode, father);
            }
            else return;
        }

        @Override
        public String toString() {
            String str = "";
            if (leftChild != null)
                str += " " + leftChild.toString();
            if (rightChild != null)
                str += " " + rightChild.toString();
            return " |key: " + key.toString() + "  value: " + value.toString() + "|" + '\n' + str;
        }
    }

    private Node<K,E> root;
    private int size;

    public BinaryTree(K key, E value){
        root = new Node<>(key, value);
    }

    public BinaryTree(){}

    @Override
    public int size() {
        if ( root == null) return 0;
        return root.childrenNumber(0);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean containsKey(Object key) {
        if (root.key.getClass() != key.getClass()) return false;
        return root.isUnique((K)key);
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public E get(Object key) {
        return null;
    }

    @Override
    public E put(K key, E value) {
        Node newNode = new Node(key, value);
        if (root == null) {root = newNode; return value;}
        else {
            try{
                if (!root.isUnique(key)) throw new Exception("need Unique key"); // or return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            root.add(newNode);
        }

        return value;
    }

    @Override
    public E remove(Object key) {
        if (root.key.compareTo((K)key) == 0) root = null;
        root.remove(key);
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends E> m) {

    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<E> values() {
        return null;
    }

    @Override
    public Set<Entry<K, E>> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
