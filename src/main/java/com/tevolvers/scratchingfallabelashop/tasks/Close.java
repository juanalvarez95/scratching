package com.tevolvers.scratchingfallabelashop.tasks;

import com.tevolvers.scratchingfallabelashop.user_interface.PopUpComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class Close implements Task {
    @Step("{0} closes all popups")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PopUpComponent.ANNOUNCEMENT_CLOSE));
    }

    public static Close popup(){
        return Tasks.instrumented(Close.class);
    }
}
