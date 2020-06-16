package com.spring.test.prototype;

import org.junit.Test;

/**
 * 客服端实现
 *
 * @author xuweizhi
 * @since 2020/06/15 14:19
 */
public class Client {

    /**
     * 只需要调用Clone方法就可以实现新简历的生成，并且可以再修改新简历的细节。
     * <p>
     * 它的好处，不用重新初始化对象，而是动态地获得对象运行时的状态。
     */
    @Test
    public void testPrototype() throws CloneNotSupportedException {
        Resume a = new Resume("小明");
        a.setPersonalInfo("男", "29");
        a.setWorkExperience("1998-2000", "xx公司");

        Resume b = (Resume) a.clone();
        b.setWorkExperience("1998-2018", "YY公司");

        Resume c = (Resume) a.clone();
        c.setPersonalInfo("男", "24");

        a.display();
        b.display();
        c.display();
    }


}
