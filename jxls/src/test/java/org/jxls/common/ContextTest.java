package org.jxls.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author Leonid Vysochyn
 */
public class ContextTest {

    @Test
    public void addVars() {
        Context context = new Context();
        context.putVar("col", Integer.valueOf(1));
        context.putVar("row", Integer.valueOf(2));
        context.putVar("obj", "12345");
        Map<String, Object> vars = context.toMap();
        assertEquals(vars.get("col"), Integer.valueOf(1));
        assertEquals(vars.get("row"), Integer.valueOf(2));
        assertEquals(vars.get("obj"), "12345");
    }

    @Test
    public void removeVar() {
        Context context = new Context();
        context.putVar("col", Integer.valueOf(1));
        Map<String, Object> vars = context.toMap();
        assertEquals(vars.get("col"), Integer.valueOf(1));
        context.removeVar("col");
        vars = context.toMap();
        assertFalse( vars.containsKey("col") );
    }
    
    @Test 
    public void testToString() {
        Context context = new Context();
        context.putVar("x", Integer.valueOf(1));
        context.putVar("y", "Abc");
        assertTrue(context.toString().contains("y=Abc"));
        assertTrue(context.toString().contains("x=1"));
    }

    @Test
    public void testCreateFromMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("x", "Abc");
        map.put("y", Integer.valueOf(10));
        Context context = new Context(map);
        map.clear();
        assertEquals("Abc", context.getVar("x"));
        assertEquals(Integer.valueOf(10), context.getVar("y"));
    }
}
