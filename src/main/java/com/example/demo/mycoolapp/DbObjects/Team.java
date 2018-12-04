/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.mycoolapp.DbObjects;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")
    , @NamedQuery(name = "Team.findByTeamid", query = "SELECT t FROM Team t WHERE t.teamid = :teamid")
    , @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "teamid")
    private Integer teamid;
    @Size(max = 30)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "teamid")
    private Collection<Teammember> teammemberCollection;
    @OneToMany(mappedBy = "teamid")
    private Collection<List> listCollection;

    public Team() {
    }

    public Team(Integer teamid) {
        this.teamid = teamid;
    }

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Teammember> getTeammemberCollection() {
        return teammemberCollection;
    }

    public void setTeammemberCollection(Collection<Teammember> teammemberCollection) {
        this.teammemberCollection = teammemberCollection;
    }

    @XmlTransient
    public Collection<List> getListCollection() {
        return listCollection;
    }

    public void setListCollection(Collection<List> listCollection) {
        this.listCollection = listCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamid != null ? teamid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.teamid == null && other.teamid != null) || (this.teamid != null && !this.teamid.equals(other.teamid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.mycoolapp.DbObjects.Team[ teamid=" + teamid + " ]";
    }
    
}
