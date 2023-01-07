package miscellaneous;

class SportsRadar {

    String[] input = null;

    public String subString(String first,String second,int j){
        char[] firstChar = first.toCharArray();
        char[] secondChar = second.toCharArray();


        StringBuilder sb = new StringBuilder();
        for(int i=0;i< secondChar.length;  i++){
            sb.append(secondChar[i]);
            if(first.contains(sb.toString())){
                continue;
            } else{
                sb.deleteCharAt(i);
                break;
            }
          
        }

        StringBuilder sb2 = new StringBuilder();
        for(int i = firstChar.length-1;i>=0;i--){
            sb2.insert(0,firstChar[i]);
            if(second.contains(sb2.toString())){
                continue;
            } else{
                sb2.deleteCharAt(0);
                break;
            }
          
        }

        String m1 = new String(sb);
        String m2 = new String(sb2);
        
        if(m1.length()==0 || m2.length()==0){
            return first;
        }
        if(m1.replaceAll("\\s", "").equals(m2.replaceAll("\\s", ""))){
            this.input[j]=null;
            return first.replaceAll(m1, second);
        }
        

        return first;
    }
    

    public static void main(String[] args) {
        SportsRadar in = new SportsRadar();
        in.input = new String[]{" Oh la","h lame sa","saint!"};

       

        for(int i=0;i< in.input.length;i++){

            String currentInput = in.input[i];
            if(currentInput!=null){
                for(int j=i+1;j< in.input.length;j++){
                    currentInput = in.subString(currentInput,in.input[j],j);
                }
            }
            
            if(currentInput!=null){
                System.out.println(currentInput+"!");
            }
        }
           
        
    }
    
}