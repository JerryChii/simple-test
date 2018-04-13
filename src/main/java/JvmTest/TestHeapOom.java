package JvmTest;

/**
 * Created by jialin5 on 2016/11/30.
 */
import java.util.ArrayList;
import java.util.List;

public class TestHeapOom {

    private static class HeapOomObject {
    }

    public static void main(String[] args) throws InterruptedException {
        List<HeapOomObject> list = new ArrayList<HeapOomObject>();
        while (true) {
            list.add(new HeapOomObject());
            Thread.sleep(1);
        }
    }
}