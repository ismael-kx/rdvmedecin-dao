package com.kx.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * Created by KX on 13/01/2017.
 */
public class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Version
    protected Long version;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public AbstractEntity build(Long id, Long version) {

        this.id = id;
        this.version = version;
        return this;
    }
    public boolean equals(Object entity){
        String class1 = this.getClass().getName();
        String class2 = this.getClass().getName();
        if(!class1.equals(class2)){
            return false;
        }
        AbstractEntity other = (AbstractEntity) entity;
        return this.id==other.id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }
}
