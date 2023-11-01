package commonLibs.utils;

public class Constants {
    public static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
    public static final String DS = System.getProperty("file.separator");
    public static final String DRIVERS_DIRECTORY = CURRENT_DIRECTORY + DS + "src" + DS + "Libs" + DS;
    public static final String CONFIG_DIRECTORY = CURRENT_DIRECTORY + DS + "config" + DS;
    public static final String REPORTS_DIRECTORY = CONFIG_DIRECTORY + DS + "reports" + DS;
    public static final String SCREENSHOTS_DIRECTORY = CONFIG_DIRECTORY + DS + "screenshots" + DS;
}
