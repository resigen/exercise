package com.zhuoshi.tool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class DatabaseOperator {

	/**
	 * ���ݿⱸ��
	 * 
	 * @param database
	 *            ���ݿ�����
	 * @param savepath
	 *            �洢·��
	 * @param username
	 *            ���ݿ��û���
	 * @param password
	 *            ���ݿ�����
	 * @param backupname
	 *            ���ݵ��ļ���
	 * @return boolean �Ƿ�ɹ�
	 */

	public boolean backup(String database, String savepath, String backupname,
			String username, String password) {

		boolean falg = false;

		try {
			Runtime rt = Runtime.getRuntime();
			Process child = rt.exec("cmd /c C:\\Users\\admin\\Desktop\\bbb\\mysqldump  -u" + username + "  -p"
					+ password + "  --set-charset=utf8   " + database );
			
			// �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���
			// ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
			InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������

			InputStreamReader xx = new InputStreamReader(in, "utf8");// �������������Ϊutf8�����������utf8����������ж����������

			String inStr;

			StringBuffer sb = new StringBuffer("");

			String outStr;
			// ��Ͽ���̨�����Ϣ�ַ���
			BufferedReader br = new BufferedReader(xx);

			while ((inStr = br.readLine()) != null) {

				sb.append(inStr + "\r\n");

			}

			outStr = sb.toString();
			// Ҫ�����������õ�sqlĿ���ļ���
			FileOutputStream fout = new FileOutputStream(savepath + "/"
					+ backupname);
			
			//utf8���ʻ�    gb2312���� 

			OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");

			writer.write(outStr);
			// ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
			writer.flush();
			// �����ǹر����������
			in.close();

			xx.close();

			br.close();

			writer.close();

			fout.close();

			falg = true;

		} catch (Exception e) {

			e.printStackTrace();

			falg = false;

		}

		return falg;

	}
	
	/**
	 * ���ݿ�ָ�
	 * 
	 * @param database
	 *            ���ݿ�����
	 * @param savepath
	 *            �洢·��
	 * @param username
	 *            ���ݿ��û���
	 * @param password
	 *            ���ݿ�����
	 * @param backupname
	 *            ���ݵ��ļ���
	 * @return boolean �Ƿ�ɹ�
	 */ 

	
	public boolean recover(String database, String savepath, String backupname,
			String username, String password) {

		boolean falg = false;

		try {

			String fPath = savepath + "/" + backupname;

			Runtime rt = Runtime.getRuntime();
			
			Process child = rt.exec("cmd /c C:\\Users\\admin\\Desktop\\bbb\\mysql -u" + username + "  -p" + password
					+ "   " + database);

			OutputStream out = child.getOutputStream();// ����̨��������Ϣ��Ϊ�����

			String inStr;

			StringBuffer sb = new StringBuffer("");

			String outStr;

			BufferedReader br = new BufferedReader(new InputStreamReader(

			new FileInputStream(fPath), "utf8"));

			while ((inStr = br.readLine()) != null) {

				sb.append(inStr + "\r\n");

			}

			outStr = sb.toString();

			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");

			writer.write(outStr);
			// ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
			writer.flush();
			// �����ǹر����������
			out.close();

			br.close();

			writer.close();

			falg = true;

		} catch (Exception e) {

			e.printStackTrace();

			falg = false;

		}

		return falg;

	}


	
}

