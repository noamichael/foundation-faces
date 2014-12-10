package org.foundationfaces.component.joyride;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import org.foundationfaces.component.Foundation;

/**
 *
 * @author Michael
 */
@FacesComponent(JoyrideStop.MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class JoyrideStop extends UIOutput {

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".JoyrideStop";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".JoyrideStopRenderer";

    /**
     * @return the expose
     */
    public boolean isExpose() {
        return (boolean) getStateHelper().get(OptionPropertyKeys.expose);
    }

    /**
     * @param expose the expose to set
     */
    public void setExpose(boolean expose) {
        getStateHelper().put(OptionPropertyKeys.expose, expose);
    }

    /**
     * @return the modal
     */
    public boolean isModal() {
        return (boolean) getStateHelper().get(OptionPropertyKeys.modal);
    }

    /**
     * @param modal the modal to set
     */
    public void setModal(boolean modal) {
        getStateHelper().put(OptionPropertyKeys.modal, modal);
    }

    /**
     * @return the keyboard
     */
    public boolean isKeyboard() {
        return (boolean) getStateHelper().get(OptionPropertyKeys.keyboard);
    }

    /**
     * @param keyboard the keyboard to set
     */
    public void setKeyboard(boolean keyboard) {
        getStateHelper().put(OptionPropertyKeys.keyboard, keyboard);
    }

    /**
     * @return the tipLocation
     */
    public String getTipLocation() {
        return (String) getStateHelper().get(OptionPropertyKeys.tipLocation);
    }

    /**
     * @param tipLocation the tipLocation to set
     */
    public void setTipLocation(String tipLocation) {
        getStateHelper().put(OptionPropertyKeys.tipLocation, tipLocation);
    }

    /**
     * @return the nubPosition
     */
    public String getNubPosition() {
        return (String) getStateHelper().get(OptionPropertyKeys.nubPosition);
    }

    /**
     * @param nubPosition the nubPosition to set
     */
    public void setNubPosition(String nubPosition) {
        getStateHelper().put(OptionPropertyKeys.nubPosition, nubPosition);
    }

    /**
     * @return the scrollSpeed
     */
    public int getScrollSpeed() {
        return (int) getStateHelper().get(OptionPropertyKeys.scrollSpeed);
    }

    /**
     * @param scrollSpeed the scrollSpeed to set
     */
    public void setScrollSpeed(int scrollSpeed) {
        getStateHelper().put(OptionPropertyKeys.scrollSpeed, scrollSpeed);
    }

    /**
     * @return the scrollAnimation
     */
    public String getScrollAnimation() {
        return (String) getStateHelper().get(OptionPropertyKeys.scrollAnimation);
    }

    /**
     * @param scrollAnimation the scrollAnimation to set
     */
    public void setScrollAnimation(String scrollAnimation) {
        getStateHelper().put(OptionPropertyKeys.scrollAnimation, scrollAnimation);
    }

    /**
     * @return the timer
     */
    public int getTimer() {
        return (int) getStateHelper().get(OptionPropertyKeys.timer);
    }

    /**
     * @param timer the timer to set
     */
    public void setTimer(int timer) {
        getStateHelper().put(OptionPropertyKeys.timer, timer);
    }

    /**
     * @return the startTimerOnClick
     */
    public boolean isStartTimerOnClick() {
        return (boolean) getStateHelper().get(OptionPropertyKeys.startTimerOnClick);
    }

    /**
     * @param startTimerOnClick the startTimerOnClick to set
     */
    public void setStartTimerOnClick(boolean startTimerOnClick) {
        getStateHelper().put(OptionPropertyKeys.startTimerOnClick, startTimerOnClick);
    }

    /**
     * @return the startOffset
     */
    public int getStartOffset() {
        return (int) getStateHelper().get(OptionPropertyKeys.startOffset);
    }

    /**
     * @param startOffset the startOffset to set
     */
    public void setStartOffset(int startOffset) {
        getStateHelper().put(OptionPropertyKeys.startOffset, startOffset);
    }

    /**
     * @return the nextButton
     */
    public boolean isNextButton() {
        return (boolean) getStateHelper().get(OptionPropertyKeys.nextButton);
    }

    /**
     * @param nextButton the nextButton to set
     */
    public void setNextButton(boolean nextButton) {
        getStateHelper().put(OptionPropertyKeys.nextButton, nextButton);
    }

    /**
     * @return the prevButton
     */
    public boolean isPrevButton() {
        return (boolean) getStateHelper().get(OptionPropertyKeys.prevButton);
    }

    /**
     * @param prevButton the prevButton to set
     */
    public void setPrevButton(boolean prevButton) {
        getStateHelper().put(OptionPropertyKeys.prevButton, prevButton);
    }

    /**
     * @return the tipAnimation
     */
    public String getTipAnimation() {
        return (String) getStateHelper().get(OptionPropertyKeys.tipAnimation);
    }

    /**
     * @param tipAnimation the tipAnimation to set
     */
    public void setTipAnimation(String tipAnimation) {
        getStateHelper().put(OptionPropertyKeys.tipAnimation, tipAnimation);
    }

    /**
     * @return the tipAnimationFadeSpeed
     */
    public int getTipAnimationFadeSpeed() {
        return (int) getStateHelper().get(OptionPropertyKeys.tipAnimationFadeSpeed);
    }

    /**
     * @param tipAnimationFadeSpeed the tipAnimationFadeSpeed to set
     */
    public void setTipAnimationFadeSpeed(int tipAnimationFadeSpeed) {
        getStateHelper().put(OptionPropertyKeys.tipAnimationFadeSpeed, tipAnimationFadeSpeed);
    }

    /**
     * @return the cookieMonster
     */
    public boolean isCookieMonster() {
        return (boolean) getStateHelper().get(OptionPropertyKeys.cookieMonster);
    }

    /**
     * @param cookieMonster the cookieMonster to set
     */
    public void setCookieMonster(boolean cookieMonster) {
        getStateHelper().put(OptionPropertyKeys.cookieMonster, cookieMonster);
    }

    /**
     * @return the cookieName
     */
    public String getCookieName() {
        return (String) getStateHelper().get(OptionPropertyKeys.cookieName);
    }

    /**
     * @param cookieName the cookieName to set
     */
    public void setCookieName(String cookieName) {
        getStateHelper().put(OptionPropertyKeys.cookieName, cookieName);
    }

    /**
     * @return the cookieDomain
     */
    public boolean isCookieDomain() {
        return (boolean) getStateHelper().get(OptionPropertyKeys.cookieDomain);
    }

    /**
     * @param cookieDomain the cookieDomain to set
     */
    public void setCookieDomain(boolean cookieDomain) {
        getStateHelper().put(OptionPropertyKeys.cookieDomain, cookieDomain);
    }

    /**
     * @return the cookieExpires
     */
    public int getCookieExpires() {
        return (int) getStateHelper().get(OptionPropertyKeys.cookieExpires);
    }

    /**
     * @param cookieExpires the cookieExpires to set
     */
    public void setCookieExpires(int cookieExpires) {
        getStateHelper().put(OptionPropertyKeys.cookieExpires, cookieExpires);
    }

    /**
     * @return the tipContainer
     */
    public String getTipContainer() {
        return (String) getStateHelper().get(OptionPropertyKeys.tipContainer);
    }

    /**
     * @param tipContainer the tipContainer to set
     */
    public void setTipContainer(String tipContainer) {
        getStateHelper().put(OptionPropertyKeys.tipContainer, tipContainer);
    }

    /**
     * @return the dataId
     */
    public String getDataId() {
        return (String) getStateHelper().get(PropertyKeys.dataId);
    }

    /**
     * @param dataId the dataId to set
     */
    public void setDataId(String dataId) {
        getStateHelper().put(PropertyKeys.dataId, dataId);
    }

    /**
     * @return the dataButton
     */
    public String getDataButton() {
        return (String) getStateHelper().get(PropertyKeys.dataButton);
    }

    /**
     * @param dataButton the dataButton to set
     */
    public void setDataButton(String dataButton) {
        getStateHelper().put(PropertyKeys.dataButton, dataButton);
    }

    /**
     * @return the dataPrevText
     */
    public String getDataPrevText() {
        return (String) getStateHelper().get(PropertyKeys.dataPrevText);
    }

    /**
     * @param dataPrevText the dataPrevText to set
     */
    public void setDataPrevText(String dataPrevText) {
        getStateHelper().put(PropertyKeys.dataPrevText, dataPrevText);
    }

    /**
     * @return the dataClass
     */
    public String getDataClass() {
        return (String) getStateHelper().get(PropertyKeys.dataClass);
    }

    /**
     * @param dataClass the dataClass to set
     */
    public void setDataClass(String dataClass) {
        getStateHelper().put(PropertyKeys.dataClass, dataClass);
    }

    /**
     * @return the dataClass
     */
    public String getDataText() {
        return (String) getStateHelper().get(PropertyKeys.dataText);
    }

    /**
     * @param dataText
     */
    public void setDataText(String dataText) {
        getStateHelper().put(PropertyKeys.dataText, dataText);
    }

    public String buildDataOptionString() {
        String options = "";
        for (OptionPropertyKeys key : OptionPropertyKeys.values()) {
            Object value = getStateHelper().get(key);
            if (value != null) {
                options += key.toString + ":" + value.toString() + ";";
            }
        }

        return options;
    }

    protected enum PropertyKeys {

        dataId,
        dataButton,
        dataPrevText,
        dataText,
        dataClass;
    }

    protected enum OptionPropertyKeys {

        expose("expose"),
        modal("modal"),
        keyboard("keyboard"),
        tipLocation("tip_location"),
        nubPosition("nub_position"),
        scrollSpeed("scroll_speed"),
        scrollAnimation("scroll_animation"),
        timer("timer"),
        startTimerOnClick("start_timer_on_click"),
        startOffset("start_offset"),
        nextButton("next_button"),
        prevButton("prev_button"),
        tipAnimation("tip_animation"),
        tipAnimationFadeSpeed("tip_animation_fade_speed"),
        cookieMonster("cookie_monster"),
        cookieName("cookie_name"),
        cookieDomain("cookie_domain"),
        cookieExpires("cookie_expires"),
        tipContainer("tip_container");

        private final String toString;

        private OptionPropertyKeys(String toString) {
            this.toString = toString;
        }

        @Override
        public String toString() {
            return toString;
        }

    }
}
