package org.example.model.spartial;

import java.util.Set;
import oracle.spatial.geometry.JGeometry;
import org.sqlproc.engine.annotation.Pojo;

@Pojo
@SuppressWarnings("all")
public class ColaMarkets {
  public static final String ORDER_BY_MKT_ID = "MKT_ID";
  
  private Byte mktId;
  
  public Byte getMktId() {
    return this.mktId;
  }
  
  public void setMktId(final Byte mktId) {
    this.mktId = mktId;
  }
  
  public ColaMarkets withMktId(final Byte mktId) {
    this.mktId = mktId;
    return this;
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public ColaMarkets withName(final String name) {
    this.name = name;
    return this;
  }
  
  private JGeometry shape;
  
  public JGeometry getShape() {
    return this.shape;
  }
  
  public void setShape(final JGeometry shape) {
    this.shape = shape;
  }
  
  public ColaMarkets withShape(final JGeometry shape) {
    this.shape = shape;
    return this;
  }
  
  @Override
  public String toString() {
    return "ColaMarkets [mktId=" + mktId + ", name=" + name + ", shape=" + shape + "]";
  }
  
  public String toStringFull() {
    return "ColaMarkets [mktId=" + mktId + ", name=" + name + ", shape=" + shape + "]";
  }
  
  public enum Attribute {
    name,
    
    shape;
  }
  
  private Set<String> nullValues_ =  new java.util.HashSet<String>();
  
  public void setNull_(final ColaMarkets.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.add(attribute.name());
  }
  
  public ColaMarkets withNull_(final ColaMarkets.Attribute... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final ColaMarkets.Attribute... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (Attribute attribute : attributes)
    	nullValues_.remove(attribute.name());
  }
  
  public ColaMarkets _clearNull_(final ColaMarkets.Attribute... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public void setNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.add(attribute);
  }
  
  public ColaMarkets withNull_(final String... attributes) {
    setNull_(attributes);
    return this;
  }
  
  public void clearNull_(final String... attributes) {
    if (attributes == null)
    	throw new IllegalArgumentException();
    for (String attribute : attributes)
    	nullValues_.remove(attribute);
  }
  
  public ColaMarkets _clearNull_(final String... attributes) {
    clearNull_(attributes);
    return this;
  }
  
  public Boolean isNull_(final ColaMarkets.Attribute attribute) {
    if (attribute == null)
    	throw new IllegalArgumentException();
    return nullValues_.contains(attribute.name());
  }
  
  public Boolean isNull_(final String attrName) {
    if (attrName == null)
    	throw new IllegalArgumentException();
    return nullValues_.contains(attrName);
  }
  
  public Boolean isDef_(final String attrName, final Boolean isAttrNotNull) {
    if (attrName == null)
    	throw new IllegalArgumentException();
    if (nullValues_.contains(attrName))
    	return true;
    if (isAttrNotNull != null)
    	return isAttrNotNull;
    return false;
  }
  
  public void clearAllNull_() {
    nullValues_ = new java.util.HashSet<String>();
  }
}
