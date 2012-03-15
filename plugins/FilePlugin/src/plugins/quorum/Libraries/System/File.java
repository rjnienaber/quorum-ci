/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins.quorum.Libraries.System;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java bytecode plugin for the "File" class. This is merely a wrapper for the
 * QuorumFilePlugin class.
 * 
 * @author Jeff Wilson
 */
public class File {
    public java.lang.Object $me = null;
    private QuorumFile inst = new QuorumFile();
    
    public long GetLastModifiedNative() {
        return inst.GetLastModifiedNative();
    }
    
    public java.lang.String GetDirectoryListingNative() {
        return inst.GetDirectoryListingNative();
    }
    public java.lang.String GetParentDirectoryNative() {
        return inst.GetParentDirectoryNative();
    }
    
    public String GetPathNative() {
        return inst.GetPathNative();
    }
    
    public void SetPathNative(String newPath) {
        inst.SetPathNative(newPath);
    }
    
    public String GetWorkingDirectoryNative() {
        return inst.GetWorkingDirectoryNative();
    }
    
    public String GetSystemNewline() {
        return inst.GetSystemNewline();
    }
    
    public boolean Exists() {
        return inst.Exists();
    }
    
    public boolean IsFile() {
        return inst.IsFile();
    }
    
    public boolean IsDirectory() {
        return inst.IsDirectory();
    }
    
    public boolean IsHidden() {
        return inst.IsHidden();
    }
    
    public String GetFileName() {
        return inst.GetFileName();
    }
    
    public String GetFileExtension() {
        return inst.GetFileExtension();
    }
    
    public double GetFreeDiskSpace() {
        return inst.GetFreeDiskSpace();
    }
    
    public double GetTotalDiskSpace() {
        return inst.GetTotalDiskSpace();
    }
    
    public double GetFileSize() {
        return inst.GetFileSize();
    }
    
    public boolean Delete() {
        return inst.Delete();
    }
    
    public boolean CreateDirectory() {
        return inst.CreateDirectory();
    }
    
    public boolean Move(String newPath) {
        return inst.Move(newPath);
    }
}
