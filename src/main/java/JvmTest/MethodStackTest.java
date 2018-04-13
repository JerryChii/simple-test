package JvmTest;

/**
 * Created by jialin5 on 2016/11/30.
 */
public class MethodStackTest {

    private int stackLength = 0;

    public void stackOverflow() throws InterruptedException {
        ++stackLength;
        Thread.sleep(1);
        stackOverflow();
    }

    public static void main(String[] args) throws Throwable {
        MethodStackTest methodStackTest = new MethodStackTest();

        try {
            methodStackTest.stackOverflow();
        } catch (Throwable e) {
            System.out.println("stack length: " + methodStackTest.stackLength);
            throw e;
        }
    }
}
