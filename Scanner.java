import java.util.*;
import java.io.PushbackReader;
import java.io.Reader;
import java.io.FileReader;

public class Scanner 
{
    Map<String,String> reservedWords = new HashMap<>();
    Map<Character, String> tokens = new HashMap<>();
    Map<Character, String> XinuHuHu;
    Map<Character, String> whiteSpace;

    
    public enum State 
    {
        START, ACCEPT, ERR , ID, NUM, PUNCT, WHITESPACE
    }
    
    public enum CharType
    {
        LETTER, DIGIT, PUNCT, WHITESPACE, OTHER 
    }
    public CharType characterClass[];

    // 0,1,2,3
    public State[][] edges = 
    {
        /* START */  
        {
            State.ID, // LETTER
            State.NUM, // DIGIT
            State.PUNCT, // PUNCT
            State.WHITESPACE, // WHITESPACE
            State.ERR // OTHER
        },
        /* ACCEPT */  
        {
            State.START, // LETTER
            State.START, // DIGIT
            State.START, // PUNCT
            State.START, // WHITESPACE
            State.START // OTHER
        },
        /* ERROR or INVALID STATE */
        {
            State.ERR, // LETTER
            State.ERR, // DIGIT
            State.ERR, // PUNCT
            State.ERR, // WHITESPACE
            State.ERR // OTHER
        },
    };

  public Scanner() 
    {
        characterClass = new CharType[256];
        tokens.put('(', "LPAREN");
        tokens.put(')', "RPAREN");
        tokens.put('{', "LBRACE");
        tokens.put('}', "RBRACE");
        tokens.put(',', "COMMA");
        tokens.put(';', "SEMI");
        tokens.put('*', "STAR");
        tokens.put('!', "BANG");
        tokens.put('/', "DIVISION");
        tokens.put('\n', "NEWLINE"); 
        tokens.put(']', "RSQUARE");
        tokens.put('[', "LSQUARE");
        tokens.put('.', "PERIOD");
        tokens.put('=', "ASSIGN");
        tokens.put('"', "STRING_LITERAL"); // Assuming double quotes for string literals
        tokens.put('&', "BWAND");
        tokens.put('|', "BWOR");
        tokens.put('^', "XOR");
        tokens.put('~', "COMP");
        tokens.put('+', "PLUS");
        tokens.put('-', "MINUS");
        tokens.put('<', "LESSTHAN");
        tokens.put('>', "GREATERTHAN");
        tokens.put(' ', "SPACE"); // Assuming single space is a token
        //tokens.put('', "ILLEGAL");
        tokens.put('\t', "ILLEGAL"); // Tab considered illegal
        tokens.put('\f', "ILLEGAL"); // Form feed considered illegal
        tokens.put('\r', "ILLEGAL"); // Carriage return considered illegal

        reservedWords.put("class","CLASS");
        reservedWords.put("extends","EXTENDS");
        reservedWords.put("public","PUBLIC");
        reservedWords.put("int","INT");
        reservedWords.put("boolean","BOOLEAN");
        reservedWords.put("static","STATIC");
        reservedWords.put("void","VOID");
        reservedWords.put("main","MAIN");
        reservedWords.put("System.out.println","PRINT");
        reservedWords.put("true","TRUE");
        reservedWords.put("false","FALSE");
        reservedWords.put("this","THIS");
        reservedWords.put("new","NEW");
        reservedWords.put("String","STRING");
        reservedWords.put("return","RETURN");
        reservedWords.put("if","IF");
        reservedWords.put("while","WHILE");
        reservedWords.put("length","LENGTH");
        reservedWords.put("char","CHAR");
        reservedWords.put("else","ELSE");
        reservedWords.put("yield","YIELD");
        reservedWords.put("for","FOR");
        reservedWords.put("synchronized","SYNCHRONIZED");
        reservedWords.put("float","FLOAT");
        reservedWords.put("Xinu.print","XINUPRINT");
        reservedWords.put("Xinu.println","XINUPRINTLN");
        reservedWords.put("Xinu.printint","XINUPRINTINT");
        reservedWords.put("Xinu.readint","XINUREADINT");
    }
    public String reader(java.io.Reader reader) throws java.io.IOException
    {         
        char currChar;
         int currCharNum = reader.read();
         while (currCharNum  != -1){
            //System.out.println("This is working lol");
            currCharNum = reader.read();
            currChar = (char)currCharNum;
            if(tokens.get(currChar) !=null){
                System.out.println(tokens.get(currChar));
            }
         }
        
        boolean debug=false;
        return null;
    }

    public static void main(String [] args) throws java.io.IOException
    {
        //java.io.Reader reader =null;
        PushbackReader reader  = new PushbackReader(new FileReader("txtFile.txt")); 
        Scanner r = new Scanner();
        r.reader(reader);

    }
}
