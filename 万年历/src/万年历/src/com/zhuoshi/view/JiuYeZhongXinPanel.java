package com.zhuoshi.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.zhuoshi.action.BenkeShengyuanAction;
import com.zhuoshi.action.UserAction;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.bean.UserBean;
import com.zhuoshi.tool.CheckHeaderCellRenderer;
import com.zhuoshi.tool.CheckTableModle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JiuYeZhongXinPanel extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;

	
	public JiuYeZhongXinPanel() {
		setLayout(null);

		JButton butshenheall = new JButton("\u6279\u91CF\u5BA1\u6838");
		butshenheall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserAction uaction = new UserAction();
			    List<UserBean> stuids =  uaction.selectshenhe(2);
				List<BenkeShengyuanBean> benkesys = new ArrayList<BenkeShengyuanBean>();
				for(int i=0;i<stuids.size();i++)
				{
					boolean result =(Boolean) table.getValueAt(i,0);
					int id=(Integer)table.getValueAt(i,1);
					if(result!=false)
					{
						BenkeShengyuanBean bean = new BenkeShengyuanBean();
					    bean.setId(id); 
					    benkesys.add(bean);
					}
					
				}
				UserAction action = new UserAction();
				int k = action.updateallUserShenheName2(benkesys);
				if (k == 0) {
					if(benkesys.size()>0)
					{
					JOptionPane.showMessageDialog(null, "������˳ɹ�");
					}else{
						JOptionPane.showMessageDialog(null, "��ѡ��");
					}
					FudaoShenhePanel show = new FudaoShenhePanel();
					// �����µ���壬����С��ԭ����һ��
					show.setSize(MainFrame.rightPanel.getSize());
					// �Ƴ�ԭ������Ϣ
					MainFrame.rightPanel.removeAll();
					MainFrame.rightPanel.add(show);
					MainFrame.rightPanel.repaint();
				}
				
			}
		});
		butshenheall.setBounds(483, 46, 93, 23);
		add(butshenheall);

		JLabel lbltop = new JLabel("\u5C31\u4E1A\u6307\u5BFC\u4E2D\u5FC3\u5BA1\u6838");
		lbltop.setFont(new Font("����", Font.PLAIN, 20));
		lbltop.setBounds(243, 21, 181, 35);
		add(lbltop);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 100, 513, 347);
		add(scrollPane);

		UserAction uaction = new UserAction();
		List<UserBean> stuids = uaction.selectshenhe(2);
		List<Integer> ids = new ArrayList<Integer>();
		for (UserBean bean : stuids) {
			ids.add(bean.getStuid());
		}
		BenkeShengyuanAction action = new BenkeShengyuanAction();
		List<BenkeShengyuanBean> benkesys = action.selectAllbyid(ids);

		initTable(benkesys);

	}

		private void initTable(List<BenkeShengyuanBean> benkesys) {		
			Vector date = new Vector();
			// ��ӱ������
			for (BenkeShengyuanBean benkesy : benkesys) {
				Vector row = new Vector();
				row.add(false);
				row.add(benkesy.getId());
				row.add(benkesy.getName());
				row.add(benkesy.getSex());
				row.add(benkesy.getXuehao());
				row.add(benkesy.getZhuanye());
				row.add("��ϸ");					
				row.add("���");				
				date.add(row);
			}
			Vector headNames = new Vector();
			headNames.add("ȫѡ");
			headNames.add("���");
			headNames.add("����");
			headNames.add("�Ա�");
			headNames.add("ѧ��");
			headNames.add("רҵ");
			headNames.add("");
			headNames.add("");
			CheckTableModle c=new CheckTableModle(date,headNames);
			table = new JTable(c);
			table.getTableHeader().setDefaultRenderer(new CheckHeaderCellRenderer(table));
			//table.repaint();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					int id = Integer.parseInt(table.getValueAt(row, 1).toString());

					if (column == 7) {
						UserAction uaction = new UserAction();
						int k=uaction.updateUserShenheName2(id);
						if(k>0){
							JOptionPane.showMessageDialog(null,"���ͨ��");
						}
					    List<UserBean> stuids =  uaction.selectshenhe(2);
						List<Integer> ids=new  ArrayList<Integer>();
					    for(UserBean bean :stuids){
					    	ids.add(bean.getStuid());
					    }
					    BenkeShengyuanAction action = new BenkeShengyuanAction();
						List<BenkeShengyuanBean> benkesys= action.selectAllbyid(ids);
						
						initTable(benkesys);
					
						 
					}
					if (column == 6) {

						BenkeShengyuanxiangxiDialog xidialog = new BenkeShengyuanxiangxiDialog(id);
						Test.benkeShengyuanxiangxiDialog = xidialog;
						xidialog.setVisible(true);
					}
					
					UserAction uaction = new UserAction();
				    List<UserBean> stuids =  uaction.selectshenhe(1);
					List<Integer> ids=new  ArrayList<Integer>();
				    for(UserBean bean :stuids){
				    	ids.add(bean.getStuid());
				    }
				   BenkeShengyuanAction action = new BenkeShengyuanAction();
					List<BenkeShengyuanBean> benkesys= action.selectAllbyid(ids);
					initTable(benkesys);
					
				}
				
			});
			scrollPane.setViewportView(table);


	}

}
