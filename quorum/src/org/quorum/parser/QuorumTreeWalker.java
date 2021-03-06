// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g 2013-06-03 16:54:50


package org.quorum.parser;
import org.quorum.vm.interfaces.*;
import org.quorum.symbols.*;
import org.quorum.vm.implementation.*;
import org.quorum.steps.*;
import org.quorum.execution.ExpressionValue;
import org.quorum.execution.ExecutionStep;
import org.quorum.execution.ScopeSelector;
import java.util.Iterator;
import java.util.Vector;
import java.util.Enumeration;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class QuorumTreeWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "ALERT", "ALWAYS", "AND", "BLUEPRINT", "BOOLEAN", "BOOLEAN_KEYWORD", "CAST", "CAST_EXPRESSION", "CHECK", "CLASS", "COLON", "COMMA", "COMMENTS", "CONSTANT", "CONSTRUCTOR", "CREATE", "DECIMAL", "DESTROY", "DETECT", "DIVIDE", "DOUBLE_QUOTE", "ELSE", "ELSE_IF", "ELSE_IF_STATEMENT", "END", "EQUALITY", "EXPRESSION_STATEMENT", "FINAL_ELSE", "FPARAM", "FUNCTION_CALL", "FUNCTION_CALL_PARENT", "FUNCTION_CALL_THIS", "FUNCTION_EXPRESSION_LIST", "GENERIC", "GREATER", "GREATER_EQUAL", "ID", "IF", "INHERITS", "INPUT", "INPUT_EXPRESSION", "INT", "INTEGER_KEYWORD", "LEFT_PAREN", "LEFT_SQR_BRACE", "LESS", "LESS_EQUAL", "ME", "MINUS", "MODULO", "MULTIPLY", "NATIVE", "NEWLINE", "NOT", "NOTEQUALS", "NOW", "NULL", "NUMBER_KEYWORD", "ON", "OR", "OUTPUT", "OVER", "PACKAGE_NAME", "PARENT", "PAREN_EXPRESSION", "PAREN_WRAPPED_EXPRESSION", "PERIOD", "PLUS", "PRIVATE", "PUBLIC", "QUALIFIED_NAME", "QUALIFIED_SOLO_EXPRESSION", "QUALIFIED_SOLO_EXPRESSION_SELECTOR", "QUALIFIED_SOLO_PARENT_EXPRESSON", "REPEAT", "RETURN", "RETURNS", "RIGHT_PAREN", "RIGHT_SQR_BRACE", "ROOT_EXPRESSION", "SAY", "SOLO_FUNCTION_CALL", "SOLO_FUNCTION_CALL_PARENT", "SOLO_FUNCTION_CALL_THIS", "STATEMENT_LIST", "STRING", "TEXT", "TIMES", "UNARY_NOT", "UNTIL", "USE", "WHILE", "WS"
    };
    public static final int CAST=11;
    public static final int FUNCTION_CALL_THIS=36;
    public static final int WHILE=96;
    public static final int GENERIC=38;
    public static final int INPUT_EXPRESSION=45;
    public static final int DOUBLE_QUOTE=25;
    public static final int ME=52;
    public static final int NOW=60;
    public static final int NOT=58;
    public static final int EOF=-1;
    public static final int SOLO_FUNCTION_CALL_PARENT=87;
    public static final int PAREN_WRAPPED_EXPRESSION=70;
    public static final int ACTION=4;
    public static final int CREATE=20;
    public static final int GREATER=39;
    public static final int COMMENTS=17;
    public static final int INHERITS=43;
    public static final int ALWAYS=6;
    public static final int LESS=50;
    public static final int RETURN=80;
    public static final int UNARY_NOT=93;
    public static final int FPARAM=33;
    public static final int FUNCTION_EXPRESSION_LIST=37;
    public static final int RIGHT_SQR_BRACE=83;
    public static final int DIVIDE=24;
    public static final int DESTROY=22;
    public static final int INTEGER_KEYWORD=47;
    public static final int SOLO_FUNCTION_CALL=86;
    public static final int PERIOD=71;
    public static final int PRIVATE=73;
    public static final int NULL=61;
    public static final int ELSE=26;
    public static final int NATIVE=56;
    public static final int ON=63;
    public static final int INT=46;
    public static final int SAY=85;
    public static final int WS=97;
    public static final int UNTIL=94;
    public static final int OR=64;
    public static final int CONSTANT=18;
    public static final int LEFT_PAREN=48;
    public static final int CHECK=13;
    public static final int LESS_EQUAL=51;
    public static final int REPEAT=79;
    public static final int EXPRESSION_STATEMENT=31;
    public static final int USE=95;
    public static final int END=29;
    public static final int FUNCTION_CALL=34;
    public static final int CONSTRUCTOR=19;
    public static final int OUTPUT=65;
    public static final int OVER=66;
    public static final int EQUALITY=30;
    public static final int CAST_EXPRESSION=12;
    public static final int CLASS=14;
    public static final int ELSE_IF_STATEMENT=28;
    public static final int QUALIFIED_SOLO_PARENT_EXPRESSON=78;
    public static final int ALERT=5;
    public static final int INPUT=44;
    public static final int SOLO_FUNCTION_CALL_THIS=88;
    public static final int ID=41;
    public static final int AND=7;
    public static final int IF=42;
    public static final int PARENT=68;
    public static final int RIGHT_PAREN=82;
    public static final int BOOLEAN=9;
    public static final int MULTIPLY=55;
    public static final int COMMA=16;
    public static final int PLUS=72;
    public static final int PAREN_EXPRESSION=69;
    public static final int ELSE_IF=27;
    public static final int RETURNS=81;
    public static final int QUALIFIED_NAME=75;
    public static final int MODULO=54;
    public static final int FUNCTION_CALL_PARENT=35;
    public static final int QUALIFIED_SOLO_EXPRESSION=76;
    public static final int FINAL_ELSE=32;
    public static final int NOTEQUALS=59;
    public static final int STATEMENT_LIST=89;
    public static final int MINUS=53;
    public static final int TEXT=91;
    public static final int ROOT_EXPRESSION=84;
    public static final int PACKAGE_NAME=67;
    public static final int COLON=15;
    public static final int NEWLINE=57;
    public static final int DECIMAL=21;
    public static final int DETECT=23;
    public static final int BLUEPRINT=8;
    public static final int BOOLEAN_KEYWORD=10;
    public static final int LEFT_SQR_BRACE=49;
    public static final int NUMBER_KEYWORD=62;
    public static final int QUALIFIED_SOLO_EXPRESSION_SELECTOR=77;
    public static final int TIMES=92;
    public static final int PUBLIC=74;
    public static final int GREATER_EQUAL=40;
    public static final int STRING=90;

    // delegates
    // delegators


        public QuorumTreeWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public QuorumTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("QuorumTreeWalkerTemplates", AngleBracketTemplateLexer.class);

    public void setTemplateLib(StringTemplateGroup templateLib) {
      this.templateLib = templateLib;
    }
    public StringTemplateGroup getTemplateLib() {
      return templateLib;
    }
    /** allows convenient multi-value initialization:
     *  "new STAttrMap().put(...).put(...)"
     */
    public static class STAttrMap extends HashMap {
      public STAttrMap put(String attrName, Object value) {
        super.put(attrName, value);
        return this;
      }
      public STAttrMap put(String attrName, int value) {
        super.put(attrName, new Integer(value));
        return this;
      }
    }

    public String[] getTokenNames() { return QuorumTreeWalker.tokenNames; }
    public String getGrammarFileName() { return "/Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g"; }


    	QuorumVirtualMachine vm;
    	AccessModifierEnum accessModifier;
    	SymbolTable symbol;
    	QualifiedNameDescriptor thisPackage = new QualifiedNameDescriptor();
    	String fileName;
    	boolean classWithNoName = false;
    	ClassDescriptor currentClass;
    	MethodDescriptor currentMethod;
    	IntermediateExecutionBuilder builder;
    	TypeChecker typeChecker;
    	StepFactory stepFactory = new StepFactory();
    	//used to create unique label hashes
    	static int labelCounter = 0;
    	static int sub_counter = 0;
    	static int expressionDepth = 0;
    	boolean inCallStep = false;
    	StringBuffer  indexer = new StringBuffer();
    	String className = "";
    	
    	//the register number, used to place values into fake registers in the computer
    	static int temp = 0;
    	public void setQuorumVirtualMachine(QuorumVirtualMachine m) {
    		vm = m;
    		symbol = vm.getSymbolTable();
    		builder = vm.getBuilder();
    		stepFactory.setMachine(vm);
    		stepFactory.setTypeChecker(m.getTypeChecker());
    		typeChecker = m.getTypeChecker();
    	}

    	public String getGrammarFileNameNoExtension() {
    		return fileName;
    	}

    	public void setGrammarFileNameNoExtension(String name) {
    		fileName = name;
    	}


    public static class start_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "start"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:66:1: start : ( package_rule ( reference )+ | ( reference )+ package_rule | package_rule | ( reference )+ | ) class_declaration EOF ;
    public final QuorumTreeWalker.start_return start() throws RecognitionException {
        QuorumTreeWalker.start_return retval = new QuorumTreeWalker.start_return();
        retval.start = input.LT(1);

        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:66:7: ( ( package_rule ( reference )+ | ( reference )+ package_rule | package_rule | ( reference )+ | ) class_declaration EOF )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:66:9: ( package_rule ( reference )+ | ( reference )+ package_rule | package_rule | ( reference )+ | ) class_declaration EOF
            {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:66:9: ( package_rule ( reference )+ | ( reference )+ package_rule | package_rule | ( reference )+ | )
            int alt4=5;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:66:10: package_rule ( reference )+
                    {
                    pushFollow(FOLLOW_package_rule_in_start51);
                    package_rule();

                    state._fsp--;

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:66:23: ( reference )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==USE) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:66:23: reference
                    	    {
                    	    pushFollow(FOLLOW_reference_in_start53);
                    	    reference();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:67:4: ( reference )+ package_rule
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:67:4: ( reference )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==USE) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:67:4: reference
                    	    {
                    	    pushFollow(FOLLOW_reference_in_start59);
                    	    reference();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    pushFollow(FOLLOW_package_rule_in_start62);
                    package_rule();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:68:4: package_rule
                    {
                    pushFollow(FOLLOW_package_rule_in_start67);
                    package_rule();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:69:4: ( reference )+
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:69:4: ( reference )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==USE) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:69:4: reference
                    	    {
                    	    pushFollow(FOLLOW_reference_in_start72);
                    	    reference();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;
                case 5 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:70:4: 
                    {
                    }
                    break;

            }

            pushFollow(FOLLOW_class_declaration_in_start81);
            class_declaration();

            state._fsp--;

            match(input,EOF,FOLLOW_EOF_in_start84); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "start"

    public static class package_rule_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "package_rule"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:74:1: package_rule : PACKAGE_NAME qn= qualified_name ;
    public final QuorumTreeWalker.package_rule_return package_rule() throws RecognitionException {
        QuorumTreeWalker.package_rule_return retval = new QuorumTreeWalker.package_rule_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.qualified_name_return qn = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:74:15: ( PACKAGE_NAME qn= qualified_name )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:74:17: PACKAGE_NAME qn= qualified_name
            {
            match(input,PACKAGE_NAME,FOLLOW_PACKAGE_NAME_in_package_rule96); 
            pushFollow(FOLLOW_qualified_name_in_package_rule100);
            qn=qualified_name();

            state._fsp--;


            		thisPackage = (qn!=null?qn.type:null);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "package_rule"

    public static class reference_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "reference"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:80:1: reference : USE qualified_name ;
    public final QuorumTreeWalker.reference_return reference() throws RecognitionException {
        QuorumTreeWalker.reference_return retval = new QuorumTreeWalker.reference_return();
        retval.start = input.LT(1);

        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:80:11: ( USE qualified_name )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:80:13: USE qualified_name
            {
            match(input,USE,FOLLOW_USE_in_reference113); 
            pushFollow(FOLLOW_qualified_name_in_reference115);
            qualified_name();

            state._fsp--;



            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "reference"

    public static class class_declaration_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "class_declaration"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:86:1: class_declaration : ( ^( CLASS ID ( generic_declaration )? ( inherit_stmnts )? ( class_stmnts )* END ) | no_class_stmnts );
    public final QuorumTreeWalker.class_declaration_return class_declaration() throws RecognitionException {
        QuorumTreeWalker.class_declaration_return retval = new QuorumTreeWalker.class_declaration_return();
        retval.start = input.LT(1);

        CommonTree ID1=null;

        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:86:20: ( ^( CLASS ID ( generic_declaration )? ( inherit_stmnts )? ( class_stmnts )* END ) | no_class_stmnts )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==CLASS) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=ACTION && LA8_0<=ALERT)||LA8_0==BLUEPRINT||LA8_0==BOOLEAN_KEYWORD||LA8_0==CHECK||LA8_0==CONSTANT||(LA8_0>=ID && LA8_0<=IF)||LA8_0==INTEGER_KEYWORD||LA8_0==ME||LA8_0==NATIVE||(LA8_0>=NUMBER_KEYWORD && LA8_0<=ON)||LA8_0==OUTPUT||LA8_0==PARENT||(LA8_0>=PRIVATE && LA8_0<=QUALIFIED_NAME)||(LA8_0>=REPEAT && LA8_0<=RETURN)||(LA8_0>=SAY && LA8_0<=SOLO_FUNCTION_CALL_THIS)||LA8_0==TEXT) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:87:2: ^( CLASS ID ( generic_declaration )? ( inherit_stmnts )? ( class_stmnts )* END )
                    {
                    match(input,CLASS,FOLLOW_CLASS_in_class_declaration131); 

                    match(input, Token.DOWN, null); 
                    ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_class_declaration133); 

                    		AccessModifierEnum e;
                    		String name;
                    		if((ID1!=null?ID1.getText():null) == null) {
                    			name = getGrammarFileNameNoExtension();
                    		}
                    		else {
                    			name = (ID1!=null?ID1.getText():null);
                    		}
                    		//get the class from the symbol table
                    		String container = thisPackage.toString();
                    		ClassDescriptor cl = symbol.enterClass(name, container);
                    		className = cl.getStaticKey();
                    		builder.begin(cl);
                    		indexer.append("<debug><class><name>");
                    		indexer.append(className);
                    		indexer.append("</name>");
                    	
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:106:2: ( generic_declaration )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==GENERIC) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:106:2: generic_declaration
                            {
                            pushFollow(FOLLOW_generic_declaration_in_class_declaration139);
                            generic_declaration();

                            state._fsp--;


                            }
                            break;

                    }



                    	
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:110:2: ( inherit_stmnts )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==INHERITS) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:110:2: inherit_stmnts
                            {
                            pushFollow(FOLLOW_inherit_stmnts_in_class_declaration146);
                            inherit_stmnts();

                            state._fsp--;


                            }
                            break;

                    }


                    	
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:113:2: ( class_stmnts )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==ACTION||LA7_0==BLUEPRINT||LA7_0==BOOLEAN_KEYWORD||LA7_0==CONSTANT||LA7_0==ID||LA7_0==INTEGER_KEYWORD||LA7_0==ME||LA7_0==NATIVE||(LA7_0>=NUMBER_KEYWORD && LA7_0<=ON)||LA7_0==PARENT||(LA7_0>=PRIVATE && LA7_0<=QUALIFIED_NAME)||LA7_0==TEXT) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:113:2: class_stmnts
                    	    {
                    	    pushFollow(FOLLOW_class_stmnts_in_class_declaration153);
                    	    class_stmnts();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match(input,END,FOLLOW_END_in_class_declaration156); 

                    		builder.endClass();
                    		symbol.popScope();
                    		indexer.append("</class></debug>");
                    		symbol.addClassIndexer(className, indexer.toString());
                    	

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:121:2: no_class_stmnts
                    {

                    		String name = getGrammarFileNameNoExtension();
                    		String container = thisPackage.toString();
                    		ClassDescriptor cl = symbol.enterClass(name, container);
                    		builder.begin(cl);
                    		indexer.append("<debug><class><name>");
                    		className = cl.getStaticKey();
                    		indexer.append(className);
                    		indexer.append("</name>");
                    	
                    pushFollow(FOLLOW_no_class_stmnts_in_class_declaration169);
                    no_class_stmnts();

                    state._fsp--;


                    		builder.endClass();
                    		symbol.popScope();
                    		indexer.append("</class></debug>");
                    		symbol.addClassIndexer(className, indexer.toString());
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "class_declaration"

    public static class no_class_stmnts_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "no_class_stmnts"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:140:1: no_class_stmnts : ( ( statement )+ | ( (modEnum= access_modifier )? method_declaration )+ );
    public final QuorumTreeWalker.no_class_stmnts_return no_class_stmnts() throws RecognitionException {
        QuorumTreeWalker.no_class_stmnts_return retval = new QuorumTreeWalker.no_class_stmnts_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.access_modifier_return modEnum = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:141:2: ( ( statement )+ | ( (modEnum= access_modifier )? method_declaration )+ )
            int alt12=2;
            switch ( input.LA(1) ) {
            case ALERT:
            case BOOLEAN_KEYWORD:
            case CHECK:
            case CONSTANT:
            case ID:
            case IF:
            case INTEGER_KEYWORD:
            case ME:
            case NUMBER_KEYWORD:
            case OUTPUT:
            case PARENT:
            case QUALIFIED_NAME:
            case REPEAT:
            case RETURN:
            case SAY:
            case SOLO_FUNCTION_CALL:
            case SOLO_FUNCTION_CALL_PARENT:
            case SOLO_FUNCTION_CALL_THIS:
            case TEXT:
                {
                alt12=1;
                }
                break;
            case PUBLIC:
                {
                int LA12_2 = input.LA(2);

                if ( (LA12_2==ACTION||LA12_2==BLUEPRINT||LA12_2==NATIVE||LA12_2==ON) ) {
                    alt12=2;
                }
                else if ( (LA12_2==BOOLEAN_KEYWORD||LA12_2==CONSTANT||LA12_2==INTEGER_KEYWORD||LA12_2==NUMBER_KEYWORD||LA12_2==QUALIFIED_NAME||LA12_2==TEXT) ) {
                    alt12=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 2, input);

                    throw nvae;
                }
                }
                break;
            case PRIVATE:
                {
                int LA12_3 = input.LA(2);

                if ( (LA12_3==BOOLEAN_KEYWORD||LA12_3==CONSTANT||LA12_3==INTEGER_KEYWORD||LA12_3==NUMBER_KEYWORD||LA12_3==QUALIFIED_NAME||LA12_3==TEXT) ) {
                    alt12=1;
                }
                else if ( (LA12_3==ACTION||LA12_3==BLUEPRINT||LA12_3==NATIVE||LA12_3==ON) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 3, input);

                    throw nvae;
                }
                }
                break;
            case ACTION:
            case BLUEPRINT:
            case NATIVE:
            case ON:
                {
                alt12=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:142:2: ( statement )+
                    {
                    //enter the fake method main
                    		MethodDescriptor md = symbol.enterMethod("main");
                    		builder.begin(md);
                    	
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:146:3: ( statement )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==ALERT||LA9_0==BOOLEAN_KEYWORD||LA9_0==CHECK||LA9_0==CONSTANT||(LA9_0>=ID && LA9_0<=IF)||LA9_0==INTEGER_KEYWORD||LA9_0==ME||LA9_0==NUMBER_KEYWORD||LA9_0==OUTPUT||LA9_0==PARENT||(LA9_0>=PRIVATE && LA9_0<=QUALIFIED_NAME)||(LA9_0>=REPEAT && LA9_0<=RETURN)||(LA9_0>=SAY && LA9_0<=SOLO_FUNCTION_CALL_THIS)||LA9_0==TEXT) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:146:3: statement
                    	    {
                    	    pushFollow(FOLLOW_statement_in_no_class_stmnts189);
                    	    statement();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    //exit the fake method main
                    	
                    		CompilerError error = symbol.getControlFlow().endMethod();
                    		if(error != null) {
                    			vm.getCompilerErrors().addError(error);
                    		}
                    		if(symbol.getControlFlow().needsReturnStep() && error == null) { //do this only for void types
                                    	LineInformation location = new LineInformation();
                    	                location.setStartColumn(0);
                    	                location.setStartLine(0);
                    	                location.setFile(getGrammarFileNameNoExtension());
                    			stepFactory.addReturnStep(location, null, null);
                    		}
                    		builder.endMethod();
                    		symbol.popScope();
                    	

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:163:4: ( (modEnum= access_modifier )? method_declaration )+
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:163:4: ( (modEnum= access_modifier )? method_declaration )+
                    int cnt11=0;
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==ACTION||LA11_0==BLUEPRINT||LA11_0==NATIVE||LA11_0==ON||(LA11_0>=PRIVATE && LA11_0<=PUBLIC)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:163:5: (modEnum= access_modifier )? method_declaration
                    	    {
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:163:13: (modEnum= access_modifier )?
                    	    int alt10=2;
                    	    int LA10_0 = input.LA(1);

                    	    if ( ((LA10_0>=PRIVATE && LA10_0<=PUBLIC)) ) {
                    	        alt10=1;
                    	    }
                    	    switch (alt10) {
                    	        case 1 :
                    	            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:163:13: modEnum= access_modifier
                    	            {
                    	            pushFollow(FOLLOW_access_modifier_in_no_class_stmnts203);
                    	            modEnum=access_modifier();

                    	            state._fsp--;


                    	            }
                    	            break;

                    	    }


                    	    		accessModifier = (modEnum!=null?modEnum.amEnum:null);
                    	    		if(accessModifier == null){
                    	    			accessModifier = accessModifier.PUBLIC;
                    	    		}
                    	    	
                    	    pushFollow(FOLLOW_method_declaration_in_no_class_stmnts211);
                    	    method_declaration();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt11 >= 1 ) break loop11;
                                EarlyExitException eee =
                                    new EarlyExitException(11, input);
                                throw eee;
                        }
                        cnt11++;
                    } while (true);


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "no_class_stmnts"

    public static class inherit_stmnts_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "inherit_stmnts"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:172:1: inherit_stmnts : ^( INHERITS (qn= qualified_name (gd= generic_statement )? )+ ) ;
    public final QuorumTreeWalker.inherit_stmnts_return inherit_stmnts() throws RecognitionException {
        QuorumTreeWalker.inherit_stmnts_return retval = new QuorumTreeWalker.inherit_stmnts_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.qualified_name_return qn = null;

        QuorumTreeWalker.generic_statement_return gd = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:173:2: ( ^( INHERITS (qn= qualified_name (gd= generic_statement )? )+ ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:173:4: ^( INHERITS (qn= qualified_name (gd= generic_statement )? )+ )
            {
            match(input,INHERITS,FOLLOW_INHERITS_in_inherit_stmnts225); 

            match(input, Token.DOWN, null); 
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:173:15: (qn= qualified_name (gd= generic_statement )? )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==QUALIFIED_NAME) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:173:17: qn= qualified_name (gd= generic_statement )?
            	    {
            	    pushFollow(FOLLOW_qualified_name_in_inherit_stmnts233);
            	    qn=qualified_name();

            	    state._fsp--;

            	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:173:40: (gd= generic_statement )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==GENERIC) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:173:40: gd= generic_statement
            	            {
            	            pushFollow(FOLLOW_generic_statement_in_inherit_stmnts239);
            	            gd=generic_statement();

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "inherit_stmnts"

    public static class access_modifier_return extends TreeRuleReturnScope {
        public AccessModifierEnum amEnum;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "access_modifier"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:175:1: access_modifier returns [AccessModifierEnum amEnum] : ( PUBLIC | PRIVATE );
    public final QuorumTreeWalker.access_modifier_return access_modifier() throws RecognitionException {
        QuorumTreeWalker.access_modifier_return retval = new QuorumTreeWalker.access_modifier_return();
        retval.start = input.LT(1);

        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:176:2: ( PUBLIC | PRIVATE )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==PUBLIC) ) {
                alt15=1;
            }
            else if ( (LA15_0==PRIVATE) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:176:4: PUBLIC
                    {
                    match(input,PUBLIC,FOLLOW_PUBLIC_in_access_modifier257); 

                    		retval.amEnum = retval.amEnum.PUBLIC;
                    	

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:180:4: PRIVATE
                    {
                    match(input,PRIVATE,FOLLOW_PRIVATE_in_access_modifier265); 

                    		retval.amEnum = retval.amEnum.PRIVATE;
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "access_modifier"

    public static class class_stmnts_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "class_stmnts"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:185:1: class_stmnts : ( assignment_statement | (modEnum= access_modifier )? method_declaration );
    public final QuorumTreeWalker.class_stmnts_return class_stmnts() throws RecognitionException {
        QuorumTreeWalker.class_stmnts_return retval = new QuorumTreeWalker.class_stmnts_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.access_modifier_return modEnum = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:186:2: ( assignment_statement | (modEnum= access_modifier )? method_declaration )
            int alt17=2;
            switch ( input.LA(1) ) {
            case BOOLEAN_KEYWORD:
            case CONSTANT:
            case ID:
            case INTEGER_KEYWORD:
            case ME:
            case NUMBER_KEYWORD:
            case PARENT:
            case QUALIFIED_NAME:
            case TEXT:
                {
                alt17=1;
                }
                break;
            case PUBLIC:
                {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==BOOLEAN_KEYWORD||LA17_2==CONSTANT||LA17_2==INTEGER_KEYWORD||LA17_2==NUMBER_KEYWORD||LA17_2==QUALIFIED_NAME||LA17_2==TEXT) ) {
                    alt17=1;
                }
                else if ( (LA17_2==ACTION||LA17_2==BLUEPRINT||LA17_2==NATIVE||LA17_2==ON) ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;
                }
                }
                break;
            case PRIVATE:
                {
                int LA17_3 = input.LA(2);

                if ( (LA17_3==ACTION||LA17_3==BLUEPRINT||LA17_3==NATIVE||LA17_3==ON) ) {
                    alt17=2;
                }
                else if ( (LA17_3==BOOLEAN_KEYWORD||LA17_3==CONSTANT||LA17_3==INTEGER_KEYWORD||LA17_3==NUMBER_KEYWORD||LA17_3==QUALIFIED_NAME||LA17_3==TEXT) ) {
                    alt17=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 3, input);

                    throw nvae;
                }
                }
                break;
            case ACTION:
            case BLUEPRINT:
            case NATIVE:
            case ON:
                {
                alt17=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:186:4: assignment_statement
                    {
                    pushFollow(FOLLOW_assignment_statement_in_class_stmnts279);
                    assignment_statement();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:187:4: (modEnum= access_modifier )? method_declaration
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:187:12: (modEnum= access_modifier )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=PRIVATE && LA16_0<=PUBLIC)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:187:12: modEnum= access_modifier
                            {
                            pushFollow(FOLLOW_access_modifier_in_class_stmnts288);
                            modEnum=access_modifier();

                            state._fsp--;


                            }
                            break;

                    }


                    		if(modEnum == null){
                    			accessModifier = AccessModifierEnum.PUBLIC;
                    		}
                    		else {
                    			accessModifier = (modEnum!=null?modEnum.amEnum:null);
                    		}
                    	
                    pushFollow(FOLLOW_method_declaration_in_class_stmnts296);
                    method_declaration();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "class_stmnts"

    protected static class method_declaration_scope {
        Vector<TypeDescriptor> types;
    }
    protected Stack method_declaration_stack = new Stack();

    public static class method_declaration_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "method_declaration"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:198:1: method_declaration : ( ^( ACTION ID (fp= formal_parameter )* ( RETURNS ad= assignment_declaration )? block[false] END ) | ^( BLUEPRINT ACTION ID (fp= formal_parameter )* ( RETURNS assignment_declaration )? ) | ^( NATIVE ACTION ID (fp= formal_parameter )* ( RETURNS assignment_declaration )? ) | ^( ON CREATE block[true] END ) );
    public final QuorumTreeWalker.method_declaration_return method_declaration() throws RecognitionException {
        method_declaration_stack.push(new method_declaration_scope());
        QuorumTreeWalker.method_declaration_return retval = new QuorumTreeWalker.method_declaration_return();
        retval.start = input.LT(1);

        CommonTree ID2=null;
        CommonTree ACTION3=null;
        CommonTree END4=null;
        CommonTree END5=null;
        QuorumTreeWalker.formal_parameter_return fp = null;

        QuorumTreeWalker.assignment_declaration_return ad = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:202:2: ( ^( ACTION ID (fp= formal_parameter )* ( RETURNS ad= assignment_declaration )? block[false] END ) | ^( BLUEPRINT ACTION ID (fp= formal_parameter )* ( RETURNS assignment_declaration )? ) | ^( NATIVE ACTION ID (fp= formal_parameter )* ( RETURNS assignment_declaration )? ) | ^( ON CREATE block[true] END ) )
            int alt24=4;
            switch ( input.LA(1) ) {
            case ACTION:
                {
                alt24=1;
                }
                break;
            case BLUEPRINT:
                {
                alt24=2;
                }
                break;
            case NATIVE:
                {
                alt24=3;
                }
                break;
            case ON:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:202:4: ^( ACTION ID (fp= formal_parameter )* ( RETURNS ad= assignment_declaration )? block[false] END )
                    {
                    ACTION3=(CommonTree)match(input,ACTION,FOLLOW_ACTION_in_method_declaration314); 


                    		((method_declaration_scope)method_declaration_stack.peek()).types = new Vector<TypeDescriptor>();
                    	

                    match(input, Token.DOWN, null); 
                    ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_method_declaration320); 
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:208:5: (fp= formal_parameter )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==FPARAM) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:208:6: fp= formal_parameter
                    	    {
                    	    pushFollow(FOLLOW_formal_parameter_in_method_declaration325);
                    	    fp=formal_parameter();

                    	    state._fsp--;

                    	     ((method_declaration_scope)method_declaration_stack.peek()).types.add((fp).type); 

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    	                String key = MethodDescriptor.autoGenerateKey((ID2!=null?ID2.getText():null), ((method_declaration_scope)method_declaration_stack.peek()).types);
                    	                MethodDescriptor md = symbol.enterMethod(key);
                    	               	md.setAccessModifier(accessModifier);
                    		builder.begin(md);
                    		

                    	
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:218:3: ( RETURNS ad= assignment_declaration )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RETURNS) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:218:4: RETURNS ad= assignment_declaration
                            {
                            match(input,RETURNS,FOLLOW_RETURNS_in_method_declaration338); 
                            pushFollow(FOLLOW_assignment_declaration_in_method_declaration342);
                            ad=assignment_declaration();

                            state._fsp--;


                            			if((ad!=null?ad.myType:null) != null) {
                            				MethodDescriptor mdResolve = symbol.getCurrentMethod();	
                            				mdResolve.setReturnType((ad!=null?ad.myType:null));
                            			}
                            		

                            }
                            break;

                    }

                    pushFollow(FOLLOW_block_in_method_declaration348);
                    block(false);

                    state._fsp--;

                    END4=(CommonTree)match(input,END,FOLLOW_END_in_method_declaration351); 

                    		indexer.append("<action line = \"");
                    		indexer.append(ACTION3.getLine());
                    		indexer.append("\" end = \"");
                    		indexer.append(END4.getLine());
                    		indexer.append("\"/>");
                    		
                    		symbol.addStatementFlagToCurrentFile((END4!=null?END4.getLine():0));
                    		
                    		CompilerError error = symbol.getControlFlow().endMethod();
                    		if(error != null) {
                    			vm.getCompilerErrors().addError(error);
                    		}
                    		
                                    if(symbol.getControlFlow().needsReturnStep() && error == null) { //do this only for void types
                                    	LineInformation location = new LineInformation();
                    	                location.setStartColumn(END4.getCharPositionInLine());
                    	                location.setStartLine((END4!=null?END4.getLine():0));
                    	                location.setFile(getGrammarFileNameNoExtension());
                    			stepFactory.addReturnStep(location, null, null);
                    		}
                    		
                    		builder.endMethod();
                    		//return scope to the class
                    		symbol.popScope();
                    		

                    	

                    match(input, Token.UP, null); 

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:253:6: ^( BLUEPRINT ACTION ID (fp= formal_parameter )* ( RETURNS assignment_declaration )? )
                    {
                    match(input,BLUEPRINT,FOLLOW_BLUEPRINT_in_method_declaration366); 

                    match(input, Token.DOWN, null); 
                    match(input,ACTION,FOLLOW_ACTION_in_method_declaration368); 

                    		((method_declaration_scope)method_declaration_stack.peek()).types = new Vector<TypeDescriptor>();
                    	
                    match(input,ID,FOLLOW_ID_in_method_declaration375); 
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:257:6: (fp= formal_parameter )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==FPARAM) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:257:7: fp= formal_parameter
                    	    {
                    	    pushFollow(FOLLOW_formal_parameter_in_method_declaration380);
                    	    fp=formal_parameter();

                    	    state._fsp--;

                    	     ((method_declaration_scope)method_declaration_stack.peek()).types.add((fp).type); 

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:258:4: ( RETURNS assignment_declaration )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RETURNS) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:258:5: RETURNS assignment_declaration
                            {
                            match(input,RETURNS,FOLLOW_RETURNS_in_method_declaration389); 
                            pushFollow(FOLLOW_assignment_declaration_in_method_declaration391);
                            assignment_declaration();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 3 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:259:4: ^( NATIVE ACTION ID (fp= formal_parameter )* ( RETURNS assignment_declaration )? )
                    {
                    match(input,NATIVE,FOLLOW_NATIVE_in_method_declaration400); 

                    match(input, Token.DOWN, null); 
                    match(input,ACTION,FOLLOW_ACTION_in_method_declaration402); 

                    		((method_declaration_scope)method_declaration_stack.peek()).types = new Vector<TypeDescriptor>();
                    	
                    match(input,ID,FOLLOW_ID_in_method_declaration409); 
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:263:5: (fp= formal_parameter )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==FPARAM) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:263:6: fp= formal_parameter
                    	    {
                    	    pushFollow(FOLLOW_formal_parameter_in_method_declaration414);
                    	    fp=formal_parameter();

                    	    state._fsp--;

                    	     ((method_declaration_scope)method_declaration_stack.peek()).types.add((fp).type); 

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:264:4: ( RETURNS assignment_declaration )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==RETURNS) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:264:5: RETURNS assignment_declaration
                            {
                            match(input,RETURNS,FOLLOW_RETURNS_in_method_declaration423); 
                            pushFollow(FOLLOW_assignment_declaration_in_method_declaration425);
                            assignment_declaration();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    }
                    break;
                case 4 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:265:4: ^( ON CREATE block[true] END )
                    {
                    match(input,ON,FOLLOW_ON_in_method_declaration434); 

                    match(input, Token.DOWN, null); 
                    match(input,CREATE,FOLLOW_CREATE_in_method_declaration436); 

                    		MethodDescriptor construct = symbol.enterConstructor();
                                    construct.setAccessModifier(AccessModifierEnum.PRIVATE);
                                    construct.flagMethodAsConstructor();
                    		builder.begin(construct);
                    	
                    pushFollow(FOLLOW_block_in_method_declaration443);
                    block(true);

                    state._fsp--;

                    END5=(CommonTree)match(input,END,FOLLOW_END_in_method_declaration446); 

                    		symbol.addStatementFlagToCurrentFile((END5!=null?END5.getLine():0));
                    		
                    		CompilerError error = symbol.getControlFlow().endMethod();
                    		if(error != null) {
                    			vm.getCompilerErrors().addError(error);
                    		}
                    		
                    		if(symbol.getControlFlow().needsReturnStep() && error == null) { //do this only for void types
                                    	LineInformation location = new LineInformation();
                    	                location.setStartColumn(END5.getCharPositionInLine());
                    	                location.setStartLine((END5!=null?END5.getLine():0));
                    	                location.setFile(getGrammarFileNameNoExtension());
                    	                location.setClassName(symbol.getCurrentClass().getStaticKey());
                    	                location.setMethodName(construct.getStaticKey());
                    	                
                    			stepFactory.addReturnStep(location, null, null);
                    		}
                    		
                    		builder.endMethod();
                    		//return scope to the class
                    		symbol.popScope();
                    		

                    	

                    match(input, Token.UP, null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            method_declaration_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "method_declaration"

    public static class qualified_name_return extends TreeRuleReturnScope {
        public QualifiedNameDescriptor type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "qualified_name"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:301:1: qualified_name returns [QualifiedNameDescriptor type] : ^( QUALIFIED_NAME ids+= ID ( PERIOD ids+= ID )* ) ;
    public final QuorumTreeWalker.qualified_name_return qualified_name() throws RecognitionException {
        QuorumTreeWalker.qualified_name_return retval = new QuorumTreeWalker.qualified_name_return();
        retval.start = input.LT(1);

        CommonTree PERIOD6=null;
        CommonTree ids=null;
        List list_ids=null;

        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:302:2: ( ^( QUALIFIED_NAME ids+= ID ( PERIOD ids+= ID )* ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:302:4: ^( QUALIFIED_NAME ids+= ID ( PERIOD ids+= ID )* )
            {
            match(input,QUALIFIED_NAME,FOLLOW_QUALIFIED_NAME_in_qualified_name469); 

            match(input, Token.DOWN, null); 
            ids=(CommonTree)match(input,ID,FOLLOW_ID_in_qualified_name474); 
            if (list_ids==null) list_ids=new ArrayList();
            list_ids.add(ids);

            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:302:30: ( PERIOD ids+= ID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==PERIOD) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:302:31: PERIOD ids+= ID
            	    {
            	    PERIOD6=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_qualified_name477); 
            	    ids=(CommonTree)match(input,ID,FOLLOW_ID_in_qualified_name481); 
            	    if (list_ids==null) list_ids=new ArrayList();
            	    list_ids.add(ids);


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            match(input, Token.UP, null); 

            		QualifiedNameDescriptor t = new QualifiedNameDescriptor();
            		t.setLineBegin(((CommonTree)list_ids.get(0)).token.getLine());
            		t.setColumnBegin(((CommonTree)list_ids.get(0)).token.getCharPositionInLine());
            		/*t.setNameFromList(list_ids);
            		*/
            		String name = "";
            		Iterator it = list_ids.iterator();

                    	while(it.hasNext()) {
                        		name += ((CommonTree) it.next()).getText();

                        		if(it.hasNext()) {
                            		name += (PERIOD6!=null?PERIOD6.getText():null);
                       		}

                        	}
                        	t.setName(name);



            		t.setLineEnd(((CommonTree)list_ids.get(list_ids.size() - 1)).token.getLine());
            		t.setColumnEnd(((CommonTree)list_ids.get(list_ids.size() - 1)).token.getCharPositionInLine());
            		retval.type = t;
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "qualified_name"

    public static class block_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "block"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:330:1: block[boolean bool] : ^( STATEMENT_LIST ( statement )* ) ;
    public final QuorumTreeWalker.block_return block(boolean bool) throws RecognitionException {
        QuorumTreeWalker.block_return retval = new QuorumTreeWalker.block_return();
        retval.start = input.LT(1);

        CommonTree STATEMENT_LIST7=null;

        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:330:22: ( ^( STATEMENT_LIST ( statement )* ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:330:24: ^( STATEMENT_LIST ( statement )* )
            {
            STATEMENT_LIST7=(CommonTree)match(input,STATEMENT_LIST,FOLLOW_STATEMENT_LIST_in_block500); 


            		if(bool) {
            			//add scope change step for runtime scoping
            			LineInformation location = new LineInformation();
            	                location.setStartColumn(STATEMENT_LIST7.getCharPositionInLine());
            	                location.setStartLine((STATEMENT_LIST7!=null?STATEMENT_LIST7.getLine():0));
            	                location.setFile(getGrammarFileNameNoExtension());
            		}

            	

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:341:3: ( statement )*
                loop26:
                do {
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==ALERT||LA26_0==BOOLEAN_KEYWORD||LA26_0==CHECK||LA26_0==CONSTANT||(LA26_0>=ID && LA26_0<=IF)||LA26_0==INTEGER_KEYWORD||LA26_0==ME||LA26_0==NUMBER_KEYWORD||LA26_0==OUTPUT||LA26_0==PARENT||(LA26_0>=PRIVATE && LA26_0<=QUALIFIED_NAME)||(LA26_0>=REPEAT && LA26_0<=RETURN)||(LA26_0>=SAY && LA26_0<=SOLO_FUNCTION_CALL_THIS)||LA26_0==TEXT) ) {
                        alt26=1;
                    }


                    switch (alt26) {
                	case 1 :
                	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:341:3: statement
                	    {
                	    pushFollow(FOLLOW_statement_in_block507);
                	    statement();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop26;
                    }
                } while (true);


                		if(bool) {
                			//add scope change step for runtime scoping
                			LineInformation location2 = new LineInformation();
                	                location2.setStartColumn(STATEMENT_LIST7.getCharPositionInLine());
                	                location2.setStartLine((STATEMENT_LIST7!=null?STATEMENT_LIST7.getLine():0));
                	                location2.setFile(getGrammarFileNameNoExtension());
                		}
                	

                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class statement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:352:1: statement : ( solo_method_call | if_statement | assignment_statement | loop_statement | return_statement | print_statement | speak_statement | check_statement | alert_statement );
    public final QuorumTreeWalker.statement_return statement() throws RecognitionException {
        QuorumTreeWalker.statement_return retval = new QuorumTreeWalker.statement_return();
        retval.start = input.LT(1);

        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:352:10: ( solo_method_call | if_statement | assignment_statement | loop_statement | return_statement | print_statement | speak_statement | check_statement | alert_statement )
            int alt27=9;
            switch ( input.LA(1) ) {
            case SOLO_FUNCTION_CALL:
            case SOLO_FUNCTION_CALL_PARENT:
            case SOLO_FUNCTION_CALL_THIS:
                {
                alt27=1;
                }
                break;
            case IF:
                {
                alt27=2;
                }
                break;
            case BOOLEAN_KEYWORD:
            case CONSTANT:
            case ID:
            case INTEGER_KEYWORD:
            case ME:
            case NUMBER_KEYWORD:
            case PARENT:
            case PRIVATE:
            case PUBLIC:
            case QUALIFIED_NAME:
            case TEXT:
                {
                alt27=3;
                }
                break;
            case REPEAT:
                {
                alt27=4;
                }
                break;
            case RETURN:
                {
                alt27=5;
                }
                break;
            case OUTPUT:
                {
                alt27=6;
                }
                break;
            case SAY:
                {
                alt27=7;
                }
                break;
            case CHECK:
                {
                alt27=8;
                }
                break;
            case ALERT:
                {
                alt27=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:354:3: solo_method_call
                    {
                    pushFollow(FOLLOW_solo_method_call_in_statement524);
                    solo_method_call();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:355:4: if_statement
                    {
                    pushFollow(FOLLOW_if_statement_in_statement529);
                    if_statement();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:356:4: assignment_statement
                    {
                    pushFollow(FOLLOW_assignment_statement_in_statement534);
                    assignment_statement();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:357:4: loop_statement
                    {
                    pushFollow(FOLLOW_loop_statement_in_statement539);
                    loop_statement();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:358:4: return_statement
                    {
                    pushFollow(FOLLOW_return_statement_in_statement544);
                    return_statement();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:359:4: print_statement
                    {
                    pushFollow(FOLLOW_print_statement_in_statement549);
                    print_statement();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:360:4: speak_statement
                    {
                    pushFollow(FOLLOW_speak_statement_in_statement554);
                    speak_statement();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:361:4: check_statement
                    {
                    pushFollow(FOLLOW_check_statement_in_statement559);
                    check_statement();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:362:4: alert_statement
                    {
                    pushFollow(FOLLOW_alert_statement_in_statement564);
                    alert_statement();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class solo_method_call_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "solo_method_call"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:365:1: solo_method_call : ( ^( SOLO_FUNCTION_CALL qualified_name ( COLON ID )? LEFT_PAREN (e= expression ( COMMA e= expression )* )? RIGHT_PAREN ) | ^( SOLO_FUNCTION_CALL_PARENT PARENT COLON qualified_name COLON ID LEFT_PAREN (e= expression ( COMMA e= expression )* )? RIGHT_PAREN ) | ^( SOLO_FUNCTION_CALL_THIS ME COLON qualified_name ( COLON ID )? LEFT_PAREN (e= expression ( COMMA e= expression )* )? RIGHT_PAREN ) );
    public final QuorumTreeWalker.solo_method_call_return solo_method_call() throws RecognitionException {
        QuorumTreeWalker.solo_method_call_return retval = new QuorumTreeWalker.solo_method_call_return();
        retval.start = input.LT(1);

        CommonTree ID9=null;
        CommonTree ID11=null;
        CommonTree ID13=null;
        QuorumTreeWalker.expression_return e = null;

        QuorumTreeWalker.qualified_name_return qualified_name8 = null;

        QuorumTreeWalker.qualified_name_return qualified_name10 = null;

        QuorumTreeWalker.qualified_name_return qualified_name12 = null;



        	Vector<ExpressionValue> values = new Vector<ExpressionValue>();
        	Vector<ExecutionStep> steps = new Vector<ExecutionStep>();
        	Vector<Integer> registers = new Vector<Integer>();
        	Vector<String> types = new Vector<String>();
        	Vector<TypeDescriptor> argumentTypes = new Vector<TypeDescriptor>();
        	int startLocation = 0;

        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:374:2: ( ^( SOLO_FUNCTION_CALL qualified_name ( COLON ID )? LEFT_PAREN (e= expression ( COMMA e= expression )* )? RIGHT_PAREN ) | ^( SOLO_FUNCTION_CALL_PARENT PARENT COLON qualified_name COLON ID LEFT_PAREN (e= expression ( COMMA e= expression )* )? RIGHT_PAREN ) | ^( SOLO_FUNCTION_CALL_THIS ME COLON qualified_name ( COLON ID )? LEFT_PAREN (e= expression ( COMMA e= expression )* )? RIGHT_PAREN ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case SOLO_FUNCTION_CALL:
                {
                alt36=1;
                }
                break;
            case SOLO_FUNCTION_CALL_PARENT:
                {
                alt36=2;
                }
                break;
            case SOLO_FUNCTION_CALL_THIS:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:375:3: ^( SOLO_FUNCTION_CALL qualified_name ( COLON ID )? LEFT_PAREN (e= expression ( COMMA e= expression )* )? RIGHT_PAREN )
                    {
                    match(input,SOLO_FUNCTION_CALL,FOLLOW_SOLO_FUNCTION_CALL_in_solo_method_call584); 


                    			inCallStep = true;
                    			builder.addStepLabel(OpcodeType.ROOT_EXPRESSION, -1);
                    		

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_qualified_name_in_solo_method_call593);
                    qualified_name8=qualified_name();

                    state._fsp--;

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:380:18: ( COLON ID )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==COLON) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:380:19: COLON ID
                            {
                            match(input,COLON,FOLLOW_COLON_in_solo_method_call596); 
                            ID9=(CommonTree)match(input,ID,FOLLOW_ID_in_solo_method_call598); 

                            }
                            break;

                    }

                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_solo_method_call602); 
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:380:41: (e= expression ( COMMA e= expression )* )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==AND||LA30_0==BOOLEAN||LA30_0==CAST||LA30_0==DECIMAL||LA30_0==DIVIDE||LA30_0==EQUALITY||(LA30_0>=FUNCTION_CALL && LA30_0<=FUNCTION_CALL_THIS)||(LA30_0>=GREATER && LA30_0<=GREATER_EQUAL)||(LA30_0>=INHERITS && LA30_0<=INPUT)||LA30_0==INT||(LA30_0>=LESS && LA30_0<=MULTIPLY)||LA30_0==NOTEQUALS||LA30_0==NULL||LA30_0==OR||LA30_0==PAREN_WRAPPED_EXPRESSION||LA30_0==PLUS||(LA30_0>=QUALIFIED_SOLO_EXPRESSION && LA30_0<=QUALIFIED_SOLO_PARENT_EXPRESSON)||LA30_0==STRING||LA30_0==UNARY_NOT) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:381:3: e= expression ( COMMA e= expression )*
                            {

                            			if(builder.getCurrentMethod() != null)
                            			{
                            				startLocation = builder.getCurrentMethod().getSteps().size();
                            			}
                            		
                            pushFollow(FOLLOW_expression_in_solo_method_call616);
                            e=expression();

                            state._fsp--;


                            			if(builder.getCurrentMethod() != null && startLocation < builder.getCurrentMethod().getSteps().size() -1){
                            				builder.getCurrentMethod().getSteps().get(startLocation).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            				(e!=null?e.step:null).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            			}
                            			values.add((e!=null?e.eval:null));
                            			steps.add((e!=null?e.step:null));
                            			registers.add((e!=null?e.eval:null).getRegister());
                            			if((e!=null?e.eval:null).getType() != null)
                            				types.add((e!=null?e.eval:null).getType().getStaticKey());
                                            			argumentTypes.add((e!=null?e.eval:null).getType());
                                            			inCallStep = false;
                            		
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:401:3: ( COMMA e= expression )*
                            loop29:
                            do {
                                int alt29=2;
                                int LA29_0 = input.LA(1);

                                if ( (LA29_0==COMMA) ) {
                                    alt29=1;
                                }


                                switch (alt29) {
                            	case 1 :
                            	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:401:4: COMMA e= expression
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_solo_method_call626); 

                            	    			if(builder.getCurrentMethod() != null)
                            	    			{
                            	    				startLocation = builder.getCurrentMethod().getSteps().size();
                            	    			}
                            	    		
                            	    pushFollow(FOLLOW_expression_in_solo_method_call640);
                            	    e=expression();

                            	    state._fsp--;


                            	    			if(builder.getCurrentMethod() != null && startLocation != builder.getCurrentMethod().getSteps().size() -1){
                            	    				builder.getCurrentMethod().getSteps().get(startLocation).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            	    				(e!=null?e.step:null).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            	    			}
                            	    			values.add((e!=null?e.eval:null));
                            	    			steps.add((e!=null?e.step:null));
                            	    			registers.add((e!=null?e.eval:null).getRegister());
                            	    			if((e!=null?e.eval:null).getType() != null)
                            	    				types.add((e!=null?e.eval:null).getType().getStaticKey());
                            	                    			argumentTypes.add((e!=null?e.eval:null).getType());
                            	    		

                            	    }
                            	    break;

                            	default :
                            	    break loop29;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_solo_method_call654); 

                    match(input, Token.UP, null); 

                    			LineInformation location = new LineInformation();
                                    			location.setEndColumn((qualified_name8!=null?qualified_name8.type:null).getColumnEnd());
                                    			location.setEndLine((qualified_name8!=null?qualified_name8.type:null).getLineEnd());
                                    			location.setStartColumn((qualified_name8!=null?qualified_name8.type:null).getColumnBegin());
                                   	 		location.setStartLine((qualified_name8!=null?qualified_name8.type:null).getLineBegin());
                                    			location.setFile(symbol.getCurrentClass().getFile().getStaticKey());
                                    			location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    			location.setMethodName(symbol.getCurrentMethod().getStaticKey());
                                    
                                    
                                    			symbol.addStatementFlagToCurrentFile((qualified_name8!=null?qualified_name8.type:null).getLineBegin());
                                    			
                                    			indexer.append("<action line = \"");
                    			indexer.append((qualified_name8!=null?qualified_name8.type:null).getLineBegin());
                    			indexer.append("\" />");
                                    
                                    			String key = "";
                                    			String myMethodName = "";
                                    			if(ID9 == null) {
                                    				key = MethodDescriptor.generateKey((qualified_name8!=null?qualified_name8.type:null).getStaticKey(), types);
                                    				myMethodName = (qualified_name8!=null?qualified_name8.type:null).getStaticKey();
                    			}
                    			else {
                    				key = MethodDescriptor.generateKey((ID9!=null?ID9.getText():null), types);
                    				myMethodName = (ID9!=null?ID9.getText():null);
                    			}
                    			CallInfo info = new CallInfo();
                    			info.register = temp;
                    			info.location = location;
                    			info.argumentRegisters = registers;
                    			info.argumentSteps = steps;
                    			info.variable = (qualified_name8!=null?qualified_name8.type:null);
                    			info.argumentTypes = argumentTypes;
                    			info.methodName = myMethodName;
                    			info.isObjectCall = (ID9 != null);
                    			info.isSoloMethod = true;
                    		
                    			ResultTuple result =  stepFactory.addCallStep(info);
                    			builder.addStepLabel(OpcodeType.SOLO_METHOD_CALL, result.getStepCount());		
                    		
                    			temp = result.getNextRegister();
                    		

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:465:4: ^( SOLO_FUNCTION_CALL_PARENT PARENT COLON qualified_name COLON ID LEFT_PAREN (e= expression ( COMMA e= expression )* )? RIGHT_PAREN )
                    {
                    match(input,SOLO_FUNCTION_CALL_PARENT,FOLLOW_SOLO_FUNCTION_CALL_PARENT_in_solo_method_call666); 


                    		inCallStep = true;
                    		builder.addStepLabel(OpcodeType.ROOT_EXPRESSION, -1);
                    	

                    match(input, Token.DOWN, null); 
                    match(input,PARENT,FOLLOW_PARENT_in_solo_method_call673); 
                    match(input,COLON,FOLLOW_COLON_in_solo_method_call675); 
                    pushFollow(FOLLOW_qualified_name_in_solo_method_call677);
                    qualified_name10=qualified_name();

                    state._fsp--;

                    match(input,COLON,FOLLOW_COLON_in_solo_method_call679); 
                    ID11=(CommonTree)match(input,ID,FOLLOW_ID_in_solo_method_call681); 
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_solo_method_call683); 
                    if(builder.getCurrentMethod() != null){startLocation = builder.getCurrentMethod().getSteps().size();}
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:471:3: (e= expression ( COMMA e= expression )* )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==AND||LA32_0==BOOLEAN||LA32_0==CAST||LA32_0==DECIMAL||LA32_0==DIVIDE||LA32_0==EQUALITY||(LA32_0>=FUNCTION_CALL && LA32_0<=FUNCTION_CALL_THIS)||(LA32_0>=GREATER && LA32_0<=GREATER_EQUAL)||(LA32_0>=INHERITS && LA32_0<=INPUT)||LA32_0==INT||(LA32_0>=LESS && LA32_0<=MULTIPLY)||LA32_0==NOTEQUALS||LA32_0==NULL||LA32_0==OR||LA32_0==PAREN_WRAPPED_EXPRESSION||LA32_0==PLUS||(LA32_0>=QUALIFIED_SOLO_EXPRESSION && LA32_0<=QUALIFIED_SOLO_PARENT_EXPRESSON)||LA32_0==STRING||LA32_0==UNARY_NOT) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:471:4: e= expression ( COMMA e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_solo_method_call694);
                            e=expression();

                            state._fsp--;


                            			if(builder.getCurrentMethod() != null && startLocation != builder.getCurrentMethod().getSteps().size() -1){
                            				builder.getCurrentMethod().getSteps().get(startLocation).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            				(e!=null?e.step:null).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            			}
                            			values.add((e!=null?e.eval:null));
                            			steps.add((e!=null?e.step:null));
                            			registers.add((e!=null?e.eval:null).getRegister());
                            			types.add((e!=null?e.eval:null).getType().getStaticKey());
                                            			argumentTypes.add((e!=null?e.eval:null).getType());
                                            			inCallStep = false;
                            		
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:484:3: ( COMMA e= expression )*
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==COMMA) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:484:4: COMMA e= expression
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_solo_method_call704); 

                            	    			if(builder.getCurrentMethod() != null)
                            	    			{
                            	    				startLocation = builder.getCurrentMethod().getSteps().size();
                            	    			}
                            	    		
                            	    pushFollow(FOLLOW_expression_in_solo_method_call717);
                            	    e=expression();

                            	    state._fsp--;


                            	    			if(builder.getCurrentMethod() != null && startLocation != builder.getCurrentMethod().getSteps().size() -1){
                            	    				builder.getCurrentMethod().getSteps().get(startLocation).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            	    				(e!=null?e.step:null).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            	    			}
                            	    			values.add((e!=null?e.eval:null));
                            	    			steps.add((e!=null?e.step:null));
                            	    			registers.add((e!=null?e.eval:null).getRegister());
                            	    			types.add((e!=null?e.eval:null).getType().getStaticKey());
                            	                    			argumentTypes.add((e!=null?e.eval:null).getType());
                            	    		

                            	    }
                            	    break;

                            	default :
                            	    break loop31;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_solo_method_call727); 

                    match(input, Token.UP, null); 

                    			LineInformation location = new LineInformation();
                                    			location.setEndColumn((qualified_name10!=null?qualified_name10.type:null).getColumnEnd());
                                    			location.setEndLine((qualified_name10!=null?qualified_name10.type:null).getLineEnd());
                                   	 		location.setStartColumn((qualified_name10!=null?qualified_name10.type:null).getColumnBegin());
                                    			location.setStartLine((qualified_name10!=null?qualified_name10.type:null).getLineBegin());
                                    			location.setFile(symbol.getCurrentClass().getFile().getStaticKey());
                                    			location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    			location.setMethodName(symbol.getCurrentMethod().getStaticKey());
                                    
                                    			symbol.addStatementFlagToCurrentFile((qualified_name10!=null?qualified_name10.type:null).getLineBegin());
                                    			
                                    			indexer.append("<action line = \"");
                    			indexer.append((qualified_name10!=null?qualified_name10.type:null).getLineBegin());
                    			indexer.append("\" />");
                                    
                                    			String key = "";
                                    			String myMethodName = "";
                                    			if(ID11 == null) {
                                    				key = MethodDescriptor.generateKey((qualified_name10!=null?qualified_name10.type:null).getStaticKey(), types);
                                    				myMethodName = (qualified_name10!=null?qualified_name10.type:null).getStaticKey();
                    			}
                    			else {
                    				key = MethodDescriptor.generateKey((ID11!=null?ID11.getText():null), types);
                    				myMethodName = (ID11!=null?ID11.getText():null);
                    			}
                    			CallInfo info = new CallInfo();
                    			info.register = temp;
                    			info.location = location;
                    			info.argumentRegisters = registers;
                    			info.argumentSteps = steps;
                    			info.variable = (qualified_name10!=null?qualified_name10.type:null);
                    			info.locatedIn = (qualified_name10!=null?qualified_name10.type:null).getStaticKey();
                    			info.argumentTypes = argumentTypes;
                    			info.methodName = myMethodName;
                    			info.isObjectCall = (ID11 != null);
                    			info.isSoloMethod = true;
                    		
                    			ResultTuple result =  stepFactory.addParentCallStep(info);
                    			builder.addStepLabel(OpcodeType.SOLO_METHOD_CALL, result.getStepCount());
                    		
                    			temp = result.getNextRegister();
                    			inCallStep = false;
                    		

                    }
                    break;
                case 3 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:547:4: ^( SOLO_FUNCTION_CALL_THIS ME COLON qualified_name ( COLON ID )? LEFT_PAREN (e= expression ( COMMA e= expression )* )? RIGHT_PAREN )
                    {
                    match(input,SOLO_FUNCTION_CALL_THIS,FOLLOW_SOLO_FUNCTION_CALL_THIS_in_solo_method_call738); 


                    		inCallStep = true;
                    		builder.addStepLabel(OpcodeType.ROOT_EXPRESSION, -1);
                    	

                    match(input, Token.DOWN, null); 
                    match(input,ME,FOLLOW_ME_in_solo_method_call745); 
                    match(input,COLON,FOLLOW_COLON_in_solo_method_call747); 
                    pushFollow(FOLLOW_qualified_name_in_solo_method_call749);
                    qualified_name12=qualified_name();

                    state._fsp--;

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:552:26: ( COLON ID )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==COLON) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:552:27: COLON ID
                            {
                            match(input,COLON,FOLLOW_COLON_in_solo_method_call752); 
                            ID13=(CommonTree)match(input,ID,FOLLOW_ID_in_solo_method_call754); 

                            }
                            break;

                    }

                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_solo_method_call758); 

                    		if(builder.getCurrentMethod() != null)
                    		{
                    			startLocation = builder.getCurrentMethod().getSteps().size();
                    		}
                    	
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:559:3: (e= expression ( COMMA e= expression )* )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==AND||LA35_0==BOOLEAN||LA35_0==CAST||LA35_0==DECIMAL||LA35_0==DIVIDE||LA35_0==EQUALITY||(LA35_0>=FUNCTION_CALL && LA35_0<=FUNCTION_CALL_THIS)||(LA35_0>=GREATER && LA35_0<=GREATER_EQUAL)||(LA35_0>=INHERITS && LA35_0<=INPUT)||LA35_0==INT||(LA35_0>=LESS && LA35_0<=MULTIPLY)||LA35_0==NOTEQUALS||LA35_0==NULL||LA35_0==OR||LA35_0==PAREN_WRAPPED_EXPRESSION||LA35_0==PLUS||(LA35_0>=QUALIFIED_SOLO_EXPRESSION && LA35_0<=QUALIFIED_SOLO_PARENT_EXPRESSON)||LA35_0==STRING||LA35_0==UNARY_NOT) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:559:4: e= expression ( COMMA e= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_solo_method_call771);
                            e=expression();

                            state._fsp--;


                            			if(builder.getCurrentMethod() != null && startLocation != builder.getCurrentMethod().getSteps().size() -1){
                            				builder.getCurrentMethod().getSteps().get(startLocation).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            				(e!=null?e.step:null).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            			}
                            			values.add((e!=null?e.eval:null));
                            			steps.add((e!=null?e.step:null));
                            			registers.add((e!=null?e.eval:null).getRegister());
                            			types.add((e!=null?e.eval:null).getType().getStaticKey());
                                            			argumentTypes.add((e!=null?e.eval:null).getType());
                                            			inCallStep = false;
                            		
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:571:4: ( COMMA e= expression )*
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==COMMA) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:571:5: COMMA e= expression
                            	    {
                            	    match(input,COMMA,FOLLOW_COMMA_in_solo_method_call778); 

                            	    			if(builder.getCurrentMethod() != null)
                            	    			{
                            	    				startLocation = builder.getCurrentMethod().getSteps().size();
                            	    			}
                            	    		
                            	    pushFollow(FOLLOW_expression_in_solo_method_call791);
                            	    e=expression();

                            	    state._fsp--;


                            	    			if(builder.getCurrentMethod() != null && startLocation != builder.getCurrentMethod().getSteps().size() -1){
                            	    				builder.getCurrentMethod().getSteps().get(startLocation).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            	    				(e!=null?e.step:null).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                            	    			}
                            	    			values.add((e!=null?e.eval:null));
                            	    			steps.add((e!=null?e.step:null));
                            	    			registers.add((e!=null?e.eval:null).getRegister());
                            	    			types.add((e!=null?e.eval:null).getType().getStaticKey());
                            	                    			argumentTypes.add((e!=null?e.eval:null).getType());
                            	    		

                            	    }
                            	    break;

                            	default :
                            	    break loop34;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_solo_method_call804); 

                    match(input, Token.UP, null); 

                    			LineInformation location = new LineInformation();
                    	                		location.setEndColumn((qualified_name12!=null?qualified_name12.type:null).getColumnEnd());
                    	                		location.setEndLine((qualified_name12!=null?qualified_name12.type:null).getLineEnd());
                    	                		location.setStartColumn((qualified_name12!=null?qualified_name12.type:null).getColumnBegin());
                    	                		location.setStartLine((qualified_name12!=null?qualified_name12.type:null).getLineBegin());
                    	                		location.setFile(symbol.getCurrentClass().getFile().getStaticKey());
                    	                		location.setClassName(symbol.getCurrentClass().getStaticKey());
                    	                		location.setMethodName(symbol.getCurrentMethod().getStaticKey());
                    	                
                    	                		symbol.addStatementFlagToCurrentFile((qualified_name12!=null?qualified_name12.type:null).getLineBegin());
                    	                
                    	               		indexer.append("<action line = \"");
                    			indexer.append((qualified_name12!=null?qualified_name12.type:null).getLineBegin());
                    			indexer.append("\" />");
                    			
                    	                		String key = "";
                    	                		String myMethodName = "";
                    	                		if(ID13 == null) {
                    	                			key = MethodDescriptor.generateKey((qualified_name12!=null?qualified_name12.type:null).getStaticKey(), types);
                    	                			myMethodName = (qualified_name12!=null?qualified_name12.type:null).getStaticKey();
                    			}
                    			else {
                    				key = MethodDescriptor.generateKey((ID13!=null?ID13.getText():null), types);
                    				myMethodName = (ID13!=null?ID13.getText():null);
                    			}
                    			CallInfo info = new CallInfo();
                    			info.register = temp;
                    			info.location = location;
                    			info.argumentRegisters = registers;
                    			info.argumentSteps = steps;
                    			info.variable = (qualified_name12!=null?qualified_name12.type:null);
                    			info.argumentTypes = argumentTypes;
                    			info.methodName = myMethodName;
                    			info.isObjectCall = (ID13 != null);
                    			info.isSoloMethod = true;
                    			
                    			ResultTuple result =  stepFactory.addCallStep(info);
                    			builder.addStepLabel(OpcodeType.SOLO_METHOD_CALL, result.getStepCount());
                    			temp = result.getNextRegister();
                    		

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "solo_method_call"

    protected static class alert_statement_scope {
        ErrorTypeDescriptor errorType;
        ExpressionValue errorValue;
        ExecutionStep errorStep;
    }
    protected Stack alert_statement_stack = new Stack();

    public static class alert_statement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "alert_statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:633:1: alert_statement : ^( ALERT LEFT_PAREN ex= root_expression RIGHT_PAREN ) ;
    public final QuorumTreeWalker.alert_statement_return alert_statement() throws RecognitionException {
        alert_statement_stack.push(new alert_statement_scope());
        QuorumTreeWalker.alert_statement_return retval = new QuorumTreeWalker.alert_statement_return();
        retval.start = input.LT(1);

        CommonTree LEFT_PAREN14=null;
        QuorumTreeWalker.root_expression_return ex = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:639:2: ( ^( ALERT LEFT_PAREN ex= root_expression RIGHT_PAREN ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:639:4: ^( ALERT LEFT_PAREN ex= root_expression RIGHT_PAREN )
            {
            match(input,ALERT,FOLLOW_ALERT_in_alert_statement824); 


            		((alert_statement_scope)alert_statement_stack.peek()).errorValue = new ExpressionValue();
            		((alert_statement_scope)alert_statement_stack.peek()).errorStep = null;
            	

            match(input, Token.DOWN, null); 
            LEFT_PAREN14=(CommonTree)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_alert_statement832); 
            pushFollow(FOLLOW_root_expression_in_alert_statement836);
            ex=root_expression();

            state._fsp--;


            		ErrorTypeDescriptor t = new ErrorTypeDescriptor();

            		if(!(ex!=null?ex.eval:null).getType().getName().equals(TypeDescriptor.TEXT)){
            			
            			ClassDescriptor cd = symbol.findFullyQualifiedClass((ex!=null?ex.eval:null).getType().getName());
            			
            			if(cd == null)
            				cd = symbol.findClass((ex!=null?ex.eval:null).getType().getName(), "Libraries.Language.Errors");
            			
            			if(cd.getStaticKey().equals(ErrorTypeDescriptor.ERROR) || cd.getParent(ErrorTypeDescriptor.ERROR) != null){
            		        	t.setName(cd.getStaticKey());
            		        	t.setType(cd.getType());
            		        }else{
            		                CompilerError error = new CompilerError();
            		          	error.setLineNumber(cd.getLineBegin());
            		          	error.setError("Class " + cd.getStaticKey() + " is not an error type." +
            		          				cd.getStaticKey() + " must inherit from class Error to be an error type");
            		          	error.setColumn(LEFT_PAREN14.getCharPositionInLine());
            		          	error.setErrorType(ErrorType.INVALID_ERROR);
            		          	error.setFile(getGrammarFileNameNoExtension());
            		          	vm.getCompilerErrors().addError(error);
            		        }
            	        }else{
            	        	t = null;
            	        }

            		((alert_statement_scope)alert_statement_stack.peek()).errorValue = (ex!=null?ex.eval:null);
            		((alert_statement_scope)alert_statement_stack.peek()).errorStep = (ex!=null?ex.step:null);
            		((alert_statement_scope)alert_statement_stack.peek()).errorType = t;
            	
            match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_alert_statement844); 

            		LineInformation location = new LineInformation();
                            
            		location.setEndColumn(((alert_statement_scope)alert_statement_stack.peek()).errorStep.getEndColumn());
                            		location.setEndLine(((alert_statement_scope)alert_statement_stack.peek()).errorStep.getEndLine());
                            		location.setStartColumn(((alert_statement_scope)alert_statement_stack.peek()).errorStep.getBeginColumn());
                            		location.setStartLine(((alert_statement_scope)alert_statement_stack.peek()).errorStep.getBeginLine());
                            		location.setFile(symbol.getCurrentClass().getFile().getStaticKey());
                            		location.setClassName(symbol.getCurrentClass().getStaticKey());
                            		location.setMethodName(symbol.getCurrentMethod().getStaticKey());
                            
                            
            		stepFactory.addAlertStep(location, ((alert_statement_scope)alert_statement_stack.peek()).errorType, ((alert_statement_scope)alert_statement_stack.peek()).errorValue, ((alert_statement_scope)alert_statement_stack.peek()).errorStep);
            		builder.addStepLabel(OpcodeType.ALERT, -1);
            		symbol.addStatementFlagToCurrentFile(location.getStartLine());
            		
            		indexer.append("<alert line = \"");
            		indexer.append(location.getStartLine());
            		indexer.append("\" />");
            		
            	

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            alert_statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "alert_statement"

    protected static class check_statement_scope {
        ExceptionInfo info;
        int detect_counter;
        int tempLabelCounter;
        boolean has_always;
        LineInformation location;
        String startSymbol;
        JumpStep detectJump;
    }
    protected Stack check_statement_stack = new Stack();

    public static class check_statement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "check_statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:702:1: check_statement : check= CHECK block[true] ( (detect_start= DETECT det_param= detect_parameter block[true] )+ (always= ALWAYS block[true] )? | always= ALWAYS block[true] ) end= END ;
    public final QuorumTreeWalker.check_statement_return check_statement() throws RecognitionException {
        check_statement_stack.push(new check_statement_scope());
        QuorumTreeWalker.check_statement_return retval = new QuorumTreeWalker.check_statement_return();
        retval.start = input.LT(1);

        CommonTree check=null;
        CommonTree detect_start=null;
        CommonTree always=null;
        CommonTree end=null;
        QuorumTreeWalker.detect_parameter_return det_param = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:712:2: (check= CHECK block[true] ( (detect_start= DETECT det_param= detect_parameter block[true] )+ (always= ALWAYS block[true] )? | always= ALWAYS block[true] ) end= END )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:713:2: check= CHECK block[true] ( (detect_start= DETECT det_param= detect_parameter block[true] )+ (always= ALWAYS block[true] )? | always= ALWAYS block[true] ) end= END
            {
            	
            		((check_statement_scope)check_statement_stack.peek()).detectJump = new JumpStep();
            		((check_statement_scope)check_statement_stack.peek()).info = new ExceptionInfo();
            		((check_statement_scope)check_statement_stack.peek()).detect_counter = 0;
            		((check_statement_scope)check_statement_stack.peek()).has_always = false;
            		
            		sub_counter++;
            		if(sub_counter > 1){labelCounter++;}
            		((check_statement_scope)check_statement_stack.peek()).tempLabelCounter = labelCounter;
            		((check_statement_scope)check_statement_stack.peek()).info.alwaysStartLabel = builder.getCurrentClass().getStaticKey() + "_" + ((check_statement_scope)check_statement_stack.peek()).info.ALWAYS + ((check_statement_scope)check_statement_stack.peek()).tempLabelCounter + ((check_statement_scope)check_statement_stack.peek()).info.START;
            	
            check=(CommonTree)match(input,CHECK,FOLLOW_CHECK_in_check_statement876); 

            		((check_statement_scope)check_statement_stack.peek()).info.checkLocation = new LineInformation(
            			check.getLine(),
            			check.getLine(),
            			check.getCharPositionInLine(),
            			(check!=null?check.getText():null).length() + check.getCharPositionInLine());
            		((check_statement_scope)check_statement_stack.peek()).info.checkStartLabel = builder.getCurrentClass().getStaticKey() + "_" + (check!=null?check.getText():null) + ((check_statement_scope)check_statement_stack.peek()).tempLabelCounter + ((check_statement_scope)check_statement_stack.peek()).info.START;
            		stepFactory.startCheck(((check_statement_scope)check_statement_stack.peek()).info);
            		((check_statement_scope)check_statement_stack.peek()).startSymbol = "check";
            	
            pushFollow(FOLLOW_block_in_check_statement882);
            block(true);

            state._fsp--;


            		((check_statement_scope)check_statement_stack.peek()).info.checkJump.setBeginColumn(check.getCharPositionInLine());
            		((check_statement_scope)check_statement_stack.peek()).info.checkJump.setEndColumn(check.getCharPositionInLine() + ((check!=null?check.getText():null).length()));
                            ((check_statement_scope)check_statement_stack.peek()).info.checkJump.setEndLine(check.getLine());
            		stepFactory.addCheckEndJumpStep(((check_statement_scope)check_statement_stack.peek()).info);
            	
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:741:2: ( (detect_start= DETECT det_param= detect_parameter block[true] )+ (always= ALWAYS block[true] )? | always= ALWAYS block[true] )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==DETECT) ) {
                alt39=1;
            }
            else if ( (LA39_0==ALWAYS) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:742:7: (detect_start= DETECT det_param= detect_parameter block[true] )+ (always= ALWAYS block[true] )?
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:742:7: (detect_start= DETECT det_param= detect_parameter block[true] )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==DETECT) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:742:8: detect_start= DETECT det_param= detect_parameter block[true]
                    	    {
                    	    detect_start=(CommonTree)match(input,DETECT,FOLLOW_DETECT_in_check_statement904); 

                    	    	    		((check_statement_scope)check_statement_stack.peek()).info.detectLocations.add(new LineInformation(
                    	    				detect_start.getLine(),
                    	    				detect_start.getLine(),
                    	    				detect_start.getCharPositionInLine(),
                    	    				(detect_start!=null?detect_start.getText():null).length() + detect_start.getCharPositionInLine()));
                    	    	    		if(((check_statement_scope)check_statement_stack.peek()).startSymbol.equals("check")){
                    	    		    		((check_statement_scope)check_statement_stack.peek()).info.checkJump.setBeginLine(detect_start.getLine());
                    	    				stepFactory.endCheck(((check_statement_scope)check_statement_stack.peek()).info);
                    	    				
                    	    				indexer.append("<check line = \"");
                    	    				indexer.append(((check_statement_scope)check_statement_stack.peek()).info.checkLocation.getStartLine());
                    	    				indexer.append("\" end = \"");
                    	    				indexer.append(detect_start.getLine());
                    	    				indexer.append("\"/>");
                    	    			}else{
                    	    				((check_statement_scope)check_statement_stack.peek()).detectJump.setBeginLine(detect_start.getLine());
                    	    		    		stepFactory.endDetect(((check_statement_scope)check_statement_stack.peek()).info, ((check_statement_scope)check_statement_stack.peek()).detect_counter);
                    	    		    		((check_statement_scope)check_statement_stack.peek()).detect_counter = ((check_statement_scope)check_statement_stack.peek()).detect_counter + 1;
                    	    		    		
                    	    		    		indexer.append("<detect line = \"");
                    	    				indexer.append(((check_statement_scope)check_statement_stack.peek()).info.detectLocations.get(((check_statement_scope)check_statement_stack.peek()).info.detectLocations.size() - 1).getStartLine());
                    	    				indexer.append("\" end = \"");
                    	    				indexer.append(detect_start.getLine());
                    	    				indexer.append("\" type = \"");
                    	    				indexer.append(((check_statement_scope)check_statement_stack.peek()).info.detectParameters.get(((check_statement_scope)check_statement_stack.peek()).info.detectParameters.size() - 1).getType().getName());
                    	    				indexer.append("\"/>");
                    	    			}
                    	    	    		
                    	    	    		((check_statement_scope)check_statement_stack.peek()).info.addDetectLabel((detect_start!=null?detect_start.getText():null) + ((check_statement_scope)check_statement_stack.peek()).detect_counter
                    	    	    			 + "_" + ((check_statement_scope)check_statement_stack.peek()).tempLabelCounter + ((check_statement_scope)check_statement_stack.peek()).info.START);
                    	    	    			 symbol.addStatementFlagToCurrentFile(detect_start.getLine());
                    	    	    		symbol.getControlFlow().detectStart();
                    	    	    		symbol.enterNextBlock();
                    	    	    		((check_statement_scope)check_statement_stack.peek()).startSymbol = "detect";
                    	    	    		
                    	    	    	
                    	    pushFollow(FOLLOW_detect_parameter_in_check_statement931);
                    	    det_param=detect_parameter();

                    	    state._fsp--;


                    	    	    		Iterator<ErrorTypeDescriptor> detectParamIt = det_param.exceptionTypeList.iterator();
                    	    	    		StringBuffer types = new StringBuffer();
                    	    	    		while(detectParamIt.hasNext()){
                    	    		    		VariableParameterCommonDescriptor d = new VariableParameterCommonDescriptor();
                    	    		    		DetectParameter er = new DetectParameter();
                    	    		    		TypeDescriptor t = new TypeDescriptor();
                    	    		    		
                    	    		    		d = symbol.getVariable((det_param!=null?det_param.name:null));
                    	    		    		er.setIsCaughtException(true);
                    	    		    		er.setVariableNumber(d.getVariableNumber());
                    	    		    		er.errorType = detectParamIt.next();
                    	    		    		t.setName(er.errorType.getName());
                    	    		    		er.setType(t);
                    	    		    		er.setName((det_param!=null?det_param.name:null));
                    	    		    		boolean result = ((check_statement_scope)check_statement_stack.peek()).info.addDetectParameter(er);
                    	    		    		if(!result){
                    	    		    			CompilerError error = new CompilerError();
                    	    		            			error.setLineNumber(detect_start.getLine());
                    	    		            			error.setError("The " + er.errorType.getStaticKey() + " has already been detected." );
                    	    		            			error.setErrorType(ErrorType.UNREACHABLE);
                    	    		            			error.setColumn(detect_start.getCharPositionInLine());
                    	    		            			error.setFile(getGrammarFileNameNoExtension());
                    	    		            			vm.getCompilerErrors().addError(error);
                    	    		    		}
                    	    		    		types.append(t.getName());
                    	    	    		}
                    	    	    		stepFactory.startDetect(((check_statement_scope)check_statement_stack.peek()).info, ((check_statement_scope)check_statement_stack.peek()).detect_counter);
                    	    	    	
                    	    pushFollow(FOLLOW_block_in_check_statement955);
                    	    block(true);

                    	    state._fsp--;


                    	    	    		((check_statement_scope)check_statement_stack.peek()).detectJump = new JumpStep();
                    	    	    		((check_statement_scope)check_statement_stack.peek()).detectJump.setType(JumpType.CHECK);
                    	    		    	((check_statement_scope)check_statement_stack.peek()).detectJump.setBeginColumn(detect_start.getCharPositionInLine());
                    	    			((check_statement_scope)check_statement_stack.peek()).detectJump.setEndColumn(detect_start.getCharPositionInLine() + ((detect_start!=null?detect_start.getText():null).length()));
                    	    	                ((check_statement_scope)check_statement_stack.peek()).detectJump.setEndLine(detect_start.getLine());
                    	    	                ((check_statement_scope)check_statement_stack.peek()).info.detectJumps.add(((check_statement_scope)check_statement_stack.peek()).detectJump);
                    	    			stepFactory.addDetectEndJumpStep(((check_statement_scope)check_statement_stack.peek()).info, ((check_statement_scope)check_statement_stack.peek()).detectJump);
                    	    	    	

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:823:7: (always= ALWAYS block[true] )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==ALWAYS) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:823:8: always= ALWAYS block[true]
                            {
                            always=(CommonTree)match(input,ALWAYS,FOLLOW_ALWAYS_in_check_statement988); 

                            		    	((check_statement_scope)check_statement_stack.peek()).info.alwaysLocation = new LineInformation(
                            				always.getLine(),
                            				always.getLine(),
                            				always.getCharPositionInLine(),
                            				(always!=null?always.getText():null).length() + always.getCharPositionInLine());
                            	    		((check_statement_scope)check_statement_stack.peek()).detectJump.setBeginLine(always.getLine());
                            	    		stepFactory.endDetect(((check_statement_scope)check_statement_stack.peek()).info, ((check_statement_scope)check_statement_stack.peek()).detect_counter);
                            	    		((check_statement_scope)check_statement_stack.peek()).detect_counter = ((check_statement_scope)check_statement_stack.peek()).detect_counter + 1;
                            	    		
                            	    		((check_statement_scope)check_statement_stack.peek()).has_always = true;
                            	    		((check_statement_scope)check_statement_stack.peek()).info.hasAlways = true;
                            	    		stepFactory.startAlways(((check_statement_scope)check_statement_stack.peek()).info, true);
                            	    		((check_statement_scope)check_statement_stack.peek()).startSymbol = "always";
                            	    		
                            	    		indexer.append("<detect line = \"");
                            			indexer.append(((check_statement_scope)check_statement_stack.peek()).info.detectLocations.get(((check_statement_scope)check_statement_stack.peek()).info.detectLocations.size() - 1).getStartLine());
                            			indexer.append("\" end = \"");
                            			indexer.append(detect_start.getLine());
                            			indexer.append("\" type = \"");
                            			indexer.append(((check_statement_scope)check_statement_stack.peek()).info.detectParameters.get(((check_statement_scope)check_statement_stack.peek()).info.detectParameters.size() - 1).getType().getName());
                            			indexer.append("\"/>");
                            	    	
                            pushFollow(FOLLOW_block_in_check_statement1004);
                            block(true);

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:851:7: always= ALWAYS block[true]
                    {
                    always=(CommonTree)match(input,ALWAYS,FOLLOW_ALWAYS_in_check_statement1036); 

                    	    		((check_statement_scope)check_statement_stack.peek()).info.alwaysLocation = new LineInformation(
                    				always.getLine(),
                    				always.getLine(),
                    				always.getCharPositionInLine(),
                    				(always!=null?always.getText():null).length() + always.getCharPositionInLine());
                    		    	((check_statement_scope)check_statement_stack.peek()).info.checkJump.setBeginLine(always.getLine());
                    			stepFactory.endCheck(((check_statement_scope)check_statement_stack.peek()).info);
                    			
                    	    		((check_statement_scope)check_statement_stack.peek()).has_always = true;
                    	    		((check_statement_scope)check_statement_stack.peek()).info.hasAlways = true;
                    	    		stepFactory.startAlways(((check_statement_scope)check_statement_stack.peek()).info, true);
                    	    		((check_statement_scope)check_statement_stack.peek()).startSymbol = "always";
                    	    		
                    	    		indexer.append("<check line = \"");
                    			indexer.append(((check_statement_scope)check_statement_stack.peek()).info.checkLocation.getStartLine());
                    			indexer.append("\" end = \"");
                    			indexer.append(detect_start.getLine());
                    			indexer.append("\"/>");
                    	    	
                    pushFollow(FOLLOW_block_in_check_statement1059);
                    block(true);

                    state._fsp--;


                    }
                    break;

            }

            end=(CommonTree)match(input,END,FOLLOW_END_in_check_statement1068); 

                		if(((check_statement_scope)check_statement_stack.peek()).startSymbol.equals("always")){
            	    		stepFactory.endAlways(((check_statement_scope)check_statement_stack.peek()).info);
            	    		
            	    		indexer.append("<always line = \"");
            			indexer.append(((check_statement_scope)check_statement_stack.peek()).info.alwaysLocation.getStartLine());
            			indexer.append("\" end = \"");
            			indexer.append(detect_start.getLine());
            			indexer.append("\"/>");
            		}else{
            			((check_statement_scope)check_statement_stack.peek()).detectJump.setBeginLine(end.getLine());
            	    		stepFactory.endDetect(((check_statement_scope)check_statement_stack.peek()).info, ((check_statement_scope)check_statement_stack.peek()).detect_counter);
            	    		((check_statement_scope)check_statement_stack.peek()).detect_counter = ((check_statement_scope)check_statement_stack.peek()).detect_counter + 1;
            	    		
            	    		if (((check_statement_scope)check_statement_stack.peek()).has_always == false) {
            	    			((check_statement_scope)check_statement_stack.peek()).info.hasAlways = false;
            	    			stepFactory.startAlways(((check_statement_scope)check_statement_stack.peek()).info, false);
            	    			stepFactory.endAlways(((check_statement_scope)check_statement_stack.peek()).info);
                			}
                			
                			indexer.append("<detect line = \"");
            			indexer.append(((check_statement_scope)check_statement_stack.peek()).info.detectLocations.get(((check_statement_scope)check_statement_stack.peek()).info.detectLocations.size() - 1).getStartLine());
            			indexer.append("\" end = \"");
            			indexer.append(detect_start.getLine());
            			indexer.append("\" type = \"");
            			indexer.append(((check_statement_scope)check_statement_stack.peek()).info.detectParameters.get(((check_statement_scope)check_statement_stack.peek()).info.detectParameters.size() - 1).getType().getName());
            			indexer.append("\"/>");
            		}

            		sub_counter--;
            		((check_statement_scope)check_statement_stack.peek()).tempLabelCounter--;
            		if(sub_counter == 0){labelCounter++;}
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            check_statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "check_statement"

    protected static class detect_parameter_scope {
        ArrayList<ErrorTypeDescriptor> exceptionList;
    }
    protected Stack detect_parameter_stack = new Stack();

    public static class detect_parameter_return extends TreeRuleReturnScope {
        public String name;
        public ArrayList<ErrorTypeDescriptor> exceptionTypeList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "detect_parameter"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:911:1: detect_parameter returns [String name, ArrayList<ErrorTypeDescriptor> exceptionTypeList] : ^(id= ID ( INHERITS qn= qualified_name ( OR qn= qualified_name )* )? ) ;
    public final QuorumTreeWalker.detect_parameter_return detect_parameter() throws RecognitionException {
        detect_parameter_stack.push(new detect_parameter_scope());
        QuorumTreeWalker.detect_parameter_return retval = new QuorumTreeWalker.detect_parameter_return();
        retval.start = input.LT(1);

        CommonTree id=null;
        QuorumTreeWalker.qualified_name_return qn = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:915:2: ( ^(id= ID ( INHERITS qn= qualified_name ( OR qn= qualified_name )* )? ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:915:4: ^(id= ID ( INHERITS qn= qualified_name ( OR qn= qualified_name )* )? )
            {
            id=(CommonTree)match(input,ID,FOLLOW_ID_in_detect_parameter1097); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:916:2: ( INHERITS qn= qualified_name ( OR qn= qualified_name )* )?
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==INHERITS) ) {
                    alt41=1;
                }
                switch (alt41) {
                    case 1 :
                        // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:916:3: INHERITS qn= qualified_name ( OR qn= qualified_name )*
                        {
                        match(input,INHERITS,FOLLOW_INHERITS_in_detect_parameter1102); 

                        		((detect_parameter_scope)detect_parameter_stack.peek()).exceptionList = new ArrayList<ErrorTypeDescriptor>();
                        	
                        pushFollow(FOLLOW_qualified_name_in_detect_parameter1111);
                        qn=qualified_name();

                        state._fsp--;


                        		ErrorTypeDescriptor t = new ErrorTypeDescriptor();

                        		ClassDescriptor cd = symbol.findClassDescriptorFromCurrentClass((qn!=null?qn.type:null).getStaticKey());

                        		if(cd == null) { //this is a compiler error
                        			cd = symbol.getCurrentClass();
                        			GenericDescriptor gd = cd.getTemplateVariable((qn!=null?qn.type:null).getStaticKey());
                        			if(gd != null){
                        				t.setName(gd.getType().getStaticKey());
                        			}else{
                        				CompilerError error = new CompilerError();
                        				error.setLineNumber((qn!=null?qn.type:null).getLineBegin());
                        				error.setError("Class " + (qn!=null?qn.type:null).getStaticKey() + " could not be found." +
                        					" Did you forget a \"use\" statement?");
                        				error.setErrorType(ErrorType.MISSING_CLASS);
                        				error.setColumn((qn!=null?qn.type:null).getColumnBegin());
                        				error.setFile(getGrammarFileNameNoExtension());
                        				vm.getCompilerErrors().addError(error);
                        			}
                        		}
                        		else {
                        			if(cd.getStaticKey().equals(ErrorTypeDescriptor.ERROR) || cd.getParent(ErrorTypeDescriptor.ERROR) != null){
                                    			t.setName(cd.getStaticKey());
                                    		}else{
                                                        CompilerError error = new CompilerError();
                                    			error.setLineNumber(cd.getLineBegin());
                                    			error.setError("Class " + cd.getStaticKey() + " is not an error type." +
                                    					cd.getStaticKey() + " must inherit from class Error to be an error type");
                                    			error.setErrorType(ErrorType.INVALID_ERROR);
                                    			error.setColumn((qn!=null?qn.type:null).getColumnBegin());
                                    			error.setFile(getGrammarFileNameNoExtension());
                                    			vm.getCompilerErrors().addError(error);
                                                 }
                        		}
                        		((detect_parameter_scope)detect_parameter_stack.peek()).exceptionList.add(t);
                        	
                        // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:958:2: ( OR qn= qualified_name )*
                        loop40:
                        do {
                            int alt40=2;
                            int LA40_0 = input.LA(1);

                            if ( (LA40_0==OR) ) {
                                alt40=1;
                            }


                            switch (alt40) {
                        	case 1 :
                        	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:958:3: OR qn= qualified_name
                        	    {
                        	    match(input,OR,FOLLOW_OR_in_detect_parameter1118); 
                        	    pushFollow(FOLLOW_qualified_name_in_detect_parameter1122);
                        	    qn=qualified_name();

                        	    state._fsp--;


                        	    		t = new ErrorTypeDescriptor();

                        	    		cd = symbol.findClassDescriptorFromCurrentClass((qn!=null?qn.type:null).getStaticKey());

                        	    		if(cd == null) { //this is a compiler error
                        	    			cd = symbol.getCurrentClass();
                        	    			GenericDescriptor gd = cd.getTemplateVariable((qn!=null?qn.type:null).getStaticKey());
                        	    			if(gd != null){
                        	    				t.setName(gd.getType().getStaticKey());
                        	    			}else{
                        	    				CompilerError error = new CompilerError();
                        	    				error.setLineNumber((qn!=null?qn.type:null).getLineBegin());
                        	    				error.setError("Class " + (qn!=null?qn.type:null).getStaticKey() + " could not be found." +
                        	    					" Did you forget a \"use\" statement?");
                        	    				error.setErrorType(ErrorType.MISSING_CLASS);
                        	    				error.setColumn((qn!=null?qn.type:null).getColumnBegin());
                        	    				error.setFile(getGrammarFileNameNoExtension());
                        	    				vm.getCompilerErrors().addError(error);
                        	    			}
                        	    		}
                        	    		else {
                        	    			if(cd.getStaticKey().equals(ErrorTypeDescriptor.ERROR) || cd.getParent(ErrorTypeDescriptor.ERROR) != null){
                        	    				t.setName(cd.getStaticKey());
                        	    			}else{
                        	    				CompilerError error = new CompilerError();
                        	                			error.setLineNumber(cd.getLineBegin());
                        	                			error.setError("Class " + cd.getStaticKey() + " is not an error type." +
                        	                					cd.getStaticKey() + " must inherit from class Error to be an error type");
                        	                			error.setErrorType(ErrorType.INVALID_ERROR);
                        	                			error.setColumn((qn!=null?qn.type:null).getColumnBegin());
                        	                			error.setFile(getGrammarFileNameNoExtension());
                        	                			vm.getCompilerErrors().addError(error);
                        	    			}
                        	    		}
                        	    		((detect_parameter_scope)detect_parameter_stack.peek()).exceptionList.add(t);
                        	    	

                        	    }
                        	    break;

                        	default :
                        	    break loop40;
                            }
                        } while (true);


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }

            		if(((detect_parameter_scope)detect_parameter_stack.peek()).exceptionList == null || ((detect_parameter_scope)detect_parameter_stack.peek()).exceptionList.isEmpty()){
            			((detect_parameter_scope)detect_parameter_stack.peek()).exceptionList = new ArrayList<ErrorTypeDescriptor>();
            			ErrorTypeDescriptor t = new ErrorTypeDescriptor();
            			t.setName(ErrorTypeDescriptor.ERROR);
            			((detect_parameter_scope)detect_parameter_stack.peek()).exceptionList.add(t);
            		}
            		retval.exceptionTypeList = ((detect_parameter_scope)detect_parameter_stack.peek()).exceptionList;
            		retval.name = (id!=null?id.getText():null);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            detect_parameter_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "detect_parameter"

    public static class print_statement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "print_statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1009:1: print_statement : OUTPUT root_expression ;
    public final QuorumTreeWalker.print_statement_return print_statement() throws RecognitionException {
        QuorumTreeWalker.print_statement_return retval = new QuorumTreeWalker.print_statement_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.root_expression_return root_expression15 = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1010:2: ( OUTPUT root_expression )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1010:4: OUTPUT root_expression
            {
            match(input,OUTPUT,FOLLOW_OUTPUT_in_print_statement1149); 
            pushFollow(FOLLOW_root_expression_in_print_statement1151);
            root_expression15=root_expression();

            state._fsp--;


            		ExecutionStep step = (root_expression15!=null?root_expression15.step:null);
            		ExpressionValue value = (root_expression15!=null?root_expression15.eval:null);

            		LineInformation location = new LineInformation();
            	                	location.setEndColumn(step.getEndColumn());
            	               	location.setEndLine(step.getEndLine());
            	               	location.setStartColumn(step.getBeginColumn());
            	           	location.setStartLine(step.getBeginLine());
            	            	location.setFile(getGrammarFileNameNoExtension());
            	
                            		symbol.addStatementFlagToCurrentFile(step.getBeginLine());
                            
            		stepFactory.addPrintStep(location, (root_expression15!=null?root_expression15.eval:null), (root_expression15!=null?root_expression15.step:null));
            		builder.addStepLabel(OpcodeType.PRINT, -1);
            		
            		indexer.append("<print line = \"");
            		indexer.append(step.getBeginLine());
            		indexer.append("\" />");
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "print_statement"

    public static class speak_statement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "speak_statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1034:1: speak_statement : SAY root_expression ;
    public final QuorumTreeWalker.speak_statement_return speak_statement() throws RecognitionException {
        QuorumTreeWalker.speak_statement_return retval = new QuorumTreeWalker.speak_statement_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.root_expression_return root_expression16 = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1035:2: ( SAY root_expression )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1035:4: SAY root_expression
            {
            match(input,SAY,FOLLOW_SAY_in_speak_statement1167); 
            pushFollow(FOLLOW_root_expression_in_speak_statement1169);
            root_expression16=root_expression();

            state._fsp--;


            		ExecutionStep step = (root_expression16!=null?root_expression16.step:null);
            		ExpressionValue value = (root_expression16!=null?root_expression16.eval:null);

            		LineInformation location = new LineInformation();
                            		location.setEndColumn(step.getEndColumn());
                            		location.setEndLine(step.getEndLine());
                            		location.setStartColumn(step.getBeginColumn());
                            		location.setStartLine(step.getBeginLine());
                            		location.setFile(getGrammarFileNameNoExtension());

                            		symbol.addStatementFlagToCurrentFile(step.getBeginLine());
            		stepFactory.addSpeakStep(location, (root_expression16!=null?root_expression16.eval:null), (root_expression16!=null?root_expression16.step:null));
            		builder.addStepLabel(OpcodeType.SAY, -1);
            		
            		indexer.append("<say line = \"");
            		indexer.append(step.getBeginLine());
            		indexer.append("\" />");
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "speak_statement"

    public static class return_statement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "return_statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1057:1: return_statement : RETURN ( root_expression | NOW ) ;
    public final QuorumTreeWalker.return_statement_return return_statement() throws RecognitionException {
        QuorumTreeWalker.return_statement_return retval = new QuorumTreeWalker.return_statement_return();
        retval.start = input.LT(1);

        CommonTree NOW18=null;
        CommonTree RETURN19=null;
        QuorumTreeWalker.root_expression_return root_expression17 = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1058:2: ( RETURN ( root_expression | NOW ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1058:4: RETURN ( root_expression | NOW )
            {
            RETURN19=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_return_statement1183); 
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1058:11: ( root_expression | NOW )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==ROOT_EXPRESSION) ) {
                alt42=1;
            }
            else if ( (LA42_0==NOW) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1058:12: root_expression
                    {
                    pushFollow(FOLLOW_root_expression_in_return_statement1186);
                    root_expression17=root_expression();

                    state._fsp--;



                    		ExecutionStep step = (root_expression17!=null?root_expression17.step:null);
                    		ExpressionValue value = (root_expression17!=null?root_expression17.eval:null);

                    		LineInformation location = new LineInformation();
                                    		location.setEndColumn(step.getEndColumn());
                                    		location.setEndLine(step.getEndLine());
                                    		location.setStartColumn(step.getBeginColumn());
                                    		location.setStartLine(step.getBeginLine());
                                    		location.setFile(getGrammarFileNameNoExtension());

                                    		symbol.addStatementFlagToCurrentFile(step.getBeginLine());
                    		stepFactory.addReturnStep(location, (root_expression17!=null?root_expression17.eval:null), (root_expression17!=null?root_expression17.step:null));
                    		builder.addStepLabel(OpcodeType.RETURN, -1);
                    		
                    		indexer.append("<return line = \"");
                    		indexer.append(step.getBeginLine());
                    		indexer.append("\" />");
                    	

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1079:4: NOW
                    {
                    NOW18=(CommonTree)match(input,NOW,FOLLOW_NOW_in_return_statement1194); 

                    		LineInformation location = new LineInformation();
                                    		location.setEndColumn(NOW18.getCharPositionInLine());
                                    		location.setEndLine(NOW18.getLine());
                                    		location.setStartColumn(RETURN19.getCharPositionInLine());
                                    		location.setStartLine(RETURN19.getLine());
                                    		location.setFile(getGrammarFileNameNoExtension());

                                    		symbol.addStatementFlagToCurrentFile(RETURN19.getLine());
                    		stepFactory.addReturnStep(location, null, null);
                    		builder.addStepLabel(OpcodeType.RETURN, -1);
                    		
                    		indexer.append("<return line = \"");
                    		indexer.append(RETURN19.getLine());
                    		indexer.append("\" />");
                    	

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "return_statement"

    public static class generic_declaration_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "generic_declaration"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1098:1: generic_declaration : ^( GENERIC LESS ids+= ID ( COMMA ids+= ID )* GREATER ) ;
    public final QuorumTreeWalker.generic_declaration_return generic_declaration() throws RecognitionException {
        QuorumTreeWalker.generic_declaration_return retval = new QuorumTreeWalker.generic_declaration_return();
        retval.start = input.LT(1);

        CommonTree ids=null;
        List list_ids=null;

        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1099:2: ( ^( GENERIC LESS ids+= ID ( COMMA ids+= ID )* GREATER ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1099:4: ^( GENERIC LESS ids+= ID ( COMMA ids+= ID )* GREATER )
            {
            match(input,GENERIC,FOLLOW_GENERIC_in_generic_declaration1212); 

            match(input, Token.DOWN, null); 
            match(input,LESS,FOLLOW_LESS_in_generic_declaration1214); 
            ids=(CommonTree)match(input,ID,FOLLOW_ID_in_generic_declaration1218); 
            if (list_ids==null) list_ids=new ArrayList();
            list_ids.add(ids);

            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1099:27: ( COMMA ids+= ID )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==COMMA) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1099:28: COMMA ids+= ID
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_generic_declaration1221); 
            	    ids=(CommonTree)match(input,ID,FOLLOW_ID_in_generic_declaration1225); 
            	    if (list_ids==null) list_ids=new ArrayList();
            	    list_ids.add(ids);


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            match(input,GREATER,FOLLOW_GREATER_in_generic_declaration1229); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "generic_declaration"

    public static class generic_statement_return extends TreeRuleReturnScope {
        public ArrayList<GenericDescriptor> templateTypes;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "generic_statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1102:1: generic_statement returns [ArrayList<GenericDescriptor> templateTypes] : ^( GENERIC LESS ad= assignment_declaration ( COMMA a= assignment_declaration )* GREATER ) ;
    public final QuorumTreeWalker.generic_statement_return generic_statement() throws RecognitionException {
        QuorumTreeWalker.generic_statement_return retval = new QuorumTreeWalker.generic_statement_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.assignment_declaration_return ad = null;

        QuorumTreeWalker.assignment_declaration_return a = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1103:2: ( ^( GENERIC LESS ad= assignment_declaration ( COMMA a= assignment_declaration )* GREATER ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1103:4: ^( GENERIC LESS ad= assignment_declaration ( COMMA a= assignment_declaration )* GREATER )
            {
            match(input,GENERIC,FOLLOW_GENERIC_in_generic_statement1247); 

            match(input, Token.DOWN, null); 
            match(input,LESS,FOLLOW_LESS_in_generic_statement1249); 

            		ArrayList<GenericDescriptor> types = new ArrayList<GenericDescriptor>();
            	
            pushFollow(FOLLOW_assignment_declaration_in_generic_statement1258);
            ad=assignment_declaration();

            state._fsp--;


            		TypeDescriptor type = (ad!=null?ad.myType:null);
            				
            		GenericDescriptor genericType = new GenericDescriptor();
            		genericType.setLineBegin(type.getLineBegin());
            		genericType.setColumnBegin(type.getColumnBegin());
            		genericType.setLineEnd(type.getLineEnd());
            		genericType.setColumnEnd(type.getColumnEnd());
            		genericType.setName(type.getName());
            		genericType.addBoundType(type);
            			
            		types.add(genericType);
            	
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1121:3: ( COMMA a= assignment_declaration )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==COMMA) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1121:4: COMMA a= assignment_declaration
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_generic_statement1266); 
            	    pushFollow(FOLLOW_assignment_declaration_in_generic_statement1270);
            	    a=assignment_declaration();

            	    state._fsp--;


            	    		type = (a!=null?a.myType:null);
            	    		
            	    		genericType = new GenericDescriptor();
            	    		genericType.setLineBegin(type.getLineBegin());
            	    		genericType.setColumnBegin(type.getColumnBegin());
            	    		genericType.setLineEnd(type.getLineEnd());
            	    		genericType.setColumnEnd(type.getColumnEnd());
            	    		genericType.setName(type.getName());
            	    		genericType.addBoundType(type);
            	    		
            	    		types.add(genericType);
            	    	

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            	
            	 	retval.templateTypes = types;
            	
            match(input,GREATER,FOLLOW_GREATER_in_generic_statement1286); 

            match(input, Token.UP, null); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "generic_statement"

    public static class class_type_return extends TreeRuleReturnScope {
        public TypeDescriptor myType;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "class_type"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1148:1: class_type returns [TypeDescriptor myType] : qn= qualified_name ;
    public final QuorumTreeWalker.class_type_return class_type() throws RecognitionException {
        QuorumTreeWalker.class_type_return retval = new QuorumTreeWalker.class_type_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.qualified_name_return qn = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1149:2: (qn= qualified_name )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1149:4: qn= qualified_name
            {
            pushFollow(FOLLOW_qualified_name_in_class_type1311);
            qn=qualified_name();

            state._fsp--;


            		TypeDescriptor t = new TypeDescriptor();

            		ClassDescriptor cd = symbol.findClassDescriptorFromCurrentClass((qn!=null?qn.type:null).getStaticKey());

            		if(cd == null) { //this is a compiler error
            			cd = symbol.getCurrentClass();
            			GenericDescriptor gd = cd.getTemplateVariable((qn!=null?qn.type:null).getStaticKey());
            			if(gd != null){
            				t = gd.getType();
            			}else{
            				CompilerError error = new CompilerError();
            				error.setLineNumber((qn!=null?qn.type:null).getLineBegin());
            				error.setError("Class " + (qn!=null?qn.type:null).getStaticKey() + " could not be found." +
            					" Did you forget a \"use\" statement?");
            				error.setErrorType(ErrorType.MISSING_CLASS);
            				error.setColumn((qn!=null?qn.type:null).getColumnBegin());
            				error.setFile(getGrammarFileNameNoExtension());
            				vm.getCompilerErrors().addError(error);
            			}
            		}
            		else {
            			t.setName(cd.getStaticKey());
            		}
            		retval.myType =t;
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "class_type"

    public static class assignment_declaration_return extends TreeRuleReturnScope {
        public TypeDescriptor myType;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "assignment_declaration"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1178:1: assignment_declaration returns [TypeDescriptor myType] : (qn= qualified_name (gs= generic_statement )? | INTEGER_KEYWORD | NUMBER_KEYWORD | TEXT | BOOLEAN_KEYWORD );
    public final QuorumTreeWalker.assignment_declaration_return assignment_declaration() throws RecognitionException {
        QuorumTreeWalker.assignment_declaration_return retval = new QuorumTreeWalker.assignment_declaration_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.qualified_name_return qn = null;

        QuorumTreeWalker.generic_statement_return gs = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1179:2: (qn= qualified_name (gs= generic_statement )? | INTEGER_KEYWORD | NUMBER_KEYWORD | TEXT | BOOLEAN_KEYWORD )
            int alt46=5;
            switch ( input.LA(1) ) {
            case QUALIFIED_NAME:
                {
                alt46=1;
                }
                break;
            case INTEGER_KEYWORD:
                {
                alt46=2;
                }
                break;
            case NUMBER_KEYWORD:
                {
                alt46=3;
                }
                break;
            case TEXT:
                {
                alt46=4;
                }
                break;
            case BOOLEAN_KEYWORD:
                {
                alt46=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1179:4: qn= qualified_name (gs= generic_statement )?
                    {
                    pushFollow(FOLLOW_qualified_name_in_assignment_declaration1333);
                    qn=qualified_name();

                    state._fsp--;

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1179:26: (gs= generic_statement )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==GENERIC) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1179:26: gs= generic_statement
                            {
                            pushFollow(FOLLOW_generic_statement_in_assignment_declaration1337);
                            gs=generic_statement();

                            state._fsp--;


                            }
                            break;

                    }


                    		TypeDescriptor t = new TypeDescriptor();

                    		ClassDescriptor cd = symbol.findClassDescriptorFromCurrentClass((qn!=null?qn.type:null).getStaticKey());

                    		if(cd == null) { //this is a compiler error
                    			cd = symbol.getCurrentClass();
                    			GenericDescriptor gd = cd.getTemplateVariable((qn!=null?qn.type:null).getStaticKey());
                    			if(gd != null){
                    				t = gd.getType();
                    			}else{
                    				CompilerError error = new CompilerError();
                    				error.setLineNumber((qn!=null?qn.type:null).getLineBegin());
                    				error.setError("Class " + (qn!=null?qn.type:null).getStaticKey() + " could not be found." +
                    					" Did you forget a \"use\" statement?");
                    				error.setErrorType(ErrorType.MISSING_CLASS);
                    				error.setColumn((qn!=null?qn.type:null).getColumnBegin());
                    				error.setFile(getGrammarFileNameNoExtension());
                    				vm.getCompilerErrors().addError(error);
                    			}
                    		}
                    		else {
                    			if((gs!=null?gs.templateTypes:null) != null){
                    				t.setSubTypes((gs!=null?gs.templateTypes:null));
                    			}
                    			t.setName(cd.getStaticKey());
                    		}
                    		retval.myType =t;
                    	

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1209:4: INTEGER_KEYWORD
                    {
                    match(input,INTEGER_KEYWORD,FOLLOW_INTEGER_KEYWORD_in_assignment_declaration1346); 

                    		TypeDescriptor type = new TypeDescriptor();
                    		type.setName(TypeDescriptor.INTEGER);
                    		retval.myType = type;
                    	

                    }
                    break;
                case 3 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1215:4: NUMBER_KEYWORD
                    {
                    match(input,NUMBER_KEYWORD,FOLLOW_NUMBER_KEYWORD_in_assignment_declaration1354); 

                    		TypeDescriptor type = new TypeDescriptor();
                    		type.setName(TypeDescriptor.NUMBER);
                    		retval.myType = type;
                    	

                    }
                    break;
                case 4 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1221:4: TEXT
                    {
                    match(input,TEXT,FOLLOW_TEXT_in_assignment_declaration1362); 

                    		TypeDescriptor type = new TypeDescriptor();
                    		type.setName(TypeDescriptor.TEXT);
                    		retval.myType = type;
                    	

                    }
                    break;
                case 5 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1227:4: BOOLEAN_KEYWORD
                    {
                    match(input,BOOLEAN_KEYWORD,FOLLOW_BOOLEAN_KEYWORD_in_assignment_declaration1370); 

                    		TypeDescriptor type = new TypeDescriptor();
                    		type.setName(TypeDescriptor.BOOLEAN);
                    		retval.myType = type;
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment_declaration"

    public static class assignment_statement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "assignment_statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1233:1: assignment_statement : ( (sel= selector COLON )? ID rhs= assign_right_hand_side | obj= qualified_name ( COLON PARENT COLON parent= qualified_name )? COLON ID rhs= assign_right_hand_side | (modifier= access_modifier )? ( CONSTANT )? type= assignment_declaration name= ID (rhs= assign_right_hand_side )? );
    public final QuorumTreeWalker.assignment_statement_return assignment_statement() throws RecognitionException {
        QuorumTreeWalker.assignment_statement_return retval = new QuorumTreeWalker.assignment_statement_return();
        retval.start = input.LT(1);

        CommonTree name=null;
        CommonTree ID20=null;
        CommonTree ID21=null;
        CommonTree PARENT22=null;
        QuorumTreeWalker.selector_return sel = null;

        QuorumTreeWalker.assign_right_hand_side_return rhs = null;

        QuorumTreeWalker.qualified_name_return obj = null;

        QuorumTreeWalker.qualified_name_return parent = null;

        QuorumTreeWalker.access_modifier_return modifier = null;

        QuorumTreeWalker.assignment_declaration_return type = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1234:2: ( (sel= selector COLON )? ID rhs= assign_right_hand_side | obj= qualified_name ( COLON PARENT COLON parent= qualified_name )? COLON ID rhs= assign_right_hand_side | (modifier= access_modifier )? ( CONSTANT )? type= assignment_declaration name= ID (rhs= assign_right_hand_side )? )
            int alt52=3;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1235:3: (sel= selector COLON )? ID rhs= assign_right_hand_side
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1235:3: (sel= selector COLON )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==ME||LA47_0==PARENT) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1235:4: sel= selector COLON
                            {
                            pushFollow(FOLLOW_selector_in_assignment_statement1386);
                            sel=selector();

                            state._fsp--;

                            match(input,COLON,FOLLOW_COLON_in_assignment_statement1388); 

                            }
                            break;

                    }

                    ID20=(CommonTree)match(input,ID,FOLLOW_ID_in_assignment_statement1392); 
                    pushFollow(FOLLOW_assign_right_hand_side_in_assignment_statement1396);
                    rhs=assign_right_hand_side();

                    state._fsp--;


                    		boolean isMe = false;
                    		LineInformation location = new LineInformation (
                    			 (ID20!=null?ID20.getLine():0),
                    			 0,
                    			 ID20.getCharPositionInLine(),
                    			 0
                    		);
                    		
                    		location.setFile(symbol.getCurrentClass().getFile().getStaticKey());
                                    		location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    		if(symbol.getCurrentMethod() != null){
                                    			location.setMethodName(symbol.getCurrentMethod().getStaticKey());
                                    		}
                                    
                    		ScopeSelector scope = (sel!=null?sel.scopeSel:null);
                    		ClassDescriptor cd = null;
                    		if(scope!= null){
                    			if(scope.isParent()){
                    				cd = scope.getCurrentClass();
                    			}else{
                    				cd = symbol.getCurrentClass();
                    				isMe = true;
                    			}
                    		}
                    		
                    		symbol.addStatementFlagToCurrentFile((ID20!=null?ID20.getLine():0));
                    		
                    		boolean hasRHS = false;
                    		if((rhs!=null?rhs.eval:null) != null){
                    			hasRHS = true;
                    		}
                    		
                    		stepFactory.addAssignmentStep(location, (ID20!=null?ID20.getText():null), (rhs!=null?rhs.eval:null), (rhs!=null?rhs.step:null), false, "", cd, isMe, hasRHS);
                    		builder.addStepLabel(OpcodeType.ASSIGNMENT, -1);
                    		
                    		indexer.append("<assignment line = \"");
                    		indexer.append((ID20!=null?ID20.getLine():0));
                    		indexer.append("\" variable = \"");
                    		indexer.append((ID20!=null?ID20.getText():null));
                    		indexer.append("\"/>");
                    	

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1278:4: obj= qualified_name ( COLON PARENT COLON parent= qualified_name )? COLON ID rhs= assign_right_hand_side
                    {
                    pushFollow(FOLLOW_qualified_name_in_assignment_statement1406);
                    obj=qualified_name();

                    state._fsp--;

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1278:23: ( COLON PARENT COLON parent= qualified_name )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==COLON) ) {
                        int LA48_1 = input.LA(2);

                        if ( (LA48_1==PARENT) ) {
                            alt48=1;
                        }
                    }
                    switch (alt48) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1278:24: COLON PARENT COLON parent= qualified_name
                            {
                            match(input,COLON,FOLLOW_COLON_in_assignment_statement1409); 
                            PARENT22=(CommonTree)match(input,PARENT,FOLLOW_PARENT_in_assignment_statement1411); 
                            match(input,COLON,FOLLOW_COLON_in_assignment_statement1413); 
                            pushFollow(FOLLOW_qualified_name_in_assignment_statement1417);
                            parent=qualified_name();

                            state._fsp--;


                            }
                            break;

                    }

                    match(input,COLON,FOLLOW_COLON_in_assignment_statement1421); 
                    ID21=(CommonTree)match(input,ID,FOLLOW_ID_in_assignment_statement1423); 
                    pushFollow(FOLLOW_assign_right_hand_side_in_assignment_statement1427);
                    rhs=assign_right_hand_side();

                    state._fsp--;


                    		LineInformation location = new LineInformation (
                    			 (ID21!=null?ID21.getLine():0),
                    			 0,
                    			 ID21.getCharPositionInLine(),
                    			 0
                    		);
                    		location.setFile(symbol.getCurrentClass().getFile().getStaticKey());
                                    		location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    		if(symbol.getCurrentMethod() != null){
                                    			location.setMethodName(symbol.getCurrentMethod().getStaticKey());
                                    		}
                                    
                    		boolean isLocal = (type!=null?type.myType:null) != null;
                    		
                    		symbol.addStatementFlagToCurrentFile((ID21!=null?ID21.getLine():0));
                    		ClassDescriptor cd = null;
                    		
                    		if((parent!=null?parent.type:null) != null){
                    			cd = symbol.findClassDescriptorFromCurrentClass((parent!=null?parent.type:null).getStaticKey());
                    			
                    			if(cd == null){
                    				CompilerError error = new CompilerError(PARENT22.getLine(), "The class "+ symbol.getCurrentClass().getStaticKey() +" does not have access to " + (parent!=null?parent.type:null).getStaticKey(), ErrorType.MISSING_PARENT);
                    				vm.getCompilerErrors().addError(error);
                    			}
                    		}
                    		
                    		boolean hasRHS = false;
                    		if((rhs!=null?rhs.eval:null) != null){
                    			hasRHS = true;
                    		}
                    		
                    		stepFactory.addAssignmentStep(location, (obj!=null?obj.type:null).getStaticKey(), (rhs!=null?rhs.eval:null), (rhs!=null?rhs.step:null), isLocal, (ID21!=null?ID21.getText():null), cd, false, hasRHS);
                    		builder.addStepLabel(OpcodeType.ASSIGNMENT, -1);
                    		
                    		indexer.append("<assignment line = \"");
                    		indexer.append((ID21!=null?ID21.getLine():0));
                    		indexer.append("\" variable = \"");
                    		indexer.append((ID21!=null?ID21.getText():null));
                    		indexer.append("\"/>");
                    	

                    }
                    break;
                case 3 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1320:4: (modifier= access_modifier )? ( CONSTANT )? type= assignment_declaration name= ID (rhs= assign_right_hand_side )?
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1320:13: (modifier= access_modifier )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( ((LA49_0>=PRIVATE && LA49_0<=PUBLIC)) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1320:13: modifier= access_modifier
                            {
                            pushFollow(FOLLOW_access_modifier_in_assignment_statement1439);
                            modifier=access_modifier();

                            state._fsp--;


                            }
                            break;

                    }

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1320:32: ( CONSTANT )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==CONSTANT) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1320:32: CONSTANT
                            {
                            match(input,CONSTANT,FOLLOW_CONSTANT_in_assignment_statement1442); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_assignment_declaration_in_assignment_statement1449);
                    type=assignment_declaration();

                    state._fsp--;

                    name=(CommonTree)match(input,ID,FOLLOW_ID_in_assignment_statement1455); 
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1320:85: (rhs= assign_right_hand_side )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==EQUALITY) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1320:85: rhs= assign_right_hand_side
                            {
                            pushFollow(FOLLOW_assign_right_hand_side_in_assignment_statement1459);
                            rhs=assign_right_hand_side();

                            state._fsp--;


                            }
                            break;

                    }


                    	                	LineInformation location = new LineInformation (
                    	                    		(name!=null?name.getLine():0),
                    	                    		0,
                    	                    		name.getCharPositionInLine(),
                    	 		0
                    		);
                                    		location.setFile(symbol.getCurrentClass().getFile().getStaticKey());
                                    		location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    		if(symbol.getCurrentMethod() != null){
                                    			location.setMethodName(symbol.getCurrentMethod().getStaticKey());
                                    		}
                                    
                                    		boolean isLocal = (type!=null?type.myType:null) != null;
                                    
                                    		symbol.addStatementFlagToCurrentFile((name!=null?name.getLine():0));
                                    
                    		if((rhs!=null?rhs.eval:null) != null)
                    		{
                    			stepFactory.addAssignmentStep(location, (name!=null?name.getText():null), (rhs!=null?rhs.eval:null), (rhs!=null?rhs.step:null), isLocal, true);
                    		}
                    	                	else { // are we are trying to instantiate an object?
                    	                		builder.addStepLabel(OpcodeType.ROOT_EXPRESSION, -1);
                    	                    		stepFactory.addAssignmentStep(location, (name!=null?name.getText():null), isLocal, false);
                    	                	}
                    	                	builder.addStepLabel(OpcodeType.ASSIGNMENT, -1);
                    		indexer.append("<assignment line = \"");
                    		indexer.append((name!=null?name.getLine():0));
                    		indexer.append("\" variable = \"");
                    		indexer.append((name!=null?name.getText():null));
                    		indexer.append("\"/>");
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment_statement"

    public static class assign_right_hand_side_return extends TreeRuleReturnScope {
        public ExpressionValue eval;
        public ExecutionStep step;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "assign_right_hand_side"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1354:1: assign_right_hand_side returns [ExpressionValue eval, ExecutionStep step] : ( EQUALITY root_expression ) ;
    public final QuorumTreeWalker.assign_right_hand_side_return assign_right_hand_side() throws RecognitionException {
        QuorumTreeWalker.assign_right_hand_side_return retval = new QuorumTreeWalker.assign_right_hand_side_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.root_expression_return root_expression23 = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1355:2: ( ( EQUALITY root_expression ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1356:3: ( EQUALITY root_expression )
            {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1356:3: ( EQUALITY root_expression )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1356:4: EQUALITY root_expression
            {
            match(input,EQUALITY,FOLLOW_EQUALITY_in_assign_right_hand_side1480); 
            pushFollow(FOLLOW_root_expression_in_assign_right_hand_side1482);
            root_expression23=root_expression();

            state._fsp--;


            }


            		retval.eval = (root_expression23!=null?root_expression23.eval:null);
            		retval.step = (root_expression23!=null?root_expression23.step:null);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assign_right_hand_side"

    protected static class if_statement_scope {
        IfStatementInfo info;
        int else_if_counter;
        String endMatch;
    }
    protected Stack if_statement_stack = new Stack();

    public static class if_statement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "if_statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1364:1: if_statement : begin_if= IF condition= root_expression b= block[true] (begin_else_if= ELSE_IF condition2= root_expression b= block[true] )* (begin_else= ELSE b= block[true] )? end= END ;
    public final QuorumTreeWalker.if_statement_return if_statement() throws RecognitionException {
        if_statement_stack.push(new if_statement_scope());
        QuorumTreeWalker.if_statement_return retval = new QuorumTreeWalker.if_statement_return();
        retval.start = input.LT(1);

        CommonTree begin_if=null;
        CommonTree begin_else_if=null;
        CommonTree begin_else=null;
        CommonTree end=null;
        QuorumTreeWalker.root_expression_return condition = null;

        QuorumTreeWalker.block_return b = null;

        QuorumTreeWalker.root_expression_return condition2 = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1370:3: (begin_if= IF condition= root_expression b= block[true] (begin_else_if= ELSE_IF condition2= root_expression b= block[true] )* (begin_else= ELSE b= block[true] )? end= END )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1370:5: begin_if= IF condition= root_expression b= block[true] (begin_else_if= ELSE_IF condition2= root_expression b= block[true] )* (begin_else= ELSE b= block[true] )? end= END
            {
            begin_if=(CommonTree)match(input,IF,FOLLOW_IF_in_if_statement1508); 

            			((if_statement_scope)if_statement_stack.peek()).endMatch = "if";
            			((if_statement_scope)if_statement_stack.peek()).info = new IfStatementInfo();
            			((if_statement_scope)if_statement_stack.peek()).else_if_counter = 0;
            			((if_statement_scope)if_statement_stack.peek()).info.endLabel = (begin_if!=null?begin_if.getText():null) + labelCounter + ((if_statement_scope)if_statement_stack.peek()).info.END;
            			((if_statement_scope)if_statement_stack.peek()).info.ifFalseLabel =(begin_if!=null?begin_if.getText():null) + labelCounter + ((if_statement_scope)if_statement_stack.peek()).info.FALSE;
            			((if_statement_scope)if_statement_stack.peek()).info.ifStartLabel =(begin_if!=null?begin_if.getText():null) + labelCounter + ((if_statement_scope)if_statement_stack.peek()).info.START;
            			symbol.addStatementFlagToCurrentFile(begin_if.getLine());
            			labelCounter++;
            					
            		
            pushFollow(FOLLOW_root_expression_in_if_statement1521);
            condition=root_expression();

            state._fsp--;


            			stepFactory.assertBooleanExpression((condition!=null?condition.eval:null).getType(),
            			    (condition!=null?condition.step:null),
            			    getGrammarFileNameNoExtension());
            			    
            			((if_statement_scope)if_statement_stack.peek()).info.ifLocation = new LineInformation(
            				begin_if.getLine(),
            				begin_if.getLine(),
            				begin_if.getCharPositionInLine(),
            				(begin_if!=null?begin_if.getText():null).length() + begin_if.getCharPositionInLine());
            				
            			ConditionalJumpIfStep ifConditionalStep = new ConditionalJumpIfStep();
            			ifConditionalStep.setEndColumn((begin_if!=null?begin_if.getText():null).length() + begin_if.getCharPositionInLine());
            			ifConditionalStep.setEndLine(begin_if.getLine());
            			ifConditionalStep.setBeginColumn(begin_if.getCharPositionInLine());
            			ifConditionalStep.setBeginLine(begin_if.getLine());

            			ifConditionalStep.setLeftRegister((condition!=null?condition.eval:null).getRegister());
            			((if_statement_scope)if_statement_stack.peek()).info.ifConditionalStep = ifConditionalStep;

            			stepFactory.startIf(((if_statement_scope)if_statement_stack.peek()).info);
            			
            		
            pushFollow(FOLLOW_block_in_if_statement1533);
            b=block(true);

            state._fsp--;


                                    
                                    		((if_statement_scope)if_statement_stack.peek()).info.ifJumpStep.setBeginColumn(begin_if.getCharPositionInLine());
            			((if_statement_scope)if_statement_stack.peek()).info.ifJumpStep.setEndColumn(begin_if.getCharPositionInLine() + ((begin_if!=null?begin_if.getText():null).length()));
            	                		((if_statement_scope)if_statement_stack.peek()).info.ifJumpStep.setEndLine(begin_if.getLine());
            			stepFactory.addIfEndJumpStep(((if_statement_scope)if_statement_stack.peek()).info);
            			
            		
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1415:3: (begin_else_if= ELSE_IF condition2= root_expression b= block[true] )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==ELSE_IF) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1415:4: begin_else_if= ELSE_IF condition2= root_expression b= block[true]
            	    {
            	    begin_else_if=(CommonTree)match(input,ELSE_IF,FOLLOW_ELSE_IF_in_if_statement1550); 

            	    			
            	    			if(((if_statement_scope)if_statement_stack.peek()).endMatch.equals("if"))
            	    			{
            	    				((if_statement_scope)if_statement_stack.peek()).info.ifJumpStep.setBeginLine(begin_else_if.getLine());
            	    				stepFactory.endIf(((if_statement_scope)if_statement_stack.peek()).info);
            	    				
            	    				indexer.append("<if line = \"");
            	    				indexer.append(((if_statement_scope)if_statement_stack.peek()).info.ifLocation.getStartLine());
            	    				indexer.append("\" end = \"");
            	    				indexer.append(begin_else_if.getLine());
            	    				indexer.append("\"/>");
            	    			}
            	    			else
            	    			{
            	    				((if_statement_scope)if_statement_stack.peek()).info.elseIfJumpSteps.get(((if_statement_scope)if_statement_stack.peek()).else_if_counter).setBeginLine(begin_else_if.getLine());
            	    				stepFactory.endElseIf(((if_statement_scope)if_statement_stack.peek()).info, ((if_statement_scope)if_statement_stack.peek()).else_if_counter);
            	    				((if_statement_scope)if_statement_stack.peek()).else_if_counter = ((if_statement_scope)if_statement_stack.peek()).else_if_counter + 1;
            	    				
            	    				indexer.append("<elseif line = \"");
            	    				indexer.append(((if_statement_scope)if_statement_stack.peek()).info.elseIfLocations.get(((if_statement_scope)if_statement_stack.peek()).info.elseIfLocations.size() - 1).getStartLine());
            	    				indexer.append("\" end = \"");
            	    				indexer.append(begin_else_if.getLine());
            	    				indexer.append("\"/>");
            	    			}
            	    			((if_statement_scope)if_statement_stack.peek()).endMatch = "elseif";
            	    			
            	    			((if_statement_scope)if_statement_stack.peek()).info.elseIfEndLabels.add((begin_else_if!=null?begin_else_if.getText():null)  + labelCounter + ((if_statement_scope)if_statement_stack.peek()).info.END + ((if_statement_scope)if_statement_stack.peek()).else_if_counter);
            	    			((if_statement_scope)if_statement_stack.peek()).info.elseIfFalseLabels.add((begin_else_if!=null?begin_else_if.getText():null) + labelCounter + ((if_statement_scope)if_statement_stack.peek()).info.FALSE + ((if_statement_scope)if_statement_stack.peek()).else_if_counter);
            	    			((if_statement_scope)if_statement_stack.peek()).info.elseIfStartLabels.add((begin_else_if!=null?begin_else_if.getText():null) + + labelCounter + ((if_statement_scope)if_statement_stack.peek()).info.START + ((if_statement_scope)if_statement_stack.peek()).else_if_counter);	
            	    			
            	    			symbol.addStatementFlagToCurrentFile(begin_else_if.getLine());		
            	    			labelCounter++;
            	    					
            	    		
            	    pushFollow(FOLLOW_root_expression_in_if_statement1563);
            	    condition2=root_expression();

            	    state._fsp--;


            	    			stepFactory.assertBooleanExpression((condition2!=null?condition2.eval:null).getType(),
            	    			    (condition2!=null?condition2.step:null),
            	    			    getGrammarFileNameNoExtension());
            	    			    
            	    			((if_statement_scope)if_statement_stack.peek()).info.elseIfLocations.add(new LineInformation(
            	    				begin_else_if.getLine(),
            	    				begin_else_if.getLine(),
            	    				begin_else_if.getCharPositionInLine(),
            	    				(begin_else_if!=null?begin_else_if.getText():null).length() + begin_else_if.getCharPositionInLine()));
            	    			
            	    			ConditionalJumpIfStep conditionalStep = new ConditionalJumpIfStep();
            	    			conditionalStep.setIsElseIf(true);
            	    			conditionalStep.setEndColumn((begin_else_if!=null?begin_else_if.getText():null).length() + begin_else_if.getCharPositionInLine());
            	    			conditionalStep.setEndLine(begin_else_if.getLine());
            	    			conditionalStep.setBeginColumn(begin_else_if.getCharPositionInLine());
            	    			conditionalStep.setBeginLine(begin_else_if.getLine());

            	    			conditionalStep.setLeftRegister((condition2!=null?condition2.eval:null).getRegister());
            	    			
            	    			((if_statement_scope)if_statement_stack.peek()).info.elseIfConditionalSteps.add(conditionalStep);	
            	    			
            	    			stepFactory.startElseIf(((if_statement_scope)if_statement_stack.peek()).info,((if_statement_scope)if_statement_stack.peek()).else_if_counter);
            	    		
            	    pushFollow(FOLLOW_block_in_if_statement1573);
            	    b=block(true);

            	    state._fsp--;


            	    			JumpStep jump = new JumpStep();
            	    			jump.setType(JumpType.IF);
            	    			jump.setBeginColumn(begin_else_if.getCharPositionInLine());
            	    			jump.setEndColumn(begin_else_if.getCharPositionInLine() + ((begin_else_if!=null?begin_else_if.getText():null).length()));
            	    			jump.setEndLine(begin_else_if.getLine());
            	    			((if_statement_scope)if_statement_stack.peek()).info.elseIfJumpSteps.add(jump);
            	    			
            	    			stepFactory.addElseIfEndJumpStep(((if_statement_scope)if_statement_stack.peek()).info, ((if_statement_scope)if_statement_stack.peek()).else_if_counter);	
            	    		

            	    								
            	    		

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1491:3: (begin_else= ELSE b= block[true] )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==ELSE) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1491:4: begin_else= ELSE b= block[true]
                    {
                    begin_else=(CommonTree)match(input,ELSE,FOLLOW_ELSE_in_if_statement1607); 

                    			((if_statement_scope)if_statement_stack.peek()).info.elseLocation = new LineInformation(
                    				begin_else.getLine(),
                    				begin_else.getLine(),
                    				begin_else.getCharPositionInLine(),
                    				(begin_else!=null?begin_else.getText():null).length() + begin_if.getCharPositionInLine());
                    			if(((if_statement_scope)if_statement_stack.peek()).endMatch.equals("if"))
                    			{
                    				((if_statement_scope)if_statement_stack.peek()).info.ifJumpStep.setBeginLine(begin_else.getLine());
                    				stepFactory.endIf(((if_statement_scope)if_statement_stack.peek()).info);
                    				
                    				indexer.append("<if line = \"");
                    				indexer.append(((if_statement_scope)if_statement_stack.peek()).info.ifLocation.getStartLine());
                    				indexer.append("\" end = \"");
                    				indexer.append(begin_else.getLine());
                    				indexer.append("\"/>");
                    			}
                    			else
                    			{
                    				((if_statement_scope)if_statement_stack.peek()).info.elseIfJumpSteps.get(((if_statement_scope)if_statement_stack.peek()).else_if_counter).setBeginLine(begin_else.getLine());
                    				stepFactory.endElseIf(((if_statement_scope)if_statement_stack.peek()).info, ((if_statement_scope)if_statement_stack.peek()).else_if_counter);
                    				((if_statement_scope)if_statement_stack.peek()).else_if_counter = ((if_statement_scope)if_statement_stack.peek()).else_if_counter + 1;
                    				
                    				indexer.append("<elseif line = \"");
                    				indexer.append(((if_statement_scope)if_statement_stack.peek()).info.elseIfLocations.get(((if_statement_scope)if_statement_stack.peek()).info.elseIfLocations.size() - 1).getStartLine());
                    				indexer.append("\" end = \"");
                    				indexer.append(begin_else.getLine());
                    				indexer.append("\"/>");
                    			}
                    			((if_statement_scope)if_statement_stack.peek()).endMatch = "else";
                    			
                    			((if_statement_scope)if_statement_stack.peek()).info.elseStartLabel = (begin_else!=null?begin_else.getText():null) + labelCounter + ((if_statement_scope)if_statement_stack.peek()).info.START;	
                    			((if_statement_scope)if_statement_stack.peek()).info.hasElse = true;
                    			labelCounter++;	
                    			stepFactory.startElse(((if_statement_scope)if_statement_stack.peek()).info);	
                    			
                    		
                    pushFollow(FOLLOW_block_in_if_statement1617);
                    b=block(true);

                    state._fsp--;


                    }
                    break;

            }

            end=(CommonTree)match(input,END,FOLLOW_END_in_if_statement1626); 

            			if(((if_statement_scope)if_statement_stack.peek()).endMatch.equals("if"))
            			{
            				((if_statement_scope)if_statement_stack.peek()).info.ifJumpStep.setBeginLine(end.getLine());
            				stepFactory.endIf(((if_statement_scope)if_statement_stack.peek()).info);
            				
            				indexer.append("<if line = \"");
            				indexer.append(((if_statement_scope)if_statement_stack.peek()).info.ifLocation.getStartLine());
            				indexer.append("\" end = \"");
            				indexer.append(end.getLine());
            				indexer.append("\"/>");
            			}
            			else if(((if_statement_scope)if_statement_stack.peek()).endMatch.equals("elseif"))
            			{
            				((if_statement_scope)if_statement_stack.peek()).info.elseIfJumpSteps.get(((if_statement_scope)if_statement_stack.peek()).else_if_counter).setBeginLine(end.getLine());
            				stepFactory.endElseIf(((if_statement_scope)if_statement_stack.peek()).info, ((if_statement_scope)if_statement_stack.peek()).else_if_counter);
            				// ((if_statement_scope)if_statement_stack.peek()).else_if_counter = ((if_statement_scope)if_statement_stack.peek()).else_if_counter + 1;
            				
            				indexer.append("<elseif line = \"");
            				indexer.append(((if_statement_scope)if_statement_stack.peek()).info.elseIfLocations.get(((if_statement_scope)if_statement_stack.peek()).info.elseIfLocations.size() - 1).getStartLine());
            				indexer.append("\" end = \"");
            				indexer.append(end.getLine());
            				indexer.append("\"/>");
            			}
            			else
            			{
            				stepFactory.endElse(((if_statement_scope)if_statement_stack.peek()).info);
            				
            				indexer.append("<else line = \"");
            				indexer.append(((if_statement_scope)if_statement_stack.peek()).info.elseLocation.getStartLine());
            				indexer.append("\" end = \"");
            				indexer.append(end.getLine());
            				indexer.append("\"/>");
            			}
            			
            			stepFactory.endIfBlock(((if_statement_scope)if_statement_stack.peek()).info);
              																		
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if_statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "if_statement"

    protected static class loop_statement_scope {
        String marker_top;
        String marker_loop;
        String marker_bottom;
        LineInformation location;
        ResultTuple loop_counter;
        JumpStep jumpToTop;
        ExpressionValue first_value;
        ExecutionStep first_step;
        ExpressionValue last_value;
        ExecutionStep last_step;
        int type;
        ConditionalJumpLoopStep cJumpStep;
        ConditionalJumpUntilStep uJumpStep;
        boolean hasCounter;
        boolean isWhile;
    }
    protected Stack loop_statement_stack = new Stack();

    public static class loop_statement_return extends TreeRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "loop_statement"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1571:1: loop_statement : REPEAT ( (expr= root_expression TIMES ) | ( ( WHILE | UNTIL ) expr= root_expression ) ) block[true] END ;
    public final QuorumTreeWalker.loop_statement_return loop_statement() throws RecognitionException {
        loop_statement_stack.push(new loop_statement_scope());
        QuorumTreeWalker.loop_statement_return retval = new QuorumTreeWalker.loop_statement_return();
        retval.start = input.LT(1);

        CommonTree REPEAT24=null;
        CommonTree TIMES25=null;
        CommonTree END26=null;
        QuorumTreeWalker.root_expression_return expr = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1590:2: ( REPEAT ( (expr= root_expression TIMES ) | ( ( WHILE | UNTIL ) expr= root_expression ) ) block[true] END )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1591:2: REPEAT ( (expr= root_expression TIMES ) | ( ( WHILE | UNTIL ) expr= root_expression ) ) block[true] END
            {
            REPEAT24=(CommonTree)match(input,REPEAT,FOLLOW_REPEAT_in_loop_statement1649); 


            		((loop_statement_scope)loop_statement_stack.peek()).marker_top = (REPEAT24!=null?REPEAT24.getText():null) + labelCounter + "_top";
            		((loop_statement_scope)loop_statement_stack.peek()).marker_loop = (REPEAT24!=null?REPEAT24.getText():null) + labelCounter + "_loop";
            		((loop_statement_scope)loop_statement_stack.peek()).marker_bottom = (REPEAT24!=null?REPEAT24.getText():null) + labelCounter + "_bottom";
            		labelCounter++;
            		((loop_statement_scope)loop_statement_stack.peek()).location = new LineInformation(
            			REPEAT24.getLine(),
            			REPEAT24.getLine(),
            			REPEAT24.getCharPositionInLine(),
            			(REPEAT24!=null?REPEAT24.getText():null).length() + REPEAT24.getCharPositionInLine());
            		((loop_statement_scope)loop_statement_stack.peek()).loop_counter = null;
            		((loop_statement_scope)loop_statement_stack.peek()).jumpToTop = new JumpStep();
            		((loop_statement_scope)loop_statement_stack.peek()).jumpToTop.setType(JumpType.LOOP);
            		((loop_statement_scope)loop_statement_stack.peek()).jumpToTop.setLineInformation(((loop_statement_scope)loop_statement_stack.peek()).location);
            		symbol.addStatementFlagToCurrentFile(REPEAT24.getLine());

            		((loop_statement_scope)loop_statement_stack.peek()).first_value = null;
            		((loop_statement_scope)loop_statement_stack.peek()).first_step = null;
            		((loop_statement_scope)loop_statement_stack.peek()).last_value = null;
            		((loop_statement_scope)loop_statement_stack.peek()).last_step = null;
            		((loop_statement_scope)loop_statement_stack.peek()).type = -1;
            		((loop_statement_scope)loop_statement_stack.peek()).cJumpStep = null;
            		
            		CompilerError e = symbol.getControlFlow().addStatement(((loop_statement_scope)loop_statement_stack.peek()).location);
            	        	if (e != null) {
            	                		this.builder.getVirtualMachine().getCompilerErrors().addError(e);
            	        	}
            	        
            		symbol.getControlFlow().repeatStart();
            		
            	
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1625:2: ( (expr= root_expression TIMES ) | ( ( WHILE | UNTIL ) expr= root_expression ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==ROOT_EXPRESSION) ) {
                alt56=1;
            }
            else if ( (LA56_0==UNTIL||LA56_0==WHILE) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1655:3: (expr= root_expression TIMES )
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1655:3: (expr= root_expression TIMES )
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1655:4: expr= root_expression TIMES
                    {
                    pushFollow(FOLLOW_root_expression_in_loop_statement1722);
                    expr=root_expression();

                    state._fsp--;

                    TIMES25=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_loop_statement1724); 

                    }


                    		((loop_statement_scope)loop_statement_stack.peek()).first_value = (expr!=null?expr.eval:null);
                    		TypeDescriptor type = (expr!=null?expr.eval:null).getType();
                    		if(type == null || !type.isInteger()) {
                    			CompilerError error = new CompilerError(TIMES25.getLine(), "repeat times requires an integer.", ErrorType.REPEAT_TIMES_NON_INTEGER);
                    			vm.getCompilerErrors().addError(error);	
                    		}
                    		((loop_statement_scope)loop_statement_stack.peek()).first_step = (expr!=null?expr.step:null);
                    		((loop_statement_scope)loop_statement_stack.peek()).loop_counter = stepFactory.addLoopCounter(temp,((loop_statement_scope)loop_statement_stack.peek()).location);
                    		builder.addLabel(((loop_statement_scope)loop_statement_stack.peek()).jumpToTop);
                    		temp = ((loop_statement_scope)loop_statement_stack.peek()).loop_counter.getNextRegister();
                    		ResultTuple jump_compare = stepFactory.addBinaryLessThanStep(temp, ((loop_statement_scope)loop_statement_stack.peek()).loop_counter.getValue(), ((loop_statement_scope)loop_statement_stack.peek()).loop_counter.getStep(),  ((loop_statement_scope)loop_statement_stack.peek()).first_value, ((loop_statement_scope)loop_statement_stack.peek()).first_step);
                    		temp = jump_compare.getNextRegister();
                    		((loop_statement_scope)loop_statement_stack.peek()).cJumpStep = new ConditionalJumpLoopStep();
                    		((loop_statement_scope)loop_statement_stack.peek()).cJumpStep.setIsEndValueKnown(true);
                    		((loop_statement_scope)loop_statement_stack.peek()).cJumpStep.setHowManyTimesRegister((expr!=null?expr.eval:null).getRegister());
                    		((loop_statement_scope)loop_statement_stack.peek()).cJumpStep.setLeftRegister(jump_compare.getValue().getRegister());
                    		((loop_statement_scope)loop_statement_stack.peek()).cJumpStep.setLineInformation(((loop_statement_scope)loop_statement_stack.peek()).location);
                    		((loop_statement_scope)loop_statement_stack.peek()).cJumpStep.setLoopType(LoopType.TIMES);
                    		builder.add(((loop_statement_scope)loop_statement_stack.peek()).cJumpStep);
                    		builder.addStepLabel(OpcodeType.TIMES, -1);
                    		builder.addMarker(((loop_statement_scope)loop_statement_stack.peek()).marker_bottom);
                    		stepFactory.addBeginScopeStep(((loop_statement_scope)loop_statement_stack.peek()).marker_loop, "loop");
                    		symbol.enterNextBlock();
                    		((loop_statement_scope)loop_statement_stack.peek()).type = 1;
                    		
                    	

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1683:4: ( ( WHILE | UNTIL ) expr= root_expression )
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1683:4: ( ( WHILE | UNTIL ) expr= root_expression )
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1683:5: ( WHILE | UNTIL ) expr= root_expression
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1683:5: ( WHILE | UNTIL )
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==WHILE) ) {
                        alt55=1;
                    }
                    else if ( (LA55_0==UNTIL) ) {
                        alt55=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 55, 0, input);

                        throw nvae;
                    }
                    switch (alt55) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1683:6: WHILE
                            {
                            match(input,WHILE,FOLLOW_WHILE_in_loop_statement1735); 
                            ((loop_statement_scope)loop_statement_stack.peek()).isWhile = true;

                            }
                            break;
                        case 2 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1683:49: UNTIL
                            {
                            match(input,UNTIL,FOLLOW_UNTIL_in_loop_statement1741); 
                            ((loop_statement_scope)loop_statement_stack.peek()).isWhile = false;

                            }
                            break;

                    }


                                   		builder.addLabel(((loop_statement_scope)loop_statement_stack.peek()).jumpToTop);
                    	
                    pushFollow(FOLLOW_root_expression_in_loop_statement1756);
                    expr=root_expression();

                    state._fsp--;


                    			((loop_statement_scope)loop_statement_stack.peek()).first_value = (expr!=null?expr.eval:null);
                    			((loop_statement_scope)loop_statement_stack.peek()).first_step = (expr!=null?expr.step:null);
                    			((loop_statement_scope)loop_statement_stack.peek()).type = 2;
                    			
                    			TypeDescriptor type = (expr!=null?expr.eval:null).getType();
                    			if(type == null || !type.isBoolean()) {
                    				CompilerError error = new CompilerError(REPEAT24.getLine(), "repeat loops require a boolean expression.", ErrorType.REPEAT_NON_BOOLEAN);
                    				vm.getCompilerErrors().addError(error);	
                    			}
                    			
                    			if(((loop_statement_scope)loop_statement_stack.peek()).isWhile){
                    				((loop_statement_scope)loop_statement_stack.peek()).cJumpStep = new ConditionalJumpLoopStep();
                    				((loop_statement_scope)loop_statement_stack.peek()).cJumpStep.setLoopType(LoopType.WHILE);
                    	
                    				((loop_statement_scope)loop_statement_stack.peek()).cJumpStep.setLeftRegister(((loop_statement_scope)loop_statement_stack.peek()).first_value.getRegister());
                    				((loop_statement_scope)loop_statement_stack.peek()).cJumpStep.setLineInformation(((loop_statement_scope)loop_statement_stack.peek()).location);
                    				builder.add(((loop_statement_scope)loop_statement_stack.peek()).cJumpStep);
                    			}else{
                    				((loop_statement_scope)loop_statement_stack.peek()).uJumpStep = new ConditionalJumpUntilStep();
                    				((loop_statement_scope)loop_statement_stack.peek()).uJumpStep.setLoopType(LoopType.UNTIL);
                    	
                    				((loop_statement_scope)loop_statement_stack.peek()).uJumpStep.setLeftRegister(((loop_statement_scope)loop_statement_stack.peek()).first_value.getRegister());
                    				((loop_statement_scope)loop_statement_stack.peek()).uJumpStep.setLineInformation(((loop_statement_scope)loop_statement_stack.peek()).location);
                    				builder.add(((loop_statement_scope)loop_statement_stack.peek()).uJumpStep);
                    			}
                    			builder.addStepLabel(OpcodeType.LOOP, -1);
                    			builder.addMarker(((loop_statement_scope)loop_statement_stack.peek()).marker_bottom);
                    			stepFactory.addBeginScopeStep(((loop_statement_scope)loop_statement_stack.peek()).marker_loop, "loop");
                    			symbol.enterNextBlock();

                    		

                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_loop_statement1767);
            block(true);

            state._fsp--;


            		stepFactory.addEndScopeStep("loop", ((loop_statement_scope)loop_statement_stack.peek()).location);
            		symbol.popScope();
            		if(((loop_statement_scope)loop_statement_stack.peek()).type == 1)
            		{
            			// move the ammount to increment to a register
            			ResultTuple inc_ammount = stepFactory.addMoveStep(temp, ((loop_statement_scope)loop_statement_stack.peek()).location, 1);
            			temp = inc_ammount.getNextRegister();
            			//add the increment ammount to the loop counter
            			ResultTuple inc_result = stepFactory.addBinaryAddStep(temp, inc_ammount.getValue(), inc_ammount.getStep(), ((loop_statement_scope)loop_statement_stack.peek()).loop_counter.getValue(), ((loop_statement_scope)loop_statement_stack.peek()).loop_counter.getStep());
            			int loopResult = temp;
            			temp = inc_result.getNextRegister();
            			//move the result to loop counters register
            			stepFactory.addMoveRegistersStep(((loop_statement_scope)loop_statement_stack.peek()).loop_counter.getValue().getRegister(), loopResult, ((loop_statement_scope)loop_statement_stack.peek()).location);
            		}
            		
            		builder.convertBackJump(((loop_statement_scope)loop_statement_stack.peek()).jumpToTop);
            		builder.add(((loop_statement_scope)loop_statement_stack.peek()).jumpToTop);
            		builder.addLabel(((loop_statement_scope)loop_statement_stack.peek()).marker_bottom);
            	
            END26=(CommonTree)match(input,END,FOLLOW_END_in_loop_statement1775); 

            		
            		symbol.getControlFlow().repeatEnd();
            		
            		indexer.append("<loop line = \"");
            		indexer.append(((loop_statement_scope)loop_statement_stack.peek()).location.getStartLine());
            		indexer.append("\" end = \"");
            		indexer.append(END26.getLine());
            		indexer.append("\"/>");
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            loop_statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "loop_statement"

    public static class selector_return extends TreeRuleReturnScope {
        public ScopeSelector scopeSel;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "selector"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1775:1: selector returns [ScopeSelector scopeSel] : ( ^( PARENT qualified_name ) | ME );
    public final QuorumTreeWalker.selector_return selector() throws RecognitionException {
        QuorumTreeWalker.selector_return retval = new QuorumTreeWalker.selector_return();
        retval.start = input.LT(1);

        CommonTree PARENT28=null;
        QuorumTreeWalker.qualified_name_return qualified_name27 = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1776:2: ( ^( PARENT qualified_name ) | ME )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==PARENT) ) {
                alt57=1;
            }
            else if ( (LA57_0==ME) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1776:4: ^( PARENT qualified_name )
                    {
                    PARENT28=(CommonTree)match(input,PARENT,FOLLOW_PARENT_in_selector1814); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_qualified_name_in_selector1816);
                    qualified_name27=qualified_name();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ScopeSelector scopeItem = new ScopeSelector();
                    		ClassDescriptor cd = symbol.findClassDescriptorFromCurrentClass((qualified_name27!=null?qualified_name27.type:null).getStaticKey());
                    		
                    		if(cd == null){
                    			CompilerError error = new CompilerError(PARENT28.getLine(), "The class "+ symbol.getCurrentClass().getStaticKey() +" does not have access to " + (qualified_name27!=null?qualified_name27.type:null).getStaticKey(), ErrorType.MISSING_PARENT);
                    			vm.getCompilerErrors().addError(error);
                    		}
                    		scopeItem.setIsParent(true);
                    		scopeItem.setCurrentClass(cd);
                    		retval.scopeSel = scopeItem;
                    	

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1789:4: ME
                    {
                    match(input,ME,FOLLOW_ME_in_selector1825); 

                    		ScopeSelector scopeItem = new ScopeSelector();
                    		scopeItem.setIsParent(false);
                    		retval.scopeSel = scopeItem;
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "selector"

    public static class root_expression_return extends TreeRuleReturnScope {
        public ExpressionValue eval;
        public ExecutionStep step;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "root_expression"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1797:1: root_expression returns [ExpressionValue eval, ExecutionStep step] : ^( ROOT_EXPRESSION expression ) ;
    public final QuorumTreeWalker.root_expression_return root_expression() throws RecognitionException {
        QuorumTreeWalker.root_expression_return retval = new QuorumTreeWalker.root_expression_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.expression_return expression29 = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1798:2: ( ^( ROOT_EXPRESSION expression ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1799:2: ^( ROOT_EXPRESSION expression )
            {

            		builder.addStepLabel(OpcodeType.ROOT_EXPRESSION, -1);
            	
            match(input,ROOT_EXPRESSION,FOLLOW_ROOT_EXPRESSION_in_root_expression1851); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_root_expression1853);
            expression29=expression();

            state._fsp--;


            match(input, Token.UP, null); 

            		expressionDepth = 0;
            		retval.eval = (expression29!=null?expression29.eval:null);
            		retval.step = (expression29!=null?expression29.step:null);
            		if(retval.eval != null){
            			retval.eval.getResult().getType().setExpressionLevel(expressionDepth );
            		}
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "root_expression"

    public static class expression_return extends TreeRuleReturnScope {
        public ExpressionValue eval;
        public ExecutionStep step;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "expression"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1813:1: expression returns [ExpressionValue eval, ExecutionStep step] : ( ^( UNARY_NOT NOT expr= expression ) | ^( EQUALITY left= expression right= expression ) | ^( NOTEQUALS left= expression right= expression ) | ^( GREATER left= expression right= expression ) | ^( GREATER_EQUAL left= expression right= expression ) | ^( INHERITS left= expression dec= class_type ) | ^( LESS left= expression right= expression ) | ^( LESS_EQUAL left= expression right= expression ) | ^( OR left= expression right= expression ) | ^( AND left= expression right= expression ) | ^( PLUS left= expression right= expression ) | ^( MINUS left= expression right= expression ) | ^( MULTIPLY left= expression right= expression ) | ^( DIVIDE left= expression right= expression ) | ^( MODULO left= expression right= expression ) | ^( FUNCTION_CALL qualified_name ( COLON ID )? LEFT_PAREN fel= function_expression_list RIGHT_PAREN ) | ^( QUALIFIED_SOLO_EXPRESSION var= qualified_name ( COLON ID )? ) | ^( QUALIFIED_SOLO_PARENT_EXPRESSON var= qualified_name COLON PARENT COLON par= qualified_name COLON ID ) | ^( QUALIFIED_SOLO_EXPRESSION_SELECTOR selector COLON qualified_name ) | ^( FUNCTION_CALL_PARENT PARENT COLON qn1= qualified_name COLON ID LEFT_PAREN fel= function_expression_list RIGHT_PAREN ) | ^( FUNCTION_CALL_THIS ME COLON qualified_name ( COLON ID )? LEFT_PAREN fel= function_expression_list RIGHT_PAREN ) | BOOLEAN | ( MINUS )? DECIMAL | ( MINUS )? INT | STRING | NULL | ME | INPUT LEFT_PAREN input_expr= expression RIGHT_PAREN | ^( PAREN_WRAPPED_EXPRESSION LEFT_PAREN expr= expression RIGHT_PAREN ) | CAST LEFT_PAREN castqn= assignment_declaration COMMA cast_expr= expression castrpn= RIGHT_PAREN );
    public final QuorumTreeWalker.expression_return expression() throws RecognitionException {
        QuorumTreeWalker.expression_return retval = new QuorumTreeWalker.expression_return();
        retval.start = input.LT(1);

        CommonTree castrpn=null;
        CommonTree ID31=null;
        CommonTree ID32=null;
        CommonTree PARENT33=null;
        CommonTree ID34=null;
        CommonTree ID37=null;
        CommonTree ID39=null;
        CommonTree BOOLEAN40=null;
        CommonTree DECIMAL41=null;
        CommonTree MINUS42=null;
        CommonTree INT43=null;
        CommonTree MINUS44=null;
        CommonTree STRING45=null;
        CommonTree NULL46=null;
        CommonTree ME47=null;
        CommonTree LEFT_PAREN48=null;
        CommonTree RIGHT_PAREN49=null;
        CommonTree CAST50=null;
        QuorumTreeWalker.expression_return expr = null;

        QuorumTreeWalker.expression_return left = null;

        QuorumTreeWalker.expression_return right = null;

        QuorumTreeWalker.class_type_return dec = null;

        QuorumTreeWalker.function_expression_list_return fel = null;

        QuorumTreeWalker.qualified_name_return var = null;

        QuorumTreeWalker.qualified_name_return par = null;

        QuorumTreeWalker.qualified_name_return qn1 = null;

        QuorumTreeWalker.expression_return input_expr = null;

        QuorumTreeWalker.assignment_declaration_return castqn = null;

        QuorumTreeWalker.expression_return cast_expr = null;

        QuorumTreeWalker.qualified_name_return qualified_name30 = null;

        QuorumTreeWalker.qualified_name_return qualified_name35 = null;

        QuorumTreeWalker.selector_return selector36 = null;

        QuorumTreeWalker.qualified_name_return qualified_name38 = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1814:2: ( ^( UNARY_NOT NOT expr= expression ) | ^( EQUALITY left= expression right= expression ) | ^( NOTEQUALS left= expression right= expression ) | ^( GREATER left= expression right= expression ) | ^( GREATER_EQUAL left= expression right= expression ) | ^( INHERITS left= expression dec= class_type ) | ^( LESS left= expression right= expression ) | ^( LESS_EQUAL left= expression right= expression ) | ^( OR left= expression right= expression ) | ^( AND left= expression right= expression ) | ^( PLUS left= expression right= expression ) | ^( MINUS left= expression right= expression ) | ^( MULTIPLY left= expression right= expression ) | ^( DIVIDE left= expression right= expression ) | ^( MODULO left= expression right= expression ) | ^( FUNCTION_CALL qualified_name ( COLON ID )? LEFT_PAREN fel= function_expression_list RIGHT_PAREN ) | ^( QUALIFIED_SOLO_EXPRESSION var= qualified_name ( COLON ID )? ) | ^( QUALIFIED_SOLO_PARENT_EXPRESSON var= qualified_name COLON PARENT COLON par= qualified_name COLON ID ) | ^( QUALIFIED_SOLO_EXPRESSION_SELECTOR selector COLON qualified_name ) | ^( FUNCTION_CALL_PARENT PARENT COLON qn1= qualified_name COLON ID LEFT_PAREN fel= function_expression_list RIGHT_PAREN ) | ^( FUNCTION_CALL_THIS ME COLON qualified_name ( COLON ID )? LEFT_PAREN fel= function_expression_list RIGHT_PAREN ) | BOOLEAN | ( MINUS )? DECIMAL | ( MINUS )? INT | STRING | NULL | ME | INPUT LEFT_PAREN input_expr= expression RIGHT_PAREN | ^( PAREN_WRAPPED_EXPRESSION LEFT_PAREN expr= expression RIGHT_PAREN ) | CAST LEFT_PAREN castqn= assignment_declaration COMMA cast_expr= expression castrpn= RIGHT_PAREN )
            int alt63=30;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1815:3: ^( UNARY_NOT NOT expr= expression )
                    {
                    match(input,UNARY_NOT,FOLLOW_UNARY_NOT_in_expression1875); 

                    match(input, Token.DOWN, null); 
                    match(input,NOT,FOLLOW_NOT_in_expression1877); 
                    pushFollow(FOLLOW_expression_in_expression1883);
                    expr=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addUnaryNotStep(temp, (expr!=null?expr.eval:null), (expr!=null?expr.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 2 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1822:4: ^( EQUALITY left= expression right= expression )
                    {
                    match(input,EQUALITY,FOLLOW_EQUALITY_in_expression1895); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1901);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1907);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryEqualsStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 3 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1829:4: ^( NOTEQUALS left= expression right= expression )
                    {
                    match(input,NOTEQUALS,FOLLOW_NOTEQUALS_in_expression1917); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1923);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1929);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryNotEqualsStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 4 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1836:4: ^( GREATER left= expression right= expression )
                    {
                    match(input,GREATER,FOLLOW_GREATER_in_expression1939); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1945);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1951);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryGreaterThanStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 5 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1843:4: ^( GREATER_EQUAL left= expression right= expression )
                    {
                    match(input,GREATER_EQUAL,FOLLOW_GREATER_EQUAL_in_expression1961); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1967);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression1973);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryGreaterEqualsStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 6 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1850:4: ^( INHERITS left= expression dec= class_type )
                    {
                    match(input,INHERITS,FOLLOW_INHERITS_in_expression1983); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression1987);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_class_type_in_expression1991);
                    dec=class_type();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryIsAStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (dec!=null?dec.myType:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 7 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1857:4: ^( LESS left= expression right= expression )
                    {
                    match(input,LESS,FOLLOW_LESS_in_expression2001); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2007);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2013);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryLessThanStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 8 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1864:4: ^( LESS_EQUAL left= expression right= expression )
                    {
                    match(input,LESS_EQUAL,FOLLOW_LESS_EQUAL_in_expression2023); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2029);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2035);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryLessEqualsStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 9 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1871:4: ^( OR left= expression right= expression )
                    {
                    match(input,OR,FOLLOW_OR_in_expression2045); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2051);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2057);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryOrStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 10 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1878:4: ^( AND left= expression right= expression )
                    {
                    match(input,AND,FOLLOW_AND_in_expression2067); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2073);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2079);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryAndStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 11 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1885:4: ^( PLUS left= expression right= expression )
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_expression2089); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2095);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2101);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryAddStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 12 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1892:4: ^( MINUS left= expression right= expression )
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_expression2111); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2117);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2123);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinarySubtractStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 13 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1899:4: ^( MULTIPLY left= expression right= expression )
                    {
                    match(input,MULTIPLY,FOLLOW_MULTIPLY_in_expression2133); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2139);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2145);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryMultiplyStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 14 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1906:4: ^( DIVIDE left= expression right= expression )
                    {
                    match(input,DIVIDE,FOLLOW_DIVIDE_in_expression2155); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2161);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2167);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryDivideStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 15 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1913:4: ^( MODULO left= expression right= expression )
                    {
                    match(input,MODULO,FOLLOW_MODULO_in_expression2177); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression2183);
                    left=expression();

                    state._fsp--;

                    pushFollow(FOLLOW_expression_in_expression2189);
                    right=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		ResultTuple result = stepFactory.addBinaryModStep(temp, (left!=null?left.eval:null), (left!=null?left.step:null), (right!=null?right.eval:null), (right!=null?right.step:null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    	

                    }
                    break;
                case 16 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1920:4: ^( FUNCTION_CALL qualified_name ( COLON ID )? LEFT_PAREN fel= function_expression_list RIGHT_PAREN )
                    {
                    match(input,FUNCTION_CALL,FOLLOW_FUNCTION_CALL_in_expression2199); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_qualified_name_in_expression2201);
                    qualified_name30=qualified_name();

                    state._fsp--;

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1920:34: ( COLON ID )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==COLON) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:1920:35: COLON ID
                            {
                            match(input,COLON,FOLLOW_COLON_in_expression2203); 
                            ID31=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2205); 

                            }
                            break;

                    }

                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_expression2209); 

                    		boolean unsetFlag = false;
                    		boolean nested = inCallStep;
                    		if (!inCallStep) {
                    			// We are now inside a call step--set the flag appropriately.
                    			inCallStep = true;
                    			unsetFlag = true;
                    		}
                    		 expressionDepth++;
                    	
                    pushFollow(FOLLOW_function_expression_list_in_expression2221);
                    fel=function_expression_list();

                    state._fsp--;

                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_expression2223); 

                    match(input, Token.UP, null); 
                    	
                    								//Dog.walk(50) should be dissallowed during semantic analysis
                    		LineInformation location = new LineInformation();
                                    location.setEndColumn((qualified_name30!=null?qualified_name30.type:null).getColumnEnd());
                                    location.setEndLine((qualified_name30!=null?qualified_name30.type:null).getLineEnd());
                                    location.setStartColumn((qualified_name30!=null?qualified_name30.type:null).getColumnBegin());
                                    location.setStartLine((qualified_name30!=null?qualified_name30.type:null).getLineBegin());
                                    location.setFile(fileName);
                                    location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    MethodDescriptor curMethod = symbol.getCurrentMethod();
                                    if(curMethod != null){
                                    	location.setMethodName(curMethod.getStaticKey());
                                    }
                                    
                    		Vector<ExecutionStep> steps = new Vector<ExecutionStep>();
                    		Vector<ExpressionValue> values = new Vector<ExpressionValue>();
                    		Vector<Integer> registers = new Vector<Integer>();

                    		Vector<TypeDescriptor> types = new Vector<TypeDescriptor>();
                    		Vector<TypeDescriptor> argumentTypes = new Vector<TypeDescriptor>();
                    		
                    		int parameterPosition = -1;
                    		if(fel != null) {
                    			parameterPosition = (fel!=null?fel.firstParam:0);
                    			for(Object o : (fel!=null?fel.list:null)) {
                    				expression_return ex = (expression_return)o;
                                    		types.add(ex.eval.getType());
                                    		argumentTypes.add(ex.eval.getType());
                                    		steps.add(ex.step);
                                    		values.add(ex.eval);
                                    		registers.add(ex.eval.getRegister());
                    			}
                    		}
                    		
                                    String key = "";
                                    String myMethodName = "";
                                    if(ID31 == null) {
                                    	key = MethodDescriptor.autoGenerateKey((qualified_name30!=null?qualified_name30.type:null).getStaticKey(), types);
                                    	myMethodName = (qualified_name30!=null?qualified_name30.type:null).getStaticKey();
                    		}
                    		else {
                    			key = MethodDescriptor.autoGenerateKey((ID31!=null?ID31.getText():null), types);
                    			myMethodName = (ID31!=null?ID31.getText():null);
                    		}
                    		CallInfo info = new CallInfo();
                    		info.register = temp;
                    		info.location = location;
                    		info.argumentRegisters = registers;
                    		info.argumentSteps = steps;
                    		info.variable = (qualified_name30!=null?qualified_name30.type:null);
                    		info.argumentTypes = argumentTypes;
                    		info.methodName = myMethodName;
                    		info.isObjectCall = (ID31 != null);
                    		info.isNested = nested;
                    		
                    		if(fel!=null && !(fel!=null?fel.list:null).isEmpty()){
                    			builder.addCallLabel(parameterPosition);
                    			//j builder.addStepLabel(OpcodeType.METHOD_CALL);
                    		}
                    		
                    		ResultTuple result =  stepFactory.addCallStep(info);
                    		
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		
                    		expressionDepth--;
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    		if(fel!=null){
                    			builder.addStepLabel(OpcodeType.METHOD_CALL, result.getStepCount());
                    		}
                    		
                    		if (unsetFlag)
                    			inCallStep = false;

                    	

                    }
                    break;
                case 17 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2008:4: ^( QUALIFIED_SOLO_EXPRESSION var= qualified_name ( COLON ID )? )
                    {
                    match(input,QUALIFIED_SOLO_EXPRESSION,FOLLOW_QUALIFIED_SOLO_EXPRESSION_in_expression2234); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_qualified_name_in_expression2238);
                    var=qualified_name();

                    state._fsp--;

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2008:51: ( COLON ID )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==COLON) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2008:52: COLON ID
                            {
                            match(input,COLON,FOLLOW_COLON_in_expression2241); 
                            ID32=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2243); 

                            }
                            break;

                    }


                    match(input, Token.UP, null); 

                    		LineInformation location = new LineInformation (
                    			(var!=null?var.type:null).getLineBegin(),
                    			(var!=null?var.type:null).getLineEnd(),
                    			(var!=null?var.type:null).getColumnBegin(),
                    			(var!=null?var.type:null).getColumnEnd()
                    		);
                    		location.setFile(fileName);
                                    location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    MethodDescriptor curMethod = symbol.getCurrentMethod();
                                    if(curMethod != null){
                                    	location.setMethodName(curMethod.getStaticKey());
                                    }

                    		ResultTuple result = new ResultTuple();
                    		ClassDescriptor cd = null;
                    		
                    		if(ID32 != null){
                    			result = stepFactory.addVariableInObjectMoveStep(location, null, null, temp, (var!=null?var.type:null), (ID32!=null?ID32.getText():null), null);
                    		}else{
                    			result = stepFactory.addVariableMoveStep(location, null, null, temp, (var!=null?var.type:null));
                    		}

                    		temp++;
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);


                    	

                    }
                    break;
                case 18 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2039:4: ^( QUALIFIED_SOLO_PARENT_EXPRESSON var= qualified_name COLON PARENT COLON par= qualified_name COLON ID )
                    {
                    match(input,QUALIFIED_SOLO_PARENT_EXPRESSON,FOLLOW_QUALIFIED_SOLO_PARENT_EXPRESSON_in_expression2255); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_qualified_name_in_expression2259);
                    var=qualified_name();

                    state._fsp--;

                    match(input,COLON,FOLLOW_COLON_in_expression2261); 
                    PARENT33=(CommonTree)match(input,PARENT,FOLLOW_PARENT_in_expression2263); 
                    match(input,COLON,FOLLOW_COLON_in_expression2265); 
                    pushFollow(FOLLOW_qualified_name_in_expression2269);
                    par=qualified_name();

                    state._fsp--;

                    match(input,COLON,FOLLOW_COLON_in_expression2271); 
                    ID34=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2273); 

                    match(input, Token.UP, null); 

                    		LineInformation location = new LineInformation (
                    			(var!=null?var.type:null).getLineBegin(),
                    			(var!=null?var.type:null).getLineEnd(),
                    			(var!=null?var.type:null).getColumnBegin(),
                    			(var!=null?var.type:null).getColumnEnd()
                    		);
                    		location.setFile(fileName);
                                    location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    MethodDescriptor curMethod = symbol.getCurrentMethod();
                                    if(curMethod != null){
                                    	location.setMethodName(curMethod.getStaticKey());
                                    }

                    		ResultTuple result = new ResultTuple();
                    		ClassDescriptor cd = null;
                    		
                    		if((par!=null?par.type:null) != null){
                    			cd = symbol.findClassDescriptorFromCurrentClass((par!=null?par.type:null).getStaticKey());
                    			
                    			if(cd == null){
                    				CompilerError error = new CompilerError(PARENT33.getLine(), "The class "+ symbol.getCurrentClass().getStaticKey() +" does not have access to " + (par!=null?par.type:null).getStaticKey(), ErrorType.MISSING_PARENT);
                    				vm.getCompilerErrors().addError(error);
                    			}
                    		}
                    		
                    		if(ID34 != null){
                    			result = stepFactory.addVariableInObjectMoveStep(location, null, null, temp, (var!=null?var.type:null), (ID34!=null?ID34.getText():null), cd);
                    		}else{
                    			result = stepFactory.addVariableMoveStep(location, null, null, temp, (var!=null?var.type:null));
                    		}

                    		temp++;
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    	

                    }
                    break;
                case 19 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2077:4: ^( QUALIFIED_SOLO_EXPRESSION_SELECTOR selector COLON qualified_name )
                    {
                    match(input,QUALIFIED_SOLO_EXPRESSION_SELECTOR,FOLLOW_QUALIFIED_SOLO_EXPRESSION_SELECTOR_in_expression2283); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_selector_in_expression2285);
                    selector36=selector();

                    state._fsp--;

                    match(input,COLON,FOLLOW_COLON_in_expression2287); 
                    pushFollow(FOLLOW_qualified_name_in_expression2289);
                    qualified_name35=qualified_name();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    		LineInformation location = new LineInformation (
                    			(qualified_name35!=null?qualified_name35.type:null).getLineBegin(),
                    			(qualified_name35!=null?qualified_name35.type:null).getLineEnd(),
                    			(qualified_name35!=null?qualified_name35.type:null).getColumnBegin(),
                    			(qualified_name35!=null?qualified_name35.type:null).getColumnEnd()
                    		);
                    		location.setFile(fileName);
                                    location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    MethodDescriptor curMethod = symbol.getCurrentMethod();
                                    if(curMethod != null){
                                    	location.setMethodName(curMethod.getStaticKey());
                                    }
                    		
                    		ResultTuple result = new ResultTuple();
                    		ScopeSelector scope = (selector36!=null?selector36.scopeSel:null);
                    		
                    		if(!scope.isParent()){
                    			result = stepFactory.addMeVariableMoveStep(location, null, null, temp, (qualified_name35!=null?qualified_name35.type:null));
                    		} else{
                    			result = stepFactory.addParentVariableMoveStep(location, null, null, temp, (qualified_name35!=null?qualified_name35.type:null), scope.getCurrentClass());
                    		}
                    		temp++;
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    		
                    	

                    }
                    break;
                case 20 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2107:4: ^( FUNCTION_CALL_PARENT PARENT COLON qn1= qualified_name COLON ID LEFT_PAREN fel= function_expression_list RIGHT_PAREN )
                    {
                    match(input,FUNCTION_CALL_PARENT,FOLLOW_FUNCTION_CALL_PARENT_in_expression2301); 

                    match(input, Token.DOWN, null); 
                    match(input,PARENT,FOLLOW_PARENT_in_expression2303); 
                    match(input,COLON,FOLLOW_COLON_in_expression2305); 
                    pushFollow(FOLLOW_qualified_name_in_expression2309);
                    qn1=qualified_name();

                    state._fsp--;

                    match(input,COLON,FOLLOW_COLON_in_expression2311); 
                    ID37=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2313); 
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_expression2315); 

                    		boolean unsetFlag = false;
                    		boolean nested = inCallStep;
                    		if (!inCallStep) {
                    			// We are now inside a call step--set the flag appropriately.
                    			inCallStep = true;
                    			unsetFlag = true;
                    		}
                    		expressionDepth++;
                    	
                    pushFollow(FOLLOW_function_expression_list_in_expression2326);
                    fel=function_expression_list();

                    state._fsp--;

                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_expression2328); 

                    match(input, Token.UP, null); 

                    		LineInformation location = new LineInformation();
                                    location.setEndColumn((qn1!=null?qn1.type:null).getColumnEnd());
                                    location.setEndLine((qn1!=null?qn1.type:null).getLineEnd());
                                    location.setStartColumn((qn1!=null?qn1.type:null).getColumnBegin());
                                    location.setStartLine((qn1!=null?qn1.type:null).getLineBegin());
                                    location.setFile(fileName);
                                    location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    MethodDescriptor curMethod = symbol.getCurrentMethod();
                                    if(curMethod != null){
                                    	location.setMethodName(curMethod.getStaticKey());
                                    }

                    		Vector<ExecutionStep> steps = new Vector<ExecutionStep>();
                    		Vector<ExpressionValue> values = new Vector<ExpressionValue>();
                    		Vector<Integer> registers = new Vector<Integer>();

                    		Vector<String> types = new Vector<String>();
                    		Vector<TypeDescriptor> argumentTypes = new Vector<TypeDescriptor>();
                    		
                    		int parameterPosition = -1;
                    		if(fel != null) {
                    			parameterPosition = (fel!=null?fel.firstParam:0);
                    			for(Object o : (fel!=null?fel.list:null)) {
                    				expression_return ex = (expression_return)o;
                                    		types.add(ex.eval.getType().getName());
                                    		argumentTypes.add(ex.eval.getType());
                                    		steps.add(ex.step);
                                    		values.add(ex.eval);
                                    		registers.add(ex.eval.getRegister());
                    			
                    			}
                    		}

                    		String key = MethodDescriptor.generateKey((ID37!=null?ID37.getText():null), types);
                    		String myMethodName = (ID37!=null?ID37.getText():null);
                    		
                    		CallInfo info = new CallInfo();
                    		info.register = temp;
                    		info.location = location;
                    		info.locatedIn = (qn1!=null?qn1.type:null).getStaticKey();
                    		info.argumentRegisters = registers;
                    		info.argumentSteps = steps;
                    		info.argumentTypes = argumentTypes;
                    		info.methodName = myMethodName;
                    		info.isObjectCall = false;
                    		info.isNested = nested;
                    		
                    		if(fel!=null && !(fel!=null?fel.list:null).isEmpty()){
                    			builder.addCallLabel(parameterPosition);
                    			//j builder.addStepLabel(OpcodeType.METHOD_CALL);
                    		}
                    		
                    		ResultTuple result =  stepFactory.addParentCallStep(info);
                    		
                    		temp = result.getNextRegister();
                    		expressionDepth--;
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    		if(fel!=null){
                    			builder.addStepLabel(OpcodeType.METHOD_CALL, result.getStepCount());
                    		}
                    		
                    		if (unsetFlag)
                    			inCallStep = false;
                    		
                    		
                    	

                    }
                    break;
                case 21 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2189:4: ^( FUNCTION_CALL_THIS ME COLON qualified_name ( COLON ID )? LEFT_PAREN fel= function_expression_list RIGHT_PAREN )
                    {
                    match(input,FUNCTION_CALL_THIS,FOLLOW_FUNCTION_CALL_THIS_in_expression2338); 

                    match(input, Token.DOWN, null); 
                    match(input,ME,FOLLOW_ME_in_expression2340); 
                    match(input,COLON,FOLLOW_COLON_in_expression2342); 
                    pushFollow(FOLLOW_qualified_name_in_expression2344);
                    qualified_name38=qualified_name();

                    state._fsp--;

                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2189:49: ( COLON ID )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==COLON) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2189:50: COLON ID
                            {
                            match(input,COLON,FOLLOW_COLON_in_expression2347); 
                            ID39=(CommonTree)match(input,ID,FOLLOW_ID_in_expression2349); 

                            }
                            break;

                    }

                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_expression2353); 

                    		boolean unsetFlag = false;
                    		boolean nested = inCallStep;
                    		if (!inCallStep) {
                    			// We are now inside a call step--set the flag appropriately.
                    			inCallStep = true;
                    			unsetFlag = true;
                    		}
                    		expressionDepth++;
                    	
                    pushFollow(FOLLOW_function_expression_list_in_expression2364);
                    fel=function_expression_list();

                    state._fsp--;

                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_expression2366); 

                    match(input, Token.UP, null); 

                    		LineInformation location = new LineInformation();
                                    location.setEndColumn((qualified_name38!=null?qualified_name38.type:null).getColumnEnd());
                                    location.setEndLine((qualified_name38!=null?qualified_name38.type:null).getLineEnd());
                                    location.setStartColumn((qualified_name38!=null?qualified_name38.type:null).getColumnBegin());
                                    location.setStartLine((qualified_name38!=null?qualified_name38.type:null).getLineBegin());
                                    location.setFile(fileName);
                                    location.setClassName(symbol.getCurrentClass().getStaticKey());
                                    MethodDescriptor curMethod = symbol.getCurrentMethod();
                                    if(curMethod != null){
                                    	location.setMethodName(curMethod.getStaticKey());
                                    }

                    		Vector<ExecutionStep> steps = new Vector<ExecutionStep>();
                    		Vector<ExpressionValue> values = new Vector<ExpressionValue>();
                    		Vector<Integer> registers = new Vector<Integer>();

                    		Vector<String> types = new Vector<String>();
                    		Vector<TypeDescriptor> argumentTypes = new Vector<TypeDescriptor>();
                    		
                    		int parameterPosition = -1;
                    		if(fel != null) {
                    			parameterPosition = (fel!=null?fel.firstParam:0);
                    			for(Object o : (fel!=null?fel.list:null)) {
                    				expression_return ex = (expression_return)o;
                                    		types.add(ex.eval.getType().getName());
                                    		argumentTypes.add(ex.eval.getType());
                                    		steps.add(ex.step);
                                    		values.add(ex.eval);
                                    		registers.add(ex.eval.getRegister());
                    			
                    			}
                    		}

                    		String key = "";
                                    String myMethodName = "";
                                    if(ID39 == null) {
                                    	key = MethodDescriptor.generateKey((qualified_name38!=null?qualified_name38.type:null).getStaticKey(), types);
                                    	myMethodName = (qualified_name38!=null?qualified_name38.type:null).getStaticKey();
                    		}
                    		else {
                    			key = MethodDescriptor.generateKey((ID39!=null?ID39.getText():null), types);
                    			myMethodName = (ID39!=null?ID39.getText():null);
                    		}

                    		CallInfo info = new CallInfo();
                    		info.register = temp;
                    		info.location = location;
                    		info.argumentRegisters = registers;
                    		info.argumentSteps = steps;
                    		info.variable = (qualified_name38!=null?qualified_name38.type:null);
                    		info.argumentTypes = argumentTypes;
                    		info.methodName = myMethodName;
                    		info.isObjectCall = (ID39!=null);
                    		info.isThisCall = true;
                    		info.isNested = nested;
                    		
                    		if(fel!=null && !(fel!=null?fel.list:null).isEmpty()){
                    			builder.addCallLabel(parameterPosition);
                    		}
                    		
                    		ResultTuple result =  stepFactory.addCallStep(info);
                    		
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		
                    		expressionDepth--;
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    		if(fel!=null){
                    			builder.addStepLabel(OpcodeType.METHOD_CALL, result.getStepCount());
                    		}
                    		
                    		if (unsetFlag)
                    			inCallStep = false;
                    	

                    }
                    break;
                case 22 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2277:4: BOOLEAN
                    {
                    BOOLEAN40=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_expression2375); 

                    		LineInformation location = new LineInformation (
                    			BOOLEAN40.getLine(),
                    			BOOLEAN40.getLine(),
                    			BOOLEAN40.getCharPositionInLine(),
                    			BOOLEAN40.getCharPositionInLine() + (BOOLEAN40!=null?BOOLEAN40.getText():null).length()
                    		);
                    		location.setFile(fileName);
                    		
                    		ResultTuple result = stepFactory.addMoveStep(temp, location, Boolean.parseBoolean((BOOLEAN40!=null?BOOLEAN40.getText():null)));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    	

                    }
                    break;
                case 23 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2293:4: ( MINUS )? DECIMAL
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2293:4: ( MINUS )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==MINUS) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2293:5: MINUS
                            {
                            MINUS42=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expression2384); 

                            }
                            break;

                    }

                    DECIMAL41=(CommonTree)match(input,DECIMAL,FOLLOW_DECIMAL_in_expression2388); 

                    		LineInformation location = new LineInformation (
                    			DECIMAL41.getLine(),
                    			DECIMAL41.getLine(),
                    			DECIMAL41.getCharPositionInLine(),
                    			DECIMAL41.getCharPositionInLine() + (DECIMAL41!=null?DECIMAL41.getText():null).length()
                    		);
                    		location.setFile(fileName);
                    		
                    		double val = -1;
                    		try{
                    			val = Double.parseDouble((DECIMAL41!=null?DECIMAL41.getText():null));
                    		}catch(NumberFormatException e){
                    			CompilerError error = new CompilerError();
                    			error.setLineNumber(DECIMAL41.getLine());
                    			error.setError((DECIMAL41!=null?DECIMAL41.getText():null) + " is an invalid number.");
                    			error.setErrorType(ErrorType.INCOMPATIBLE_TYPES);
                    			error.setColumn(DECIMAL41.getCharPositionInLine());
                    			error.setFile(getGrammarFileNameNoExtension());
                    			vm.getCompilerErrors().addError(error);
                    		}
                    		
                    		if(MINUS42 != null) {
                    			val *= -1;
                    		}
                    		ResultTuple result = stepFactory.addMoveStep(temp, location, val);
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    	

                    }
                    break;
                case 24 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2325:4: ( MINUS )? INT
                    {
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2325:4: ( MINUS )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==MINUS) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2325:5: MINUS
                            {
                            MINUS44=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expression2397); 

                            }
                            break;

                    }

                    INT43=(CommonTree)match(input,INT,FOLLOW_INT_in_expression2401); 

                    		LineInformation location = new LineInformation (
                    			INT43.getLine(),
                    			INT43.getLine(),
                    			INT43.getCharPositionInLine(),
                    			INT43.getCharPositionInLine() + (INT43!=null?INT43.getText():null).length()
                    		);
                    		location.setFile(fileName);
                    		int val = -1;
                    		try{
                    			val = Integer.parseInt((INT43!=null?INT43.getText():null));
                    		}catch(NumberFormatException e){
                    			CompilerError error = new CompilerError();
                    			error.setLineNumber(INT43.getLine());
                    			error.setError("The integer " + (INT43!=null?INT43.getText():null) + " is not valid. All integers must be between the range of -2,147,483,648 and 2,147,483,647");
                    			error.setErrorType(ErrorType.INCOMPATIBLE_TYPES);
                    			error.setColumn(INT43.getCharPositionInLine());
                    			error.setFile(getGrammarFileNameNoExtension());
                    			vm.getCompilerErrors().addError(error);
                    		}
                    		if(MINUS44 != null) {
                    			val *= -1;
                    		}
                    		ResultTuple result = stepFactory.addMoveStep(temp, location, val);
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    	

                    }
                    break;
                case 25 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2355:4: STRING
                    {
                    STRING45=(CommonTree)match(input,STRING,FOLLOW_STRING_in_expression2409); 

                    		LineInformation location = new LineInformation (
                    			STRING45.getLine(),
                    			STRING45.getLine(),
                    			STRING45.getCharPositionInLine(),
                    			STRING45.getCharPositionInLine() + (STRING45!=null?STRING45.getText():null).length()
                    		);
                    		location.setFile(fileName);
                    		ResultTuple result = stepFactory.addMoveStep(temp, location, (STRING45!=null?STRING45.getText():null));
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    	

                    }
                    break;
                case 26 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2370:4: NULL
                    {
                    NULL46=(CommonTree)match(input,NULL,FOLLOW_NULL_in_expression2417); 

                    		LineInformation location = new LineInformation (
                    			NULL46.getLine(),
                    			NULL46.getLine(),
                    			NULL46.getCharPositionInLine(),
                    			NULL46.getCharPositionInLine() + (NULL46!=null?NULL46.getText():null).length()
                    		);
                    		location.setFile(fileName);
                    		ResultTuple result = stepFactory.addMoveNullStep(temp, location);
                    		temp = result.getNextRegister();
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    	

                    }
                    break;
                case 27 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2385:4: ME
                    {
                    ME47=(CommonTree)match(input,ME,FOLLOW_ME_in_expression2425); 

                    		LineInformation location = new LineInformation (
                    			ME47.getLine(),
                    			ME47.getLine(),
                    			ME47.getCharPositionInLine(),
                    			ME47.getCharPositionInLine() + (ME47!=null?ME47.getText():null).length()
                    		);
                    		location.setFile(fileName);
                    		
                    		ResultTuple result = new ResultTuple();

                    		result = stepFactory.addMoveThisStep(location, temp);

                    		temp++;
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    	

                    }
                    break;
                case 28 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2404:4: INPUT LEFT_PAREN input_expr= expression RIGHT_PAREN
                    {
                    match(input,INPUT,FOLLOW_INPUT_in_expression2433); 
                    inCallStep = true; int parameterPosition = builder.addParameterLabel();
                    LEFT_PAREN48=(CommonTree)match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_expression2436); 
                    expressionDepth++;
                    pushFollow(FOLLOW_expression_in_expression2442);
                    input_expr=expression();

                    state._fsp--;

                    RIGHT_PAREN49=(CommonTree)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_expression2444); 

                    		LineInformation location = new LineInformation (
                    			LEFT_PAREN48.getLine(),
                    			RIGHT_PAREN49.getLine(),
                    			LEFT_PAREN48.getCharPositionInLine(),
                    			RIGHT_PAREN49.getCharPositionInLine()
                    		);
                    		location.setFile(fileName);
                    		
                    				ExecutionStep step = (input_expr!=null?input_expr.step:null);
                    		ExpressionValue value = (input_expr!=null?input_expr.eval:null);

                    		builder.addCallLabel(parameterPosition);
                    		ResultTuple result = stepFactory.addInputStep(location, value, step, temp);
                    		
                    		temp = result.getNextRegister();
                    		expressionDepth--;
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		inCallStep = false;
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    	

                    }
                    break;
                case 29 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2427:3: ^( PAREN_WRAPPED_EXPRESSION LEFT_PAREN expr= expression RIGHT_PAREN )
                    {
                    match(input,PAREN_WRAPPED_EXPRESSION,FOLLOW_PAREN_WRAPPED_EXPRESSION_in_expression2452); 

                    match(input, Token.DOWN, null); 
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_expression2454); 
                    pushFollow(FOLLOW_expression_in_expression2458);
                    expr=expression();

                    state._fsp--;

                    match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_expression2460); 

                    match(input, Token.UP, null); 
                    retval.eval = (expr!=null?expr.eval:null); retval.step = (expr!=null?expr.step:null);

                    }
                    break;
                case 30 :
                    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2428:4: CAST LEFT_PAREN castqn= assignment_declaration COMMA cast_expr= expression castrpn= RIGHT_PAREN
                    {
                    CAST50=(CommonTree)match(input,CAST,FOLLOW_CAST_in_expression2467); 
                    match(input,LEFT_PAREN,FOLLOW_LEFT_PAREN_in_expression2469); 
                    pushFollow(FOLLOW_assignment_declaration_in_expression2473);
                    castqn=assignment_declaration();

                    state._fsp--;

                    match(input,COMMA,FOLLOW_COMMA_in_expression2475); 
                    expressionDepth++;
                    pushFollow(FOLLOW_expression_in_expression2480);
                    cast_expr=expression();

                    state._fsp--;

                    castrpn=(CommonTree)match(input,RIGHT_PAREN,FOLLOW_RIGHT_PAREN_in_expression2484); 

                    		LineInformation location = new LineInformation (
                    			CAST50.getLine(),
                    			castrpn.getLine(),
                    			CAST50.getCharPositionInLine(),
                    			castrpn.getCharPositionInLine()
                    		);
                    		location.setFile(fileName);
                    		TypeDescriptor type = (castqn!=null?castqn.myType:null);
                    		ExecutionStep step = (cast_expr!=null?cast_expr.step:null);
                    		ExpressionValue value = (cast_expr!=null?cast_expr.eval:null);
                    		
                    		ResultTuple result = stepFactory.addCastStep(location, type, value, step, temp);
                    		
                    		temp = result.getNextRegister();
                    		expressionDepth--;
                    		retval.eval = result.getValue();
                    		retval.step = result.getStep();
                    		retval.eval.getResult().getType().setExpressionLevel(expressionDepth);
                    	

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class function_expression_list_return extends TreeRuleReturnScope {
        public List list;
        public int firstParam;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "function_expression_list"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2451:1: function_expression_list returns [List list, int firstParam] : ^( FUNCTION_EXPRESSION_LIST (e= expression )* ) ;
    public final QuorumTreeWalker.function_expression_list_return function_expression_list() throws RecognitionException {
        QuorumTreeWalker.function_expression_list_return retval = new QuorumTreeWalker.function_expression_list_return();
        retval.start = input.LT(1);

        QuorumTreeWalker.expression_return e = null;


        retval.list = new ArrayList(); retval.firstParam = -1;int startLocation = 0;
        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2453:2: ( ^( FUNCTION_EXPRESSION_LIST (e= expression )* ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2454:2: ^( FUNCTION_EXPRESSION_LIST (e= expression )* )
            {
            match(input,FUNCTION_EXPRESSION_LIST,FOLLOW_FUNCTION_EXPRESSION_LIST_in_function_expression_list2508); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2454:29: (e= expression )*
                loop64:
                do {
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==AND||LA64_0==BOOLEAN||LA64_0==CAST||LA64_0==DECIMAL||LA64_0==DIVIDE||LA64_0==EQUALITY||(LA64_0>=FUNCTION_CALL && LA64_0<=FUNCTION_CALL_THIS)||(LA64_0>=GREATER && LA64_0<=GREATER_EQUAL)||(LA64_0>=INHERITS && LA64_0<=INPUT)||LA64_0==INT||(LA64_0>=LESS && LA64_0<=MULTIPLY)||LA64_0==NOTEQUALS||LA64_0==NULL||LA64_0==OR||LA64_0==PAREN_WRAPPED_EXPRESSION||LA64_0==PLUS||(LA64_0>=QUALIFIED_SOLO_EXPRESSION && LA64_0<=QUALIFIED_SOLO_PARENT_EXPRESSON)||LA64_0==STRING||LA64_0==UNARY_NOT) ) {
                        alt64=1;
                    }


                    switch (alt64) {
                	case 1 :
                	    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2455:2: e= expression
                	    {

                	    		if(retval.list.size() >= 1){
                	    			inCallStep = false;
                	    		}
                	    		if(retval.list.size() == 0){
                	    			retval.firstParam = builder.addParameterLabel();
                	    		}
                	    		if(builder.getCurrentMethod() != null){startLocation = builder.getCurrentMethod().getSteps().size();}
                	    	
                	    pushFollow(FOLLOW_expression_in_function_expression_list2520);
                	    e=expression();

                	    state._fsp--;


                	    		if(builder.getCurrentMethod() != null && builder.getCurrentMethod().getSteps().size() != 0 && startLocation < builder.getCurrentMethod().getSteps().size()){
                	    				builder.getCurrentMethod().getSteps().get(startLocation).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                	    				(e!=null?e.step:null).setExpressionEndPosition(builder.getCurrentMethod().getSteps().size() - 1);
                	    		}
                	    		retval.list.add(e);
                	    	

                	    }
                	    break;

                	default :
                	    break loop64;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "function_expression_list"

    public static class formal_parameter_return extends TreeRuleReturnScope {
        public TypeDescriptor type;
        public String name;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "formal_parameter"
    // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2475:1: formal_parameter returns [TypeDescriptor type, String name] : ^( FPARAM ad= assignment_declaration ID ) ;
    public final QuorumTreeWalker.formal_parameter_return formal_parameter() throws RecognitionException {
        QuorumTreeWalker.formal_parameter_return retval = new QuorumTreeWalker.formal_parameter_return();
        retval.start = input.LT(1);

        CommonTree ID51=null;
        QuorumTreeWalker.assignment_declaration_return ad = null;


        try {
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2476:2: ( ^( FPARAM ad= assignment_declaration ID ) )
            // /Users/Melissa/NetBeansProjects/quorum/quorum/src/org/quorum/parser/QuorumTreeWalker.g:2476:6: ^( FPARAM ad= assignment_declaration ID )
            {
            match(input,FPARAM,FOLLOW_FPARAM_in_formal_parameter2549); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_assignment_declaration_in_formal_parameter2553);
            ad=assignment_declaration();

            state._fsp--;

            ID51=(CommonTree)match(input,ID,FOLLOW_ID_in_formal_parameter2555); 

            match(input, Token.UP, null); 
            	
            		retval.type = (ad!=null?ad.myType:null);
            		retval.name = (ID51!=null?ID51.getText():null);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "formal_parameter"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA63 dfa63 = new DFA63(this);
    static final String DFA4_eotS =
        "\24\uffff";
    static final String DFA4_eofS =
        "\24\uffff";
    static final String DFA4_minS =
        "\1\4\2\113\1\uffff\2\2\2\51\2\3\1\51\1\4\1\51\1\4\1\3\2\uffff\1"+
        "\3\2\uffff";
    static final String DFA4_maxS =
        "\1\137\2\113\1\uffff\2\2\2\51\2\107\1\51\1\137\1\51\1\137\1\107"+
        "\2\uffff\1\107\2\uffff";
    static final String DFA4_acceptS =
        "\3\uffff\1\5\13\uffff\1\3\1\1\1\uffff\1\2\1\4";
    static final String DFA4_specialS =
        "\24\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\3\2\uffff\1\3\1\uffff\1\3\2\uffff\2\3\3\uffff\1\3\26\uffff"+
            "\2\3\4\uffff\1\3\4\uffff\1\3\3\uffff\1\3\5\uffff\2\3\1\uffff"+
            "\1\3\1\uffff\1\1\1\3\4\uffff\3\3\3\uffff\2\3\4\uffff\4\3\2\uffff"+
            "\1\3\3\uffff\1\2",
            "\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\13\103\uffff\1\12",
            "\1\15\103\uffff\1\14",
            "\1\16",
            "\2\17\2\uffff\1\17\1\uffff\1\17\2\uffff\2\17\3\uffff\1\17\26"+
            "\uffff\2\17\4\uffff\1\17\4\uffff\1\17\3\uffff\1\17\5\uffff\2"+
            "\17\1\uffff\1\17\2\uffff\1\17\4\uffff\3\17\3\uffff\2\17\4\uffff"+
            "\4\17\2\uffff\1\17\3\uffff\1\20",
            "\1\21",
            "\2\23\2\uffff\1\23\1\uffff\1\23\2\uffff\2\23\3\uffff\1\23\26"+
            "\uffff\2\23\4\uffff\1\23\4\uffff\1\23\3\uffff\1\23\5\uffff\2"+
            "\23\1\uffff\1\23\1\uffff\1\22\1\23\4\uffff\3\23\3\uffff\2\23"+
            "\4\uffff\4\23\2\uffff\1\23\3\uffff\1\2",
            "\1\13\103\uffff\1\12",
            "",
            "",
            "\1\15\103\uffff\1\14",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "66:9: ( package_rule ( reference )+ | ( reference )+ package_rule | package_rule | ( reference )+ | )";
        }
    }
    static final String DFA52_eotS =
        "\12\uffff";
    static final String DFA52_eofS =
        "\12\uffff";
    static final String DFA52_minS =
        "\1\12\1\uffff\1\2\1\uffff\1\51\1\3\1\51\1\17\1\3\1\uffff";
    static final String DFA52_maxS =
        "\1\133\1\uffff\1\2\1\uffff\1\51\1\107\2\51\1\107\1\uffff";
    static final String DFA52_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\5\uffff\1\2";
    static final String DFA52_specialS =
        "\12\uffff}>";
    static final String[] DFA52_transitionS = {
            "\1\3\7\uffff\1\3\26\uffff\1\1\5\uffff\1\3\4\uffff\1\1\11\uffff"+
            "\1\3\5\uffff\1\1\4\uffff\2\3\1\2\17\uffff\1\3",
            "",
            "\1\4",
            "",
            "\1\5",
            "\1\7\103\uffff\1\6",
            "\1\10",
            "\1\11\26\uffff\1\3\2\uffff\1\3",
            "\1\7\103\uffff\1\6",
            ""
    };

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "1233:1: assignment_statement : ( (sel= selector COLON )? ID rhs= assign_right_hand_side | obj= qualified_name ( COLON PARENT COLON parent= qualified_name )? COLON ID rhs= assign_right_hand_side | (modifier= access_modifier )? ( CONSTANT )? type= assignment_declaration name= ID (rhs= assign_right_hand_side )? );";
        }
    }
    static final String DFA63_eotS =
        "\40\uffff";
    static final String DFA63_eofS =
        "\40\uffff";
    static final String DFA63_minS =
        "\1\7\13\uffff\1\2\23\uffff";
    static final String DFA63_maxS =
        "\1\135\13\uffff\1\56\23\uffff";
    static final String DFA63_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\uffff"+
        "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
        "\1\32\1\33\1\34\1\35\1\36\1\14";
    static final String DFA63_specialS =
        "\40\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\12\1\uffff\1\26\1\uffff\1\36\11\uffff\1\27\2\uffff\1\16\5"+
            "\uffff\1\2\3\uffff\1\20\1\24\1\25\2\uffff\1\4\1\5\2\uffff\1"+
            "\6\1\34\1\uffff\1\30\3\uffff\1\7\1\10\1\33\1\14\1\17\1\15\3"+
            "\uffff\1\3\1\uffff\1\32\2\uffff\1\11\5\uffff\1\35\1\uffff\1"+
            "\13\3\uffff\1\21\1\23\1\22\13\uffff\1\31\2\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\37\22\uffff\1\27\30\uffff\1\30",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "1813:1: expression returns [ExpressionValue eval, ExecutionStep step] : ( ^( UNARY_NOT NOT expr= expression ) | ^( EQUALITY left= expression right= expression ) | ^( NOTEQUALS left= expression right= expression ) | ^( GREATER left= expression right= expression ) | ^( GREATER_EQUAL left= expression right= expression ) | ^( INHERITS left= expression dec= class_type ) | ^( LESS left= expression right= expression ) | ^( LESS_EQUAL left= expression right= expression ) | ^( OR left= expression right= expression ) | ^( AND left= expression right= expression ) | ^( PLUS left= expression right= expression ) | ^( MINUS left= expression right= expression ) | ^( MULTIPLY left= expression right= expression ) | ^( DIVIDE left= expression right= expression ) | ^( MODULO left= expression right= expression ) | ^( FUNCTION_CALL qualified_name ( COLON ID )? LEFT_PAREN fel= function_expression_list RIGHT_PAREN ) | ^( QUALIFIED_SOLO_EXPRESSION var= qualified_name ( COLON ID )? ) | ^( QUALIFIED_SOLO_PARENT_EXPRESSON var= qualified_name COLON PARENT COLON par= qualified_name COLON ID ) | ^( QUALIFIED_SOLO_EXPRESSION_SELECTOR selector COLON qualified_name ) | ^( FUNCTION_CALL_PARENT PARENT COLON qn1= qualified_name COLON ID LEFT_PAREN fel= function_expression_list RIGHT_PAREN ) | ^( FUNCTION_CALL_THIS ME COLON qualified_name ( COLON ID )? LEFT_PAREN fel= function_expression_list RIGHT_PAREN ) | BOOLEAN | ( MINUS )? DECIMAL | ( MINUS )? INT | STRING | NULL | ME | INPUT LEFT_PAREN input_expr= expression RIGHT_PAREN | ^( PAREN_WRAPPED_EXPRESSION LEFT_PAREN expr= expression RIGHT_PAREN ) | CAST LEFT_PAREN castqn= assignment_declaration COMMA cast_expr= expression castrpn= RIGHT_PAREN );";
        }
    }
 

    public static final BitSet FOLLOW_package_rule_in_start51 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_reference_in_start53 = new BitSet(new long[]{0xC110860000046530L,0x0000000089E18E12L});
    public static final BitSet FOLLOW_reference_in_start59 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000008L});
    public static final BitSet FOLLOW_package_rule_in_start62 = new BitSet(new long[]{0xC110860000046530L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_package_rule_in_start67 = new BitSet(new long[]{0xC110860000046530L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_reference_in_start72 = new BitSet(new long[]{0xC110860000046530L,0x0000000089E18E12L});
    public static final BitSet FOLLOW_class_declaration_in_start81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACKAGE_NAME_in_package_rule96 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_package_rule100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_in_reference113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_reference115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASS_in_class_declaration131 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_class_declaration133 = new BitSet(new long[]{0xC1108E4020046530L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_generic_declaration_in_class_declaration139 = new BitSet(new long[]{0xC1108E0020046530L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_inherit_stmnts_in_class_declaration146 = new BitSet(new long[]{0xC110860020046530L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_class_stmnts_in_class_declaration153 = new BitSet(new long[]{0xC110860020046530L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_END_in_class_declaration156 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_no_class_stmnts_in_class_declaration169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_no_class_stmnts189 = new BitSet(new long[]{0x4010860000042422L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_access_modifier_in_no_class_stmnts203 = new BitSet(new long[]{0xC110860000046530L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_method_declaration_in_no_class_stmnts211 = new BitSet(new long[]{0xC110860000046532L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_INHERITS_in_inherit_stmnts225 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_qualified_name_in_inherit_stmnts233 = new BitSet(new long[]{0x0000004000000008L,0x0000000000000800L});
    public static final BitSet FOLLOW_generic_statement_in_inherit_stmnts239 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000800L});
    public static final BitSet FOLLOW_PUBLIC_in_access_modifier257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRIVATE_in_access_modifier265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_statement_in_class_stmnts279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_access_modifier_in_class_stmnts288 = new BitSet(new long[]{0xC110860000046530L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_method_declaration_in_class_stmnts296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_method_declaration314 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_method_declaration320 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_formal_parameter_in_method_declaration325 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_RETURNS_in_method_declaration338 = new BitSet(new long[]{0x4010820000040400L,0x0000000008000E10L});
    public static final BitSet FOLLOW_assignment_declaration_in_method_declaration342 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_method_declaration348 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_END_in_method_declaration351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLUEPRINT_in_method_declaration366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_method_declaration368 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_method_declaration375 = new BitSet(new long[]{0x0000000200000008L,0x0000000000020000L});
    public static final BitSet FOLLOW_formal_parameter_in_method_declaration380 = new BitSet(new long[]{0x0000000200000008L,0x0000000000020000L});
    public static final BitSet FOLLOW_RETURNS_in_method_declaration389 = new BitSet(new long[]{0x4010820000040400L,0x0000000008000E10L});
    public static final BitSet FOLLOW_assignment_declaration_in_method_declaration391 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NATIVE_in_method_declaration400 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_method_declaration402 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_method_declaration409 = new BitSet(new long[]{0x0000000200000008L,0x0000000000020000L});
    public static final BitSet FOLLOW_formal_parameter_in_method_declaration414 = new BitSet(new long[]{0x0000000200000008L,0x0000000000020000L});
    public static final BitSet FOLLOW_RETURNS_in_method_declaration423 = new BitSet(new long[]{0x4010820000040400L,0x0000000008000E10L});
    public static final BitSet FOLLOW_assignment_declaration_in_method_declaration425 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ON_in_method_declaration434 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CREATE_in_method_declaration436 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_method_declaration443 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_END_in_method_declaration446 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUALIFIED_NAME_in_qualified_name469 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_qualified_name474 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000080L});
    public static final BitSet FOLLOW_PERIOD_in_qualified_name477 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_qualified_name481 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000080L});
    public static final BitSet FOLLOW_STATEMENT_LIST_in_block500 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_block507 = new BitSet(new long[]{0x4010860000042428L,0x0000000009E18E12L});
    public static final BitSet FOLLOW_solo_method_call_in_statement524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_statement_in_statement529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_statement_in_statement534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_loop_statement_in_statement539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_statement_in_statement544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_statement_in_statement549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_speak_statement_in_statement554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_check_statement_in_statement559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alert_statement_in_statement564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SOLO_FUNCTION_CALL_in_solo_method_call584 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_qualified_name_in_solo_method_call593 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_COLON_in_solo_method_call596 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_solo_method_call598 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_solo_method_call602 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024047141L});
    public static final BitSet FOLLOW_expression_in_solo_method_call616 = new BitSet(new long[]{0x0000000000010000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_solo_method_call626 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_solo_method_call640 = new BitSet(new long[]{0x0000000000010000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_solo_method_call654 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOLO_FUNCTION_CALL_PARENT_in_solo_method_call666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PARENT_in_solo_method_call673 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_solo_method_call675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_solo_method_call677 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_solo_method_call679 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_solo_method_call681 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_solo_method_call683 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024047141L});
    public static final BitSet FOLLOW_expression_in_solo_method_call694 = new BitSet(new long[]{0x0000000000010000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_solo_method_call704 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_solo_method_call717 = new BitSet(new long[]{0x0000000000010000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_solo_method_call727 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SOLO_FUNCTION_CALL_THIS_in_solo_method_call738 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ME_in_solo_method_call745 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_solo_method_call747 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_solo_method_call749 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_COLON_in_solo_method_call752 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_solo_method_call754 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_solo_method_call758 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024047141L});
    public static final BitSet FOLLOW_expression_in_solo_method_call771 = new BitSet(new long[]{0x0000000000010000L,0x0000000000040000L});
    public static final BitSet FOLLOW_COMMA_in_solo_method_call778 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_solo_method_call791 = new BitSet(new long[]{0x0000000000010000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_solo_method_call804 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALERT_in_alert_statement824 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_alert_statement832 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_root_expression_in_alert_statement836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_alert_statement844 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CHECK_in_check_statement876 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_check_statement882 = new BitSet(new long[]{0x0000000000800040L});
    public static final BitSet FOLLOW_DETECT_in_check_statement904 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_detect_parameter_in_check_statement931 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_check_statement955 = new BitSet(new long[]{0x0000000020800040L});
    public static final BitSet FOLLOW_ALWAYS_in_check_statement988 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_check_statement1004 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_ALWAYS_in_check_statement1036 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_check_statement1059 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_END_in_check_statement1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_detect_parameter1097 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INHERITS_in_detect_parameter1102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_detect_parameter1111 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_OR_in_detect_parameter1118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_detect_parameter1122 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
    public static final BitSet FOLLOW_OUTPUT_in_print_statement1149 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_root_expression_in_print_statement1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAY_in_speak_statement1167 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_root_expression_in_speak_statement1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_return_statement1183 = new BitSet(new long[]{0x1000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_root_expression_in_return_statement1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOW_in_return_statement1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERIC_in_generic_declaration1212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LESS_in_generic_declaration1214 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_generic_declaration1218 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_COMMA_in_generic_declaration1221 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_generic_declaration1225 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_GREATER_in_generic_declaration1229 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERIC_in_generic_statement1247 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LESS_in_generic_statement1249 = new BitSet(new long[]{0x4010820000040400L,0x0000000008000E10L});
    public static final BitSet FOLLOW_assignment_declaration_in_generic_statement1258 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_COMMA_in_generic_statement1266 = new BitSet(new long[]{0x4010820000040400L,0x0000000008000E10L});
    public static final BitSet FOLLOW_assignment_declaration_in_generic_statement1270 = new BitSet(new long[]{0x0000008000010000L});
    public static final BitSet FOLLOW_GREATER_in_generic_statement1286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_qualified_name_in_class_type1311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualified_name_in_assignment_declaration1333 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_generic_statement_in_assignment_declaration1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_KEYWORD_in_assignment_declaration1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_KEYWORD_in_assignment_declaration1354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_assignment_declaration1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_KEYWORD_in_assignment_declaration1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_assignment_statement1386 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_assignment_statement1388 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_assignment_statement1392 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_assign_right_hand_side_in_assignment_statement1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualified_name_in_assignment_statement1406 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_assignment_statement1409 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_PARENT_in_assignment_statement1411 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_assignment_statement1413 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_assignment_statement1417 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_assignment_statement1421 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_assignment_statement1423 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_assign_right_hand_side_in_assignment_statement1427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_access_modifier_in_assignment_statement1439 = new BitSet(new long[]{0x4010820000040400L,0x0000000008000E10L});
    public static final BitSet FOLLOW_CONSTANT_in_assignment_statement1442 = new BitSet(new long[]{0x4010820000040400L,0x0000000008000E10L});
    public static final BitSet FOLLOW_assignment_declaration_in_assignment_statement1449 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_assignment_statement1455 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_assign_right_hand_side_in_assignment_statement1459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALITY_in_assign_right_hand_side1480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_root_expression_in_assign_right_hand_side1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_statement1508 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_root_expression_in_if_statement1521 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_if_statement1533 = new BitSet(new long[]{0x000000002C000000L});
    public static final BitSet FOLLOW_ELSE_IF_in_if_statement1550 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_root_expression_in_if_statement1563 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_if_statement1573 = new BitSet(new long[]{0x000000002C000000L});
    public static final BitSet FOLLOW_ELSE_in_if_statement1607 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_if_statement1617 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_END_in_if_statement1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPEAT_in_loop_statement1649 = new BitSet(new long[]{0x0000000000000000L,0x0000000140100000L});
    public static final BitSet FOLLOW_root_expression_in_loop_statement1722 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_TIMES_in_loop_statement1724 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_WHILE_in_loop_statement1735 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_UNTIL_in_loop_statement1741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_root_expression_in_loop_statement1756 = new BitSet(new long[]{0x0000000200000000L,0x0000000002020000L});
    public static final BitSet FOLLOW_block_in_loop_statement1767 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_END_in_loop_statement1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARENT_in_selector1814 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_qualified_name_in_selector1816 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ME_in_selector1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROOT_EXPRESSION_in_root_expression1851 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_root_expression1853 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_UNARY_NOT_in_expression1875 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOT_in_expression1877 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression1883 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EQUALITY_in_expression1895 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1901 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression1907 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOTEQUALS_in_expression1917 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1923 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression1929 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_in_expression1939 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1945 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression1951 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GREATER_EQUAL_in_expression1961 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1967 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression1973 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INHERITS_in_expression1983 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression1987 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_class_type_in_expression1991 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESS_in_expression2001 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2007 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2013 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LESS_EQUAL_in_expression2023 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2029 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2035 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_expression2045 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2051 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2057 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_expression2067 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2073 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2079 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_in_expression2089 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2095 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2101 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expression2111 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2117 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2123 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MULTIPLY_in_expression2133 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2139 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2145 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIVIDE_in_expression2155 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2161 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2167 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODULO_in_expression2177 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression2183 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2189 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_CALL_in_expression2199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_qualified_name_in_expression2201 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_COLON_in_expression2203 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_expression2205 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_expression2209 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_function_expression_list_in_expression2221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_expression2223 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUALIFIED_SOLO_EXPRESSION_in_expression2234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_qualified_name_in_expression2238 = new BitSet(new long[]{0x0000000000008008L});
    public static final BitSet FOLLOW_COLON_in_expression2241 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_expression2243 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUALIFIED_SOLO_PARENT_EXPRESSON_in_expression2255 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_qualified_name_in_expression2259 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_expression2261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_PARENT_in_expression2263 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_expression2265 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_expression2269 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_expression2271 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_expression2273 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUALIFIED_SOLO_EXPRESSION_SELECTOR_in_expression2283 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_selector_in_expression2285 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_expression2287 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_expression2289 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_CALL_PARENT_in_expression2301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PARENT_in_expression2303 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_expression2305 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_expression2309 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_expression2311 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_expression2313 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_expression2315 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_function_expression_list_in_expression2326 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_expression2328 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNCTION_CALL_THIS_in_expression2338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ME_in_expression2340 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_COLON_in_expression2342 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_qualified_name_in_expression2344 = new BitSet(new long[]{0x0001000000008000L});
    public static final BitSet FOLLOW_COLON_in_expression2347 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_expression2349 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_expression2353 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_function_expression_list_in_expression2364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_expression2366 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BOOLEAN_in_expression2375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_expression2384 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DECIMAL_in_expression2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_expression2397 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_INT_in_expression2401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expression2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_expression2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ME_in_expression2425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_expression2433 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_expression2436 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2442 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_expression2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PAREN_WRAPPED_EXPRESSION_in_expression2452 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_expression2454 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_expression2460 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_in_expression2467 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LEFT_PAREN_in_expression2469 = new BitSet(new long[]{0x4010820000040400L,0x0000000008000E10L});
    public static final BitSet FOLLOW_assignment_declaration_in_expression2473 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_COMMA_in_expression2475 = new BitSet(new long[]{0x28FC599C41200A80L,0x0000000024007141L});
    public static final BitSet FOLLOW_expression_in_expression2480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RIGHT_PAREN_in_expression2484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_EXPRESSION_LIST_in_function_expression_list2508 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_function_expression_list2520 = new BitSet(new long[]{0x28FC599C41200A88L,0x0000000024007141L});
    public static final BitSet FOLLOW_FPARAM_in_formal_parameter2549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_assignment_declaration_in_formal_parameter2553 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ID_in_formal_parameter2555 = new BitSet(new long[]{0x0000000000000008L});

}