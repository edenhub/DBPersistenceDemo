package persistenceDemo.PesistenceInterface;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by lab on 2014/12/3.
 */
//应该将FormBean作为一个根出现，包装为一个xml节点
@XmlRootElement
public class FormBean {
    private String localActionId;
    private String field1;
    private String field2;
    private int age;

    public FormBean(){}

    public FormBean(String field1, String field2, int age) {
        this.field1 = field1;
        this.field2 = field2;
        this.age = age;
    }

    public String getLocalActionId() {
        return localActionId;
    }

    public void setLocalActionId(String localActionId) {
        this.localActionId = localActionId;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FormBean{" +
                "localActionId='" + localActionId + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", age=" + age +
                '}';
    }
}
