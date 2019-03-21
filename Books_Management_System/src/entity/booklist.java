package entity;

public class booklist {



	//保存行数据

		//ID NAME                 price                         AGE ADDRESS
		private int id;
		private String name;
		private String price;
		private String auth;
		private String pub_date;
		private String press;
		private String states;
		
		
		
		
		
		
		public booklist() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		
		
		
		
		public booklist(int id, String name, String price, String auth, String pub_date,
				String press,String states) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.auth = auth;
			this.pub_date = pub_date;
			this.press = press;
			this.states = states;
			
//			this.title = title;
		}





		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getprice() {
			return price;
		}
		public void setprice(String price) {
			this.price = price;
		}
		public String getauth() {
			return auth;
		}
		public void setauth(String auth) {
			this.auth = auth;
		}
		public String getpub_date() {
			return pub_date;
		}
		public void setpub_date(String pub_date) {
			this.pub_date = pub_date;
		}
		public String press() {
			return pub_date;
		}
		public void press(String press) {
			this.press = press;
		}
		public String getpress() {
			return press;
		}
		public void setpress(String press) {
			this.press = press;
		}
		public String getstates() {
			return states;
		}
		public void setstates(String states) {
			this.states = states;
		}
	}


