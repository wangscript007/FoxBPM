/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author MAENLIANG
 */
package org.foxbpm.engine.impl.schedule.quartz;

import java.util.HashMap;
import java.util.Map;

import org.foxbpm.engine.ProcessEngineManagement;
import org.foxbpm.engine.impl.RuntimeServiceImpl;
import org.foxbpm.engine.impl.schedule.FoxbpmJobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 流程实例自动启动JOB
 * 
 * @author MAENLIANG
 * @date 2014-06-25
 * 
 */
public class ProcessIntanceAutoStartJob extends AbstractQuartzScheduleJob {
	private static Logger LOG = LoggerFactory.getLogger(ProcessIntanceAutoStartJob.class);
	/**
	 * quartz系统创建
	 */
	public ProcessIntanceAutoStartJob() {
		
	}
	
	/**
	 * 本地自动调度创建
	 * 
	 * @param name
	 * @param groupName
	 * @param trigger
	 */
	public ProcessIntanceAutoStartJob(String name, String groupName) {
		super(name, groupName);
	}
	
	 
	public void executeJob(FoxbpmJobExecutionContext foxpmJobExecutionContext)
	    throws JobExecutionException {
		String processDefinitionId = foxpmJobExecutionContext.getProcessId();
		String processDefinitionKey = foxpmJobExecutionContext.getProcessKey();
		String businessKey = foxpmJobExecutionContext.getBizKey();
		Map<String, Object> transientVariables = new HashMap<String, Object>();
		Map<String, Object> persistenceVariables = new HashMap<String, Object>();
		
		LOG.debug("ProcessIntanceAutoStartJob执行,执行参数为 =流程定义ID:{} 流程定义Key:{} 业务关联键:{} ", processDefinitionId, processDefinitionKey, businessKey);
		
		RuntimeServiceImpl runtimeService = (RuntimeServiceImpl) ProcessEngineManagement.getDefaultProcessEngine().getRuntimeService();
		runtimeService.autoStartProcessInstance(processDefinitionKey, processDefinitionId, businessKey, transientVariables, persistenceVariables);
	}
	
}
