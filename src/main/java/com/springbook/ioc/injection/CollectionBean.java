package com.springbook.ioc.injection;

import java.util.List;

public class CollectionBean { // ����Ʈ �÷����� ��������� ������ CollectionBean Ŭ���� 
	// List
	private List<String> addressList; 

	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	
	// Set
//	private Set<String> addressList;
//
//	public void setAddressList(Set<String> addressList) {
//		this.addressList = addressList;
//	}
//
//	public Set<String> getAddressList() {
//		return addressList;
//	}
	
	
	// Map
//	private Map<String, Controller> addressList;
//
//	public Map<String, Controller> getAddressList() {
//		return addressList;
//	}
//
//	public void setAddressList(Map<String, Controller> addressList) {
//		this.addressList = addressList;
//	}
	
	// Properties
//	private Properties addressList;
//
//	public Properties getAddressList() {
//		return addressList;
//	}
//
//	public void setAddressList(Properties addressList) {
//		this.addressList = addressList;
//	}
	
	
	
	
}
