package org.example.rest;

import java.io.Serializable;

import org.example.model.spartial.ColaMarkets;

public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private Byte mktId;
    private String name;
    private String shape;

    public Result(ColaMarkets cola) {
        this.mktId = cola.getMktId();
        this.name = cola.getName();
        this.shape = cola.getShape().toString();
    }

    public Byte getMktId() {
        return mktId;
    }

    public void setMktId(Byte mktId) {
        this.mktId = mktId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return "Result [mktId=" + mktId + ", name=" + name + ", shape=" + shape + "]";
    }

}
