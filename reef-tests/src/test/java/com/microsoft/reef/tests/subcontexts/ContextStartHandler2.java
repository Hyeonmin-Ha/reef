/**
 * Copyright (C) 2014 Microsoft Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoft.reef.tests.subcontexts;

import com.microsoft.reef.evaluator.context.events.ContextStart;
import com.microsoft.wake.EventHandler;

import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ContextStartHandler2 implements EventHandler<ContextStart> {

  @Inject
  ContextStartHandler2() {
  }

  @Override
  public void onNext(final ContextStart contextStart) {
    Logger.getLogger(this.getClass().getName()).log(Level.INFO, "ContextStart: " + contextStart);
  }
}
