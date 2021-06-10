public class Operator implements Runnable {
	final static int SLEEP = 1000;

	Atc atc;
	public Operator(Atc atc) {
		this.atc = atc;
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				if (!atc.queue.isEmpty()) {
					Long queue_value = atc.queue.poll();
					if (queue_value != null) {
						System.out.println(Thread.currentThread().getName() + " принимает вызов: " + queue_value);
						Thread.sleep(SLEEP);
					} else {
						System.out.println("Звонки закончились");
						break;
					}
				} else {
					System.out.println("Звонки закончились");
					break;
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}