package abcd.pages;

import abcd.utilities.Driver;

public class PageInitializer extends Driver {

    public static SamplePage samplePage;
    public static BookingComPage bookingCom;

    public static void initialize(){
      samplePage=new SamplePage();
      bookingCom=new BookingComPage();

    }


}
