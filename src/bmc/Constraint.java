package bmc;

public class Constraint {
	
	public enum Operade {
        GREATERTHAN, EQUALTO, LESSTHAN, NOTEQUALTO, GREATEROREQUALTO, LESSOREQUALTO;
    }
	
	Operade operade;
	BMCValue left;
	BMCValue right;
	
	public Constraint(Operade op, BMCValue left, BMCValue right) {
		this.operade = op;
		this.left = left;
        this.right = right;
    }
}
