package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.UserDAO;
import Dao.booklistDAO;
import entity.booklist;

	public class manage extends JFrame {
		
		

		String data[][]=new String[0][0];
	    String names[]={"���","�鼮","�۸�","����","����ʱ��","������","�Ƿ���"};	           
		
		//String data[][]=new String[3][3];
		
		//String data[][]={ {},{},{} };
		
		JTextField txt=new JTextField();
		
		JButton btn=new JButton("��ѯ");
		JButton deleteBtn=new JButton("ɾ��");
		JButton updateBtn=new JButton("�޸�");
		
		//�������JScrollPane��
		JTable jt=new JTable(data,names);
		
		JScrollPane jsp=new JScrollPane(jt);
		
		public manage()
		{
			txt.setBounds(10, 10,150,30);
			btn.setBounds(170, 10,70, 30);
			
			jsp.setBounds(10, 50,400,100);
			
			deleteBtn.setBounds(10, 160,70,30);
			updateBtn.setBounds(100, 160,70,30);
			
		
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					query();
					
				}
			});
			
			
			deleteBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					delete();
				}
			});


			updateBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					update();
				}
			});
			
			//jt.getTableHeader().setReorderingAllowed(false);
			this.getContentPane().setLayout(null);
			this.getContentPane().add(txt);
			this.getContentPane().add(btn);
			this.getContentPane().add(jsp);
			this.getContentPane().add(deleteBtn);
			this.getContentPane().add(updateBtn);
			
			
			
			this.setSize(600,600);
			
			this.setVisible(true);
			
		}
		public void query()
		{
			//��ȡ�ı����ֵ
			String name=txt.getText();
			//ʹ�����ֵ ��Ϊ��ѯ����  ��ѯ����ƥ���users
booklistDAO dao=new booklistDAO();
			
			
			ArrayList<booklist> bookList=dao.getbooklistByName(name);
			
			//��bookList�е����� ��ӵ������
			
//			�����---���� ����ά���飩 ���⣨һά���飩
			//�������е����� ת��Ϊ ��ά����
			
			Object contents[][]=new Object[bookList.size()][7];
			
			for(int i=0;i<bookList.size();i++)
			{
				booklist u=bookList.get(i);
				contents[i][0]=u.getId();
				contents[i][1]=u.getName();
				contents[i][2]=u.getprice();
				contents[i][3]=u.getauth();
				contents[i][4]=u.getpub_date();
				contents[i][5]=u.getpress();
				contents[i][6]=u.getstates();
			}
			
			//����һ������ģ��
			DefaultTableModel dtm=new DefaultTableModel(contents, names);
			
			jt.setModel(dtm);
			
		}
		
		public void delete()
		{
			//1.��ȡѡ����һ�еĵ�һ����Ԫ���ֵ
			
			int row=jt.getSelectedRow();
			if(row==-1)
			{
				JOptionPane.showMessageDialog(this,  "��ѡ����Ҫɾ������","������Ϣ", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int id=(Integer)jt.getValueAt(row, 0);
			System.out.println(id);
			
			//2.����dao�㣬ɾ��
			
			booklistDAO dao=new booklistDAO();
			
			boolean flag=dao.delete(id);
			
			if(flag)
			{
				JOptionPane.showMessageDialog(this,"ɾ���ɹ�", "ɾ��",  JOptionPane.ERROR_MESSAGE);
				query();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"ɾ��ʧ��",  "ɾ��", JOptionPane.ERROR_MESSAGE);
				query();
			}
			
			
		}
		
		
		
		public void update()
		{
			//��ȡ�û�ѡ�����
			
			//���ûѡ�� ��ʾ����
			int row=jt.getSelectedRow();
			if(row==-1)
			{
				JOptionPane.showMessageDialog(this,  "��ѡ����Ҫ�޸ĵ���","������Ϣ", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			//��ȡ7��ֵ
			
			int id=(Integer)jt.getValueAt(row, 0);
			
			String name=jt.getValueAt(row, 1).toString();
			
			String price=jt.getValueAt(row, 2).toString();
			
			String auth=jt.getValueAt(row, 3).toString();
			
			String pub_date=jt.getValueAt(row, 4).toString();
			
			String press=jt.getValueAt(row, 5).toString();
			
			String states=jt.getValueAt(row, 6).toString();
			
			booklist u=new booklist(id,name,price,auth,pub_date,press,states);
			
//			�򿪸��´���
			updateFrame uf=new updateFrame();
			
			uf.idTxt.setText(id+"");
			uf.nameTxt.setText(name);
			uf.priceTxt.setText(price);
			uf.authTxt.setText(auth);
			uf.pub_dateTxt.setText(pub_date);
			uf.pressTxt.setText(press);
			uf.statesTxt.setText(states);
		}
			
			

			
			
			
}



