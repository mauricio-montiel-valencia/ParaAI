/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2_test_programation2;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mauricio10
 */
@Entity
@Table(name = "BALL_SPORT_REGISTER")
@NamedQueries({
    @NamedQuery(name = "BallSportRegister.findAll", query = "SELECT b FROM BallSportRegister b"),
    @NamedQuery(name = "BallSportRegister.findByBallSportRegisterid", query = "SELECT b FROM BallSportRegister b WHERE b.ballSportRegisterid = :ballSportRegisterid"),
    @NamedQuery(name = "BallSportRegister.findByName", query = "SELECT b FROM BallSportRegister b WHERE b.name = :name"),
    @NamedQuery(name = "BallSportRegister.findByBallimage", query = "SELECT b FROM BallSportRegister b WHERE b.ballimage = :ballimage")})
public class BallSportRegister implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "BALL_SPORT_REGISTERID")
    private BigDecimal ballSportRegisterid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "BALLIMAGE")
    private String ballimage;

    public BallSportRegister() {
    }

    public BallSportRegister(BigDecimal ballSportRegisterid) {
        this.ballSportRegisterid = ballSportRegisterid;
    }

    public BallSportRegister(BigDecimal ballSportRegisterid, String name, String ballimage) {
        this.ballSportRegisterid = ballSportRegisterid;
        this.name = name;
        this.ballimage = ballimage;
    }

    public BigDecimal getBallSportRegisterid() {
        return ballSportRegisterid;
    }

    public void setBallSportRegisterid(BigDecimal ballSportRegisterid) {
        this.ballSportRegisterid = ballSportRegisterid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBallimage() {
        return ballimage;
    }

    public void setBallimage(String ballimage) {
        this.ballimage = ballimage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ballSportRegisterid != null ? ballSportRegisterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BallSportRegister)) {
            return false;
        }
        BallSportRegister other = (BallSportRegister) object;
        if ((this.ballSportRegisterid == null && other.ballSportRegisterid != null) || (this.ballSportRegisterid != null && !this.ballSportRegisterid.equals(other.ballSportRegisterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.project2_test_programation2.BallSportRegister[ ballSportRegisterid=" + ballSportRegisterid + " ]";
    }
    
}
