/**
 * This file is part of mycollab-services.
 *
 * mycollab-services is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-services is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-services.  If not, see <http://www.gnu.org/licenses/>.
 */
/*Domain class of table m_crm_accounts_leads*/
package com.esofthead.mycollab.module.crm.domain;

import com.esofthead.mycollab.core.arguments.ValuedBean;
import java.util.Date;

@SuppressWarnings("ucd")
@com.esofthead.mycollab.core.db.metadata.Table("m_crm_accounts_leads")
public class AccountLead extends ValuedBean {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_accounts_leads.id
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("id")
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_accounts_leads.accountId
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("accountId")
    private Integer accountid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_accounts_leads.leadId
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("leadId")
    private Integer leadid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_accounts_leads.createTime
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("createTime")
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column m_crm_accounts_leads.isConvertRel
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    @com.esofthead.mycollab.core.db.metadata.Column("isConvertRel")
    private Boolean isconvertrel;

    private static final long serialVersionUID = 1;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_accounts_leads.id
     *
     * @return the value of m_crm_accounts_leads.id
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_accounts_leads.id
     *
     * @param id the value for m_crm_accounts_leads.id
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_accounts_leads.accountId
     *
     * @return the value of m_crm_accounts_leads.accountId
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public Integer getAccountid() {
        return accountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_accounts_leads.accountId
     *
     * @param accountid the value for m_crm_accounts_leads.accountId
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_accounts_leads.leadId
     *
     * @return the value of m_crm_accounts_leads.leadId
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public Integer getLeadid() {
        return leadid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_accounts_leads.leadId
     *
     * @param leadid the value for m_crm_accounts_leads.leadId
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public void setLeadid(Integer leadid) {
        this.leadid = leadid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_accounts_leads.createTime
     *
     * @return the value of m_crm_accounts_leads.createTime
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_accounts_leads.createTime
     *
     * @param createtime the value for m_crm_accounts_leads.createTime
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column m_crm_accounts_leads.isConvertRel
     *
     * @return the value of m_crm_accounts_leads.isConvertRel
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public Boolean getIsconvertrel() {
        return isconvertrel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column m_crm_accounts_leads.isConvertRel
     *
     * @param isconvertrel the value for m_crm_accounts_leads.isConvertRel
     *
     * @mbggenerated Fri Feb 27 09:55:24 ICT 2015
     */
    public void setIsconvertrel(Boolean isconvertrel) {
        this.isconvertrel = isconvertrel;
    }

    public static enum Field {
        id,
        accountid,
        leadid,
        createtime,
        isconvertrel;

        public boolean equalTo(Object value) {
            return name().equals(value);
        }
    }
}