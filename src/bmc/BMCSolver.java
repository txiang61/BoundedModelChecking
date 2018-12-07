package bmc;

import java.util.Set;

import com.microsoft.z3.*;

import bmc.BMCValue.ValueType;
import bmc.Constraint.Operade;

public class BMCSolver {

	public void solve(Set<Constraint> constraintSet) {
        System.out.println("-----Solving----");
        
        Context ctx = new Context();
        Solver s = ctx.mkSolver();
        for (Constraint c : constraintSet) {
            s.add(constructClause(ctx, c));
        }
        
        Status result = s.check();
        System.out.println("solver result: " + result);

        System.out.println("-----Solver ends----");
	}
	
	private BoolExpr constructClause(Context ctx, Constraint c) {
		Operade op = c.operade;
		Sort bvtr = getBitVecSort(c.right.getType());
		Sort bvtl = getBitVecSort(c.left.getType());
		switch (op) {
			case GREATERTHAN:
				
			    break;
			case EQUALTO:
				
				BitVecExpr r = ;
				BitVecExpr r = ;
				return ctx.mkEq(r, l);
			case NOTEQUALTO:
			    break;
			case LESSTHAN:
			    break;
			case GREATEROREQUALTO:
			    break;
			case LESSOREQUALTO:
			    break;
			default:
			    System.err.println("Unknown orignal type, abort!");
			    System.exit(1);
		}
	}
	
	private Sort getBitVecSort(Context ctx, ValueType type) {
		switch (type) {
			case TOP:
				return ctx.mkBitVecSort(64);
			case INTEGER:
				return ctx.mkBitVecSort(32);
			case SHORT:
				return ctx.mkBitVecSort(16);
			case BYTE:
				return ctx.mkBitVecSort(8);
			case BOTTOM:
				return null;
			default:
			    System.err.println("Unknown orignal type, abort!");
			    System.exit(1);
		}
		
		return null;
	}
}
