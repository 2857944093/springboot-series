工厂方法模式（Factory Method）：

    定义一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法使一个类的实例化延迟到子类。


动机：

    对象创建中的有些过程包括决定创建哪个对象、管理对象的生命周期，以及管理特定对象的创建和销毁的概念。


适用场景：

    当一个类不知道它所需要创建的对象是那个类的时候。

    当一个类希望由它的子类来指定它所创建的对象的时候。

    当类创建对象的职责委托给某一个类时，并且你希望指定由哪一个类代理这一局部化的时候。


结构：
<img src="https://github.com/2857944093/springboot-series/blob/master/images/factory/%E5%B7%A5%E5%8E%82%E6%96%B9%E6%B3%95.png" />

代码示例：下面是一个披萨工厂
<p></p>

    `public class PizzaStore {
        SimplePizzaFactory factory;

        public PizzaStore(SimplePizzaFactory factory) {
            this.factory = factory;
        }

        public Product orderPizza(String type) {
             return  factory.createPizza(type);
        }
    }`
<p></p>

    public class SimplePizzaFactory {
        public Product createPizza(String type) {
            Product pizza = null;
            if (type.equals("cheese")) {
                pizza = new CheesePizza();
            } else if (type.equals("clam")) {
                pizza = new ClamPizza();
            } else if (type.equals("veggie")) {
                pizza = new VeggiePizza();
            }
            return pizza;
        }
    }
<p></p>

    public interface Product {
        void print();
    }
<p></p>

    //奶酪披萨
    public class CheesePizza implements Product {
        @Override
        public void print() {
            System.out.println("cheese");
        }
    }
<p></p>

    //蔬菜披萨
    public class VeggiePizza implements Product {
        @Override
        public void print() {
            System.out.println("veggie");
        }
    }
<p></p>

    public class Client{
      public static void main(String[] args) {
            SimplePizzaFactory factory = new SimplePizzaFactory();
            Product pizza = new PizzaStore(factory).orderPizza("clam");
            pizza.print();
        }
    }
<p></p>

    输出: clam

总结：

    工厂方法让我们将类的实例化那一部分分离出来，延迟到子类执行。其实Spring IOC中一直默默的为我们做着这工作。
