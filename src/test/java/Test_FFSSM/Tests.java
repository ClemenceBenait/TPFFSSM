package Test_FFSSM;

import FFSSM.Club;
import FFSSM.Licence;
import FFSSM.Personne;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 *
 * @author cbenait
 */
public class Tests {
    public Club clubA;
    public Plongeur pA;
    public Plongeur pB;
    public Plongeur pC;
    public Licence licence1;
    public Licence licence2;
    public Licence licence3;
    public Plongee plongee1;
    public Plongee plongee2;
    
    @Before
	public void setUp() {
        clubA = new Club(null, "aaa", null);
        pA = new Plongeur("1234", "Dupont", "Paul", "xxx", "xxx", null);
        pB = new Plongeur("123456", "Durand", "Pierre", "xxx", "xxx", null);
        pC = new Plongeur("123", "Dubois", "Jacques", "xxx", "xxx", null);
        Calendar delivrance = Calendar.getInstance();
        delivrance.add(Calendar.MINUTE, -10);
        Calendar delivrancePlusDeux = Calendar.getInstance();
        delivrancePlusDeux.add(Calendar.YEAR, -2);
        licence1 = new Licence(pA,"1", delivrance,2,clubA);
        licence2 = new Licence(pB,"2", delivrance,4,clubA);
        licence3 = new Licence(pC,"2", delivrancePlusDeux,4,clubA);
        plongee1= new Plongee(null,null,null,2,2);
        plongee2= new Plongee(null,null,null,10,10);
        
        }
    
        @Test
	public void testLicenceValide() {
	
		Calendar delivrance = Calendar.getInstance();
                               
 		assertTrue(licence1.estValide(delivrance));
		
		Calendar testUnAnUnjour = (Calendar) delivrance.clone();
		testUnAnUnjour.add(Calendar.YEAR, 1);
                testUnAnUnjour.add(Calendar.DAY_OF_YEAR, 1);
                
                assertTrue(!licence1.estValide(testUnAnUnjour));
                
	}
        @Test
        public void testPlongeeEstConforme() {
            pA.ajoutLicence(licence1);
            pB.ajoutLicence(licence2);
            pC.ajoutLicence(licence3);
            
            plongee1.ajouteParticipant(pA);
            plongee1.ajouteParticipant(pB);
            assertTrue(plongee1.estConforme());
            
            plongee2.ajouteParticipant(pA);
            plongee2.ajouteParticipant(pC);
            assertFalse(plongee2.estConforme());
        }
        
        @Test
        public void testClubPlongeesNonConformes() {
            
          
            pC.ajoutLicence(licence3);
            plongee2.ajouteParticipant(pC);
            
            clubA.organisePlongee(plongee2);
            assertTrue(clubA.plongeesNonConformes().contains(plongee2));
        }
}
