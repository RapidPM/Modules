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

import org.rapidpm.data.table.annotation.FactoryFor;
import org.rapidpm.data.table.cellvaluefactory.Factory;

/**
 * Long-Factory.
 *
 * @author Alexander Vos
 */
@FactoryFor(Long.class)
public class LongFactory implements Factory<Long> {
    @Override
    public Long createInstance() {
        return 0L;
    }
}
