interface inf{
	public void wa();
	public void wa1();
}

class inf1 implements inf{

	@Override
	public void wa() {
		System.out.println("wa");
	}

	@Override
	public void wa1() {
	System.out.println("wa1");		
	}
	
}
abstract class test {
	public abstract void haha();
	public abstract void haha1();
}

// 抽象类必须被子类继承，子类（如果不是抽象类）必须覆写抽象类中的全部抽象方法。
class test1 extends test {

	@Override
	public void haha() {
		System.out.println("haha");
	}

	@Override
	public void haha1() {
		System.out.println("haha1");
	}

}

class Student extends Person {
	private int num;
	private String school;

	public Student() {
		System.out.println("student的无参构造方法");
	}

	public Student(int num, String school) {
		this.num = num;
		this.school = school;
	}

	public Student(String name, int age, String sex, int num, String school) {
		super(name, age, sex);
		this.num = num;
		this.school = school;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}

class Person {
	/*
	 * 构造块优先于构造方法执行，而且每次实例化对象时都会执行构造块中的代码。 静态代码块优先于构造方法执行，而在类中定义的静态代码块会优先于构造块执行，
	 * 且不管有多少对象产生，静态代码块只执行一次。
	 * 
	 * 使用static声明的方法，可以通过类名称直接引用。非static声明的方法可以调用static声明的属性或方法，
	 * 而static声明的方法不能调用非static类型声明的属性或方法。这也并不难理解，因为在程序中所有的属性和
	 * 方法必须在对象开辟堆内存之后才可以调用，而static类型的方法在对象未被实例化时就可以被类名调用，
	 * 所以如果直接由static方法调用非static操作，则有可能在属性还没有被初始化时就被调用了， 这一点在语法上就讲不通。
	 */
	static {
		System.out.println("静态代码块。。");
	}
	private String name;
	private int age;
	private String sex;

	public Person() {
		System.out.println("Person的无参构造方法。");
	}

	public Person(String name, int age, String sex) {
		System.out.println("Person调用有参构造方法");
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
//Thread 类实际上也是实现了Runnable接口
/*一、联系：两种方式，无论使用哪种，最终都必须依靠Thread类才能启动多线程，
 * 而在Thread类中的run方法调用的是Runnable接口中的run方法。
 * 二、区别：如果一个类继承Thread，则不适合于多个线程共享资源，因为每个Thread类的实例化对象只能对应
并启动一个线程，而实现Runnable接口，就可以方便地实现资源的共享，因为每个Runnalbe接口的实
例化对象可以作为参数传入到多个Thread对象中，从而用一个Runnable接口的实例化对象启动多个线程。
 */

class T extends Thread{
	private int ticket = 10;
	@Override
	public void run() {
		//System.out.println("T is running");
		for (int i = 0; i < 20; i++) {
			if(this.ticket>0){
				System.out.println("卖票：ticket="+this.ticket--);
			}
		}
	}	
}
class RunT1 implements Runnable{
	private int ticket = 10;
	@Override
	public void run() {
	//System.out.println("RunT1T1 is runnning");
	for (int i = 0; i < 20; i++) {
		if(this.ticket>0){
			System.out.println("卖票：ticket="+this.ticket--+Thread.currentThread().getName()+"买票");
		}
	}
	}
	
}

public class JAVABasic {
	final String fs = "zwb";

	public static void main(String[] args) {
		//	在程序开发中只要是多线程肯定永远以实现Runnable接口为主，因为实现Runnable接口相比.继承Thread类有如下好处：
		//避免点继承的局限，一个类可以继承多个接口。
		//->适合于资源的共享
		RunT1 rt = new RunT1();
		//RunT1 rt1 = new RunT1();
		Thread t1 = new Thread(rt,"zwb");
		Thread t2= new Thread(rt,"hsl");
		Thread t3= new Thread(rt,"zxz");
		t1.start();
		t2.start();
		t3.start();
		//Thread类有run 和start方法 前者线程有序执行 后者乱序执行  runnable 接口只有start方法，启动线程
		//使用前者可以共享火车票资源做到总共10张票，而后者每个线程都卖了10张 没有达到资源共享
		/*System.out.println("----------使用继承Thread类卖票---------------");
		Thread t4 = new T();
		Thread t5= new T();
		Thread t6= new T();
		t4.start();
		t5.start();
		t6.start();*/
		/*
		 * 在使用String类进行操作时，特别重要的一点：字符串的内容一旦声明则不可改变。在程序中，
		 * 改变String类对象的内容时，实际上是改变了String类对象的引用，将其指向了其它字符串所在的地址，
		 * 这样是很耗费内存资源的，因此，如果在开发中遇到改变很多次String类对象内容的时候，
		 * 
		 * 
		 * 一定要用StringBuffer类代替完成。
		 */

		Student st = new Student(331313, "NWPU");
		System.out.println(st.getSchool());
		Student stu = new Student("hls", 25, "女", 331313, "NWPU");
		//向上转型：用子类实例化父类对象或接口对象。调用被子类覆写的方法时，调用的是覆写后的方法，
		//不可以调用子类中独有的方法（即在父类或接口中没有），要想调用，则必须进行向下转型。
		Person p1 = (Person)stu;
		//向下转型：将实例化后的父类强制转化为其子类的实例化对象。在进行对象的向下转型前必须首先发生对象的向上转型。 
		Student s11 = (Student)p1;
		System.out.println(s11.getName());
		//instanceof关键字：对象 instanceof 类 ——>返回boolean类型值，对象为该类的实例化对象，则返回true，否则返回false 。
		System.out.println( s11 instanceof Student );
		System.out.println(p1.getName());
		System.out.println(stu.getSex());
		String s = "wqwq";
		String s2 = "sasada";
		s = "ffadasd";
		StringBuffer sb = new StringBuffer("sasas");
		/*Object类中的equals方法默认使用的是按地址进行比较的，并不能进行对内容的比较，
		 * 而在String类中覆写的方法则是进行内容比较的。
		 */
		System.out.println(s.equals(s2));
		// 当使用new关键字实例化对象时，才会调用构造方法。
		Person p = new Person();
		System.out.println(p.getAge());
		// Person p1 = new Person("zwb",25,"男");
		// System.out.println(p1.getName());
		final String r = "xx";
		// 使用浮点型数值时，默认的类型是double，后面加上f或F才被识别为float类型
		double d = 0.45;
		// 使用数组前一定要先开辟内存空间，当然也可以直接用静态赋值的方式。

		int[] array1 = { 1, 2, 3, 4 };
		System.out.println(d + "" + r);
		// 任何数据类型碰到String类型的变量或常量之后都会向String类型转换
		System.out.println();
		int[] array = new int[4];
		// 由于数组是引用数据类型，因此在数组操作中，栈内存中保存的永远是数组的访问地址（
		// 即引用，相当于C/C++中的指针），只开辟栈内存空间的数组是无法使用的，
		// 必须有指向的堆内存才可以使用，要想开辟堆内存则必须使用关键字new，
		// 然后只是将此堆内存的使用权交给了对应的栈内存空间，
		// 而且一个堆内存空间可以同时被多个栈内存空间所指向。
	}

}
