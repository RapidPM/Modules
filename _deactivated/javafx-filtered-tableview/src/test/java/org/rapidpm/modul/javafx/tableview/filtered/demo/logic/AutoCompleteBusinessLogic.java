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

package org.rapidpm.modul.javafx.tableview.filtered.demo.logic;

import javax.inject.Inject;

import org.rapidpm.commons.cdi.logger.CDILogger;
import org.rapidpm.modul.javafx.tableview.filtered.demo.model.autocompletetextfield.PersistentPojo;
import org.rapidpm.module.se.commons.logger.Logger;

/**
 * User: Sven Ruppert Date: 17.09.13 Time: 15:56
 */
public class AutoCompleteBusinessLogic {

    private @Inject @CDILogger Logger logger;

    public void doSomething(PersistentPojo pojo) {
        if (logger.isDebugEnabled()) {
            logger.debug("doSomething()->pojo " + pojo.getText());
        }
        //whtever to do here...
    }


}
