package client.GUI;

import com.jfoenix.controls.base.IFXLabelFloatControl;
import com.jfoenix.controls.base.IFXValidatableControl;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.scene.Node;
import javafx.scene.control.TextField;

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

    static <N extends TextField & IFXValidatableControl>
        void ensureIdenticalValues(N initialNode, N reentryNode, String message) {
        RequiredFieldValidator validator = new RequiredFieldValidator();
        validator.setMessage(message);

        reentryNode.getValidators().add(validator);

        initialNode.focusedProperty().addListener((o, oldValue, newValue) -> {
            if (reentryNode.getText().equals(initialNode.getText()))
                reentryNode.validate();
        });
        reentryNode.focusedProperty().addListener((o, oldValue, newValue) -> {

            if (reentryNode.getText().equals(initialNode.getText()))
                reentryNode.validate();
        });
    }
}
