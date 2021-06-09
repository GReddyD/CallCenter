public class Main {
	public static void main(String[] args) {
		Atc atc = new Atc();

		Thread threadQueueCalls = new Thread(null, atc, "АТС");
		threadQueueCalls.setDaemon(true);
		threadQueueCalls.start();
		getThreadSleep();

		new Thread(null, new Operator(atc), "Оператор 1").start();
		new Thread(null, new Operator(atc), "Оператор 2").start();
		new Thread(null, new Operator(atc), "Оператор 3").start();
		new Thread(null, new Operator(atc), "Оператор 4").start();
		new Thread(null, new Operator(atc), "Оператор 5").start();
	}

	private static void getThreadSleep() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
