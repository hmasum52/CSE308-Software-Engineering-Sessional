package parser;
public class PythonParser implements Parser {
    
    @Override
    public void parse() {
        System.out.println("Python parser");
    }

    @Override
    public String getParserName() {
        return "Python parser";
    }
}
