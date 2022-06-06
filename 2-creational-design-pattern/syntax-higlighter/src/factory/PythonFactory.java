package factory;

import environment.Environment;
import environment.PythonEnvironment;
import font.Consolas;
import font.Font;
import parser.Parser;
import parser.PythonParser;

public class PythonFactory extends LanguageFactory{

    @Override
    public Parser getParser() {
        return new PythonParser();
    }

    @Override
    public Font getFont() { 
        return new Consolas();
    }

    @Override
    public Environment getEnviroment() {
        return new PythonEnvironment();
    }
    
}
