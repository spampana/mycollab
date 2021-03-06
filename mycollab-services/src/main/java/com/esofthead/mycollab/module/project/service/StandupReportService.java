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
package com.esofthead.mycollab.module.project.service;

import java.util.Date;
import java.util.List;

import com.esofthead.mycollab.common.domain.GroupItem;
import com.esofthead.mycollab.core.cache.CacheKey;
import com.esofthead.mycollab.core.cache.Cacheable;
import com.esofthead.mycollab.core.persistence.service.IDefaultService;
import com.esofthead.mycollab.module.project.domain.SimpleStandupReport;
import com.esofthead.mycollab.module.project.domain.StandupReportWithBLOBs;
import com.esofthead.mycollab.module.project.domain.criteria.StandupReportSearchCriteria;
import com.esofthead.mycollab.module.user.domain.SimpleUser;

/**
 * 
 * @author MyCollab Ltd.
 * @since 1.0
 * 
 */
public interface StandupReportService
extends
IDefaultService<Integer, StandupReportWithBLOBs, StandupReportSearchCriteria> {
	@Cacheable
	SimpleStandupReport findById(int standupId,
			@CacheKey int sAccountId);

	@Cacheable
	SimpleStandupReport findStandupReportByDateUser(int projectId,
			String username, Date onDate, @CacheKey Integer sAccountId);

	@Cacheable
	List<GroupItem> getReportsCount(
			@CacheKey StandupReportSearchCriteria criteria);

	@Cacheable
	List<SimpleUser> findUsersNotDoReportYet(int projectId, Date onDate,
			@CacheKey Integer sAccountId);

}
