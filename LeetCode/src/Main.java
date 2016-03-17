public class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		Class c = main.getClass();
		ClassLoader loader = c.getClassLoader();
		try {
			Class c1  = loader.loadClass("Main");
			System.out.println(c1.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(loader);
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());
	}

}
