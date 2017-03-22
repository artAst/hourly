package org.hourly.common.constants;


public enum EmployeeType {
	
	REGULAR( "regular" ), FIXED( "fixed" );
	
	String value;
	
	EmployeeType(String value) {
		this.value = value;
	}
	
	public EmployeeType fromValue( String value ) {
		if ( value != null ) {
			for ( EmployeeType type : values() ) {
				if ( value.equalsIgnoreCase( type.getValue() ) )
					return type;
			}
		}
		throw new IllegalArgumentException( "Invalid employee type value: " + value );
	}
	
	public String getValue() {
		return value;
	}
}
