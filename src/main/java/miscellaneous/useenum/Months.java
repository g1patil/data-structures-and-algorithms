package miscellaneous.useenum;

public enum Months {
    JAN("january"){
        @Override
        public String getValue(){
            return "overridden value";
        }
    },
    FEB("february"),
    MARCH("march"),
    APR("april");

    public final String month;

    Months(String months){
        this.month = months;
    }

    public String getValue(){
        return this.month;
    }

    public static Months fromValueMonths(String value){
        for(Months element : Months.values()){
            if(element.month.equals(value)){
                return element;
            }
        }
        throw new IllegalArgumentException("unexpected error");
    }
}
