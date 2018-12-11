package bmc;

import java.util.Objects;

public class Variable {

	enum VariableType {
        VARIABLE, CONSTANT
    }
	
	private VariableType type;
	private Integer value;
	private Integer prefix;
	private String name;
	private Integer range;
	
	public Variable(String name, int prefix, int range) {
        this.type = VariableType.VARIABLE;
        this.value = null;
        this.name = name;
        this.range = range;
        this.prefix = prefix;
    }
	
	public Variable(int constant, int range) {
        this.value = constant;
        this.type = VariableType.CONSTANT;
        this.name = String.valueOf(constant);
        this.range = range;
        this.prefix = null;
    }
	
    public Integer getConstantValue() {
        assert type == VariableType.CONSTANT;
        return value;
    }
    
    public String getName() {
        return String.format("%s_%d", name, prefix);
    }
    
    public VariableType getType() {
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
        return type == ((Variable) obj).type && Objects.equals(value,
                ((Variable) obj).value) && Objects.equals(name, ((Variable) obj).name);
    }

    @Override
    public String toString(){
    	if (type == VariableType.CONSTANT) {
    		return value.toString();
    	} else {
    		return name;
    	}
    }
}
