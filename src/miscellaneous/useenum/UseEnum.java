package miscellaneous.useenum;


public class UseEnum {

    public void enumTesting(Months somemonth){}
    public static void main(String[] args) {
        System.out.println(Months.fromValueMonths("april"));
        System.out.println(Months.valueOf(Months.class,"april"));
    }
}