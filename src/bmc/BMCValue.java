package bmc;

import java.util.Objects;

public class BMCValue {

	enum ValueType {
        TOP, LONG, INTEGER, BYTE, SHORT, CONSTANT, BOTTOM
    }
	
	private ValueType type;
	private Integer value;
	private String name;
	
	public BMCValue(ValueType type, String name) {
        this.type = type;
        this.value = null;
        this.name = name;
    }
	
	public BMCValue(ValueType type, Integer constant) {
        this.value = constant;
        this.type = ValueType.CONSTANT;
        this.name = constant.toString();
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
}
