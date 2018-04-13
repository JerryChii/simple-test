package Thread;

class SyncThread implements Runnable {
   private static int count;

   public SyncThread() {
      count = 0;
   }

   public  void run() {
      synchronized(this) {
         for (int i = 0; i < 100; i++) {
            try {
               System.out.println(Thread.currentThread().getName() + ":" + (count++));
               Thread.sleep(1);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }

   public int getCount() {
      return count;
   }
}