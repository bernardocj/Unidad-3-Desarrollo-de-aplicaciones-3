package mx.edu.utng.orders.sqlite;

import java.util.UUID;



public class OrderContract {

    interface OrderHeaderColumns{
        String ID = "id";
        String DATE = "record_date";
        String ID_CUSTOMER = "id_customer";
        String ID_METHOD_PAYMENT = "id_method_payment";
    }

    interface OrderDetailColumns{
        String ID = "id";
        String SEQUENCE = "sequence";
        String ID_PRODUCT = "id_product";
        String QUANTITY = "quantity";
        String PRICE = "price";
    }

    interface ProductColumns{
        String ID = "id";
        String NAME = "name";
        String PRICE = "price";
        String STOCK = "stock";
    }

    interface VitaminColumns{
        String ID = "id";
        String NAME = "name";
        String DOSE = "dose";
        String PRICE = "price";
        String TYPE = "type";
    }
    interface  CustomerColumns{
        String ID = "id";
        String FIRSTNAME = "firstname";
        String LASTNAME = "lastname";
        String PHONE = "phone";
    }

    interface MethodPaymentColumns{
        String ID = "id";
        String NAME = "name";
    }
    interface RepliesColumns{
        String REPLY_ID = "reply_id";
        String REPLY_CONTENT = "reply_content";
        String REPLY_DATE = "reply_date";
    }

    public static class OrderHeaders implements OrderHeaderColumns{
        public static String generateIdOrderHeader(){
            return  "OH-"+ UUID.randomUUID().toString();
        }
    }

    public static class OrderDetails implements OrderDetailColumns{

    }

    public static class Products implements ProductColumns{
        public static String generateIdProduct(){
            return  "PR-"+ UUID.randomUUID().toString();
        }
    }

    public static class Customers implements CustomerColumns{
        public static String generateIdCustomer(){
            return  "CU-"+ UUID.randomUUID().toString();
        }
    }

    public static class MethodsPayment implements MethodPaymentColumns{
        public static String generateIdMethodPayment(){
            return  "MP-"+ UUID.randomUUID().toString();
        }
    }
    public static class Vitamins implements VitaminColumns{
        public static String generateIdVitamin(){
            return  "VI-"+ UUID.randomUUID().toString();
        }
    }
    public static class Replies implements RepliesColumns{
        public static String generateIdReplies(){
            return  "RE-"+ UUID.randomUUID().toString();
        }
    }

    private OrderContract() {

    }
}
