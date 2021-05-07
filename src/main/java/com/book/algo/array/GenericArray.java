package com.book.algo.array;

import java.util.ArrayList;

/**
 * 实现一个动态扩容的数组
 *
 * @param <T>
 */
public class GenericArray<T> {
    
    private T[] data;
    
    private int size;
    
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    
    public GenericArray() {
        this(10);
    }
    
    public int getCapacity() {
        return data.length;
    }
    
    public int count() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }
    
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }
    
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 特殊场景，查找的时候需要判断是否是null，选用不同的方法
     * @param e
     * @return
     */
    public int find(T e) {
        if (e == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 在下标位置插入元素
     * 1. 数组插入需要考虑扩容
     * 2. 扩容时机
     * 1）插入之前
     * 2）数组已满 （size == 数组长度）
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        checkIndexForAdd(index);
        //扩容
        if (size == data.length) {
            resize(size * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }
    
    public void addFirst(T e) {
        add(0, e);
    }
    
    public void addLast(T e) {
        add(size, e);
    }
    
    /**
     * 删除指定下标的元素， 删除以后需要缩容
     * 缩容的条件：
     * 1. 元素个数 == 数组长度的4分之一
     * 2. 元素个数大于1个
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        checkIndex(index);
        T temp = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        
        //缩容
        if (size == data.length / 4 && size / 2 != 0) {
            resize(data.length / 4);
        }
        return temp;
    }
    
    public T removeFirst() {
        return remove(0);
    }
    
    public T removeLast() {
        return remove(size - 1);
    }
    
    /**
     * 特殊场景，删除元素的时候需要判断是否是null
     *
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        remove(index);
    }
    
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >= 0 and index < size.");
        }
    }
    
    
    public void checkIndexForAdd(int index) {
        //插入的时候，支持在size 下标位置插入，会实时扩容
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("IndexForAdd failed! Require index >= 0 and index <= size.");
        }
    }
    
    private void resize(int length) {
        T[] newArray = (T[]) new Object[length];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }
    
    public static void main(String[] args) {
        GenericArray<Object> array = new GenericArray<>();
        array.add(0, null);
        array.removeElement(null);
        System.out.println(array);
        
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(0, null);
        objects.remove(null);
        System.out.println(objects);
    }
}
