package com.shield.model;

/**
 * @Package: com.shield.model
 * @ClassName: Organ
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/4 11:44
 * @Description:
 */
public class Organ {

    private String id;
    private String organName;
    private String pid;
    private Integer type;
    private Integer sex;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
