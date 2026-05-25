/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.userloginsystem1;
 
import org.junit.jupiter.api.AfterEach; 
import org.junit.jupiter.api.AfterAll; 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.BeforeAll; 
import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 
 
/** 
 * Part 1 Unit Testing 
 * @author Mukoni 
 */ 
public class UserloginSystem1IT { 
 
    public UserloginSystem1IT() { 
    } 
 
    /** 
     * Runs once before all tests 
     */ 
    @BeforeAll 
    public static void setUpClass() { 
 
        System.out.println("Starting test..."); 
    } 
 
    /** 
     * Runs once after all tests 
     */ 
    @AfterAll   
 
    public static void tearDownClass() { 
 
        System.out.println("Test completed."); 
    } 
 
    /** 
     * Runs before each test 
     */ 
    @BeforeEach 
    public void setUp() { 
 
        System.out.println("Running test..."); 
    } 
 
    /** 
     * Runs after each test 
     */ 
    @AfterEach 
    public void tearDown() { 
 
        System.out.println("Test finished."); 
    } 
 
    /** 
     * Test correct username 
     */ 
    @Test 
    public void testUsername() { 
 
        boolean answer = 
        UserloginSystem1.checkUsername("muk_1"); 
 
 
        assertTrue(answer); 
    } 
 
    /** 
     * Test incorrect username 
     */ 
    @Test 
    public void testWrongUsername() { 
 
        boolean answer = 
        UserloginSystem1.checkUsername("mukoni"); 
 
        assertFalse(answer); 
    } 
 
    /** 
     * Test correct password 
     */ 
    @Test 
    public void testPassword() { 
 
        boolean answer = 
        UserloginSystem1.checkPasswordComplexity("Muko@123"); 
 
        assertTrue(answer); 
    } 
 
    /** 
     * Test incorrect password 
     */ 
    @Test 
    public void testWrongPassword() { 
 
        boolean answer = 
        UserloginSystem1.checkPasswordComplexity("password"); 
 
        assertFalse(answer); 
    } 
 
    /** 
     * Test correct cellphone number 
     */ 
    @Test 
    public void testCellphone() { 
 
        boolean answer = 
        UserloginSystem1.checkCellphoneNumber("+27681653327"); 
 
        assertTrue(answer); 
    } 
 
    /** 
     * Test incorrect cellphone number 
     */ 
    @Test 
    public void testWrongCellphone() { 
 
        boolean answer = 
        UserloginSystem1.checkCellphoneNumber("0681653327"); 
 
        assertFalse(answer);  
    } 
 
    /** 
     * Test correct login details 
     */ 
    @Test 
    public void testLogin() { 
 
        boolean answer = 
        UserloginSystem1.loginUser("muk_1","Muko@123","muk_1","Muko@123"); 
 
        assertTrue(answer); 
    } 
 
    /** 
     * Test incorrect login details 
     */ 
    @Test 
    public void testWrongLogin() { 
 
        boolean answer = 
        UserloginSystem1.loginUser("muk_1","Muko@123","wrong","123"); 
 
        assertFalse(answer); 
    } 
 
    /** 
     * Test welcome message 
     */ 
    @Test 
    public void testWelcomeMessage() { 
 
        String result = 
        UserloginSystem1.returnLoginStatus(true,"Mukoni","Angela"); 
 
        assertEquals( 
                "Welcome Mukoni Angela, it is great to see you again.",result); 
    } 
 
    /** 
     * Test failed login message 
     */ 
    @Test 
    public void testLoginMessage() { 
 
        String result = 
        UserloginSystem1.returnLoginStatus(false,"Mukoni","Angela"); 
 
        assertEquals( 
        "Username or password incorrect, please try again.",result);}}