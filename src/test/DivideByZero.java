package test;

public class DivideByZero {
	public int foo(int y) {
        int x = 0;
        int z = 0;
        if (y == 1) {
        	x = 1;
        } else {
        	z = 1;
        }
        return 10/(x-z);
    }
}
