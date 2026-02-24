package main.g911;

// pu priv  pr
public class Student extends BaseEntity {
    private float grade;

    public Student(String v1, String v2) { // 5
        super(v1, v2);
        System.out.println("i am on Student con with v1 , v2 " + v1 + " " + v2);

    }

    public Student() {
        super(0);
        System.out.println("i am on Student con");
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

}
