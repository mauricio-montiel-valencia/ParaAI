/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2_test_programation2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mauricio10
 */
@Entity
@Table(name = "POSITIONS")
@NamedQueries({
    @NamedQuery(name = "Positions.findAll", query = "SELECT p FROM Positions p"),
    @NamedQuery(name = "Positions.findByPositionsid", query = "SELECT p FROM Positions p WHERE p.positionsid = :positionsid"),
    @NamedQuery(name = "Positions.findByPositions", query = "SELECT p FROM Positions p WHERE p.positions = :positions")})
public class Positions implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "POSITIONSID")
    private BigDecimal positionsid;
    @Basic(optional = false)
    @Column(name = "POSITIONS")
    private BigInteger positions;
    @OneToMany(mappedBy = "positionsid", fetch = FetchType.EAGER)
    private Collection<GeneralInformationTeam> generalInformationTeamCollection;
    @JoinColumn(name = "TEAM_REGISTERID", referencedColumnName = "TEAM_REGISTERID")
    @ManyToOne(fetch = FetchType.EAGER)
    private TeamRegister teamRegisterid;
    @JoinColumn(name = "TOURNAMENTID", referencedColumnName = "TOURNAMENTID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tournament tournamentid;

    public Positions() {
    }

    public Positions(BigDecimal positionsid) {
        this.positionsid = positionsid;
    }

    public Positions(BigDecimal positionsid, BigInteger positions) {
        this.positionsid = positionsid;
        this.positions = positions;
    }

    public BigDecimal getPositionsid() {
        return positionsid;
    }

    public void setPositionsid(BigDecimal positionsid) {
        this.positionsid = positionsid;
    }

    public BigInteger getPositions() {
        return positions;
    }

    public void setPositions(BigInteger positions) {
        this.positions = positions;
    }

    public Collection<GeneralInformationTeam> getGeneralInformationTeamCollection() {
        return generalInformationTeamCollection;
    }

    public void setGeneralInformationTeamCollection(Collection<GeneralInformationTeam> generalInformationTeamCollection) {
        this.generalInformationTeamCollection = generalInformationTeamCollection;
    }

    public TeamRegister getTeamRegisterid() {
        return teamRegisterid;
    }

    public void setTeamRegisterid(TeamRegister teamRegisterid) {
        this.teamRegisterid = teamRegisterid;
    }

    public Tournament getTournamentid() {
        return tournamentid;
    }

    public void setTournamentid(Tournament tournamentid) {
        this.tournamentid = tournamentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (positionsid != null ? positionsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Positions)) {
            return false;
        }
        Positions other = (Positions) object;
        if ((this.positionsid == null && other.positionsid != null) || (this.positionsid != null && !this.positionsid.equals(other.positionsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.project2_test_programation2.Positions[ positionsid=" + positionsid + " ]";
    }
    
}
