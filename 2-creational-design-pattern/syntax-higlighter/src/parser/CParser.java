package parser;

public class CParser implements Parser{
    @Override
    public void parse(){
        System.out.println("C parser");
    }    

    @Override
    public String getParserName(){
        return "C parser";
    }
}
