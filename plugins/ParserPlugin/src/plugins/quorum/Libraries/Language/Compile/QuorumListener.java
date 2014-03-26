// Generated from /Users/stefika/Repositories/quorum-language/plugins/ParserPlugin/src/plugins/quorum/Libraries/Language/Parser/Quorum.g4 by ANTLR 4.1
package plugins.quorum.Libraries.Language.Compile;;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuorumParser}.
 */
public interface QuorumListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuorumParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(@NotNull QuorumParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(@NotNull QuorumParser.SelectorContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Decimal}.
	 * @param ctx the parse tree
	 */
	void enterDecimal(@NotNull QuorumParser.DecimalContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Decimal}.
	 * @param ctx the parse tree
	 */
	void exitDecimal(@NotNull QuorumParser.DecimalContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#ParenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpression(@NotNull QuorumParser.ParenthesisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#ParenthesisExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpression(@NotNull QuorumParser.ParenthesisExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Cast}.
	 * @param ctx the parse tree
	 */
	void enterCast(@NotNull QuorumParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Cast}.
	 * @param ctx the parse tree
	 */
	void exitCast(@NotNull QuorumParser.CastContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#speak_statement}.
	 * @param ctx the parse tree
	 */
	void enterSpeak_statement(@NotNull QuorumParser.Speak_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#speak_statement}.
	 * @param ctx the parse tree
	 */
	void exitSpeak_statement(@NotNull QuorumParser.Speak_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#ParentFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterParentFunctionCall(@NotNull QuorumParser.ParentFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#ParentFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitParentFunctionCall(@NotNull QuorumParser.ParentFunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#check_statement}.
	 * @param ctx the parse tree
	 */
	void enterCheck_statement(@NotNull QuorumParser.Check_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#check_statement}.
	 * @param ctx the parse tree
	 */
	void exitCheck_statement(@NotNull QuorumParser.Check_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#ParentFieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterParentFieldAccess(@NotNull QuorumParser.ParentFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#ParentFieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitParentFieldAccess(@NotNull QuorumParser.ParentFieldAccessContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void enterClass_declaration(@NotNull QuorumParser.Class_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void exitClass_declaration(@NotNull QuorumParser.Class_declarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#ObjectFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterObjectFunctionCall(@NotNull QuorumParser.ObjectFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#ObjectFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitObjectFunctionCall(@NotNull QuorumParser.ObjectFunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#solo_method_call}.
	 * @param ctx the parse tree
	 */
	void enterSolo_method_call(@NotNull QuorumParser.Solo_method_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#solo_method_call}.
	 * @param ctx the parse tree
	 */
	void exitSolo_method_call(@NotNull QuorumParser.Solo_method_callContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#formal_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFormal_parameter(@NotNull QuorumParser.Formal_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#formal_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFormal_parameter(@NotNull QuorumParser.Formal_parameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull QuorumParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull QuorumParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Me}.
	 * @param ctx the parse tree
	 */
	void enterMe(@NotNull QuorumParser.MeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Me}.
	 * @param ctx the parse tree
	 */
	void exitMe(@NotNull QuorumParser.MeContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#function_expression_list}.
	 * @param ctx the parse tree
	 */
	void enterFunction_expression_list(@NotNull QuorumParser.Function_expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#function_expression_list}.
	 * @param ctx the parse tree
	 */
	void exitFunction_expression_list(@NotNull QuorumParser.Function_expression_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull QuorumParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull QuorumParser.StartContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#String}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull QuorumParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#String}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull QuorumParser.StringContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Or}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull QuorumParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Or}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull QuorumParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint_statement(@NotNull QuorumParser.Print_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint_statement(@NotNull QuorumParser.Print_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#method_declaration}.
	 * @param ctx the parse tree
	 */
	void enterMethod_declaration(@NotNull QuorumParser.Method_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#method_declaration}.
	 * @param ctx the parse tree
	 */
	void exitMethod_declaration(@NotNull QuorumParser.Method_declarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#generic_statement}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_statement(@NotNull QuorumParser.Generic_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#generic_statement}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_statement(@NotNull QuorumParser.Generic_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#And}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull QuorumParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#And}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull QuorumParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Null}.
	 * @param ctx the parse tree
	 */
	void enterNull(@NotNull QuorumParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Null}.
	 * @param ctx the parse tree
	 */
	void exitNull(@NotNull QuorumParser.NullContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Inherits}.
	 * @param ctx the parse tree
	 */
	void enterInherits(@NotNull QuorumParser.InheritsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Inherits}.
	 * @param ctx the parse tree
	 */
	void exitInherits(@NotNull QuorumParser.InheritsContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#VariableOrFieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterVariableOrFieldAccess(@NotNull QuorumParser.VariableOrFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#VariableOrFieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitVariableOrFieldAccess(@NotNull QuorumParser.VariableOrFieldAccessContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#MeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterMeFunctionCall(@NotNull QuorumParser.MeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#MeFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitMeFunctionCall(@NotNull QuorumParser.MeFunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#assign_right_hand_side}.
	 * @param ctx the parse tree
	 */
	void enterAssign_right_hand_side(@NotNull QuorumParser.Assign_right_hand_sideContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#assign_right_hand_side}.
	 * @param ctx the parse tree
	 */
	void exitAssign_right_hand_side(@NotNull QuorumParser.Assign_right_hand_sideContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(@NotNull QuorumParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(@NotNull QuorumParser.If_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#access_modifier}.
	 * @param ctx the parse tree
	 */
	void enterAccess_modifier(@NotNull QuorumParser.Access_modifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#access_modifier}.
	 * @param ctx the parse tree
	 */
	void exitAccess_modifier(@NotNull QuorumParser.Access_modifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull QuorumParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull QuorumParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#class_stmnts}.
	 * @param ctx the parse tree
	 */
	void enterClass_stmnts(@NotNull QuorumParser.Class_stmntsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#class_stmnts}.
	 * @param ctx the parse tree
	 */
	void exitClass_stmnts(@NotNull QuorumParser.Class_stmntsContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#qualified_name}.
	 * @param ctx the parse tree
	 */
	void enterQualified_name(@NotNull QuorumParser.Qualified_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#qualified_name}.
	 * @param ctx the parse tree
	 */
	void exitQualified_name(@NotNull QuorumParser.Qualified_nameContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void enterLoop_statement(@NotNull QuorumParser.Loop_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#loop_statement}.
	 * @param ctx the parse tree
	 */
	void exitLoop_statement(@NotNull QuorumParser.Loop_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#assignment_declaration}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_declaration(@NotNull QuorumParser.Assignment_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#assignment_declaration}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_declaration(@NotNull QuorumParser.Assignment_declarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#FieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(@NotNull QuorumParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#FieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(@NotNull QuorumParser.FieldAccessContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#inherit_stmnts}.
	 * @param ctx the parse tree
	 */
	void enterInherit_stmnts(@NotNull QuorumParser.Inherit_stmntsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#inherit_stmnts}.
	 * @param ctx the parse tree
	 */
	void exitInherit_stmnts(@NotNull QuorumParser.Inherit_stmntsContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#detect_parameter}.
	 * @param ctx the parse tree
	 */
	void enterDetect_parameter(@NotNull QuorumParser.Detect_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#detect_parameter}.
	 * @param ctx the parse tree
	 */
	void exitDetect_parameter(@NotNull QuorumParser.Detect_parameterContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Addition}.
	 * @param ctx the parse tree
	 */
	void enterAddition(@NotNull QuorumParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Addition}.
	 * @param ctx the parse tree
	 */
	void exitAddition(@NotNull QuorumParser.AdditionContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#no_class_stmnts}.
	 * @param ctx the parse tree
	 */
	void enterNo_class_stmnts(@NotNull QuorumParser.No_class_stmntsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#no_class_stmnts}.
	 * @param ctx the parse tree
	 */
	void exitNo_class_stmnts(@NotNull QuorumParser.No_class_stmntsContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(@NotNull QuorumParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(@NotNull QuorumParser.Return_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Input}.
	 * @param ctx the parse tree
	 */
	void enterInput(@NotNull QuorumParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Input}.
	 * @param ctx the parse tree
	 */
	void exitInput(@NotNull QuorumParser.InputContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Multiplication}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(@NotNull QuorumParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Multiplication}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(@NotNull QuorumParser.MultiplicationContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Minus}.
	 * @param ctx the parse tree
	 */
	void enterMinus(@NotNull QuorumParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Minus}.
	 * @param ctx the parse tree
	 */
	void exitMinus(@NotNull QuorumParser.MinusContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_statement(@NotNull QuorumParser.Assignment_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#assignment_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_statement(@NotNull QuorumParser.Assignment_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(@NotNull QuorumParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(@NotNull QuorumParser.BooleanContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#alert_statement}.
	 * @param ctx the parse tree
	 */
	void enterAlert_statement(@NotNull QuorumParser.Alert_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#alert_statement}.
	 * @param ctx the parse tree
	 */
	void exitAlert_statement(@NotNull QuorumParser.Alert_statementContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(@NotNull QuorumParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(@NotNull QuorumParser.ReferenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Not}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull QuorumParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Not}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull QuorumParser.NotContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#generic_declaration}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_declaration(@NotNull QuorumParser.Generic_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#generic_declaration}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_declaration(@NotNull QuorumParser.Generic_declarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#class_type}.
	 * @param ctx the parse tree
	 */
	void enterClass_type(@NotNull QuorumParser.Class_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#class_type}.
	 * @param ctx the parse tree
	 */
	void exitClass_type(@NotNull QuorumParser.Class_typeContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Equals}.
	 * @param ctx the parse tree
	 */
	void enterEquals(@NotNull QuorumParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Equals}.
	 * @param ctx the parse tree
	 */
	void exitEquals(@NotNull QuorumParser.EqualsContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Greater}.
	 * @param ctx the parse tree
	 */
	void enterGreater(@NotNull QuorumParser.GreaterContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Greater}.
	 * @param ctx the parse tree
	 */
	void exitGreater(@NotNull QuorumParser.GreaterContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#Integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(@NotNull QuorumParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#Integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(@NotNull QuorumParser.IntegerContext ctx);

	/**
	 * Enter a parse tree produced by {@link QuorumParser#package_rule}.
	 * @param ctx the parse tree
	 */
	void enterPackage_rule(@NotNull QuorumParser.Package_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuorumParser#package_rule}.
	 * @param ctx the parse tree
	 */
	void exitPackage_rule(@NotNull QuorumParser.Package_ruleContext ctx);
}