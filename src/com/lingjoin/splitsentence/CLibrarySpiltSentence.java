package com.lingjoin.splitsentence;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CLibrarySpiltSentence extends Library {

	CLibrarySpiltSentence Instance = (CLibrarySpiltSentence) Native.loadLibrary("SpiltSentence",
			CLibrarySpiltSentence.class);

	public int SS_Init(String sDataPath, String sLicenceCode);

	public void SS_Exit();

	public String SS_GetSentence(String sText, int encode);

	public String SS_GetLastErrorMsg();
}
