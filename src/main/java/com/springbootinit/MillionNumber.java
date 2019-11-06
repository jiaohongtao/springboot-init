package com.springbootinit;

import java.util.Random;
import java.util.TreeSet;

/*
 * 求100万个数中最大的100个数
 *  分析:
 *   1.采用随机数的方式产生100,0000个数
 *   2.用二叉树来存储数据,向其中存100个数,
 *   3.在循环里继续产生随机数,把这个数与树存储的第一个数比较,如果新数更大,删除树的第一个数,存储新数
 *   4.有个bug,要优化,按照默认的比较,树里面有的数就不添加了,需要重写compare方法,避免忽略掉重复的数
 * @2015.10.27
 */
public class MillionNumber {

    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        TreeSet<Integer> tree = new TreeSet<>( //重写步骤:导包,创建Comparator<>对象,重写compare方法,确定返回值
                // @override
                (a1, a2) -> {
                    return a1 > a2 ? 1 : -1; //大于就返回1,添加在右边,小于和等于返回-1,添加在左边
                });

        Random rand = new Random(); // 创建Random对象
        long startTime = System.currentTimeMillis(); // 计时
        int i = 0;
        while (i < 100) {
            tree.add(rand.nextInt()); // 先添加100个数
            i++;
        }
        int temp;
        while (i++ < 10000000) { // 测试1千万个数
            temp = rand.nextInt();
            if (temp > tree.first()) { // temp与tree的第一个数比较
                tree.pollFirst(); // 删除第一个
                tree.add(temp); // 添加temp到树
            }
        }
        System.out.println(tree);
        System.out.println(tree.size());
        System.out.println("\nTest1 runtime :" + (System.currentTimeMillis() - startTime) + "ms");
    }
}