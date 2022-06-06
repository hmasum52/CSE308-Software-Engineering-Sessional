package factory;

import environment.CEnviroment;
import environment.Environment;
import font.CourierNew;
import font.Font;
import parser.CParser;
import parser.Parser;

public class CFactory extends LanguageFactory{

    @Override
    public Parser getParser() {
        return new CParser();
    }

    @Override
    public Font getFont() {
        return new CourierNew();
    }

    @Override
    public Environment getEnviroment() {
        return new CEnviroment();
    }
    
}
