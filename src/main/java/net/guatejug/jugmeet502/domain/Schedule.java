/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guatejug.jugmeet502.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shaka
 */
@Entity
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByLectureId", query = "SELECT s FROM Schedule s WHERE s.schedulePK.lectureId = :lectureId"),
    @NamedQuery(name = "Schedule.findByLocationId", query = "SELECT s FROM Schedule s WHERE s.schedulePK.locationId = :locationId"),
    @NamedQuery(name = "Schedule.findByPeriodId", query = "SELECT s FROM Schedule s WHERE s.schedulePK.periodId = :periodId")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SchedulePK schedulePK;
    @JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Lecture lecture;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Location location;
    @JoinColumn(name = "period_id", referencedColumnName = "period_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Period period;

    public Schedule() {
    }

    public Schedule(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
    }

    public Schedule(int lectureId, int locationId, int periodId) {
        this.schedulePK = new SchedulePK(lectureId, locationId, periodId);
    }

    public SchedulePK getSchedulePK() {
        return schedulePK;
    }

    public void setSchedulePK(SchedulePK schedulePK) {
        this.schedulePK = schedulePK;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schedulePK != null ? schedulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.schedulePK == null && other.schedulePK != null) || (this.schedulePK != null && !this.schedulePK.equals(other.schedulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.guatejug.jugmeet502.domain.Schedule[ schedulePK=" + schedulePK + " ]";
    }
    
}
