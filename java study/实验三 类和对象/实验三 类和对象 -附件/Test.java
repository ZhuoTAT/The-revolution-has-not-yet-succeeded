import javax.management.MXBean;
import java.util.ArrayList;
import java.util.Arrays;

class Course {
    String name;
    int grade;
    double points;

    public Course(String name, int grade, double points) {
        this.name = name;
        this.grade = grade;
        this.points = points;
    }

    public int getGP() {
        if (grade >= 90) return 4;
        if (grade >= 80) return 3;
        if (grade >= 70) return 2;
        if (grade >= 60) return 1;
        return 0;
    }
    public boolean hasGrade(){
        return grade!=0;
    }
}

class Student {
    String name;
    ArrayList<Course> myCourse;

    public Student(String name) {
        this.name = name;
        this.myCourse = new ArrayList<>();
    }

    public Student(String name, Course[] courses) {
        this.name = name;
        this.myCourse = new ArrayList<>(Arrays.asList(courses));
    }

    public int courseGradeSum() {
        int sum = 0;
        for (Course c : myCourse) {
            sum += c.grade;
        }
        return sum;
    }

    public double courseEveGrade() {
        return (double) courseGradeSum() / myCourse.size();
    }

    public double getGPA() {
        double sumCredit = 0;
        double sumGradePoint = 0;
        for (Course c : myCourse) {
            sumCredit += c.points;
            sumGradePoint += c.getGP() * c.points;
        }
        return sumGradePoint / sumCredit;
    }

    public boolean isBetterThan(Student s) {
        return this.getGPA() > s.getGPA();
    }

    public static Student whoIsBest(Student s1, Student s2) {
        return s1.isBetterThan(s2) ? s1 : s2;
    }

    public static Student whoIsBest(Student[] ss) {
        Student best = ss[0];
        for (int i = 1; i < ss.length; i++) {
            if (!best.isBetterThan(ss[i])) {
                best = ss[i];
            }
        }
        return best;
    }

    public void addCourse(Course c) {
        if (!myCourse.contains(c)) {
            myCourse.add(c);
        } else {
            System.out.println("该课程已存在，无法再次选择");
        }
    }

    public void dropCourse(Course c) {
        if (myCourse.contains(c) && !c.hasGrade()) {
            myCourse.remove(c);
        } else {
            System.out.println("该课程不存在或已有成绩，无法退选");
        }
    }
}

class Test {
    public static void main(String[] args) {
        Course[] cs1 = {new Course("数据结构", 80, 5), new Course("数据库", 90, 3),new Course("面向对象", 80, 3)};
        Course[] cs2 = {new Course("软件工程", 60, 5), new Course("数据库", 80, 3),new Course("面向对象", 80, 3)};
        Course[] cs3 = {new Course("数据结构", 90, 5), new Course("数据库", 80, 3),new Course("软件工程", 90, 3),new Course("面向对象", 90, 3)};
        Student []s={new Student("John", cs1),new Student("Mike", cs2),new Student("Rose", cs3)};
        System.out.println(Student.whoIsBest(s).name + "的总成绩为：" + Student.whoIsBest(s).courseGradeSum());
        System.out.println(Student.whoIsBest(s).name + "的平均绩点为：" + Student.whoIsBest(s).getGPA());

    }
}