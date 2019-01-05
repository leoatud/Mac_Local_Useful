package others;

public class SingleTon {
    public static void main(String[] args) {

    }
}


/**
 * this is singleton first version
 * 一般singleton直接写这一种
 */
class Single{
    private static final Single s = new Single();
    private Single(){}
    public static Single getInstance(){
        return s;
    }
}

/**
 * 延迟加载single -->好处多：多线程访问时有隐患
 * 同步后比较低效
 */

class Single2{

    private static Single2 s = null;
    private Single2(){}
    public static Single2 getInstance(){
        if(s==null){
            synchronized (Single2.class){
                if(s==null)
                    s = new Single2();
            }
        }
        return s;
    }
}