package fan;

public class goods {
    private int number;
    private String name;
    private double price;
    private int remain;
    public goods() {

    }
    public goods(int number,String name,double price,int remain){
        this.number = number;
        this.name = name;
        this.price = price;
        this.remain = remain;
    }
    public int getNumber(){
        return number;
    }
    public int getRemain(){
        return remain;
    }
    public String getname(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }
}
