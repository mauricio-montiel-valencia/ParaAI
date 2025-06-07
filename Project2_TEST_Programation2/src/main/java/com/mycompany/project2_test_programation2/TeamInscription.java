/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project2_test_programation2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mauricio10
 */
@Entity
@Table(name = "TEAM_INSCRIPTION")
@NamedQueries({
    @NamedQuery(name = "TeamInscription.findAll", query = "SELECT t FROM TeamInscription t"),
    @NamedQuery(name = "TeamInscription.findByTeamInscriptionid", query = "SELECT t FROM TeamInscription t WHERE t.teamInscriptionid = :teamInscriptionid"),
    @NamedQuery(name = "TeamInscription.findByTeamName", query = "SELECT t FROM TeamInscription t WHERE t.teamName = :teamName"),
    @NamedQuery(name = "TeamInscription.findByTeamLogo", query = "SELECT t FROM TeamInscription t WHERE t.teamLogo = :teamLogo"),
    @NamedQuery(name = "TeamInscription.findBySport", query = "SELECT t FROM TeamInscription t WHERE t.sport = :sport")})
public class TeamInscription implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TEAM_INSCRIPTIONID")
    private BigDecimal teamInscriptionid;
    @Basic(optional = false)
    @Column(name = "TEAM_NAME")
    private String teamName;
    @Basic(optional = false)
    @Column(name = "TEAM_LOGO")
    private String teamLogo;
    @Basic(optional = false)
    @Column(name = "SPORT")
    private String sport;
    @OneToMany(mappedBy = "teamInscriptionid", fetch = FetchType.EAGER)
    private Collection<Tournament> tournamentCollection;
    @OneToMany(mappedBy = "teamInscriptionid", fetch = FetchType.EAGER)
    private Collection<TeamRegister> teamRegisterCollection;

    public TeamInscription() {
    }

    public TeamInscription(BigDecimal teamInscriptionid) {
        this.teamInscriptionid = teamInscriptionid;
    }

    public TeamInscription(BigDecimal teamInscriptionid, String teamName, String teamLogo, String sport) {
        this.teamInscriptionid = teamInscriptionid;
        this.teamName = teamName;
        this.teamLogo = teamLogo;
        this.sport = sport;
    }

    public BigDecimal getTeamInscriptionid() {
        return teamInscriptionid;
    }

    public void setTeamInscriptionid(BigDecimal teamInscriptionid) {
        this.teamInscriptionid = teamInscriptionid;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Collection<Tournament> getTournamentCollection() {
        return tournamentCollection;
    }

    public void setTournamentCollection(Collection<Tournament> tournamentCollection) {
        this.tournamentCollection = tournamentCollection;
    }

    public Collection<TeamRegister> getTeamRegisterCollection() {
        return teamRegisterCollection;
    }

    public void setTeamRegisterCollection(Collection<TeamRegister> teamRegisterCollection) {
        this.teamRegisterCollection = teamRegisterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamInscriptionid != null ? teamInscriptionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamInscription)) {
            return false;
        }
        TeamInscription other = (TeamInscription) object;
        if ((this.teamInscriptionid == null && other.teamInscriptionid != null) || (this.teamInscriptionid != null && !this.teamInscriptionid.equals(other.teamInscriptionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.project2_test_programation2.TeamInscription[ teamInscriptionid=" + teamInscriptionid + " ]";
    }
    
}
