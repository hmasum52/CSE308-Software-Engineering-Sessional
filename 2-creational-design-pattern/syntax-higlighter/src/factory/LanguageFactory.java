package factory;

import environment.Environment;
import font.Font;
import parser.Parser;

public abstract class LanguageFactory{
    public abstract Parser getParser();
    public abstract Font getFont();
    public abstract Environment getEnviroment();

    public static LanguageFactory getFactory(String fileExtension){
        switch(fileExtension){
            case ".c":
                return new CFactory();
            case ".cpp":
                return new CppFactory();
            case ".py":
                return new PythonFactory();
            default:
                return null;
        }
    }
}