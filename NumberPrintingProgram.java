package FinalOOPLab;
public class NumberPrintingProgram {

    private static final int NUM_THREADS = 3;
    private static final int NUM_PRINTS_PER_THREAD = 10 / NUM_THREADS; //3

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            int start = i * NUM_PRINTS_PER_THREAD + 1; //1, 4, 7
            int end = start + NUM_PRINTS_PER_THREAD - 1;//3, 6, 5
            threads[i] = new Thread(new NumberPrinter(start, end));
            threads[i].start();
            try {
                threads[i].join(); // Ensure that each thread finishes before the next one starts
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class NumberPrinter implements Runnable {
        private final int start;
        private final int end;

        public NumberPrinter(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
