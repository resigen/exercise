package com.zhuoshi.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.zhuoshi.action.BenZhuanAction;
import com.zhuoshi.action.BenZhuanAction;
import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.tool.CheckHeaderCellRenderer;
import com.zhuoshi.tool.CheckTableModle;
import com.zhuoshi.tool.ExcelOperate;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BenZhuanView extends JPanel {
	private JTextField txtzycode;
	private JTextField txtzyname;
	private JTable table;
	private JScrollPane scrollPane;
	private int rowsByPage=17;//ÿҳ����
	private int pages= 0;//һ������ҳ
	private int currentPage= 1;//��ǰ�ǵڼ�ҳ
	private int totalRows = 0;//һ������������
	private JButton btnFirst;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnLast;

	/**
	 * Create the panel.
	 */
	private void initPage()
	{
		BenZhuanAction action =new BenZhuanAction();
		//����һ���ж���������
		int totalRows = action.count();
		
		//����һ���ж���ҳ
		if(totalRows%rowsByPage==0)
		{
			pages=totalRows/rowsByPage;
		}else{
			pages=totalRows/rowsByPage+1;
		}
	}
	public BenZhuanView() {
		initPage();
		this.setLayout(null);

		JLabel lblzycode = new JLabel("\u4E13\u4E1A\u4EE3\u7801");
		lblzycode.setBounds(108, 39, 54, 15);
		add(lblzycode);

		txtzycode = new JTextField();
		txtzycode.setBounds(187, 36, 259, 21);
		add(txtzycode);
		txtzycode.setColumns(10);

		JLabel lblzyname = new JLabel("\u4E13\u4E1A\u540D\u79F0");
		lblzyname.setBounds(108, 81, 54, 15);
		add(lblzyname);

		txtzyname = new JTextField();
		txtzyname.setBounds(187, 78, 259, 21);
		add(txtzyname);
		txtzyname.setColumns(10);

		JButton btnAdd = new JButton("\u6DFB\u52A0");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = 0;
				if(!txtzycode.getText().equals("")&&!txtzyname.getText().equals(""))
				{
				String code = txtzycode.getText();
				String name = txtzyname.getText();
				BenZhuanBean bean = new BenZhuanBean();
				bean.setBzzycode(code);
				bean.setBzzyname(name);
				BenZhuanAction action = new BenZhuanAction();
				n = action.addBenzhuan(bean);
			}else
			{
				JOptionPane.showMessageDialog(null,"�����������Ϣ");
			}
				if (n > 0) {
					BenZhuanView show = new BenZhuanView();
					// �����µ���壬����С��ԭ����һ��
					show.setSize(MainFrame.rightPanel.getSize());
					// �Ƴ�ԭ������Ϣ
					MainFrame.rightPanel.removeAll();
					MainFrame.rightPanel.add(show);
					MainFrame.rightPanel.repaint();
				}
			}
		});
		btnAdd.setBounds(160, 119, 93, 23);
		add(btnAdd);

		JButton btnAddall = new JButton("\u6279\u91CF\u6DFB\u52A0");
		btnAddall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jfc = new JFileChooser("c://");
					int n = jfc.showOpenDialog(null);
					if (n == 0) {
						File file = jfc.getSelectedFile();
						String[][] result = ExcelOperate.getData(file, 1);
						int rowLength = result.length;
						List<BenZhuanBean> benzhuans = new ArrayList<BenZhuanBean>();
						for (int i = 0; i < rowLength; i++) {
							BenZhuanBean bean = new BenZhuanBean();
							bean.setBzzycode(result[i][0]);
							bean.setBzzyname(result[i][1]);
							benzhuans.add(bean);
						}
						System.out.println();
						BenZhuanAction action = new BenZhuanAction();
						int k = action.addBenzhuans(benzhuans);
						if (k == 0) {
							JOptionPane.showMessageDialog(null, "����ɹ�");
							BenZhuanView show = new BenZhuanView();
							// �����µ���壬����С��ԭ����һ��
							show.setSize(MainFrame.rightPanel.getSize());
							// �Ƴ�ԭ������Ϣ
							MainFrame.rightPanel.removeAll();
							MainFrame.rightPanel.add(show);
							MainFrame.rightPanel.repaint();
						}
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		btnAddall.setBounds(314, 119, 93, 23);
		add(btnAddall);

		JButton btnDeleteall = new JButton("\u6279\u91CF\u5220\u9664");
		btnDeleteall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<BenZhuanBean> benzhuans = new ArrayList<BenZhuanBean>();
				for(int i=0;i<rowsByPage;i++)
				{
					boolean result =(Boolean) table.getValueAt(i,0);
					int id=(Integer)table.getValueAt(i,1);
					if(result!=false)
					{
						BenZhuanBean bean = new BenZhuanBean();
					    bean.setId(id); 
					    benzhuans.add(bean);
					}
				}
				BenZhuanAction action = new BenZhuanAction();
				int k = action.delectallBenzhuans(benzhuans);
				if (k == 0) {
					if(benzhuans.size()>0)
					{
					JOptionPane.showMessageDialog(null, "����ɾ���ɹ�");
					}else{
						JOptionPane.showMessageDialog(null, "��ѡ��");
					}
					BenZhuanView show = new BenZhuanView();
					// �����µ���壬����С��ԭ����һ��
					show.setSize(MainFrame.rightPanel.getSize());
					// �Ƴ�ԭ������Ϣ
					MainFrame.rightPanel.removeAll();
					MainFrame.rightPanel.add(show);
					MainFrame.rightPanel.repaint();
				}
			}
		});
		btnDeleteall.setBounds(460, 119, 93, 23);
		add(btnDeleteall);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 167, 525, 300);
		add(scrollPane);
		
		JButton btnSelect = new JButton("\u67E5\u8BE2");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BenZhuanBean bean = new BenZhuanBean();				
					bean.setBzzyname(txtzyname.getText());					
					bean.setBzzycode(txtzycode.getText());				
					BenZhuanAction action = new BenZhuanAction();
					List<BenZhuanBean> benzhuans = action.selectAll(bean, 0, 0);
					initTable(benzhuans);
				}
		});
		btnSelect.setBounds(28, 119, 93, 23);
		add(btnSelect);
		
		btnFirst = new JButton("\u7B2C\u4E00\u9875");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPage=1;
				BenZhuanAction action = new BenZhuanAction();
				List<BenZhuanBean> benzhuans= action.selectAll(null,currentPage-1,rowsByPage);
				initTable(benzhuans); 
			}
		});
		btnFirst.setBounds(28,477, 79, 23);
		add(btnFirst);
		
		btnPrevious = new JButton("\u4E0A\u4E00\u9875");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentPage==1)
				{
					JOptionPane.showMessageDialog(null,"�Ѿ�����һҳ");
				}
				if (currentPage>1) {
					currentPage--;
					BenZhuanAction action = new BenZhuanAction();
					List<BenZhuanBean> benzhuans= action.selectAll(null,(currentPage - 1) * rowsByPage,rowsByPage);
					initTable(benzhuans); 
				}
				
			}
		});
		btnPrevious.setBounds(192,477, 77, 23);
		add(btnPrevious);
		
		btnNext = new JButton("\u4E0B\u4E00\u9875");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentPage==pages)
				{
					JOptionPane.showMessageDialog(null,"�Ѿ������һҳ");
				}
				if (currentPage < pages) {
					currentPage++;
					BenZhuanAction action = new BenZhuanAction();
					List<BenZhuanBean> benzhuans= action.selectAll(null,(currentPage - 1) * rowsByPage,rowsByPage);
					initTable(benzhuans); 
				}
				
			}
		});
		btnNext.setBounds(333,477, 77, 23);
		add(btnNext);
		
		btnLast = new JButton("\u6700\u540E\u4E00\u9875");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPage = pages;
				BenZhuanAction action = new BenZhuanAction();
				List<BenZhuanBean> benzhuans = action.selectAll(null, (currentPage - 1) * rowsByPage, rowsByPage);
				initTable(benzhuans);
			}
		});
		btnLast.setBounds(467,477, 86, 23);
		add(btnLast);
		
		BenZhuanAction action = new BenZhuanAction();
		List<BenZhuanBean> benzhuans= action.selectAll(null, 0, 0);
		initTable(benzhuans);
		
	}
	private void initTable(List<BenZhuanBean> benzhuans) {
		//DefaultTableModel dtm = new DefaultTableModel();
//		// ��ӱ�ͷ����
//        dtm.add("ȫѡ/ȫ��ѡ");
//		dtm.add("���");
//		dtm.add("רҵ����");
//		dtm.add("רҵ����");
//		dtm.add("");
//		dtm.add("");
		
		Vector date = new Vector();
		// ��ӱ������
		for (BenZhuanBean benzhuan : benzhuans) {
			Vector row = new Vector();
			row.add(false);
			row.add(benzhuan.getId());
			row.add(benzhuan.getBzzycode());
			row.add(benzhuan.getBzzyname());
			row.add("�޸�");
			row.add("ɾ��");			
			date.add(row);
		}
		Vector headNames = new Vector();
		headNames.add("ȫѡ");
		headNames.add("���");
		headNames.add("רҵ����");
		headNames.add("רҵ����");
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
				int id = Integer.parseInt(table.getValueAt(row,1).toString());

				if (column == 4) {
					// ��ʾ�޸ĶԻ��� (ģʽ�Ի���)
					UpdateBenZhuanDialog bzdialog = new UpdateBenZhuanDialog(id);
					Test.updateBenZhuanDialog = bzdialog;
					bzdialog.setVisible(true);

				}
				if (column == 5) {

					int n = JOptionPane.showConfirmDialog(null, "�Ƿ�ɾ��?", "ɾ���Ի���", JOptionPane.YES_NO_OPTION);
					if (n == 0) {
						BenZhuanAction action = new BenZhuanAction();
						action.deleteBenzhuan(id);
					}
				}
				BenZhuanAction action = new BenZhuanAction();
				List<BenZhuanBean> benzhuans = action.selectAll(null, 0, 0);
				initTable(benzhuans);
			}
		});
		scrollPane.setViewportView(table);
	}

}
