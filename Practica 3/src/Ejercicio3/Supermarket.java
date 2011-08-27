package Ejercicio3;

public class Supermarket {

	SimpleAisle<Aisle> data = new SimpleAisle<Aisle>();

	public void simulation(int aisles, int arrivalProbability,
			int minServiceTime, int maxServiceTime, int simulationTime) {
		Prom idle = new Prom();
		int a, b;
		for (a = 0; a < aisles; a++) {
			data.add(new Aisle());
		}

		for (a = 0; a < simulationTime; a++) {
			if ((Math.random()) <= ((double) arrivalProbability / 100)) {
				Aisle aux = null;
				for (Aisle info : data) {
					if (aux == null) {
						aux = info;
					} else {
						if (aux.size() > info.size()) {
							aux = info;
						}
					}
				}
				aux.add((int) (Math.random()*minServiceTime)
						+ (maxServiceTime - minServiceTime));
			}
			for (Aisle info : data) {
				b = info.timePass();
				if(b == 0){
					idle.add(1);
				}else{
					idle.add(0);
				}
				System.out.println(info.timePass());
			}
			System.out.println("");
		}
		Prom operGen = new Prom();
		Prom elemsGen = new Prom();
		for(Aisle info: data){
			operGen.sumProm(info.getOper());
			elemsGen.sumProm(info.getElems());
		}
		System.out.println("Promedio Oscioso de los cajeros: " + idle.evaluate()*100);
		System.out.println("Promedio de Clientes en cola: " + elemsGen.evaluate());
		System.out.println("Promedio de Espera en cola: " + operGen.evaluate());
		System.out.println("Maximo Tiempo de Espera: " + operGen.getMax());
		System.out.println("Minimo Tiempo de Espera: "+ operGen.getMin());
	}

}
