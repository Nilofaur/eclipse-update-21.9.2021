package SQL;

public class SQLinitialisation {

	
	String breakfast ;
	 String lunch ;
	 String evening_snack ;
	  String dinner ;
	 	public  String days ;
	 	
	 	
	 	// ABOUTME PAGE TO MANUALUPDATE
	 	
	 	String height;
	 	String weight;
	 	
	 	public String getHeight() {
			return height;
		}
		public void setHeight(String height) {
			this.height = height;
		}
		public String getWeight() {
			return weight;
		}
		public void setWeight(String weight) {
			this.weight = weight;
		}

	 	
	 	
	 
	 	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	public String getLunch() {
		return lunch;
	}
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	public String getEvening_snack() {
		return evening_snack;
	}
	public void setEvening_snack(String evening_snack) {
		this.evening_snack = evening_snack;
	}
	public String getDinner() {
		return dinner;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}

	 @Override
		public String toString() {
		 
			//return " [days=" + days + "+breakfast=" + breakfast + "+lunch=" + lunch + "+evening_snack=" 
			//+ evening_snack + "+dinner=" + dinner +"]";
		 
		 
		return " " + days + "  " + breakfast + "  " + lunch + "  " 
		+ evening_snack + "  " + dinner +"  ";

			}
		
	
}
