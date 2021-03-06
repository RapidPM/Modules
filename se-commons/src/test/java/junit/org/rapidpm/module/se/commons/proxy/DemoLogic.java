/*
 * Copyright [2014] [www.rapidpm.org / Sven Ruppert (sven.ruppert@rapidpm.org)]
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

package junit.org.rapidpm.module.se.commons.proxy;

/**
* Created by ts40 on 19.02.14.
*/
public class DemoLogic implements DemoInterface{

    public String value = null;

    @Override
    public void doSomething() {
        System.out.println("doSomething-> DemoLogic");
    }

    public String getSomething(){ return "nooop";}

    public String getValue() {
        return value;
    }
}
