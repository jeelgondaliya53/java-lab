
class OutOfStockException extends Exception{
    private int fall;

    OutOfStockException(String msg,int fall){
        super(msg);
        this.fall=fall;
    }

    public int shortfall(){
        return fall;
    }
}

class InvalidQuantityException extends Exception{
    InvalidQuantityException(String msg){
        super(msg);
    }
}

class Warehouse{
    private int stock;

    Warehouse(int stock){
        this.stock=stock;
    }

    public void issue(String item,int qun)throws OutOfStockException,InvalidQuantityException{

        if(qun<=0){
            throw new InvalidQuantityException("quantity must be greater than 0");
        }

        if(qun>stock){
            int fall=qun-stock;
            throw new OutOfStockException("Not enough stock for "+item,fall);
        }

        stock=stock-qun;

        System.out.println("Issued "+qun+" "+item+"Remaining stock: "+stock);
    }
}

class Stock{
    public static void main(String[] args)
    {

        Warehouse w=new Warehouse(10);

        String[][] req={
            {"Laptop","3"},
            {"Keyboard","4"},
            {"Mouse","6"},
            {"Monitor","0"},
            {"Printer","2"}
        };

        for(String[] r:req)
        {

            String item=r[0];
            int q=Integer.parseInt(r[1]);

            try{
                w.issue(item,q);
            }

            catch(OutOfStockException e){
                System.out.println("Out of stock: "+item+" | Shortfall: "+e.shortfall());
            }

            catch(InvalidQuantityException e){
                System.out.println("Invalid quantity for "+item+": "+e.getMessage());
            }
        }

        System.out.println("All requests processed.");
    }
}
