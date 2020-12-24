import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Date;

public class Student {

    private String name;
    private Integer age;
    private String sex;
    private Date birthdy;

    public Student(){

    }

    public Student(String name, Integer age, String sex, Date birthdy) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthdy = birthdy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdy() {
        return birthdy;
    }

    public void setBirthdy(Date birthdy) {
        this.birthdy = birthdy;
    }
}
