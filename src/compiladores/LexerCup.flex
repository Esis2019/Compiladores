package compiladores;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
{espacio}               { /*Ignore*/}
"//".*                  { /*Ignore*/}

"/*"                        { return new Symbol(sym.coment_1, yychar, yyline, yytext()); }
"//"                        { return new Symbol(sym.coment_2, yychar, yyline, yytext()); }
(int | byte | enum | auto | bool | short | double | char | long | float | double ) {return new Symbol(sym.T_dato, yychar, yyline, yytext());}

"{"                         { return new Symbol(sym.id1, yychar, yyline, yytext()); }
"<%"                        { return new Symbol(sym.id1, yychar, yyline, yytext()); }
"}"                         { return new Symbol(sym.id2, yychar, yyline, yytext()); }
"%>"                        { return new Symbol(sym.id2, yychar, yyline, yytext()); }
"["                         { return new Symbol(sym.id3, yychar, yyline, yytext()); }
"<:"                        { return new Symbol(sym.id3, yychar, yyline, yytext()); }
"]"                         { return new Symbol(sym.id4, yychar, yyline, yytext()); }
":>"                        { return new Symbol(sym.id4, yychar, yyline, yytext()); }
"("                         { return new Symbol(sym.id5, yychar, yyline, yytext()); }
")"                         { return new Symbol(sym.id6, yychar, yyline, yytext()); }
";"                         { return new Symbol(sym.id7, yychar, yyline, yytext()); }
":"                         { return new Symbol(sym.id8, yychar, yyline, yytext()); }
"..."                       { return new Symbol(sym.ELLIPSIS, yychar, yyline, yytext()); }
"?"                         { return new Symbol(sym.id9, yychar, yyline, yytext()); }
"::"                        { return new Symbol(sym.COLONCOLON, yychar, yyline, yytext()); }
"."                         { return new Symbol(sym.id10, yychar, yyline, yytext()); }
".*"                        { return new Symbol(sym.DOTSTAR, yychar, yyline, yytext()); }
"+"                         { return new Symbol(sym.id11, yychar, yyline, yytext()); }
"-"                         { return new Symbol(sym.id12, yychar, yyline, yytext()); }
"*"                         { return new Symbol(sym.id13, yychar, yyline, yytext()); }
"/"                         { return new Symbol(sym.id14, yychar, yyline, yytext()); }
"%"                         { return new Symbol(sym.id15, yychar, yyline, yytext()); }
"^"                         { return new Symbol(sym.id16, yychar, yyline, yytext()); }
"xor"                       { return new Symbol(sym.id16, yychar, yyline, yytext()); }
"&"                         { return new Symbol(sym.id17, yychar, yyline, yytext()); }
"bitand"                    { return new Symbol(sym.id18, yychar, yyline, yytext()); }
"|"                         { return new Symbol(sym.id19, yychar, yyline, yytext()); }
"bitor"                     { return new Symbol(sym.id19, yychar, yyline, yytext()); }
"~"                         { return new Symbol(sym.id20, yychar, yyline, yytext()); }
"compl"                     { return new Symbol(sym.id20, yychar, yyline, yytext()); }
"!"                         { return new Symbol(sym.id21, yychar, yyline, yytext()); }
"not"                       { return new Symbol(sym.id21, yychar, yyline, yytext()); }
"="                         { return new Symbol(sym.id22, yychar, yyline, yytext()); }
"<"                         { return new Symbol(sym.id23, yychar, yyline, yytext()); }
">"                         { return new Symbol(sym.id24, yychar, yyline, yytext()); }
"+="                        { return new Symbol(sym.ADDEQ, yychar, yyline, yytext()); }
"-="                        { return new Symbol(sym.SUBEQ, yychar, yyline, yytext()); }
"*="                        { return new Symbol(sym.MULEQ, yychar, yyline, yytext()); }
"/="                        { return new Symbol(sym.DIVEQ, yychar, yyline, yytext()); }
"%="                        { return new Symbol(sym.MODEQ, yychar, yyline, yytext()); }
"^="                        { return new Symbol(sym.XOREQ, yychar, yyline, yytext()); }
"xor_eq"                    { return new Symbol(sym.XOREQ, yychar, yyline, yytext()); }
"&="                        { return new Symbol(sym.ANDEQ, yychar, yyline, yytext()); }
"and_eq"                    { return new Symbol(sym.ANDEQ, yychar, yyline, yytext()); }
"|="                        { return new Symbol(sym.OREQ, yychar, yyline, yytext()); }
"or_eq"                     { return new Symbol(sym.OREQ, yychar, yyline, yytext()); }
"<<"                        { return new Symbol(sym.SL, yychar, yyline, yytext()); }
">>"                        { return new Symbol(sym.SR, yychar, yyline, yytext()); }
"<<="                       { return new Symbol(sym.SLEQ, yychar, yyline, yytext()); }
">>="                       { return new Symbol(sym.SREQ, yychar, yyline, yytext()); }
"=="                        { return new Symbol(sym.EQ, yychar, yyline, yytext()); }
"!="                        { return new Symbol(sym.NOTEQ, yychar, yyline, yytext()); }
"not_eq"                    { return new Symbol(sym.NOTEQ, yychar, yyline, yytext()); }
"<="                        { return new Symbol(sym.LTEQ, yychar, yyline, yytext()); }
">="                        { return new Symbol(sym.GTEQ, yychar, yyline, yytext()); }
"&&"                        { return new Symbol(sym.ANDAND, yychar, yyline, yytext()); }
"and"                       { return new Symbol(sym.ANDAND, yychar, yyline, yytext()); }
"||"                        { return new Symbol(sym.OROR, yychar, yyline, yytext()); }
"or"                        { return new Symbol(sym.OROR, yychar, yyline, yytext()); }
"++"                        { return new Symbol(sym.PLUSPLUS, yychar, yyline, yytext()); }
"--"                        { return new Symbol(sym.MINUSMINUS, yychar, yyline, yytext()); }
","                         { return new Symbol(sym.id25, yychar, yyline, yytext()); }
"#"                         { return new Symbol(sym.id26, yychar, yyline, yytext()); }
"->*"                       { return new Symbol(sym.ARROWSTAR, yychar, yyline, yytext()); }
"->"                        { return new Symbol(sym.ARROW, yychar, yyline, yytext()); }
"asm"                       { return new Symbol(sym.ASM, yychar, yyline, yytext()); }
"break"                     { return new Symbol(sym.BREAK, yychar, yyline, yytext()); }
"case"                      { return new Symbol(sym.CASE, yychar, yyline, yytext()); }
"catch"                     { return new Symbol(sym.CATCH, yychar, yyline, yytext()); }
"class"                     { return new Symbol(sym.CLASS, yychar, yyline, yytext()); }
"const"                     { return new Symbol(sym.CONST, yychar, yyline, yytext()); }
"const_cast"                { return new Symbol(sym.CONST_CAST, yychar, yyline, yytext()); }
"continue"                  { return new Symbol(sym.CONTINUE, yychar, yyline, yytext()); }
"default"                   { return new Symbol(sym.DEFAULT, yychar, yyline, yytext()); }
"delete"                    { return new Symbol(sym.DELETE, yychar, yyline, yytext()); }
"do"                        { return new Symbol(sym.DO, yychar, yyline, yytext()); }
"dynamic_cast"              { return new Symbol(sym.DYNAMIC_CAST, yychar, yyline, yytext()); }
"else"                      { return new Symbol(sym.ELSE, yychar, yyline, yytext()); }
"explicit"                  { return new Symbol(sym.EXPLICIT, yychar, yyline, yytext()); }
"export"                    { return new Symbol(sym.EXPORT, yychar, yyline, yytext()); }
"extern"                    { return new Symbol(sym.EXTERN, yychar, yyline, yytext()); }
"false"                     { return new Symbol(sym.FALSE, yychar, yyline, yytext()); }
"for"                       { return new Symbol(sym.FOR, yychar, yyline, yytext()); }
"friend"                    { return new Symbol(sym.FRIEND, yychar, yyline, yytext()); }
"goto"                      { return new Symbol(sym.GOTO, yychar, yyline, yytext()); }
"if"                        { return new Symbol(sym.IF, yychar, yyline, yytext()); }
"inline"                    { return new Symbol(sym.INLINE, yychar, yyline, yytext()); }
"mutable"                   { return new Symbol(sym.MUTABLE, yychar, yyline, yytext()); }
"namespace"                 { return new Symbol(sym.NAMESPACE, yychar, yyline, yytext()); }
"new"                       { return new Symbol(sym.NEW, yychar, yyline, yytext()); }
"operator"                  { return new Symbol(sym.OPERATOR, yychar, yyline, yytext()); }
"private"                   { return new Symbol(sym.PRIVATE, yychar, yyline, yytext()); }
"protected"                 { return new Symbol(sym.PROTECTED, yychar, yyline, yytext()); }
"public"                    { return new Symbol(sym.PUBLIC, yychar, yyline, yytext()); }
"register"                  { return new Symbol(sym.REGISTER, yychar, yyline, yytext()); }
"reinterpret_cast"          { return new Symbol(sym.REINTERPRET_CAST, yychar, yyline, yytext()); }
"return"                    { return new Symbol(sym.RETURN, yychar, yyline, yytext()); }
"signed"                    { return new Symbol(sym.SIGNED, yychar, yyline, yytext()); }
"sizeof"                    { return new Symbol(sym.SIZEOF, yychar, yyline, yytext()); }
"static"                    { return new Symbol(sym.STATIC, yychar, yyline, yytext()); }
"static_cast"               { return new Symbol(sym.STATIC_CAST, yychar, yyline, yytext()); }
"struct"                    { return new Symbol(sym.STRUCT, yychar, yyline, yytext()); }
"switch"                    { return new Symbol(sym.SWITCH, yychar, yyline, yytext()); }
"template"                  { return new Symbol(sym.TEMPLATE, yychar, yyline, yytext()); }
"this"                      { return new Symbol(sym.THIS, yychar, yyline, yytext()); }
"throw"                     { return new Symbol(sym.THROW, yychar, yyline, yytext()); }
"true"                      { return new Symbol(sym.TRUE, yychar, yyline, yytext()); }
"try"                       { return new Symbol(sym.TRY, yychar, yyline, yytext()); }
"typedef"                   { return new Symbol(sym.TYPEDEF, yychar, yyline, yytext()); }
"typeid"                    { return new Symbol(sym.TYPEID, yychar, yyline, yytext()); }
"typename"                  { return new Symbol(sym.TYPENAME, yychar, yyline, yytext()); }
"union"                     { return new Symbol(sym.UNION, yychar, yyline, yytext()); }
"unsigned"                  { return new Symbol(sym.UNSIGNED, yychar, yyline, yytext()); }
"using"                     { return new Symbol(sym.USING, yychar, yyline, yytext()); }
"virtual"                   { return new Symbol(sym.VIRTUAL, yychar, yyline, yytext()); }
"void"                      { return new Symbol(sym.VOID, yychar, yyline, yytext()); }
"volatile"                  { return new Symbol(sym.VOLATILE, yychar, yyline, yytext()); }
"wchar_t"                   { return new Symbol(sym.WCHAR_T, yychar, yyline, yytext()); }
"while"                     { return new Symbol(sym.WHILE, yychar, yyline, yytext()); }
"begin"                     { return new Symbol(sym.BEGIN, yychar, yyline, yytext()); }
"end"                       { return new Symbol(sym.END, yychar, yyline, yytext()); }
"main"                      { return new Symbol(sym.Main, yychar, yyline, yytext()); }
"include"                   { return new Symbol(sym.Include, yychar, yyline, yytext()); }
"h"                         { return new Symbol(sym.Letra_H, yychar, yyline, yytext()); }
(iostream | conio | math ) {return new Symbol(sym.Libreria, yychar, yyline, yytext());}

{L}({L}|{D})*               { return new Symbol(sym.ident, yychar, yyline, yytext()); }
("(-"{D}+")")|{D}+          { return new Symbol(sym.numero, yychar, yyline, yytext()); }
.                           { return new Symbol(sym.ERROR, yychar, yyline, yytext()); }




