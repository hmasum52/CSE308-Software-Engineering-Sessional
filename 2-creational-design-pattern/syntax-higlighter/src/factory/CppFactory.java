package factory;

import environment.CppEnvironment;
import environment.Environment;
import font.Font;
import font.Monaco;
import parser.CppParser;
import parser.Parser;

public class CppFactory extends LanguageFactory{

    @Override
    public Parser getParser() {
        return new CppParser();
    }

    @Override
    public Font getFont() {
        return new Monaco();
    }

    @Override
    public Environment getEnviroment() {
        return new CppEnvironment();
    }
    
}
