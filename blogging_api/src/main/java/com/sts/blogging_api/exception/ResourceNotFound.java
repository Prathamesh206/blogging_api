package com.sts.blogging_api.exception;

public class ResourceNotFound  extends RuntimeException {
  String resourceName;
  String resourceValue;
  Long resourceId;
public ResourceNotFound(String resourceName, String resourceValue, Long resourceId) {
	super(String.format("the "+resourceName+" not found", resourceName,resourceValue,resourceId));
	this.resourceName = resourceName;
	this.resourceValue = resourceValue;
	this.resourceId = resourceId;
}
  
}
