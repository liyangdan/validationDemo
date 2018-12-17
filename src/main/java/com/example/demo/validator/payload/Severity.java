package com.example.demo.validator.payload;

import javax.validation.Payload;

/**
 * @author liyangdan
 * @date 2018/12/16 9:56 PM
 */

public class Severity {
    public interface Info extends Payload {
    }

    public interface Error extends Payload {
    }
}
