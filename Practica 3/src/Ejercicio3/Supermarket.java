package Ejercicio3;

public class Supermarket {

	SimpleAisle<Aisle> data = new SimpleAisle<Aisle>();

	public void simulation(int aisles, int arrivalProbability,
			int minServiceTime, int maxServiceTime, int simulationTime) {
	
		int a;
		for (a = 0; a < aisles; a++) {
			data.add(new Aisle());
		}

		for (a = 0; a < simulationTime; a++) {
			if((Math.random())<(arrivalProbability/100)){
				Aisle aux= null; 
				for(Aisle info: data){
					if(aux == null){
						aux = info;
					}else{
						if(aux.size() > info.size()){
							aux = info;
						}
					}
				}
				aux.add((int)(Math.random()%minServiceTime)+(maxServiceTime-minServiceTime));
			}
			for(Aisle info: data){
				info.timePass();				
			}
		}
		for(Aisle info: data){
			
		}
	}
}
