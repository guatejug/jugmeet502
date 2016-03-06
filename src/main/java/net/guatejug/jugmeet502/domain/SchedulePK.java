/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guatejug.jugmeet502.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author shaka
 */
@Embeddable
public class SchedulePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "lecture_id")
    private int lectureId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "location_id")
    private int locationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "period_id")
    private int periodId;

    public SchedulePK() {
    }

    public SchedulePK(int lectureId, int locationId, int periodId) {
        this.lectureId = lectureId;
        this.locationId = locationId;
        this.periodId = periodId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) lectureId;
        hash += (int) locationId;
        hash += (int) periodId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchedulePK)) {
            return false;
        }
        SchedulePK other = (SchedulePK) object;
        if (this.lectureId != other.lectureId) {
            return false;
        }
        if (this.locationId != other.locationId) {
            return false;
        }
        if (this.periodId != other.periodId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.guatejug.jugmeet502.domain.SchedulePK[ lectureId=" + lectureId + ", locationId=" + locationId + ", periodId=" + periodId + " ]";
    }
    
}
