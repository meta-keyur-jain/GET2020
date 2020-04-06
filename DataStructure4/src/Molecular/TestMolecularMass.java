package Molecular;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestMolecularMass {
    MolecularMass molecule = new MolecularMass();

    @Test
    public void test1() {
        String string = "CH2(OH)2";
        int molecularMass = molecule.calculateMolecularMass(string);
        int expected = 48;
        assertEquals(expected, molecularMass);
         
    } 

    @Test 
    public void test2() {
        String string = "CH3(CH2)4CH3";
        int molecularMass = molecule.calculateMolecularMass(string);
        int expected = 74;
        assertEquals(expected, molecularMass);
        
    }
}
 