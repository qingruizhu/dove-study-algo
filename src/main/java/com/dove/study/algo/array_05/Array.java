package com.dove.study.algo.array_05;

/**
 * @Description: 实现一个大小固定的有序数组，支持动态增删改操作
 * @Auther: qingruizhu
 * @Date: 2020/9/22 15:41
 */
public class Array {

    private int[] data;
    // 数组的大小
    private int n;
    // 数据的大小
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
        this.n = capacity;
        this.size = 0;
    }

    /**
     * insert
     */
    public boolean insert(int index, int value) {
        if (size == n) {
            System.out.println("数据已满");
            return false;
        }
        if (index < 0 || index > size) {
            System.out.println("插入位置非法");
            return false;
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
        return true;
    }

    /**
     * delete
     */
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("索引越界");
            return false;
        }
        for (int i = index; i < size; i++) {
            data[index] = data[index + 1];
        }
        size--;
        return true;
    }

    /**
     * update
     */

    public boolean update(int index, int replace) {
        if (index < 0 || index >= size) {
            System.out.println("索引越界");
            return false;
        }
        data[index] = replace;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < size; ++i) {//bug
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.insert(0, 10);
        array.insert(1, 11);
        array.insert(2, 12);
        array.insert(3, 13);
        array.printAll();

    }

}
