package com.springbootinit.algorithm;

/**
 * @Classname PrimeNumber
 * @Description 判断1000000之间有多少个素数(质数)，并输出所有素数。
 * 程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数的平方根)，如果能被整除， 则表明此数不是素数，反之是素数。
 * @Date 2019/11/6 21:23
 * @Author jiaohongtao
 */
public class PrimeNumber {

    private static void primeNumber(int n) {
        int count1 = 0, count2 = 0;
        for (int i = 0; i <= n; i++) {
            // 每一个数一个个接受检验是否为素数
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j != 0) {
                    //不能被整除累计一次
                    count1++;
                }
            }
            // 转为int的类型
            int num = (int) Math.sqrt(i);
            //如果累计次数num - 1个数相等则为素数
            if (count1 == (num - 1)) {
                System.out.println("素数:" + i);
                count2++;
            }
            // 统计素数个数
            count1 = 0;
        }
        System.out.println(count2);
    }

    public static void main(String[] args) {
        primeNumber(1000000);
    }
}
