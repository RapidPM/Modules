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

package gui.org.rapidpm.demo.javafx.searchbox;

import javax.inject.Inject;

import gui.org.rapidpm.demo.javafx.searchbox.demo.DemoDataBuilder;
import gui.org.rapidpm.demo.javafx.searchbox.demo.SearchBoxDemoPane;
import gui.org.rapidpm.demo.javafx.searchbox.demo.SearchBoxDemoPaneController;
import gui.org.rapidpm.demo.javafx.searchbox.demo.model.TransientDemoDataRow;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.rapidpm.demo.cdi.commons.fx.JavaFXBaseTest;

/**
 * User: Sven Ruppert
 * Date: 30.08.13
 * Time: 06:56
 */
public class SearchBoxTest extends JavaFXBaseTest {
    @Override protected Class<? extends JavaFXBaseTest> getTestClass() {
        return SearchBoxTest.class;
    }

    public static class TestImpl extends JavaFXBaseTest.JavaFXBaseTestImpl {

        @Inject SearchBoxDemoPane root;
        @Inject DemoDataBuilder dataBuilder;

        @Override public boolean isExitAfterTest() {
            return false;
        }

        @Override protected Class<? extends JavaFXBaseTest> getParentTestClass() {
            return SearchBoxTest.class;
        }

        @Override public void testImpl(Stage stage) {
            stage.setTitle("SearchBoxTest");  //i18n
            stage.setScene(new Scene(root, 1024, 786));

            final SearchBoxDemoPaneController controller = root.getController();
            final ObservableList<TransientDemoDataRow> transientDemoDataRows = dataBuilder.create();
            controller.tableView.setItems(transientDemoDataRows);
            controller.SearchBox.refreshIndex(transientDemoDataRows);
        }
    }
}
