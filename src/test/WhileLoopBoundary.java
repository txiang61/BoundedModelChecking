package test;

public class WhileLoopBoundary {
	public void main(int x) {
		int counter = 0;
		while(x % 47 == 42){
			counter++;
			x = (1019357 * x + 30129) % (1 << 17);
		}
		
		assert(counter <= 5);
		assert(counter >= 0);
	}
}
