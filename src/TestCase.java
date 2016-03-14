
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.test.kataChallenge.common.Constants;
import com.test.kataChallenge.userInputOperations.UserInput;

public class TestCase {

	/*
	 * Valid Test Cases
	 */
	   String[] input1={"1","2","3","4","5"};
	   String[] input2={"1","1","3","4","5"};
	   String[] input3={"1","1","1","4","5"};
	   String[] input4={"1","1","1","1","5"};
	   String[] input5={"1","1","1","1","1"};
	   String[] input6={"1","1","1","5","5"};
	   
	/*
	 * InValid Test Cases
	 */	   
	   String[] input7={"99","11","3","4","5"};
	   String[] input8={"1","1","1","4","5","6"};
	   String[] input9={" "," ","1"};
	   String[] input10={"1","$$","1","1","1"};
	   String[] input11={"1","99","1","5","5"};
	   String[] input12={"1","1","88","5","5"};

	   UserInput userInput=new UserInput();

	
	   @Test
	   public void testValidate(){		   
		   assertEquals(Constants.validInput,userInput.validateInput(input1));
		   assertEquals(Constants.validInput,userInput.validateInput(input2));
		   assertEquals(Constants.validInput,userInput.validateInput(input3));
		   assertEquals(Constants.validInput,userInput.validateInput(input4));
		   assertEquals(Constants.validInput,userInput.validateInput(input5));
		   assertEquals(Constants.validInput,userInput.validateInput(input6));

		   assertEquals(Constants.invalidInput,userInput.validateInput(input7));
		   assertEquals(Constants.invalidInput,userInput.validateInput(input8));
		   assertEquals(Constants.invalidInput,userInput.validateInput(input9));
		   assertEquals(Constants.invalidInput,userInput.validateInput(input10));
		   assertEquals(Constants.invalidInput,userInput.validateInput(input11));		   

		   
	   }

}
