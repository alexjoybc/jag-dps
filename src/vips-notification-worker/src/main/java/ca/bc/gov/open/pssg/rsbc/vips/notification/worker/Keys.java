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
    public static final String VIPS_QUEUE_NAME = VIPS_VALUE + "_queue";

    /**
     * DO NOT CHANGE - The default output notification value.
     */
    public static final String OUTPUT_NOTIFICATION_VALUE = "outputNotification";

    public static final String SFTP_RELEASE_DIR = "release";
    public static final String SFTP_ARCHIVE_DIR = "archive";
    public static final String SFTP_ERROR_DIR = "error";


}
