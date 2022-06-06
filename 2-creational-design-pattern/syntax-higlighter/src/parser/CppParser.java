package parser;

public class CppParser implements Parser{
    @Override
    public void parse(){
        System.out.println("C++ parser");
    }   
    
    @Override
    public String getParserName(){
        return "C++ parser";
    }
}
