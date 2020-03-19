package com.chryl.po;

import java.util.Date;

public class AuthUser {
    /**
     * 用户编号
     */
    private String userid;

    /**
     * 登录用户账号
     */
    private String username;

    /**
     * 操作员名称
     */
    private String operatorname;

    /**
     * 操作员密码(修改密码)
     */
    private String prePassword;
    
    /**
     * 操作员密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date altertime;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 机构编号
     */
    private String orgcode;
    
    private String kpiorgid;

    private String orgname;
    
    /**
     * 员工编号
     */
    private String empcode;
    
    private String rolename;
    
//    private List<AuthRole> roles;
    
    private String identity;
    
    private String employeeflag;
    /**
     * 用户编号
     * @return USERID 用户编号
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 用户编号
     * @param userid 用户编号
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 登录用户账号
     * @return USERNAME 登录用户账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 登录用户账号
     * @param username 登录用户账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 操作员名称
     * @return OPERATORNAME 操作员名称
     */
    public String getOperatorname() {
        return operatorname;
    }

    /**
     * 操作员名称
     * @param operatorname 操作员名称
     */
    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname == null ? null : operatorname.trim();
    }

    /**
     * 操作员密码
     * @return PASSWORD 操作员密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 操作员密码
     * @param password 操作员密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 创建时间
     * @return CREATETIME 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 创建时间
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 更新时间
     * @return ALTERTIME 更新时间
     */
    public Date getAltertime() {
        return altertime;
    }

    /**
     * 更新时间
     * @param altertime 更新时间
     */
    public void setAltertime(Date altertime) {
        this.altertime = altertime;
    }

    /**
     * 用户状态
     * @return STATUS 用户状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 用户状态
     * @param status 用户状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 机构编号
     * @return ORGCODE 机构编号
     */
    public String getOrgcode() {
        return orgcode;
    }

    /**
     * 机构编号
     * @param orgcode 机构编号
     */
    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    /**
     * 员工编号
     * @return EMPCODE 员工编号
     */
    public String getEmpcode() {
        return empcode;
    }

    /**
     * 员工编号
     * @param empcode 员工编号
     */
    public void setEmpcode(String empcode) {
        this.empcode = empcode == null ? null : empcode.trim();
    }

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

//	public List<AuthRole> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<AuthRole> roles) {
//		this.roles = roles;
//	}

	public String getPrePassword() {
		return prePassword;
	}

	public void setPrePassword(String prePassword) {
		this.prePassword = prePassword;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getEmployeeflag() {
        return employeeflag;
    }

	public void setEmployeeflag(String employeeflag) {
        this.employeeflag = employeeflag == null ? null : employeeflag.trim();
    }

	public String getKpiorgid() {
		return kpiorgid;
	}

	public void setKpiorgid(String kpiorgid) {
		this.kpiorgid = kpiorgid;
	}



}