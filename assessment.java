import java.util.*;

class Discount{
    public static int flat_10_discount(int qty){
        int flat_disc = qty;
        flat_disc = flat_disc - 10;
        return flat_disc;
    }
    public static int bulk_5_discount(int qty){
        int bulk5_disc = qty;
        bulk5_disc = (5*bulk5_disc)/100;
        return bulk5_disc;
    }
    public static int bulk_10_discount(int qty){
        int bulk10_disc = qty;
        bulk10_disc = (10*bulk10_disc)/100;
        return bulk10_disc;
    }
    public static int tired_50_discount(int qty){
        int tired_disc = qty;
        tired_disc = tired_disc/100;
        return tired_disc;
    }
}
class Total extends Discount{
    int qty_a, qty_b, qty_c, total_qty=0, discount_val=0;
    String wrapped="";
    int price_A = 20, price_B = 40, price_C = 50,disc_A=0, disc_B=0, disc_C=0, total_price_A,total_price_B,total_price_C;
    public Total(int qty_a, int qty_b, int qty_c, String wrapped){
        this.qty_a = qty_a;
        this.qty_b = qty_b;
        this.qty_c = qty_c;
        this.wrapped = wrapped;
        total_qty = qty_a+qty_b+qty_c;
    }
    public int total_A(){
        total_price_A = price_A*qty_a;
        if(qty_a>10){
            disc_A = bulk_5_discount(qty_a);
            total_price_A = total_price_A - disc_A;
        }
        return total_price_A;
    }
    public int total_B(){
        total_price_B = price_B*qty_b;
        if(qty_b>10){
            disc_B = bulk_5_discount(qty_b);
            total_price_B = total_price_B - disc_B;
        }
        return total_price_B;
    }
    public int total_C(){
        total_price_C = price_C*qty_c;
        if(qty_c>10){
            disc_C = bulk_5_discount(qty_c);
            total_price_C = total_price_C - disc_C;
        }
        return total_price_C;
    }
    public void total_Cost(){
        int total_cost = total_A()+total_B()+total_C();
        if((total_qty>30) && qty_a>15){
            total_price_A = tired_50_discount(total_price_A);
            discount_val  += total_price_A;
        }
        if((total_qty>30) && qty_b>15){
            total_price_B = tired_50_discount(total_price_B);
            discount_val  += total_price_B;
        }
        if((total_qty>30) && qty_c>15){
            total_price_C = tired_50_discount(total_price_C);
            discount_val  += total_price_C;
        }
        if(total_cost>200){
            discount_val  += flat_10_discount(total_cost);
        }
        if(total_qty>20){
            discount_val  += bulk_10_discount(total_cost);
        }
        total_cost -= discount_val; 
        System.out.println("Total : "+total_cost);
    }
}
public class assessment extends Total {

        public assessment(int qty_a, int qty_b, int qty_c, String wrapped) {
        super(qty_a, qty_b, qty_c, wrapped);
        total_Cost();
        //TODO Auto-generated constructor stub
    }

        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! What should you want to by, Please Enter the Qyantity : ");
        System.out.println("Enter Quantity A : ");
        int Quantity_A = sc.nextInt();
        System.out.println("Enter Quantity B : ");
        int Quantity_B = sc.nextInt();
        System.out.println("Enter Quantity C : ");
        int Quantity_C = sc.nextInt();
        System.out.print("Wrapping as gift ? Y or N : ");
        String Gift_Wrapped = sc.next();

        assessment a = new assessment(Quantity_A, Quantity_B, Quantity_C, Gift_Wrapped);
     

    }

}