import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Atc implements Runnable {

	ConcurrentLinkedQueue<Long> queue = new ConcurrentLinkedQueue<>();

	final static int SLEEP_TIME = 1;
	final static int CALLS_PER_SECOND = 60;
	final static int ITERATION_IN_DAY = 1;

	Random random = new Random();

	@Override
	public void run() {
		try {
			int count = 0;
			while (true) {
				if (count < ITERATION_IN_DAY) {
					for (int i = 0; i < CALLS_PER_SECOND; i++) {
						long numbers = (random.nextInt(1000000)) + 89680000000L;
						queue.add(numbers);
						count++;
						Thread.sleep(SLEEP_TIME);
					}
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
