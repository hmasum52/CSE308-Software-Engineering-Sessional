import environment.Environment;
import factory.LanguageFactory;
import font.Font;
import parser.Parser;

public class Editor {
    private static Editor editor;

    private LanguageFactory languageFactory;

    private Font font;
    private Parser parser;
    private Environment environment;

    private Editor(){
        
    }

    public synchronized static Editor getInstance(){
        if(editor == null){
            editor = new Editor();
        }
        return editor;
    }

    public void openFile(String fileName){
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        languageFactory = LanguageFactory.getFactory(fileExtension);
        if(languageFactory != null){
            parser = languageFactory.getParser();
            font = languageFactory.getFont();
            environment = languageFactory.getEnviroment();
            System.out.println("Selected font: " + font.getFontName());
            System.out.println("Environment: " + environment.getEnviromentName());
            System.out.println("Parser: " + parser.getParserName());
        }else{
            System.out.println("File extension not supported");
        }
    }
}
