package com.selenium.nosalty.util;

import static org.assertj.core.api.Assertions.assertThat;
import com.selenium.nosalty.logger.Logger;
import org.openqa.selenium.WebElement;

public final class WebElementAssertions {
    private static final Logger LOGGER = new Logger(WebElementAssertions.class);

    private WebElementAssertions() {
    }

    public static void elementHasText(WebElement element,String expectedString) {
        LOGGER.debug("Validating if the element has the text:  " + expectedString);
        assertThat(element.getText().trim())
                .isEqualTo(expectedString);
    }

    public static void elementIsDisabled(WebElement element) {
        LOGGER.debug("Checking if element is disabled");
        assertThat(element.isEnabled()).isFalse();
    }
}
