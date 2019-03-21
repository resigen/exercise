package com.zhuoshi.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.zhuoshi.action.AuthorityAction;
import com.zhuoshi.action.R_AAction;
import com.zhuoshi.action.RiZhiAction;
import com.zhuoshi.bean.AuthorityBean;
import com.zhuoshi.bean.R_ABean;
import com.zhuoshi.bean.RiZiBean;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static  final JPanel rightPanel = new JPanel();

	
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800,600);
		setTitle("��ѧ����ҵ����ϵͳƽ̨");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((screen.getWidth() - getWidth()) / 2);
		int y = (int) ((screen.getHeight() - getHeight()) / 2);
		setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel topPanel = new JPanel();
		topPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		topPanel.setBounds(0, 0,800,50);
		contentPane.add(topPanel);
		topPanel.setLayout(null);

		JLabel lblTop = new JLabel();
		lblTop.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		lblTop.setBounds(216, 10, 418, 30);
		topPanel.add(lblTop);
		lblTop.setText("��ӭʹ�ô�ѧ����Ϣ����ϵͳ");
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date day=new Date();    
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				//System.out.println(df.format(day));
				RiZiBean Rb2 = new RiZiBean();
				Rb2.setAwaytime(df.format(day));
				Test.Rb2=Rb2;
				RiZhiAction ra = new RiZhiAction();
				ra.addrizhi();
				System.exit(0);
			}
		});
		btnNewButton.setBounds(682, 19, 93, 23);
		topPanel.add(btnNewButton);

		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		leftPanel.setBounds(0,50,200,550);
		contentPane.add(leftPanel);
		leftPanel.setLayout(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane();
		leftPanel.add(scrollPane);

		rightPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		rightPanel.setBounds(200,50,600,550);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("img/bg1.gif"); // ���ͼƬ
		JLabel lb_backgroud = new JLabel(img);
		this.getLayeredPane().add(lb_backgroud, new Integer(Integer.MIN_VALUE));
		lb_backgroud.setBounds(-30,50,img.getIconWidth(), img.getIconHeight());
		rightPanel.add(lb_backgroud);

		// �������ڵ�
		AuthorityAction authorityAction = new AuthorityAction();
		AuthorityBean rootBean = authorityAction.selectByPid(-1).get(0);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootBean.getAname());
		initTree(root, rootBean.getId());

		JTree tree = new JTree(root);
		scrollPane.setViewportView(tree);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if (node != null && node.isLeaf()) {
					String value = node.toString();
					AuthorityAction authorityAction = new AuthorityAction();
					String url = authorityAction.selectByAname(value);
					try {
						if (!url.equals("") && url != null) {
							// ���������
							Class c = Class.forName(url);
							// ʵ���������
							Object obj = c.newInstance();
							// ����ת��
							JPanel panel = (JPanel) obj;
							panel.setSize(rightPanel.getSize());
							rightPanel.removeAll();
							rightPanel.add(panel);
							rightPanel.repaint();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});

	}
	//�ݹ������
	//1�Σ��ڵ�  2�Σ����ڵ��id 
	private void initTree(DefaultMutableTreeNode node,int pid){
		AuthorityAction authorityAction =new AuthorityAction();
		//��ѯ���ڵ����м������� 
		List<AuthorityBean> sons =authorityAction.selectByPid(pid);
		if(sons!=null)
		{
			//��������
			for(AuthorityBean son:sons)
			{
				//��ѯ�����¼�ˣ�����ЩȨ��
				R_AAction raaction = new R_AAction();
				//�õ���¼�˽�ɫid
				int rid = Test.userBean.getRid();
				List<R_ABean> ras = raaction.selectByRid(rid);
				for(R_ABean ra :ras)
				{
					if(ra.getAid()==son.getId())
					{
						DefaultMutableTreeNode sonnode=new DefaultMutableTreeNode(son.getAname());
						node.add(sonnode);
						initTree(sonnode,son.getId());
					}
				}
				
				
			}
		}
	}
  
}
