package generic_utilites;

import java.util.Random;

public class Java_Utilities {
	public int getRandomNumber()
	{
		Random ran=new Random();
		int randomNumber = ran.nextInt(1000);
		return randomNumber;
	}

}
