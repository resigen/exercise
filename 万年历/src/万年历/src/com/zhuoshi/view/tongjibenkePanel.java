package com.zhuoshi.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Action;

import com.zhuoshi.action.BenkeShengyuanAction;
import com.zhuoshi.bean.BenZhuanBean;
import com.zhuoshi.bean.BenkeShengyuanBean;
import com.zhuoshi.bean.StudentBean;
import com.zhuoshi.tool.ExcelExportCollege;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class tongjibenkePanel extends JPanel {
	private JTable table;
	private JScrollPane scrollPane;
	private BenkeShengyuanAction ba;
	
	public tongjibenkePanel() {
		this.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 84, 519, 335);
		add(scrollPane);
		
		JButton butdaochu = new JButton("\u5BFC\u51FA");
		butdaochu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
 				JFileChooser jfc = new JFileChooser();
				int result = jfc.showSaveDialog(null);
				if (result == 0) {
		 			File file = jfc.getSelectedFile();
					String name = file.getName();
					if (!name.contains(".xls")) {
						name += ".xls";
						file = new File(file.getParentFile() + "/" + name);
					}
					List<String> dtm = new ArrayList<String>();
					dtm.add("院系/地区");
					ba = new BenkeShengyuanAction();
					List<BenkeShengyuanBean> beans = ba.selectashengyuandi();
					List<BenkeShengyuanBean> zybeans=ba.selectallzhuanye();
					String dname = null;
					for (int n = 2; n < beans.size(); n++) {
						dname = beans.get(n).getShengyuandi();
						dtm.add(dname);
					}
					List<String[]> data = new ArrayList<String[]>();
					for(BenkeShengyuanBean zyb:zybeans){
						String[] row=new String[dtm.size()];
						row[0]=zyb.getZhuanye();
						for(int i=1; i<dtm.size();i++){
							row[i]=ba.selectCount(zyb.getZhuanye(),dtm.get(i).toString())+"";
						}					
						data.add(row);
					}
					String title = name.substring(0,name.length()-4);
					boolean flag=false;
					try{
						flag=ExcelExportCollege.exportExcel(dtm, data,file, title);
					}catch(Exception ex){
						ex.printStackTrace();
					}
					if(false){
						JOptionPane.showMessageDialog(null, "导出成功");
					}
						
				}

			}
		});
		butdaochu.setBounds(262, 450, 93, 23);
		add(butdaochu);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u751F\u6E90\u5730\u7EDF\u8BA1");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(216, 28, 219, 30);
		add(lblNewLabel);
		
		initTable();
	}	
	    
	
		private void initTable(){
			DefaultTableModel dtm = new DefaultTableModel();
			BenkeShengyuanAction ba =new BenkeShengyuanAction();
			List<BenkeShengyuanBean> beans=ba.selectashengyuandi();
			List<BenkeShengyuanBean> zybeans=ba.selectallzhuanye();
			dtm.addColumn("院系/地区");
			String dname=null;
			for(int n=2;n<beans.size();n++){
				dname=beans.get(n).getShengyuandi();
				dtm.addColumn(dname);
			}
			for(BenkeShengyuanBean zyb:zybeans){
				Vector<Comparable> row=new Vector <Comparable>();
				row.add(zyb.getZhuanye());
				for(int i=1;i<dtm.getColumnCount();i++){
					int count=ba.selectCount(zyb.getZhuanye(),dtm.getColumnName(i));
					row.add(count);						
				}
				dtm.addRow(row);
			}
		
		

//		DefaultTableModel dtm = new DefaultTableModel();
//		ba= new BenkeShengyuanAction();
//		List<BenkeShengyuanBean> syds= ba.selectashengyuandi();
//	    for(BenkeShengyuanBean bksy:syds)
//	    {
//	    	dtm.addColumn(bksy.getShengyuandi());			
//	    }
//	    dtm.addColumn("总数");
	
	    table = new JTable(dtm);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    table.repaint();
	    scrollPane.setViewportView(table);

		}	
}
