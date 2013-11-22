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

package org.rapidpm.commons.cdi.tx;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.rapidpm.commons.cdi.ManagedInstanceCreator;
import org.rapidpm.commons.cdi.logger.CDILogger;
import org.rapidpm.lang.cache.generic.Cacheable;
import org.rapidpm.module.se.commons.logger.Logger;

/**
 * User: Sven Ruppert
 * Date: 12.07.13
 * Time: 16:17
 */
@Cacheable(primaryKeyAttributeName = "txNumber", className = CDITransaction.class)
public class CDITransaction {
    private String txNumber = System.nanoTime() + "";

    private @Inject BeanManager beanManager;
    private @Inject @CDILogger Logger logger;
    private @Inject ManagedInstanceCreator managedInstanceCreator;

    private CDITransactionContext transactionContext;

    @PostConstruct
    public void init() {
        if (logger.isDebugEnabled()) {
            logger.debug(" transactionContext = " + transactionContext);
        }
        transactionContext = (CDITransactionContext) beanManager.getContext(CDITransactionScope.class);
    }

    private final List<CDITransactionStep> stepList = new ArrayList<>();

    public void execute() {
        begin(txNumber);
        if (logger.isInfoEnabled()) {
            logger.info("stepList = " + stepList.size());
        }
        for (final CDITransactionStep cdiTransactionStep : stepList) {
            final CDITransactionStep step = managedInstanceCreator.activateCDI(cdiTransactionStep);
            step.doIt();
        }
        end(txNumber);
    }

    private void begin(final String txNummber) {
        if (logger.isDebugEnabled()) {
            logger.debug(" begin -> " + txNumber);
            logger.debug(" transactionContext = " + transactionContext);
        }
        transactionContext.begin(txNummber);
    }

    private void end(final String txNummber) {
        if (logger.isDebugEnabled()) {
            logger.debug("  end -> " + txNumber);
            logger.debug(" transactionContext = " + transactionContext);
        }
        transactionContext.end(txNummber);
    }

    public String getTxNumber() {
        return txNumber;
    }

    public void addCDITransactionStep(final CDITransactionStep step) {
        stepList.add(step);
    }

    public static abstract class CDITransactionStep {

        protected CDITransactionStep() {

        }

        public abstract void doIt();
    }


}