package com.jitendra.list.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DISTRICT")
public class District implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="HEADQYARTER")
	private String headquarter;
	
	@Column(name="POPULATION")
	private String popullation;
	
	@Column(name="AREA")
	private String area;
	
	@Column(name="DENSITY")
	private String density;
	
	@Column(name="STATECODE")
	private String stateCode;

	/**
	 * 
	 */
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param code
	 * @param name
	 * @param headquarter
	 * @param popullation
	 * @param area
	 * @param density
	 */
	public District(Long id, String code, String name, String headquarter, String popullation, String area,
			String density) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.headquarter = headquarter;
		this.popullation = popullation;
		this.area = area;
		this.density = density;
	}
	
	

	/**
	 * @param id
	 * @param code
	 * @param name
	 * @param headquarter
	 * @param popullation
	 * @param area
	 * @param density
	 * @param stateCode
	 */
	public District(Long id, String code, String name, String headquarter, String popullation, String area,
			String density, String stateCode) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.headquarter = headquarter;
		this.popullation = popullation;
		this.area = area;
		this.density = density;
		this.stateCode = stateCode;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the headquarter
	 */
	public String getHeadquarter() {
		return headquarter;
	}

	/**
	 * @param headquarter the headquarter to set
	 */
	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}

	/**
	 * @return the popullation
	 */
	public String getPopullation() {
		return popullation;
	}

	/**
	 * @param popullation the popullation to set
	 */
	public void setPopullation(String popullation) {
		this.popullation = popullation;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the density
	 */
	public String getDensity() {
		return density;
	}

	/**
	 * @param density the density to set
	 */
	public void setDensity(String density) {
		this.density = density;
	}

	
	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((density == null) ? 0 : density.hashCode());
		result = prime * result + ((headquarter == null) ? 0 : headquarter.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((popullation == null) ? 0 : popullation.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		District other = (District) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (density == null) {
			if (other.density != null)
				return false;
		} else if (!density.equals(other.density))
			return false;
		if (headquarter == null) {
			if (other.headquarter != null)
				return false;
		} else if (!headquarter.equals(other.headquarter))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (popullation == null) {
			if (other.popullation != null)
				return false;
		} else if (!popullation.equals(other.popullation))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "District [id=" + id + ", code=" + code + ", name=" + name + ", headquarter=" + headquarter
				+ ", popullation=" + popullation + ", area=" + area + ", density=" + density + ", stateCode="
				+ stateCode + "]";
	}
	
	

}
