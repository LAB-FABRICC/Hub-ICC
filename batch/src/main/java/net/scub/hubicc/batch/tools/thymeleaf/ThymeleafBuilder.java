package net.scub.hubicc.batch.tools.thymeleaf;

import net.scub.hubicc.batch.model.HtmlItem;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Component
public class ThymeleafBuilder {

    private final TemplateEngine templateEngine;

    public ThymeleafBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * Build template.
     *
     * @param aboutUrlId aboutUrlId
     * @param htmlItems  htmlItems
     * @return template
     */
    public String buildTemplate(final String aboutUrlId, final List<HtmlItem> htmlItems) {
        final var context = new Context();
        context.setVariable("aboutUrlId", aboutUrlId);
        context.setVariable("htmlItems", htmlItems);

        return templateEngine.process("RDFItem", context);
    }
}
