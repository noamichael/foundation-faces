package org.foundationfaces.component.joyride;

/**
 *
 * @author Michael
 */
public class JoyrideStop {

    private boolean expose = false;     // turn on or off the expose feature
    private boolean modal = true;      // Whether to cover page with modal during the tour
    private boolean keyboard = true;      // enable left; right and esc keystrokes
    private String tipLocation = "bottom";  // "top" or "bottom" in relation to parent
    private String nubPosition = "auto";    // override on a per tooltip bases
    private int scrollSpeed = 1500;      // Page scrolling speed in milliseconds; 0 = no scroll animation
    private String scrollAnimation = "linear";  // supports "swing" and "linear"; extend with jQuery UI.
    private int timer = 0;         // 0 = no timer ; all other numbers = timer in milliseconds
    private boolean startTimerOnClick = true;      // true or false - true requires clicking the first button start the timer
    private int startOffset = 0;         // the index of the tooltip you want to start on (index of the li)
    private boolean nextButton = true;      // true or false to control whether a next button is used
    private boolean prevButton = true;      // true or false to control whether a prev button is used
    private String tipAnimation = "fade";    // "pop" or "fade" in each tip
    private int tipAnimationFadeSpeed = 300;       // when tipAnimation = "fade" this is speed in milliseconds for the transition
    private boolean cookieMonster = false;     // true or false to control whether cookies are used
    private String cookieName = "joyride"; // Name the cookie you"ll use
    private boolean cookieDomain = false;     // Will this cookie be attached to a domain; ie. ".notableapp.com"
    private int cookieExpires = 365;       // set when you would like the cookie to expire.
    private String tipContainer = "body";    // Where will the tip be attached

    /**
     * @return the expose
     */
    public boolean isExpose() {
        return expose;
    }

    /**
     * @param expose the expose to set
     */
    public void setExpose(boolean expose) {
        this.expose = expose;
    }

    /**
     * @return the modal
     */
    public boolean isModal() {
        return modal;
    }

    /**
     * @param modal the modal to set
     */
    public void setModal(boolean modal) {
        this.modal = modal;
    }

    /**
     * @return the keyboard
     */
    public boolean isKeyboard() {
        return keyboard;
    }

    /**
     * @param keyboard the keyboard to set
     */
    public void setKeyboard(boolean keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * @return the tipLocation
     */
    public String getTipLocation() {
        return tipLocation;
    }

    /**
     * @param tipLocation the tipLocation to set
     */
    public void setTipLocation(String tipLocation) {
        this.tipLocation = tipLocation;
    }

    /**
     * @return the nubPosition
     */
    public String getNubPosition() {
        return nubPosition;
    }

    /**
     * @param nubPosition the nubPosition to set
     */
    public void setNubPosition(String nubPosition) {
        this.nubPosition = nubPosition;
    }

    /**
     * @return the scrollSpeed
     */
    public int getScrollSpeed() {
        return scrollSpeed;
    }

    /**
     * @param scrollSpeed the scrollSpeed to set
     */
    public void setScrollSpeed(int scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
    }

    /**
     * @return the scrollAnimation
     */
    public String getScrollAnimation() {
        return scrollAnimation;
    }

    /**
     * @param scrollAnimation the scrollAnimation to set
     */
    public void setScrollAnimation(String scrollAnimation) {
        this.scrollAnimation = scrollAnimation;
    }

    /**
     * @return the timer
     */
    public int getTimer() {
        return timer;
    }

    /**
     * @param timer the timer to set
     */
    public void setTimer(int timer) {
        this.timer = timer;
    }

    /**
     * @return the startTimerOnClick
     */
    public boolean isStartTimerOnClick() {
        return startTimerOnClick;
    }

    /**
     * @param startTimerOnClick the startTimerOnClick to set
     */
    public void setStartTimerOnClick(boolean startTimerOnClick) {
        this.startTimerOnClick = startTimerOnClick;
    }

    /**
     * @return the startOffset
     */
    public int getStartOffset() {
        return startOffset;
    }

    /**
     * @param startOffset the startOffset to set
     */
    public void setStartOffset(int startOffset) {
        this.startOffset = startOffset;
    }

    /**
     * @return the nextButton
     */
    public boolean isNextButton() {
        return nextButton;
    }

    /**
     * @param nextButton the nextButton to set
     */
    public void setNextButton(boolean nextButton) {
        this.nextButton = nextButton;
    }

    /**
     * @return the prevButton
     */
    public boolean isPrevButton() {
        return prevButton;
    }

    /**
     * @param prevButton the prevButton to set
     */
    public void setPrevButton(boolean prevButton) {
        this.prevButton = prevButton;
    }

    /**
     * @return the tipAnimation
     */
    public String getTipAnimation() {
        return tipAnimation;
    }

    /**
     * @param tipAnimation the tipAnimation to set
     */
    public void setTipAnimation(String tipAnimation) {
        this.tipAnimation = tipAnimation;
    }

    /**
     * @return the tipAnimationFadeSpeed
     */
    public int getTipAnimationFadeSpeed() {
        return tipAnimationFadeSpeed;
    }

    /**
     * @param tipAnimationFadeSpeed the tipAnimationFadeSpeed to set
     */
    public void setTipAnimationFadeSpeed(int tipAnimationFadeSpeed) {
        this.tipAnimationFadeSpeed = tipAnimationFadeSpeed;
    }

    /**
     * @return the cookieMonster
     */
    public boolean isCookieMonster() {
        return cookieMonster;
    }

    /**
     * @param cookieMonster the cookieMonster to set
     */
    public void setCookieMonster(boolean cookieMonster) {
        this.cookieMonster = cookieMonster;
    }

    /**
     * @return the cookieName
     */
    public String getCookieName() {
        return cookieName;
    }

    /**
     * @param cookieName the cookieName to set
     */
    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    /**
     * @return the cookieDomain
     */
    public boolean isCookieDomain() {
        return cookieDomain;
    }

    /**
     * @param cookieDomain the cookieDomain to set
     */
    public void setCookieDomain(boolean cookieDomain) {
        this.cookieDomain = cookieDomain;
    }

    /**
     * @return the cookieExpires
     */
    public int getCookieExpires() {
        return cookieExpires;
    }

    /**
     * @param cookieExpires the cookieExpires to set
     */
    public void setCookieExpires(int cookieExpires) {
        this.cookieExpires = cookieExpires;
    }

    /**
     * @return the tipContainer
     */
    public String getTipContainer() {
        return tipContainer;
    }

    /**
     * @param tipContainer the tipContainer to set
     */
    public void setTipContainer(String tipContainer) {
        this.tipContainer = tipContainer;
    }
}
