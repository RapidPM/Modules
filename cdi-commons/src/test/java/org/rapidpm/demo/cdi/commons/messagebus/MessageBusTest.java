package org.rapidpm.demo.cdi.commons.messagebus;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rapidpm.demo.cdi.commons.messagebus.model.TestCallbackData;

/**
 * User: Sven Ruppert
 * Date: 01.08.13
 * Time: 14:58
 */
@RunWith(Arquillian.class)
public class MessageBusTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackages(true, "org.rapidpm.demo.cdi.commons")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    @Inject @CDIMessageBus MessageBus messageBus;

    @Test
    public void testMessageBus001() throws Exception {
        Assert.assertNotNull(messageBus);

        //someone that want to get the message - start
        final MessageBusCallback<TestCallbackData> callBack = new MessageBusCallback<TestCallbackData>() {
            @Override
            public void recordCallbackMessage(Message<TestCallbackData> m) {
                Assert.assertNotNull(m);
                final TestCallbackData value = m.getValue();
                Assert.assertNotNull(value.getValueLong());
                Assert.assertEquals(-1L, value.getValueLong().longValue());

                Assert.assertNotNull(value.getValueTxt());
                Assert.assertEquals("AEAEAE", value.getValueTxt());
            }
        };

        messageBus.registerCallBack(callBack);
        //someone that want to get the message - stop

        //someone that want to give the message - start
        final TestCallbackData testCallbackData = new TestCallbackData();
        testCallbackData.setValueTxt("AEAEAE");
        testCallbackData.setValueLong(-1L);

        final Message<TestCallbackData> message = new Message<>();
        message.setAnnotationLiteral(new AnnotationLiteral<TestCDIMessageBus>() {});
        message.setValue(testCallbackData);
        messageBus.post(message);
        //someone that want to give the message - stop


        //no listening enymore
        messageBus.destroyCallBack(callBack);

    }
}
