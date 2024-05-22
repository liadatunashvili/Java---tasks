package com.company;

public class Inner<T> implements Node<T> {

    private Node<T> left, right;
    private int lsize, rsize;

    public Inner(Node<T> left, Node<T> right, int lsize, int rsize) {
        this.left = left;
        this.right = right;
        this.lsize = lsize;
        this.rsize = rsize;
    }

    @Override
    public int size() {
        return lsize + rsize;
    }

    @Override
    public T get(int i) {
        int location = i + 1;
        if (location <= lsize) {
            return left.get(i);
        }
        else {
            return right.get(i - lsize);
        }
    }

    @Override
    public void update(int i, T x) {
        int location = i + 1;
        if (location <= lsize) {
            left.update(i,x);
        }
        else {
            right.update(i - lsize, x);
        }
    }

    @Override
    public Node<T> insert(int i, T x) {
        if (i < 0) {
            return insert(0, x);
        }
        else if (i >= size()) {
            return insert(size() - 1, x);
        }
        else {
            int location = i + 1;
            if (location <= lsize) {
                lsize++;
                left = left.insert(i,x);
            }
            else {
                rsize++;
                right = right.insert(i - lsize, x);
            }
            return this;
        }
    }
    @Override
    public Node<T> remove(int i) {
        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException();
        int location = i + 1;
        if (location <= lsize) {
            lsize--;
            left = left.remove(i);
        }
        else {
            rsize--;
            right = right.remove(i - lsize);
        }
        if (left instanceof Inner<T> lNode) {
            if (lNode.left == null) {
                left = lNode.right;
            }
            else if (lNode.right == null) {
                left = lNode.left;
            }
        }
        else if (right instanceof Inner<T> rNode) {
            if (rNode.left == null) {
                left = rNode.right;
            }
            else if (rNode.right == null) {
                left = rNode.left;
            }
        }
        return this;
    }
}