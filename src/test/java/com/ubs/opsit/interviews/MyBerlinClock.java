public class BerlinClock implements TimeConverter {

	/* (non-Javadoc)
	 * @see com.ubs.opsit.interviews.TimeConverter#convertTime(java.lang.String)
	 */
	 
	@Override
	public String convertTime(String givenTime) {
		
		System.out.println(givenTime);
		
		String timeSlice[]= givenTime.split(":");
		
		String getSecondsCol = (Integer.valueOf(timeSlice[2]).intValue()%2 == 0) ? "Y\r\n" : "O\r\n";
		
		StringBuffer berlinClockTime = new StringBuffer(getSecondsCol);
		
		//Set givenTime in berlinClockTime
		
		berlinClockTime.append(getBerlinClockHours(timeSlice[0]));
		berlinClockTime.append(getBerlinMinutes(timeSlice[1]));
		
		return berlinClockTime.toString();
	}

	private String getBerlinMinutes(String minutes) {
	
		int minutesInteger = Integer.valueOf(minutes).intValue();
		StringBuffer BerlinClockMinutes = new StringBuffer("");
		
		for(int count = 1; count <= minutesInteger/5; count++){
		
			if(count == 3 || count == 6 || count == 9){
				BerlinClockMinutes.append("R");
			}else {
				BerlinClockMinutes.append("Y");
			}
		}
		
		for(int j=1;j <= 11 - (minutesInteger/5);j++){
		
			BerlinClockMinutes.append("O");
		
		}
		
		BerlinClockMinutes.append("\r\n");
		
		if(minutesInteger%5 == 1){
			BerlinClockMinutes.append("YOOO");
		}else if(minutesInteger%5 == 2){
			BerlinClockMinutes.append("YYOO");
		}else if(minutesInteger%5 == 3){
			BerlinClockMinutes.append("YYYO");
		}else if(minutesInteger%5 == 4){
			BerlinClockMinutes.append("YYYY");
		}else if(minutesInteger%5 == 0){
			BerlinClockMinutes.append("OOOO");
		}
		
		return BerlinClockMinutes.toString();
	}

	private String getBerlinClockHours(String hours) {
		
		int hoursInteger = Integer.valueOf(hours).intValue();
		String BerlinClockHours = "";
		
		if(hoursInteger>=20){
			BerlinClockHours = "RRRR\r\n";
		}else if(hoursInteger>=15){
			BerlinClockHours = "RRRO\r\n";
		}else if(hoursInteger>=10){
			BerlinClockHours = "RROO\r\n";
		}else if(hoursInteger>= 5){
			BerlinClockHours = "ROOO\r\n";
		}else {
			BerlinClockHours = "OOOO\r\n";
	}
	
		if(hoursInteger%5 == 1){
			BerlinClockHours = BerlinClockHours + "ROOO\r\n";
		}else if(hoursInteger%5 == 2){
			BerlinClockHours = BerlinClockHours + "RROO\r\n";
		}else if(hoursInteger%5 == 3){
			BerlinClockHours = BerlinClockHours + "RRRO\r\n";
		}else if(hoursInteger%5 == 4){
			BerlinClockHours = BerlinClockHours + "RRRR\r\n";
		}else if(hoursInteger%5 == 0){
			BerlinClockHours = BerlinClockHours + "OOOO\r\n";
		}
		
		return BerlinClockHours;
	}

}
