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
	@NamedQuery( name = "PROVINCE.FIND-BY-NAME", query = "FROM Province p WHERE lower(p.provinceName) LIKE lower(:name)" )
} )
@Entity
@Table(name = "hourly_province")
public class Province {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "province_id" )
	private Long provinceId;
	
	@Column( name = "name" )
	private String provinceName;
	
	public Province() {}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
}
