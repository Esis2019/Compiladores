/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class estilos {
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","valor"};
       
       String [] registro =new String [2];
       modelo = new DefaultTableModel(null,titulos);
       
       try {
           ArrayList lista = new ArrayList();
           ArrayList datos = new ArrayList();
           lista.add("   id1");lista.add("   id2");lista.add("   id3");lista.add("   id4");lista.add("   id5");
           lista.add("   id6");lista.add("   id7");lista.add("   id8");lista.add("   id9");lista.add("   id10");
           lista.add("   id11");lista.add("   id12");lista.add("   id13");lista.add("   id14");lista.add("   id15");
           lista.add("   id16");lista.add("   id17");lista.add("   id18");lista.add("   id19");lista.add("   id20");
           lista.add("   id21");lista.add("   id22");lista.add("   id23");lista.add("   id24");lista.add("   id25");
           lista.add("   id26");
           /*
           lista.add("   ELLIPSIS");lista.add("   COLONCOLON");lista.add("   DOTSTAR");lista.add("   ADDEQ");
           lista.add("   SUBEQ");lista.add("   MULEQ");lista.add("   DIVEQ");lista.add("   MODEQ");
           lista.add("   XOREQ");lista.add("   ANDEQ");lista.add("   OREQ");lista.add("   SL");
           lista.add("   SR");lista.add("   SLEQ");lista.add("   SREQ");lista.add("   EQ");
           lista.add("   NOTEQ");lista.add("   LTEQ");lista.add("   GTEQ");lista.add("   ANDAND");
           lista.add("   OROR");lista.add("   PLUSPLUS");lista.add("   MINUSMINUS");lista.add("   ARROWSTAR");
           lista.add("   ARROW");lista.add("   ASM");lista.add("   AUTO");lista.add("   BOOL");
           lista.add("   BREAK");lista.add("   CASE");lista.add("   CATCH");lista.add("   CHAR");
           lista.add("   CLASS");lista.add("   CONST");lista.add("   CONST_CAST");lista.add("   CONTINUE");
           lista.add("   DEFAULT");lista.add("   DELETE");lista.add("   DO");lista.add("   DOUBLE");
           lista.add("   DYNAMIC_CAST");lista.add("   ELSE");lista.add("   ENUM");lista.add("   EXPLICIT");
           lista.add("   EXPORT");lista.add("   EXTERN");lista.add("   FALSE");lista.add("   FLOAT");
           lista.add("   FOR");lista.add("   FRIEND");lista.add("   GOTO");lista.add("   IF");
           lista.add("   INLINE");lista.add("   INT");lista.add("   LONG");lista.add("   MUTABLE");
           lista.add("   NAMESPACE");lista.add("   NEW");lista.add("   OPERATOR");lista.add("   PRIVATE");
           lista.add("   PROTECTED");lista.add("   PUBLIC");lista.add("   REGISTER");lista.add("   REINTERPRET_CAST");
           lista.add("   RETURN");lista.add("   SHORT");lista.add("   SIGNED");lista.add("   SIZEOF");
           lista.add("   STATIC");lista.add("   STATIC_CAST");lista.add("   STRUCT");lista.add("   SWITCH");
           lista.add("   TEMPLATE");lista.add("   THIS");lista.add("   THROW");lista.add("   TRUE");
           lista.add("   TRY");lista.add("   TYPEDEF");lista.add("   TYPEID");lista.add("   TYPENAME");
           lista.add("   UNION");lista.add("   UNSIGNED");lista.add("   USING");lista.add("   VIRTUAL");
           lista.add("   VOID");lista.add("   VOLATILE");lista.add("   WCHAR_T");lista.add("   WHILE");
           lista.add("   ident");lista.add("   numero");
           */
           datos.add("{          <%");datos.add("}           %>");datos.add("[           <:");datos.add("]           :>");
           datos.add("(");datos.add(" )");datos.add(";");datos.add(":");
           datos.add("?");datos.add(" .");datos.add("+");datos.add("-");
           datos.add("*");datos.add(" /");datos.add("%");datos.add("^            xor");
           datos.add("&");datos.add(" bitand");datos.add("|          bitor");datos.add("~         compl");
           datos.add("!         not");datos.add("=");datos.add("<");datos.add(">");
           datos.add(",");datos.add("#");
           
           
           for(int x=0;x<lista.size();x++) {
               registro [0]=(String) lista.get(x);
               registro [1]=(String) datos.get(x);
               modelo.addRow(registro);
           }
               
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
       
       
   }
    
   public void mostrarLexico(String buscar, JTextArea jTextArea2)throws IOException{
       DefaultTableModel modelo;
        File archivo = new File("archivo.txt");
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(buscar);
            escribir.close();
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File archivo2 = new File("archivo.cpp");
        PrintWriter escribir2;
        try {
            escribir2 = new PrintWriter(archivo2);
            escribir2.print(buscar);
            escribir2.close();
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
            int con = 1;
            Lexer lexer = new Lexer(new StringReader(buscar));
            String resultado = "LINEA " + con + "\t\tSIMBOLO\n";
            while(true){
                Tokens token = lexer.yylex();
                if(token == null){
                    jTextArea2.setText(resultado);
                    return;
                }
                switch(token){
                    case Linea:
                        con++;
                        resultado += "LINEA " + con + "\n";
                        break;
                    case ASM:
                        resultado += "<Reservada asm>\t" + lexer.lexeme + "\n";
                        break;
                    case AUTO:
                        resultado += "<Reservada auto>\t" + lexer.lexeme + "\n";
                        break;
                    case BOOL:
                        resultado += "<Reservada bool>\t" + lexer.lexeme + "\n";
                        break;
                    case BREAK:
                        resultado += "<Reservada break>\t" + lexer.lexeme + "\n";
                        break;
                    case CASE:
                        resultado += "<Reservada case>\t" + lexer.lexeme + "\n";
                        break;
                    case CATCH:
                        resultado += "<Reservada catch>\t" + lexer.lexeme + "\n";
                        break;
                    case CHAR:
                        resultado += "<Reservada char>\t" + lexer.lexeme + "\n";
                        break;  
                    case CLASS:
                        resultado += "<Reservada class>\t" + lexer.lexeme + "\n";
                        break;
                    case CONST:
                        resultado += "<Reservada const>\t" + lexer.lexeme + "\n";
                        break;
                    case CONST_CAST:
                        resultado += "<Reservada const_cast>\t" + lexer.lexeme + "\n";
                        break;
                    case CONTINUE:
                        resultado += "<Reservada continue>\t" + lexer.lexeme + "\n";
                        break;
                    case DEFAULT:
                        resultado += "<Reservada default>\t" + lexer.lexeme + "\n";
                        break;
                    case DELETE:
                        resultado += "<Reservada delete>\t" + lexer.lexeme + "\n";
                        break;
                    case DO:
                        resultado += "<Reservada do>\t" + lexer.lexeme + "\n";
                        break;
                    case DOUBLE:
                        resultado += "<Reservada double>\t" + lexer.lexeme + "\n";
                        break;
                    case DYNAMIC_CAST:
                        resultado += "<Reservada dynamic_cast>\t" + lexer.lexeme + "\n";
                        break;
                    case ELSE:
                        resultado += "<Reservada else>\t" + lexer.lexeme + "\n";
                        break;
                    case ENUM:
                        resultado += "<Reservada enum>\t" + lexer.lexeme + "\n";
                        break;
                    case EXPLICIT:
                        resultado += "<Reservada explicit>\t" + lexer.lexeme + "\n";
                        break;
                    case EXPORT:
                        resultado += "<Reservada export>\t" + lexer.lexeme + "\n";
                        break;
                    case EXTERN:
                        resultado += "<Reservada extern>\t" + lexer.lexeme + "\n";
                        break;
                    case FALSE:
                        resultado += "<Reservada false>\t" + lexer.lexeme + "\n";
                        break;
                    case FLOAT:
                        resultado += "<Reservada float>\t" + lexer.lexeme + "\n";
                        break; 
                    case FOR:
                        resultado += "<Reservada for>\t" + lexer.lexeme + "\n";
                        break;
                    case FRIEND:
                        resultado += "<Reservada friend>\t" + lexer.lexeme + "\n";
                        break;
                    case GOTO:
                        resultado += "<Reservada goto>\t" + lexer.lexeme + "\n";
                        break;
                    case IF:
                        resultado += "<Reservada if>\t" + lexer.lexeme + "\n";
                        break;
                    case INLINE:
                        resultado += "<Reservada inline>\t" + lexer.lexeme + "\n";
                        break;
                    case INT:
                        resultado += "<Reservada int>\t" + lexer.lexeme + "\n";
                        break;
                    case LONG:
                        resultado += "<Reservada long>\t" + lexer.lexeme + "\n";
                        break;                   
                    case MUTABLE:
                        resultado += "<Reservada mutable>\t" + lexer.lexeme + "\n";
                        break;
                    case NAMESPACE:
                        resultado += "<Reservada namespace>\t" + lexer.lexeme + "\n";
                        break;
                    case NEW:
                        resultado += "<Reservada new>\t" + lexer.lexeme + "\n";
                        break;
                    case OPERATOR:
                        resultado += "<Reservada operator>\t" + lexer.lexeme + "\n";
                        break;
                    case PRIVATE:
                        resultado += "<Reservada private>\t" + lexer.lexeme + "\n";
                        break;
                    case PROTECTED:
                        resultado += "<Reservada protected>\t" + lexer.lexeme + "\n";
                        break;
                    case PUBLIC:
                        resultado += "<Reservada public>\t" + lexer.lexeme + "\n";
                        break;
                    case REGISTER:
                        resultado += "<Reservada register>\t" + lexer.lexeme + "\n";
                        break;
                    case REINTERPRET_CAST:
                        resultado += "<Reservada reinterpret_cast>\t" + lexer.lexeme + "\n";
                        break;
                    case RETURN:
                        resultado += "<Reservada return>\t" + lexer.lexeme + "\n";
                        break;
                    case SHORT:
                        resultado += "<Reservada short>\t" + lexer.lexeme + "\n";
                        break;                        
                    case SIGNED:
                        resultado += "<Reservada signed>\t" + lexer.lexeme + "\n";
                        break;
                    case SIZEOF:
                        resultado += "<Reservada sizeof>\t" + lexer.lexeme + "\n";
                        break;
                    case STATIC:
                        resultado += "<Reservada static>\t" + lexer.lexeme + "\n";
                        break;
                    case STATIC_CAST:
                        resultado += "<Reservada static_cast>\t" + lexer.lexeme + "\n";
                        break;
                    case STRUCT:
                        resultado += "<Reservada struct>\t" + lexer.lexeme + "\n";
                        break;
                    case SWITCH:
                        resultado += "<Reservada swicth>\t" + lexer.lexeme + "\n";
                        break;
                    case TEMPLATE:
                        resultado += "<Reservada template>\t" + lexer.lexeme + "\n";
                        break;
                    case THIS:
                        resultado += "<Reservada this>\t" + lexer.lexeme + "\n";
                        break;
                    case THROW:
                        resultado += "<Reservada throw>\t" + lexer.lexeme + "\n";
                        break;
                    case TRUE:
                        resultado += "<Reservada true>\t" + lexer.lexeme + "\n";
                        break;
                    case TRY:
                        resultado += "<Reservada try>\t" + lexer.lexeme + "\n";
                        break;
                    case TYPEDEF:
                        resultado += "<Reservada typedef>\t" + lexer.lexeme + "\n";
                        break;
                    case TYPEID:
                        resultado += "<Reservada typeid>\t" + lexer.lexeme + "\n";
                        break;
                    case TYPENAME:
                        resultado += "<Reservada typename>\t" + lexer.lexeme + "\n";
                        break;
                    case UNION:
                        resultado += "<Reservada union>\t" + lexer.lexeme + "\n";
                        break;
                    case UNSIGNED:
                        resultado += "<Reservada unsigned>\t" + lexer.lexeme + "\n";
                        break; 
                    case USING:
                        resultado += "<Reservada using>\t" + lexer.lexeme + "\n";
                        break;
                    case VIRTUAL:
                        resultado += "<Reservada virtual>\t" + lexer.lexeme + "\n";
                        break;
                    case VOID:
                        resultado += "<Reservada void>\t" + lexer.lexeme + "\n";
                        break;
                    case VOLATILE:
                        resultado += "<Reservada volatile>\t" + lexer.lexeme + "\n";
                        break;
                    case WCHAR_T:
                        resultado += "<Reservada wchar_t>\t" + lexer.lexeme + "\n";
                        break;
                    case WHILE:
                        resultado += "<Reservada while>\t" + lexer.lexeme + "\n";
                        break; 
                    case id1:
                        resultado += "<Reservada id1>\t" + lexer.lexeme + "\n";
                        break; 
                    case id2:
                        resultado += "<Reservada id2>\t" + lexer.lexeme + "\n";
                        break; 
                    case id3:
                        resultado += "<Reservada id3>\t" + lexer.lexeme + "\n";
                        break; 
                    case id4:
                        resultado += "<Reservada id4>\t" + lexer.lexeme + "\n";
                        break; 
                    case id5:
                        resultado += "<Reservada id5>\t" + lexer.lexeme + "\n";
                        break; 
                    case id6:
                        resultado += "<Reservada id6>\t" + lexer.lexeme + "\n";
                        break; 
                    case id7:
                        resultado += "<Reservada id7>\t" + lexer.lexeme + "\n";
                        break; 
                    case id8:
                        resultado += "<Reservada id8>\t" + lexer.lexeme + "\n";
                        break;                       
                    case id9:
                        resultado += "<Reservada id9>\t" + lexer.lexeme + "\n";
                        break; 
                    case id10:
                        resultado += "<Reservada id10>\t" + lexer.lexeme + "\n";
                        break; 
                    case id11:
                        resultado += "<Reservada id11>\t" + lexer.lexeme + "\n";
                        break; 
                    case id12:
                        resultado += "<Reservada id12>\t" + lexer.lexeme + "\n";
                        break; 
                    case id13:
                        resultado += "<Reservada id13>\t" + lexer.lexeme + "\n";
                        break; 
                    case id14:
                        resultado += "<Reservada id14>\t" + lexer.lexeme + "\n";
                        break;    
                    case id15:
                        resultado += "<Reservada id15>\t" + lexer.lexeme + "\n";
                        break; 
                    case id16:
                        resultado += "<Reservada id16>\t" + lexer.lexeme + "\n";
                        break;                       
                    case id17:
                        resultado += "<Reservada id17>\t" + lexer.lexeme + "\n";
                        break; 
                    case id18:
                        resultado += "<Reservada id18>\t" + lexer.lexeme + "\n";
                        break; 
                    case id19:
                        resultado += "<Reservada id19>\t" + lexer.lexeme + "\n";
                        break; 
                    case id20:
                        resultado += "<Reservada id20>\t" + lexer.lexeme + "\n";
                        break; 
                    case id21:
                        resultado += "<Reservada id21>\t" + lexer.lexeme + "\n";
                        break; 
                    case id22:
                        resultado += "<Reservada id22>\t" + lexer.lexeme + "\n";
                        break; 
                    case id23:
                        resultado += "<Reservada id23>\t" + lexer.lexeme + "\n";
                        break; 
                    case id24:
                        resultado += "<Reservada id24>\t" + lexer.lexeme + "\n";
                        break;
                    case ADDEQ:
                        resultado += "<Reservada addeq>\t" + lexer.lexeme + "\n";
                        break; 
                    case SUBEQ:
                        resultado += "<Reservada subeq>\t" + lexer.lexeme + "\n";
                        break; 
                    case MULEQ:
                        resultado += "<Reservada muleq>\t" + lexer.lexeme + "\n";
                        break;
                    case DIVEQ:
                        resultado += "<Reservada diveq>\t" + lexer.lexeme + "\n";
                        break; 
                    case MODEQ:
                        resultado += "<Reservada modeq>\t" + lexer.lexeme + "\n";
                        break; 
                    case XOREQ:
                        resultado += "<Reservada xoreq>\t" + lexer.lexeme + "\n";
                        break;
                    case ANDEQ:
                        resultado += "<Reservada andeq>\t" + lexer.lexeme + "\n";
                        break; 
                    case OREQ:
                        resultado += "<Reservada oreq>\t" + lexer.lexeme + "\n";
                        break; 
                    case SL:
                        resultado += "<Reservada sl>\t" + lexer.lexeme + "\n";
                        break;
                    case SR:
                        resultado += "<Reservada sr>\t" + lexer.lexeme + "\n";
                        break; 
                    case SLEQ:
                        resultado += "<Reservada sleq>\t" + lexer.lexeme + "\n";
                        break; 
                    case EQ:
                        resultado += "<Reservada eq>\t" + lexer.lexeme + "\n";
                        break;
                    case NOTEQ:
                        resultado += "<Reservada noteq>\t" + lexer.lexeme + "\n";
                        break; 
                    case LTEQ:
                        resultado += "<Reservada lteq>\t" + lexer.lexeme + "\n";
                        break;
                    case ANDAND:
                        resultado += "<Reservada andand>\t" + lexer.lexeme + "\n";
                        break; 
                    case OROR:
                        resultado += "<Reservada oror>\t" + lexer.lexeme + "\n";
                        break; 
                    case PLUSPLUS:
                        resultado += "<Reservada plusplus>\t" + lexer.lexeme + "\n";
                        break;   
                    case MINUSMINUS:
                        resultado += "<Reservada minusminus>\t" + lexer.lexeme + "\n";
                        break; 
                    case ELLIPSIS:
                        resultado += "<Reservada ellipsis>\t" + lexer.lexeme + "\n";
                        break; 
                    case COLONCOLON:
                        resultado += "<Reservada coloncolon>\t" + lexer.lexeme + "\n";
                        break;
                    case DOTSTAR:
                        resultado += "<Reservada dotstar>\t" + lexer.lexeme + "\n";
                        break; 
                    case BEGIN:
                        resultado += "<Reservada begin>\t" + lexer.lexeme + "\n";
                        break; 
                    case END:
                        resultado += "<Reservada end>\t" + lexer.lexeme + "\n";
                        break; 
                    case COUT:
                        resultado += "<Reservada cout>\t" + lexer.lexeme + "\n";
                        break; 
                    case CIN:
                        resultado += "<Reservada cin>\t" + lexer.lexeme + "\n";
                        break;
                    /*FUNCIONES ITERATIVAS DE LA CLASE ARRAY*/
                    case CRBEGIN:
                        resultado += "<Reservada crbegin>\t" + lexer.lexeme + "\n";
                        break; 
                    case CREND:
                        resultado += "<Reservada crend>\t" + lexer.lexeme + "\n";
                        break;   
                    case CBEGIN:
                        resultado += "<Reservada cbegin>\t" + lexer.lexeme + "\n";
                        break; 
                    case CEND:
                        resultado += "<Reservada cend>\t" + lexer.lexeme + "\n";
                        break; 
                    case RBEGIN:
                        resultado += "<Reservada rbegin>\t" + lexer.lexeme + "\n";
                        break;
                    case REND:
                        resultado += "<Reservada rend>\t" + lexer.lexeme + "\n";
                        break;
                    /*LIBRERIA CTYPE.H */
                    case ISALNUM:
                        resultado += "<Reservada isalnum>\t" + lexer.lexeme + "\n";
                        break;   
                    case ISALPHA:
                        resultado += "<Reservada isalpha>\t" + lexer.lexeme + "\n";
                        break; 
                    case ISCNTRL:
                        resultado += "<Reservada iscntrl>\t" + lexer.lexeme + "\n";
                        break; 
                    case ISDIGIT:
                        resultado += "<Reservada isdigit>\t" + lexer.lexeme + "\n";
                        break;
                    case ISGRAPH:
                        resultado += "<Reservada isgraph>\t" + lexer.lexeme + "\n";
                        break; 
                    case ISLOWER:
                        resultado += "<Reservada islower>\t" + lexer.lexeme + "\n";
                        break; 
                    case ISPRINT:
                        resultado += "<Reservada isprint>\t" + lexer.lexeme + "\n";
                        break;
                    case ISPUNCT:
                        resultado += "<Reservada ispunct>\t" + lexer.lexeme + "\n";
                        break; 
                    case ISSPACE:
                        resultado += "<Reservada isspace>\t" + lexer.lexeme + "\n";
                        break;
                    case ISUPPER:
                        resultado += "<Reservada isupper>\t" + lexer.lexeme + "\n";
                        break; 
                    case ISXDIGIT:
                        resultado += "<Reservada isxdigit>\t" + lexer.lexeme + "\n";
                        break;
                    case TOLOWER:
                        resultado += "<Reservada tolower>\t" + lexer.lexeme + "\n";
                        break; 
                    case TOUPPER:
                        resultado += "<Reservada toupper>\t" + lexer.lexeme + "\n";
                        break; 
                    /*LIBRERIA STDIO.H */
                    case FPRINTF:
                        resultado += "<Reservada fprintf>\t" + lexer.lexeme + "\n";
                        break;   
                    case FSCANF:
                        resultado += "<Reservada fscanf>\t" + lexer.lexeme + "\n";
                        break; 
                    case PRINTF:
                        resultado += "<Reservada printf>\t" + lexer.lexeme + "\n";
                        break; 
                    case SCANF:
                        resultado += "<Reservada scanf>\t" + lexer.lexeme + "\n";
                        break;
                    case SNPRINTF:
                        resultado += "<Reservada snprintf>\t" + lexer.lexeme + "\n";
                        break; 
                    case SPRINTF:
                        resultado += "<Reservada sprintf>\t" + lexer.lexeme + "\n";
                        break; 
                    case SSCANF:
                        resultado += "<Reservada sscanf>\t" + lexer.lexeme + "\n";
                        break;
                    case VFPRINTF:
                        resultado += "<Reservada vfprintf>\t" + lexer.lexeme + "\n";
                        break;   
                    case VFSCANF:
                        resultado += "<Reservada vfscanf>\t" + lexer.lexeme + "\n";
                        break; 
                    case VPRINTF:
                        resultado += "<Reservada vprintf>\t" + lexer.lexeme + "\n";
                        break; 
                    case VSCANF:
                        resultado += "<Reservada vscanf>\t" + lexer.lexeme + "\n";
                        break;
                    case VSNPRINTF:
                        resultado += "<Reservada vsnprintf>\t" + lexer.lexeme + "\n";
                        break; 
                    case VSPRINTF:
                        resultado += "<Reservada vsprintf>\t" + lexer.lexeme + "\n";
                        break; 
                    case VSSCANF:
                        resultado += "<Reservada vsscanf>\t" + lexer.lexeme + "\n";
                        break;
                    case REMOVE:
                        resultado += "<Reservada remove>\t" + lexer.lexeme + "\n";
                        break; 
                    case RENAME:
                        resultado += "<Reservada rename>\t" + lexer.lexeme + "\n";
                        break; 
                    case TMPFILE:
                        resultado += "<Reservada tmpfile>\t" + lexer.lexeme + "\n";
                        break;
                    case TMPNAM:
                        resultado += "<Reservada tmpnam>\t" + lexer.lexeme + "\n";
                        break; 
                    case FCLOSE:
                        resultado += "<Reservada fclose>\t" + lexer.lexeme + "\n";
                        break; 
                    case FFLUSH:
                        resultado += "<Reservada fflush>\t" + lexer.lexeme + "\n";
                        break;
                    case FOPEN:
                        resultado += "<Reservada fopen>\t" + lexer.lexeme + "\n";
                        break; 
                    case FREOPEN:
                        resultado += "<Reservada freopen>\t" + lexer.lexeme + "\n";
                        break;
                    case SETBUF:
                        resultado += "<Reservada setbuf>\t" + lexer.lexeme + "\n";
                        break; 
                    case SETVBUF:
                        resultado += "<Reservada setvbuf>\t" + lexer.lexeme + "\n";
                        break; 
                    /*LIBRERIA FENV.H */
                    case FECLEAREXCEPT:
                        resultado += "<Reservada feclearexcep>\t" + lexer.lexeme + "\n";
                        break; 
                    case FERAISEEXCEPT:
                        resultado += "<Reservada feraiseexcept>\t" + lexer.lexeme + "\n";
                        break;
                    case FEGETEXCEPTFLAG:
                        resultado += "<Reservada fegetexceptflag>\t" + lexer.lexeme + "\n";
                        break; 
                    case FESETEXCEPTFLAG:
                        resultado += "<Reservada fesetexceptflag>\t" + lexer.lexeme + "\n";
                        break;
                    case FEGETROUND:
                        resultado += "<Reservada fegetround>\t" + lexer.lexeme + "\n";
                        break; 
                    case FESETROUND:
                        resultado += "<Reservada fesetround>\t" + lexer.lexeme + "\n";
                        break;
                    case FEGETENV:
                        resultado += "<Reservada fegetenv>\t" + lexer.lexeme + "\n";
                        break; 
                    case FESETENV:
                        resultado += "<Reservada Fesetenv>\t" + lexer.lexeme + "\n";
                        break;
                    case FEHOLDEXCEPT:
                        resultado += "<Reservada feholdexcept>\t" + lexer.lexeme + "\n";
                        break; 
                    case FEUPDATEENV:
                        resultado += "<Reservada feupdateenv>\t" + lexer.lexeme + "\n";
                        break; 
                    case FETESTEXCEPT:
                        resultado += "<Reservada fetestexcept>\t" + lexer.lexeme + "\n";
                        break;
                    /*LIBRERIA LOCALE.H */   
                    case SETLOCALE:
                        resultado += "<Reservada setlocale>\t" + lexer.lexeme + "\n";
                        break; 
                    case LOCALECONV:
                        resultado += "<Reservada localeconv>\t" + lexer.lexeme + "\n";
                        break;
                    /*LIBRERIA MATH.H */  
                    case COS:
                        resultado += "<Reservada cos>\t" + lexer.lexeme + "\n";
                        break; 
                    case SIN:
                        resultado += "<Reservada sin>\t" + lexer.lexeme + "\n";
                        break;
                    case TAN:
                        resultado += "<Reservada tan>\t" + lexer.lexeme + "\n";
                        break; 
                    case ACOS:
                        resultado += "<Reservada acos>\t" + lexer.lexeme + "\n";
                        break;
                    case ASIN:
                        resultado += "<Reservada asin>\t" + lexer.lexeme + "\n";
                        break; 
                    case ATAN:
                        resultado += "<Reservada atan>\t" + lexer.lexeme + "\n";
                        break;
                    case ATAN2:
                        resultado += "<Reservada atan2>\t" + lexer.lexeme + "\n";
                        break; 
                    case COSH:
                        resultado += "<Reservada cosh>\t" + lexer.lexeme + "\n";
                        break;
                    case SINH:
                        resultado += "<Reservada sinh>\t" + lexer.lexeme + "\n";
                        break; 
                    case TANH:
                        resultado += "<Reservada tanh>\t" + lexer.lexeme + "\n";
                        break;
                    case ACOSH:
                        resultado += "<Reservada acosh>\t" + lexer.lexeme + "\n";
                        break; 
                    case ASINH:
                        resultado += "<Reservada asinh>\t" + lexer.lexeme + "\n";
                        break;
                    case ATANH:
                        resultado += "<Reservada atanh>\t" + lexer.lexeme + "\n";
                        break; 
                    case EXP:
                        resultado += "<Reservada exp>\t" + lexer.lexeme + "\n";
                        break;                                                 
                    case FREXP:
                        resultado += "<Reservada frexp>\t" + lexer.lexeme + "\n";
                        break; 
                    case LDEXP:
                        resultado += "<Reservada ldexp>\t" + lexer.lexeme + "\n";
                        break;
                    case LOG:
                        resultado += "<Reservada log>\t" + lexer.lexeme + "\n";
                        break; 
                    case LOG10:
                        resultado += "<Reservada log10>\t" + lexer.lexeme + "\n";
                        break;
                    case MODF:
                        resultado += "<Reservada modf>\t" + lexer.lexeme + "\n";
                        break; 
                    case EXP2:
                        resultado += "<Reservada exp2>\t" + lexer.lexeme + "\n";
                        break;
                    case EXPM1:
                        resultado += "<Reservada expm1>\t" + lexer.lexeme + "\n";
                        break; 
                    case ILOGB:
                        resultado += "<Reservada ilogb>\t" + lexer.lexeme + "\n";
                        break;
                    case LOG1P:
                        resultado += "<Reservada log1p>\t" + lexer.lexeme + "\n";
                        break; 
                    case LOG2:
                        resultado += "<Reservada log2>\t" + lexer.lexeme + "\n";
                        break;
                    case SCALBN:
                        resultado += "<Reservada scalbn>\t" + lexer.lexeme + "\n";
                        break; 
                    case SCALBLN:
                        resultado += "<Reservada scalbln>\t" + lexer.lexeme + "\n";
                        break;
                    case POW:
                        resultado += "<Reservada pow>\t" + lexer.lexeme + "\n";
                        break; 
                    case SQRT:
                        resultado += "<Reservada sqrt>\t" + lexer.lexeme + "\n";
                        break;
                    case CBRT:
                        resultado += "<Reservada cbrt>\t" + lexer.lexeme + "\n";
                        break; 
                    case HYPOT:
                        resultado += "<Reservada hypot>\t" + lexer.lexeme + "\n";
                        break;
                    case ERF:
                        resultado += "<Reservada erf>\t" + lexer.lexeme + "\n";
                        break; 
                    case ERFC:
                        resultado += "<Reservada erfc>\t" + lexer.lexeme + "\n";
                        break;
                    case TGAMMA:
                        resultado += "<Reservada tgamma>\t" + lexer.lexeme + "\n";
                        break; 
                    case LGAMMA:
                        resultado += "<Reservada lgamma>\t" + lexer.lexeme + "\n";
                        break;
                    case CEIL:
                        resultado += "<Reservada ceil>\t" + lexer.lexeme + "\n";
                        break; 
                    case FLOOR:
                        resultado += "<Reservada floor>\t" + lexer.lexeme + "\n";
                        break;                                                 
                    case FMOD:
                        resultado += "<Reservada fmod>\t" + lexer.lexeme + "\n";
                        break; 
                    case TRUNC:
                        resultado += "<Reservada trunc>\t" + lexer.lexeme + "\n";
                        break;                      
                    case ROUND:
                        resultado += "<Reservada round>\t" + lexer.lexeme + "\n";
                        break; 
                    case LROUND:
                        resultado += "<Reservada lround>\t" + lexer.lexeme + "\n";
                        break;
                    case LLROUND:
                        resultado += "<Reservada llround>\t" + lexer.lexeme + "\n";
                        break; 
                    case RINT:
                        resultado += "<Reservada rint>\t" + lexer.lexeme + "\n";
                        break;
                    case LRINT:
                        resultado += "<Reservada lrint>\t" + lexer.lexeme + "\n";
                        break; 
                    case LLRINT:
                        resultado += "<Reservada llrint>\t" + lexer.lexeme + "\n";
                        break; 
                    case NEARBYINT:
                        resultado += "<Reservada nearbyint>\t" + lexer.lexeme + "\n";
                        break;
                    case REMAINDER:
                        resultado += "<Reservada remainder>\t" + lexer.lexeme + "\n";
                        break; 
                    case REMQUO:
                        resultado += "<Reservada remquo>\t" + lexer.lexeme + "\n";
                        break;                                                 
                    case COPYSIGN:
                        resultado += "<Reservada copysign>\t" + lexer.lexeme + "\n";
                        break; 
                    case NAN:
                        resultado += "<Reservada nan>\t" + lexer.lexeme + "\n";
                        break;                      
                    case NEXTAFTER:
                        resultado += "<Reservada nextafter>\t" + lexer.lexeme + "\n";
                        break; 
                    case NEXTTOWARD:
                        resultado += "<Reservada nexttoward>\t" + lexer.lexeme + "\n";
                        break;
                    case FDIM:
                        resultado += "<Reservada fdim>\t" + lexer.lexeme + "\n";
                        break; 
                    case FMAX:
                        resultado += "<Reservada fmax>\t" + lexer.lexeme + "\n";
                        break;
                    case FMIN:
                        resultado += "<Reservada fmin>\t" + lexer.lexeme + "\n";
                        break; 
                    case FABS:
                        resultado += "<Reservada fabs>\t" + lexer.lexeme + "\n";
                        break;     
                    case ABS:
                        resultado += "<Reservada abs>\t" + lexer.lexeme + "\n";
                        break; 
                    case FMA:
                        resultado += "<Reservada fma>\t" + lexer.lexeme + "\n";
                        break; 
                    /*LIBRERIA SETJMP.H */   
                    case LONGJMP:
                        resultado += "<Reservada Longjmp>\t" + lexer.lexeme + "\n";
                        break; 
                    /*LIBRERIA SIGNAL.H */   
                    case SIGNAL:
                        resultado += "<Reservada signal>\t" + lexer.lexeme + "\n";
                        break;  
                    case RAISE:
                        resultado += "<Reservada raise>\t" + lexer.lexeme + "\n";
                        break;  
                    /*LIBRERIA STDIO.H */   
                    case FGETS:
                        resultado += "<Reservada fgets>\t" + lexer.lexeme + "\n";
                        break;  
                    case FGETC:
                        resultado += "<Reservada fgetc>\t" + lexer.lexeme + "\n";
                        break; 
                    case FPUTS:
                        resultado += "<Reservada fputs>\t" + lexer.lexeme + "\n";
                        break;  
                    case FPUTC:
                        resultado += "<Reservada fputc>\t" + lexer.lexeme + "\n";
                        break; 
                    case GETC:
                        resultado += "<Reservada fetc>\t" + lexer.lexeme + "\n";
                        break;
                    case GETCHAR:
                        resultado += "<Reservada getchar>\t" + lexer.lexeme + "\n";
                        break;  
                    case GETS:
                        resultado += "<Reservada gets>\t" + lexer.lexeme + "\n";
                        break; 
                    case PUTC:
                        resultado += "<Reservada putc>\t" + lexer.lexeme + "\n";
                        break;  
                    case PUTCHAR:
                        resultado += "<Reservada putchar>\t" + lexer.lexeme + "\n";
                        break;   
                    case PUTS:
                        resultado += "<Reservada puts>\t" + lexer.lexeme + "\n";
                        break;  
                    case UNGETC:
                        resultado += "<Reservada ungetc>\t" + lexer.lexeme + "\n";
                        break;
                    case FREAD:
                        resultado += "<Reservada fread>\t" + lexer.lexeme + "\n";
                        break;  
                    case FWRITE:
                        resultado += "<Reservada fwrite>\t" + lexer.lexeme + "\n";
                        break; 
                    case FGETPOS:
                        resultado += "<Reservada fgetpos>\t" + lexer.lexeme + "\n";
                        break;  
                    case FSEEK:
                        resultado += "<Reservada fseek>\t" + lexer.lexeme + "\n";
                        break; 
                    case FSETPOS:
                        resultado += "<Reservada fsetpos>\t" + lexer.lexeme + "\n";
                        break;
                    case FTELL:
                        resultado += "<Reservada ftell>\t" + lexer.lexeme + "\n";
                        break;  
                    case REWIND:
                        resultado += "<Reservada rewind>\t" + lexer.lexeme + "\n";
                        break; 
                    case CLEARERR:
                        resultado += "<Reservada clearerr>\t" + lexer.lexeme + "\n";
                        break;  
                    case FEOF:
                        resultado += "<Reservada feof>\t" + lexer.lexeme + "\n";
                        break;   
                    case FERROR:
                        resultado += "<Reservada ferror>\t" + lexer.lexeme + "\n";
                        break;  
                    case PERROR:
                        resultado += "<Reservada perror>\t" + lexer.lexeme + "\n";
                        break;
                    /*LIBRERIA STLIB.H */   
                    case ATOF:
                        resultado += "<Reservada atof>\t" + lexer.lexeme + "\n";
                        break;  
                    case ATOI:
                        resultado += "<Reservada atoi>\t" + lexer.lexeme + "\n";
                        break; 
                    case ATOL:
                        resultado += "<Reservada atol>\t" + lexer.lexeme + "\n";
                        break;  
                    case ATOLL:
                        resultado += "<Reservada atoll>\t" + lexer.lexeme + "\n";
                        break; 
                    case STRTOD:
                        resultado += "<Reservada strtod>\t" + lexer.lexeme + "\n";
                        break;
                    case STRTOF:
                        resultado += "<Reservada strtof>\t" + lexer.lexeme + "\n";
                        break;  
                    case STRTOL:
                        resultado += "<Reservada strtol>\t" + lexer.lexeme + "\n";
                        break; 
                    case STRTOLD:
                        resultado += "<Reservada strtold>\t" + lexer.lexeme + "\n";
                        break;  
                    case STRTOLL:
                        resultado += "<Reservada strtoll>\t" + lexer.lexeme + "\n";
                        break;   
                    case STRTOUL:
                        resultado += "<Reservada strtoul>\t" + lexer.lexeme + "\n";
                        break; 
                    case STRTOULL:
                        resultado += "<Reservada strtoull>\t" + lexer.lexeme + "\n";
                        break;
                    case RAND:
                        resultado += "<Reservada rand>\t" + lexer.lexeme + "\n";
                        break;  
                    case SRAND:
                        resultado += "<Reservada srand>\t" + lexer.lexeme + "\n";
                        break; 
                    case CALLOC:
                        resultado += "<Reservada calloc>\t" + lexer.lexeme + "\n";
                        break;  
                    case FREE:
                        resultado += "<Reservada free>\t" + lexer.lexeme + "\n";
                        break; 
                    case MALLOC:
                        resultado += "<Reservada malloc>\t" + lexer.lexeme + "\n";
                        break;
                    case REALLOC:
                        resultado += "<Reservada realloc>\t" + lexer.lexeme + "\n";
                        break;  
                    case ABORT:
                        resultado += "<Reservada abort>\t" + lexer.lexeme + "\n";
                        break; 
                    case ATEXIT:
                        resultado += "<Reservada atexit>\t" + lexer.lexeme + "\n";
                        break;  
                    case AT_QUICK_EXIT:
                        resultado += "<Reservada at_quick_exit>\t" + lexer.lexeme + "\n";
                        break;   
                    case EXIT:
                        resultado += "<Reservada exit>\t" + lexer.lexeme + "\n";
                        break;  
                    case GETENV:
                        resultado += "<Reservada getenv>\t" + lexer.lexeme + "\n";
                        break;
                    case QUICK_EXIT:
                        resultado += "<Reservada quick_quick>\t" + lexer.lexeme + "\n";
                        break;   
                    case SYSTEM:
                        resultado += "<Reservada system>\t" + lexer.lexeme + "\n";
                        break;  
                    case _EXIT:
                        resultado += "<Reservada _exit>\t" + lexer.lexeme + "\n";
                        break;
                    case BSEARCH:
                        resultado += "<Reservada bsearch>\t" + lexer.lexeme + "\n";
                        break;  
                    case QSORT:
                        resultado += "<Reservada qsort>\t" + lexer.lexeme + "\n";
                        break;   
                    case DIV:
                        resultado += "<Reservada div>\t" + lexer.lexeme + "\n";
                        break;  
                    case LABS:
                        resultado += "<Reservada labs>\t" + lexer.lexeme + "\n";
                        break;
                    case LDIV:
                        resultado += "<Reservada ldiv>\t" + lexer.lexeme + "\n";
                        break;   
                    case LLABS:
                        resultado += "<Reservada llabs>\t" + lexer.lexeme + "\n";
                        break;  
                    case LLDIV:
                        resultado += "<Reservada lldiv>\t" + lexer.lexeme + "\n";
                        break;
                    case MBLEN:
                        resultado += "<Reservada mblen>\t" + lexer.lexeme + "\n";
                        break;  
                    case MBTOWC:
                        resultado += "<Reservada mbtowc>\t" + lexer.lexeme + "\n";
                        break;
                    case WCTOMB:
                        resultado += "<Reservada wctomb>\t" + lexer.lexeme + "\n";
                        break;   
                    case MBSTOWCS:
                        resultado += "<Reservada mbstowcs>\t" + lexer.lexeme + "\n";
                        break;  
                    case WCSTOMBS:
                        resultado += "<Reservada wcstombs>\t" + lexer.lexeme + "\n";
                        break;
                }
            }
   }
}
