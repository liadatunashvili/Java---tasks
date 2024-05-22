package com.company;

public class Leaf<T> implements Node<T> {

    private T value;

    public Leaf(T value) {
        this.value = value;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public T get(int i) {
        if (i == 0) return value;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void update(int i, T x) {
        if (i == 0) value = x;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Node<T> insert(int i, T x) {
        if (i <= 0) {
            return new Inner<>(new Leaf<>(x), this, 1, 1);
        }
        else {
            return new Inner<>(this, new Leaf<>(x), 1, 1);
        }
    }

    @Override
    public Node<T> remove(int i) {
        if (i == 0) return null;
        throw new IndexOutOfBoundsException();
    }

}