package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class TestWebClient {

    private WebClient webClient = new WebClient();

    @BeforeAll
    public static void beforeAll() throws Exception {
        Server server = new Server(8081);
        Context context = new Context(server, "/testGetContentOk");
        context.setHandler(new TestGetContentOkHandler());
        server.setStopAtShutdown(true);
        server.start();
    }

    @AfterAll
    public static void afterAll() {
    }

    @Test
    void testGetContentOk() throws MalformedURLException {
        WebClient client = new WebClient();
        String workingContent = client.getContent(new URL("http://localhost:8081/testGetContentOk"));
        assertThat(workingContent).isEqualTo("It works");
    }

    // 스텁
    private static class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String s, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, int i) throws IOException, ServletException {
            ServletOutputStream out = httpServletResponse.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            httpServletResponse.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }
}
