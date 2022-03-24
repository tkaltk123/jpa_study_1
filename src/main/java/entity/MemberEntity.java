package entity;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER")
public class MemberEntity {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "id : " + id + ", name : " + name + ", age : " + age.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
