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

package demo;

import org.rapidpm.demo.cdi.commons.fx.components.CDIBaseGridPane;

/**
 * User: Sven Ruppert
 * Date: 09.07.13
 * Time: 14:44
 */
public class LoginPane extends CDIBaseGridPane<LoginPane, LoginController> {

//    private @Inject FXMLLoaderSingleton fxmlLoaderSingleton;
//    private @Inject LoginController controller;

    public LoginPane() {

    }

//    @PostConstruct
//    public void init() {
//        final FXMLLoader fxmlLoader = fxmlLoaderSingleton.getFXMLLoader(LoginPane.class);
//        fxmlLoader.setRoot(this);
//        try {
//            fxmlLoader.setController(controller);
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
//    }


    @Override public Class<LoginPane> getPaneClass() {
        return LoginPane.class;
    }
}
