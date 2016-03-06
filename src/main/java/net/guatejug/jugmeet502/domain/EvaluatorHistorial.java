/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.guatejug.jugmeet502.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shaka
 */
@Entity
@Table(name = "evaluator_historial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluatorHistorial.findAll", query = "SELECT e FROM EvaluatorHistorial e"),
    @NamedQuery(name = "EvaluatorHistorial.findByEvaluatorId", query = "SELECT e FROM EvaluatorHistorial e WHERE e.evaluatorId = :evaluatorId"),
    @NamedQuery(name = "EvaluatorHistorial.findByStatus", query = "SELECT e FROM EvaluatorHistorial e WHERE e.status = :status"),
    @NamedQuery(name = "EvaluatorHistorial.findByCreationDate", query = "SELECT e FROM EvaluatorHistorial e WHERE e.creationDate = :creationDate"),
    @NamedQuery(name = "EvaluatorHistorial.findByComments", query = "SELECT e FROM EvaluatorHistorial e WHERE e.comments = :comments")})
public class EvaluatorHistorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluator_id")
    private Integer evaluatorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private short status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4000)
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "evaluator_id", referencedColumnName = "evaluator_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Evaluator evaluator;

    public EvaluatorHistorial() {
    }

    public EvaluatorHistorial(Integer evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public EvaluatorHistorial(Integer evaluatorId, short status, Date creationDate, String comments) {
        this.evaluatorId = evaluatorId;
        this.status = status;
        this.creationDate = creationDate;
        this.comments = comments;
    }

    public Integer getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(Integer evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Evaluator getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluatorId != null ? evaluatorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluatorHistorial)) {
            return false;
        }
        EvaluatorHistorial other = (EvaluatorHistorial) object;
        if ((this.evaluatorId == null && other.evaluatorId != null) || (this.evaluatorId != null && !this.evaluatorId.equals(other.evaluatorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.guatejug.jugmeet502.domain.EvaluatorHistorial[ evaluatorId=" + evaluatorId + " ]";
    }
    
}
