package com.magese;

/**
 * <p>1115. 交替打印 FooBar</p>
 * <p><a href="https://leetcode.cn/problems/print-foobar-alternately/"></a></p>
 * <p>给你一个类：</p>
 * <code>
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 * </code>
 * <p/>
 * <code>
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * </code>
 * <p/>
 * <p>两个不同的线程将会共用一个 FooBar 实例：</p>
 * <p>线程 A 将会调用 foo() 方法，而</p>
 * <p>线程 B 将会调用 bar() 方法</p>
 * <p>请设计修改程序，以确保 "foobar" 被输出 n 次。</p>
 * <p/>
 * <p>示例 1：</p>
 * <p>输入：n = 1</p>
 * <p>输出："foobar"</p>
 * <p>解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。</p>
 * <p/>
 * <p>示例 2：</p>
 * <p>输入：n = 2</p>
 * <p>输出："foobarfoobar"</p>
 * <p>解释："foobar" 将被输出两次。</p>
 * <p/>
 * <p>提示：</p>
 * <p>1 <= n <= 1000</p>
 */
public class PrintFoobarAlternately {

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        FooBar fooBar = new FooBar(n);
        Runnable printFoo = () -> System.out.println(Thread.currentThread().getName() + ":foo");
        Runnable printBar = () -> System.out.println(Thread.currentThread().getName() + ":bar");

        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
    }


    private static class FooBar {
        private final int n;
        private volatile boolean flag = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (!flag) {
                    Thread.yield();
                }

                if (flag) {
                    printFoo.run();
                    flag = false;
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while (flag) {
                    Thread.yield();
                }

                if (!flag) {
                    printBar.run();
                    flag = true;
                }
            }
        }
    }
}
