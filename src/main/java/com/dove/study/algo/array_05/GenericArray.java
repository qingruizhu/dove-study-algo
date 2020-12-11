package com.dove.study.algo.array_05;

/**
 * @Description: 实现一个支持动态扩容的数组
 * @Auther: qingruizhu
 * @Date: 2020/9/22 13:46
 */
public class GenericArray<T> {

    private T[] data;
    private int size;

    /**
     * 默认容量=10
     */
    public GenericArray() {
        this(10);
    }

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 元素的数量
     */
    public int size() {
        return size;
    }

    /**
     * 数组的容量
     */
    public int capacity() {
        return data.length;
    }

    /**
     * set
     */
    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("failed:set -> 索引越界");
        }
        data[index] = e;
    }

    /**
     * get
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("failed:get -> 索引越界");
        }
        return data[index];
    }

    /**
     * add
     */
    public void add(int index, T e) {
        //1.
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("failed:add -> 索引越界");
        }
        //2.是否需要扩容
        if (data.length == size) {
            //扩容两倍
            resize(data.length << 1);
        }

        //3. 添加时先移动最后面的数据 last_data = data[size-1]
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
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
     * 扩容/缩容
     *
     * @param capacity
     */
    public void resize(int capacity) {
        if (capacity < size) {
            throw new IllegalArgumentException("failed:resize -> 扩容量小于数据量");
        }

        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 移除
     */
    public T remove(int index) {
        //1.
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("failed:remove -> 索引越界");
        }
        T tem = data[index];
        //2.
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        //3.缩容
        if (size == data.length << 2 && data.length << 1 != 0) {
            resize(data.length << 1);
        }
        //4.
        data[size - 1] = null;
        size--;
        return tem;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * delete
     */
    public void delete(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * contains
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * find
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    public static void main(String[] args) {
        GenericArray<Integer> test = new GenericArray<>();
        test.add(0, 10);
        test.add(1, 11);
        test.add(2, 12);
        System.out.println(test);

    }

}
