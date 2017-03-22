package org.hourly.common.constants;

public enum Operation {
	
	CREATE("Create"), UPDATE("Update"), DELETE("Delete"), QUERY("Query"), CUSTOM("Custom");
	
	private String description;
    
    Operation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
