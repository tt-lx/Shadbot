package com.shadorc.shadbot.command.utils;

import com.shadorc.shadbot.api.json.wikipedia.WikipediaPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WikipediaCmdTest {

    private static Logger logger;
    private static WikiCmd cmd;
    private static Method method;

    @BeforeAll
    public static void init() throws NoSuchMethodException {
        logger = Loggers.getLogger(WikipediaCmdTest.class);
        cmd = new WikiCmd();

        method = WikiCmd.class.getDeclaredMethod("getWikipediaPage", String.class);
        method.setAccessible(true);
    }

    @Test
    public void testGetWikipediaPage() throws InvocationTargetException, IllegalAccessException {
        final WikipediaPage result = ((Mono<WikipediaPage>) method.invoke(cmd, "21 guns")).block();
        logger.info("testGetWikipediaPage: {}", result);
        assertNotNull(result.getExtract());
        assertNotNull(result.getTitle());
    }

    @Test
    public void testGetWikipediaPageNotFound() throws InvocationTargetException, IllegalAccessException {
        final WikipediaPage result = ((Mono<WikipediaPage>) method.invoke(cmd, "ThisShouldNotBeFound&é'(-è_çà)='")).block();
        logger.info("testGetWikipediaPageNotFound: {}", result);
        assertNull(result);
    }

}
