/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.mycoolapp.DbObjects;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PussyConqueror
 */
@Entity
@Table(name = "listmember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listmember.findAll", query = "SELECT l FROM Listmember l")
    , @NamedQuery(name = "Listmember.findByListmemberid", query = "SELECT l FROM Listmember l WHERE l.listmemberid = :listmemberid")})
public class Listmember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "listmemberid")
    private Integer listmemberid;
    @JoinColumn(name = "listid", referencedColumnName = "listid")
    @ManyToOne
    private List listid;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private TaskUser userid;

    public Listmember() {
    }

    public Listmember(Integer listmemberid) {
        this.listmemberid = listmemberid;
    }

    public Integer getListmemberid() {
        return listmemberid;
    }

    public void setListmemberid(Integer listmemberid) {
        this.listmemberid = listmemberid;
    }

    public List getListid() {
        return listid;
    }

    public void setListid(List listid) {
        this.listid = listid;
    }

    public TaskUser getUserid() {
        return userid;
    }

    public void setUserid(TaskUser userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listmemberid != null ? listmemberid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listmember)) {
            return false;
        }
        Listmember other = (Listmember) object;
        if ((this.listmemberid == null && other.listmemberid != null) || (this.listmemberid != null && !this.listmemberid.equals(other.listmemberid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.mycoolapp.DbObjects.Listmember[ listmemberid=" + listmemberid + " ]";
    }
    
}
