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
@Table(name = "task_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskUser.findAll", query = "SELECT t FROM TaskUser t")
    , @NamedQuery(name = "TaskUser.findByUserid", query = "SELECT t FROM TaskUser t WHERE t.userid = :userid")
    , @NamedQuery(name = "TaskUser.findByPassword", query = "SELECT t FROM TaskUser t WHERE t.password = :password")
    , @NamedQuery(name = "TaskUser.findByLogin", query = "SELECT t FROM TaskUser t WHERE t.login = :login")
    , @NamedQuery(name = "TaskUser.findByToken", query = "SELECT t FROM TaskUser t WHERE t.token = :token")})
public class TaskUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "token")
    private String token;
    @OneToMany(mappedBy = "userid")
    private Collection<Listmember> listmemberCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Teammember> teammemberCollection;

    public TaskUser() {
    }

    public TaskUser(Integer userid) {
        this.userid = userid;
    }

    public TaskUser(Integer userid, String password, String login, String token) {
        this.userid = userid;
        this.password = password;
        this.login = login;
        this.token = token;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @XmlTransient
    public Collection<Listmember> getListmemberCollection() {
        return listmemberCollection;
    }

    public void setListmemberCollection(Collection<Listmember> listmemberCollection) {
        this.listmemberCollection = listmemberCollection;
    }

    @XmlTransient
    public Collection<Teammember> getTeammemberCollection() {
        return teammemberCollection;
    }

    public void setTeammemberCollection(Collection<Teammember> teammemberCollection) {
        this.teammemberCollection = teammemberCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskUser)) {
            return false;
        }
        TaskUser other = (TaskUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.mycoolapp.DbObjects.TaskUser[ userid=" + userid + " ]";
    }
    
}
