/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2_test_programation2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Mauricio10
 */
@Entity
@Table(name = "GLOBAL_RANKING")
@NamedQueries({
    @NamedQuery(name = "GlobalRanking.findAll", query = "SELECT g FROM GlobalRanking g"),
    @NamedQuery(name = "GlobalRanking.findByGlobalRankingid", query = "SELECT g FROM GlobalRanking g WHERE g.globalRankingid = :globalRankingid"),
    @NamedQuery(name = "GlobalRanking.findByPositionsRanking", query = "SELECT g FROM GlobalRanking g WHERE g.positionsRanking = :positionsRanking")})
public class GlobalRanking implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GLOBAL_RANKINGID")
    private BigDecimal globalRankingid;
    @Basic(optional = false)
    @Column(name = "POSITIONS_RANKING")
    private BigInteger positionsRanking;
    @JoinColumn(name = "GENERAL_STATSID", referencedColumnName = "GENERAL_STATSID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GeneralStadistics generalStatsid;
    @JoinColumn(name = "TEAM_REGISTERID", referencedColumnName = "TEAM_REGISTERID")
    @ManyToOne(fetch = FetchType.EAGER)
    private TeamRegister teamRegisterid;

    public GlobalRanking() {
    }

    public GlobalRanking(BigDecimal globalRankingid) {
        this.globalRankingid = globalRankingid;
    }

    public GlobalRanking(BigDecimal globalRankingid, BigInteger positionsRanking) {
        this.globalRankingid = globalRankingid;
        this.positionsRanking = positionsRanking;
    }

    public BigDecimal getGlobalRankingid() {
        return globalRankingid;
    }

    public void setGlobalRankingid(BigDecimal globalRankingid) {
        this.globalRankingid = globalRankingid;
    }

    public BigInteger getPositionsRanking() {
        return positionsRanking;
    }

    public void setPositionsRanking(BigInteger positionsRanking) {
        this.positionsRanking = positionsRanking;
    }

    public GeneralStadistics getGeneralStatsid() {
        return generalStatsid;
    }

    public void setGeneralStatsid(GeneralStadistics generalStatsid) {
        this.generalStatsid = generalStatsid;
    }

    public TeamRegister getTeamRegisterid() {
        return teamRegisterid;
    }

    public void setTeamRegisterid(TeamRegister teamRegisterid) {
        this.teamRegisterid = teamRegisterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (globalRankingid != null ? globalRankingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobalRanking)) {
            return false;
        }
        GlobalRanking other = (GlobalRanking) object;
        if ((this.globalRankingid == null && other.globalRankingid != null) || (this.globalRankingid != null && !this.globalRankingid.equals(other.globalRankingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.project2_test_programation2.GlobalRanking[ globalRankingid=" + globalRankingid + " ]";
    }
    
}
