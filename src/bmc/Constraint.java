package bmc;

public class Constraint {
	
	public enum Operade {
        GREATERTHAN, EQUALTO, LESSTHAN, NOTEQUALTO, GREATEROREQUALTO, LESSOREQUALTO;
    }
	
	Operade operade;
	SymbolicValue left;
	SymbolicValue right;
	
	public Constraint(Operade op, SymbolicValue left, SymbolicValue right) {
		this.operade = op;
		this.left = left;
        this.right = right;
    }
}
