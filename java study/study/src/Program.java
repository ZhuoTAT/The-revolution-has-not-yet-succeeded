import java.util.Scanner;

class Program {
    static String[] CourseNames = { "数据结构", "面向对象程序设计", "数据库基础", "算法设计与分析", "计算机图形学" };
    static double[] CoursePoints = { 5, 4.5, 3, 3, 2 };
    static void printCourse() {
        System.out.println("本学期可选修课程为：");
        for (int i = 0; i < CourseNames.length; i++) {
            System.out.printf("%d——%s:%.1f学分\t\t", i + 1, CourseNames[i], CoursePoints[i]);
            if (i % 2 == 1)
                System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Course[] a = new Course[3];
        a[0] = new Course("数据结构",4,80);
        a[1] = new Course("数据库", 2,90);
        a[2] = new Course("软件工程",2, 70);
        Student John = new Student("John", a);
        Course c1 = new Course("数据结构",4);
        John.chooseCourse(c1);
        System.out.println(John);

        Course[] b = new Course[3];
        b[0] = new Course("高级语言",6,80);
        b[1] = new Course("数据库", 2,90);
        b[2] = new Course("面向对象",4, 75);
//		a[0] = new Course("高级语言",6,80);
//		a[1] = new Course("数据库", 2,90);
//		a[2] = new Course("面向对象",4, 75);
        Student Smith = new Student("smith", a);
        System.out.println(Smith);

        Student best=Student.WhoIsBest(John,Smith);
        System.out.println("John和smith中较好的是：\n"+best);

        System.out.printf("同学，请输入你的姓名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Student s = new Student(name);
        printCourse();
        System.out.printf("请输入你想选择的课程编号，输入0结束：\n");

        int number = scanner.nextInt();
        while (number != 0) {
            s.addCourse(new Course(CourseNames[number - 1], CoursePoints[number - 1]));
            number = scanner.nextInt();
        }

        System.out.println(s);

        System.out.println("一学期过去了...");
        System.out.println("现在由老师打分...");
        for (Course c : s.getMyCourses()) {
            System.out.printf("%s选修%s的成绩是：", s.name, c.getName());
            c.setGrade(scanner.nextInt());
        }
        System.out.println();

        System.out.println(name + "的成绩单：");
        System.out.println(s);

        best=Student.WhoIsBest(new Student[]{John,Smith,s});
        System.out.println("三人中最好的是：\n"+best);

    }

}
