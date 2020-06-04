package ca.bc.gov.open.pssg.rsbc.vips.notification.worker;

public class Keys {



    private Keys() {}


    /**
     * The VIPS value for usage across the app
     */
    public static final String VIPS_VALUE = "VIPS";

    /**
     * DO NOT CHANGE - The name of the CRRP queue
     */
    public static final String VIPS_QUEUE_NAME = VIPS_VALUE + ".notification.Q";
    

    public static final String APP_NAME = "vips-notification-worker";


}
