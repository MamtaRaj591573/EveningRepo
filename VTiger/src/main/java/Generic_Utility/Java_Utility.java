package Generic_Utility;

import java.util.Random;

public class Java_Utility 
{
		/**this method is used to avoid duplicates values
		 * @author HP
		 */
		public int getRandomNum()
		{
			Random rannum=new Random();
			int value=rannum.nextInt(1000);
			return value;
		}

}
