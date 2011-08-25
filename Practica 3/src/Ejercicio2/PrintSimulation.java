package Ejercicio2;

public class PrintSimulation {
	public static void simulation(int simulationTime, int minServiceTime,
			int maxServiceTime, int arrivalProbability) {

		int currentPrint = 0;
		Probability works = new Probability();
		Probability waitTime = new Probability();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < simulationTime; i++) {
			if (currentPrint == 0) {
				if (!stack.isEmpty()) {
					currentPrint = stack.pop();
					works.add(currentPrint);
					
				}
			}
			if (currentPrint > 0) {
				currentPrint--;
			}
			if ((Math.random()) <= ((double) arrivalProbability) / 100) {
				stack.push((int) (Math.random() % minServiceTime)
						+ (maxServiceTime - minServiceTime));
			}
			waitTime.add(stack.size());
		}
		System.out.println("Cantidad de trabajos atendidos: " + works.num());
		System.out.println("Promedio de tiempo: " + works.evaluate());
		System.out.println("Cantidad de elementos en cola: " + stack.size());
		System.out.println("Promedio de elementos en cola: "
				+ waitTime.evaluate());
	}
}
