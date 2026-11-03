package com.bornfire.xbrl.entities;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "MIS_TREASURY_PLACEMENT") // replace with your actual table name
@IdClass(MIS_Treasury_placement_id_class.class)
public class MIS_TREASURY_PLACEMENT_ENTITY implements Serializable{
	
	@Id
	private String	num_operation;
	private String	entite_operation;
	private String	poste;
	private String	titre;
	private String	devise_1;
	private BigDecimal	nominal_1;
	private Date	date_operation;
	private Date	date_valeur;
	private Date	date_echeance;
	private String	preavis;
	private String	entite;
	private String	portefeuille;
	private String	contrepartie;
	private String	statut;
	private BigDecimal	valeur_taux_1;
	private String	taux_1;
	private String	periodicite_1;
	private String	affaire;
	private BigDecimal	duree_init;
	private BigDecimal	duree_restant;
	private String	tri_1;
	private String	tri_2;
	private String	tri_3;
	private String	op_reference;
	private String	filtrage;
	private String	signe;
	private Date	date_fin;
	private Date	date_debut;
	private String	op_finance;
	private String	create_user;
	private Date	create_time;
	private String	modify_user;
	private Date	modify_time;
	private String	verify_user;
	private Date	verify_time;
	private String	entity_flg;
	private String	modify_flg;
	@Id
	private Date	report_date;
	private String	branch_code;
	private String	branch_name;
	public String getNum_operation() {
		return num_operation;
	}
	public void setNum_operation(String num_operation) {
		this.num_operation = num_operation;
	}
	public String getEntite_operation() {
		return entite_operation;
	}
	public void setEntite_operation(String entite_operation) {
		this.entite_operation = entite_operation;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDevise_1() {
		return devise_1;
	}
	public void setDevise_1(String devise_1) {
		this.devise_1 = devise_1;
	}
	public BigDecimal getNominal_1() {
		return nominal_1;
	}
	public void setNominal_1(BigDecimal nominal_1) {
		this.nominal_1 = nominal_1;
	}
	public Date getDate_operation() {
		return date_operation;
	}
	public void setDate_operation(Date date_operation) {
		this.date_operation = date_operation;
	}
	public Date getDate_valeur() {
		return date_valeur;
	}
	public void setDate_valeur(Date date_valeur) {
		this.date_valeur = date_valeur;
	}
	public Date getDate_echeance() {
		return date_echeance;
	}
	public void setDate_echeance(Date date_echeance) {
		this.date_echeance = date_echeance;
	}
	public String getPreavis() {
		return preavis;
	}
	public void setPreavis(String preavis) {
		this.preavis = preavis;
	}
	public String getEntite() {
		return entite;
	}
	public void setEntite(String entite) {
		this.entite = entite;
	}
	public String getPortefeuille() {
		return portefeuille;
	}
	public void setPortefeuille(String portefeuille) {
		this.portefeuille = portefeuille;
	}
	public String getContrepartie() {
		return contrepartie;
	}
	public void setContrepartie(String contrepartie) {
		this.contrepartie = contrepartie;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public BigDecimal getValeur_taux_1() {
		return valeur_taux_1;
	}
	public void setValeur_taux_1(BigDecimal valeur_taux_1) {
		this.valeur_taux_1 = valeur_taux_1;
	}
	public String getTaux_1() {
		return taux_1;
	}
	public void setTaux_1(String taux_1) {
		this.taux_1 = taux_1;
	}
	public String getPeriodicite_1() {
		return periodicite_1;
	}
	public void setPeriodicite_1(String periodicite_1) {
		this.periodicite_1 = periodicite_1;
	}
	public String getAffaire() {
		return affaire;
	}
	public void setAffaire(String affaire) {
		this.affaire = affaire;
	}
	public BigDecimal getDuree_init() {
		return duree_init;
	}
	public void setDuree_init(BigDecimal duree_init) {
		this.duree_init = duree_init;
	}
	public BigDecimal getDuree_restant() {
		return duree_restant;
	}
	public void setDuree_restant(BigDecimal duree_restant) {
		this.duree_restant = duree_restant;
	}
	public String getTri_1() {
		return tri_1;
	}
	public void setTri_1(String tri_1) {
		this.tri_1 = tri_1;
	}
	public String getTri_2() {
		return tri_2;
	}
	public void setTri_2(String tri_2) {
		this.tri_2 = tri_2;
	}
	public String getTri_3() {
		return tri_3;
	}
	public void setTri_3(String tri_3) {
		this.tri_3 = tri_3;
	}
	public String getOp_reference() {
		return op_reference;
	}
	public void setOp_reference(String op_reference) {
		this.op_reference = op_reference;
	}
	public String getFiltrage() {
		return filtrage;
	}
	public void setFiltrage(String filtrage) {
		this.filtrage = filtrage;
	}
	public String getSigne() {
		return signe;
	}
	public void setSigne(String signe) {
		this.signe = signe;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public String getOp_finance() {
		return op_finance;
	}
	public void setOp_finance(String op_finance) {
		this.op_finance = op_finance;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	@Override
	public String toString() {
		return "MIS_TREASURY_PLACEMENT_ENTITY [num_operation=" + num_operation + ", entite_operation="
				+ entite_operation + ", poste=" + poste + ", titre=" + titre + ", devise_1=" + devise_1 + ", nominal_1="
				+ nominal_1 + ", date_operation=" + date_operation + ", date_valeur=" + date_valeur + ", date_echeance="
				+ date_echeance + ", preavis=" + preavis + ", entite=" + entite + ", portefeuille=" + portefeuille
				+ ", contrepartie=" + contrepartie + ", statut=" + statut + ", valeur_taux_1=" + valeur_taux_1
				+ ", taux_1=" + taux_1 + ", periodicite_1=" + periodicite_1 + ", affaire=" + affaire + ", duree_init="
				+ duree_init + ", duree_restant=" + duree_restant + ", tri_1=" + tri_1 + ", tri_2=" + tri_2 + ", tri_3="
				+ tri_3 + ", op_reference=" + op_reference + ", filtrage=" + filtrage + ", signe=" + signe
				+ ", date_fin=" + date_fin + ", date_debut=" + date_debut + ", op_finance=" + op_finance
				+ ", create_user=" + create_user + ", create_time=" + create_time + ", modify_user=" + modify_user
				+ ", modify_time=" + modify_time + ", verify_user=" + verify_user + ", verify_time=" + verify_time
				+ ", entity_flg=" + entity_flg + ", modify_flg=" + modify_flg + ", report_date=" + report_date
				+ ", branch_code=" + branch_code + ", branch_name=" + branch_name + "]";
	}
	public MIS_TREASURY_PLACEMENT_ENTITY(String num_operation, String entite_operation, String poste, String titre,
			String devise_1, BigDecimal nominal_1, Date date_operation, Date date_valeur, Date date_echeance,
			String preavis, String entite, String portefeuille, String contrepartie, String statut,
			BigDecimal valeur_taux_1, String taux_1, String periodicite_1, String affaire, BigDecimal duree_init,
			BigDecimal duree_restant, String tri_1, String tri_2, String tri_3, String op_reference, String filtrage,
			String signe, Date date_fin, Date date_debut, String op_finance, String create_user, Date create_time,
			String modify_user, Date modify_time, String verify_user, Date verify_time, String entity_flg,
			String modify_flg, Date report_date, String branch_code, String branch_name) {
		super();
		this.num_operation = num_operation;
		this.entite_operation = entite_operation;
		this.poste = poste;
		this.titre = titre;
		this.devise_1 = devise_1;
		this.nominal_1 = nominal_1;
		this.date_operation = date_operation;
		this.date_valeur = date_valeur;
		this.date_echeance = date_echeance;
		this.preavis = preavis;
		this.entite = entite;
		this.portefeuille = portefeuille;
		this.contrepartie = contrepartie;
		this.statut = statut;
		this.valeur_taux_1 = valeur_taux_1;
		this.taux_1 = taux_1;
		this.periodicite_1 = periodicite_1;
		this.affaire = affaire;
		this.duree_init = duree_init;
		this.duree_restant = duree_restant;
		this.tri_1 = tri_1;
		this.tri_2 = tri_2;
		this.tri_3 = tri_3;
		this.op_reference = op_reference;
		this.filtrage = filtrage;
		this.signe = signe;
		this.date_fin = date_fin;
		this.date_debut = date_debut;
		this.op_finance = op_finance;
		this.create_user = create_user;
		this.create_time = create_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.report_date = report_date;
		this.branch_code = branch_code;
		this.branch_name = branch_name;
	}
	public MIS_TREASURY_PLACEMENT_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
