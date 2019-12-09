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
"cbegin"                    { return new Symbol(sym.CBEGIN, yychar, yyline, yytext()); }
"cend"                      { return new Symbol(sym.CEND, yychar, yyline, yytext()); }
"rbegin"                    { return new Symbol(sym.RBEGIN, yychar, yyline, yytext()); }
"rend"                      { return new Symbol(sym.REND, yychar, yyline, yytext()); }
"crbegin"                   { return new Symbol(sym.CRBEGIN, yychar, yyline, yytext()); }
"crend"                     { return new Symbol(sym.CREND, yychar, yyline, yytext()); }
"cin"                       { return new Symbol(sym.CIN, yychar, yyline, yytext()); }
"cout"                      { return new Symbol(sym.COUT, yychar, yyline, yytext()); }
"isalnum"                   { return new Symbol(sym.ISALNUM, yychar, yyline, yytext()); }
"isalpha"                   { return new Symbol(sym.ISALPHA, yychar, yyline, yytext()); }
"iscntrl"                   { return new Symbol(sym.ISCNTRL, yychar, yyline, yytext()); }
"isdigit"                   { return new Symbol(sym.ISDIGIT, yychar, yyline, yytext()); }
"isgraph"                   { return new Symbol(sym.ISGRAPH, yychar, yyline, yytext()); }
"islower"                   { return new Symbol(sym.ISLOWER, yychar, yyline, yytext()); }
"isprint"                   { return new Symbol(sym.ISPRINT, yychar, yyline, yytext()); }
"ispunct"                   { return new Symbol(sym.ISPUNCT, yychar, yyline, yytext()); }
"isspace"                   { return new Symbol(sym.ISSPACE, yychar, yyline, yytext()); }
"isupper"                   { return new Symbol(sym.ISUPPER, yychar, yyline, yytext()); }
"isxdigit"                  { return new Symbol(sym.ISXDIGIT, yychar, yyline, yytext()); }
"fprintf"                   { return new Symbol(sym.FPRINTF, yychar, yyline, yytext()); }
"fscanf"                    { return new Symbol(sym.FSCANF, yychar, yyline, yytext()); }
"printf"                    { return new Symbol(sym.PRINTF, yychar, yyline, yytext()); }
"scanf"                     { return new Symbol(sym.SCANF, yychar, yyline, yytext()); }
"snprintf"                  { return new Symbol(sym.SNPRINTF, yychar, yyline, yytext()); }
"sprintf"                   { return new Symbol(sym.SPRINTF, yychar, yyline, yytext()); }
"sscanf"                    { return new Symbol(sym.SSCANF, yychar, yyline, yytext()); }
"vfprintf"                  { return new Symbol(sym.VFPRINTF, yychar, yyline, yytext()); }
"vfscanf"                   { return new Symbol(sym.VFSCANF, yychar, yyline, yytext()); }
"vprintf"                   { return new Symbol(sym.VPRINTF, yychar, yyline, yytext()); }
"vscanf"                    { return new Symbol(sym.VSCANF, yychar, yyline, yytext()); }
"vsnprintf"                 { return new Symbol(sym.VSNPRINTF, yychar, yyline, yytext()); }
"vsprintf"                  { return new Symbol(sym.VSPRINTF, yychar, yyline, yytext()); }
"vsscanf"                   { return new Symbol(sym.VSSCANF, yychar, yyline, yytext()); }
"remove"                    { return new Symbol(sym.REMOVE, yychar, yyline, yytext()); }
"rename"                    { return new Symbol(sym.RENAME, yychar, yyline, yytext()); }
"tmpfile"                   { return new Symbol(sym.TMPFILE, yychar, yyline, yytext()); }
"tmpnam"                    { return new Symbol(sym.TMPNAM, yychar, yyline, yytext()); }
"fclose"                    { return new Symbol(sym.FCLOSE, yychar, yyline, yytext()); }
"fflush"                    { return new Symbol(sym.FFLUSH, yychar, yyline, yytext()); }
"fopen"                     { return new Symbol(sym.FOPEN, yychar, yyline, yytext()); }
"freopen"                   { return new Symbol(sym.FREOPEN, yychar, yyline, yytext()); }
"setbuf"                    { return new Symbol(sym.SETBUF, yychar, yyline, yytext()); }
"setvbuf"                   { return new Symbol(sym.SETVBUF, yychar, yyline, yytext()); }
"tolower"                   { return new Symbol(sym.TOLOWER, yychar, yyline, yytext()); }
"toupper"                   { return new Symbol(sym.TOUPPER, yychar, yyline, yytext()); }
"feclearexcept"             { return new Symbol(sym.FECLEAREXCEPT, yychar, yyline, yytext()); }
"feraiseexcept"             { return new Symbol(sym.FERAISEEXCEPT, yychar, yyline, yytext()); }
"fegetexceptflag"           { return new Symbol(sym.FEGETEXCEPTFLAG, yychar, yyline, yytext()); }
"fesetexceptflag"           { return new Symbol(sym.FESETEXCEPTFLAG, yychar, yyline, yytext()); }
"fegetround"                { return new Symbol(sym.FEGETROUND, yychar, yyline, yytext()); }
"fesetround"                { return new Symbol(sym.FESETROUND, yychar, yyline, yytext()); }
"fegetenv"                  { return new Symbol(sym.FEGETENV, yychar, yyline, yytext()); }
"Fesetenv"                  { return new Symbol(sym.FESETENV, yychar, yyline, yytext()); }
"feholdexcept"              { return new Symbol(sym.FEHOLDEXCEPT, yychar, yyline, yytext()); }
"feupdateenv"               { return new Symbol(sym.FEUPDATEENV, yychar, yyline, yytext()); }
"fetestexcept"              { return new Symbol(sym.FETESTEXCEPT, yychar, yyline, yytext()); }
"setlocale"                 { return new Symbol(sym.SETLOCALE, yychar, yyline, yytext()); }
"localeconv"                { return new Symbol(sym.LOCALECONV, yychar, yyline, yytext()); }
"cos"                       { return new Symbol(sym.COS, yychar, yyline, yytext()); }
"sin"                       { return new Symbol(sym.SIN, yychar, yyline, yytext()); }
"tan"                       { return new Symbol(sym.TAN, yychar, yyline, yytext()); }
"acos"                      { return new Symbol(sym.ACOS, yychar, yyline, yytext()); }
"asin"                      { return new Symbol(sym.ASIN, yychar, yyline, yytext()); }
"atan"                      { return new Symbol(sym.ATAN, yychar, yyline, yytext()); }
"atan2"                     { return new Symbol(sym.ATAN2, yychar, yyline, yytext()); }
"cosh"                      { return new Symbol(sym.COSH, yychar, yyline, yytext()); }
"sinh"                      { return new Symbol(sym.SINH, yychar, yyline, yytext()); }
"tanh"                      { return new Symbol(sym.TANH, yychar, yyline, yytext()); }
"acosh"                     { return new Symbol(sym.ACOSH, yychar, yyline, yytext()); }
"asinh"                     { return new Symbol(sym.ASINH, yychar, yyline, yytext()); }
"atanh"                     { return new Symbol(sym.ATANH, yychar, yyline, yytext()); }
"exp"                       { return new Symbol(sym.EXP, yychar, yyline, yytext()); }
"frexp"                     { return new Symbol(sym.FREXP, yychar, yyline, yytext()); }
"ldexp"                     { return new Symbol(sym.LDEXP, yychar, yyline, yytext()); }
"log"                       { return new Symbol(sym.LOG, yychar, yyline, yytext()); }
"log10"                     { return new Symbol(sym.LOG10, yychar, yyline, yytext()); }
"modf"                      { return new Symbol(sym.MODF, yychar, yyline, yytext()); }
"exp2"                      { return new Symbol(sym.EXP2, yychar, yyline, yytext()); }
"expm1"                     { return new Symbol(sym.EXPM1, yychar, yyline, yytext()); }
"ilogb"                     { return new Symbol(sym.ILOGB, yychar, yyline, yytext()); }
"log1p"                     { return new Symbol(sym.LOG1P, yychar, yyline, yytext()); }
"log2"                      { return new Symbol(sym.LOG2, yychar, yyline, yytext()); }
"scalbn"                    { return new Symbol(sym.SCALBN, yychar, yyline, yytext()); }
"scalbln"                   { return new Symbol(sym.SCALBLN, yychar, yyline, yytext()); }
"pow"                       { return new Symbol(sym.POW, yychar, yyline, yytext()); }
"sqrt"                      { return new Symbol(sym.SQRT, yychar, yyline, yytext()); }
"cbrt"                      { return new Symbol(sym.CBRT, yychar, yyline, yytext()); }
"hypot"                     { return new Symbol(sym.HYPOT, yychar, yyline, yytext()); }
"erf"                       { return new Symbol(sym.ERF, yychar, yyline, yytext()); }
"erfc"                      { return new Symbol(sym.ERFC, yychar, yyline, yytext()); }
"tgamma"                    { return new Symbol(sym.TGAMMA, yychar, yyline, yytext()); }
"lgamma"                    { return new Symbol(sym.LGAMMA, yychar, yyline, yytext()); }
"ceil"                      { return new Symbol(sym.CEIL, yychar, yyline, yytext()); }
"floor"                     { return new Symbol(sym.FLOOR, yychar, yyline, yytext()); }
"fmod"                      { return new Symbol(sym.FMOD, yychar, yyline, yytext()); }
"trunc"                     { return new Symbol(sym.TRUNC, yychar, yyline, yytext()); }
"round"                     { return new Symbol(sym.ROUND, yychar, yyline, yytext()); }
"lround"                    { return new Symbol(sym.LROUND, yychar, yyline, yytext()); }
"llround"                   { return new Symbol(sym.LLROUND, yychar, yyline, yytext()); }
"rint"                      { return new Symbol(sym.RINT, yychar, yyline, yytext()); }
"lrint"                     { return new Symbol(sym.LRINT, yychar, yyline, yytext()); }
"llrint"                    { return new Symbol(sym.LLRINT, yychar, yyline, yytext()); }
"nearbyint"                 { return new Symbol(sym.NEARBYINT, yychar, yyline, yytext()); }
"remainder"                 { return new Symbol(sym.REMAINDER, yychar, yyline, yytext()); }
"remquo"                    { return new Symbol(sym.REMQUO, yychar, yyline, yytext()); }
"copysign"                  { return new Symbol(sym.COPYSIGN, yychar, yyline, yytext()); }
"nan"                       { return new Symbol(sym.NAN, yychar, yyline, yytext()); }
"nextafter"                 { return new Symbol(sym.NEXTAFTER, yychar, yyline, yytext()); }
"nexttoward"                { return new Symbol(sym.NEXTTOWARD, yychar, yyline, yytext()); }
"fdim"                      { return new Symbol(sym.FDIM, yychar, yyline, yytext()); }
"fmax"                      { return new Symbol(sym.FMAX, yychar, yyline, yytext()); }
"fmin"                      { return new Symbol(sym.FMIN, yychar, yyline, yytext()); }
"fabs"                      { return new Symbol(sym.FABS, yychar, yyline, yytext()); }
"abs"                       { return new Symbol(sym.ABS, yychar, yyline, yytext()); }
"fma"                       { return new Symbol(sym.FMA, yychar, yyline, yytext()); }
"main"                      { return new Symbol(sym.Main, yychar, yyline, yytext()); }
"include"                   { return new Symbol(sym.Include, yychar, yyline, yytext()); }
"h"                         { return new Symbol(sym.Letra_H, yychar, yyline, yytext()); }
(iostream | conio | math |ctype | fenv | stdio) {return new Symbol(sym.Libreria, yychar, yyline, yytext());}
{L}({L}|{D})*               { return new Symbol(sym.ident, yychar, yyline, yytext()); }
("(-"{D}+")")|{D}+          { return new Symbol(sym.numero, yychar, yyline, yytext()); }
.                           { return new Symbol(sym.ERROR, yychar, yyline, yytext()); }




