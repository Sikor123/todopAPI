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
@Table(name = "teammember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teammember.findAll", query = "SELECT t FROM Teammember t")
    , @NamedQuery(name = "Teammember.findByTeammemberid", query = "SELECT t FROM Teammember t WHERE t.teammemberid = :teammemberid")})
public class Teammember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "teammemberid")
    private Integer teammemberid;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne
    private TaskUser userid;
    @JoinColumn(name = "teamid", referencedColumnName = "teamid")
    @ManyToOne
    private Team teamid;

    public Teammember() {
    }

    public Teammember(Integer teammemberid) {
        this.teammemberid = teammemberid;
    }

    public Integer getTeammemberid() {
        return teammemberid;
    }

    public void setTeammemberid(Integer teammemberid) {
        this.teammemberid = teammemberid;
    }

    public TaskUser getUserid() {
        return userid;
    }

    public void setUserid(TaskUser userid) {
        this.userid = userid;
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
        hash += (teammemberid != null ? teammemberid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teammember)) {
            return false;
        }
        Teammember other = (Teammember) object;
        if ((this.teammemberid == null && other.teammemberid != null) || (this.teammemberid != null && !this.teammemberid.equals(other.teammemberid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.mycoolapp.DbObjects.Teammember[ teammemberid=" + teammemberid + " ]";
    }
    
}
