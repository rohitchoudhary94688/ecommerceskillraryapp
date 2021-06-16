package scripts;

import org.testng.annotations.Test;

import genericlib.Baseclass;
import pom.Addtocartpage;
import pom.Skillrarydemologinpage;
import pom.Skillraryloginpage;

public class Addingcoursestocart extends Baseclass {
    @Test
    public void tc1() {
    	Skillraryloginpage s=new Skillraryloginpage(driver);
    	s.gearsbutton();
    	s.skillrarydemoapplication();
    	utilities.switchingtabs(driver);
    	
    	Skillrarydemologinpage d=new Skillrarydemologinpage(driver);
    	utilities.mousehover(driver, d.getCoursebtn());
    	d.seleniumtraining();
    	
    	Addtocartpage e=new Addtocartpage(driver);
    	utilities.doubleclick(driver,e.getPlusbtn());
    	e.addtocartbutton();
    	
    	utilities.alertpopup(driver);
    }
}
