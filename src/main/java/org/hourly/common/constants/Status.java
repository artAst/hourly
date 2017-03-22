package org.hourly.common.constants;

public enum Status {
	
	SUCCESS("success"), FAILED("failed"), ERROR("error");
	
	String value;
	
	Status(String value) {
		this.value = value;
	}
	
	public Status fromValue(String value) {
		if ( value != null ) {
			for( Status type : values() ) {
				if ( value.equalsIgnoreCase( type.getValue() ) )
					return type;
			}
		}
		throw new IllegalArgumentException( "Invalid status value: " + value );
	}
	
	public String getValue() {
		return value;
	}
}
