package com.dove.study.likou;

/**
 * @Description: <p>
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 * <p>
 * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 * <p>
 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 * <p>
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fair-candy-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: qingruizhu
 * @Date: 2021/2/1 上午11:23
 */
public class Solution6 {
    public static void main(String[] args) {

        int[] a = {1, 1}, b = {2, 2};
        int[] ints = fairCandySwap(a, b);
        System.out.println(ints.toString());


    }


    public static int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
        }
        int bina = (sumA + sumB) / 2;

        if (sumA > bina) {
            int cha = sumA - bina;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (A[i] == (B[j] + cha)) {
                        return new int[]{A[i], B[j]};
                    }
                }
            }
        } else if (sumB > bina) {
            int cha = sumB - bina;
            for (int i = 0; i < B.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (B[i] == (A[j] + cha)) {
                        return new int[]{A[j], B[i]};
                    }
                }
            }
        }
        return new int[]{A[0], B[0]};
    }


}
