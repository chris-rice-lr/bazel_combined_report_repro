package com.chris.foo;

import org.junit.Assert;
import org.junit.Test;

public class FooTest {
  @Test
  public void test() {
    Foo r = new Foo();
    Assert.assertEquals("bar", r.getBar());
  }
}
