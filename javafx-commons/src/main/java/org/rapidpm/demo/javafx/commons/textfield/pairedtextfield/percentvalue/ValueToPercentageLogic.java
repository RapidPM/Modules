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

package org.rapidpm.demo.javafx.commons.textfield.pairedtextfield.percentvalue;

import javax.inject.Inject;

/**
 * User: Sven Ruppert
 * Date: 09.10.13
 * Time: 13:01
 */
public class ValueToPercentageLogic {

    @Inject PercentageFormatter formatter;

    //p=P*100/G
    public String convert(double baseValue, String text) {
        final Double aDouble = Double.valueOf(text);
        final double v = aDouble * 100 / baseValue;
        return formatter.format(v);
    }
}