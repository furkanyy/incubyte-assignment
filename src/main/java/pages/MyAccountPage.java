package pages;

import toolset.Actions;

public class MyAccountPage {

    /**
     * UI components.
     */
    private static final String PAGE_HEADER = "My Account";

    /**
     * check the My Account Page's presence
     */
    public void checkMyAccountPage() {
        Actions.verifyResults(PAGE_HEADER);
    }
}
