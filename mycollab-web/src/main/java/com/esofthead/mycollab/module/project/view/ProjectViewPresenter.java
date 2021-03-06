/**
 * This file is part of mycollab-web.
 *
 * mycollab-web is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-web is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-web.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.module.project.view;

import com.esofthead.mycollab.core.utils.ClassUtils;
import com.esofthead.mycollab.module.project.CurrentProjectVariables;
import com.esofthead.mycollab.module.project.domain.SimpleProject;
import com.esofthead.mycollab.module.project.service.ProjectMemberService;
import com.esofthead.mycollab.module.project.service.ProjectService;
import com.esofthead.mycollab.module.project.view.bug.TrackerPresenter;
import com.esofthead.mycollab.module.project.view.file.IFilePresenter;
import com.esofthead.mycollab.module.project.view.message.MessagePresenter;
import com.esofthead.mycollab.module.project.view.milestone.MilestonePresenter;
import com.esofthead.mycollab.module.project.view.page.PagePresenter;
import com.esofthead.mycollab.module.project.view.parameters.*;
import com.esofthead.mycollab.module.project.view.problem.IProblemPresenter;
import com.esofthead.mycollab.module.project.view.risk.IRiskPresenter;
import com.esofthead.mycollab.module.project.view.settings.UserSettingPresenter;
import com.esofthead.mycollab.module.project.view.standup.IStandupPresenter;
import com.esofthead.mycollab.module.project.view.task.TaskPresenter;
import com.esofthead.mycollab.module.project.view.time.ITimeTrackingPresenter;
import com.esofthead.mycollab.module.project.view.user.ProjectDashboardPresenter;
import com.esofthead.mycollab.spring.ApplicationContextUtil;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.mvp.IPresenter;
import com.esofthead.mycollab.vaadin.mvp.PageActionChain;
import com.esofthead.mycollab.vaadin.mvp.PresenterResolver;
import com.esofthead.mycollab.vaadin.mvp.ScreenData;
import com.esofthead.mycollab.vaadin.ui.AbstractPresenter;
import com.esofthead.mycollab.vaadin.ui.NotificationUtil;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComponentContainer;

/**
 * @author MyCollab Ltd.
 * @since 1.0
 */
public class ProjectViewPresenter extends AbstractPresenter<ProjectView> {

    private static final long serialVersionUID = 1L;

    public ProjectViewPresenter() {
        super(ProjectView.class);
    }

    @Override
    public void onGo(ComponentContainer container, ScreenData<?> data) {
        ProjectModule prjContainer = (ProjectModule) container;
        prjContainer.removeAllComponents();
        prjContainer.addComponent(view);
        prjContainer.setComponentAlignment(view, Alignment.TOP_CENTER);

        if (data == null) {
            // do nothing
        }
        if (data.getParams() instanceof Integer) {
            ProjectService projectService = ApplicationContextUtil
                    .getSpringBean(ProjectService.class);
            SimpleProject project = projectService.findById(
                    (Integer) data.getParams(), AppContext.getAccountId());

            if (project == null) {
                NotificationUtil.showRecordNotExistNotification();
            } else {
                ProjectMemberService projectMemberService = ApplicationContextUtil
                        .getSpringBean(ProjectMemberService.class);
                boolean userBelongToProject = projectMemberService
                        .isUserBelongToProject(AppContext.getUsername(),
                                project.getId(), AppContext.getAccountId());
                if (userBelongToProject) {
                    CurrentProjectVariables.setProject(project);
                    view.initView(project);
                } else {
                    NotificationUtil.showMessagePermissionAlert();
                }
            }
        }
    }

    @Override
    protected void onDefaultStopChain() {
        ProjectDashboardPresenter presenter = PresenterResolver
                .getPresenter(ProjectDashboardPresenter.class);
        presenter.go(this.view, null);
    }

    @Override
    protected void onHandleChain(ComponentContainer container,
                                 PageActionChain pageActionChain) {
        ScreenData<?> pageAction = pageActionChain.peek();

        IPresenter<?> presenter;

        if (ClassUtils.instanceOf(pageAction, MilestoneScreenData.Read.class,
                MilestoneScreenData.Search.class,
                MilestoneScreenData.Add.class, MilestoneScreenData.Edit.class)) {
            presenter = PresenterResolver
                    .getPresenter(MilestonePresenter.class);
        } else if (ClassUtils.instanceOf(pageAction,
                MessageScreenData.Read.class, MessageScreenData.Search.class)) {
            presenter = PresenterResolver.getPresenter(MessagePresenter.class);
        } else if (ClassUtils.instanceOf(pageAction,
                PageScreenData.Search.class, PageScreenData.Add.class,
                PageScreenData.Read.class, PageScreenData.Edit.class)) {
            presenter = PresenterResolver.getPresenter(PagePresenter.class);
        } else if (ClassUtils.instanceOf(pageAction,
                ProblemScreenData.Read.class, ProblemScreenData.Search.class,
                ProblemScreenData.Add.class, ProblemScreenData.Edit.class)) {
            presenter = PresenterResolver.getPresenter(IProblemPresenter.class);
        } else if (ClassUtils.instanceOf(pageAction, RiskScreenData.Read.class,
                RiskScreenData.Search.class, RiskScreenData.Add.class,
                RiskScreenData.Edit.class)) {
            presenter = PresenterResolver.getPresenter(IRiskPresenter.class);
        } else if (ClassUtils.instanceOf(pageAction, TaskScreenData.Read.class,
                TaskScreenData.Edit.class, TaskGroupScreenData.GotoDashboard.class,
                TaskGroupScreenData.Read.class, TaskGroupScreenData.Edit.class)) {
            presenter = PresenterResolver.getPresenter(TaskPresenter.class);
        } else if (ClassUtils.instanceOf(pageAction, BugScreenData.Read.class,
                BugScreenData.GotoDashboard.class, BugScreenData.Add.class,
                BugScreenData.Edit.class, BugScreenData.Search.class,
                ComponentScreenData.Read.class, ComponentScreenData.Add.class,
                ComponentScreenData.Edit.class,
                ComponentScreenData.Search.class, VersionScreenData.Read.class,
                VersionScreenData.Search.class, VersionScreenData.Add.class,
                VersionScreenData.Edit.class)) {
            presenter = PresenterResolver.getPresenter(TrackerPresenter.class);
        } else if (ClassUtils.instanceOf(pageAction,
                StandupScreenData.Search.class, StandupScreenData.Add.class)) {
            presenter = PresenterResolver.getPresenter(IStandupPresenter.class);
        } else if (ClassUtils.instanceOf(pageAction,
                ProjectMemberScreenData.Search.class,
                ProjectMemberScreenData.Read.class,
                ProjectMemberScreenData.Add.class,
                ProjectMemberScreenData.InviteProjectMembers.class,
                ProjectRoleScreenData.Search.class,
                ProjectRoleScreenData.Add.class,
                ProjectRoleScreenData.Read.class,
                ProjectSettingScreenData.ViewSettings.class)) {
            presenter = PresenterResolver
                    .getPresenter(UserSettingPresenter.class);
        } else if (ClassUtils.instanceOf(pageAction,
                TimeTrackingScreenData.Search.class)) {
            presenter = PresenterResolver
                    .getPresenter(ITimeTrackingPresenter.class);
        } else if (ClassUtils.instanceOf(pageAction,
                FileScreenData.GotoDashboard.class)) {
            presenter = PresenterResolver.getPresenter(IFilePresenter.class);
        } else if (ClassUtils.instanceOf(pageAction, ProjectScreenData.GotoTagList.class)) {
            presenter = PresenterResolver.getPresenter(ProjectDashboardPresenter.class);
        } else {
            throw new UnsupportedOperationException(
                    "Not support page action chain " + pageAction);
        }

        presenter.handleChain(view, pageActionChain);
    }
}
