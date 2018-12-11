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
		BitVecExpr r;
		BitVecExpr l;
		if (c.right.getType() == ValueType.VARIABLE) {
			r = (BitVecExpr)ctx.mkConst(c.right.getName(), ctx.mkBitVecSort(c.right.getRange()));
		} else {
			r = (BitVecNum)ctx.mkBV(c.right.getConstantValue(), c.right.getRange());
		}
		
		if (c.left.getType() == ValueType.VARIABLE) {
			l = (BitVecExpr)ctx.mkConst(c.left.getName(), ctx.mkBitVecSort(c.left.getRange()));
		} else {
			l = (BitVecNum)ctx.mkBV(c.left.getConstantValue(), c.left.getRange());
		}
		
		switch (op) {
			case GREATERTHAN:
				return ctx.mkBVSGT(l, r);
			case EQUALTO:
				return ctx.mkEq(l, r);
			case NOTEQUALTO:
				return ctx.mkNot(ctx.mkEq(l, r));
			case LESSTHAN:
				return ctx.mkBVSLT(l, r);
			case GREATEROREQUALTO:
				return ctx.mkBVSGE(l, r);
			case LESSOREQUALTO:
				return ctx.mkBVSLE(l, r);
			default:
			    System.err.println("Unknown orignal type, abort!");
			    System.exit(1);
		}
		
		return null;
	}
}
