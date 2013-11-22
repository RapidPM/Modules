/*
 * Copyright [2013] [www.rapidpm.org / Sven Ruppert (sven.ruppert@rapidpm.org)]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.rapidpm.commons.javafx.pairedtextfield;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.rapidpm.commons.javafx.pairedtextfield.demologic.DemoLogicContext;
import org.rapidpm.commons.javafx.pairedtextfield.demologic.DemoLogic;

/**
 * User: Sven Ruppert
 * Date: 08.10.13
 * Time: 15:45
 */
public class LeftTextFieldBindingCallable extends CDICallable<String> {

    @Inject @DemoLogicContext
    Instance<DemoLogic> demoLogic;

    @Override public String call() throws Exception {
        final String s = "l - " + demoLogic.get().doIt();
        return s;
    }
}
