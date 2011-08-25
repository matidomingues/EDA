package Ejercicio6;

public class RoundRobin {

	private Integer quantum = 10;
	long sTime;
	long tTime;
	long totalTime;
	long workTime;

	public RoundRobin(long totalTime, long workTime) {
		this.totalTime = totalTime;
		this.workTime = workTime;
	}

	public void roundRobin(RoundList<Integer> list) throws InterruptedException {
		Iterate<Integer> iter = list.iterator();
		Integer elem;
		tTime = System.currentTimeMillis();
		sTime = tTime;
		while ((tTime - System.currentTimeMillis()) < totalTime) {
			while (!iter.hasNext()) {
				System.out.println("No more Thread, waiting for more");
				Thread.sleep(quantum);
				if ((tTime - System.currentTimeMillis()) < totalTime) {
					if ((sTime - System.currentTimeMillis()) >= workTime) {
						iter.add((int) Math.random() % 50);
					}
				} else {
					break;
				}
			}
			if ((elem = iter.next()).compareTo(quantum) == 1) {
				System.out.println("Thread working, sleeping for: " + quantum);
				Thread.sleep(quantum);
				elem -= quantum;
			} else {
				System.out.println("Thread working, sleeping for: " + elem);
				Thread.sleep(elem);
				iter.remove();
			}
			if ((sTime - System.currentTimeMillis()) >= workTime) {
				System.out.println("Adding new Thread");
				iter.add((int) (Math.random() % 50));
			}
		}
		System.out.println("Simulation Finished");
	}
}
