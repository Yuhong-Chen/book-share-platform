package impl.GUI;

import com.jfoenix.controls.base.IFXLabelFloatControl;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.scene.Node;

class Helpers {

    /**
     * Turns any given JFX Node into one which is required before form submission.
     * The generic is constructed to ensure that only nodes which are capable of validation
     * can be used as a parameter.
     *
     * @param parentNode the node which is required
     * @param message the error message to show on the omission of a value for the {@param parentNode}
     * */
    static <N extends Node & IFXLabelFloatControl> void makeNodeRequired(N parentNode, String message) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage(message);

        parentNode.getValidators().add(validator);
        parentNode.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) parentNode.validate();
        });
    }

}
