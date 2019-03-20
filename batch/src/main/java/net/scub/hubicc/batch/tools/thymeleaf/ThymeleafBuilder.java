package net.scub.hubicc.batch.tools.thymeleaf;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Component
public class ThymeleafBuilder {

    private final TemplateEngine templateEngine;

    /**
     * Constructor.
     *
     * @param templateEngine templateEngine
     */
    public ThymeleafBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }


    /**
     * Build template.
     *
     * @param templatePath templatePath
     * @param params       params
     * @return template
     */
    public String buildTemplateWithParams(final String templatePath, final Map<String, Object> params) {
        final Context context = new Context();
        context.setVariables(params);

        return templateEngine.process(templatePath, context);
    }
}
