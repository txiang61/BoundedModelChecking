package bmc;

import java.util.Objects;

import org.checkerframework.dataflow.analysis.AbstractValue;

public class BMCValue implements AbstractValue<BMCValue> {

	enum ValueType {
        VARIABLE, CONSTANT
    }
	
	private ValueType type;
	private Integer value;
	private String name;
	private int range;
	
	public BMCValue(ValueType type, String name, int range) {
        this.type = type;
        this.value = null;
        this.name = name;
        this.range = range;
    }
	
	public BMCValue(ValueType type, Integer constant, int range) {
        this.value = constant;
        this.type = ValueType.CONSTANT;
        this.name = constant.toString();
        this.range = range;
    }
	
    public Integer getConstantValue() {
        assert type == ValueType.CONSTANT;
        return value;
    }
    
    public String getName() {
        return name;
    }
    
    public ValueType getType() {
        return type;
    }
    
    public int getRange() {
        return range;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BMCValue)) {
            return false;
        }
        return type == ((BMCValue) obj).type && Objects.equals(value,
                ((BMCValue) obj).value) && Objects.equals(name, ((BMCValue) obj).name);
    }

    @Override
    public String toString(){
    	if (type == ValueType.CONSTANT) {
    		return value.toString();
    	} else {
    		return name;
    	}
    }

	@Override
	public BMCValue leastUpperBound(BMCValue arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
