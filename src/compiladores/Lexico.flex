package compiladores;
import static compiladores.Tokens.*;
%%
%class Lexer
%type Tokens

L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
{espacio}               { /*Ignore*/}
"//".*                  { /*Ignore*/}

"\n"                        { lexeme=yytext(); return Linea; }
"/*"                        { lexeme=yytext(); return coment_1; }
"//"                        { lexeme=yytext(); return coment_2; }
"{"                         { lexeme=yytext(); return id1; }
"<%"                        { lexeme=yytext(); return id1; }
"}"                         { lexeme=yytext(); return id2; }
"%>"                        { lexeme=yytext(); return id2; }
"["                         { lexeme=yytext(); return id3; }
"<:"                        { lexeme=yytext(); return id3; }
"]"                         { lexeme=yytext(); return id4; }
":>"                        { lexeme=yytext(); return id4; }
"("                         { lexeme=yytext(); return id5; }
")"                         { lexeme=yytext(); return id6; }
";"                         { lexeme=yytext(); return id7; }
":"                         { lexeme=yytext(); return id8; }
"..."                       { lexeme=yytext(); return ELLIPSIS; }
"?"                         { lexeme=yytext(); return id9; }
"::"                        { lexeme=yytext(); return COLONCOLON; }
"."                         { lexeme=yytext(); return id10; }
".*"                        { lexeme=yytext(); return DOTSTAR; }
"+"                         { lexeme=yytext(); return id11; }
"-"                         { lexeme=yytext(); return id12; }
"*"                         { lexeme=yytext(); return id13; }
"/"                         { lexeme=yytext(); return id14; }
"%"                         { lexeme=yytext(); return id15; }
"^"                         { lexeme=yytext(); return id16; }
"xor"                       { lexeme=yytext(); return id16; }
"&"                         { lexeme=yytext(); return id17; }
"bitand"                    { lexeme=yytext(); return id18; }
"|"                         { lexeme=yytext(); return id19; }
"bitor"                     { lexeme=yytext(); return id19; }
"~"                         { lexeme=yytext(); return id20; }
"compl"                     { lexeme=yytext(); return id20; }
"!"                         { lexeme=yytext(); return id21; }
"not"                       { lexeme=yytext(); return id21; }
"="                         { lexeme=yytext(); return id22; }
"<"                         { lexeme=yytext(); return id23; }
">"                         { lexeme=yytext(); return id24; }
"+="                        { lexeme=yytext(); return ADDEQ; }
"-="                        { lexeme=yytext(); return SUBEQ; }
"*="                        { lexeme=yytext(); return MULEQ; }
"/="                        { lexeme=yytext(); return DIVEQ; }
"%="                        { lexeme=yytext(); return MODEQ; }
"^="                        { lexeme=yytext(); return XOREQ; }
"xor_eq"                    { lexeme=yytext(); return XOREQ; }
"&="                        { lexeme=yytext(); return ANDEQ; }
"and_eq"                    { lexeme=yytext(); return ANDEQ; }
"|="                        { lexeme=yytext(); return OREQ; }
"or_eq"                     { lexeme=yytext(); return OREQ; }
"<<"                        { lexeme=yytext(); return SL; }
">>"                        { lexeme=yytext(); return SR; }
"<<="                       { lexeme=yytext(); return SLEQ; }
">>="                       { lexeme=yytext(); return SREQ; }
"=="                        { lexeme=yytext(); return EQ; }
"!="                        { lexeme=yytext(); return NOTEQ; }
"not_eq"                    { lexeme=yytext(); return NOTEQ; }
"<="                        { lexeme=yytext(); return LTEQ; }
">="                        { lexeme=yytext(); return GTEQ; }
"&&"                        { lexeme=yytext(); return ANDAND; }
"and"                       { lexeme=yytext(); return ANDAND; }
"||"                        { lexeme=yytext(); return OROR; }
"or"                        { lexeme=yytext(); return OROR; }
"++"                        { lexeme=yytext(); return PLUSPLUS; }
"--"                        { lexeme=yytext(); return MINUSMINUS; }
","                         { lexeme=yytext(); return id25; }
"#"                         { lexeme=yytext(); return id26; }
"->*"                       { lexeme=yytext(); return ARROWSTAR; }
"->"                        { lexeme=yytext(); return ARROW; }
"asm"                       { lexeme=yytext(); return ASM; }
"auto"                      { lexeme=yytext(); return AUTO; }
"bool"                      { lexeme=yytext(); return BOOL; }
"break"                     { lexeme=yytext(); return BREAK; }
"case"                      { lexeme=yytext(); return CASE; }
"catch"                     { lexeme=yytext(); return CATCH; }
"char"                      { lexeme=yytext(); return CHAR; }
"class"                     { lexeme=yytext(); return CLASS; }
"const"                     { lexeme=yytext(); return CONST; }
"const_cast"                { lexeme=yytext(); return CONST_CAST; }
"continue"                  { lexeme=yytext(); return CONTINUE; }
"default"                   { lexeme=yytext(); return DEFAULT; }
"delete"                    { lexeme=yytext(); return DELETE; }
"do"                        { lexeme=yytext(); return DO; }
"double"                    { lexeme=yytext(); return DOUBLE; }
"dynamic_cast"              { lexeme=yytext(); return DYNAMIC_CAST; }
"else"                      { lexeme=yytext(); return ELSE; }
"enum"                      { lexeme=yytext(); return ENUM; }
"explicit"                  { lexeme=yytext(); return EXPLICIT; }
"export"                    { lexeme=yytext(); return EXPORT; }
"extern"                    { lexeme=yytext(); return EXTERN; }
"false"                     { lexeme=yytext(); return FALSE; }
"float"                     { lexeme=yytext(); return FLOAT; }
"for"                       { lexeme=yytext(); return FOR; }
"friend"                    { lexeme=yytext(); return FRIEND; }
"goto"                      { lexeme=yytext(); return GOTO; }
"if"                        { lexeme=yytext(); return IF; }
"inline"                    { lexeme=yytext(); return INLINE; }
"int"                       { lexeme=yytext(); return INT; }
"long"                      { lexeme=yytext(); return LONG; }
"mutable"                   { lexeme=yytext(); return MUTABLE; }
"namespace"                 { lexeme=yytext(); return NAMESPACE; }
"new"                       { lexeme=yytext(); return NEW; }
"operator"                  { lexeme=yytext(); return OPERATOR; }
"private"                   { lexeme=yytext(); return PRIVATE; }
"protected"                 { lexeme=yytext(); return PROTECTED; }
"public"                    { lexeme=yytext(); return PUBLIC; }
"register"                  { lexeme=yytext(); return REGISTER; }
"reinterpret_cast"          { lexeme=yytext(); return REINTERPRET_CAST; }
"return"                    { lexeme=yytext(); return RETURN; }
"short"                     { lexeme=yytext(); return SHORT; }
"signed"                    { lexeme=yytext(); return SIGNED; }
"sizeof"                    { lexeme=yytext(); return SIZEOF; }
"static"                    { lexeme=yytext(); return STATIC; }
"static_cast"               { lexeme=yytext(); return STATIC_CAST; }
"struct"                    { lexeme=yytext(); return STRUCT; }
"switch"                    { lexeme=yytext(); return SWITCH; }
"template"                  { lexeme=yytext(); return TEMPLATE; }
"this"                      { lexeme=yytext(); return THIS; }
"throw"                     { lexeme=yytext(); return THROW; }
"true"                      { lexeme=yytext(); return TRUE; }
"try"                       { lexeme=yytext(); return TRY; }
"typedef"                   { lexeme=yytext(); return TYPEDEF; }
"typeid"                    { lexeme=yytext(); return TYPEID; }
"typename"                  { lexeme=yytext(); return TYPENAME; }
"union"                     { lexeme=yytext(); return UNION; }
"unsigned"                  { lexeme=yytext(); return UNSIGNED; }
"using"                     { lexeme=yytext(); return USING; }
"virtual"                   { lexeme=yytext(); return VIRTUAL; }
"void"                      { lexeme=yytext(); return VOID; }
"volatile"                  { lexeme=yytext(); return VOLATILE; }
"wchar_t"                   { lexeme=yytext(); return WCHAR_T; }
"while"                     { lexeme=yytext(); return WHILE; }
"begin"                     { lexeme=yytext(); return BEGIN; }
"end"                       { lexeme=yytext(); return END; }
"rbegin"                    { lexeme=yytext(); return RBEGIN; }
"rend"                      { lexeme=yytext(); return REND; }
"cbegin"                    { lexeme=yytext(); return CBEGIN; }
"cend"                      { lexeme=yytext(); return CEND; }
"crbegin"                   { lexeme=yytext(); return CRBEGIN; }
"crend"                     { lexeme=yytext(); return CREND; }
"cout"                      { lexeme=yytext(); return COUT; }
"cin"                       { lexeme=yytext(); return CIN; }
"isalnum"                   { lexeme=yytext(); return ISALNUM; }
"isalpha"                   { lexeme=yytext(); return ISALPHA; }
"iscntrl"                   { lexeme=yytext(); return ISCNTRL; }
"isdigit"                   { lexeme=yytext(); return ISDIGIT; }
"isgraph"                   { lexeme=yytext(); return ISGRAPH; }
"islower"                   { lexeme=yytext(); return ISLOWER; }
"isprint"                   { lexeme=yytext(); return ISPRINT; }
"ispunct"                   { lexeme=yytext(); return ISPUNC; }
"isspace"                   { lexeme=yytext(); return ISSPACE; }
"isupper"                   { lexeme=yytext(); return ISUPPER; }
"isxdigit"                  { lexeme=yytext(); return ISXDIGIT; }
"fprintf"                   { lexeme=yytext(); return FPRINTF; }
"fscanf"                    { lexeme=yytext(); return FSCANF; }
"printf"                    { lexeme=yytext(); return PRINTF; }
"scanf"                     { lexeme=yytext(); return SCANF; }
"snprintf"                  { lexeme=yytext(); return SNPRINTF; }
"sprintf"                   { lexeme=yytext(); return SPRINTF; }
"sscanf"                    { lexeme=yytext(); return SSCANF; }
"vfprintf"                  { lexeme=yytext(); return VFPRINTF; }
"vfscanf"                   { lexeme=yytext(); return VFSCANF; }
"vprintf"                   { lexeme=yytext(); return VPRINTF; }
"vscanf"                    { lexeme=yytext(); return VSCANF; }
"vsnprintf"                 { lexeme=yytext(); return VSNPRINTF; }
"vsprintf"                  { lexeme=yytext(); return VSPRINTF; }
"vsscanf"                   { lexeme=yytext(); return VSSCANF; }
"remove"                    { lexeme=yytext(); return REMOVE; }
"rename"                    { lexeme=yytext(); return RENAME; }
"tmpfile"                   { lexeme=yytext(); return TMPFILE; }
"tmpnam"                    { lexeme=yytext(); return TMPNAM; }
"fclose"                    { lexeme=yytext(); return FCLOSE; }
"fflush"                    { lexeme=yytext(); return FFLUSH; }
"fopen"                     { lexeme=yytext(); return FOPEN; }
"freopen"                   { lexeme=yytext(); return FREOPEN; }
"setbuf"                    { lexeme=yytext(); return SETBUF; }
"setvbuf"                   { lexeme=yytext(); return SETVBUF; }
"main"                      { lexeme=yytext(); return Main;}
{L}({L}|{D})*               { lexeme=yytext(); return ident;}
("(-"{D}+")")|{D}+          { lexeme=yytext(); return numero;}
.                           {return ERROR;}



