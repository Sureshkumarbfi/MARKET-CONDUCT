package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRF_ACCESS_AND_ROLES_TABLE")
public class AccessAndRoles {

    @Id
    @Column(name = "ROLE_ID")
    private String roleId;

    @Column(name = "ROLE_DESC")
    private String roleDesc;

    @Column(name = "PERMISSIONS")
    private String permissions;

    @Column(name = "WORK_CLASS")
    private String workClass;

    @Column(name = "DOMAIN_ID")
    private String domainId;

    @Column(name = "ADMIN")
    private String admin;

    @Column(name = "MENULIST")
    private String menulist;

    @Column(name = "ENTRY_USER")
    private String entryUser;

    @Column(name = "MODIFY_USER")
    private String modifyUser;

    @Column(name = "AUTH_USER")
    private String authUser;

    @Column(name = "ENTRY_TIME")
    private Date entryTime;

    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    @Column(name = "AUTH_TIME")
    private Date authTime;

    @Column(name = "REMARKS")
    private String remarks;

    @Column(name = "NEW_ROLE_FLG")
    private String newRoleFlg;

    @Column(name = "RT_REPORTS")
    private String rtReports;
    
    @Column(name = "ASL")
    private String asl;
    
    @Column(name = "ASL_UPLOAD")
    private String asl_upload;
    
    @Column(name = "AUDIT_US")
    private String audit_us;

    @Column(name = "ENTITY_FLG")
    private String entityFlg;

    @Column(name = "AUTH_FLG")
    private String authFlg;

    @Column(name = "MODIFY_FLG")
    private String modifyFlg;

    @Column(name = "DEL_FLG")
    private String delFlg;

	

	public AccessAndRoles(String roleId, String roleDesc, String permissions, String workClass, String domainId,
			String admin, String menulist, String entryUser, String modifyUser, String authUser, Date entryTime,
			Date modifyTime, Date authTime, String remarks, String newRoleFlg, String rtReports, String asl,
			String asl_upload, String audit_us, String entityFlg, String authFlg, String modifyFlg, String delFlg) {
		super();
		this.roleId = roleId;
		this.roleDesc = roleDesc;
		this.permissions = permissions;
		this.workClass = workClass;
		this.domainId = domainId;
		this.admin = admin;
		this.menulist = menulist;
		this.entryUser = entryUser;
		this.modifyUser = modifyUser;
		this.authUser = authUser;
		this.entryTime = entryTime;
		this.modifyTime = modifyTime;
		this.authTime = authTime;
		this.remarks = remarks;
		this.newRoleFlg = newRoleFlg;
		this.rtReports = rtReports;
		this.asl = asl;
		this.asl_upload = asl_upload;
		this.audit_us = audit_us;
		this.entityFlg = entityFlg;
		this.authFlg = authFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
	}

	public AccessAndRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
	    result = prime * result + ((roleDesc == null) ? 0 : roleDesc.hashCode());
	    result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
	    result = prime * result + ((workClass == null) ? 0 : workClass.hashCode());
	    result = prime * result + ((domainId == null) ? 0 : domainId.hashCode());
	    result = prime * result + ((admin == null) ? 0 : admin.hashCode());
	    result = prime * result + ((menulist == null) ? 0 : menulist.hashCode());
	    result = prime * result + ((entryUser == null) ? 0 : entryUser.hashCode());
	    result = prime * result + ((modifyUser == null) ? 0 : modifyUser.hashCode());
	    result = prime * result + ((authUser == null) ? 0 : authUser.hashCode());
	    result = prime * result + ((entryTime == null) ? 0 : entryTime.hashCode());
	    result = prime * result + ((modifyTime == null) ? 0 : modifyTime.hashCode());
	    result = prime * result + ((authTime == null) ? 0 : authTime.hashCode());
	    result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
	    result = prime * result + ((newRoleFlg == null) ? 0 : newRoleFlg.hashCode());
	    result = prime * result + ((rtReports == null) ? 0 : rtReports.hashCode());
	    result = prime * result + ((entityFlg == null) ? 0 : entityFlg.hashCode());
	    result = prime * result + ((authFlg == null) ? 0 : authFlg.hashCode());
	    result = prime * result + ((modifyFlg == null) ? 0 : modifyFlg.hashCode());
	    result = prime * result + ((delFlg == null) ? 0 : delFlg.hashCode());
	    return result;
	}


	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null)
	        return false;
	    if (getClass() != obj.getClass())
	        return false;
	    AccessAndRoles other = (AccessAndRoles) obj;
	    if (roleId == null) {
	        if (other.roleId != null)
	            return false;
	    } else if (!roleId.equals(other.roleId))
	        return false;
	    if (roleDesc == null) {
	        if (other.roleDesc != null)
	            return false;
	    } else if (!roleDesc.equals(other.roleDesc))
	        return false;
	    if (permissions == null) {
	        if (other.permissions != null)
	            return false;
	    } else if (!permissions.equals(other.permissions))
	        return false;
	    if (workClass == null) {
	        if (other.workClass != null)
	            return false;
	    } else if (!workClass.equals(other.workClass))
	        return false;
	    if (domainId == null) {
	        if (other.domainId != null)
	            return false;
	    } else if (!domainId.equals(other.domainId))
	        return false;
	    if (admin == null) {
	        if (other.admin != null)
	            return false;
	    } else if (!admin.equals(other.admin))
	        return false;
	    if (menulist == null) {
	        if (other.menulist != null)
	            return false;
	    } else if (!menulist.equals(other.menulist))
	        return false;
	    if (entryUser == null) {
	        if (other.entryUser != null)
	            return false;
	    } else if (!entryUser.equals(other.entryUser))
	        return false;
	    if (modifyUser == null) {
	        if (other.modifyUser != null)
	            return false;
	    } else if (!modifyUser.equals(other.modifyUser))
	        return false;
	    if (authUser == null) {
	        if (other.authUser != null)
	            return false;
	    } else if (!authUser.equals(other.authUser))
	        return false;
	    if (entryTime == null) {
	        if (other.entryTime != null)
	            return false;
	    } else if (!entryTime.equals(other.entryTime))
	        return false;
	    if (modifyTime == null) {
	        if (other.modifyTime != null)
	            return false;
	    } else if (!modifyTime.equals(other.modifyTime))
	        return false;
	    if (authTime == null) {
	        if (other.authTime != null)
	            return false;
	    } else if (!authTime.equals(other.authTime))
	        return false;
	    if (remarks == null) {
	        if (other.remarks != null)
	            return false;
	    } else if (!remarks.equals(other.remarks))
	        return false;
	    if (newRoleFlg == null) {
	        if (other.newRoleFlg != null)
	            return false;
	    } else if (!newRoleFlg.equals(other.newRoleFlg))
	        return false;
	    if (rtReports == null) {
	        if (other.rtReports != null)
	            return false;
	    } else if (!rtReports.equals(other.rtReports))
	        return false;
	    if (entityFlg == null) {
	        if (other.entityFlg != null)
	            return false;
	    } else if (!entityFlg.equals(other.entityFlg))
	        return false;
	    if (authFlg == null) {
	        if (other.authFlg != null)
	            return false;
	    } else if (!authFlg.equals(other.authFlg))
	        return false;
	    if (modifyFlg == null) {
	        if (other.modifyFlg != null)
	            return false;
	    } else if (!modifyFlg.equals(other.modifyFlg))
	        return false;
	    if (delFlg == null) {
	        if (other.delFlg != null)
	            return false;
	    } else if (!delFlg.equals(other.delFlg))
	        return false;
	    return true;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getWorkClass() {
		return workClass;
	}

	public void setWorkClass(String workClass) {
		this.workClass = workClass;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getMenulist() {
		return menulist;
	}

	public void setMenulist(String menulist) {
		this.menulist = menulist;
	}

	public String getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(String entryUser) {
		this.entryUser = entryUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public String getAuthUser() {
		return authUser;
	}

	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getAuthTime() {
		return authTime;
	}

	public void setAuthTime(Date authTime) {
		this.authTime = authTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getNewRoleFlg() {
		return newRoleFlg;
	}

	public void setNewRoleFlg(String newRoleFlg) {
		this.newRoleFlg = newRoleFlg;
	}

	public String getRtReports() {
		return rtReports;
	}

	public void setRtReports(String rtReports) {
		this.rtReports = rtReports;
	}

	public String getEntityFlg() {
		return entityFlg;
	}

	public void setEntityFlg(String entityFlg) {
		this.entityFlg = entityFlg;
	}

	public String getAuthFlg() {
		return authFlg;
	}

	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public String getAsl() {
		return asl;
	}

	public void setAsl(String asl) {
		this.asl = asl;
	}

	public String getAsl_upload() {
		return asl_upload;
	}

	public void setAsl_upload(String asl_upload) {
		this.asl_upload = asl_upload;
	}

	public String getAudit_us() {
		return audit_us;
	}

	public void setAudit_us(String audit_us) {
		this.audit_us = audit_us;
	}

	@Override
	public String toString() {
		return "AccessAndRoles [roleId=" + roleId + ", roleDesc=" + roleDesc + ", permissions=" + permissions
				+ ", workClass=" + workClass + ", domainId=" + domainId + ", admin=" + admin + ", menulist=" + menulist
				+ ", entryUser=" + entryUser + ", modifyUser=" + modifyUser + ", authUser=" + authUser + ", entryTime="
				+ entryTime + ", modifyTime=" + modifyTime + ", authTime=" + authTime + ", remarks=" + remarks
				+ ", newRoleFlg=" + newRoleFlg + ", rtReports=" + rtReports + ", asl=" + asl + ", asl_upload="
				+ asl_upload + ", audit_us=" + audit_us + ", entityFlg=" + entityFlg + ", authFlg=" + authFlg
				+ ", modifyFlg=" + modifyFlg + ", delFlg=" + delFlg + "]";
	}

	


	
	
	
}

