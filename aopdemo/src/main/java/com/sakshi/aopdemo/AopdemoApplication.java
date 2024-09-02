package com.sakshi.aopdemo;

import com.sakshi.aopdemo.dao.AccountDAO;
import com.sakshi.aopdemo.dao.MembershipDAO;
import com.sakshi.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.concurrent.SuccessCallback;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService thetrafficFortuneService){
		return runner-> {
			//demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(thetrafficFortuneService);
			//demoTheArroundAdviceHandleException(thetrafficFortuneService);

			demoTheArroundAdviceRethrowException(thetrafficFortuneService);


		};
	}

	private void demoTheArroundAdviceRethrowException(TrafficFortuneService thetrafficFortuneService) {

		System.out.println("\nMain Program: demoTheArroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = thetrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheArroundAdviceHandleException(TrafficFortuneService thetrafficFortuneService) {

		System.out.println("\nMain Program: demoTheArroundAdviceHandleException");

		System.out.println("Calling getFortune()");

         boolean tripWire = true;
		String data = thetrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService thetrafficFortuneService) {

		System.out.println("\nMain Program: demoTheArroundAdvice");

		System.out.println("Calling getFortune()");

		String data = thetrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

		//call method to find the accounts
		List<Account> theAccounts = null;

		try{
			//add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}

		catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: " + exc);
		}
		//display the accounts

		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");










	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		//call method to find the accounts
		List<Account> theAccounts = null;

		try{
			//add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}

		catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: " + exc);
		}
		//display the accounts

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");





	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		//call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		//display the accounts

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO) {

		//call the business method

		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");

		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();



		//call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name=theAccountDAO.getName();
		String code= theAccountDAO.getServiceCode();



		//call the membership business method

		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}

}