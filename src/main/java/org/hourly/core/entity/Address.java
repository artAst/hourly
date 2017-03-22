package org.hourly.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries( {
	@NamedQuery( name = "ADDRESS.FIND-BY-ADDRESS", query = "FROM Address a WHERE lower(a.address) LIKE lower(:address)" ),
	@NamedQuery( name = "ADDRESS.FIND-BY-PROVINCE", query = "FROM Address a WHERE a.province = :province" ),
	@NamedQuery( name = "ADDRESS.FIND-BY-CITY", query = "FROM Address a WHERE a.city = :city" )
} )
@Entity
@Table(name = "hourly_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "address_id" )
	private Long addressId;
	
	private Date dateCreated;
	
	private Date lastEdited;
	
	private String address;
	
	@ManyToOne( targetEntity = Province.class )
	@JoinColumn( name = "province_id" )
	private Province province;
	
	@ManyToOne( targetEntity = City.class )
	@JoinColumn( name = "city_id" )
	private City city;
	
	public Address() {}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(Date lastEdited) {
		this.lastEdited = lastEdited;
	}
}
