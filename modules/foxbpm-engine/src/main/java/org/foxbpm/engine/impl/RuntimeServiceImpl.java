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
 * @author kenshin
 * @author ych
 */
package org.foxbpm.engine.impl;

import java.util.Map;

import org.foxbpm.engine.RuntimeService;
import org.foxbpm.engine.impl.cmd.SignalCmd;
import org.foxbpm.engine.impl.cmd.StartProcessInstanceCmd;
import org.foxbpm.engine.impl.runtime.ProcessInstanceQueryImpl;
import org.foxbpm.engine.impl.runtime.TokenQueryImpl;
import org.foxbpm.engine.runtime.ProcessInstance;
import org.foxbpm.engine.runtime.ProcessInstanceQuery;
import org.foxbpm.engine.runtime.TokenQuery;

/**
 * runTimeService的具体实现
 * @author kenshin
 *
 */
public class RuntimeServiceImpl extends ServiceImpl implements RuntimeService {

	public ProcessInstance startProcessInstanceByKey(String processDefinitionKey) {
		return commandExecutor.execute(new StartProcessInstanceCmd<ProcessInstance>(processDefinitionKey, null, null, null));
	}

	public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, String bizKey) {
		return commandExecutor.execute(new StartProcessInstanceCmd<ProcessInstance>(processDefinitionKey, null, bizKey, null));
	}

	public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) {
		return commandExecutor.execute(new StartProcessInstanceCmd<ProcessInstance>(processDefinitionKey, null, null, variables));
	}

	public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, String bizKey, Map<String, Object> variables) {
		return commandExecutor.execute(new StartProcessInstanceCmd<ProcessInstance>(processDefinitionKey, null, bizKey, variables));
	}

	public ProcessInstance startProcessInstanceById(String processDefinitionId) {
		return commandExecutor.execute(new StartProcessInstanceCmd<ProcessInstance>(null, processDefinitionId, null, null));
	}

	public ProcessInstance startProcessInstanceById(String processDefinitionId, String bizKey) {
		return commandExecutor.execute(new StartProcessInstanceCmd<ProcessInstance>(null, processDefinitionId, bizKey, null));
	}

	public ProcessInstance startProcessInstanceById(String processDefinitionId, Map<String, Object> variables) {
		return commandExecutor.execute(new StartProcessInstanceCmd<ProcessInstance>(null, processDefinitionId, null, variables));
	}

	public ProcessInstance startProcessInstanceById(String processDefinitionId, String bizKey, Map<String, Object> variables) {
		return commandExecutor.execute(new StartProcessInstanceCmd<ProcessInstance>(null, processDefinitionId, bizKey, variables));
	}

	public ProcessInstance startProcessInstanceByMessage(String messageName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcessInstance startProcessInstanceByMessage(String messageName, String bizKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcessInstance startProcessInstanceByMessage(String messageName, Map<String, Object> processVariables) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcessInstance startProcessInstanceByMessage(String messageName, String bizKey, Map<String, Object> processVariables) {
		// TODO Auto-generated method stub
		return null;
	}

	public void signal(String executionId) {
		commandExecutor.execute(new SignalCmd(executionId, null, null, null));
	}

	public void signal(String executionId, Map<String, Object> processVariables) {
		commandExecutor.execute(new SignalCmd(executionId, null, null, processVariables));
	}
	
	public TokenQuery createTokenQuery() {
		return new TokenQueryImpl(commandExecutor);
	}
	
	public ProcessInstanceQuery createProcessInstanceQuery() {
		return new ProcessInstanceQueryImpl(commandExecutor);
	}

}