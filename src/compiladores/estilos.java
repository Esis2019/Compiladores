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
                }
            }
   }
}
