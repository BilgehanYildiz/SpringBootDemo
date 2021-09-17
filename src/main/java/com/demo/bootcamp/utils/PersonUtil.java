package com.demo.bootcamp.utils;

import com.demo.bootcamp.configuration.MyConfiguration;

public class PersonUtil {

    public String returnKey()
    {
      MyConfiguration myConfiguration=  (MyConfiguration)ApplicationContextUtils.getApplicationContext().getBean(MyConfiguration.class);
      return myConfiguration.getKey2();
    }
}
