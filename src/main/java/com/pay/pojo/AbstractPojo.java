package com.pay.pojo;

import org.apache.commons.lang.builder.ToStringBuilder;

public class AbstractPojo {
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
