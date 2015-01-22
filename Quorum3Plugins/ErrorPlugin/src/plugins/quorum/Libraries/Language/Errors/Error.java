/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins.quorum.Libraries.Language.Errors;

import quorum.Libraries.Containers.Array;
import quorum.Libraries.Language.Errors.*;
import quorum.Libraries.System.StackTraceItem;

/**
 *
 * @author Andreas Stefik
 */
public class Error {
    public java.lang.Object $me = null;
    
    public Error() {
    }
    
    
    public static quorum.Libraries.Language.Errors.Error ConvertToQuorumError(Throwable throwable) {
        if(throwable instanceof NullPointerException) {
            UndefinedObjectError error = new UndefinedObjectError();
            CaptureThrowableTrace(throwable.getStackTrace(), error);
            return error;
        } else if(throwable instanceof ClassCastException) {
            CastError error = new CastError();
            CaptureThrowableTrace(throwable.getStackTrace(), error);
            return error;
        } else if(throwable instanceof quorum.Libraries.Language.Errors.Error) {
            quorum.Libraries.Language.Errors.Error error = (quorum.Libraries.Language.Errors.Error) throwable;
            if(error.stackTrace == null) {
                CaptureThrowableTrace(Thread.currentThread().getStackTrace(), error);
            }
            return error;
        } else {
            quorum.Libraries.Language.Errors.Error error = new quorum.Libraries.Language.Errors.Error();
            CaptureThrowableTrace(Thread.currentThread().getStackTrace(), error);
            return error;
        }
    }
    
    public static void CaptureThrowableTrace(StackTraceElement[] trace, quorum.Libraries.Language.Errors.Error error) {
        quorum.Libraries.Containers.Array array = new quorum.Libraries.Containers.Array();
        for(int i = 0; i < trace.length; i++) {
            StackTraceElement e = trace[i];
            String fileName = e.getFileName();
            String className = e.getClassName();
            String quorumDot = "quorum.";
            boolean isQuorumClass = false;
            if(className.startsWith(quorumDot)) {
                className = className.substring(quorumDot.length());
                isQuorumClass = true;
            }
            int lineNumber = e.getLineNumber();
            String methodName = e.getMethodName();
            //only put in the quorum errors
            if((isQuorumClass || className.startsWith("plugins.quorum"))
               && !(methodName.startsWith("main") && lineNumber == -1)
               && !(className.startsWith("plugins.quorum.Libraries.Language.Errors.Error"))) {
                StackTraceItem item = new StackTraceItem();
                item.Set$Libraries$System$StackTraceItem$className(className);
                item.Set$Libraries$System$StackTraceItem$fileName(fileName);
                item.Set$Libraries$System$StackTraceItem$lineNumber(lineNumber);
                item.Set$Libraries$System$StackTraceItem$methodName(methodName);
                array.Add(item);
            }
        }
        error.SetStackTrace(array);
    }
}
