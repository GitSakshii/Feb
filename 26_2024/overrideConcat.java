class Strings
{
    private String s;
    Strings(String s){
        this.s=s;
    }
    public Strings concat(Strings s){
        return new Strings(this.s+s.getString());
    }
    public String getString(){
        return s;
    }
}
public class overrideConcat{
    public static void main(String[] args)
    {
        Strings str1=new Strings("abc");
        Strings  str2=new Strings("def");
       Strings ans= str1.concat(str2);
        System.out.println(ans.getString());


    }
}
