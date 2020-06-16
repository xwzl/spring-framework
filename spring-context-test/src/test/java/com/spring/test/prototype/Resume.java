package com.spring.test.prototype;


/**
 * <h2>什么是原型模式</h2>
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * <p>
 * 原型模式其实就是一个对象在创建另一个可定制的对象，而且不需要指定任何创建的细节。Java提供了
 * Cloneable接口，其中有一个唯一方法Clone()，实现这个接口就可以完成原型模式了。
 *
 * @author xuweizhi
 * @since 2020/06/15 14:16
 */
public class Resume implements Cloneable {

    private String name;
    private String sex;
    private String age;
    private String timeArea;
    private String company;

    public Resume(String name) {
        this.name = name;
    }

    //设置个人信息
    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    //设置工作经历
    public void setWorkExperience(String timeArea, String company) {
        this.timeArea = timeArea;
        this.company = company;
    }

    //显示
    public void display() {
        System.out.println(name + "\t" + sex + "\t" + age);
        System.out.println("工作经历：" + timeArea + "\t" + company);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTimeArea() {
		return timeArea;
	}

	public void setTimeArea(String timeArea) {
		this.timeArea = timeArea;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
