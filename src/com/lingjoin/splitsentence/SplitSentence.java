package com.lingjoin.splitsentence;

import java.io.File;
import java.io.RandomAccessFile;

import com.lingjoin.splitsentence.CLibrarySpiltSentence;

public class SplitSentence {

	// 全局静态初始化状态
	public static int initState = 0;

	/**
	 * 构造函数
	 * 
	 * @param data
	 *            Data目录
	 * @param license
	 *            授权码
	 */
	public SplitSentence(String data, String license) {
		if (initState == 1)
			return;
		initState = CLibrarySpiltSentence.Instance.SS_Init(data, license);
		if (initState == 0)
			System.out.println(CLibrarySpiltSentence.Instance.SS_GetLastErrorMsg());
	}

	public String SS_GetSentence(String text, int encode) {
		return CLibrarySpiltSentence.Instance.SS_GetSentence(text, encode);
	}

	public void SS_Exit() {
		CLibrarySpiltSentence.Instance.SS_Exit();
	}

	public String getContent(File file) throws Exception {
		RandomAccessFile f = new RandomAccessFile(file, "r");
		byte[] b = new byte[(int) file.length()];
		f.read(b);
		f.close();
		String c = new String(b, "utf-8").replaceAll("\\s", "");
		return c;
	}

	public static void main(String[] args) throws Exception {
		SplitSentence ss = new SplitSentence("", "");
		ss.SS_GetSentence(ss.getContent(new File("5.txt")), 1);
		while (true) {
			String str = ss.SS_GetSentence(null, 1);
			if (str.isEmpty())
				break;
			System.out.println(str);
		}
		ss.SS_Exit();
	}
}
