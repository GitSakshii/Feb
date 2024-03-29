import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


    abstract class Product{
        int productid,price;
        String productName;
        public Product(int productid,int price,String productName)
        {
            this.productid=productid;
            this.price=price;
            this.productName=productName;
        }
        public int getProductid(){return productid;}
        public int getprice(){return price;}
        public String getProductName() {return productName;}

        public abstract void display();

    }
    class electronics extends Product{

        int warrantyperiod;
        int powerconsumption;
        public electronics(int productid,int price,String productName,int warrantyperiod,int powerconsumption)
        {
            super(productid,price,productName);
            this.warrantyperiod=warrantyperiod;
            this.powerconsumption=powerconsumption;
        }
        @Override
        public void display(){
            System.out.println("     Product ID: " + getProductid() + ", Product Name " + getProductName());
            System.out.println("     Price" + getprice() + " Warranty Period " + warrantyperiod + ", Power consumption" + powerconsumption);
            System.out.println("            *******************************");

        }
    }
    class Clothing extends Product{
       String size,color;
        public Clothing(int productid,int price,String productName,String size,String color)
        {
            super(productid,price,productName);
            this.size=size;
            this.color=color;
        }
        @Override
        public void display()
        { System.out.println("     Product ID: " + getProductid() + ", Product Name " + getProductName());
            System.out.println("     Price" + getprice() + " Size " + size+ ", Color" + color);

            System.out.println("            *******************************");

        }

    }
     class Order{
        private ArrayList<Product> orders;
        private double totalAmount;
        public Order() {
            orders = new ArrayList<>();
            totalAmount = 0.0;
        }

        //total amount
        public void addProduct(Product product) {
            orders.add(product);
            totalAmount += product.getprice(); // Add the price of the product to the total amount
        }
        public void display() {
            System.out.println("Order Details:");
            System.out.println("Total Amount: $" + totalAmount);
            System.out.println("Products:");
            for (Product product :Main.products) {
                System.out.println("- " + product.getProductName() + " " + product.getprice() + " ");
            }
        }

        //order history
        public void orderHistory(){
            System.out.println("Order history");
            for(Product p:orders){
                System.out.println(p.getProductName());
                System.out.println(p.getprice());
            }
        }
    }
    class admin
    {
        void addproduct(Product product)
        {
            Main.products.add(product);
        }
    }

    interface user{
        void browseproducts();
         void addtocart(Product product);
         void placeorder();

    }

     class guest implements user{
        private List<Product> cart;

        public guest() {
            cart = new ArrayList<>();
        }
        public void browseproducts()
        {
            System.out.println("    Product list ");
            for(Product product:Main.products)
            {
                product.display();
            }
        }
        public void addtocart(Product product){
            cart.add(product);
            System.out.println("Added " + product.getProductName() + " to cart.");
        }
        public void placeorder(){

        }


    }
    class registereduser implements user{
       private List<Product> cart;
        public registereduser(){
            this.cart=new ArrayList<>();
        }
        void addproduct(Product product)
        {
            Main.products.add(product);
        }
        public void browseproducts()
        {
            System.out.println("    Product list ");
            for(Product product:Main.products)
            {
                product.display();
            }
        }

       public void addtocart(Product product){
           cart.add(product);
           System.out.println("Added " + product.getProductName() + " to cart.");
       }
       public void placeorder(){
           Order order  = new Order();
           for(Product product : cart){
               order.addProduct(product);
           }
           order.display();
           order.orderHistory();
           cart.clear();
       }
    }
    public class Main {
        static List<Product> products=new ArrayList<>();;
        private static Scanner sc=new Scanner (System.in);

    public static void main(String[] args) {
        registereduser a=new registereduser();
        Order o=new Order();

        while(true)
        {
            System.out.println("    Welcome to Online Shopping System");
            System.out.println("    1.Guest User");
            System.out.println("    2.User Login");
            System.out.println("    3.Admin Login");
            System.out.println("    4.Exit");
            System.out.println("    Enter your choice:");
            int ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.println("    1.Browse Products");
                    System.out.println("    2.Add Product to cart");
                    System.out.println("    3.Place Order");
                    System.out.println("    Enter your choice");
                    int gc=sc.nextInt();
                    switch (gc)
                    {
                        case 1:
                            guest guest = new guest();
                            guest.browseproducts();
                            break;
                        case 2:
                            guest guest1=new guest();
                            System.out.print("Enter the Product Id to add to cart: ");
                            int productIdAdd = sc.nextInt();
                            sc.nextLine();
                            for (Product product : products) {
                                if (product.getProductid() == productIdAdd) {
                                    guest1.addtocart(product);
                                    break;
                                }
                            }
                        case 3:
                            System.out.println("Only registered users can place order");
                            System.out.println("Please register first");
                            break;
                    }

                    break;
                case 2:
                    // userlogin();
                    System.out.println("    1.Browse Products");
                    System.out.println("    2.Add Product to cart");
                    System.out.println("    3.Place Order");
                    System.out.println("    4.Order history");
                    System.out.println("    5.Exit");
                    System.out.println("    Enter your choice");
                    int uc=sc.nextInt();
                    switch (uc)
                    {
                        case 1:
                            a.browseproducts();
                            System.out.println("Press any key..");
                            sc.nextLine();
                            break;
                        case 2:

                            System.out.println("Add to cart");
                            System.out.print("Enter the Product Id :");
                            int productIdAdd = sc.nextInt();
                            sc.nextLine();
                            for (Product product : products) {
                                if (product.getProductid() == productIdAdd) {
                                    a.addtocart(product);
                                    break;
                                }
                            }
                            break;
                        case 3:
                           a.placeorder();
                           break;
                        case 4:
                            o.orderHistory();
                            break;
                        default:
                            System.out.println("invalid");
                    }
                    break;
                case 3:
                    //adminlogin();
                    System.out.println("    1.Add product");
                    System.out.println("    Enter Choice");
                    int c=sc.nextInt();

                    switch(c)
                    {
                        case 1:
                            System.out.println("   1. Add Electronics");
                            System.out.println("   2. Add Clothes");
                            int p=sc.nextInt();
                            switch (p)
                            {
                                case 1:
                                    System.out.println("    Product Id");
                                    int pid=sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("    Enter Product Name");
                                    String pname=sc.nextLine();
                                    System.out.println("    Enter Price:");
                                    int price=sc.nextInt();
                                    System.out.println("    Warranty Period");
                                    int warranty=sc.nextInt();
                                    System.out.println("    Power Consumption");
                                    int power=sc.nextInt();
                                    electronics e=new electronics(pid,price,pname,warranty,power);
                                    a.addproduct(e);
                                    System.out.println("    Product Added Successfully");
                                    System.out.println("    Press any key.."   );
                                    sc.nextLine();
                                    break;
                                case 2:
                                    System.out.println("    Product Id");
                                    int prod=sc.nextInt();
                                    System.out.println("    Enter Product Name");
                                    String name=sc.nextLine();
                                    System.out.println("    Enter Price:");
                                    int pprice=sc.nextInt();
                                    System.out.println("    Size: ");
                                    String size=sc.nextLine();
                                    System.out.println("    Color");
                                    String color=sc.nextLine();
                                    Clothing cloth=new Clothing(prod,pprice,name,size,color);
                                    a.addproduct(cloth);
                                    System.out.println("    Product Added Successfully");
                                    System.out.println("    Press any key"   );
                                    sc.nextLine();
                                    break;
                            }
                          break;
                        default:
                            System.out.println("    Enter Valid option");
                    }
                    break;
                case 4:

                    System.out.println("Exiting...");
                    sc.close(); // Close the scanner
                    System.exit(0); // Exit the program

                default:
                    System.out.println("    Invalid Choice.Please Enter a valid option");

            }
        }
    }
}
