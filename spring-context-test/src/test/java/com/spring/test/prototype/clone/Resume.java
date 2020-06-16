package com.spring.test.prototype.clone;

/**
 * 克隆
 *
 * @author xuweizhi
 * @since 2020/06/15 14:21
 */

public class Resume implements Cloneable {

    private String name;
    private String sex;
    private String age;

    private WorkExperience work;


    public Resume(String name) {
        this.name = name;
        work = new WorkExperience();
    }

    public Resume(WorkExperience work) {
        this.work = work;
    }

    //设置个人信息
    public void SetPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    //设置工作经历
    public void SetWorkExperience(String workDate, String company) {
        work.setWorkDate(workDate);
        work.setCompany(company);
    }

    //显示
    public void Display() {
        System.out.println(name + "\t" + sex + "\t" + age);
        System.out.println("工作经历：" + work.getWorkDate() + "\t" + work.getCompany());
    }

    ///**
    // * Clone()方法是这样的，如果字段是值类型的，则对该字段执行逐位复制，如果字段是引用类型，则复制引用
    // * 但不复制引用的对象；因此，原始对象及其复本引用同一对象。
    // */
    //@Override
    //protected Object clone() throws CloneNotSupportedException {
    //    return super.clone();
    //}

    /**
     * 深复制
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume obj = (Resume) super.clone();
        obj.work = (WorkExperience) obj.work.clone();
        return obj;
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Resume a = new Resume("小明");
        a.SetPersonalInfo("男", "29");
        a.SetWorkExperience("1998-2000", "xx公司");

        Resume b = (Resume) a.clone();
        b.SetWorkExperience("1998-2018", "YY公司");

        Resume c = (Resume) a.clone();
        a.SetWorkExperience("1998-2000", "ZZ公司");

        a.Display();
        b.Display();
        c.Display();
    }


}
