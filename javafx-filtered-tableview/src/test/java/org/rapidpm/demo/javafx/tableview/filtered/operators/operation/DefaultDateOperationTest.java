package org.rapidpm.demo.javafx.tableview.filtered.operators.operation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.rapidpm.demo.javafx.tableview.filtered.operators.DateOperator;
import org.rapidpm.demo.javafx.tableview.filtered.operators.IFilterOperator;
import org.rapidpm.demo.javafx.tableview.filtered.operators.StringOperator;

/**
 * DefaultDateOperation Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Mai 6, 2013</pre>
 */
public class DefaultDateOperationTest {

    private Date BEFORE_NOW;
    private Date NOW;
    private Date AFTER_NOW;

    @Before
    public void before() throws Exception {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        BEFORE_NOW = sdf.parse("2013-04-01");
        NOW =  sdf.parse("2013-05-01");
        AFTER_NOW =  sdf.parse("2013-06-01");

        Assert.assertNotEquals(BEFORE_NOW, NOW);
        Assert.assertNotEquals(AFTER_NOW, NOW);
        Assert.assertNotEquals(AFTER_NOW, BEFORE_NOW);

    }

    @After
    public void after() throws Exception {
    }

    @org.junit.Test
    public void testNONE01() throws Exception {
        final DefaultDateOperation defOp = new DefaultDateOperation();
        final DateOperator strOp = new DateOperator(DateOperator.Type.NONE, NOW);
        Assert.assertFalse(defOp.check(strOp, NOW));
        Assert.assertFalse(defOp.check(strOp, new Date()));
        Assert.assertFalse(defOp.check(strOp, null));
    }
    @org.junit.Test
    public void testEQUALS01() throws Exception {
        final DefaultDateOperation defOp = new DefaultDateOperation();
        final DateOperator strOp = new DateOperator(DateOperator.Type.EQUALS, NOW);
        Assert.assertTrue(defOp.check(strOp, new Date()));
        Assert.assertFalse(defOp.check(strOp, NOW));
        Assert.assertTrue(defOp.check(strOp, null));
    }

    @org.junit.Test
    public void testNOTEQUALS01() throws Exception {
        final DefaultDateOperation defOp = new DefaultDateOperation();
        final Date newDate = new Date();
        final DateOperator strOp = new DateOperator(DateOperator.Type.NOTEQUALS, newDate);
        Assert.assertTrue(defOp.check(strOp, newDate));
        Assert.assertFalse(defOp.check(strOp, NOW));

        Assert.assertTrue(defOp.check(strOp, null));
    }

    @org.junit.Test
    public void testBEFORE01() throws Exception {
        final DefaultDateOperation defOp = new DefaultDateOperation();
        final DateOperator strOp = new DateOperator(DateOperator.Type.BEFORE, NOW);
        Assert.assertTrue(defOp.check(strOp, AFTER_NOW));
        Assert.assertTrue(defOp.check(strOp, NOW));
        Assert.assertTrue(defOp.check(strOp, null));

        Assert.assertFalse(defOp.check(strOp, BEFORE_NOW));
    }

    @org.junit.Test
    public void testBEFOREON01() throws Exception {
        final DefaultDateOperation defOp = new DefaultDateOperation();
        final DateOperator strOp = new DateOperator(DateOperator.Type.BEFOREON, NOW);
        Assert.assertTrue(defOp.check(strOp, AFTER_NOW));
        Assert.assertTrue(defOp.check(strOp, null));

        Assert.assertFalse(defOp.check(strOp, NOW));
        Assert.assertFalse(defOp.check(strOp, BEFORE_NOW));
    }
    @org.junit.Test
    public void testAFTER01() throws Exception {
        final DefaultDateOperation defOp = new DefaultDateOperation();
        final DateOperator strOp = new DateOperator(DateOperator.Type.AFTER, NOW);
        Assert.assertTrue(defOp.check(strOp, BEFORE_NOW));
        Assert.assertTrue(defOp.check(strOp, NOW));
        Assert.assertTrue(defOp.check(strOp, null));

        Assert.assertFalse(defOp.check(strOp, AFTER_NOW));
    }

    @org.junit.Test
    public void testAFTERON01() throws Exception {
        final DefaultDateOperation defOp = new DefaultDateOperation();
        final DateOperator strOp = new DateOperator(DateOperator.Type.AFTERON, NOW);
        Assert.assertTrue(defOp.check(strOp, BEFORE_NOW));
        Assert.assertTrue(defOp.check(strOp, null));

        Assert.assertFalse(defOp.check(strOp, NOW));
        Assert.assertFalse(defOp.check(strOp, AFTER_NOW));
    }




} 