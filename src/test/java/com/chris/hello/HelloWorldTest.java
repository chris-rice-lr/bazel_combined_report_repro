package com.chris.hello;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {
  @Test
  public void test() {
    HelloWorld r = new HelloWorld();
    Assert.assertEquals("world", r.getWorld());
  }
}
