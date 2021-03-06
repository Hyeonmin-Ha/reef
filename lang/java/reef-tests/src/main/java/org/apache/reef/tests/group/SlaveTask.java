/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.reef.tests.group;

import org.apache.reef.io.network.group.api.task.CommunicationGroupClient;
import org.apache.reef.io.network.group.api.task.GroupCommClient;
import org.apache.reef.task.Task;

import javax.inject.Inject;

/**
 * Slave task used for testing multiple communication groups.
 */
public final class SlaveTask implements Task {

  private CommunicationGroupClient commGroupClient;

  @Inject
  private SlaveTask(final GroupCommClient groupCommClient) {
    this.commGroupClient = groupCommClient.getCommunicationGroup(MultipleCommGroupsDriver.Group1.class);
    if (commGroupClient == null) {
      commGroupClient = groupCommClient.getCommunicationGroup(MultipleCommGroupsDriver.Group2.class);
    }
  }

  @Override
  public byte[] call(final byte[] memento) throws Exception {
    commGroupClient.getBroadcastReceiver(MultipleCommGroupsDriver.BroadcastOperatorName.class).receive();
    return null;
  }
}
