package com.book.algo.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 基于数组的LRU 缓存淘汰策略
 *
 * @param <T>
 */
public class LRUBasedArray<T> {
    
    private static final int DEFAULT_CAPACITY = (1 << 3);
    
    private int capacity;
    
    private int count;
    
    private T[] value;
    
    private Map<T, Integer> holder;
    
    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }
    
    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.value = (T[]) new Object[capacity];
        holder = new HashMap<>(capacity);
    }
    
    private T offer(T obj) {
        Integer index = holder.get(obj);
        if (Objects.isNull(index)) {
            if (isFull()) {
                //缓存已满，删除并缓存头部
                removeAndCache(obj);
            } else {
                //缓存未满，缓存头部
                cache(obj, count);
            }
        } else {
            //更新位置，缓存在头部
            update(obj, index);
        }
        return obj;
    }
    
    /**
     * 删除尾部节点并缓存到头部
     *
     * @param obj
     */
    public void removeAndCache(T obj) {
        T t = value[--count];
        holder.remove(t);
        cache(obj, count);
    }
    
    
    /**
     * 缓存到头部
     *
     * @param obj
     * @param end 数组右移动的边界
     */
    public void cache(T obj, int end) {
        //向后移动元素
        rightShift(end);
        value[0] = obj;
        holder.put(obj, 0);
        count++;
    }
    
    /**
     * 需要移动的最后一个元素下标
     *
     * @param end
     */
    public void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }
    
    /**
     * 更新缓存的位置，缓存到头部
     *
     * @param obj
     */
    public void update(T obj, int end) {
        rightShift(end);
        value[0] = obj;
        holder.put(obj, 0);
    }
    
    /**
     * 判断缓存是否已满
     *
     * @return
     */
    private boolean isFull() {
        return count == capacity;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (i != count - 1) {
                sb.append(value[i] + ",");
            } else {
                sb.append(value[i]);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int num = (1 << 3);
        System.out.println(num);

        testDefaultConstructor();
//        testSpecialConstructor();
    }
    
    
    public static void testDefaultConstructor() {
        LRUBasedArray<Integer> array = new LRUBasedArray<>();
        array.offer(1);
        array.offer(2);
        array.offer(3);
        array.offer(4);
        array.offer(5);
        array.offer(6);
        array.offer(7);
        array.offer(8);
        array.offer(9);
        array.offer(2);
        System.out.println(array);
    }
    
    public static void testSpecialConstructor() {
        LRUBasedArray<Integer> array = new LRUBasedArray<>(4);
        array.offer(1);
        array.offer(2);
        array.offer(3);
        array.offer(4);
        array.offer(5);
        array.offer(6);
        array.offer(7);
        array.offer(8);
        array.offer(9);
        array.offer(null);
        array.offer(null);
        System.out.println(array);
    }
    
}
