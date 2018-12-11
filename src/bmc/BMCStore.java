package bmc;

import java.util.HashMap;
import java.util.Map;

import org.checkerframework.dataflow.analysis.FlowExpressions.Receiver;
import org.checkerframework.dataflow.analysis.Store;
import org.checkerframework.dataflow.cfg.CFGVisualizer;
import org.checkerframework.dataflow.cfg.node.Node;

public class BMCStore implements Store<BMCStore> {

    /**
     * Map of Node to its SymbolicValue
     */
    Map<Node, BMCValue> nodeToValueMapping;
    
    public BMCStore() {
        this.nodeToValueMapping = new HashMap<Node, BMCValue>();
    }
    
    public BMCStore(HashMap<Node, BMCValue> outSourceMapping) {
        this.nodeToValueMapping = outSourceMapping;
    }
    
	@Override
	public boolean canAlias(Receiver arg0, Receiver arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BMCStore copy() {
		return new BMCStore(new HashMap<>(nodeToValueMapping));
	}

	@Override
	public BMCStore leastUpperBound(BMCStore arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void visualize(CFGVisualizer<?, BMCStore, ?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BMCStore widenedUpperBound(BMCStore arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
