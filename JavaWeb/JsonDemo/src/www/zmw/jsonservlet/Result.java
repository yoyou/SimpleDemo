package www.zmw.jsonservlet;

import java.util.List;

public class Result {
		private int result;
		private List<Person> persondata;
		public int getResult() {
			return result;
		}
		public void setResult(int result) {
			this.result = result;
		}
		public List<Person> getList() {
			return persondata;
		}
		public void setList(List<Person> persondata) {
			this.persondata = persondata;
		}
}
