/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins.quorum.Libraries.Language.Types;

import quorum.Libraries.Language.Object$Interface;
import quorum.Libraries.Language.Types.Integer$Interface;
import quorum.Libraries.Language.Types.Number$Interface;

/**
 * Integer plugin for handling Integer class functions for objects and primitives.
 * 
 * @author Melissa Stefik
 */
public class Integer {
    public java.lang.Object $me = null;
    private int integer = -1;
    
    
    public static int ParseInteger(String value) throws quorum.Libraries.Language.Errors.CastError{
        try {
            return java.lang.Integer.parseInt(value);
        } catch(NumberFormatException e) {
            throw new quorum.Libraries.Language.Errors.CastError();
        }
    }
    
    public static int ConvertObjectToInteger(Object$Interface object) {
        if(object == null) {
            throw new NullPointerException("Cannot convert an undefined type to an integer.");
        }
        Integer$Interface val = (Integer$Interface) object;
        return val.GetValue();
    }
    
    public static int ConvertIntegerObjectToInteger(Integer$Interface object) {
        if(object == null) {
            throw new NullPointerException("Cannot convert an undefined type to an integer.");
        }
        return object.GetValue();
    }
    
    public static Number$Interface ConvertIntegerPrimitiveToNumberObject(int value) {
        Number$Interface num = new quorum.Libraries.Language.Types.Number();
        num.SetValue(value);
        return num;
    }
    
    public static Object$Interface ConvertIntegerToObject(int value) {
        Integer$Interface i = new quorum.Libraries.Language.Types.Integer();
        i.SetValue(value);
        return i;
    }
    
    public static Integer$Interface ConvertIntegerToIntegerObject(int value) {
        Integer$Interface i = new quorum.Libraries.Language.Types.Integer();
        i.SetValue(value);
        return i;
    }
    
    public void SetValueNative(int value){
        integer = value;
    }
    
    public static boolean PrimitiveEquals(int self, Object$Interface obj) throws quorum.Libraries.Language.Errors.Error{
        Integer$Interface t = (Integer$Interface)obj;
        return self == t.GetValue();
    }
    
    public static double PrimitiveGetNumber(int self){
        return self;
    }
    
    public static String PrimitiveGetText(int self){
        return "" + self;
    }
    
    public static quorum.Libraries.Language.Support.CompareResult$Interface PrimitiveCompare(int self, quorum.Libraries.Language.Object$Interface obj){
        quorum.Libraries.Language.Support.CompareResult r = new quorum.Libraries.Language.Support.CompareResult();
        Integer$Interface t = (Integer$Interface)obj;
        if(self == t.GetValue()){
            r.result = r.EQUAL;
        } else if(self > t.GetValue()){
            r.result = r.LARGER;
        } else {
            r.result = r.SMALLER;
        }
        return r;
    }
    
    public int BitCount(){
        return java.lang.Integer.bitCount(integer);
    }
    
    public static int PrimitiveBitCount(int self){
        return java.lang.Integer.bitCount(self);
    }
    
    public int HighestOneBit(){
        return java.lang.Integer.highestOneBit(integer);
    }
            
    public static int PrimitiveHighestOneBit(int self){
        return java.lang.Integer.highestOneBit(self);
    }
    
    public int LowestOneBit(){
        return java.lang.Integer.lowestOneBit(integer);
    }
    
    public static int PrimitiveLowestOneBit(int self){
        return java.lang.Integer.lowestOneBit(self);
    }
    
    public int LeadingZeros(){
        return java.lang.Integer.numberOfLeadingZeros(integer);
    }
    
    public static int PrimitiveLeadingZeros(int self){
        return java.lang.Integer.numberOfLeadingZeros(self);
    }
    
    public int TrailingZeros(){
        return java.lang.Integer.numberOfTrailingZeros(integer);
    }
    
    public static int PrimitiveTrailingZeros(int self){
        return java.lang.Integer.numberOfTrailingZeros(self);
    }
    
    public int Reverse(){
        return java.lang.Integer.reverse(integer);
    }
    
    public static int PrimitiveReverse(int self){
        return java.lang.Integer.reverse(self);
    }
    
    public int RotateLeft(int value){
        return java.lang.Integer.rotateLeft(integer, value);
    }
    
    public static int PrimitiveRotateLeft(int self, int points){
        return java.lang.Integer.rotateLeft(self, points);
    }
    
    public int RotateRight(int value){
        return java.lang.Integer.rotateRight(integer, value);
    }
    
    public static int PrimitiveRotateRight(int self, int points){
        return java.lang.Integer.rotateRight(self, points);
    }
    
    public String GetBinary(){
        return java.lang.Integer.toBinaryString(integer);
    }
    
    public static String PrimitiveGetBinary(int self){
        return java.lang.Integer.toBinaryString(self);
    }
    
    public String GetHex(){
        return java.lang.Integer.toHexString(integer);
    }
    
    public static String PrimitiveGetHex(int self){
        return java.lang.Integer.toHexString(self);
    }
    
    public String GetOctal(){
        return java.lang.Integer.toOctalString(integer);
    }
    
    public static String PrimitiveGetOctal(int self){
        return java.lang.Integer.toOctalString(self);
    }
    
    public static int PrimitiveGetMaximumValue(){
        return java.lang.Integer.MAX_VALUE;
    }
    
    public static int PrimitiveGetMinimumValue(){
        return java.lang.Integer.MIN_VALUE;
    }
    
    public int GetHashCode() {
        return integer;
    }
    
    public int PrimitiveGetHashCode(int self) {
        return self;
    }
}
