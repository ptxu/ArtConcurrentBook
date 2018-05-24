import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Copyright: Copyright (c) 2017 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2017年9月13日 上午10:32:45
 * @version V1.0
 */

/**
 * @ClassName: AtomicIntegerFiledUpdaterDemo
 * @Description: TODO
 * @author dell
 * @date 2017年9月13日 上午10:32:45
 *
 */
public class AtomicIntegerFiledUpdaterDemo {

    class DemoData {
        public volatile int value1 = 1;
        volatile int value2 = 2;
        protected volatile int value3 = 3;
        volatile int value4 = 4;

    }

    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName) {
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }

    void doit() {
        DemoData data = new DemoData();
        System.out.println("1 ==> " + getUpdater("value1").getAndSet(data, 10));
        System.out.println("3 ==> " + getUpdater("value2").incrementAndGet(data));
        System.out.println("2 ==> " + getUpdater("value3").decrementAndGet(data));
        System.out.println("true ==> " + getUpdater("value4").compareAndSet(data, 4, 5));
    }

    public static void main(String[] args) {
        AtomicIntegerFiledUpdaterDemo demo = new AtomicIntegerFiledUpdaterDemo();
        demo.doit();
    }
}
