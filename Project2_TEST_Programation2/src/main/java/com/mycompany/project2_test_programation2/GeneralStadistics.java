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
@Table(name = "GENERAL_STADISTICS")
@NamedQueries({
    @NamedQuery(name = "GeneralStadistics.findAll", query = "SELECT g FROM GeneralStadistics g"),
    @NamedQuery(name = "GeneralStadistics.findByGeneralStatsid", query = "SELECT g FROM GeneralStadistics g WHERE g.generalStatsid = :generalStatsid"),
    @NamedQuery(name = "GeneralStadistics.findByGeneralWins", query = "SELECT g FROM GeneralStadistics g WHERE g.generalWins = :generalWins")})
public class GeneralStadistics implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "GENERAL_STATSID")
    private BigDecimal generalStatsid;
    @Basic(optional = false)
    @Column(name = "GENERAL_WINS")
    private BigInteger generalWins;
    @OneToMany(mappedBy = "generalStatsid", fetch = FetchType.EAGER)
    private Collection<GeneralInformationTeam> generalInformationTeamCollection;
    @OneToMany(mappedBy = "generalStatsid", fetch = FetchType.EAGER)
    private Collection<GlobalRanking> globalRankingCollection;
    @JoinColumn(name = "TEAM_REGISTERID", referencedColumnName = "TEAM_REGISTERID")
    @ManyToOne(fetch = FetchType.EAGER)
    private TeamRegister teamRegisterid;

    public GeneralStadistics() {
    }

    public GeneralStadistics(BigDecimal generalStatsid) {
        this.generalStatsid = generalStatsid;
    }

    public GeneralStadistics(BigDecimal generalStatsid, BigInteger generalWins) {
        this.generalStatsid = generalStatsid;
        this.generalWins = generalWins;
    }

    public BigDecimal getGeneralStatsid() {
        return generalStatsid;
    }

    public void setGeneralStatsid(BigDecimal generalStatsid) {
        this.generalStatsid = generalStatsid;
    }

    public BigInteger getGeneralWins() {
        return generalWins;
    }

    public void setGeneralWins(BigInteger generalWins) {
        this.generalWins = generalWins;
    }

    public Collection<GeneralInformationTeam> getGeneralInformationTeamCollection() {
        return generalInformationTeamCollection;
    }

    public void setGeneralInformationTeamCollection(Collection<GeneralInformationTeam> generalInformationTeamCollection) {
        this.generalInformationTeamCollection = generalInformationTeamCollection;
    }

    public Collection<GlobalRanking> getGlobalRankingCollection() {
        return globalRankingCollection;
    }

    public void setGlobalRankingCollection(Collection<GlobalRanking> globalRankingCollection) {
        this.globalRankingCollection = globalRankingCollection;
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
        hash += (generalStatsid != null ? generalStatsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralStadistics)) {
            return false;
        }
        GeneralStadistics other = (GeneralStadistics) object;
        if ((this.generalStatsid == null && other.generalStatsid != null) || (this.generalStatsid != null && !this.generalStatsid.equals(other.generalStatsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.project2_test_programation2.GeneralStadistics[ generalStatsid=" + generalStatsid + " ]";
    }
    
}
