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

package org.rapidpm.data.table.cellvaluefactory.impl.lang;

/**
 * Sven Ruppert
 * User: svenruppert
 * Date: 15.11.11
 * Time: 08:32
 * This is part of the PrometaJava project please contact chef@sven-ruppert.de
 */

import org.apache.log4j.Logger;
import org.rapidpm.data.table.annotation.FactoryFor;
import org.rapidpm.data.table.cellvaluefactory.Factory;

@FactoryFor(String.class)
public class StringFactory implements Factory<String> {
    private static final Logger logger = Logger.getLogger(StringFactory.class);


    @Override
    public String createInstance() throws InstantiationException {
        return "";
    }
}
