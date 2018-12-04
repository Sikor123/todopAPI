/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.mycoolapp.DbObjects;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PussyConqueror
 */
@Entity
@Table(name = "task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")
    , @NamedQuery(name = "Task.findByTaskid", query = "SELECT t FROM Task t WHERE t.taskid = :taskid")
    , @NamedQuery(name = "Task.findByTaskname", query = "SELECT t FROM Task t WHERE t.taskname = :taskname")
    , @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description")
    , @NamedQuery(name = "Task.findByIsdone", query = "SELECT t FROM Task t WHERE t.isdone = :isdone")
    , @NamedQuery(name = "Task.findByDuedate", query = "SELECT t FROM Task t WHERE t.duedate = :duedate")
    , @NamedQuery(name = "Task.findByIspriority", query = "SELECT t FROM Task t WHERE t.ispriority = :ispriority")})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "taskid")
    private Integer taskid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "taskname")
    private String taskname;
    @Size(max = 140)
    @Column(name = "description")
    private String description;
    @Column(name = "isdone")
    private Boolean isdone;
    @Column(name = "duedate")
    @Temporal(TemporalType.DATE)
    private Date duedate;
    @Column(name = "ispriority")
    private Boolean ispriority;
    @JoinColumn(name = "listid", referencedColumnName = "listid")
    @ManyToOne(optional = false)
    private List listid;

    public Task() {
    }

    public Task(Integer taskid) {
        this.taskid = taskid;
    }

    public Task(Integer taskid, String taskname) {
        this.taskid = taskid;
        this.taskname = taskname;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsdone() {
        return isdone;
    }

    public void setIsdone(Boolean isdone) {
        this.isdone = isdone;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Boolean getIspriority() {
        return ispriority;
    }

    public void setIspriority(Boolean ispriority) {
        this.ispriority = ispriority;
    }

    public List getListid() {
        return listid;
    }

    public void setListid(List listid) {
        this.listid = listid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskid != null ? taskid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskid == null && other.taskid != null) || (this.taskid != null && !this.taskid.equals(other.taskid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.mycoolapp.DbObjects.Task[ taskid=" + taskid + " ]";
    }
    
}
