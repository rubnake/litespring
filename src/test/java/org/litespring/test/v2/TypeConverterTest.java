package org.litespring.test.v2;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.SimpleTypeConverter;
import org.litespring.beans.TypeConverter;
import org.litespring.beans.TypeMismatchException;

import static org.junit.Assert.fail;

public class TypeConverterTest {
    @Test
    public void typeConverterStringToInt() throws TypeMismatchException {
        TypeConverter converter = new SimpleTypeConverter();

        Integer i = converter.convertIfNecessary("3", Integer.class);
        Assert.assertEquals(3, i.intValue());

        try {
            converter.convertIfNecessary("3.1", Integer.class);
        } catch (TypeMismatchException e) {
            return;
        }

        fail();

    }

    @Test
    public  void  testConvertStringToBoolean() throws TypeMismatchException {
        TypeConverter converter = new SimpleTypeConverter();
        Boolean b = converter.convertIfNecessary("true", Boolean.class);

        Assert.assertEquals(true, b.booleanValue());

        try {
            converter.convertIfNecessary("xxxyyyzzz", Boolean.class);
        } catch (TypeMismatchException e) {
            return;
        }
        fail();

    }
}
