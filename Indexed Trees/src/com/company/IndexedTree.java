package com.company;

import java.util.Iterator;

public class IndexedTree<T> implements Iterable<T> {

    private Node<T> tree;

    public int size() {
        return tree != null ? tree.size() : 0;
    }

    public T get(int i) {
        return tree != null ? tree.get(i) : null;
    }

    public void update(int i, T x) {
        if (tree != null) {
            tree.update(i, x);
        }
    }

    public void insert(int i, T x) {
        if (tree == null) {
            tree = new Leaf<>(x);
        }
        else {
            tree = tree.insert(i, x);
        }
    }

    public void remove(int i) {
        if (tree != null) {
            tree = tree.remove(i);
        }
        if (size() == 0) {
            tree = null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size();
            }

            @Override
            public T next() {
                return get(i++);
            }

        };
    }
}

class Main {

    public static void main(String[] arr) {
        IndexedTree<String> t = new IndexedTree<String>();
        for (String s : arr) t.insert(0, s);
        var n = t.size();
        System.out.println(n);
        for (String s : t) {
            System.out.println(s);
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(t.get(i));
            t.remove(i);
        }
        System.out.println(t.size());
    }
}