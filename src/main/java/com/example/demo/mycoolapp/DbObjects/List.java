/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.mycoolapp.DbObjects;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PussyConqueror
 */
@Entity
@Table(name = "list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "List.findAll", query = "SELECT l FROM List l")
    , @NamedQuery(name = "List.findByListid", query = "SELECT l FROM List l WHERE l.listid = :listid")
    , @NamedQuery(name = "List.findByListname", query = "SELECT l FROM List l WHERE l.listname = :listname")})
public class List implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "listid")
    private Integer listid;
    @Size(max = 30)
    @Column(name = "listname")
    private String listname;
    @OneToMany(mappedBy = "listid")
    private Collection<Listmember> listmemberCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listid")
    private Collection<Task> taskCollection;
    @JoinColumn(name = "teamid", referencedColumnName = "teamid")
    @ManyToOne
    private Team teamid;

    public List() {
    }

    public List(Integer listid) {
        this.listid = listid;
    }

    public Integer getListid() {
        return listid;
    }

    public void setListid(Integer listid) {
        this.listid = listid;
    }

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    @XmlTransient
    public Collection<Listmember> getListmemberCollection() {
        return listmemberCollection;
    }

    public void setListmemberCollection(Collection<Listmember> listmemberCollection) {
        this.listmemberCollection = listmemberCollection;
    }

    @XmlTransient
    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }

    public Team getTeamid() {
        return teamid;
    }

    public void setTeamid(Team teamid) {
        this.teamid = teamid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listid != null ? listid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof List)) {
            return false;
        }
        List other = (List) object;
        if ((this.listid == null && other.listid != null) || (this.listid != null && !this.listid.equals(other.listid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.mycoolapp.DbObjects.List[ listid=" + listid + " ]";
    }
    
}
