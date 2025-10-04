package com.crypto.backend.AiChatBot;



import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.context.annotation.Configuration;
import org.commonmark.renderer.html.HtmlRenderer;
import java.util.List;
import org.commonmark.parser.Parser;

@Deprecated
@Configuration
public class ParseAndRender {

    public String  processInput(String response){


      Parser parser=Parser.builder().build();

      HtmlRenderer renderer=HtmlRenderer.builder().extensions(List.of(TablesExtension.create())).build();

      Node root=parser.parse(response);

      String render=renderer.render(root);

      return Jsoup.clean(render, Safelist.relaxed());


    }

}
