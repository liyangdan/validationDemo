package com.example.demo.validator.groups;

import javax.validation.groups.Default;

/**
 * @author liyangdan
 * @date 2018/12/18 5:19 PM
 */

public class ValidGroups {
    public interface First  {
    }

    public interface Second {
    }

    public interface Thrid {
    }

    public interface Fourth {
    }

    public interface Fifth extends Default{
    }

}
