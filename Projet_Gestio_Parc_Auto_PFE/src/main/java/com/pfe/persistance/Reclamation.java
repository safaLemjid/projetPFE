package com.pfe.persistance;

public class Reclamation {
  private Integer num_rec;
  private String description;
  private Personnel personnel;
  
  
public Integer getNum_rec() {
	return num_rec;
}
public void setNum_rec(Integer num_rec) {
	this.num_rec = num_rec;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Personnel getPersonnel() {
	return personnel;
}
public void setPersonnel(Personnel personnel) {
	this.personnel = personnel;
}
 

@Override
public String toString() {
	return "Reclamation [num_rec=" + num_rec + ", description=" + description
			+ "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((num_rec == null) ? 0 : num_rec.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Reclamation other = (Reclamation) obj;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (num_rec == null) {
		if (other.num_rec != null)
			return false;
	} else if (!num_rec.equals(other.num_rec))
		return false;
	return true;
}
  
}
