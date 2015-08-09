package com.tmjee.linearisation.processor;

import joptsimple.HelpFormatter;
import joptsimple.OptionDescriptor;

import java.util.Map;

/**
 * @author tmjee
 */
public class ArgumentsHelpFormatter implements HelpFormatter {

    @Override
    public String format(Map<String, ? extends OptionDescriptor> map) {

        StringBuilder sb = new StringBuilder();

        sb.append("Usage: java -jar linearisability.jar [options]");
        sb.append("\n");
        sb.append(" [opt] means optional argument.\n");
        sb.append(" <opt> means required argument.");

        for (OptionDescriptor optionDesriptor : map.values()) {
            lineFor(sb, optionDesriptor);
        }

        return sb.toString();
    }


    private void lineFor(StringBuilder sb, OptionDescriptor optionDescriptor) {
        optionDescriptor.options().forEach((option)-> {
            if (!optionDescriptor.representsNonOptions()) {
                sb.append("\n\t");
                sb.append("-");
                sb.append(option);
                if (optionDescriptor.acceptsArguments()) {
                    if (optionDescriptor.requiresArgument()) {
                        sb.append(" <");
                    } else {
                        sb.append(" [");
                    }
                    sb.append(optionDescriptor.argumentDescription());
                    if (optionDescriptor.requiresArgument()) {
                        sb.append(">");
                    } else {
                        sb.append("]");
                    }
                }
                sb.append(" ");
                sb.append(optionDescriptor.description());
                sb.append(" ");
            }
        });
    }
}
