/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guatejug.jugmeet502.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shaka
 */
@Entity
@Table(name = "period")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Period.findAll", query = "SELECT p FROM Period p"),
    @NamedQuery(name = "Period.findByPeriodId", query = "SELECT p FROM Period p WHERE p.periodId = :periodId"),
    @NamedQuery(name = "Period.findByPeriodDate", query = "SELECT p FROM Period p WHERE p.periodDate = :periodDate"),
    @NamedQuery(name = "Period.findByStartTime", query = "SELECT p FROM Period p WHERE p.startTime = :startTime"),
    @NamedQuery(name = "Period.findByEndTime", query = "SELECT p FROM Period p WHERE p.endTime = :endTime")})
public class Period implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "period_id")
    private Integer periodId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "period_date")
    @Temporal(TemporalType.DATE)
    private Date periodDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "period")
    private List<Schedule> scheduleList;

    public Period() {
    }

    public Period(Integer periodId) {
        this.periodId = periodId;
    }

    public Period(Integer periodId, Date periodDate, Date startTime, Date endTime) {
        this.periodId = periodId;
        this.periodDate = periodDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public Date getPeriodDate() {
        return periodDate;
    }

    public void setPeriodDate(Date periodDate) {
        this.periodDate = periodDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @XmlTransient
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodId != null ? periodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Period)) {
            return false;
        }
        Period other = (Period) object;
        if ((this.periodId == null && other.periodId != null) || (this.periodId != null && !this.periodId.equals(other.periodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.guatejug.jugmeet502.domain.Period[ periodId=" + periodId + " ]";
    }
    
}
