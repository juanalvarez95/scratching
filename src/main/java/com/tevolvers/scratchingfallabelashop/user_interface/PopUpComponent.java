package com.tevolvers.scratchingfallabelashop.user_interface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PopUpComponent {

    public static final Target ANNOUNCEMENT_CLOSE = Target.the("Equis for close announcement")
            .located(By.id("lightbox-close"));
}
