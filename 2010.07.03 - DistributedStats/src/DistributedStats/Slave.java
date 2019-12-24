package DistributedStats;

public class Slave {
	private int[] dataset;
	
	public Slave(int[] init_dataset) {
		this.dataset = init_dataset;
	}
	
	public Pair<Integer, Integer> getSumAndCount() {
		int sum = 0;
		for(int elem : this.dataset) {
			sum += elem;
		}
		return new Pair<Integer, Integer>( sum, this.dataset.length );
	}
}
