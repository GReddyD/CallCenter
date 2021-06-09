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
					System.out.println(Thread.currentThread().getName() + " принимает вызов: " + atc.queue.poll());
					Thread.sleep(SLEEP);
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