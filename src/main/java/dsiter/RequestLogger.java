package dsiter;

public class RequestLogger {

    private static ThreadLocal<Timer> tlt = ThreadLocal.withInitial(() -> new Timer());

    public static void log(String message) {
        Timer t = tlt.get();
        t.log(message);
    }

    private static class Timer {
        private long startTime;

        public Timer() {
            System.out.println("New Timer");
            startTime = System.currentTimeMillis();
        }

        public void log(String message) {
            long now = System.currentTimeMillis();
            double elapsedSec = (now - startTime) / 1000D;
            startTime = now;
            System.out.println(message + ": " + elapsedSec + " sec");
        }
    }
}
