package org.hourly.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries( {
	@NamedQuery( name = "CITY.FIND-BY-NAME", query = "FROM City c WHERE lower(c.cityName) LIKE lower(:name)" )
} )
@Entity
@Table(name = "hourly_city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "city_id" )
	private Long cityId;
	
	@Column( name = "name" )
	private String cityName;
	
	public City() {}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
