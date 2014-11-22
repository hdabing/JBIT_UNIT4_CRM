package service;

import java.util.List;

import dao.relationshipDaoImpl;
import entity.Relationship;

public class relationshipService {
	private relationshipDaoImpl relationshipdaoimpl;

	public relationshipDaoImpl getRelationshipdaoimpl() {
		return relationshipdaoimpl;
	}

	public void setRelationshipdaoimpl(relationshipDaoImpl relationshipdaoimpl) {
		this.relationshipdaoimpl = relationshipdaoimpl;
	}
	
	/**
	 * 客户的交往记录集
	 * @param customerid 客户id
	 * @return
	 */
	public List<Relationship> listRelationship(int customerid){
		String hql="From Relationship where customerid="+customerid+" order by id";
		
		return relationshipdaoimpl.getRelationshiplist(hql);
	}
	
	public void addRelationship(Relationship relationship){
		relationshipdaoimpl.add(relationship);
	}
	
	public void editRelationship(Relationship relationship){
		relationshipdaoimpl.edit(relationship);
	}
	
	public void delRelationship(int id){
		relationshipdaoimpl.del(id);
	}
	
	public Relationship getRelationship(int id){
		return relationshipdaoimpl.getRelationship(id);
	}
}
