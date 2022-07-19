/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mfa.enums;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author Terry Keyrouz
 */
public class AuthenticationMethodTest {

    /**
     * Test if the enum exist.
     */
    @Test
    public void testAuthenticationMethodEnums() {
        assertNotNull(AuthenticationMethod.valueOf("EMAIL"));
        assertNotNull(AuthenticationMethod.valueOf("MOBILE"));
        assertNotNull(AuthenticationMethod.valueOf("APPLICATION"));
    }
}
