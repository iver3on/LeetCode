class Gen2 {
    private Object ob; // 定义一个通用类型成员
 
    public Gen2(Object ob) {
        this.ob = ob;
    }
 
    public Object getOb() {
        return ob;
    }
 
    public void setOb(Object ob) {
        this.ob = ob;
    }
 
    public void showTyep() {
        System.out.println("T的实际类型是: " + ob.getClass().getName());
    }
}
 
public class GenDemo2 {
    public static void main(String[] args) {
        // 定义类Gen2的一个Integer版本
        Gen2 intOb = new Gen2(new Integer(88));
        intOb.showTyep();
        
        //没有使用泛型 就必须强制类型转换  使用了泛型 就没有必要进行这些操作
        int i = (Integer) intOb.getOb();
        System.out.println("value= " + i);
        System.out.println("---------------------------------");
        // 定义类Gen2的一个String版本
        Gen2 strOb = new Gen2("Hello Gen!");
        strOb.showTyep();
        String s = (String) strOb.getOb();
        System.out.println("value= " + s);
    }
}